package org.azd.release.approvals;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.ApprovalStatus;
import org.azd.enums.ApprovalType;
import org.azd.enums.ReleaseQueryOrder;
import org.azd.exceptions.AzDException;
import org.azd.release.definitions.DefinitionsRequestBuilder;
import org.azd.release.types.ReleaseApproval;
import org.azd.release.types.ReleaseApprovals;
import org.azd.release.types.ReleaseEnvironment;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Release Approvals Api.
 */
public class ApprovalsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ApprovalsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "release", "b47c6458-e73b-47cb-a770-4df1e8813a91", ApiVersion.RELEASE);
    }

    /**
     * Get a list of approvals
     *
     * @return List of release approvals {@link ReleaseApprovals}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ReleaseApprovals> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(ReleaseApprovals.class);
    }

    /**
     * Get a list of approvals
     *
     * @param requestConfiguration Consumer of query parameters.
     * @return List of release approvals {@link ReleaseApprovals}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ReleaseApprovals> listAsync(Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(ReleaseApprovals.class);
    }

    /**
     * Update status of an approval
     *
     * @param approvalId Id of the approval.
     * @param releaseApproval Release approval object to approve.
     * @return Release approval object {@link ReleaseApproval}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ReleaseApproval> updateAsync(int approvalId, ReleaseApproval releaseApproval) throws AzDException {
        return builder()
                .location("9328e074-59fb-465a-89d9-b09c82ee5109")
                .PATCH(releaseApproval)
                .serviceEndpoint("approvalId", approvalId)
                .build()
                .executeAsync(ReleaseApproval.class);
    }

    /**
     * Get a list of approvals
     *
     * @return List of release approvals {@link ReleaseApprovals}
     * @throws AzDException Default Api Exception handler.
     */
    public ReleaseApprovals list() throws AzDException {
        return builder()
                .build()
                .execute(ReleaseApprovals.class);
    }

    /**
     * Get a list of approvals
     *
     * @param requestConfiguration Consumer of query parameters.
     * @return List of release approvals {@link ReleaseApprovals}
     * @throws AzDException Default Api Exception handler.
     */
    public ReleaseApprovals list(Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(ReleaseApprovals.class);
    }

    /**
     * Update status of an approval
     *
     * @param approvalId Id of the approval.
     * @param releaseApproval Release approval object to approve.
     * @return Release approval object {@link ReleaseApproval}
     * @throws AzDException Default Api Exception handler.
     */
    public ReleaseApproval update(int approvalId, ReleaseApproval releaseApproval) throws AzDException {
        return builder()
                .location("9328e074-59fb-465a-89d9-b09c82ee5109")
                .PATCH(releaseApproval)
                .serviceEndpoint("approvalId", approvalId)
                .build()
                .execute(ReleaseApproval.class);
    }

    public static class ListQueryParameters {
        /**
         * Approvals assigned to this user.
         */
        @QueryParameter(name = "assignedToFilter")
        public String assignedToFilter;
        /**
         * Gets the approvals after the continuation token provided.
         */
        @QueryParameter(name = "continuationToken")
        public Integer continuationToken;
        /**
         * 'true' to include my group approvals. Default is 'false'.
         */
        @QueryParameter(name = "includeMyGroupApprovals")
        public Boolean includeMyGroupApprovals;
        /**
         * Gets the results in the defined order of created approvals. Default is 'descending'.
         */
        @QueryParameter(name = "queryOrder")
        public ReleaseQueryOrder queryOrder;
        /**
         * Approvals for release id(s) mentioned in the filter.
         * Multiple releases can be mentioned by separating them with ',' e.g. releaseIdsFilter=1,2,3,4.
         */
        @QueryParameter(name = "releaseIdsFilter")
        public String releaseIdsFilter;
        /**
         * Approvals with this status. Default is 'pending'.
         */
        @QueryParameter(name = "statusFilter")
        public ApprovalStatus statusFilter;
        /**
         * Number of approvals to get. Default is 50.
         */
        @QueryParameter(name = "top")
        public Integer top;
        /**
         * Approval with this type.
         */
        @QueryParameter(name = "typeFilter")
        public ApprovalType typeFilter;
    }

    public static class ListRequestConfiguration {
        public ListQueryParameters queryParameters = new ListQueryParameters();
    }
}
