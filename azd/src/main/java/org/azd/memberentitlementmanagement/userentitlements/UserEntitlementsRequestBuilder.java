package org.azd.memberentitlementmanagement.userentitlements;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.common.types.JsonPatchDocument;
import org.azd.enums.CustomHeader;
import org.azd.enums.UserEntitlementProperty;
import org.azd.exceptions.AzDException;
import org.azd.memberentitlementmanagement.types.PagedGraphMemberList;
import org.azd.memberentitlementmanagement.types.UserEntitlement;
import org.azd.memberentitlementmanagement.types.UserEntitlementOperationReference;
import org.azd.memberentitlementmanagement.types.UserEntitlementsResponse;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with User entitlements Api.
 */
public class UserEntitlementsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public UserEntitlementsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "memberEntitlementManagement", "387f832c-dbf2-4643-88e9-c1aa94dbb737",
                ApiVersion.USER_ENTITLEMENTS);
    }

    /**
     * Add a user, assign license and extensions and make them a member of a project group in an account.
     *
     * @param userEntitlement User entitlement object {@link UserEntitlement}
     * @return User entitlements response object {@link UserEntitlementsResponse}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<UserEntitlementsResponse> addAsync(UserEntitlement userEntitlement) throws AzDException {
        return builder()
                .POST(userEntitlement)
                .build()
                .executeAsync(UserEntitlementsResponse.class);
    }

    /**
     * Delete a user from the account.
     * <p>
     * The delete operation includes un-assigning Extensions and Licenses and removing the user from all project
     * memberships. The user would continue to have access to the account if she is member of an AAD group,
     * that is added directly to the account.
     *
     * @param userId ID of the user.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<Void> deleteAsync(String userId) throws AzDException {
        return builder()
                .DELETE()
                .location("8480c6eb-ce60-47e9-88df-eca3c801638b")
                .serviceEndpoint("userId", userId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get User Entitlement for a user.
     *
     * @param userId ID of the user.
     * @return User entitlement object {@link UserEntitlement}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<UserEntitlement> getAsync(String userId) throws AzDException {
        return builder()
                .location("8480c6eb-ce60-47e9-88df-eca3c801638b")
                .serviceEndpoint("userId", userId)
                .build()
                .executeAsync(UserEntitlement.class);
    }

    /**
     * Get a paged set of user entitlements matching the filter and sort criteria built with properties that match the select input.
     *
     * @return Paged list of members {@link PagedGraphMemberList}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<PagedGraphMemberList> searchAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(PagedGraphMemberList.class);
    }

    /**
     * Get a paged set of user entitlements matching the filter and sort criteria built with properties that match the select input.
     *
     * @param requestConfiguration Consumer of request configuration that represents the query parameters.
     * @return Paged list of members {@link PagedGraphMemberList}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<PagedGraphMemberList> searchAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(PagedGraphMemberList.class);
    }

    /**
     * Edit the entitlements (License, Extensions, Projects, Teams etc) for a user.
     *
     * @param userId            ID of the user.
     * @param jsonPatchDocument Request body to update parameters.
     * @return User entitlement response object {@link UserEntitlementsResponse}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<UserEntitlementsResponse> updateAsync(String userId, List<JsonPatchDocument> jsonPatchDocument) throws AzDException {
        return builder()
                .PATCH(jsonPatchDocument)
                .location("8480c6eb-ce60-47e9-88df-eca3c801638b")
                .serviceEndpoint("userId", userId)
                .header(CustomHeader.JSON_PATCH)
                .build()
                .executeAsync(UserEntitlementsResponse.class);
    }

    /**
     * Edit the entitlements (License, Extensions, Projects, Teams etc) for one or more users.
     *
     * @param jsonPatchDocument          Collection of patch objects to update
     * @param doNotSendInviteForNewUsers Whether to send email invites to new users or not
     * @return User entitlement operation reference {@link UserEntitlementOperationReference}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<UserEntitlementOperationReference> updateAsync(List<JsonPatchDocument> jsonPatchDocument,
                                                                            boolean doNotSendInviteForNewUsers) throws AzDException {
        return builder()
                .PATCH(jsonPatchDocument)
                .query("doNotSendInviteForNewUsers", doNotSendInviteForNewUsers)
                .header(CustomHeader.JSON_PATCH)
                .build()
                .executeAsync(UserEntitlementOperationReference.class);
    }

    /**
     * Add a user, assign license and extensions and make them a member of a project group in an account.
     *
     * @param userEntitlement User entitlement object {@link UserEntitlement}
     * @return User entitlements response object {@link UserEntitlementsResponse}
     * @throws AzDException Default Api exception handler.
     */
    public UserEntitlementsResponse add(UserEntitlement userEntitlement) throws AzDException {
        return builder()
                .POST(userEntitlement)
                .build()
                .execute(UserEntitlementsResponse.class);
    }

    /**
     * Delete a user from the account.
     * <p>
     * The delete operation includes un-assigning Extensions and Licenses and removing the user from all project
     * memberships. The user would continue to have access to the account if she is member of an AAD group,
     * that is added directly to the account.
     *
     * @param userId ID of the user.
     * @throws AzDException Default Api exception handler.
     */
    public Void delete(String userId) throws AzDException {
        return builder()
                .DELETE()
                .location("8480c6eb-ce60-47e9-88df-eca3c801638b")
                .serviceEndpoint("userId", userId)
                .build()
                .executePrimitive();
    }

    /**
     * Get User Entitlement for a user.
     *
     * @param userId ID of the user.
     * @return User entitlement object {@link UserEntitlement}
     * @throws AzDException Default Api exception handler.
     */
    public UserEntitlement get(String userId) throws AzDException {
        return builder()
                .location("8480c6eb-ce60-47e9-88df-eca3c801638b")
                .serviceEndpoint("userId", userId)
                .build()
                .execute(UserEntitlement.class);
    }

    /**
     * Get a paged set of user entitlements matching the filter and sort criteria built with properties that match the select input.
     *
     * @return Paged list of members {@link PagedGraphMemberList}
     * @throws AzDException Default Api exception handler.
     */
    public PagedGraphMemberList search() throws AzDException {
        return builder()
                .build()
                .execute(PagedGraphMemberList.class);
    }

    /**
     * Get a paged set of user entitlements matching the filter and sort criteria built with properties that match the select input.
     *
     * @param requestConfiguration Consumer of request configuration that represents the query parameters.
     * @return Paged list of members {@link PagedGraphMemberList}
     * * @throws AzDException Default Api exception handler.
     */
    public PagedGraphMemberList search(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(PagedGraphMemberList.class);
    }

    /**
     * Edit the entitlements (License, Extensions, Projects, Teams etc) for a user.
     *
     * @param userId            ID of the user.
     * @param jsonPatchDocument Request body to update parameters.
     * @return User entitlement response object {@link UserEntitlementsResponse}
     * @throws AzDException Default Api exception handler.
     */
    public UserEntitlementsResponse update(String userId, List<JsonPatchDocument> jsonPatchDocument) throws AzDException {
        return builder()
                .PATCH(jsonPatchDocument)
                .location("8480c6eb-ce60-47e9-88df-eca3c801638b")
                .serviceEndpoint("userId", userId)
                .header(CustomHeader.JSON_PATCH)
                .build()
                .execute(UserEntitlementsResponse.class);
    }

    /**
     * Edit the entitlements (License, Extensions, Projects, Teams etc) for one or more users.
     *
     * @param jsonPatchDocument          Collection of patch objects to update
     * @param doNotSendInviteForNewUsers Whether to send email invites to new users or not
     * @return User entitlement operation reference {@link UserEntitlementOperationReference}
     * @throws AzDException Default Api exception handler.
     */
    public UserEntitlementOperationReference update(List<JsonPatchDocument> jsonPatchDocument,
                                                    boolean doNotSendInviteForNewUsers) throws AzDException {
        return builder()
                .PATCH(jsonPatchDocument)
                .query("doNotSendInviteForNewUsers", doNotSendInviteForNewUsers)
                .header(CustomHeader.JSON_PATCH)
                .build()
                .execute(UserEntitlementOperationReference.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Continuation token for getting the next page of data set. If null is passed, gets the first page.
         */
        @QueryParameter(name = "continuationToken")
        public String continuationToken;
        /**
         * Equality operators relating to searching user entitlements seperated by and clauses. Valid filters include:
         * licenseId, licenseStatus, userType, and name. licenseId: filters based on license assignment using
         * license names. i.e. licenseId eq 'Account-Stakeholder' or licenseId eq 'Account-Express'. licenseStatus:
         * filters based on license status. currently only supports disabled. i.e. licenseStatus eq 'Disabled'.
         * To get disabled basic licenses, you would pass (licenseId eq 'Account-Express' and licenseStatus eq 'Disabled')
         * userType: filters off identity type. Suppored types are member or guest i.e. userType eq 'member'.
         * name: filters on if the user's display name or email contians given input. i.e. get all users with "test"
         * in email or displayname is "name eq 'test'". A valid query could be:
         * (licenseId eq 'Account-Stakeholder' or (licenseId eq 'Account-Express' and licenseStatus eq 'Disabled'))
         * and name eq 'test' and userType eq 'guest'.
         */
        @QueryParameter(name = "$filter")
        public String filter;
        /**
         * PropertyName and Order (separated by a space ( )) to sort on (e.g. lastAccessed desc). Order defaults to
         * ascending. valid properties to order by are dateCreated, lastAccessed, and name
         */
        @QueryParameter(name = "$orderBy")
        public String orderBy;
        /**
         * Comma (",") separated list of properties to select in the result entitlements. names of the
         * properties are - 'Projects, 'Extensions' and 'Grouprules'.
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
