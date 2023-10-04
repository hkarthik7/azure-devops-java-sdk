package org.azd.core.projects;

import org.azd.common.ApiVersion;
import org.azd.common.types.JsonPatchDocument;
import org.azd.core.types.ProjectProperties;
import org.azd.enums.CustomHeader;
import org.azd.exceptions.AzDException;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.concurrent.CompletableFuture;

public class PropertiesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates the request builder with required values.
     * @param accessTokenCredential Authentication type {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public PropertiesRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "projects", ApiVersion.PROJECT_PROPERTIES);
    }

    /***
     * Get a collection of team project properties.
     * @param projectId provide the project guid not the project name
     * @throws AzDException Default Api Exception handler.
     * @return ProjectProperties {@link ProjectProperties}
     */
    public CompletableFuture<ProjectProperties> getAsync(String projectId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + projectId + "/properties";

        return requestAdapter.sendAsync(reqInfo, ProjectProperties.class);
    }

    /***
     * Get a collection of team project properties.
     * @param projectId provide the project guid not the project name
     * @param keys A comma-delimited string of team project property names.
     * Wildcard characters ("?" and "*") are supported. If no key is specified, all properties will be returned.
     * @throws AzDException Default Api Exception handler.
     * @return ProjectProperties {@link ProjectProperties}
     */
    public CompletableFuture<ProjectProperties> getAsync(String projectId, String keys) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + projectId + "/properties";
        reqInfo.setQueryParameter("keys", keys);

        return requestAdapter.sendAsync(reqInfo, ProjectProperties.class);
    }

    /***
     * Get a collection of team project properties.
     * @param projectId provide the project guid not the project name
     * @throws AzDException Default Api Exception handler.
     * @return ProjectProperties {@link ProjectProperties}
     */
    public ProjectProperties get(String projectId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + projectId + "/properties";

        return requestAdapter.send(reqInfo, ProjectProperties.class);
    }

    /***
     * Get a collection of team project properties.
     * @param projectId provide the project guid not the project name
     * @param keys A comma-delimited string of team project property names.
     * Wildcard characters ("?" and "*") are supported. If no key is specified, all properties will be returned.
     * @throws AzDException Default Api Exception handler.
     * @return ProjectProperties {@link ProjectProperties}
     */
    public ProjectProperties get(String projectId, String keys) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + projectId + "/properties";
        reqInfo.setQueryParameter("keys", keys);

        return requestAdapter.send(reqInfo, ProjectProperties.class);
    }

    /***
     * Create, update, and delete team project properties.
     * @param projectId provide the project guid not the project name
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> setAsync(String projectId, JsonPatchDocument projectProperty) throws AzDException {
        var reqInfo = toPatchRequestInformation(projectProperty);
        reqInfo.project = null;
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + projectId + "/properties";
        reqInfo.requestHeaders.add(CustomHeader.JSON_PATCH);

        return requestAdapter.sendPrimitiveAsync(reqInfo);
    }

    /***
     * Create, update, and delete team project properties.
     * @param projectId provide the project guid not the project name
     * @throws AzDException Default Api Exception handler.
     */
    public Void set(String projectId, JsonPatchDocument projectProperty) throws AzDException {
        var reqInfo = toPatchRequestInformation(projectProperty);
        reqInfo.project = null;
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + projectId + "/properties";
        reqInfo.requestHeaders.add(CustomHeader.JSON_PATCH);

        return requestAdapter.sendPrimitive(reqInfo);
    }
}
