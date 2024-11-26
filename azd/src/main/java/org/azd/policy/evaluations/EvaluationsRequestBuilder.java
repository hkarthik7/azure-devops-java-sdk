package org.azd.policy.evaluations;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.policy.types.PolicyEvaluationRecord;
import org.azd.policy.types.PolicyEvaluationRecords;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Policy Evaluations Api.
 */
public class EvaluationsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public EvaluationsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "policy", "46aecb7a-5d2c-4647-897b-0209505a9fe4", ApiVersion.POLICY);
    }

    /**
     * Gets the present evaluation state of a policy.
     * <p>
     * Each policy which applies to a pull request will have an evaluation state which is specific to that
     * policy running in the context of that pull request. Each evaluation is uniquely identified via a Guid. You can
     * find all the policy evaluations for a specific pull request using the List operation of this controller.
     *
     * @param evaluationId ID of the policy evaluation to be retrieved.
     * @return PolicyEvaluationRecord Object {@link PolicyEvaluationRecord}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<PolicyEvaluationRecord> getAsync(String evaluationId) throws AzDException {
        return builder()
                .serviceEndpoint("evaluationId", evaluationId)
                .build()
                .executeAsync(PolicyEvaluationRecord.class);
    }

    /**
     * Retrieves a list of all the policy evaluation statuses for a specific pull request.
     * <p>
     * Evaluations are retrieved using an artifact ID which uniquely identifies the pull request.
     * To generate an artifact ID for a pull request, use this template:
     * <pre>{@code
     * vstfs:///CodeReview/CodeReviewId/{projectId}/{pullRequestId}
     * }</pre>
     *
     * @param requestConfiguration Represents the query parameters.
     * @return Collection of evaluation records {@link PolicyEvaluationRecords}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<PolicyEvaluationRecords> listAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("c23ddff5-229c-4d04-a80b-0fdce9f360c8")
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(PolicyEvaluationRecords.class);
    }

    /**
     * Requeue the policy evaluation.
     * <p>
     * Some policies define a "requeue" action which performs some policy-specific operation. You can trigger this
     * operation by updating an existing policy evaluation and setting the PolicyEvaluationRecord.Status field to Queued.
     * Although any policy evaluation can be requeued, at present only build policies perform any action in response.
     * Requeueing a build policy will queue a new build to run (cancelling any existing build which is running).
     *
     * @param evaluationId ID of the policy evaluation to be retrieved.
     * @return PolicyEvaluationRecord Object {@link PolicyEvaluationRecord}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<PolicyEvaluationRecord> requeueAsync(String evaluationId) throws AzDException {
        return builder()
                .PATCH(null)
                .serviceEndpoint("evaluationId", evaluationId)
                .build()
                .executeAsync(PolicyEvaluationRecord.class);
    }

    /**
     * Gets the present evaluation state of a policy.
     * <p>
     * Each policy which applies to a pull request will have an evaluation state which is specific to that
     * policy running in the context of that pull request. Each evaluation is uniquely identified via a Guid. You can
     * find all the policy evaluations for a specific pull request using the List operation of this controller.
     *
     * @param evaluationId ID of the policy evaluation to be retrieved.
     * @return PolicyEvaluationRecord Object {@link PolicyEvaluationRecord}
     * @throws AzDException Default Api Exception handler.
     **/
    public PolicyEvaluationRecord get(String evaluationId) throws AzDException {
        return builder()
                .serviceEndpoint("evaluationId", evaluationId)
                .build()
                .execute(PolicyEvaluationRecord.class);
    }

    /**
     * Retrieves a list of all the policy evaluation statuses for a specific pull request.
     * <p>
     * Evaluations are retrieved using an artifact ID which uniquely identifies the pull request.
     * To generate an artifact ID for a pull request, use this template:
     * <pre>{@code
     * vstfs:///CodeReview/CodeReviewId/{projectId}/{pullRequestId}
     * }</pre>
     *
     * @param requestConfiguration Represents the query parameters.
     * @return Collection of evaluation records {@link PolicyEvaluationRecords}
     * @throws AzDException Default Api Exception handler.
     */
    public PolicyEvaluationRecords list(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("c23ddff5-229c-4d04-a80b-0fdce9f360c8")
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(PolicyEvaluationRecords.class);
    }

    /**
     * Requeue the policy evaluation.
     * <p>
     * Some policies define a "requeue" action which performs some policy-specific operation. You can trigger this
     * operation by updating an existing policy evaluation and setting the PolicyEvaluationRecord.Status field to Queued.
     * Although any policy evaluation can be requeued, at present only build policies perform any action in response.
     * Requeueing a build policy will queue a new build to run (cancelling any existing build which is running).
     *
     * @param evaluationId ID of the policy evaluation to be retrieved.
     * @return PolicyEvaluationRecord Object {@link PolicyEvaluationRecord}
     * @throws AzDException Default Api Exception handler.
     */
    public PolicyEvaluationRecord requeue(String evaluationId) throws AzDException {
        return builder()
                .PATCH(null)
                .serviceEndpoint("evaluationId", evaluationId)
                .build()
                .execute(PolicyEvaluationRecord.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * The maximum number of evaluation records to return
         */
        @QueryParameter(name = "$top")
        public Integer top;
        /**
         * A string which uniquely identifies the target of a policy evaluation.
         */
        @QueryParameter(name = "artifactId")
        public String artifactId;
        /**
         * The number of policy evaluation records to ignore. For example, to retrieve results 101-150,
         * set top to 50 and skip to 100.
         */
        @QueryParameter(name = "$skip")
        public Integer skip;
        /**
         * Some policies might determine that they do not apply to a specific pull request.
         * Setting this parameter to true will return evaluation records even for policies which don't apply to this pull request.
         */
        @QueryParameter(name = "includeNotApplicable")
        public Boolean includeNotApplicable;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}
