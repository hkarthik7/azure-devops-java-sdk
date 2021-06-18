package org.azd.release;

import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.ReleaseDetails;
import org.azd.release.types.Release;
import org.azd.release.types.ReleaseEnvironment;
import org.azd.release.types.Releases;
import org.azd.utils.AzDDefaultParameters;
import org.azd.utils.ResourceId;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import static org.azd.utils.Client.request;

public class ReleaseApi implements ReleaseDetails {
    /***
     * Instance of AzDDefaultParameters
     */
    private final AzDDefaultParameters DEFAULT_PARAMETERS;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "release/releases";

    /***
     * Instantiate the class with instance of AzDDefaultParameters
     * @param defaultParameters instance of AzDDefaultParameters
     */
    public ReleaseApi(AzDDefaultParameters defaultParameters) { this.DEFAULT_PARAMETERS = defaultParameters; }

    /***
     * Create a release.
     * @param releaseDefinitionId pass definition Id to create a release.
     * @param description pass description to create a release.
     * @param artifactAlias build pipeline alias name. Run getBuilds() from BuildApi to get the build alias name and build number.
     * @param artifactId pass the build id.
     * @param artifactName pass the build pipeline name
     * @param isDraft creates the release as draft if set to false
     * @return Release {@link Release}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public Release createRelease(int releaseDefinitionId, String description, String artifactAlias,
                                 String artifactId, String artifactName,
                                 boolean isDraft) throws DefaultParametersException, AzDException {

        var artifacts = new LinkedHashMap<String, Object>(){{
            put("alias", artifactAlias);
            put("instanceReference", new LinkedHashMap<String, Object>(){{
                put("id", artifactId);
                put("name", artifactName);
            }});
        }};

        var h = new LinkedHashMap<String, Object>(){{
            put("definitionId", Integer.toString(releaseDefinitionId));
            put("description", description);
            put("artifacts", List.of(artifacts));
            put("isDraft", isDraft);
            put("reason", "none");
            put("manualEnvironments", null);

        }};
        String r = request(RequestMethod.POST, DEFAULT_PARAMETERS, ResourceId.RELEASE, DEFAULT_PARAMETERS.getProject(),
                AREA, null, null, ReleaseVersion.VERSION, null, h);

        return MAPPER.mapJsonResponse(r, Release.class);
    }

    /***
     * Get a Release
     * @param releaseId pass the release id
     * @return Release {@link Release}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public Release getRelease(int releaseId) throws DefaultParametersException, AzDException {
        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.RELEASE, DEFAULT_PARAMETERS.getProject(),
                AREA, Integer.toString(releaseId), null, ReleaseVersion.VERSION, null, null);

        return MAPPER.mapJsonResponse(r, Release.class);
    }

    /***
     * Gets a Release
     * @param releaseId pass the release id
     * @param expand field to expand in the result. {@link SingleReleaseExpands}
     * @return Release {@link Release}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public Release getRelease(int releaseId, SingleReleaseExpands expand) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("$expand", expand.toString().toLowerCase());
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.RELEASE, DEFAULT_PARAMETERS.getProject(),
                AREA, Integer.toString(releaseId), null, ReleaseVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, Release.class);
    }

    /***
     * Gets a Release
     * @param releaseId pass the release id
     * @param expand field to expand in the result. {@link SingleReleaseExpands}
     * @param approvalFilters A filter which would allow fetching approval steps selectively based on whether it is automated, or manual.
     * This would also decide whether we should fetch pre and post approval snapshots. Assumes All by default
     * @param propertyFilters A comma-delimited list of extended properties to be retrieved.
     * If set, the returned Release will contain values for the specified property Ids (if they exist).
     * If not set, properties will not be included.
     * @param topGateRecords Number of release gate records to get. Default is 5.
     * @return Release {@link Release}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public Release getRelease(int releaseId, SingleReleaseExpands expand,
                              ReleaseApprovalFilters approvalFilters, String[] propertyFilters,
                              int topGateRecords) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("approvalFilters", approvalFilters);
            put("propertyFilters", String.join(",", propertyFilters));
            put("$expand", expand.toString().toLowerCase());
            put("$topGateRecords", topGateRecords);
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.RELEASE, DEFAULT_PARAMETERS.getProject(),
                AREA, Integer.toString(releaseId), null, ReleaseVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, Release.class);
    }

    /***
     * Get a release environment.
     * @param releaseId pass the release id
     * @param environmentId Id of the release environment.
     * @return Release Environment {@link ReleaseEnvironment}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public ReleaseEnvironment getReleaseEnvironment(int releaseId, int environmentId) throws DefaultParametersException, AzDException {
        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.RELEASE, DEFAULT_PARAMETERS.getProject(),
                AREA, Integer.toString(releaseId), "environments/" + environmentId,
                ReleaseVersion.RELEASE_ENVIRONMENT, null, null);

        return MAPPER.mapJsonResponse(r, ReleaseEnvironment.class);
    }

    /***
     * Get a release environment.
     * @param releaseId pass the release id
     * @param environmentId Id of the release environment.
     * @param expand Release expands {@link SingleReleaseExpands}
     * @return Release Environment {@link ReleaseEnvironment}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public ReleaseEnvironment getReleaseEnvironment(int releaseId, int environmentId,
                                                    SingleReleaseExpands expand) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("$expand", expand.toString().toLowerCase());
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.RELEASE, DEFAULT_PARAMETERS.getProject(),
                AREA, Integer.toString(releaseId), "environments/" + environmentId,
                ReleaseVersion.RELEASE_ENVIRONMENT, q, null);

        return MAPPER.mapJsonResponse(r, ReleaseEnvironment.class);
    }

    /***
     * Get a list of releases
     * @return Releases {@link Releases}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public Releases getReleases() throws DefaultParametersException, AzDException {
        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.RELEASE, DEFAULT_PARAMETERS.getProject(),
                AREA, null, null, ReleaseVersion.VERSION, null, null);

        return MAPPER.mapJsonResponse(r, Releases.class);
    }

    /***
     * Get a list of releases
     * @param expand The property that should be expanded in the list of releases. {@link ReleaseExpands}
     * @return Releases {@link Releases}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public Releases getReleases(ReleaseExpands expand) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("$expand", expand.toString().toLowerCase());
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.RELEASE, DEFAULT_PARAMETERS.getProject(),
                AREA, null, null, ReleaseVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, Releases.class);
    }

    /***
     * Get a list of releases
     * @param definitionId pass the release definition id
     * @return Releases {@link Releases}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public Releases getReleases(int definitionId) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("definitionId", definitionId);
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.RELEASE, DEFAULT_PARAMETERS.getProject(),
                AREA, null, null, ReleaseVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, Releases.class);
    }

    /***
     * Get a list of releases
     * @param expand The property that should be expanded in the list of releases. {@link ReleaseExpands}
     * @param top Number of releases to get. Default is 50.
     * @return Releases {@link Releases}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public Releases getReleases(ReleaseExpands expand, int top) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("$expand", expand.toString().toLowerCase());
            put("$top", top);
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.RELEASE, DEFAULT_PARAMETERS.getProject(),
                AREA, null, null, ReleaseVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, Releases.class);
    }

    /***
     * Get a list of releases
     * @param releaseIdFilter A comma-delimited list of releases Ids. Only releases with these Ids will be returned.
     * @return Releases {@link Releases}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public Releases getReleases(String[] releaseIdFilter) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("releaseIdFilter", String.join(",", releaseIdFilter));
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.RELEASE, DEFAULT_PARAMETERS.getProject(),
                AREA, null, null, ReleaseVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, Releases.class);
    }

    /***
     * Get a list of releases
     * @param expand The property that should be expanded in the list of releases. {@link ReleaseExpands}
     * @param top Number of releases to get. Default is 50.
     * @param artifactTypeId Releases with given artifactTypeId will be returned.
     * Values can be Build, Jenkins, GitHub, Nuget, Team Build (external), ExternalTFSBuild, Git, TFVC, ExternalTfsXamlBuild.
     * @param artifactVersionId Releases with given artifactVersionId will be returned. E.g. in case of Build artifactType, it is buildId.
     * @param continuationToken Gets the releases after the continuation token provided.
     * @param createdBy Releases created by this user.
     * @param definitionEnvironmentId pass the release definition environment id
     * @param definitionId Releases from this release definition Id.
     * @param environmentStatusFilter environment status filter
     * @param isDeleted Gets the soft deleted releases, if true.
     * @param maxCreatedTime Releases that were created before this time.
     * @param minCreatedTime Releases that were created after this time.
     * @param path Releases under this folder path will be returned
     * @param propertyFilters A comma-delimited list of extended properties to be retrieved.
     * If set, the returned Releases will contain values for the specified property Ids (if they exist).
     * If not set, properties will not be included. Note that this will not filter out any Release from
     * results irrespective of whether it has property set or not.
     * @param queryOrder Gets the results in the defined order of created date for releases. Default is descending.
     * @param releaseIdFilter A comma-delimited list of releases Ids. Only releases with these Ids will be returned.
     * @param searchText Releases with names containing searchText.
     * @param sourceBranchFilter Releases with given sourceBranchFilter will be returned.
     * @param sourceId Unique identifier of the artifact used. e.g. For build it would be {projectGuid}:{BuildDefinitionId},
     * for Jenkins it would be {JenkinsConnectionId}:{JenkinsDefinitionId}, for TfsOnPrem it would be
     * {TfsOnPremConnectionId}:{ProjectName}:{TfsOnPremDefinitionId}. For third-party artifacts e.g. TeamCity,
     * BitBucket you may refer 'uniqueSourceIdentifier' inside vss-extension.json
     * https://github.com/Microsoft/vsts-rm-extensions/blob/master/Extensions.
     * @param statusFilter Releases that have the status from {@link ReleaseStatus}.
     * @param tagFilter A comma-delimited list of tags. Only releases with these tags will be returned.
     * @return Releases {@link Releases}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public Releases getReleases(ReleaseExpands expand, int top, String artifactTypeId, String artifactVersionId,
                                int continuationToken, String createdBy, int definitionEnvironmentId, int definitionId,
                                int environmentStatusFilter, boolean isDeleted, String maxCreatedTime, String minCreatedTime,
                                String path, String[] propertyFilters, ReleaseQueryOrder queryOrder, String[] releaseIdFilter,
                                String searchText, String sourceBranchFilter, String sourceId, ReleaseStatus statusFilter,
                                String[] tagFilter) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("definitionId", definitionId);
            put("definitionEnvironmentId", definitionEnvironmentId);
            put("searchText", searchText);
            put("createdBy", createdBy);
            put("statusFilter", statusFilter);
            put("environmentStatusFilter", environmentStatusFilter);
            put("minCreatedTime", minCreatedTime);
            put("maxCreatedTime", maxCreatedTime);
            put("queryOrder", queryOrder.toString().toLowerCase());
            put("$top", top);
            put("continuationToken", continuationToken);
            put("artifactTypeId", artifactTypeId);
            put("sourceId", sourceId);
            put("artifactVersionId", artifactVersionId);
            put("sourceBranchFilter", sourceBranchFilter);
            put("isDeleted", isDeleted);
            put("$expand", expand.toString().toLowerCase());
            put("tagFilter", String.join(",", tagFilter));
            put("propertyFilters", String.join(",", propertyFilters));
            put("path", path);
            put("releaseIdFilter", String.join(",", releaseIdFilter));
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.RELEASE, DEFAULT_PARAMETERS.getProject(),
                AREA, null, null, ReleaseVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, Releases.class);
    }
}
