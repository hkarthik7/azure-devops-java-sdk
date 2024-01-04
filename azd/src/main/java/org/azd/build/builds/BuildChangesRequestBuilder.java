package org.azd.build.builds;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.build.types.BuildChanges;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides the functionality to manage Build Changes Api.
 */
public class BuildChangesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public BuildChangesRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "build", "54572c7b-bbd3-45d4-80dc-28be08941620", ApiVersion.BUILD_CHANGES);
    }

    /**
     * Gets the changes associated with a build
     *
     * @param buildId ID of the build.
     * @return Future object of BuildChanges {@link BuildChanges}
     * @throws AzDException Default Api exception handler
     */
    public CompletableFuture<BuildChanges> getAsync(int buildId) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .build()
                .executeAsync(BuildChanges.class);
    }

    /**
     * Gets the changes associated with a build
     *
     * @param buildId              ID of the build.
     * @param requestConfiguration Consumer of request configuration object.
     * @return Future object of BuildChanges {@link BuildChanges}
     * @throws AzDException Default Api exception handler
     */
    public CompletableFuture<BuildChanges> getAsync(int buildId,
                                                    Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(BuildChanges.class);
    }

    /***
     * Gets the changes made to the repository between two given builds.
     * @param requestConfiguration Consumer of request configuration object.
     * @return BuildChanges future object {@link BuildChanges}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildChanges> listAsync(Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .location("f10f0ea5-18a1-43ec-a8fb-2042c7be9b43")
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(BuildChanges.class);
    }

    /**
     * Gets the changes associated with a build
     *
     * @param buildId ID of the build.
     * @return Future object of BuildChanges {@link BuildChanges}
     * @throws AzDException Default Api exception handler
     */
    public BuildChanges get(int buildId) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .build()
                .execute(BuildChanges.class);
    }

    /**
     * Gets the changes associated with a build
     *
     * @param buildId              ID of the build.
     * @param requestConfiguration Consumer of request configuration object.
     * @return Future object of BuildChanges {@link BuildChanges}
     * @throws AzDException Default Api exception handler
     */
    public BuildChanges get(int buildId,
                            Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(BuildChanges.class);
    }

    /***
     * Gets the changes made to the repository between two given builds.
     * @param requestConfiguration Consumer of request configuration object.
     * @return BuildChanges future object {@link BuildChanges}
     * @throws AzDException Default Api Exception handler.
     */
    public BuildChanges list(Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .location("f10f0ea5-18a1-43ec-a8fb-2042c7be9b43")
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(BuildChanges.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * From build id to get build changes.
         */
        @QueryParameter(name = "fromBuildId")
        public int fromBuildId;
        /**
         * To build id to get changes between builds.
         */
        @QueryParameter(name = "toBuildId")
        public int toBuildId;
        /**
         * Specify to return top changes between builds.
         */
        @QueryParameter(name = "$top")
        public Number top;
        /**
         * Continuation token to return the paginated response.
         */
        @QueryParameter(name = "continuationToken")
        public String continuationToken;
        /**
         * True to include the source build changes.
         */
        @QueryParameter(name = "includeSourceChange")
        public Boolean includeSourceChange;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}
