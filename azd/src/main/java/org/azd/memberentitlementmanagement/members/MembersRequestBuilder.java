package org.azd.memberentitlementmanagement.members;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.memberentitlementmanagement.types.PagedGraphMemberList;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Members Api.
 */
public class MembersRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public MembersRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "memberEntitlementManagement", "45a36e53-5286-4518-aa72-2d29f7acc5d8",
                ApiVersion.MEMBERSHIP_ENTITLEMENT_MANAGEMENT_MEMBERS);
    }

    /**
     * Add a member to a Group.
     *
     * @param groupId  Id of the Group.
     * @param memberId Id of the member to add.
     * @throws AzDException Default Api exception handler
     */
    public CompletableFuture<Void> addAsync(String groupId, String memberId) throws AzDException {
        return builder()
                .PUT(null)
                .serviceEndpoint("groupId", groupId)
                .serviceEndpoint("memberId", memberId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get direct members of a Group.
     *
     * @param groupId Id of the Group.
     * @return Collection of graph member. {@link PagedGraphMemberList}
     * @throws AzDException Default Api exception handler
     */
    public CompletableFuture<PagedGraphMemberList> getAsync(String groupId) throws AzDException {
        return builder()
                .serviceEndpoint("groupId", groupId)
                .build()
                .executeAsync(PagedGraphMemberList.class);
    }

    /**
     * Get direct members of a Group.
     *
     * @param groupId              Id of the Group.
     * @param requestConfiguration Consumer of request configuration that represents the query parameters.
     * @return Collection of graph member. {@link PagedGraphMemberList}
     * @throws AzDException Default Api exception handler
     */
    public CompletableFuture<PagedGraphMemberList> getAsync(String groupId, Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("groupId", groupId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(PagedGraphMemberList.class);
    }

    /**
     * Remove a member from a Group.
     *
     * @param groupId  Id of the Group.
     * @param memberId Id of the member to add.
     * @throws AzDException Default Api exception handler
     */
    public CompletableFuture<Void> removeMemberAsync(String groupId, String memberId)
            throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("groupId", groupId)
                .serviceEndpoint("memberId", memberId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Add a member to a Group.
     *
     * @param groupId  Id of the Group.
     * @param memberId Id of the member to add.
     * @throws AzDException Default Api exception handler
     */
    public Void add(String groupId, String memberId) throws AzDException {
        return builder()
                .PUT(null)
                .serviceEndpoint("groupId", groupId)
                .serviceEndpoint("memberId", memberId)
                .build()
                .executePrimitive();
    }

    /**
     * Get direct members of a Group.
     *
     * @param groupId Id of the Group.
     * @return Collection of graph member. {@link PagedGraphMemberList}
     * @throws AzDException Default Api exception handler
     */
    public PagedGraphMemberList get(String groupId) throws AzDException {
        return builder()
                .serviceEndpoint("groupId", groupId)
                .build()
                .execute(PagedGraphMemberList.class);
    }

    /**
     * Get direct members of a Group.
     *
     * @param groupId              Id of the Group.
     * @param requestConfiguration Consumer of request configuration that represents the query parameters.
     * @return Collection of graph member. {@link PagedGraphMemberList}
     * @throws AzDException Default Api exception handler
     */
    public PagedGraphMemberList get(String groupId, Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("groupId", groupId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(PagedGraphMemberList.class);
    }

    /**
     * Remove a member from a Group.
     *
     * @param groupId  Id of the Group.
     * @param memberId Id of the member to add.
     * @throws AzDException Default Api exception handler
     */
    public Void removeMember(String groupId, String memberId)
            throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("groupId", groupId)
                .serviceEndpoint("memberId", memberId)
                .build()
                .executePrimitive();
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Maximum number of results to retrieve.
         */
        @QueryParameter(name = "maxResults")
        public Number maxResults;
        /**
         * Paging Token from the previous page fetched. If the 'pagingToken' is null,
         * the results would be fetched from the beginning of the Members List.
         */
        @QueryParameter(name = "pagingToken")
        public String pagingToken;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}
