package org.azd.core.projects;

import org.azd.common.ApiVersion;
import org.azd.common.types.QueryParameter;
import org.azd.core.types.OperationReference;
import org.azd.core.types.Project;
import org.azd.core.types.Projects;
import org.azd.enums.ProjectState;
import org.azd.exceptions.AzDException;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.LinkedHashMap;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Builder class that constructs requests for Core Projects Api.
 */
public class ProjectsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates the request builder with required values.
     * @param accessTokenCredential Authentication type {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public ProjectsRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "projects", ApiVersion.PROJECT);
    }

    /**
     * Provides functionality to manage Project properties Api.
     * @return PropertiesRequestBuilder {@link PropertiesRequestBuilder}
     */
    public PropertiesRequestBuilder properties() {
        return new PropertiesRequestBuilder(accessTokenCredential, requestAdapter);
    }

    /**
     * Provides functionality to manage Project feature management Api.
     * @return ProjectsFeatureManagementRequestBuilder {@link ProjectsFeatureManagementRequestBuilder}
     */
    public ProjectsFeatureManagementRequestBuilder featureManagement() {
        return new ProjectsFeatureManagementRequestBuilder(accessTokenCredential, requestAdapter);
    }

    /***
     * Creates a default scrum project
     * @param projectName pass the project name
     * @param description pass the description for the project
     * @throws AzDException Default Api Exception handler.
     * @return object with link to the project
     */
    public CompletableFuture<OperationReference> createAsync(String projectName, String description) throws AzDException {
        LinkedHashMap<String, Object> project = new LinkedHashMap<>() {{
            put("name", projectName);
            put("description", description);
            put("capabilities", new LinkedHashMap<String, Object>() {{
                put("versioncontrol", new LinkedHashMap<String, Object>() {{
                    put("sourceControlType", "Git");
                }});
                put("processTemplate", new LinkedHashMap<String, Object>() {{
                    put("templateTypeId", "6b724908-ef14-45cf-84f8-768b5384da45");
                }});
            }});
        }};

        var reqInfo = toPostRequestInformation(project);
        reqInfo.project = null;

        return requestAdapter.sendAsync(reqInfo, OperationReference.class);
    }

    /***
     * Creates a project for given process id
     * @param projectName pass the project name
     * @param description project description
     * @param sourceControlType type of version control
     * @param templateTypeId pass the process id. Run getProcesses to get the list of process id
     * @throws AzDException Default Api Exception handler.
     * @return object with link to the project
     */
    public CompletableFuture<OperationReference> createAsync(String projectName, String description,
                                                             String sourceControlType, String templateTypeId) throws AzDException {
        LinkedHashMap<String, Object> project = new LinkedHashMap<>() {{
            put("name", projectName);
            put("description", description);
            put("capabilities", new LinkedHashMap<String, Object>() {{
                put("versioncontrol", new LinkedHashMap<String, Object>() {{
                    put("sourceControlType", sourceControlType);
                }});
                put("processTemplate", new LinkedHashMap<String, Object>() {{
                    put("templateTypeId", templateTypeId);
                }});
            }});
        }};

        var reqInfo = toPostRequestInformation(project);
        reqInfo.project = null;

        return requestAdapter.sendAsync(reqInfo, OperationReference.class);
    }

    /***
     * Queues a project to be deleted.
     * <p>
     *     You should pass the project id to delete it. Passing the project name
     *     won't delete. To get the project id run getProject() with projectName
     *     and get the Id.
     * </p>
     * @param projectId pass the project id
     * @throws AzDException Default Api Exception handler.
     * @return object of deleted project with url
     */
    public CompletableFuture<OperationReference> deleteAsync(String projectId) throws AzDException {
        var reqInfo = toDeleteRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + projectId;

        return requestAdapter.sendAsync(reqInfo, OperationReference.class);
    }

    /***
     * Get project with the specified id or name
     * @param projectName pass the project name or id
     * @throws AzDException Default Api Exception handler.
     * @return project object {@link Project}
     */
    public CompletableFuture<Project> getAsync(String projectName) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + projectName;

        return requestAdapter.sendAsync(reqInfo, Project.class);
    }

    /***
     * Get project with the specified id or name
     * @param projectName pass the project name or id
     * @throws AzDException Default Api Exception handler.
     * @return project object {@link Project}
     */
    public CompletableFuture<Project> getAsync(String projectName, Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + projectName;

        if (requestConfiguration != null) {
            final var config = new RequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.sendAsync(reqInfo, Project.class);
    }

    /***
     * Get the current project. This should be set when creating the service client object using
     * AzDServiceClient {@link org.azd.serviceclient.AzDServiceClient}
     * @throws AzDException Default Api Exception handler.
     * @return project object {@link Project}
     */
    public CompletableFuture<Project> getAsync() throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + project;

        return requestAdapter.sendAsync(reqInfo, Project.class);
    }

    /***
     * Get all projects in the organization that the authenticated user has access to.
     * @throws AzDException Default Api Exception handler.
     * @return array of project {@link Projects}
     */
    public CompletableFuture<Projects> listAsync() throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;

        return requestAdapter.sendAsync(reqInfo, Projects.class);
    }

    /***
     * Update an existing project's name, abbreviation, description, or restore a project.
     * @param project Project object to perform update operation.
     * @param projectId The project id of the project to update.
     * @throws AzDException Default Api Exception handler.
     * @return OperationReference object {@link OperationReference}
     */
    public CompletableFuture<OperationReference> updateAsync(String projectId, Project project) throws AzDException {
        var reqInfo = toPatchRequestInformation(project);
        reqInfo.project = null;
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + projectId;

        return requestAdapter.sendAsync(reqInfo, OperationReference.class);
    }

    /***
     * Creates a default scrum project
     * @param projectName pass the project name
     * @param description pass the description for the project
     * @throws AzDException Default Api Exception handler.
     * @return object with link to the project
     */
    public OperationReference create(String projectName, String description) throws AzDException {
        LinkedHashMap<String, Object> project = new LinkedHashMap<>() {{
            put("name", projectName);
            put("description", description);
            put("capabilities", new LinkedHashMap<String, Object>() {{
                put("versioncontrol", new LinkedHashMap<String, Object>() {{
                    put("sourceControlType", "Git");
                }});
                put("processTemplate", new LinkedHashMap<String, Object>() {{
                    put("templateTypeId", "6b724908-ef14-45cf-84f8-768b5384da45");
                }});
            }});
        }};

        var reqInfo = toPostRequestInformation(project);
        reqInfo.project = null;

        return requestAdapter.send(reqInfo, OperationReference.class);
    }

    /***
     * Creates a project for given process id
     * @param projectName pass the project name
     * @param description project description
     * @param sourceControlType type of version control
     * @param templateTypeId pass the process id. Run getProcesses to get the list of process id
     * @throws AzDException Default Api Exception handler.
     * @return object with link to the project
     */
    public OperationReference create(String projectName, String description,
                                     String sourceControlType, String templateTypeId) throws AzDException {
        LinkedHashMap<String, Object> project = new LinkedHashMap<>() {{
            put("name", projectName);
            put("description", description);
            put("capabilities", new LinkedHashMap<String, Object>() {{
                put("versioncontrol", new LinkedHashMap<String, Object>() {{
                    put("sourceControlType", sourceControlType);
                }});
                put("processTemplate", new LinkedHashMap<String, Object>() {{
                    put("templateTypeId", templateTypeId);
                }});
            }});
        }};

        var reqInfo = toPostRequestInformation(project);
        reqInfo.project = null;

        return requestAdapter.send(reqInfo, OperationReference.class);
    }

    /***
     * Queues a project to be deleted.
     * <p>
     *     You should pass the project id to delete it. Passing the project name
     *     won't delete. To get the project id run getProject() with projectName
     *     and get the Id.
     * </p>
     * @param projectId pass the project id
     * @throws AzDException Default Api Exception handler.
     * @return object of deleted project with url
     */
    public OperationReference delete(String projectId) throws AzDException {
        var reqInfo = toDeleteRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + projectId;

        return requestAdapter.send(reqInfo, OperationReference.class);
    }

    /***
     * Get project with the specified id or name
     * @param projectName pass the project name or id
     * @throws AzDException Default Api Exception handler.
     * @return project object {@link Project}
     */
    public Project get(String projectName) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + projectName;

        return requestAdapter.send(reqInfo, Project.class);
    }

    /***
     * Get project with the specified id or name
     * @param projectName pass the project name or id
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @throws AzDException Default Api Exception handler.
     * @return project object {@link Project}
     */
    public Project get(String projectName, Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + projectName;

        if (requestConfiguration != null) {
            final var config = new RequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.send(reqInfo, Project.class);
    }

    /***
     * Get the current project. This should be set when creating the service client object using
     * AzDServiceClient {@link org.azd.serviceclient.AzDServiceClient}
     * @throws AzDException Default Api Exception handler.
     * @return project object {@link Project}
     */
    public Project get() throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + project;
        reqInfo.project = null;

        return requestAdapter.send(reqInfo, Project.class);
    }

    /***
     * Get all projects in the organization that the authenticated user has access to.
     * @throws AzDException Default Api Exception handler.
     * @return array of project {@link Projects}
     */
    public Projects list() throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;

        return requestAdapter.send(reqInfo, Projects.class);
    }

    /***
     * Get all projects in the organization that the authenticated user has access to.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @throws AzDException Default Api Exception handler.
     * @return array of project {@link Projects}
     */
    public Projects list(Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;

        if (requestConfiguration != null) {
            final var config = new ListRequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.send(reqInfo, Projects.class);
    }

    /***
     * Update an existing project's name, abbreviation, description, or restore a project.
     * @param project Project object to perform update operation.
     * @param projectId The project id of the project to update.
     * @throws AzDException Default Api Exception handler.
     * @return OperationReference object {@link OperationReference}
     */
    public OperationReference update(String projectId, Project project) throws AzDException {
        var reqInfo = toPatchRequestInformation(project);
        reqInfo.project = null;
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + projectId;

        return requestAdapter.send(reqInfo, OperationReference.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Include capabilities (such as source control) in the team project result (default: false).
         */
        @QueryParameter(name = "includeCapabilities")
        public Boolean includeCapabilities;
        /**
         * Search within renamed projects (that had such name in the past).
         */
        @QueryParameter(name = "includeHistory")
        public Boolean includeHistory;
    }

    /**
     * Represents the query parameters.
     */
    public static class ListQueryParameters {
        /**
         * Projects to skip.
         */
        @QueryParameter(name = "$skip")
        public Number skip;
        /**
         * Projects to select.
         */
        @QueryParameter(name = "$top")
        public Number top;
        /**
         * Pointer that shows how many projects already been fetched.
         */
        @QueryParameter(name = "continuationToken")
        public Number continuationToken;
        /**
         * Get the team's default image URL.
         */
        @QueryParameter(name = "getDefaultTeamImageUrl")
        public Boolean getDefaultTeamImageUrl;
        /**
         * Filter on team projects in a specific team project state (default: WellFormed).
         */
        @QueryParameter(name = "stateFilter")
        public ProjectState stateFilter;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class ListRequestConfiguration {
        public ListQueryParameters queryParameters = new ListQueryParameters();
    }
}
