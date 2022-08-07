package org.azd.release;

import org.azd.common.ApiVersion;
import org.azd.connection.Connection;
import org.azd.distributedtask.types.VariableGroupMap;
import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.ReleaseDetails;
import org.azd.release.types.*;
import org.azd.utils.AzDAsyncApi;

import java.util.*;

import static org.azd.utils.RestClient.send;

/***
 * Release Api to manage releases service
 */
public class ReleaseApi extends AzDAsyncApi<ReleaseApi> implements ReleaseDetails {
    /***
     * Connection object
     */
    private final Connection CONNECTION;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "release/releases";
    private final String RELEASE = "efc2f575-36ef-48e9-b672-0c6fb4a48ac5";

    /***
     * Pass the connection object to work with Release Api
     * @param connection Connection object
     */
    public ReleaseApi(Connection connection) {
        this.CONNECTION = connection;
    }

    /***
     * Create a release.
     * @param releaseDefinitionId pass definition Id to create a release.
     * @param description pass description to create a release.
     * @param artifactAlias build pipeline alias name. Run getBuilds() from BuildApi to get the build alias name and build number.
     * @param artifactId pass the build id.
     * @param artifactName pass the build pipeline name
     * @param isDraft creates the release as draft if set to false
     * @return Release {@link Release}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Release createRelease(int releaseDefinitionId, String description, String artifactAlias,
                                 String artifactId, String artifactName,
                                 boolean isDraft) throws AzDException {

        var artifacts = new LinkedHashMap<String, Object>() {{
            put("alias", artifactAlias);
            put("instanceReference", new LinkedHashMap<String, Object>() {{
                put("id", artifactId);
                put("name", artifactName);
            }});
        }};

        var h = new LinkedHashMap<String, Object>() {{
            put("definitionId", Integer.toString(releaseDefinitionId));
            put("description", description);
            put("artifacts", List.of(artifacts));
            put("isDraft", isDraft);
            put("reason", "none");
            put("manualEnvironments", null);
        }};

        String r = send(RequestMethod.POST, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA, null, null, ApiVersion.RELEASES, null, h, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, Release.class);
    }

    /***
     * Get a Release
     * @param releaseId pass the release id
     * @return Release {@link Release}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Release getRelease(int releaseId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA, Integer.toString(releaseId), null, ApiVersion.RELEASES, null, null, null);

        return MAPPER.mapJsonResponse(r, Release.class);
    }

    /***
     * Gets a Release
     * @param releaseId pass the release id
     * @param expand field to expand in the result. {@link SingleReleaseExpands}
     * @return Release {@link Release}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Release getRelease(int releaseId, SingleReleaseExpands expand) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("$expand", expand.toString().toLowerCase());
        }};

        String r = send(RequestMethod.GET, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA, Integer.toString(releaseId), null, ApiVersion.RELEASES, q, null, null);

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
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Release getRelease(int releaseId, SingleReleaseExpands expand,
                              ReleaseApprovalFilters approvalFilters, String[] propertyFilters,
                              int topGateRecords) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("approvalFilters", approvalFilters);
            put("propertyFilters", String.join(",", propertyFilters));
            put("$expand", expand.toString().toLowerCase());
            put("$topGateRecords", topGateRecords);
        }};

        String r = send(RequestMethod.GET, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA, Integer.toString(releaseId), null, ApiVersion.RELEASES, q, null, null);

        return MAPPER.mapJsonResponse(r, Release.class);
    }

    /***
     * Get a release environment.
     * @param releaseId pass the release id
     * @param environmentId Id of the release environment.
     * @return Release Environment {@link ReleaseEnvironment}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ReleaseEnvironment getReleaseEnvironment(int releaseId, int environmentId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA, Integer.toString(releaseId), "environments/" + environmentId,
                ApiVersion.RELEASE_ENVIRONMENT, null, null, null);

        return MAPPER.mapJsonResponse(r, ReleaseEnvironment.class);
    }

    /***
     * Get a release environment.
     * @param releaseId pass the release id
     * @param environmentId Id of the release environment.
     * @param expand Release expands {@link SingleReleaseExpands}
     * @return Release Environment {@link ReleaseEnvironment}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ReleaseEnvironment getReleaseEnvironment(int releaseId, int environmentId,
                                                    SingleReleaseExpands expand) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("$expand", expand.toString().toLowerCase());
        }};

        String r = send(RequestMethod.GET, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA, Integer.toString(releaseId), "environments/" + environmentId,
                ApiVersion.RELEASE_ENVIRONMENT, q, null, null);

        return MAPPER.mapJsonResponse(r, ReleaseEnvironment.class);
    }

    /***
     * Get a list of releases
     * @return Releases {@link Releases}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Releases getReleases() throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA, null, null, ApiVersion.RELEASES, null, null, null);

        return MAPPER.mapJsonResponse(r, Releases.class);
    }

    /***
     * Get a list of releases
     * @param expand The property that should be expanded in the list of releases. {@link ReleaseExpands}
     * @return Releases {@link Releases}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Releases getReleases(ReleaseExpands expand) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("$expand", expand.toString().toLowerCase());
        }};

        String r = send(RequestMethod.GET, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA, null, null, ApiVersion.RELEASES, q, null, null);

        return MAPPER.mapJsonResponse(r, Releases.class);
    }

    /***
     * Get a list of releases
     * @param definitionId pass the release definition id
     * @return Releases {@link Releases}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Releases getReleases(int definitionId) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("definitionId", definitionId);
        }};

        String r = send(RequestMethod.GET, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA, null, null, ApiVersion.RELEASES, q, null, null);

        return MAPPER.mapJsonResponse(r, Releases.class);
    }

    /***
     * Get a list of releases
     * @param expand The property that should be expanded in the list of releases. {@link ReleaseExpands}
     * @param top Number of releases to get. Default is 50.
     * @return Releases {@link Releases}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Releases getReleases(ReleaseExpands expand, int top) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("$expand", expand.toString().toLowerCase());
            put("$top", top);
        }};

        String r = send(RequestMethod.GET, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA, null, null, ApiVersion.RELEASES, q, null, null);

        return MAPPER.mapJsonResponse(r, Releases.class);
    }

    /***
     * Get a list of releases
     * @param releaseIdFilter A comma-delimited list of releases Ids. Only releases with these Ids will be returned.
     * @return Releases {@link Releases}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Releases getReleases(String[] releaseIdFilter) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("releaseIdFilter", String.join(",", releaseIdFilter));
        }};

        String r = send(RequestMethod.GET, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA, null, null, ApiVersion.RELEASES, q, null, null);

        return MAPPER.mapJsonResponse(r, Releases.class);
    }

    /***
     * Get a list of releases
     * @param expand The property that should be expanded in the list of releases. {@link ReleaseExpands}
     * @param artifactVersionId Releases with given artifactVersionId will be returned. E.g. in case of Build artifactType, it is buildId.
     * @return Releases {@link Releases}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Releases getReleases(ReleaseExpands expand, String artifactVersionId) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("$expand", expand.toString().toLowerCase());
            put("artifactVersionId", artifactVersionId);
        }};

        String r = send(RequestMethod.GET, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA, null, null, ApiVersion.RELEASES, q, null, null);

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
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Releases getReleases(ReleaseExpands expand, int top, String artifactTypeId, String artifactVersionId,
                                int continuationToken, String createdBy, int definitionEnvironmentId, int definitionId,
                                int environmentStatusFilter, boolean isDeleted, String maxCreatedTime, String minCreatedTime,
                                String path, String[] propertyFilters, ReleaseQueryOrder queryOrder, String[] releaseIdFilter,
                                String searchText, String sourceBranchFilter, String sourceId, ReleaseStatus statusFilter,
                                String[] tagFilter) throws AzDException {
        var q = new HashMap<String, Object>() {{
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

        String r = send(RequestMethod.GET, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA, null, null, ApiVersion.RELEASES, q, null, null);

        return MAPPER.mapJsonResponse(r, Releases.class);
    }

    /***
     * Create a release definition
     * @param releaseDefinitionParameters Pass the release definition parameter as string. It is easy to export
     * json result from an existing pipeline and edit it.
     * @return ReleaseDefinition {@link ReleaseDefinition}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ReleaseDefinition createReleaseDefinition(String releaseDefinitionParameters) throws AzDException {

        var body = MAPPER.mapJsonResponse(releaseDefinitionParameters, HashMap.class);

        String r = send(RequestMethod.POST, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA.replace("releases", "definitions"), null, null, ApiVersion.RELEASE_DEFINITION,
                null, body, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, ReleaseDefinition.class);
    }

    /***
     * Delete a release definition.
     * @param definitionId Id of the release definition/pipeline.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deleteReleaseDefinition(int definitionId) throws AzDException {
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, RELEASE, CONNECTION.getProject(),
                    AREA.replace("releases", "definitions"), Integer.toString(definitionId),
                    null, ApiVersion.RELEASE_DEFINITION, null, null, null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
        return null;
    }

    /***
     * Delete a release definition.
     * @param definitionId Id of the release definition/pipeline.
     * @param comment Comment for deleting a release definition.
     * @param forceDelete 'true' to automatically cancel any in-progress release deployments
     * and proceed with release definition deletion . Default is 'false'.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deleteReleaseDefinition(int definitionId, String comment, boolean forceDelete) throws AzDException {
        try {
            var q = new HashMap<String, Object>() {{
                put("comment", comment);
                put("forceDelete", forceDelete);
            }};

            String r = send(RequestMethod.DELETE, CONNECTION, RELEASE, CONNECTION.getProject(),
                    AREA.replace("releases", "definitions"), Integer.toString(definitionId),
                    null, ApiVersion.RELEASE_DEFINITION, q, null, null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
        return null;
    }

    /***
     * Get a release definition.
     * @param definitionId Id of the release definition/pipeline.
     * @return ReleaseDefinition {@link ReleaseDefinition}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ReleaseDefinition getReleaseDefinition(int definitionId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA.replace("releases", "definitions"), Integer.toString(definitionId),
                null, ApiVersion.RELEASE_DEFINITION, null, null, null);

        return MAPPER.mapJsonResponse(r, ReleaseDefinition.class);
    }

    /***
     * Get revision history for a release definition
     * @param definitionId Id of the release definition/pipeline.
     * @return ReleaseDefinitionRevisions {@link ReleaseDefinitionRevisions}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ReleaseDefinitionRevisions getReleaseDefinitionHistory(int definitionId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA.replace("releases", "definitions"), Integer.toString(definitionId),
                "revisions", ApiVersion.RELEASE_DEFINITION_HISTORY, null, null, null);

        return MAPPER.mapJsonResponse(r, ReleaseDefinitionRevisions.class);
    }

    /***
     * Get a list of release definitions.
     * @return ReleaseDefinitions {@link ReleaseDefinitions}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ReleaseDefinitions getReleaseDefinitions() throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA.replace("releases", "definitions"), null,
                null, ApiVersion.RELEASE_DEFINITION, null, null, null);

        return MAPPER.mapJsonResponse(r, ReleaseDefinitions.class);
    }

    /**
     * Get a list of release definitions.
     *
     * @param expands The properties that should be expanded in the list of Release definitions. {@link ReleaseDefinitionExpands}
     * @return ReleaseDefinition Object {@link ReleaseDefinition}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public ReleaseDefinitions getReleaseDefinitions(ReleaseDefinitionExpands expands) throws AzDException {
        var q = new HashMap<String, Object>(){{ put("$expand", expands.name()); }};

        String r = send(RequestMethod.GET, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA.replace("releases", "definitions"), null,
                null, ApiVersion.RELEASE_DEFINITION, q, null, null);

        return MAPPER.mapJsonResponse(r, ReleaseDefinitions.class);
    }

    /**
     * Get a list of release definitions.
     *
     * @param top Number of release definitions to get.
     * @return ReleaseDefinition Object {@link ReleaseDefinition}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public ReleaseDefinitions getReleaseDefinitions(int top) throws AzDException {
        var q = new HashMap<String, Object>(){{ put("$top", top); }};

        String r = send(RequestMethod.GET, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA.replace("releases", "definitions"), null,
                null, ApiVersion.RELEASE_DEFINITION, q, null, null);

        return MAPPER.mapJsonResponse(r, ReleaseDefinitions.class);
    }

    /**
     * Get a list of release definitions.
     *
     * @param artifactSourceId Release definitions with given artifactSourceId will be
     * returned. e.g. For build it would be {projectGuid}:{BuildDefinitionId}, for Jenkins it would be
     * {JenkinsConnectionId}:{JenkinsDefinitionId}, for TfsOnPrem it would be
     * {TfsOnPremConnectionId}:{ProjectName}:{TfsOnPremDefinitionId}.
     * For third-party artifacts e.g. TeamCity, BitBucket you may refer 'uniqueSourceIdentifier'
     * inside vss-extension.json at https://github.com/Microsoft/vsts-rm-extensions/blob/master/Extensions.
     * @return ReleaseDefinition Object {@link ReleaseDefinition}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public ReleaseDefinitions getReleaseDefinitions(String artifactSourceId) throws AzDException {
        var q = new HashMap<String, Object>(){{ put("artifactSourceId", artifactSourceId); }};

        String r = send(RequestMethod.GET, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA.replace("releases", "definitions"), null,
                null, ApiVersion.RELEASE_DEFINITION, q, null, null);

        return MAPPER.mapJsonResponse(r, ReleaseDefinitions.class);
    }

    /**
     * Get a list of release definitions.
     *
     * @param definitionIdFilter A comma-delimited list of release definitions to retrieve.
     * @return ReleaseDefinition Object {@link ReleaseDefinition}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public ReleaseDefinitions getReleaseDefinitions(int[] definitionIdFilter) throws AzDException {
        var q = new HashMap<String, Object>(){{ put("definitionIdFilter", intArrayToString(definitionIdFilter)); }};

        String r = send(RequestMethod.GET, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA.replace("releases", "definitions"), null,
                null, ApiVersion.RELEASE_DEFINITION, q, null, null);

        return MAPPER.mapJsonResponse(r, ReleaseDefinitions.class);
    }

    /**
     * Get a list of release definitions.
     *
     * @param expands The properties that should be expanded in the list of Release definitions.
     * @param top Number of release definitions to get.
     * @param artifactSourceId Release definitions with given artifactSourceId will be returned. e.g.
     * For build it would be {projectGuid}:{BuildDefinitionId}, for Jenkins it would be
     * {JenkinsConnectionId}:{JenkinsDefinitionId}, for TfsOnPrem it would be
     * {TfsOnPremConnectionId}:{ProjectName}:{TfsOnPremDefinitionId}. For third-party artifacts e.g.
     * TeamCity, BitBucket you may refer 'uniqueSourceIdentifier' inside vss-extension.json at
     * https://github.com/Microsoft/vsts-rm-extensions/blob/master/Extensions.
     * @param artifactType Release definitions with given artifactType will be returned. Values can be
     * Build, Jenkins, GitHub, Nuget, Team Build (external), ExternalTFSBuild, Git, TFVC, ExternalTfsXamlBuild.
     * @param continuationToken Gets the release definitions after the continuation token provided.
     * @param definitionIdFilter A comma-delimited list of release definitions to retrieve.
     * @param isDeleted 'true' to get release definitions that has been deleted. Default is 'false'
     * @param isExactNameMatch 'true'to gets the release definitions with exact match as specified in searchText. Default is 'false'.
     * @param path Gets the release definitions under the specified path.
     * @param propertyFilters A comma-delimited list of extended properties to be retrieved.
     * If set, the returned Release Definitions will contain values for the specified property Ids
     * (if they exist). If not set, properties will not be included. Note that this will not filter out
     * any Release Definition from results irrespective of whether it has property set or not.
     * @param queryOrder Gets the results in the defined order. Default is 'IdAscending'.
     * @param searchText Get release definitions with names containing searchText.
     * @param searchTextContainsFolderName 'true' to get the release definitions under the folder with name as
     * specified in searchText. Default is 'false'.
     * @param tagFilter A comma-delimited list of tags. Only release definitions with these tags will be returned.
     * @return ReleaseDefinition Object {@link ReleaseDefinition}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public ReleaseDefinitions getReleaseDefinitions(ReleaseDefinitionExpands expands, int top,
                                                    String artifactSourceId, String artifactType,
                                                    String continuationToken, int[] definitionIdFilter,
                                                    boolean isDeleted, boolean isExactNameMatch, String path,
                                                    String[] propertyFilters, ReleaseDefinitionQueryOrder queryOrder,
                                                    String searchText, boolean searchTextContainsFolderName,
                                                    String[] tagFilter) throws AzDException {
        var q = new HashMap<String, Object>(){{
            put("$expand", expands.name());
            put("$top", top);
            put("artifactSourceId", artifactSourceId);
            put("artifactType", artifactType);
            put("continuationToken", continuationToken);
            put("definitionIdFilter", intArrayToString(definitionIdFilter));
            put("isDeleted", isDeleted);
            put("isExactNameMatch", isExactNameMatch);
            put("path", path);
            put("propertyFilters", String.join(",", propertyFilters));
            put("queryOrder", queryOrder.name());
            put("searchText", searchText);
            put("searchTextContainsFolderName", searchTextContainsFolderName);
            put("tagFilter", String.join(",", tagFilter));
        }};

        String r = send(RequestMethod.GET, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA.replace("releases", "definitions"), null,
                null, ApiVersion.RELEASE_DEFINITION, q, null, null);

        return MAPPER.mapJsonResponse(r, ReleaseDefinitions.class);
    }

    /**
     * Update a release definition.
     *
     * @param releaseDefinition Pass the release definition {@link ReleaseDefinition} object. You can get it by running
     *                          either getReleaseDefinitions() or getReleaseDefinition(int definitionId)
     * @return a ReleaseDefinition {@link ReleaseDefinition} object.
     * @throws AzDException Default Api exception handler.
     */
    @Override
    public ReleaseDefinition updateReleaseDefinition(ReleaseDefinition releaseDefinition) throws AzDException {
        String r = send(RequestMethod.PUT, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA.replace("releases", "definitions"), null,
                null, ApiVersion.RELEASE_DEFINITION, null, releaseDefinition, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, ReleaseDefinition.class);
    }

