package org.azd.workitemtracking.wiql;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.helpers.URLHelper;
import org.azd.workitemtracking.types.WorkItemQueryResult;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Work item tracking Wiql Api.
 */
public class WiqlRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public WiqlRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "wit");
    }

    /**
     * Gets the results of the query given the query ID.
     *
     * @param id   The query ID.
     * @param team Team ID or team name
     * @return The result of a work item query. {@link WorkItemQueryResult}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemQueryResult> queryByIdAsync(String id, String team) throws AzDException {
        return builder()
                .location("a02355f5-5f8a-4671-8e32-369d23aac83d")
                .serviceEndpoint("id", id)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .apiVersion(ApiVersion.WIT_WIQL)
                .build()
                .executeAsync(WorkItemQueryResult.class);
    }

    /**
     * Gets the results of the query given the query ID.
     *
     * @param id                   The query ID.
     * @param team                 Team ID or team name
     * @param requestConfiguration Represents the query parameters.
     * @return The result of a work item query. {@link WorkItemQueryResult}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemQueryResult> queryByIdAsync(String id, String team,
                                                                 Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("a02355f5-5f8a-4671-8e32-369d23aac83d")
                .serviceEndpoint("id", id)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .apiVersion(ApiVersion.WIT_WIQL)
                .build()
                .executeAsync(WorkItemQueryResult.class);
    }

    /**
     * Gets the results of the query given its WIQL.
     *
     * @param team Team ID or team name
     * @return The result of a work item query. {@link WorkItemQueryResult}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemQueryResult> queryAsync(String team, String query) throws AzDException {
        return builder()
                .location("1a9c53f7-f243-4447-b110-35ef023636e4")
                .POST(Map.of("query", query))
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .apiVersion(ApiVersion.WIT_WIQL)
                .build()
                .executeAsync(WorkItemQueryResult.class);
    }

    /**
     * Gets the results of the query given its WIQL.
     *
     * @param team                 Team ID or team name
     * @param requestConfiguration Represents the query parameters.
     * @return The result of a work item query. {@link WorkItemQueryResult}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemQueryResult> queryAsync(String team, String query,
                                                             Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("1a9c53f7-f243-4447-b110-35ef023636e4")
                .POST(Map.of("query", query))
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .apiVersion(ApiVersion.WIT_WIQL)
                .build()
                .executeAsync(WorkItemQueryResult.class);
    }

    /**
     * Gets the results of the query given the query ID.
     *
     * @param id   The query ID.
     * @param team Team ID or team name
     * @return The result of a work item query. {@link WorkItemQueryResult}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemQueryResult queryById(String id, String team) throws AzDException {
        return builder()
                .location("a02355f5-5f8a-4671-8e32-369d23aac83d")
                .serviceEndpoint("id", id)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .apiVersion(ApiVersion.WIT_WIQL)
                .build()
                .execute(WorkItemQueryResult.class);
    }

    /**
     * Gets the results of the query given the query ID.
     *
     * @param id                   The query ID.
     * @param team                 Team ID or team name
     * @param requestConfiguration Represents the query parameters.
     * @return The result of a work item query. {@link WorkItemQueryResult}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemQueryResult queryById(String id, String team,
                                         Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("a02355f5-5f8a-4671-8e32-369d23aac83d")
                .serviceEndpoint("id", id)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .apiVersion(ApiVersion.WIT_WIQL)
                .build()
                .execute(WorkItemQueryResult.class);
    }

    /**
     * Gets the results of the query given its WIQL.
     *
     * @param team Team ID or team name
     * @return The result of a work item query. {@link WorkItemQueryResult}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemQueryResult query(String team, String query) throws AzDException {
        return builder()
                .location("1a9c53f7-f243-4447-b110-35ef023636e4")
                .POST(Map.of("query", query))
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .apiVersion(ApiVersion.WIT_WIQL)
                .build()
                .execute(WorkItemQueryResult.class);
    }

    /**
     * Gets the results of the query given its WIQL.
     *
     * @param team                 Team ID or team name
     * @param requestConfiguration Represents the query parameters.
     * @return The result of a work item query. {@link WorkItemQueryResult}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemQueryResult query(String team, String query,
                                     Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("1a9c53f7-f243-4447-b110-35ef023636e4")
                .POST(Map.of("query", query))
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .apiVersion(ApiVersion.WIT_WIQL)
                .build()
                .execute(WorkItemQueryResult.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * The max number of results to return.
         */
        @QueryParameter(name = "$top")
        public Integer top;
        /**
         * Whether to use time precision.
         */
        @QueryParameter(name = "timePrecision")
        public Boolean timePrecision;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

}
