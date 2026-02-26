package org.azd.workitemtracking.comments;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.CommentExpandOptions;
import org.azd.enums.CommentFormat;
import org.azd.enums.CommentSortOrder;
import org.azd.exceptions.AzDException;
import org.azd.workitemtracking.types.Comment;
import org.azd.workitemtracking.types.CommentList;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class CommentsRequestBuilder extends BaseRequestBuilder {
    public CommentsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "wit", "608aac0a-32e1-4493-a863-b9cf4566d257", ApiVersion.WORK_ITEM_TRACKING_COMMENTS);
    }

    /**
     * Add a comment on a work item.
     * @param comment Text of the comment.
     * @param workItemId Id of a work item.
     * @return Comment Object {@link Comment}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<Comment> addAsync(String comment, int workItemId) throws AzDException {
        return builder()
                .POST(Map.of("text", comment))
                .serviceEndpoint("workItemId", workItemId)
                .build()
                .executeAsync(Comment.class);
    }

    /**
     * Add a comment on a work item.
     * @param comment Text of the comment.
     * @param workItemId Id of a work item.
     * @param format Format of a work item comment (Markdown or Html).
     * @return Comment Object {@link Comment}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<Comment> addAsync(String comment, int workItemId, CommentFormat format) throws AzDException {
        return builder()
                .POST(Map.of("text", comment))
                .serviceEndpoint("workItemId", workItemId)
                .query("format", format)
                .build()
                .executeAsync(Comment.class);
    }

    /**
     * Returns a work item comment.
     * @param commentId Id of the comment.
     * @param workItemId Id of a work item.
     * @return Comment Object {@link Comment}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<Comment> getAsync(int commentId, int workItemId) throws AzDException {
        return builder()
                .serviceEndpoint("commentId", commentId)
                .serviceEndpoint("workItemId", workItemId)
                .build()
                .executeAsync(Comment.class);
    }

    /**
     * Returns a work item comment.
     * @param commentId Id of the comment.
     * @param workItemId Id of a work item.
     * @param requestConfiguration Represents the query parameters.
     * @return Comment Object {@link Comment}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<Comment> getAsync(int commentId, int workItemId,
                                               Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("commentId", commentId)
                .serviceEndpoint("workItemId", workItemId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(Comment.class);
    }

    /**
     * Returns a list of work item comments, pageable.
     * @param workItemId Id of a work item.
     * @return List of Comment Object {@link CommentList}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<CommentList> listAsync(int workItemId) throws AzDException {
        return builder()
                .serviceEndpoint("workItemId", workItemId)
                .build()
                .executeAsync(CommentList.class);
    }

    /**
     * Returns a list of work item comments, pageable.
     * @param workItemId Id of a work item.
     * @param requestConfiguration Represents the query parameters.
     * @return List of Comment Object {@link CommentList}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<CommentList> listAsync(int workItemId,
                         Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("workItemId", workItemId)
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(CommentList.class);
    }

    /**
     * Delete a comment on a work item.
     * @param commentId Id of the comment.
     * @param workItemId Id of a work item.
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<Void> deleteAsync(int commentId, int workItemId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("commentId", commentId)
                .serviceEndpoint("workItemId", workItemId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Add a comment on a work item.
     * @param comment Text of the comment.
     * @param workItemId Id of a work item.
     * @return Comment Object {@link Comment}
     * @throws AzDException Default Api Exception handler.
     **/
    public Comment add(String comment, int workItemId) throws AzDException {
        return builder()
                .POST(Map.of("text", comment))
                .serviceEndpoint("workItemId", workItemId)
                .build()
                .execute(Comment.class);
    }

    /**
     * Add a comment on a work item.
     * @param comment Text of the comment.
     * @param workItemId Id of a work item.
     * @param format Format of a work item comment (Markdown or Html).
     * @return Comment Object {@link Comment}
     * @throws AzDException Default Api Exception handler.
     **/
    public Comment add(String comment, int workItemId, CommentFormat format) throws AzDException {
        return builder()
                .POST(Map.of("text", comment))
                .serviceEndpoint("workItemId", workItemId)
                .query("format", format)
                .build()
                .execute(Comment.class);
    }

    /**
     * Returns a work item comment.
     * @param commentId Id of the comment.
     * @param workItemId Id of a work item.
     * @return Comment Object {@link Comment}
     * @throws AzDException Default Api Exception handler.
     **/
    public Comment get(int commentId, int workItemId) throws AzDException {
        return builder()
                .serviceEndpoint("commentId", commentId)
                .serviceEndpoint("workItemId", workItemId)
                .build()
                .execute(Comment.class);
    }

    /**
     * Returns a work item comment.
     * @param commentId Id of the comment.
     * @param workItemId Id of a work item.
     * @param requestConfiguration Represents the query parameters.
     * @return Comment Object {@link Comment}
     * @throws AzDException Default Api Exception handler.
     **/
    public Comment get(int commentId, int workItemId,
                                               Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("commentId", commentId)
                .serviceEndpoint("workItemId", workItemId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(Comment.class);
    }

    /**
     * Returns a list of work item comments, pageable.
     * @param workItemId Id of a work item.
     * @return List of Comment Object {@link CommentList}
     * @throws AzDException Default Api Exception handler.
     **/
    public CommentList list(int workItemId) throws AzDException {
        return builder()
                .serviceEndpoint("workItemId", workItemId)
                .build()
                .execute(CommentList.class);
    }

    /**
     * Returns a list of work item comments, pageable.
     * @param workItemId Id of a work item.
     * @param requestConfiguration Represents the query parameters.
     * @return List of Comment Object {@link CommentList}
     * @throws AzDException Default Api Exception handler.
     **/
    public CommentList list(int workItemId,
                         Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("workItemId", workItemId)
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(CommentList.class);
    }

    /**
     * Delete a comment on a work item.
     * @param commentId Id of the comment.
     * @param workItemId Id of a work item.
     * @throws AzDException Default Api Exception handler.
     **/
    public Void delete(int commentId, int workItemId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("commentId", commentId)
                .serviceEndpoint("workItemId", workItemId)
                .build()
                .executePrimitive();
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Specifies the additional data retrieval options for work item comments.
         */
        @QueryParameter(name = "$expand")
        public CommentExpandOptions expand;
        /**
         * Specify if the deleted comment should be retrieved.
         */
        @QueryParameter(name = "includeDeleted")
        public Boolean includeDeleted;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

    /**
     * Represents the list query parameters.
     */
    public static class ListQueryParameters {
        /**
         * Specifies the additional data retrieval options for work item comments.
         */
        @QueryParameter(name = "$expand")
        public CommentExpandOptions expand;
        /**
         * Max number of comments to return.
         */
        @QueryParameter(name = "$top")
        public Integer top;
        /**
         * Used to query for the next page of comments.
         */
        @QueryParameter(name = "continuationToken")
        public String continuationToken;
        /**
         * Order in which the comments should be returned.
         */
        @QueryParameter(name = "order")
        public CommentSortOrder order;
        /**
         * Specify if the deleted comment should be retrieved.
         */
        @QueryParameter(name = "includeDeleted")
        public Boolean includeDeleted;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class ListRequestConfiguration {
        public ListQueryParameters queryParameters = new ListQueryParameters();
    }
}
