package org.azd.graph.users;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.graph.types.*;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Graph Users Api.
 */
public class UsersRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public UsersRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "graph", "005e26ec-6b77-4e4f-a986-b3827bf241f5", ApiVersion.GRAPH);
    }

    /**
     * Materialize an existing AAD or MSA user into the ADO account.
     * <p>
     * <br/><br/><strong>NOTE:</strong> Created users are not active in an account unless they have been explicitly assigned a parent group at
     * creation time or have signed in and been autolicensed through AAD group memberships.
     * <p>
     * <br/><br/>Adding a user to an account is required before the user can be added to ADO groups or assigned an asset.
     * <p>
     * <br/><br/>The body of the request must be a derived type of GraphUserCreationContext:
     * <p>
     * <br/><br/>GraphUserMailAddressCreationContext - Create a new user using the mail address as a reference to an existing user
     * from an external AD or AAD backed provider.
     * <br/><br/>GraphUserOriginIdCreationContext - Create a new user using the OriginID as a reference to an existing user from
     * an external AD or AAD backed provider.
     * <br/><br/>GraphUserPrincipalNameCreationContext - Create a new user using the principal name as a reference to an
     * existing user from an external AD or AAD backed provider.
     * <br/><br/>If the user to be added corresponds to a user that was previously deleted, then that user will be restored.
     * <p>
     * <br/><br/>Optionally, you can add the newly created user as a member of an existing ADO group and/or specify a custom storage key for the user.
     *
     * @param creationContext graph user creation context object to create a user.
     * @return Graph user object {@link GraphUser}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GraphUser> createAsync(GraphUserCreationContext creationContext) throws AzDException {
        return builder()
                .POST(creationContext)
                .build()
                .executeAsync(GraphUser.class);
    }

    /**
     * Materialize an existing AAD or MSA user into the ADO account.
     * <p>
     * <br/><br/><strong>NOTE:</strong> Created users are not active in an account unless they have been explicitly assigned a parent group at
     * creation time or have signed in and been autolicensed through AAD group memberships.
     * <p>
     * <br/><br/>Adding a user to an account is required before the user can be added to ADO groups or assigned an asset.
     * <p>
     * <br/><br/>The body of the request must be a derived type of GraphUserCreationContext:
     * <p>
     * <br/><br/>GraphUserMailAddressCreationContext - Create a new user using the mail address as a reference to an existing user
     * from an external AD or AAD backed provider.
     * <br/><br/>GraphUserOriginIdCreationContext - Create a new user using the OriginID as a reference to an existing user from
     * an external AD or AAD backed provider.
     * <br/><br/>GraphUserPrincipalNameCreationContext - Create a new user using the principal name as a reference to an
     * existing user from an external AD or AAD backed provider.
     * <br/><br/>If the user to be added corresponds to a user that was previously deleted, then that user will be restored.
     * <p>
     * <br/><br/>Optionally, you can add the newly created user as a member of an existing ADO group and/or specify a custom storage key for the user.
     *
     * @param creationContext      graph user creation context object to create a user.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Graph user object {@link GraphUser}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GraphUser> createAsync(GraphUserCreationContext creationContext,
                                                    Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .POST(creationContext)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(GraphUser.class);
    }

    /**
     * The user will still be visible, but membership checks for the user will return false.
     *
     * @param userDescriptor The descriptor of the user to delete.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<Void> deleteAsync(String userDescriptor) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("userDescriptor", userDescriptor)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get a user by its descriptor.
     *
     * @param userDescriptor The descriptor of the user to delete.
     * @return Graph user object {@link GraphUser}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GraphUser> getAsync(String userDescriptor) throws AzDException {
        return builder()
                .serviceEndpoint("userDescriptor", userDescriptor)
                .build()
                .executeAsync(GraphUser.class);
    }

    /**
     * Get a list of all users in a given scope.
     * <p>
     * Since the list of users may be large, results are returned in pages of users.
     * If there are more results than can be returned in a single page, the result set will contain a
     * continuation token for retrieval of the next set of results.
     *
     * @return Collection of graph user as a paged response. Use getNextPageLink() to get the next page.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GraphUsers> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(GraphUsers.class);
    }

    /**
     * Get a list of all users in a given scope.
     * <p>
     * Since the list of users may be large, results are returned in pages of users.
     * If there are more results than can be returned in a single page, the result set will contain a
     * continuation token for retrieval of the next set of results.
     *
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Collection of graph user as a paged response. Use getNextPageLink() to get the next page.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GraphUsers> listAsync(Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(GraphUsers.class);
    }

    /**
     * Map an existing user to a different user.
     *
     * <br />The body of the request must be a derived type of {@link GraphUserUpdateContext}:
     *
     * <br /><br />{@link GraphUserOriginIdUpdateContext} - Map an existing user in an account, to an existing user from an external
     * AD or AAD backed provider using the OriginId as a reference.
     *
     * @param updateContext origin id and optionally storage key to update.
     * @param userDescriptor The descriptor of the user to update
     * @return Graph user object {@link GraphUser}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GraphUser> updateAsync(GraphUserUpdateContext updateContext, String userDescriptor) throws AzDException {
        return builder()
                .PATCH(updateContext)
                .serviceEndpoint("userDescriptor", userDescriptor)
                .build()
                .executeAsync(GraphUser.class);
    }

    /**
     * Materialize an existing AAD or MSA user into the ADO account.
     * <p>
     * <br/><br/><strong>NOTE:</strong> Created users are not active in an account unless they have been explicitly assigned a parent group at
     * creation time or have signed in and been autolicensed through AAD group memberships.
     * <p>
     * <br/><br/>Adding a user to an account is required before the user can be added to ADO groups or assigned an asset.
     * <p>
     * <br/><br/>The body of the request must be a derived type of GraphUserCreationContext:
     * <p>
     * <br/><br/>GraphUserMailAddressCreationContext - Create a new user using the mail address as a reference to an existing user
     * from an external AD or AAD backed provider.
     * <br/><br/>GraphUserOriginIdCreationContext - Create a new user using the OriginID as a reference to an existing user from
     * an external AD or AAD backed provider.
     * <br/><br/>GraphUserPrincipalNameCreationContext - Create a new user using the principal name as a reference to an
     * existing user from an external AD or AAD backed provider.
     * <br/><br/>If the user to be added corresponds to a user that was previously deleted, then that user will be restored.
     * <p>
     * <br/><br/>Optionally, you can add the newly created user as a member of an existing ADO group and/or specify a custom storage key for the user.
     *
     * @param creationContext graph user creation context object to create a user.
     * @return Graph user object {@link GraphUser}
     * @throws AzDException Default Api exception handler.
     */
    public GraphUser create(GraphUserCreationContext creationContext) throws AzDException {
        return builder()
                .POST(creationContext)
                .build()
                .execute(GraphUser.class);
    }

    /**
     * Materialize an existing AAD or MSA user into the ADO account.
     * <p>
     * <br/><br/><strong>NOTE:</strong> Created users are not active in an account unless they have been explicitly assigned a parent group at
     * creation time or have signed in and been autolicensed through AAD group memberships.
     * <p>
     * <br/><br/>Adding a user to an account is required before the user can be added to ADO groups or assigned an asset.
     * <p>
     * <br/><br/>The body of the request must be a derived type of GraphUserCreationContext:
     * <p>
     * <br/><br/>GraphUserMailAddressCreationContext - Create a new user using the mail address as a reference to an existing user
     * from an external AD or AAD backed provider.
     * <br/><br/>GraphUserOriginIdCreationContext - Create a new user using the OriginID as a reference to an existing user from
     * an external AD or AAD backed provider.
     * <br/><br/>GraphUserPrincipalNameCreationContext - Create a new user using the principal name as a reference to an
     * existing user from an external AD or AAD backed provider.
     * <br/><br/>If the user to be added corresponds to a user that was previously deleted, then that user will be restored.
     * <p>
     * <br/><br/>Optionally, you can add the newly created user as a member of an existing ADO group and/or specify a custom storage key for the user.
     *
     * @param creationContext      graph user creation context object to create a user.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Graph user object {@link GraphUser}
     * @throws AzDException Default Api exception handler.
     */
    public GraphUser create(GraphUserCreationContext creationContext,
                            Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .POST(creationContext)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(GraphUser.class);
    }

    /**
     * The user will still be visible, but membership checks for the user will return false.
     *
     * @param userDescriptor The descriptor of the user to delete.
     * @throws AzDException Default Api exception handler.
     */
    public Void delete(String userDescriptor) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("userDescriptor", userDescriptor)
                .build()
                .executePrimitive();
    }

    /**
     * Get a user by its descriptor.
     *
     * @param userDescriptor The descriptor of the user to delete.
     * @return Graph user object {@link GraphUser}
     * @throws AzDException Default Api exception handler.
     */
    public GraphUser get(String userDescriptor) throws AzDException {
        return builder()
                .serviceEndpoint("userDescriptor", userDescriptor)
                .build()
                .execute(GraphUser.class);
    }

    /**
     * Get a list of all users in a given scope.
     * <p>
     * Since the list of users may be large, results are returned in pages of users.
     * If there are more results than can be returned in a single page, the result set will contain a
     * continuation token for retrieval of the next set of results.
     *
     * @return Collection of graph user as a paged response. Use getNextPageLink() to get the next page.
     * @throws AzDException Default Api exception handler.
     */
    public GraphUsers list() throws AzDException {
        return builder()
                .build()
                .execute(GraphUsers.class);
    }

    /**
     * Get a list of all users in a given scope.
     * <p>
     * Since the list of users may be large, results are returned in pages of users.
     * If there are more results than can be returned in a single page, the result set will contain a
     * continuation token for retrieval of the next set of results.
     *
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Collection of graph user as a paged response. Use getNextPageLink() to get the next page.
     * @throws AzDException Default Api exception handler.
     */
    public GraphUsers list(Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(GraphUsers.class);
    }

    /**
     * Map an existing user to a different user.
     *
     * <br />The body of the request must be a derived type of {@link GraphUserUpdateContext}:
     *
     * <br /><br />{@link GraphUserOriginIdUpdateContext} - Map an existing user in an account, to an existing user from an external
     * AD or AAD backed provider using the OriginId as a reference.
     *
     * @param updateContext origin id and optionally storage key to update.
     * @param userDescriptor The descriptor of the user to update
     * @return Graph user object {@link GraphUser}
     * @throws AzDException Default Api exception handler.
     */
    public GraphUser update(GraphUserUpdateContext updateContext, String userDescriptor) throws AzDException {
        return builder()
                .PATCH(updateContext)
                .serviceEndpoint("userDescriptor", userDescriptor)
                .build()
                .execute(GraphUser.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * A comma separated list of descriptors referencing groups you want the graph group to join
         */
        @QueryParameter(name = "groupDescriptors")
        public String[] groupDescriptors;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

    /**
     * Represents the query parameters.
     */
    public static class ListQueryParameters {
        /**
         * An opaque data blob that allows the next page of data to resume immediately after where
         * the previous page ended. The only reliable way to know if there is more data left is the presence of a continuation token.
         */
        @QueryParameter(name = "continuationToken")
        public String continuationToken;
        /**
         * Specify a non-default scope (collection, project) to search for users.
         */
        @QueryParameter(name = "scopeDescriptor")
        public String scopeDescriptor;
        /**
         * A comma separated list of user subject subtypes to reduce the retrieved results,
         * e.g. msa’, ‘aad’, ‘svc’ (service identity), ‘imp’ (imported identity), etc.
         */
        @QueryParameter(name = "subjectTypes")
        public String[] subjectTypes;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class ListRequestConfiguration {
        public ListQueryParameters queryParameters = new ListQueryParameters();
    }
}
