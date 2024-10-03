package org.azd.memberentitlementmanagement.memberentitlements;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.UserEntitlementProperty;
import org.azd.exceptions.AzDException;
import org.azd.memberentitlementmanagement.types.SearchMemberEntitlement;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Search Member Entitlements Api.
 */
public class MemberEntitlementsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public MemberEntitlementsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "memberEntitlementManagement", "1e8cabfb-1fda-461e-860f-eeeae54d06bb",
                ApiVersion.SEARCH_MEMBER_ENTITLEMENTS);
    }

    /**
     * Search member entitlements and get a paginated response.
     *
     * @return Search member entitlement object {@link SearchMemberEntitlement}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<SearchMemberEntitlement> searchAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(SearchMemberEntitlement.class);
    }

    /**
     * Search member entitlements and get a paginated response.
     *
     * @param requestConfiguration Consumer of request configuration that represents the query parameters.
     * @return Search member entitlement object {@link SearchMemberEntitlement}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<SearchMemberEntitlement> searchAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(SearchMemberEntitlement.class);
    }

    /**
     * Search member entitlements and get a paginated response.
     *
     * @return Search member entitlement object {@link SearchMemberEntitlement}
     * @throws AzDException Default Api exception handler.
     */
    public SearchMemberEntitlement search() throws AzDException {
        return builder()
                .build()
                .execute(SearchMemberEntitlement.class);
    }

    /**
     * Search member entitlements and get a paginated response.
     *
     * @param requestConfiguration Consumer of request configuration that represents the query parameters.
     * @return Search member entitlement object {@link SearchMemberEntitlement}
     * @throws AzDException Default Api exception handler.
     */
    public SearchMemberEntitlement search(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(SearchMemberEntitlement.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Pass the continuation token to get the next page results.
         */
        @QueryParameter(name = "continuationToken")
        public String continuationToken;
        /**
         * Values to filter
         */
        @QueryParameter(name = "$filter")
        public String filter;
        /**
         * Sort
         */
        @QueryParameter(name = "$orderBy")
        public String orderBy;
        /**
         * Values to select
         */
        @QueryParameter(name = "select")
        public UserEntitlementProperty select;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}