    /***
     * Delete a release using release id.
     * @param releaseId Release id to delete
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deleteRelease(int releaseId) throws AzDException {
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, RELEASE, CONNECTION.getProject(),
                    AREA, Integer.toString(releaseId), null, ApiVersion.RELEASES, null, null, null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
        return null;
    }

    /***
     * Update a complete release object.
     * @param releaseId Id of the release to update.
     * @param release Release object to update
     * @return a release object {@link Release}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Release updateRelease(int releaseId, Release release) throws AzDException {
        String r = send(RequestMethod.PUT, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA, Integer.toString(releaseId), null, ApiVersion.RELEASES, null, release, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, Release.class);
    }

    /***
     * Update the status of a release environment.
     * @param releaseId Id of the release to update.
     * @param environmentId Id of the stage or environment to update.
     * @param comment Gets or sets comment.
     * @param scheduledDeploymentTime Gets or sets scheduled deployment time.
     * @param status Gets or sets status of environment.
     * @param variables Sets list of environment variables to be overridden at deployment time.
     * @return ReleaseEnvironment object {@link ReleaseEnvironment}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ReleaseEnvironment updateReleaseEnvironment(int releaseId, int environmentId, String comment,
                                                       String scheduledDeploymentTime, ReleaseEnvironmentStatus status, VariableGroupMap variables)
            throws AzDException {
        var b = new HashMap<String, Object>() {{
            put("comment", comment);
            put("scheduledDeploymentTime", scheduledDeploymentTime);
            put("status", status.toString().toLowerCase());
        }};

        if (variables != null) b.put("variables", variables.get());

        String r = send(RequestMethod.PATCH, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA, Integer.toString(releaseId), "environments/" + environmentId, ApiVersion.RELEASE_ENVIRONMENT,
                null, b, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, ReleaseEnvironment.class);
    }

    /***
     * Update few properties of a release.
     * @param releaseId Id of the release to update.
     * @param comment Sets comment for release.
     * @param keepForever Set 'true' to exclude the release from retention policies.
     * @param manualEnvironments Sets list of manual environments.
     * @param status Sets status of the release.
     * @param name Sets name of the release.
     * @return A release object {@link Release}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Release updateReleaseResource(int releaseId, String comment, boolean keepForever, String[] manualEnvironments,
                                         ReleaseStatus status, String name) throws AzDException {
        var b = new HashMap<String, Object>() {{
            put("comment", comment);
            put("keepForever", keepForever);
            put("status", status.toString().toLowerCase());
            put("manualEnvironments", manualEnvironments);
            put("name", name);
        }};

        String r = send(RequestMethod.PATCH, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA, Integer.toString(releaseId), null, ApiVersion.RELEASES, null, b, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, Release.class);
    }

    /***
     * Queue a release pipeline with release id and environment or stage name.
     * @param releaseId Id of the release
     * @param environmentName Stage name or environment name
     * @return Release Environment object {@link ReleaseEnvironment}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ReleaseEnvironment queueRelease(int releaseId, String environmentName) throws AzDException {
        var release = getRelease(releaseId);
        boolean environment = release
                .getEnvironments()
                .stream()
                .anyMatch(x -> x.getName().equals(environmentName));

        if (environment) {
            int environmentId = release
                    .getEnvironments()
                    .stream()
                    .filter(x -> x.getName().equals(environmentName))
                    .findFirst()
                    .get()
                    .getId();

            return updateReleaseEnvironment(releaseId, environmentId, null, null,
                    ReleaseEnvironmentStatus.INPROGRESS, null);
        }

        throw new AzDException("NoSuchElementException", "Given environment name '" + environmentName + "' doesn't exist.");
    }

    /***
     * Abandon a release.
     * @param releaseId Id of the release
     * @return A release object {@link Release}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Release abandonRelease(int releaseId) throws AzDException {
        return updateReleaseResource(releaseId, null, false, null, ReleaseStatus.ABANDONED, null);
    }

    /***
     * Get a list of approvals
     * @return List of release approvals {@link ReleaseApprovals}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ReleaseApprovals getReleaseApprovals() throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA.replace("releases", "approvals"), null, null, ApiVersion.RELEASE, null, null, null);

        return MAPPER.mapJsonResponse(r, ReleaseApprovals.class);
    }

    /***
     * Get a list of approvals
     * @param releaseIdsFilter array of release ids to filter the approvals
     * @return List of release approvals {@link ReleaseApprovals}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ReleaseApprovals getReleaseApprovals(int[] releaseIdsFilter) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("releaseIdsFilter", String.join(",", intArrayToString(releaseIdsFilter)));
        }};

        String r = send(RequestMethod.GET, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA.replace("releases", "approvals"), null, null, ApiVersion.RELEASE, q, null, null);

        return MAPPER.mapJsonResponse(r, ReleaseApprovals.class);
    }

    /***
     * Get a list of approvals
     * @param assignedToFilter Approvals assigned to this user.
     * @param continuationToken Gets the approvals after the continuation token provided.
     * @param includeMyGroupApprovals 'true' to include my group approvals. Default is 'false'.
     * @param queryOrder Gets the results in the defined order of created approvals. Default is 'descending'.
     * @param releaseIdsFilter Approvals for release id(s) mentioned in the filter.
     * Multiple releases can be mentioned by separating them with ',' e.g. releaseIdsFilter=1,2,3,4.
     * @param statusFilter Approvals with this status. Default is 'pending'.
     * @param top Number of approvals to get. Default is 50.
     * @param typeFilter Approval with this type.
     * @return List of release approvals {@link ReleaseApprovals}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ReleaseApprovals getReleaseApprovals(String assignedToFilter, int continuationToken, boolean includeMyGroupApprovals,
                                                ReleaseQueryOrder queryOrder, int[] releaseIdsFilter, ReleaseApprovalStatus statusFilter,
                                                int top, ReleaseApprovalType typeFilter) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("assignedToFilter", assignedToFilter);
            put("continuationToken", continuationToken);
            put("includeMyGroupApprovals", includeMyGroupApprovals);
            put("queryOrder", queryOrder.toString().toLowerCase());
            put("releaseIdsFilter", String.join(",", intArrayToString(releaseIdsFilter)));
            put("statusFilter", statusFilter);
            put("top", top);
            put("typeFilter", typeFilter.toString().toLowerCase());
        }};

        String r = send(RequestMethod.GET, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA.replace("releases", "approvals"), null, null, ApiVersion.RELEASE, q, null, null);

        return MAPPER.mapJsonResponse(r, ReleaseApprovals.class);
    }

    /***
     * Update status of an approval
     * @param approvalId Id of the approval.
     * @param status Gets or sets the status of the approval.
     * @param comments Gets or sets comments for approval.
     * @return release approval object {@link ReleaseApproval}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ReleaseApproval updateApproval(int approvalId, ReleaseApprovalStatus status, String comments) throws AzDException {
        var body = new HashMap<String, Object>() {{
            put("status", status.toString().toLowerCase());
            put("comments", comments);
        }};

        String r = send(RequestMethod.PATCH, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA.replace("releases", "approvals"), Integer.toString(approvalId), null, ApiVersion.RELEASE, null, body, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, ReleaseApproval.class);
    }

    /***
     * Get manual intervention for a given release and manual intervention id.
     * @param releaseId Id of the manual intervention.
     * @param manualInterventionId Id of the release.
     * @return manual intervention object {@link ManualIntervention}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ManualIntervention getManualIntervention(int releaseId, int manualInterventionId) throws AzDException {
        String id = releaseId + "/manualinterventions/" + manualInterventionId;

        String r = send(RequestMethod.GET, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA, id, null, ApiVersion.RELEASE_MANUAL_INTERVENTION, null, null, null);

        return MAPPER.mapJsonResponse(r, ManualIntervention.class);
    }

    /***
     * List all manual interventions for a given release.
     * @param releaseId Id of the release.
     * @return list of manual intervention object {@link ManualInterventions}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ManualInterventions getManualInterventions(int releaseId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA, Integer.toString(releaseId), null, ApiVersion.RELEASE_MANUAL_INTERVENTION, null, null, null);

        return MAPPER.mapJsonResponse(r, ManualInterventions.class);
    }

    /***
     * Update manual intervention.
     * @param releaseId Id of the release.
     * @param manualInterventionId Id of the manual intervention.
     * @param comment Sets the comment for manual intervention update.
     * @param status Sets the status of the manual intervention.
     * @return manual intervention object {@link ManualIntervention}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ManualIntervention updateManualIntervention(int releaseId, int manualInterventionId, String comment, ManualInterventionStatus status)
            throws AzDException {
        var body = new HashMap<String, Object>() {{
            put("status", status.toString().toLowerCase());
            put("comment", comment);
        }};

        String id = releaseId + "/manualinterventions/" + manualInterventionId;

        String r = send(RequestMethod.PATCH, CONNECTION, RELEASE, CONNECTION.getProject(),
                AREA, id, null, ApiVersion.RELEASE_MANUAL_INTERVENTION, null, body, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, ManualIntervention.class);
    }

    /***
     * Helper method to convert integer array to string.
     * @param i integer array
     * @return {@link String}
     */
    private String intArrayToString(int[] i) {
        var r = Arrays.stream(i).mapToObj(String::valueOf).toArray(String[]::new);
        return String.join(",", r);
    }
}
