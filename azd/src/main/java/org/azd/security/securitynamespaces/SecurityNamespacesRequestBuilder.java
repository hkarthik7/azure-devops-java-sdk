package org.azd.security.securitynamespaces;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.security.types.SecurityNamespaces;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Security Api.
 */
public class SecurityNamespacesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public SecurityNamespacesRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "security", "ce7b9f95-fde9-4be8-a86d-83b366f0b87a", ApiVersion.SECURITY);
    }

    /**
     * List all security namespaces or just the specified namespace.
     *
     * @param securityNamespaceId Security namespace identifier.
     * @param localOnly           If true, retrieve only local security namespaces.
     * @return Collection of Security name spaces {@link SecurityNamespaces}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<SecurityNamespaces> queryAsync(String securityNamespaceId, boolean localOnly) throws AzDException {

        return builder()
                .serviceEndpoint("securityNamespaceId", securityNamespaceId)
                .query("localOnly", localOnly)
                .build()
                .executeAsync(SecurityNamespaces.class);
    }

    /**
     * List all security namespaces or just the specified namespace.
     *
     * @param securityNamespaceId Security namespace identifier.
     * @param localOnly           If true, retrieve only local security namespaces.
     * @return Collection of Security name spaces {@link SecurityNamespaces}
     * @throws AzDException Default Api exception handler.
     */
    public SecurityNamespaces query(String securityNamespaceId, boolean localOnly) throws AzDException {

        return builder()
                .serviceEndpoint("securityNamespaceId", securityNamespaceId)
                .query("localOnly", localOnly)
                .build()
                .execute(SecurityNamespaces.class);
    }
}
