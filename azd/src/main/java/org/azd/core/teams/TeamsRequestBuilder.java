package org.azd.core.teams;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.core.types.WebApiTeam;
import org.azd.core.types.WebApiTeams;
import org.azd.exceptions.AzDException;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class TeamsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public TeamsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "core", "d30a3dd1-f8ba-442a-b86a-bd0c0c383e59");

    }

    /**
     * Provides functionality to manage Teams members Api.
     *
     * @return TeamsMembersRequestBuilder {@link TeamsMembersRequestBuilder}
     */
    public TeamsMembersRequestBuilder members() {
        return new TeamsMembersRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Create a team in a team project.
     *
     * @param projectId project name or GUID
     * @param teamName  pass the team name
     * @return returns web api object
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WebApiTeam> createAsync(String projectId, String teamName) throws AzDException {
        return builder()
                .POST(Map.of("name", teamName))
                .serviceEndpoint("projectId", projectId)
                .build()
                .executeAsync(WebApiTeam.class);
    }

    /**
     * Delete a team.
     *
     * @param projectId pass the project name or id
     * @param teamId    pass the team name
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(String projectId, String teamId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("projectId", projectId)
                .serviceEndpoint("teamId", teamId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get a specific team.
     *
     * @param projectId pass the project name or id
     * @param teamId    pass the team name
     * @return team object
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WebApiTeam> getAsync(String projectId, String teamId) throws AzDException {
        return builder()
                .serviceEndpoint("projectId", projectId)
                .serviceEndpoint("teamId", teamId)
                .build()
                .executeAsync(WebApiTeam.class);
    }

    /**
     * Get a specific team.
     *
     * @param projectId      pass the project name or id
     * @param teamId         pass the team name
     * @param expandIdentity if true gets the identity object
     * @return team object
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WebApiTeam> getAsync(String projectId, String teamId, boolean expandIdentity) throws AzDException {
        return builder()
                .serviceEndpoint("projectId", projectId)
                .serviceEndpoint("teamId", teamId)
                .query("expandIdentity", expandIdentity)
                .build()
                .executeAsync(WebApiTeam.class);
    }

    /**
     * Get a list of all teams.
     *
     * @return array of team {@link WebApiTeams}.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WebApiTeams> listAsync() throws AzDException {
        return builder()
                .location("7a4d9ee9-3433-4347-b47a-7a80f1cf307e")
                .build()
                .executeAsync(WebApiTeams.class);
    }

    /**
     * Get a list of all teams.
     *
     * @return array of team {@link WebApiTeams}.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WebApiTeams> listAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("7a4d9ee9-3433-4347-b47a-7a80f1cf307e")
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(WebApiTeams.class);
    }

    /**
     * Get a list of teams.
     *
     * @param projectId Project name.
     * @return array of team {@link WebApiTeams}.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WebApiTeams> getAsync(String projectId) throws AzDException {
        return builder()
                .serviceEndpoint("projectId", projectId)
                .build()
                .executeAsync(WebApiTeams.class);
    }

    /**
     * Get a list of teams.
     *
     * @param projectId            Project name.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return array of team {@link WebApiTeams}.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WebApiTeams> getAsync(String projectId, Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("projectId", projectId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(WebApiTeams.class);
    }

    /**
     * Update a team's name and/or description.
     *
     * @param projectId Project name.
     * @param team      WebApiTeam object to update {@link WebApiTeam}.
     * @param teamId    The name or ID (GUID) of the team.
     * @return array of team {@link WebApiTeams}.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WebApiTeam> updateAsync(String projectId, String teamId, WebApiTeam team) throws AzDException {
        return builder()
                .PATCH(team)
                .serviceEndpoint("projectId", projectId)
                .serviceEndpoint("teamId", teamId)
                .build()
                .executeAsync(WebApiTeam.class);
    }

    /**
     * Create a team in a team project.
     *
     * @param projectId project name or GUID
     * @param teamName  pass the team name
     * @return returns web api object
     * @throws AzDException Default Api Exception handler.
     */
    public WebApiTeam create(String projectId, String teamName) throws AzDException {
        return builder()
                .POST(Map.of("name", teamName))
                .serviceEndpoint("projectId", projectId)
                .build()
                .execute(WebApiTeam.class);
    }

    /**
     * Delete a team.
     *
     * @param projectId pass the project name or id
     * @param teamId    pass the team name
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(String projectId, String teamId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("projectId", projectId)
                .serviceEndpoint("teamId", teamId)
                .build()
                .executePrimitive();
    }

    /**
     * Get a specific team.
     *
     * @param projectId pass the project name or id
     * @param teamId    pass the team name
     * @return team object
     * @throws AzDException Default Api Exception handler.
     */
    public WebApiTeam get(String projectId, String teamId) throws AzDException {
        return builder()
                .serviceEndpoint("projectId", projectId)
                .serviceEndpoint("teamId", teamId)
                .build()
                .execute(WebApiTeam.class);
    }

    /**
     * Get a specific team.
     *
     * @param projectId      pass the project name or id
     * @param teamId         pass the team name
     * @param expandIdentity if true gets the identity object
     * @return team object
     * @throws AzDException Default Api Exception handler.
     */
    public WebApiTeam get(String projectId, String teamId, boolean expandIdentity) throws AzDException {
        return builder()
                .serviceEndpoint("projectId", projectId)
                .serviceEndpoint("teamId", teamId)
                .query("expandIdentity", expandIdentity)
                .build()
                .execute(WebApiTeam.class);
    }

    /**
     * Get a list of all teams.
     *
     * @return array of team {@link WebApiTeams}.
     * @throws AzDException Default Api Exception handler.
     */
    public WebApiTeams list() throws AzDException {
        return builder()
                .location("7a4d9ee9-3433-4347-b47a-7a80f1cf307e")
                .build()
                .execute(WebApiTeams.class);
    }

    /**
     * Get a list of all teams.
     *
     * @return array of team {@link WebApiTeams}.
     * @throws AzDException Default Api Exception handler.
     */
    public WebApiTeams list(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("7a4d9ee9-3433-4347-b47a-7a80f1cf307e")
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(WebApiTeams.class);
    }

    /**
     * Get a list of teams.
     *
     * @param projectId Project name.
     * @return array of team {@link WebApiTeams}.
     * @throws AzDException Default Api Exception handler.
     */
    public WebApiTeams get(String projectId) throws AzDException {
        return builder()
                .serviceEndpoint("projectId", projectId)
                .build()
                .execute(WebApiTeams.class);
    }

    /**
     * Get a list of teams.
     *
     * @param projectId            Project name.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return array of team {@link WebApiTeams}.
     * @throws AzDException Default Api Exception handler.
     */
    public WebApiTeams get(String projectId, Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("projectId", projectId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(WebApiTeams.class);
    }

    /**
     * Update a team's name and/or description.
     *
     * @param projectId Project name.
     * @param team      WebApiTeam object to update {@link WebApiTeam}.
     * @param teamId    The name or ID (GUID) of the team.
     * @return array of team {@link WebApiTeams}.
     * @throws AzDException Default Api Exception handler.
     */
    public WebApiTeam update(String projectId, String teamId, WebApiTeam team) throws AzDException {
        return builder()
                .PATCH(team)
                .serviceEndpoint("projectId", projectId)
                .serviceEndpoint("teamId", teamId)
                .build()
                .execute(WebApiTeam.class);
    }


    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * A value indicating whether or not to expand Identity information in the result WebApiTeam object.
         */
        @QueryParameter(name = "$expandIdentity")
        public Boolean expandIdentity;
        /**
         * If true, then return all teams requesting user is member. Otherwise return all teams user has read access.
         */
        @QueryParameter(name = "$mine")
        public Boolean mine;
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

