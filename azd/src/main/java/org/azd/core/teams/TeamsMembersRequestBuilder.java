package org.azd.core.teams;

import org.azd.common.ApiVersion;
import org.azd.common.types.QueryParameter;
import org.azd.core.types.TeamMembers;
import org.azd.exceptions.AzDException;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class TeamsMembersRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates the request builder with required values.
     * @param accessTokenCredential Authentication type {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public TeamsMembersRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "projects", ApiVersion.PROJECT_TEAMS_MEMBERS);
    }

    /**
     * Get a list of members for a specific team.
     * @param projectName The name or ID (GUID) of the team project the team belongs to.
     * @param teamName The name or ID (GUID) of the team .
     * @return TeamMembers object {@link TeamMembers}.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<TeamMembers> getAsync(String projectName, String teamName) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + projectName + "/teams" + teamName + "/members";

        return requestAdapter.sendAsync(reqInfo, TeamMembers.class);
    }

    /**
     * Get a list of members for a specific team.
     * @param projectName The name or ID (GUID) of the team project the team belongs to.
     * @param teamName The name or ID (GUID) of the team .
     * @return TeamMembers object {@link TeamMembers}.
     * @throws AzDException Default Api Exception handler.
     */
    public TeamMembers get(String projectName, String teamName) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + projectName + "/teams" + teamName + "/members";

        return requestAdapter.send(reqInfo, TeamMembers.class);
    }

    /**
     * Get a list of members for a specific team.
     * @param projectName The name or ID (GUID) of the team project the team belongs to.
     * @param teamName The name or ID (GUID) of the team .
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return TeamMembers object {@link TeamMembers}.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<TeamMembers> getAsync(String projectName, String teamName, Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + projectName + "/teams" + teamName + "/members";

        if (requestConfiguration != null) {
            final var config = new RequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.sendAsync(reqInfo, TeamMembers.class);
    }

    /**
     * Get a list of members for a specific team.
     * @param projectName The name or ID (GUID) of the team project the team belongs to.
     * @param teamName The name or ID (GUID) of the team .
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return TeamMembers object {@link TeamMembers}.
     * @throws AzDException Default Api Exception handler.
     */
    public TeamMembers get(String projectName, String teamName, Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + projectName + "/teams" + teamName + "/members";

        if (requestConfiguration != null) {
            final var config = new RequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.send(reqInfo, TeamMembers.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
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
