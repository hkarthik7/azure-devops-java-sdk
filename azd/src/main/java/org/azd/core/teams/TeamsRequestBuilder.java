package org.azd.core.teams;

import org.azd.common.ApiVersion;
import org.azd.common.types.QueryParameter;
import org.azd.core.types.WebApiTeam;
import org.azd.core.types.WebApiTeams;
import org.azd.exceptions.AzDException;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class TeamsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates the request builder with required values.
     * @param accessTokenCredential Authentication type {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public TeamsRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "projects", ApiVersion.PROJECT_TEAMS);
    }

    /**
     * Provides functionality to manage Teams members Api.
     * @return TeamsMembersRequestBuilder {@link TeamsMembersRequestBuilder}
     */
    public TeamsMembersRequestBuilder members() {
        return new TeamsMembersRequestBuilder(accessTokenCredential, requestAdapter);
    }

    /***
     * Create a team in a team project.
     * @param projectName project name or GUID
     * @param teamName pass the team name
     * @throws AzDException Default Api Exception handler.
     * @return returns web api object
     */
    public CompletableFuture<WebApiTeam> createAsync(String projectName, String teamName) throws AzDException {
        var body = new HashMap<>() {{
            put("name", teamName);
        }};

        var reqInfo = toPostRequestInformation(body);
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + projectName + "/teams";

        return requestAdapter.sendAsync(reqInfo, WebApiTeam.class);
    }

    /***
     * Delete a team.
     * @param projectName pass the project name or id
     * @param teamName pass the team name
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(String projectName, String teamName) throws AzDException {
        var reqInfo = toDeleteRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + projectName + "/teams/" + teamName;

        return requestAdapter.sendPrimitiveAsync(reqInfo);
    }

    /***
     * Get a specific team.
     * @param projectName pass the project name or id
     * @param teamName pass the team name
     * @throws AzDException Default Api Exception handler.
     * @return team object
     */
    public CompletableFuture<WebApiTeam> getAsync(String projectName, String teamName) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + projectName + "/teams/" + teamName;

        return requestAdapter.sendAsync(reqInfo, WebApiTeam.class);
    }

    /***
     * Get a specific team.
     * @param projectName pass the project name or id
     * @param teamName pass the team name
     * @param expandIdentity if true gets the identity object
     * @throws AzDException Default Api Exception handler.
     * @return team object
     */
    public CompletableFuture<WebApiTeam> getAsync(String projectName, String teamName, boolean expandIdentity) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + projectName + "/teams/" + teamName;
        reqInfo.setQueryParameter("expandIdentity", expandIdentity);

        return requestAdapter.sendAsync(reqInfo, WebApiTeam.class);
    }

    /***
     * Get a list of all teams.
     * @throws AzDException Default Api Exception handler.
     * @return array of team {@link WebApiTeams}.
     */
    public CompletableFuture<WebApiTeams> listAsync() throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = "teams";

        return requestAdapter.sendAsync(reqInfo, WebApiTeams.class);
    }

    /***
     * Get a list of all teams.
     * @throws AzDException Default Api Exception handler.
     * @return array of team {@link WebApiTeams}.
     */
    public CompletableFuture<WebApiTeams> listAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = "teams";

        if (requestConfiguration != null) {
            final var config = new RequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.sendAsync(reqInfo, WebApiTeams.class);
    }

    /***
     * Get a list of teams.
     * @param projectName Project name.
     * @throws AzDException Default Api Exception handler.
     * @return array of team {@link WebApiTeams}.
     */
    public CompletableFuture<WebApiTeams> getAsync(String projectName) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + projectName + "/teams";

        return requestAdapter.sendAsync(reqInfo, WebApiTeams.class);
    }

    /***
     * Get a list of teams.
     * @param projectName Project name.
     * @param team WebApiTeam object to update {@link WebApiTeam}.
     * @param teamName The name or ID (GUID) of the team.
     * @throws AzDException Default Api Exception handler.
     * @return array of team {@link WebApiTeams}.
     */
    public CompletableFuture<WebApiTeam> updateAsync(String projectName, String teamName, WebApiTeam team) throws AzDException {
        var reqInfo = toPatchRequestInformation(team);
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + projectName + "/teams/" + teamName;

        return requestAdapter.sendAsync(reqInfo, WebApiTeam.class);
    }

    /***
     * Update a team's name and/or description.
     * @param projectName Project name.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @throws AzDException Default Api Exception handler.
     * @return array of team {@link WebApiTeams}.
     */
    public CompletableFuture<WebApiTeams> getAsync(String projectName, Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + projectName + "/teams";

        if (requestConfiguration != null) {
            final var config = new RequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.sendAsync(reqInfo, WebApiTeams.class);
    }

    /***
     * Create a team in a team project.
     * @param projectName project name or GUID
     * @param teamName pass the team name
     * @throws AzDException Default Api Exception handler.
     * @return returns web api object
     */
    public WebApiTeam create(String projectName, String teamName) throws AzDException {
        var body = new HashMap<>() {{
            put("name", teamName);
        }};

        var reqInfo = toPostRequestInformation(body);
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + projectName + "/teams";

        return requestAdapter.send(reqInfo, WebApiTeam.class);
    }

    /***
     * Delete a team.
     * @param projectName pass the project name or id
     * @param teamName pass the team name
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(String projectName, String teamName) throws AzDException {
        var reqInfo = toDeleteRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + projectName + "/teams/" + teamName;

        return requestAdapter.sendPrimitive(reqInfo);
    }

    /***
     * Get a specific team.
     * @param projectName pass the project name or id
     * @param teamName pass the team name
     * @throws AzDException Default Api Exception handler.
     * @return team object
     */
    public WebApiTeam get(String projectName, String teamName) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + projectName + "/teams/" + teamName;
        reqInfo.project = null;

        return requestAdapter.send(reqInfo, WebApiTeam.class);
    }

    /***
     * Get a specific team.
     * @param projectName pass the project name or id
     * @param teamName pass the team name
     * @param expandIdentity if true gets the identity object
     * @throws AzDException Default Api Exception handler.
     * @return team object
     */
    public WebApiTeam get(String projectName, String teamName, boolean expandIdentity) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + projectName + "/teams/" + teamName;
        reqInfo.project = null;
        reqInfo.setQueryParameter("expandIdentity", expandIdentity);

        return requestAdapter.send(reqInfo, WebApiTeam.class);
    }

    /***
     * Get a list of all teams.
     * @throws AzDException Default Api Exception handler.
     * @return array of team {@link WebApiTeams}.
     */
    public WebApiTeams list() throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = "teams";
        reqInfo.project = null;

        return requestAdapter.send(reqInfo, WebApiTeams.class);
    }

    /***
     * Get a list of all teams.
     * @throws AzDException Default Api Exception handler.
     * @return array of team {@link WebApiTeams}.
     */
    public WebApiTeams list(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = "teams";
        reqInfo.project = null;

        if (requestConfiguration != null) {
            final var config = new RequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.send(reqInfo, WebApiTeams.class);
    }

    /***
     * Get a list of teams.
     * @param projectName Project name.
     * @throws AzDException Default Api Exception handler.
     * @return array of team {@link WebApiTeams}.
     */
    public WebApiTeams get(String projectName) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + projectName + "/teams";
        reqInfo.project = null;

        return requestAdapter.send(reqInfo, WebApiTeams.class);
    }

    /***
     * Get a list of teams.
     * @param projectName Project name.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @throws AzDException Default Api Exception handler.
     * @return array of team {@link WebApiTeams}.
     */
    public WebApiTeams get(String projectName, Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + projectName + "/teams";
        reqInfo.project = null;

        if (requestConfiguration != null) {
            final var config = new RequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.send(reqInfo, WebApiTeams.class);
    }

    /***
     * Get a list of teams.
     * @param projectName Project name.
     * @param team WebApiTeam object to update {@link WebApiTeam}.
     * @param teamName The name or ID (GUID) of the team.
     * @throws AzDException Default Api Exception handler.
     * @return array of team {@link WebApiTeams}.
     */
    public WebApiTeam update(String projectName, String teamName, WebApiTeam team) throws AzDException {
        var reqInfo = toPatchRequestInformation(team);
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + projectName + "/teams/" + teamName;

        return requestAdapter.send(reqInfo, WebApiTeam.class);
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
        public Number skip;
        /**
         * Maximum number of teams to return.
         */
        @QueryParameter(name = "$top")
        public Number top;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}
