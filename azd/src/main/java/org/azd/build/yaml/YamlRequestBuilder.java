package org.azd.build.yaml;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.build.types.YamlBuild;
import org.azd.exceptions.AzDException;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Build Yaml Api.
 */
public class YamlRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public YamlRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "build", "7c3df3a1-7e51-4150-8cf7-540347f8697f");
    }

    /**
     * Converts a definition to YAML.
     *
     * @param definitionId The ID of the definition.
     * @return Yaml build object {@link YamlBuild}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<YamlBuild> getAsync(int definitionId) throws AzDException {
        return builder()
                .serviceEndpoint("definitionId", definitionId)
                .build()
                .executeAsync(YamlBuild.class);
    }

    /**
     * Converts a definition to YAML.
     *
     * @param definitionId         The ID of the definition.
     * @param requestConfiguration Consumer of query parameters to filter.
     * @return Yaml build object {@link YamlBuild}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<YamlBuild> getAsync(int definitionId,
                                                 Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("definitionId", definitionId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(YamlBuild.class);
    }

    /**
     * Converts a definition to YAML.
     *
     * @param definitionId The ID of the definition.
     * @return Yaml build object {@link YamlBuild}
     * @throws AzDException Default Api Exception handler.
     */
    public YamlBuild get(int definitionId) throws AzDException {
        return builder()
                .serviceEndpoint("definitionId", definitionId)
                .build()
                .execute(YamlBuild.class);
    }

    /**
     * Converts a definition to YAML.
     *
     * @param definitionId         The ID of the definition.
     * @param requestConfiguration Consumer of query parameters to filter.
     * @return Yaml build object {@link YamlBuild}
     * @throws AzDException Default Api Exception handler.
     */
    public YamlBuild get(int definitionId,
                         Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("definitionId", definitionId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(YamlBuild.class);
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
        public String propertyFilters;
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
