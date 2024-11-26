package org.azd.build.authorizedresources;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.build.types.DefinitionResourceReference;
import org.azd.build.types.DefinitionResourceReferences;
import org.azd.exceptions.AzDException;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides the functionality to manage Build Authorized resources Api.
 */
public class AuthorizedResourcesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public AuthorizedResourcesRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "build", "398c85bc-81aa-4822-947c-a194a05f0fef");
    }

    /**
     * Authorize Project Resources.
     *
     * @param definitionResourceReferences Collection of DefinitionResourceReference.
     * @return A future object of collection of DefinitionResourceReference {@link DefinitionResourceReferences}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<DefinitionResourceReferences> authorizeAsync(
            List<DefinitionResourceReference> definitionResourceReferences) throws AzDException {
        return builder()
                .PATCH(definitionResourceReferences)
                .build()
                .executeAsync(DefinitionResourceReferences.class);
    }

    /**
     * Get a collection of Authorize Project Resources.
     *
     * @return A future object of collection of DefinitionResourceReference {@link DefinitionResourceReferences}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<DefinitionResourceReferences> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(DefinitionResourceReferences.class);
    }

    /**
     * Get a collection of Authorize Project Resources.
     *
     * @param requestConfiguration Consumer of request configuration that represents the query parameters.
     * @return Collection of DefinitionResourceReference {@link DefinitionResourceReferences}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<DefinitionResourceReferences> listAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(DefinitionResourceReferences.class);
    }

    /**
     * Authorize Project Resources.
     *
     * @param definitionResourceReferences Collection of DefinitionResourceReference.
     * @return A future object of collection of DefinitionResourceReference {@link DefinitionResourceReferences}
     * @throws AzDException Default Api exception handler.
     */
    public DefinitionResourceReferences authorize(
            List<DefinitionResourceReference> definitionResourceReferences) throws AzDException {
        return builder()
                .PATCH(definitionResourceReferences)
                .build()
                .execute(DefinitionResourceReferences.class);
    }

    /**
     * Get a collection of Authorize Project Resources.
     *
     * @return A future object of collection of DefinitionResourceReference {@link DefinitionResourceReferences}
     * @throws AzDException Default Api exception handler.
     */
    public DefinitionResourceReferences list() throws AzDException {
        return builder()
                .build()
                .execute(DefinitionResourceReferences.class);
    }

    /**
     * Get a collection of Authorize Project Resources.
     *
     * @param requestConfiguration Consumer of request configuration that represents the query parameters.
     * @return Collection of DefinitionResourceReference {@link DefinitionResourceReferences}
     * @throws AzDException Default Api exception handler.
     */
    public DefinitionResourceReferences list(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(DefinitionResourceReferences.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Type of the authorized resource.
         */
        @QueryParameter(name = "type")
        public String type;
        /**
         * ID of the authorized resource.
         */
        @QueryParameter(name = "id")
        public String id;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}
