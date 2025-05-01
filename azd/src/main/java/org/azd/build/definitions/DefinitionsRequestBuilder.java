package org.azd.build.definitions;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.build.types.BuildDefinition;
import org.azd.build.types.BuildDefinitionRevisions;
import org.azd.build.types.BuildDefinitions;
import org.azd.common.ApiVersion;
import org.azd.enums.DefinitionQueryOrder;
import org.azd.exceptions.AzDException;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Build Definitions Api.
 */
public class DefinitionsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public DefinitionsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "build", "dbeaf647-6167-421a-bda9-c9327b25e2e6", ApiVersion.BUILD_DEFINITIONS);
    }

    /**
     * Creates a new definition.
     *
     * @param buildDefinition                Build definition object.
     * @param definitionRequestConfiguration Consumer of query parameters to clone the definition if exists.
     * @return build definition {@link BuildDefinition}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildDefinition> createAsync(BuildDefinition buildDefinition,
                                                          Consumer<DefinitionRequestConfiguration> definitionRequestConfiguration) throws AzDException {
        return builder()
                .POST(buildDefinition)
                .query(DefinitionRequestConfiguration::new, definitionRequestConfiguration, q -> q.definitionQueryParameters)
                .build()
                .executeAsync(BuildDefinition.class);
    }

    /**
     * Deletes a definition and all associated builds.
     *
     * @param definitionId pass the definition id
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
     * Gets a definition
     *
     * @param definitionId         pass the definition id
     * @param requestConfiguration Consumer of query request parameters.
     * @return build definition {@link BuildDefinition}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildDefinition> getAsync(int definitionId, Consumer<GetRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("definitionId", definitionId)
                .query(GetRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(BuildDefinition.class);
    }

    /**
     * Gets a definition
     *
     * @param definitionId pass the definition id.
     * @return build definition {@link BuildDefinition}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildDefinition> getAsync(int definitionId) throws AzDException {
        return builder()
                .serviceEndpoint("definitionId", definitionId)
                .build()
                .executeAsync(BuildDefinition.class);
    }

    /**
     * Gets a definition revisions.
     *
     * @param definitionId pass the definition id
     * @return build definition revisions object {@link BuildDefinitionRevisions}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildDefinitionRevisions> getRevisionsAsync(int definitionId) throws AzDException {
        return builder()
                .serviceEndpoint("definitionId", definitionId)
                .location("7c116775-52e5-453e-8c5d-914d9762d8c4")
                .apiVersion(ApiVersion.BUILD_DEFINITION_REVISIONS)
                .build()
                .executeAsync(BuildDefinitionRevisions.class);
    }

    /**
     * Gets a list of definitions.
     *
     * @return build definitions object {@link BuildDefinitions}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildDefinitions> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(BuildDefinitions.class);
    }


    /**
     * Gets a list of definitions.
     *
     * @param requestConfiguration Consumer of query request parameters.
     * @return build definitions object {@link BuildDefinitions}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildDefinitions> listAsync(Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(BuildDefinitions.class);
    }

    /**
     * Restores a deleted definition
     *
     * @param definitionId pass the build definition id
     * @param deleted      When false, restores a deleted definition.
     * @return a {@link BuildDefinition} object
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildDefinition> restoreAsync(int definitionId, boolean deleted) throws AzDException {
        return builder()
                .PATCH(null)
                .serviceEndpoint("definitionId", definitionId)
                .query("deleted", deleted)
                .build()
                .executeAsync(BuildDefinition.class);
    }

    /**
     * Updates an existing build definition.
     * In order for this operation to succeed, the value of the "Revision" property of the request body must match the
     * existing build definition's. It is recommended that you obtain the existing build definition by using GET, modify
     * the build definition as necessary, and then submit the modified definition with PUT.
     *
     * @param definitionId    pass the build definition id
     * @param buildDefinition Build definition object to update.
     * @return a {@link BuildDefinition} object
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildDefinition> updateAsync(int definitionId, BuildDefinition buildDefinition,
                                                          Consumer<UpdateRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .PUT(buildDefinition)
                .serviceEndpoint("definitionId", definitionId)
                .query(UpdateRequestConfiguration::new, requestConfiguration, q -> q.updateQueryParameters)
                .build()
                .executeAsync(BuildDefinition.class);
    }

    /**
     * Creates a new definition.
     *
     * @param buildDefinition                Build definition object.
     * @param definitionRequestConfiguration Consumer of query parameters to clone the definition if exists.
     * @return build definition {@link BuildDefinition}
     * @throws AzDException Default Api Exception handler.
     */
    public BuildDefinition create(BuildDefinition buildDefinition,
                                  Consumer<DefinitionRequestConfiguration> definitionRequestConfiguration) throws AzDException {
        return builder()
                .POST(buildDefinition)
                .query(DefinitionRequestConfiguration::new, definitionRequestConfiguration, q -> q.definitionQueryParameters)
                .build()
                .execute(BuildDefinition.class);
    }

    /**
     * Deletes a definition and all associated builds.
     *
     * @param definitionId pass the definition id
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
     * Gets a definition
     *
     * @param definitionId         pass the definition id
     * @param requestConfiguration Consumer of query request parameters.
     * @return build definition {@link BuildDefinition}
     * @throws AzDException Default Api Exception handler.
     */
    public BuildDefinition get(int definitionId, Consumer<GetRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("definitionId", definitionId)
                .query(GetRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(BuildDefinition.class);
    }

    /**
     * Gets a definition
     *
     * @param definitionId pass the definition id.
     * @return build definition {@link BuildDefinition}
     * @throws AzDException Default Api Exception handler.
     */
    public BuildDefinition get(int definitionId) throws AzDException {
        return builder()
                .serviceEndpoint("definitionId", definitionId)
                .build()
                .execute(BuildDefinition.class);
    }

    /**
     * Gets a definition revisions.
     *
     * @param definitionId pass the definition id
     * @return build definition revisions object {@link BuildDefinitionRevisions}
     * @throws AzDException Default Api Exception handler.
     */
    public BuildDefinitionRevisions getRevisions(int definitionId) throws AzDException {
        return builder()
                .serviceEndpoint("definitionId", definitionId)
                .location("7c116775-52e5-453e-8c5d-914d9762d8c4")
                .apiVersion(ApiVersion.BUILD_DEFINITION_REVISIONS)
                .build()
                .execute(BuildDefinitionRevisions.class);
    }

    /**
     * Gets a list of definitions.
     *
     * @return build definitions object {@link BuildDefinitions}
     * @throws AzDException Default Api Exception handler.
     */
    public BuildDefinitions list() throws AzDException {
        return builder()
                .build()
                .execute(BuildDefinitions.class);
    }


    /**
     * Gets a list of definitions.
     *
     * @param requestConfiguration Consumer of query request parameters.
     * @return build definitions object {@link BuildDefinitions}
     * @throws AzDException Default Api Exception handler.
     */
    public BuildDefinitions list(Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(BuildDefinitions.class);
    }

    /**
     * Restores a deleted definition
     *
     * @param definitionId pass the build definition id
     * @param deleted      When false, restores a deleted definition.
     * @return a {@link BuildDefinition} object
     * @throws AzDException Default Api Exception handler.
     */
    public BuildDefinition restore(int definitionId, boolean deleted) throws AzDException {
        return builder()
                .PATCH(null)
                .serviceEndpoint("definitionId", definitionId)
                .query("deleted", deleted)
                .build()
                .execute(BuildDefinition.class);
    }

    /**
     * Updates an existing build definition.
     * In order for this operation to succeed, the value of the "Revision" property of the request body must match the
     * existing build definition's. It is recommended that you obtain the existing build definition by using GET, modify
     * the build definition as necessary, and then submit the modified definition with PUT.
     *
     * @param definitionId    pass the build definition id
     * @param buildDefinition Build definition object to update.
     * @return a {@link BuildDefinition} object
     * @throws AzDException Default Api Exception handler.
     */
    public BuildDefinition update(int definitionId, BuildDefinition buildDefinition,
                                  Consumer<UpdateRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .PUT(buildDefinition)
                .serviceEndpoint("definitionId", definitionId)
                .query(UpdateRequestConfiguration::new, requestConfiguration, q -> q.updateQueryParameters)
                .build()
                .execute(BuildDefinition.class);
    }

    /**
     * Represents the query parameter for Create Definition.
     */
    public static class UpdateQueryParameters {
        @QueryParameter(name = "secretsSourceDefinitionId")
        public Number secretsSourceDefinitionId;
        @QueryParameter(name = "secretsSourceDefinitionRevision")
        public Number secretsSourceDefinitionRevision;
    }

    public static class UpdateRequestConfiguration {
        public UpdateQueryParameters updateQueryParameters = new UpdateQueryParameters();
    }

    /**
     * Represents the query parameter for Create Definition.
     */
    public static class DefinitionQueryParameters {
        @QueryParameter(name = "definitionToCloneId")
        public Number definitionToCloneId;
        @QueryParameter(name = "definitionToCloneRevision")
        public Number definitionToCloneRevision;
    }

    public static class DefinitionRequestConfiguration {
        public DefinitionQueryParameters definitionQueryParameters = new DefinitionQueryParameters();
    }

    public static class GetQueryParameters {
        /**
         * If true includes latest builds.
         */
        @QueryParameter(name = "includeLatestBuilds")
        public Boolean includeLatestBuilds;
        /**
         * If specified, indicates the date from which metrics should be included.
         */
        @QueryParameter(name = "minMetricsTime")
        public String minMetricsTime;
        /**
         * A comma-delimited list of properties to include in the results.
         */
        @QueryParameter(name = "propertyFilters")
        public String[] propertyFilters;
        /**
         * The revision number to retrieve. If this is not specified, the latest version will be returned.
         */
        @QueryParameter(name = "revision")
        public Integer revision;
    }

    public static class GetRequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

    public static class ListQueryParameters {
        /**
         * The maximum number of definitions to return.
         */
        @QueryParameter(name = "$top")
        public Integer top;
        /**
         * If specified, filters to definitions that have builds after this date.
         */
        @QueryParameter(name = "builtAfter")
        public String builtAfter;
        /**
         * A continuation token, returned by a previous call to this method, that can be used to return the next set of definitions.
         */
        @QueryParameter(name = "continuationToken")
        public String continuationToken;
        /**
         * A comma-delimited list that specifies the IDs of definitions to retrieve.
         */
        @QueryParameter(name = "definitionIds")
        public String[] definitionIds;
        /**
         * Indicates whether the full definitions should be returned. By default, shallow representations of the definitions are returned.
         */
        @QueryParameter(name = "includeAllProperties")
        public Boolean includeAllProperties;
        /**
         * Indicates whether to return the latest and latest completed builds for this definition.
         */
        @QueryParameter(name = "includeLatestBuilds")
        public Boolean includeLatestBuilds;
        /**
         * If specified, indicates the date from which metrics should be included.
         */
        @QueryParameter(name = "minMetricsTime")
        public String minMetricsTime;
        /**
         * If specified, filters to definitions whose names match this pattern.
         */
        @QueryParameter(name = "name")
        public String name;
        /**
         * If specified, filters to definitions that do not have builds after this date.
         */
        @QueryParameter(name = "notBuiltAfter")
        public String notBuiltAfter;
        /**
         * If specified, filters to definitions under this folder.
         */
        @QueryParameter(name = "path")
        public String path;
        /**
         * If specified, filters to definitions with the given process type.
         */
        @QueryParameter(name = "processType")
        public Number processType;
        /**
         * Indicates the order in which definitions should be returned.
         */
        @QueryParameter(name = "queryOrder")
        public DefinitionQueryOrder queryOrder;
        /**
         * A repository ID. If specified, filters to definitions that use this repository.
         */
        @QueryParameter(name = "repositoryId")
        public String repositoryId;
        /**
         * If specified, filters to definitions that have a repository of this type.
         */
        @QueryParameter(name = "repositoryType")
        public String repositoryType;
        /**
         * If specified, filters to definitions that use the specified task.
         */
        @QueryParameter(name = "taskIdFilter")
        public String taskIdFilter;
        /**
         * If specified, filters to YAML definitions that match the given filename. To use this filter includeAllProperties should be set to true
         */
        @QueryParameter(name = "yamlFilename")
        public String yamlFilename;
    }

    public static class ListRequestConfiguration {
        public ListQueryParameters queryParameters = new ListQueryParameters();
    }
}
