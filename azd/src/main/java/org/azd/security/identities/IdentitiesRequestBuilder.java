package org.azd.security.identities;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.QueryMembership;
import org.azd.exceptions.AzDException;
import org.azd.security.types.Identities;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Identities API to find the legacy identity descriptors for users and groups.
 * Identities can be searched for by name, email, id, identity descriptor, and subject descriptor.
 */
public class IdentitiesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public IdentitiesRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "IMS", "28010c54-d0c0-4c89-a5b0-1c9e188b9fb7", ApiVersion.IDENTITY);
    }

    /**
     * Resolve legacy identity information for use with older APIs such as the Security APIs
     * @param requestConfiguration Consumer of request configuration that represents query parameters.
     * @return Identities object {@link Identities}
     * @throws AzDException Default API exception handler.
     */
    public CompletableFuture<Identities> readAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(Identities.class);

    }

    /**
     * Resolve legacy identity information for use with older APIs such as the Security APIs
     * @param requestConfiguration Consumer of request configuration that represents query parameters.
     * @return Identities object {@link Identities}
     * @throws AzDException Default API exception handler.
     */
    public Identities read(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(Identities.class);

    }

    /**
     * Represents the query parameters.
     */
    public static class QueryParameters {
        /**
         * A comma separated list of identity descriptors to resolve
         */
        @QueryParameter(name = "descriptors")
        public String[] descriptors;
        /**
         * The search value, as specified by the searchFilter.
         */
        @QueryParameter(name = "filterValue")
        public String filterValue;
        /**
         * A comma separated list of storage keys to resolve
         */
        @QueryParameter(name = "identityIds")
        public String[] identityIds;
        /**
         * The membership information to include with the identities. Values can be None
         * for no membership data or Direct to include the groups that the identity is a
         * member of and the identities that are a member of this identity (groups only)
         */
        @QueryParameter(name = "queryMembership")
        public QueryMembership queryMembership;
        /**
         * The type of search to perform. Values can be AccountName (domain\alias), DisplayName,
         * MailAddress, General (display name, account name, or unique name), or
         * LocalGroupName (only search Azure Devops groups).
         */
        @QueryParameter(name = "searchFilter")
        public String searchFilter;
        /**
         * A comma separated list of subject descriptors to resolve
         */
        @QueryParameter(name = "subjectDescriptors")
        public String[] subjectDescriptors;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public QueryParameters queryParameters = new QueryParameters();
    }
}
