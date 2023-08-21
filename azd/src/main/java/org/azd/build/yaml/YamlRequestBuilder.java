package org.azd.build.yaml;

import org.azd.build.types.YamlBuild;
import org.azd.common.ApiVersion;
import org.azd.common.types.QueryParameter;
import org.azd.exceptions.AzDException;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Build Yaml Api.
 */
public class YamlRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public YamlRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "build/definitions", ApiVersion.BUILD_YAML);
    }

    /**
     * Converts a definition to YAML.
     * @param definitionId The ID of the definition.
     * @return Yaml build object {@link YamlBuild}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<YamlBuild> get(int definitionId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + definitionId + "/yaml";

        return requestAdapter.sendAsync(reqInfo, YamlBuild.class);
    }

    /**
     * Converts a definition to YAML.
     * @param definitionId The ID of the definition.
     * @param requestConfiguration Consumer of query parameters to filter.
     * @return Yaml build object {@link YamlBuild}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<YamlBuild> get(int definitionId, Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + definitionId + "/yaml";

        if (requestConfiguration != null) {
            final var config = new RequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.sendAsync(reqInfo, YamlBuild.class);
    }

    public static class GetQueryParameters {
        /**
         * If true includes the latest builds.
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

    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}
