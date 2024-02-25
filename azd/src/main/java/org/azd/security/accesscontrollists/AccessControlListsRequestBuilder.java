package org.azd.security.accesscontrollists;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.security.types.ACLs;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Security Access control lists Api.
 */
public class AccessControlListsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public AccessControlListsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "security", "18a2ad18-7571-46ae-bec7-0c7da1495885", ApiVersion.SECURITY);
    }

    /**
     * Return a list of access control lists for the specified security namespace and token. All ACLs in the security
     * namespace will be retrieved if no optional parameters are provided.
     *
     * @param securityNamespaceId  Security namespace identifier.
     * @param requestConfiguration Represents the query parameters.
     * @return Collection of Access control lists {@link ACLs}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ACLs> queryAsync(String securityNamespaceId,
                                              Consumer<QueryRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("securityNamespaceId", securityNamespaceId)
                .query(QueryRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(ACLs.class);
    }

    /**
     * Remove access control lists under the specified security namespace.
     *
     * @param securityNamespaceId  Security namespace identifier.
     * @param requestConfiguration Represents the query parameters.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Boolean> removeAsync(String securityNamespaceId,
                                                  Consumer<DeleteRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("securityNamespaceId", securityNamespaceId)
                .query(DeleteRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeStringAsync()
                .thenApplyAsync(Boolean::valueOf);
    }

    /**
     * Create or update one or more access control lists. All data that currently exists for the ACLs supplied will be overwritten.
     *
     * @param securityNamespaceId          Security namespace identifier.
     * @param setAccessControlListsRequest Request body to add or update the access control lists.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> setAsync(String securityNamespaceId, ACLs setAccessControlListsRequest) throws AzDException {
        return builder()
                .POST(setAccessControlListsRequest)
                .serviceEndpoint("securityNamespaceId", securityNamespaceId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Return a list of access control lists for the specified security namespace and token. All ACLs in the security
     * namespace will be retrieved if no optional parameters are provided.
     *
     * @param securityNamespaceId  Security namespace identifier.
     * @param requestConfiguration Represents the query parameters.
     * @return Collection of Access control lists {@link ACLs}
     * @throws AzDException Default Api exception handler.
     */
    public ACLs query(String securityNamespaceId,
                      Consumer<QueryRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("securityNamespaceId", securityNamespaceId)
                .query(QueryRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(ACLs.class);
    }

    /**
     * Remove access control lists under the specified security namespace.
     *
     * @param securityNamespaceId  Security namespace identifier.
     * @param requestConfiguration Represents the query parameters.
     * @throws AzDException Default Api Exception handler.
     */
    public Boolean remove(String securityNamespaceId,
                          Consumer<DeleteRequestConfiguration> requestConfiguration) throws AzDException {
        return Boolean.valueOf(builder()
                .DELETE()
                .serviceEndpoint("securityNamespaceId", securityNamespaceId)
                .query(DeleteRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeString());
    }

    /**
     * Create or update one or more access control lists. All data that currently exists for the ACLs supplied will be overwritten.
     *
     * @param securityNamespaceId          Security namespace identifier.
     * @param setAccessControlListsRequest Request body to add or update the access control lists.
     * @throws AzDException Default Api Exception handler.
     */
    public Void set(String securityNamespaceId, ACLs setAccessControlListsRequest) throws AzDException {
        return builder()
                .POST(setAccessControlListsRequest)
                .serviceEndpoint("securityNamespaceId", securityNamespaceId)
                .build()
                .executePrimitive();
    }

    /**
     * Represents the query parameters.
     */
    public static class QueryParameters {
        /**
         * An optional filter string containing a list of identity descriptors separated by ',' whose ACEs
         * should be retrieved. If this is left null, entire ACLs will be returned.
         */
        @QueryParameter(name = "descriptors")
        public String descriptors;
        /**
         * Security token
         */
        @QueryParameter(name = "token")
        public String token;
        /**
         * If true, populate the extended information properties for the access control entries contained in the returned lists.
         */
        @QueryParameter(name = "includeExtendedInfo")
        public Boolean includeExtendedInfo;
        /**
         * If true and this is a hierarchical namespace, return child ACLs of the specified token.
         */
        @QueryParameter(name = "recurse")
        public Boolean recurse;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class QueryRequestConfiguration {
        public QueryParameters queryParameters = new QueryParameters();
    }

    /**
     * Represents the query parameters.
     */
    public static class DeleteQueryParameters {
        /**
         * If true and this is a hierarchical namespace, also remove child ACLs of the specified tokens.
         */
        @QueryParameter(name = "recurse")
        public Boolean recurse;
        /**
         * One or more comma-separated security tokens
         */
        @QueryParameter(name = "tokens")
        public String tokens;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class DeleteRequestConfiguration {
        public DeleteQueryParameters queryParameters = new DeleteQueryParameters();
    }
}
