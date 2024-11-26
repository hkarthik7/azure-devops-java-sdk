package org.azd.release.definitions;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.ReleaseDefinitionExpands;
import org.azd.enums.ReleaseDefinitionQueryOrder;
import org.azd.exceptions.AzDException;
import org.azd.release.types.ReleaseDefinition;
import org.azd.release.types.ReleaseDefinitions;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Release Definitions Api.
 */
public class DefinitionsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public DefinitionsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "release", "d8f96f24-8ea7-4cb6-baab-2df8fc515665", ApiVersion.RELEASE_DEFINITION);
    }

    /**
     * Provides functionality to work with Release Definition revisions Api.
     *
     * @return DefinitionsRevisionRequestBuilder {@link DefinitionsRevisionRequestBuilder}
     */
    public DefinitionsRevisionRequestBuilder revision() {
        return new DefinitionsRevisionRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Create a release definition
     *
     * @param releaseDefinition Release definition object to create the definition.
     * @return ReleaseDefinition {@link ReleaseDefinition}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ReleaseDefinition> createAsync(ReleaseDefinition releaseDefinition) throws AzDException {
        return builder()
                .POST(releaseDefinition)
                .build()
                .executeAsync(ReleaseDefinition.class);
    }

    /**
     * Delete a release definition.
     *
     * @param definitionId Id of the release definition/pipeline.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(int definitionId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("definitionId", definitionId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Delete a release definition.
     *
     * @param definitionId         Id of the release definition/pipeline.
     * @param requestConfiguration Request configuration of query parameters.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(int definitionId, Consumer<DeleteRequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("definitionId", definitionId)
                .query(DeleteRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get a release definition.
     *
     * @param definitionId Id of the release definition/pipeline.
     * @return ReleaseDefinition {@link ReleaseDefinition}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ReleaseDefinition> getAsync(int definitionId) throws AzDException {
        return builder()
                .serviceEndpoint("definitionId", definitionId)
                .build()
                .executeAsync(ReleaseDefinition.class);
    }

    /**
     * Get a release definition.
     *
     * @param definitionId Id of the release definition/pipeline.
     * @return ReleaseDefinition {@link ReleaseDefinition}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ReleaseDefinition> getAsync(int definitionId, Consumer<GetRequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("definitionId", definitionId)
                .query(GetRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(ReleaseDefinition.class);
    }

    /**
     * Get a list of release definitions.
     *
     * @return ReleaseDefinitions {@link ReleaseDefinitions}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ReleaseDefinitions> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(ReleaseDefinitions.class);
    }

    /**
     * Get a list of release definitions.
     *
     * @return ReleaseDefinitions {@link ReleaseDefinitions}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ReleaseDefinitions> listAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(ReleaseDefinitions.class);
    }

    /**
     * Update a release definition.
     *
     * @param releaseDefinition Pass the release definition {@link ReleaseDefinition} object. You can get it by running
     *                          either getReleaseDefinitions() or getReleaseDefinition(int definitionId)
     * @return a ReleaseDefinition {@link ReleaseDefinition} object.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ReleaseDefinition> updateAsync(ReleaseDefinition releaseDefinition) throws AzDException {
        return builder()
                .PUT(releaseDefinition)
                .build()
                .executeAsync(ReleaseDefinition.class);
    }

    /**
     * Create a release definition
     *
     * @param releaseDefinition Release definition object to create the definition.
     * @return ReleaseDefinition {@link ReleaseDefinition}
     * @throws AzDException Default Api Exception handler.
     */
    public ReleaseDefinition create(ReleaseDefinition releaseDefinition) throws AzDException {
        return builder()
                .POST(releaseDefinition)
                .build()
                .execute(ReleaseDefinition.class);
    }

    /**
     * Delete a release definition.
     *
     * @param definitionId Id of the release definition/pipeline.
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(int definitionId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("definitionId", definitionId)
                .build()
                .executePrimitive();
    }

    /**
     * Delete a release definition.
     *
     * @param definitionId         Id of the release definition/pipeline.
     * @param requestConfiguration Request configuration of query parameters.
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(int definitionId, Consumer<DeleteRequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("definitionId", definitionId)
                .query(DeleteRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executePrimitive();
    }

    /**
     * Get a release definition.
     *
     * @param definitionId Id of the release definition/pipeline.
     * @return ReleaseDefinition {@link ReleaseDefinition}
     * @throws AzDException Default Api Exception handler.
     */
    public ReleaseDefinition get(int definitionId) throws AzDException {
        return builder()
                .serviceEndpoint("definitionId", definitionId)
                .build()
                .execute(ReleaseDefinition.class);
    }

    /**
     * Get a release definition.
     *
     * @param definitionId Id of the release definition/pipeline.
     * @return ReleaseDefinition {@link ReleaseDefinition}
     * @throws AzDException Default Api Exception handler.
     */
    public ReleaseDefinition get(int definitionId, Consumer<GetRequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("definitionId", definitionId)
                .query(GetRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(ReleaseDefinition.class);
    }

    /**
     * Get a list of release definitions.
     *
     * @return ReleaseDefinitions {@link ReleaseDefinitions}
     * @throws AzDException Default Api Exception handler.
     */
    public ReleaseDefinitions list() throws AzDException {
        return builder()
                .build()
                .execute(ReleaseDefinitions.class);
    }

    /**
     * Get a list of release definitions.
     *
     * @return ReleaseDefinitions {@link ReleaseDefinitions}
     * @throws AzDException Default Api Exception handler.
     */
    public ReleaseDefinitions list(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(ReleaseDefinitions.class);
    }

    /**
     * Update a release definition.
     *
     * @param releaseDefinition Pass the release definition {@link ReleaseDefinition} object. You can get it by running
     *                          either getReleaseDefinitions() or getReleaseDefinition(int definitionId)
     * @return a ReleaseDefinition {@link ReleaseDefinition} object.
     * @throws AzDException Default Api exception handler.
     */
    public ReleaseDefinition update(ReleaseDefinition releaseDefinition) throws AzDException {
        return builder()
                .PUT(releaseDefinition)
                .build()
                .execute(ReleaseDefinition.class);
    }


    /**
     * Represents the query parameters.
     */
    public static class DeleteQueryParameters {
        /**
         * Comment for deleting a release definition.
         */
        @QueryParameter(name = "comment")
        public String comment;
        /**
         * 'true' to automatically cancel any in-progress release deployments and proceed with release definition deletion.
         * Default is 'false'.
         */
        @QueryParameter(name = "forceDelete")
        public Boolean forceDelete;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class DeleteRequestConfiguration {
        public DeleteQueryParameters queryParameters = new DeleteQueryParameters();
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * A comma-delimited list of extended properties to be retrieved.
         * f set, the returned Release Definition will contain values for the specified property Ids
         * (if they exist). If not set, properties will not be included.
         */
        @QueryParameter(name = "propertyFilters")
        public String propertyFilters;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class GetRequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

    /**
     * Represents the query parameters.
     */
    public static class ListQueryParameters {
        /**
         * The properties that should be expanded in the list of Release definitions.
         */
        @QueryParameter(name = "$expand")
        public ReleaseDefinitionExpands expand;
        /**
         * Number of release definitions to get.
         */
        @QueryParameter(name = "$top")
        public Integer top;
        /**
         * Release definitions with given artifactSourceId will be returned.
         * e.g. For build it would be
         * {projectGuid}:{BuildDefinitionId}, for Jenkins it would be {JenkinsConnectionId}:{JenkinsDefinitionId},
         * for TfsOnPrem it would be {TfsOnPremConnectionId}:{ProjectName}:{TfsOnPremDefinitionId}.
         * For third-party artifacts e.g. TeamCity, BitBucket you may refer 'uniqueSourceIdentifier' inside vss-extension.json at
         * <a href="https://github.com/Microsoft/vsts-rm-extensions/blob/master/Extensions">Extensions</a>.
         */
        @QueryParameter(name = "artifactSourceId")
        public String artifactSourceId;
        /**
         * Release definitions with given artifactType will be returned.
         * Values can be Build, Jenkins, GitHub, Nuget, Team Build (external), ExternalTFSBuild, Git, TFVC, ExternalTfsXamlBuild.
         */
        @QueryParameter(name = "artifactType")
        public String artifactType;
        /**
         * Gets the release definitions after the continuation token provided.
         */
        @QueryParameter(name = "continuationToken")
        public String continuationToken;
        /**
         * A comma-delimited list of release definitions to retrieve.
         */
        @QueryParameter(name = "definitionIdFilter")
        public String definitionIdFilter;
        /**
         * 'true' to get release definitions that has been deleted. Default is 'false'
         */
        @QueryParameter(name = "isDeleted")
        public Boolean isDeleted;


        /**
         * 'true' to gets the release definitions with exact match as specified in searchText. Default is 'false'.
         */
        @QueryParameter(name = "isExactNameMatch")
        public Boolean isExactNameMatch;

        /**
         * Gets the release definitions under the specified path.
         */
        @QueryParameter(name = "path")
        public String path;

        /**
         * A comma-delimited list of extended properties to be retrieved.
         * If set, the returned Release Definitions will contain values for the specified property Ids (if they exist).
         * If not set, properties will not be included. Note that this will not filter out any Release Definition
         * from results irrespective of whether it has property set or not.
         */
        @QueryParameter(name = "propertyFilters")
        public String propertyFilters;

        /**
         * Gets the results in the defined order. Default is 'IdAscending'.
         */
        @QueryParameter(name = "queryOrder")
        public ReleaseDefinitionQueryOrder queryOrder;

        /**
         * Get release definitions with names containing searchText.
         */
        @QueryParameter(name = "searchText")
        public String searchText;

        /**
         * 'true' to get the release definitions under the folder with name as specified in searchText. Default is 'false'.
         */
        @QueryParameter(name = "searchTextContainsFolderName")
        public Boolean searchTextContainsFolderName;

        /**
         * A comma-delimited list of tags. Only release definitions with these tags will be returned.
         */
        @QueryParameter(name = "tagFilter")
        public String tagFilter;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public ListQueryParameters queryParameters = new ListQueryParameters();
    }

}
