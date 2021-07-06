package org.azd.release;

import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.ReleaseDetails;
import org.azd.release.types.*;
import org.azd.connection.Connection;
import org.azd.utils.Client;
import org.azd.utils.ResourceId;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.azd.utils.Client.send;

/***
 * Release Api to manage releases service
 */
public class ReleaseApi implements ReleaseDetails {
    /***
     * Connection object
     */
    private final Connection CONNECTION;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "release/releases";

    /***
     * Pass the connection object to work with Release Api
     * @param connection Connection object
     */
    public ReleaseApi(Connection connection) { this.CONNECTION = connection; }

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
        String r = send(RequestMethod.POST, CONNECTION, ResourceId.RELEASE, CONNECTION.getProject(),
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
        String r = send(RequestMethod.GET, CONNECTION, ResourceId.RELEASE, CONNECTION.getProject(),
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

        String r = send(RequestMethod.GET, CONNECTION, ResourceId.RELEASE, CONNECTION.getProject(),
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

        String r = send(RequestMethod.GET, CONNECTION, ResourceId.RELEASE, CONNECTION.getProject(),
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
        String r = send(RequestMethod.GET, CONNECTION, ResourceId.RELEASE, CONNECTION.getProject(),
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

        String r = send(RequestMethod.GET, CONNECTION, ResourceId.RELEASE, CONNECTION.getProject(),
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
        String r = send(RequestMethod.GET, CONNECTION, ResourceId.RELEASE, CONNECTION.getProject(),
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

        String r = send(RequestMethod.GET, CONNECTION, ResourceId.RELEASE, CONNECTION.getProject(),
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

        String r = send(RequestMethod.GET, CONNECTION, ResourceId.RELEASE, CONNECTION.getProject(),
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

        String r = send(RequestMethod.GET, CONNECTION, ResourceId.RELEASE, CONNECTION.getProject(),
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

        String r = send(RequestMethod.GET, CONNECTION, ResourceId.RELEASE, CONNECTION.getProject(),
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

        String r = send(RequestMethod.GET, CONNECTION, ResourceId.RELEASE, CONNECTION.getProject(),
                AREA, null, null, ReleaseVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, Releases.class);
    }

    /***
     * Create a release definition
     * @param releaseDefinitionParameters Pass the release definition parameter as string. It is easy to export
     * json result from an existing pipeline and edit it.
     * @return ReleaseDefinition {@link ReleaseDefinition}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public ReleaseDefinition createReleaseDefinition(String releaseDefinitionParameters) throws DefaultParametersException, AzDException {

        var body = MAPPER.mapJsonResponse(releaseDefinitionParameters, HashMap.class);

        String r = send(RequestMethod.POST, CONNECTION, ResourceId.RELEASE, CONNECTION.getProject(),
                AREA.replace("releases", "definitions"), null, null, ReleaseVersion.RELEASE_DEFINITION, null, body);

        return MAPPER.mapJsonResponse(r, ReleaseDefinition.class);
    }

    /***
     * Delete a release definition.
     * @param definitionId Id of the release definition/pipeline.
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public void deleteReleaseDefinition(int definitionId) throws DefaultParametersException, AzDException {
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, ResourceId.RELEASE, CONNECTION.getProject(),
                    AREA.replace("releases", "definitions"), Integer.toString(definitionId),
                    null, ReleaseVersion.RELEASE_DEFINITION, null, null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (DefaultParametersException | AzDException e) {
            throw e;
        }
    }

    /***
     * Delete a release definition.
     * @param definitionId Id of the release definition/pipeline.
     * @param comment Comment for deleting a release definition.
     * @param forceDelete 'true' to automatically cancel any in-progress release deployments
     * and proceed with release definition deletion . Default is 'false'.
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public void deleteReleaseDefinition(int definitionId, String comment, boolean forceDelete) throws DefaultParametersException, AzDException {
        try {
            var q = new HashMap<String, Object>(){{
                put("comment", comment);
                put("forceDelete", forceDelete);
            }};

            String r = send(RequestMethod.DELETE, CONNECTION, ResourceId.RELEASE, CONNECTION.getProject(),
                    AREA.replace("releases", "definitions"), Integer.toString(definitionId),
                    null, ReleaseVersion.RELEASE_DEFINITION, q, null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (DefaultParametersException | AzDException e) {
            throw e;
        }
    }

    /***
     * Get a release definition.
     * @param definitionId Id of the release definition/pipeline.
     * @return ReleaseDefinition {@link ReleaseDefinition}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public ReleaseDefinition getReleaseDefinition(int definitionId) throws DefaultParametersException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, ResourceId.RELEASE, CONNECTION.getProject(),
                AREA.replace("releases", "definitions"), Integer.toString(definitionId),
                null, ReleaseVersion.RELEASE_DEFINITION, null, null);

        return MAPPER.mapJsonResponse(r, ReleaseDefinition.class);
    }

    /***
     * Get revision history for a release definition
     * @param definitionId Id of the release definition/pipeline.
     * @return ReleaseDefinitionRevisions {@link ReleaseDefinitionRevisions}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public ReleaseDefinitionRevisions getReleaseDefinitionHistory(int definitionId) throws DefaultParametersException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, ResourceId.RELEASE, CONNECTION.getProject(),
                AREA.replace("releases", "definitions"), Integer.toString(definitionId),
                "revisions", ReleaseVersion.RELEASE_DEFINITION_HISTORY, null, null);

        return MAPPER.mapJsonResponse(r, ReleaseDefinitionRevisions.class);
    }

    /***
     * Get a list of release definitions.
     * @return ReleaseDefinitions {@link ReleaseDefinitions}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public ReleaseDefinitions getReleaseDefinitions() throws DefaultParametersException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, ResourceId.RELEASE, CONNECTION.getProject(),
                AREA.replace("releases", "definitions"), null,
                null, ReleaseVersion.RELEASE_DEFINITION, null, null);

        return MAPPER.mapJsonResponse(r, ReleaseDefinitions.class);
    }
}
