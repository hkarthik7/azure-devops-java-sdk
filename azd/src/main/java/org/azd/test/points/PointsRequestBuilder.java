package org.azd.test.points;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.helpers.Utils;
import org.azd.test.types.PointUpdateModel;
import org.azd.test.types.TestPoint;
import org.azd.test.types.TestPoints;
import org.azd.test.types.TestPointsQuery;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Test points Api.
 */
public class PointsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public PointsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "test", "3bcfd5c8-be62-488e-b1da-b8289ce9299c", ApiVersion.TEST_POINTS);
    }

    /**
     * Get a test point.
     *
     * @param planId ID of the test plan.
     * @param suiteId ID of the suite that contains the point.
     * @param pointIds ID of the test point to get.
     * @return Test point object {@link TestPoint}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<TestPoint> getAsync(int planId, int pointIds, int suiteId) throws AzDException {
        return builder()
                .serviceEndpoint("planId", planId)
                .serviceEndpoint("pointIds", pointIds)
                .serviceEndpoint("suiteId", suiteId)
                .build()
                .executeAsync(TestPoint.class);
    }

    /**
     * Get a test point.
     *
     * @param planId ID of the test plan.
     * @param suiteId ID of the suite that contains the point.
     * @param pointIds ID of the test point to get.
     * @param witFields list of work item field names.
     * @return Test point object {@link TestPoint}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<TestPoint> getAsync(int planId, int pointIds, int suiteId, String... witFields)
            throws AzDException {
        return builder()
                .serviceEndpoint("planId", planId)
                .serviceEndpoint("pointIds", pointIds)
                .serviceEndpoint("suiteId", suiteId)
                .query("witFields", Utils.toString(witFields))
                .build()
                .executeAsync(TestPoint.class);
    }

    /**
     * Get test points using query.
     *
     * @param query Query object to get the test points.
     * @return Test points query object {@link TestPointsQuery}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<TestPointsQuery> getByQueryAsync(TestPointsQuery query)
            throws AzDException {
        return builder()
                .POST(query)
                .build()
                .executeAsync(TestPointsQuery.class);
    }

    /**
     * Get test points using query.
     *
     * @param query Query object to get the test points.
     * @param skip Number of test points to skip.
     * @param top Number of test points to return.
     * @return Test points query object {@link TestPointsQuery}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<TestPointsQuery> getByQueryAsync(TestPointsQuery query, int skip, int top)
            throws AzDException {
        return builder()
                .POST(query)
                .query("$skip", skip)
                .query("$top", top)
                .build()
                .executeAsync(TestPointsQuery.class);
    }

    /**
     * Get a list of test points.
     *
     * @param planId ID of the test plan.
     * @param suiteId ID of the suite that contains the point.
     * @return Collection of test points object {@link TestPoints}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<TestPoints> listAsync(int planId, int suiteId) throws AzDException {
        return builder()
                .serviceEndpoint("planId", planId)
                .serviceEndpoint("suiteId", suiteId)
                .build()
                .executeAsync(TestPoints.class);
    }

    /**
     * Get a list of test points.
     *
     * @param planId ID of the test plan.
     * @param suiteId ID of the suite that contains the point.
     * @param requestConfiguration Represents the query parameters.
     * @return Collection of test points object {@link TestPoints}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<TestPoints> listAsync(int planId, int suiteId, Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("planId", planId)
                .serviceEndpoint("suiteId", suiteId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(TestPoints.class);
    }

    /**
     * Update test points.
     *
     * @param updateModel Request object to update.
     * @param planId ID of the test plan.
     * @param suiteId ID of the suite that contains the point.
     * @param pointIds IDs of the test point to get.
     * @return Collection of test points object {@link TestPoints}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<TestPoints> updateAsync(PointUpdateModel updateModel, int planId, int suiteId,
                                                     int... pointIds) throws AzDException {
        return builder()
                .serviceEndpoint("planId", planId)
                .serviceEndpoint("suiteId", suiteId)
                .serviceEndpoint("pointIds", Utils.toString(pointIds))
                .PATCH(updateModel)
                .build()
                .executeAsync(TestPoints.class);
    }

    /**
     * Get a test point.
     *
     * @param planId ID of the test plan.
     * @param suiteId ID of the suite that contains the point.
     * @param pointIds ID of the test point to get.
     * @return Test point object {@link TestPoint}
     * @throws AzDException Default Api Exception handler.
     */
    public TestPoint get(int planId, int pointIds, int suiteId) throws AzDException {
        return builder()
                .serviceEndpoint("planId", planId)
                .serviceEndpoint("pointIds", pointIds)
                .serviceEndpoint("suiteId", suiteId)
                .build()
                .execute(TestPoint.class);
    }

    /**
     * Get a test point.
     *
     * @param planId ID of the test plan.
     * @param suiteId ID of the suite that contains the point.
     * @param pointIds ID of the test point to get.
     * @param witFields list of work item field names.
     * @return Test point object {@link TestPoint}
     * @throws AzDException Default Api Exception handler.
     */
    public TestPoint get(int planId, int pointIds, int suiteId, String... witFields)
            throws AzDException {
        return builder()
                .serviceEndpoint("planId", planId)
                .serviceEndpoint("pointIds", pointIds)
                .serviceEndpoint("suiteId", suiteId)
                .query("witFields", Utils.toString(witFields))
                .build()
                .execute(TestPoint.class);
    }

    /**
     * Get test points using query.
     *
     * @param query Query object to get the test points.
     * @return Test points query object {@link TestPointsQuery}
     * @throws AzDException Default Api Exception handler.
     */
    public TestPointsQuery getByQuery(TestPointsQuery query)
            throws AzDException {
        return builder()
                .POST(query)
                .build()
                .execute(TestPointsQuery.class);
    }

    /**
     * Get test points using query.
     *
     * @param query Query object to get the test points.
     * @param skip Number of test points to skip.
     * @param top Number of test points to return.
     * @return Test points query object {@link TestPointsQuery}
     * @throws AzDException Default Api Exception handler.
     */
    public TestPointsQuery getByQuery(TestPointsQuery query, int skip, int top)
            throws AzDException {
        return builder()
                .POST(query)
                .query("$skip", skip)
                .query("$top", top)
                .build()
                .execute(TestPointsQuery.class);
    }

    /**
     * Get a list of test points.
     *
     * @param planId ID of the test plan.
     * @param suiteId ID of the suite that contains the point.
     * @return Collection of test points object {@link TestPoints}
     * @throws AzDException Default Api Exception handler.
     */
    public TestPoints list(int planId, int suiteId) throws AzDException {
        return builder()
                .serviceEndpoint("planId", planId)
                .serviceEndpoint("suiteId", suiteId)
                .build()
                .execute(TestPoints.class);
    }

    /**
     * Get a list of test points.
     *
     * @param planId ID of the test plan.
     * @param suiteId ID of the suite that contains the point.
     * @param requestConfiguration Represents the query parameters.
     * @return Collection of test points object {@link TestPoints}
     * @throws AzDException Default Api Exception handler.
     */
    public TestPoints list(int planId, int suiteId, Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("planId", planId)
                .serviceEndpoint("suiteId", suiteId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(TestPoints.class);
    }

    /**
     * Update test points.
     *
     * @param updateModel Request object to update.
     * @param planId ID of the test plan.
     * @param suiteId ID of the suite that contains the point.
     * @param pointIds IDs of the test point to get.
     * @return Collection of test points object {@link TestPoints}
     * @throws AzDException Default Api Exception handler.
     */
    public TestPoints update(PointUpdateModel updateModel, int planId, int suiteId,
                             int... pointIds) throws AzDException {
        return builder()
                .serviceEndpoint("planId", planId)
                .serviceEndpoint("suiteId", suiteId)
                .serviceEndpoint("pointIds", Utils.toString(pointIds))
                .PATCH(updateModel)
                .build()
                .execute(TestPoints.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Number of test points to skip.
         */
        @QueryParameter(name = "$skip")
        private Integer skip;
        /**
         * Number of test points to return.
         */
        @QueryParameter(name = "$top")
        private Integer top;
        /**
         * Get test points for specific configuration.
         */
        @QueryParameter(name = "configurationId")
        private String configurationId;
        /**
         * Include all properties for the test point.
         */
        @QueryParameter(name = "includePointDetails")
        private Boolean includePointDetails;
        /**
         * Get test points for a specific test case, valid when configurationId is not set.
         */
        @QueryParameter(name = "testCaseId")
        private String testCaseId;
        /**
         * Get test points for comma-separated list of test point IDs, valid only when configurationId and testCaseId are not set.
         */
        @QueryParameter(name = "testPointIds")
        private String testPointIds;
        /**
         * Comma-separated list of work item field names.
         */
        @QueryParameter(name = "witFields")
        private String witFields;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}
