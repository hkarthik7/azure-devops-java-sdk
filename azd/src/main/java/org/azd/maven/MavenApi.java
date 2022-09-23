package org.azd.maven;

import org.azd.common.ApiVersion;
import org.azd.connection.Connection;
import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.helpers.StreamHelper;
import org.azd.interfaces.MavenDetails;
import org.azd.maven.types.MavenPackageVersionDeletionState;
import org.azd.maven.types.Package;
import org.azd.maven.types.UpstreamingBehavior;
import org.azd.utils.AzDAsyncApi;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.azd.utils.RestClient.send;

/***
 * MavenApi class to manage maven artifact package api
 */
public class MavenApi extends AzDAsyncApi<MavenApi> implements MavenDetails {
    /***
     * Connection object
     */
    private final Connection CONNECTION;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "packaging";
    private final String MAVEN = "6f7f8c07-ff36-473c-bcf3-bd6cc9b6c066";
    private final String PACKAGES_RELATIVE_PATH = "_packaging";

    /***
     * Pass the connection object to work with Maven Package Api
     *
     * @param connection Connection object
     */
    public MavenApi(Connection connection) {
        this.CONNECTION = connection;
    }

    /***
     * Get information about a package version.
     *
     * @param feedId     Name or ID of the feed. Example: "mavenfeed".
     * @param groupId    Group ID of the package. Example: "com.example".
     * @param artifactId Artifact ID of the package. Example: "app".
     * @param version    Version of the package. Example: "1.0.0".
     * @return Package {@link Package}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Package getPackageVersion(String feedId, String groupId, String artifactId, String version)
            throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, MAVEN, CONNECTION.getProject(),
                AREA + "/feeds", feedId,
                "maven/groups/" + groupId + "/artifacts/" + artifactId + "/versions/" + version,
                ApiVersion.MAVEN, null, null, null);

        return MAPPER.mapJsonResponse(r, Package.class);
    }

    /***
     * Get information about a package version.
     *
     * @param feedId      Name or ID of the feed. Example: "mavenfeed".
     * @param groupId     Group ID of the package. Example: "com.example".
     * @param artifactId  Artifact ID of the package. Example: "app".
     * @param version     Version of the package. Example: "1.0.0".
     * @param showDeleted True to show information for deleted versions
     * @return Package {@link Package}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Package getPackageVersion(String feedId, String groupId, String artifactId, String version,
                                     boolean showDeleted) throws AzDException {
        HashMap<String, Object> q = new HashMap<>() {
            {
                put("showDeleted", showDeleted);
            }
        };
        String r = send(RequestMethod.GET, CONNECTION, MAVEN, CONNECTION.getProject(),
                AREA + "/feeds", feedId,
                "maven/groups/" + groupId + "/artifacts/" + artifactId + "/versions/" + version,
                ApiVersion.MAVEN, q, null, null);

        return MAPPER.mapJsonResponse(r, Package.class);
    }

    /***
     * Get information about a package version in the recycle bin.
     *
     * @param feedId     Name or ID of the feed. Example: "mavenfeed".
     * @param groupId    Group ID of the package. Example: "com.example".
     * @param artifactId Artifact ID of the package. Example: "app".
     * @param version    Version of the package. Example: "1.0.0".
     * @return MavenPackageVersionDeletionState
     *         {@link MavenPackageVersionDeletionState}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public MavenPackageVersionDeletionState getPackageVersionFromRecycleBin(String feedId, String groupId,
                                                                            String artifactId, String version) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, MAVEN, CONNECTION.getProject(),
                AREA + "/feeds", feedId,
                "maven/RecycleBin/groups/" + groupId + "/artifacts/" + artifactId + "/versions/" + version,
                ApiVersion.MAVEN, null, null, null);

        return MAPPER.mapJsonResponse(r, MavenPackageVersionDeletionState.class);
    }

    /***
     * Get the upstreaming behavior of a package within the context of a feed
     *
     * @param feedId     Name or ID of the feed. Example: "mavenfeed".
     * @param groupId    Group ID of the package. Example: "com.example".
     * @param artifactId Artifact ID of the package. Example: "app".
     * @return UpstreamingBehavior
     *         {@link UpstreamingBehavior}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public UpstreamingBehavior getUpstreamingBehavior(String feedId, String groupId, String artifactId)
            throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, MAVEN, CONNECTION.getProject(),
                AREA + "/feeds", feedId, "maven/groups/" + groupId + "/artifacts/" + artifactId + "/upstreaming",
                ApiVersion.MAVEN, null, null, null);
        return MAPPER.mapJsonResponse(r, UpstreamingBehavior.class);
    }

    /***
     * Fulfills Maven package file download requests by either returning the URL
     of
     * the requested package file or, in the case of Azure DevOps Server (OnPrem),
     *
     * @param feedId Name or ID of the feed. Example: "mavenfeed".
     * @param groupId Group ID of the package. Example: "com.example".
     * @param artifactId Artifact ID of the package. Example: "app".
     * @param version Version of the package. Example: "1.0.0".
     * @param fileName File name to download. Example: "app-1.0.0.jar".
     * @return Package content.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public InputStream downloadPackage(String feedId, String groupId, String artifactId, String version, String fileName) throws AzDException {
        var callbackUri = send(null, RequestMethod.GET, CONNECTION, MAVEN, CONNECTION.getProject(),
                AREA + "/feeds", feedId,
                "maven/" + groupId + "/" + artifactId + "/" + version + "/" + fileName + "/content",
                ApiVersion.MAVEN, null, null, null, true)
                .thenApplyAsync(HttpResponse::uri)
                .thenApplyAsync(URI::toString)
                .join();

        int statusCode = send(callbackUri, RequestMethod.GET, null, null, null,
                null, null, null, null, null, null, null, true)
                .thenApplyAsync(HttpResponse::statusCode)
                .join();

        var res = send(callbackUri, RequestMethod.GET, null, null, null,
                null, null, null, null, null, null, null, true)
                .thenApplyAsync(HttpResponse::body)
                .join();         
                
        if(statusCode != 200)
            MAPPER.mapJsonResponse(StreamHelper.convertToString(res), Map.class);

        return res;
    }

    /***
     * Delete a package version from the feed and move it to the feed's recycle bin.
     *
     * @param feedId     Name or ID of the feed. Example: "mavenfeed".
     * @param groupId    Group ID of the package. Example: "com.example".
     * @param artifactId Artifact ID of the package. Example: "app".
     * @param version    Version of the package. Example: "1.0.0".
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public void deletePackageVersion(String feedId, String groupId, String artifactId, String version)
            throws AzDException {
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, MAVEN, CONNECTION.getProject(),
                    AREA + "/feeds", feedId,
                    "maven/groups/" + groupId + "/artifacts/" + artifactId + "/versions/" + version,
                    ApiVersion.MAVEN, null, null, null);
            if (!r.isEmpty())
                MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }

    }

    /***
     * Permanently delete a package from a feed's recycle bin.
     *
     * @param feedId     Name or ID of the feed. Example: "mavenfeed".
     * @param groupId    Group ID of the package. Example: "com.example".
     * @param artifactId Artifact ID of the package. Example: "app".
     * @param version    Version of the package. Example: "1.0.0".
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public void deletePackageVersionFromRecycleBin(String feedId, String groupId, String artifactId, String version)
            throws AzDException {
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, MAVEN, CONNECTION.getProject(),
                    AREA + "/feeds", feedId,
                    "maven/RecycleBin/groups/" + groupId + "/artifacts/" + artifactId + "/versions/" + version,
                    ApiVersion.MAVEN, null, null, null);
            if (!r.isEmpty())
                MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
    }

    /***
     * Set mutable state on a package version.(eg. prelease, release)
     *
     * @param feedId     Name or ID of the feed. Example: "mavenfeed".
     * @param groupId    Group ID of the package. Example: "com.example".
     * @param artifactId Artifact ID of the package. Example: "app".
     * @param version    Version of the package. Example: "1.0.0".
     * @param promote    State of the package. Example: "prelease".
     *                   {@link PackagePromote}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public void updatePackageVersion(String feedId, String groupId, String artifactId, String version, PackagePromote promote)
            throws AzDException {
        updatePackageVersion(feedId, groupId, artifactId, version, promote.toString().toLowerCase());
    }

    /***
     * Set mutable state on a package version.(eg. prelease, release)
     *
     * @param feedId     Name or ID of the feed. Example: "mavenfeed".
     * @param groupId    Group ID of the package. Example: "com.example".
     * @param artifactId Artifact ID of the package. Example: "app".
     * @param version    Version of the package. Example: "1.0.0".
     * @param promote    State of the package. Example: "prelease".
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public void updatePackageVersion(String feedId, String groupId, String artifactId, String version, String promote)
            throws AzDException {

        var req = new HashMap<String, Object>() {{
            put("op", PackageOperation.ADD.toString());
            put("path", "/views/-");
            put("value", promote); // "promote package type"
        }};

        var body = new HashMap<String, Object>() {{ put("views", req); }};

        try {
            String r = send(RequestMethod.PATCH, CONNECTION, MAVEN, CONNECTION.getProject(),
                    AREA + "/feeds", feedId,
                    "maven/groups/" + groupId + "/artifacts/" + artifactId + "/versions/" + version, ApiVersion.MAVEN,
                    null,
                    body, CustomHeader.JSON_CONTENT_TYPE);
            if (!r.isEmpty())
                MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
    }

    /***
     * Update several packages from a single feed in a single request. The updates
     * to the packages do not happen atomically.
     *
     * @param feedId    Name or ID of the feed. Example: "mavenfeed".
     * @param viewId    Name of ID the view, packages need to be promoted to.
     * @param operation Type of operation that needs to be performed on packages.
     *                  supports only PROMOTE or DELETE.
     *                  {@link PackagesBatchOperation}.
     * @param packages  Identifies a particular Maven package versions
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public void updatePackageVersions(String feedId, String viewId, PackagesBatchOperation operation,
                                      List<Map<String, Object>> packages)
            throws AzDException {
        var req = new HashMap<String, Object>();
        try {
            if (operation == PackagesBatchOperation.PROMOTE) {
                req.put("data", Map.of("viewId", viewId));
            }
            req.put("operation", operation.toString().toLowerCase());

            List l = new ArrayList();
            for (var pkg : packages) {
                l.add(Map.of("group", pkg.get("group"), "artifact", pkg.get("artifact"), "version",
                        pkg.get("version")));
            }
            req.put("packages", l);

            String r = send(RequestMethod.POST, CONNECTION, MAVEN, CONNECTION.getProject(),
                    AREA + "/feeds", feedId, "maven/packagesbatch", ApiVersion.MAVEN, null, req, CustomHeader.JSON_CONTENT_TYPE);
            if (!r.isEmpty())
                MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
    }

    /***
     * Restore a package version from the recycle bin to its associated feed.
     *
     * @param feedId     Name or ID of the feed. Example: "mavenfeed".
     * @param groupId    Group ID of the package. Example: "com.example".
     * @param artifactId Artifact ID of the package. Example: "app".
     * @param version    Version of the package. Example: "1.0.0".
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public void restorePackageVersionFromRecycleBin(String feedId, String groupId, String artifactId, String version)
            throws AzDException {
        try {
            String r = send(RequestMethod.PATCH, CONNECTION, MAVEN, CONNECTION.getProject(),
                    AREA + "/feeds", feedId,
                    "maven/RecycleBin/groups/" + groupId + "/artifacts/" + artifactId + "/versions/" + version,
                    ApiVersion.MAVEN, null, Map.of("deleted", "false"), CustomHeader.JSON_CONTENT_TYPE);
            if (!r.isEmpty())
                MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
    }

    /***
     * Set the upstreaming behavior of a (scoped) package.
     *
     * @param feedId     Name or ID of the feed. Example: "mavenfeed".
     * @param groupId    Group ID of the package. Example: "com.example".
     * @param artifactId Artifact ID of the package. Example: "app".
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public void setUpstreamingBehavior(String feedId, String groupId, String artifactId)
            throws AzDException {
        setUpstreamingBehavior(feedId, groupId, artifactId, "allowExternalVersions");
    }

    /***
     * Set the upstreaming behavior of a (scoped) package.
     *
     * @param feedId     Name or ID of the feed. Example: "mavenfeed".
     * @param groupId    Group ID of the package. Example: "com.example".
     * @param artifactId Artifact ID of the package. Example: "app".
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public void setUpstreamingBehavior(String feedId, String groupId, String artifactId, String upstreamingBehavior)
            throws AzDException {

        var req = new HashMap<String, Object>();
        try {
            req.put("versionsFromExternalUpstreams", upstreamingBehavior);

            String r = send(RequestMethod.PATCH, CONNECTION, MAVEN, CONNECTION.getProject(),
                    AREA + "/feeds", feedId,
                    "maven/groups/" + groupId + "/artifacts/" + artifactId + "/upstreaming",
                    ApiVersion.MAVEN, null, req, CustomHeader.JSON_CONTENT_TYPE);
            if (!r.isEmpty())
                MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
    }

    /***
     * To clear the upstream behavior of a (scoped) package.
     *
     * @param feedId     Name or ID of the feed. Example: "mavenfeed".
     * @param groupId    Group ID of the package. Example: "com.example".
     * @param artifactId Artifact ID of the package. Example: "app".
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public void clearUpstreamingBehavior(String feedId, String groupId, String artifactId) throws AzDException {
        var req = new HashMap<String, Object>();
        try {
            req.put("versionsFromExternalUpstreams", "auto");

            String r = send(RequestMethod.PATCH, CONNECTION, MAVEN, CONNECTION.getProject(),
                    AREA + "/feeds", feedId,
                    "maven/groups/" + groupId + "/artifacts/" + artifactId + "/upstreaming",
                    ApiVersion.MAVEN, null, req, CustomHeader.JSON_CONTENT_TYPE);
            if (!r.isEmpty())
                MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
    }

    /***
     * Delete or restore several package versions from the recycle bin.
     *
     * @param feedId                 Name or ID of the feed. Example: "mavenfeed".
     * @param operation Type of operation that needs to be performed on
     *                               packages. Recycle Bin supports only
     *                               PERMANENTDELETE or
     *                               RESTORETOFEED. {@link PackagesBatchOperation}
     * @param packages               Identifies a particular Maven package versions
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public void updateRecycleBinPackages(String feedId, PackagesBatchOperation operation,
                                         List<Map<String, Object>> packages)
            throws AzDException {
        var req = new HashMap<String, Object>();
        try {
            req.put("data", null);
            req.put("operation", operation.toString().toLowerCase());

            List l = new ArrayList<Map>();
            for (var pkg : packages) {
                l.add(Map.of("group", pkg.get("group"), "artifact", pkg.get("artifact"), "version",
                        pkg.get("version")));
            }
            req.put("packages", l);

            String r = send(RequestMethod.POST, CONNECTION, MAVEN, CONNECTION.getProject(),
                    AREA + "/feeds", feedId, "maven/RecycleBin/packagesbatch", ApiVersion.MAVEN, null, req, CustomHeader.JSON_CONTENT_TYPE);
            if (!r.isEmpty())
                MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
    }

    /***
     * Fulfills Maven package file upload requests by either returning the URL
     of
     * the requested package file or, in the case of Azure DevOps Server (OnPrem),
     *
     * @param feedId Name or ID of the feed. Example: "mavenfeed".
     * @param groupId Group ID of the package. Example: "com.example".
     * @param artifactId Artifact ID of the package. Example: "app".
     * @param version Version of the package. Example: "1.0.0".
     * @param fileName File name to upoad. Must include artifactId Example: "app-1.0.0.jar".
     * @param content Inputstream for the package file.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public void uploadPackage(String feedId, String groupId, String artifactId, String version, String fileName, InputStream content)
            throws AzDException {
        try {
            String pathSeparator = "/";

            String baseInstance = Instance.BASE_INSTANCE.setSubdomain("pkgs"); // This returns https://pkgs.dev.azure.com
            StringBuilder stringBuilder = new StringBuilder(baseInstance);
            
            stringBuilder.append(CONNECTION.getOrganization());
            if (CONNECTION.getProject() != null) {
                stringBuilder.append(pathSeparator).append(CONNECTION.getProject());
            }

            stringBuilder.append(pathSeparator + PACKAGES_RELATIVE_PATH);

            if (feedId != null) {
                stringBuilder.append(pathSeparator).append(feedId);
            }
            
            String area="maven" + pathSeparator + "v1";
            stringBuilder.append(pathSeparator).append(area);

            String resource=groupId + pathSeparator + artifactId + pathSeparator + version+ pathSeparator + fileName; 
            if (resource != null) {
                stringBuilder.append(pathSeparator).append(resource);
            }
            
            String requestUrl=stringBuilder.toString();

            var t = send(requestUrl, RequestMethod.PUT, CONNECTION, null, null,
                            null, null, null, ApiVersion.MAVEN,null, HttpRequest.BodyPublishers.ofInputStream(() -> content),
                            HttpResponse.BodyHandlers.ofString(), null, false);

            String r= t.thenApplyAsync(HttpResponse::body).join();
            if(!r.isEmpty()) // if the response is not empty, then the upload was not successful
                MAPPER.mapJsonResponse(r, Map.class);      
        } catch(AzDException e){
            throw e;
        }
    }
}
