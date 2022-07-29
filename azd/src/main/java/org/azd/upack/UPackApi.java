package org.azd.upack;

import org.azd.common.ApiVersion;
import org.azd.connection.Connection;
import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.UpackDetails;
import org.azd.upack.types.Package;
import org.azd.upack.types.UPackPackageVersionDeletionState;
import org.azd.utils.AzDAsyncApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.azd.utils.RestClient.send;

/***
 * UpackApi class to manage Universal Package artifact package api
 */
public class UPackApi extends AzDAsyncApi<UPackApi> implements UpackDetails {
    /***
     * Connection object
     */
    private final Connection CONNECTION;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "packaging";
    private final String UPACK = "d397749b-f115-4027-b6dd-77a65dd10d21";

    /***
     * Pass the connection object to work with Universal Package Api
     *
     * @param connection Connection object
     */
    public UPackApi(Connection connection) {
        this.CONNECTION = connection;
    }

    /***
     * Show information about a package version.
     *
     * @param feedId      Name or ID of the feed. Example: "ufeed".
     * @param packageName Name of the package. Example: "upackage".
     * @param version     Version of the package. Example: "1.0.0".
     * @return Package {@link Package}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Package getPackageVersion(String feedId, String packageName, String version) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, UPACK, CONNECTION.getProject(), AREA + "/feeds", feedId,
                "upack/packages/" + packageName + "/versions/" + version, ApiVersion.UPACK, null, null, null);

        return MAPPER.mapJsonResponse(r, Package.class);
    }

    /***
     * Show information about a package version.
     *
     * @param feedId      Name or ID of the feed. Example: "ufeed".
     * @param packageName Name of the package. Example: "upackage".
     * @param version     Version of the package. Example: "1.0.0".
     * @param showDeleted True to show information for deleted versions
     * @return Package {@link Package}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Package getPackageVersion(String feedId, String packageName, String version, boolean showDeleted)
            throws AzDException {
        HashMap<String, Object> q = new HashMap<>() {
            {
                put("showDeleted", showDeleted);
            }
        };
        String r = send(RequestMethod.GET, CONNECTION, UPACK, CONNECTION.getProject(), AREA + "/feeds", feedId,
                "upack/packages/" + packageName + "/versions/" + version, ApiVersion.UPACK, q, null, null);

        return MAPPER.mapJsonResponse(r, Package.class);
    }

    /***
     * Get information about a package version in the recycle bin.
     *
     * @param feedId      Name or ID of the feed. Example: "ufeed".
     * @param packageName Name of the package. Example: "upackage".
     * @param version     Version of the package. Example: "1.0.0".
     * @return UPackPackageVersionDeletionState
     *         {@link UPackPackageVersionDeletionState}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public UPackPackageVersionDeletionState getPackageVersionFromRecycleBin(String feedId, String packageName,
                                                                            String version) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, UPACK, CONNECTION.getProject(), AREA + "/feeds", feedId,
                "upack/RecycleBin/packages/" + packageName + "/versions/" + version, ApiVersion.UPACK, null, null, null);

        return MAPPER.mapJsonResponse(r, UPackPackageVersionDeletionState.class);
    }


    /***
     * Delete a package version from the feed and move it to the feed's recycle
     * bin.
     *
     * @param feedId      Name or ID of the feed. Example: "ufeed".
     * @param packageName Name of the package. Example: "upackage".
     * @param version     Version of the package. Example: "1.0.0".
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public void deletePackageVersion(String feedId, String packageName, String version) throws AzDException {
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, UPACK, CONNECTION.getProject(), AREA + "/feeds", feedId,
                    "upack/packages/" + packageName + "/versions/" + version, ApiVersion.UPACK, null, null, null);
            if (!r.isEmpty())
                MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }

    }

    /***
     * Permanently delete a package from a feed's recycle bin.
     *
     * @param feedId      Name or ID of the feed. Example: "ufeed".
     * @param packageName Name of the package. Example: "upackage".
     * @param version     Version of the package. Example: "1.0.0".
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public void deletePackageVersionFromRecycleBin(String feedId, String packageName, String version)
            throws AzDException {
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, UPACK, CONNECTION.getProject(), AREA + "/feeds", feedId,
                    "upack/RecycleBin/packages/" + packageName + "/versions/" + version, ApiVersion.UPACK, null, null, null);
            if (!r.isEmpty())
                MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
    }

    /***
     * Update information for a package version. (eg. prelease, release)
     *
     * @param feedId      Name or ID of the feed. Example: "ufeed".
     * @param packageName Name of the package. Example: "upackage".
     * @param version     Version of the package. Example: "1.0.0"
     * @param promote     State of the package. Example: "prelease". {@link
     *                    PackagePromote}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public void updatePackageVersion(String feedId, String packageName, String version, PackagePromote promote)
            throws AzDException {
        updatePackageVersion(feedId, packageName, version, promote.toString().toLowerCase());
    }

    /***
     * Update information for a package version. (eg. prelease, release)
     *
     * @param feedId      Name or ID of the feed. Example: "ufeed".
     * @param packageName Name of the package. Example: "upackage".
     * @param version     Version of the package. Example: "1.0.0"
     * @param promote     State of the package. Example: "prelease".
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public void updatePackageVersion(String feedId, String packageName, String version, String promote)
            throws AzDException {

        var req = new HashMap<String, Object>(){{
            put("op", PackageOperation.ADD.toString());
            put("path", "/views/-");
            put("value", promote.toString()); // "prmote package type"
        }};

        var body = new HashMap<String, Object>(){{ put("views", req); }};

        try {
            String r = send(RequestMethod.PATCH, CONNECTION, UPACK, CONNECTION.getProject(), AREA + "/feeds", feedId,
                    "upack/packages/" + packageName + "/versions/" + version, ApiVersion.UPACK, null, body, CustomHeader.JSON_CONTENT_TYPE);
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
     * @param feedId    Name or ID of the feed. Example: "ufeed".
     * @param viewId    Name of ID the view, packages need to be promoted to.
     * @param operation Type of operation that needs to be performed on packages.
     *                  supports only PROMOTE or DELETE.
     *                  {@link PackagesBatchOperation}.
     * @param packages  Identifies a particular Universal package version.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public void updatePackageVersions(String feedId, String viewId, PackagesBatchOperation operation,
                                      List<Map<String, Object>> packages) throws AzDException {
        var req = new HashMap<String, Object>();
        try {
            if (operation == PackagesBatchOperation.PROMOTE) {
                req.put("data", Map.of("viewId", viewId));
            }
            req.put("operation", operation.toString().toLowerCase());

            List l = new ArrayList<Map>();
            for (var pkg : packages) {
                l.add(Map.of("id", pkg.get("id"), "version", pkg.get("version")));
            }
            req.put("packages", l);

            String r = send(RequestMethod.POST, CONNECTION, UPACK, CONNECTION.getProject(), AREA + "/feeds", feedId,
                    "upack/packagesbatch", ApiVersion.UPACK, null, req, CustomHeader.JSON_CONTENT_TYPE);
            if (!r.isEmpty()) {
                MAPPER.mapJsonResponse(r, Map.class);
            }
        } catch (AzDException e) {
            throw e;
        }
    }

    /***
     * Restore a package version from the recycle bin to its associated feed.
     *
     * @param feedId      Name or ID of the feed. Example: "ufeed".
     * @param packageName Name of the package. Example: "upackage".
     * @param version     Version of the package. Example: "1.0.0"
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public void restorePackageVersionFromRecycleBin(String feedId, String packageName, String version)
            throws AzDException {
        try {
            String r = send(RequestMethod.PATCH, CONNECTION, UPACK, CONNECTION.getProject(),
                    AREA + "/feeds", feedId, "upack/RecycleBin/packages/" + packageName + "/versions/" + version,
                    ApiVersion.UPACK, null, Map.of("deleted", "false"), null);
            if (!r.isEmpty())
                MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
    }

    /***
     * Delete or restore several package versions from the recycle bin.
     *
     * @param feedId    Name or ID of the feed. Example: "upack".
     * @param operation Type of operation that needs to be performed on packages.
     *                  Recycle Bin supports only PERMANENTDELETE or RESTORETOFEED.
     *                  {@link PackagesBatchOperation}
     * @param packages  Identifies a particular Universal package versions
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public void updateRecycleBinPackages(String feedId, PackagesBatchOperation operation,
                                         List<Map<String, Object>> packages) throws AzDException {
        var req = new HashMap<String, Object>();
        try {
            req.put("data", null);
            req.put("operation", operation.toString().toLowerCase());

            List l = new ArrayList<Map>();
            for (var pkg : packages) {
                l.add(Map.of("id", pkg.get("id"), "version", pkg.get("version")));
            }
            req.put("packages", l);

            String r = send(RequestMethod.POST, CONNECTION, UPACK, CONNECTION.getProject(), AREA + "/feeds", feedId,
                    "upack/RecycleBin/packagesbatch", ApiVersion.UPACK, null, req, CustomHeader.JSON_CONTENT_TYPE);
            if (!r.isEmpty())
                MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
    }
}
