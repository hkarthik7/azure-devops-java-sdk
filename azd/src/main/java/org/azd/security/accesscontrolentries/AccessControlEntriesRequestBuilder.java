package org.azd.security.accesscontrolentries;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.security.types.ACEs;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Security Access control entries Api.
 */
public class AccessControlEntriesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public AccessControlEntriesRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "security", "ac08c8ff-4323-4b08-af90-bcd018d380ce", ApiVersion.SECURITY);
    }

    /**
     * Remove the specified ACEs from the ACL belonging to the specified token.
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
     * Add or update ACEs in the ACL for the provided token. The request body contains the target token, a list of ACEs
     * and a optional merge parameter. In the case of a collision (by identity descriptor) with an existing ACE in
     * the ACL, the "merge" parameter determines the behavior. If set, the existing ACE has its allow and deny merged
     * with the incoming ACE's allow and deny. If unset, the existing ACE is displaced.
     *
     * @param securityNamespaceId          Security namespace identifier.
     * @param setAccessControlEntryRequest Request body to add or update the access control entries.
     * @return Collection of access control entry {@link ACEs}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ACEs> setAsync(String securityNamespaceId,
                                            ACEs setAccessControlEntryRequest)
            throws AzDException {
        return builder()
                .POST(setAccessControlEntryRequest)
                .serviceEndpoint("securityNamespaceId", securityNamespaceId)
                .build()
                .executeAsync(ACEs.class);
    }

    /**
     * Remove the specified ACEs from the ACL belonging to the specified token.
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
     * Add or update ACEs in the ACL for the provided token. The request body contains the target token, a list of ACEs
     * and a optional merge parameter. In the case of a collision (by identity descriptor) with an existing ACE in
     * the ACL, the "merge" parameter determines the behavior. If set, the existing ACE has its allow and deny merged
     * with the incoming ACE's allow and deny. If unset, the existing ACE is displaced.
     *
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/security/access-control-entries/set-access-control-entries?view=azure-devops-rest-7.1&tabs=HTTP#merge">Example</a>
     * @param securityNamespaceId          Security namespace identifier.
     * @param setAccessControlEntryRequest Request body to add or update the access control entries.
     * @return Collection of access control entry {@link ACEs}
     * @throws AzDException Default Api Exception handler.
     */
    public ACEs set(String securityNamespaceId, ACEs setAccessControlEntryRequest) throws AzDException {
        return builder()
                .POST(setAccessControlEntryRequest)
                .serviceEndpoint("securityNamespaceId", securityNamespaceId)
                .build()
                .execute(ACEs.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class DeleteQueryParameters {
        /**
         * String containing a list of identity descriptors separated by ',' whose entries should be removed.
         */
        @QueryParameter(name = "descriptors")
        public String[] descriptors;
        /**
         * The token whose ACL should be modified.
         */
        @QueryParameter(name = "token")
        public String token;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class DeleteRequestConfiguration {
        public DeleteQueryParameters queryParameters = new DeleteQueryParameters();
    }
}
