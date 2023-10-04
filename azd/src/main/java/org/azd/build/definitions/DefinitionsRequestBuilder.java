package org.azd.build.definitions;

import org.azd.build.types.BuildDefinition;
import org.azd.build.types.BuildDefinitionRevisions;
import org.azd.build.types.BuildDefinitions;
import org.azd.common.ApiVersion;
import org.azd.common.types.QueryParameter;
import org.azd.enums.CustomHeader;
import org.azd.enums.DefinitionQueryOrder;
import org.azd.exceptions.AzDException;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Build Definitions Api.
 */
public class DefinitionsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public DefinitionsRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "build/definitions", ApiVersion.BUILD_DEFINITIONS);
    }

    /***
     * Creates a new definition.
     * @param buildDefinition Build definition object.
     * @param definitionRequestConfiguration Consumer of query parameters to clone the definition if exists.
     * @throws AzDException Default Api Exception handler.
     * @return build definition {@link BuildDefinition}
     */
    public CompletableFuture<BuildDefinition> createAsync(BuildDefinition buildDefinition,
                                                          Consumer<DefinitionRequestConfiguration> definitionRequestConfiguration) throws AzDException {
        var reqInfo = toPostRequestInformation(buildDefinition);
        if (definitionRequestConfiguration != null) {
            final var config = new DefinitionRequestConfiguration();
            definitionRequestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.definitionQueryParameters);
        }

        return requestAdapter.sendAsync(reqInfo, BuildDefinition.class);
    }

    /***
     * Deletes a definition and all associated builds.
     * @param definitionId pass the definition id
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(int definitionId) throws AzDException {
        var reqInfo = toDeleteRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + definitionId;
        reqInfo.requestHeaders.add(CustomHeader.JSON_CONTENT_TYPE);

        return requestAdapter.sendPrimitiveAsync(reqInfo);
    }

    /***
     * Gets a definition
     * @param definitionId pass the definition id
     * @param requestConfiguration Consumer of query request parameters.
     * @throws AzDException Default Api Exception handler.
     * @return build definition {@link BuildDefinition}
     */
    public CompletableFuture<BuildDefinition> getAsync(int definitionId, Consumer<GetRequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + definitionId;

        if (requestConfiguration != null) {
            final var config = new GetRequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.sendAsync(reqInfo, BuildDefinition.class);
    }

    /***
     * Gets a definition
     * @param definitionId pass the definition id.
     * @throws AzDException Default Api Exception handler.
     * @return build definition {@link BuildDefinition}
     */
    public CompletableFuture<BuildDefinition> getAsync(int definitionId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + definitionId;

        return requestAdapter.sendAsync(reqInfo, BuildDefinition.class);
    }

    /***
     * Gets a definition revisions.
     * @param definitionId pass the definition id
     * @throws AzDException Default Api Exception handler.
     * @return build definition revisions object {@link BuildDefinitionRevisions}
     */
    public CompletableFuture<BuildDefinitionRevisions> getRevisionsAsync(int definitionId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + definitionId + "/revisions";
        reqInfo.apiVersion = ApiVersion.BUILD_DEFINITION_REVISIONS;

        return requestAdapter.sendAsync(reqInfo, BuildDefinitionRevisions.class);
    }

    /***
     * Gets a list of definitions.
     * @throws AzDException Default Api Exception handler.
     * @return build definitions object {@link BuildDefinitions}
     */
    public CompletableFuture<BuildDefinitions> listAsync() throws AzDException {
        var reqInfo = toGetRequestInformation();

        return requestAdapter.sendAsync(reqInfo, BuildDefinitions.class);
    }


    /***
     * Gets a list of definitions.
     * @param requestConfiguration Consumer of query request parameters.
     * @throws AzDException Default Api Exception handler.
     * @return build definitions object {@link BuildDefinitions}
     */
    public CompletableFuture<BuildDefinitions> listAsync(Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();

        if (requestConfiguration != null) {
            final var config = new ListRequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.sendAsync(reqInfo, BuildDefinitions.class);
    }

    /***
     * Restores a deleted definition
     * @param definitionId pass the build definition id
     * @param deleted When false, restores a deleted definition.
     * @throws AzDException Default Api Exception handler.
     * @return a {@link BuildDefinition} object
     */
    public CompletableFuture<BuildDefinition> restoreAsync(int definitionId, boolean deleted) throws AzDException {
        var reqInfo = toPatchRequestInformation(null);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + definitionId;
        reqInfo.setQueryParameter("deleted", deleted);

        return requestAdapter.sendAsync(reqInfo, BuildDefinition.class);
    }

    /***
     * Updates an existing build definition.
     * In order for this operation to succeed, the value of the "Revision" property of the request body must match the
     * existing build definition's. It is recommended that you obtain the existing build definition by using GET, modify
     * the build definition as necessary, and then submit the modified definition with PUT.
     *
     * @param definitionId pass the build definition id
     * @param buildDefinition Build definition object to update.
     * @throws AzDException Default Api Exception handler.
     * @return a {@link BuildDefinition} object
     */
    public CompletableFuture<BuildDefinition> updateAsync(int definitionId, BuildDefinition buildDefinition, Consumer<UpdateRequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toPutRequestInformation(buildDefinition);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + definitionId;

        if (requestConfiguration != null) {
            final var config = new UpdateRequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.updateQueryParameters);
        }

        return requestAdapter.sendAsync(reqInfo, BuildDefinition.class);
    }

    /***
     * Creates a new definition.
     * @param buildDefinition Build definition object.
     * @param definitionRequestConfiguration Consumer of query parameters to clone the definition if exists.
     * @throws AzDException Default Api Exception handler.
     * @return build definition {@link BuildDefinition}
     */
    public BuildDefinition create(BuildDefinition buildDefinition,
                                  Consumer<DefinitionRequestConfiguration> definitionRequestConfiguration) throws AzDException {
        var reqInfo = toPostRequestInformation(buildDefinition);
        if (definitionRequestConfiguration != null) {
            final var config = new DefinitionRequestConfiguration();
            definitionRequestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.definitionQueryParameters);
        }

        return requestAdapter.send(reqInfo, BuildDefinition.class);
    }

    /***
     * Deletes a definition and all associated builds.
     * @param definitionId pass the definition id
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(int definitionId) throws AzDException {
        var reqInfo = toDeleteRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + definitionId;
        reqInfo.requestHeaders.add(CustomHeader.JSON_CONTENT_TYPE);

        return requestAdapter.sendPrimitive(reqInfo);
    }

    /***
     * Gets a definition
     * @param definitionId pass the definition id
     * @param requestConfiguration Consumer of query request parameters.
     * @throws AzDException Default Api Exception handler.
     * @return build definition {@link BuildDefinition}
     */
    public BuildDefinition get(int definitionId, Consumer<GetRequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + definitionId;

        if (requestConfiguration != null) {
            final var config = new GetRequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.send(reqInfo, BuildDefinition.class);
    }

    /***
     * Gets a definition
     * @param definitionId pass the definition id.
     * @throws AzDException Default Api Exception handler.
     * @return build definition {@link BuildDefinition}
     */
    public BuildDefinition get(int definitionId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + definitionId;

        return requestAdapter.send(reqInfo, BuildDefinition.class);
    }

    /***
     * Gets a definition revisions.
     * @param definitionId pass the definition id
     * @throws AzDException Default Api Exception handler.
     * @return build definition revisions object {@link BuildDefinitionRevisions}
     */
    public BuildDefinitionRevisions getRevisions(int definitionId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + definitionId + "/revisions";
        reqInfo.apiVersion = ApiVersion.BUILD_DEFINITION_REVISIONS;

        return requestAdapter.send(reqInfo, BuildDefinitionRevisions.class);
    }

    /***
     * Gets a list of definitions.
     * @throws AzDException Default Api Exception handler.
     * @return build definitions object {@link BuildDefinitions}
     */
    public BuildDefinitions list() throws AzDException {
        var reqInfo = toGetRequestInformation();

        return requestAdapter.send(reqInfo, BuildDefinitions.class);
    }


    /***
     * Gets a list of definitions.
     * @param requestConfiguration Consumer of query request parameters.
     * @throws AzDException Default Api Exception handler.
     * @return build definitions object {@link BuildDefinitions}
     */
    public BuildDefinitions list(Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();

        if (requestConfiguration != null) {
            final var config = new ListRequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.send(reqInfo, BuildDefinitions.class);
    }

    /***
     * Restores a deleted definition
     * @param definitionId pass the build definition id
     * @param deleted When false, restores a deleted definition.
     * @throws AzDException Default Api Exception handler.
     * @return a {@link BuildDefinition} object
     */
    public BuildDefinition restore(int definitionId, boolean deleted) throws AzDException {
        var reqInfo = toPatchRequestInformation(null);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + definitionId;
        reqInfo.setQueryParameter("deleted", deleted);

        return requestAdapter.send(reqInfo, BuildDefinition.class);
    }

    /***
     * Updates an existing build definition.
     * In order for this operation to succeed, the value of the "Revision" property of the request body must match the
     * existing build definition's. It is recommended that you obtain the existing build definition by using GET, modify
     * the build definition as necessary, and then submit the modified definition with PUT.
     *
     * @param definitionId pass the build definition id
     * @param buildDefinition Build definition object to update.
     * @throws AzDException Default Api Exception handler.
     * @return a {@link BuildDefinition} object
     */
    public BuildDefinition update(int definitionId, BuildDefinition buildDefinition, Consumer<UpdateRequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toPutRequestInformation(buildDefinition);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + definitionId;

        if (requestConfiguration != null) {
            final var config = new UpdateRequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.updateQueryParameters);
        }

        return requestAdapter.send(reqInfo, BuildDefinition.class);
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
        public Number revision;
    }

    public static class GetRequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

    public static class ListQueryParameters {
        /**
         * The maximum number of definitions to return.
         */
        @QueryParameter(name = "$top")
        public Number top;
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
        public String definitionIds;
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
