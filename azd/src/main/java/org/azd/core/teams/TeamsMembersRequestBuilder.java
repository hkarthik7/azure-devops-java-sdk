package org.azd.core.teams;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.core.types.TeamMembers;
import org.azd.exceptions.AzDException;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to manage teams members Api.
 */
public class TeamsMembersRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public TeamsMembersRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "core", "294c494c-2600-4d7e-b76c-3dd50c3c95be", ApiVersion.PROJECT_TEAMS_MEMBERS);
    }

    /**
     * Get a list of members for a specific team.
     *
     * @param projectId The name or ID (GUID) of the team project the team belongs to.
     * @param teamId    The name or ID (GUID) of the team .
     * @return TeamMembers object {@link TeamMembers}.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<TeamMembers> getAsync(String projectId, String teamId) throws AzDException {
        return builder()
                .serviceEndpoint("projectId", projectId)
                .serviceEndpoint("teamId", teamId)
                .build()
                .executeAsync(TeamMembers.class);
    }

    /**
     * Get a list of members for a specific team.
     *
     * @param projectId            The name or ID (GUID) of the team project the team belongs to.
     * @param teamId               The name or ID (GUID) of the team .
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return TeamMembers object {@link TeamMembers}.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<TeamMembers> getAsync(String projectId, String teamId, Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("projectId", projectId)
                .serviceEndpoint("teamId", teamId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(TeamMembers.class);
    }

    /**
     * Get a list of members for a specific team.
     *
     * @param projectId The name or ID (GUID) of the team project the team belongs to.
     * @param teamId    The name or ID (GUID) of the team .
     * @return TeamMembers object {@link TeamMembers}.
     * @throws AzDException Default Api Exception handler.
     */
    public TeamMembers get(String projectId, String teamId) throws AzDException {
        return builder()
                .serviceEndpoint("projectId", projectId)
                .serviceEndpoint("teamId", teamId)
                .build()
                .execute(TeamMembers.class);
    }

    /**
     * Get a list of members for a specific team.
     *
     * @param projectId            The name or ID (GUID) of the team project the team belongs to.
     * @param teamId               The name or ID (GUID) of the team .
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return TeamMembers object {@link TeamMembers}.
     * @throws AzDException Default Api Exception handler.
     */
    public TeamMembers get(String projectId, String teamId, Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("projectId", projectId)
                .serviceEndpoint("teamId", teamId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(TeamMembers.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Number of teams to skip.
         */
        @QueryParameter(name = "$skip")
        public Integer skip;
        /**
         * Maximum number of teams to return.
         */
        @QueryParameter(name = "$top")
        public Integer top;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}
