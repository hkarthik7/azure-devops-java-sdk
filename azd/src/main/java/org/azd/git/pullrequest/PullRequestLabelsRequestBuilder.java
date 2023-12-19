package org.azd.git.pullrequest;

import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.git.types.WebApiTagDefinition;
import org.azd.git.types.WebApiTagDefinitions;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Request builder to manage pull request labels Api.
 */
public class PullRequestLabelsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public PullRequestLabelsRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "git/repositories", ApiVersion.GIT);
    }

    /***
     * Create a label for a specified pull request. The only required field is
     * the name of the new label.
     * @param repositoryName The repository name of the pull request’s target branch.
     * @param pullRequestId ID of the pull request.
     * @param labelName tag/label name
     * @return WebApi tag object {@link WebApiTagDefinition}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WebApiTagDefinition> createAsync(String repositoryName, int pullRequestId, String labelName)
            throws AzDException {
        var reqInfo = toPostRequestInformation(Map.of("name", labelName));
        reqInfo.serviceEndpoint = service + "/" + repositoryName + "/pullRequests/" + pullRequestId + "/labels";

        return requestAdapter.sendAsync(reqInfo, WebApiTagDefinition.class);
    }

    /***
     * Removes a label from the set of those assigned to the pull request.
     * @param repositoryName The repository name of the pull request’s target branch.
     * @param pullRequestId ID of the pull request.
     * @param labelName tag/label name
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(String repositoryName, int pullRequestId, String labelName) throws AzDException {
        var reqInfo = toDeleteRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + repositoryName + "/pullRequests/" + pullRequestId + "/labels/" + labelName;

        return requestAdapter.sendPrimitiveAsync(reqInfo);
    }

    /***
     * Retrieves a single label that has been assigned to a pull request.
     * @param repositoryName The repository name of the pull request’s target branch.
     * @param pullRequestId ID of the pull request.
     * @param labelName tag/label name
     * @return WebApi tag object {@link WebApiTagDefinition}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WebApiTagDefinition> getAsync(String repositoryName, int pullRequestId, String labelName)
            throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + repositoryName + "/pullRequests/" + pullRequestId + "/labels/" + labelName;

        return requestAdapter.sendAsync(reqInfo, WebApiTagDefinition.class);
    }

    /***
     * Get all the labels assigned to a pull request.
     * @param repositoryName The repository name of the pull request’s target branch.
     * @param pullRequestId ID of the pull request.
     * @return List of WebApi tag object {@link WebApiTagDefinitions}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WebApiTagDefinitions> listAsync(String repositoryName, int pullRequestId)
            throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + repositoryName + "/pullRequests/" + pullRequestId + "/labels";

        return requestAdapter.sendAsync(reqInfo, WebApiTagDefinitions.class);
    }

    /***
     * Create a label for a specified pull request. The only required field is
     * the name of the new label.
     * @param repositoryName The repository name of the pull request’s target branch.
     * @param pullRequestId ID of the pull request.
     * @param labelName tag/label name
     * @return WebApi tag object {@link WebApiTagDefinition}
     * @throws AzDException Default Api Exception handler.
     */
    public WebApiTagDefinition create(String repositoryName, int pullRequestId, String labelName)
            throws AzDException {
        var reqInfo = toPostRequestInformation(Map.of("name", labelName));
        reqInfo.serviceEndpoint = service + "/" + repositoryName + "/pullRequests/" + pullRequestId + "/labels";

        return requestAdapter.send(reqInfo, WebApiTagDefinition.class);
    }

    /***
     * Removes a label from the set of those assigned to the pull request.
     * @param repositoryName The repository name of the pull request’s target branch.
     * @param pullRequestId ID of the pull request.
     * @param labelName tag/label name
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(String repositoryName, int pullRequestId, String labelName) throws AzDException {
        var reqInfo = toDeleteRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + repositoryName + "/pullRequests/" + pullRequestId + "/labels/" + labelName;

        return requestAdapter.sendPrimitive(reqInfo);
    }

    /***
     * Retrieves a single label that has been assigned to a pull request.
     * @param repositoryName The repository name of the pull request’s target branch.
     * @param pullRequestId ID of the pull request.
     * @param labelName tag/label name
     * @return WebApi tag object {@link WebApiTagDefinition}
     * @throws AzDException Default Api Exception handler.
     */
    public WebApiTagDefinition get(String repositoryName, int pullRequestId, String labelName)
            throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + repositoryName + "/pullRequests/" + pullRequestId + "/labels/" + labelName;

        return requestAdapter.send(reqInfo, WebApiTagDefinition.class);
    }

    /***
     * Get all the labels assigned to a pull request.
     * @param repositoryName The repository name of the pull request’s target branch.
     * @param pullRequestId ID of the pull request.
     * @return List of WebApi tag object {@link WebApiTagDefinitions}
     * @throws AzDException Default Api Exception handler.
     */
    public WebApiTagDefinitions list(String repositoryName, int pullRequestId)
            throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + repositoryName + "/pullRequests/" + pullRequestId + "/labels";

        return requestAdapter.send(reqInfo, WebApiTagDefinitions.class);
    }
}
