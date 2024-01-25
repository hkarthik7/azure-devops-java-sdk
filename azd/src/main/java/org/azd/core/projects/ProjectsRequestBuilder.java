package org.azd.core.projects;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.core.types.OperationReference;
import org.azd.core.types.Project;
import org.azd.core.types.ProjectCreationParameters;
import org.azd.core.types.Projects;
import org.azd.enums.ProjectState;
import org.azd.exceptions.AzDException;
import org.azd.serviceclient.AzDService;

import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Builder class that constructs requests for Core Projects Api.
 */
public class ProjectsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ProjectsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "core", "603fe2ac-9723-48b9-88ad-09305aa6c6e1");

    }

    /**
     * Provides functionality to manage Project properties Api.
     *
     * @return PropertiesRequestBuilder {@link PropertiesRequestBuilder}
     */
    public PropertiesRequestBuilder properties() {
        return new PropertiesRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Creates a project for given process id
     *
     * @param projectCreationParameters Request body to create a new project.
     * @return object with link to the project
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<OperationReference> createAsync(ProjectCreationParameters projectCreationParameters) throws AzDException {
        Objects.requireNonNull(projectCreationParameters, "Project parameters cannot be null.");
        LinkedHashMap<String, Object> body = new LinkedHashMap<>() {{
            put("name", projectCreationParameters.name);
            put("description", projectCreationParameters.description);
            put("capabilities", new LinkedHashMap<String, Object>() {{
                put("versioncontrol", new LinkedHashMap<String, Object>() {{
                    put("sourceControlType", projectCreationParameters.sourceControlType);
                }});
                put("processTemplate", new LinkedHashMap<String, Object>() {{
                    put("templateTypeId", projectCreationParameters.templateTypeId);
                }});
            }});
        }};

        return builder()
                .POST(body)
                .build()
                .executeAsync(OperationReference.class);
    }

    /**
     * Queues a project to be deleted.
     * <p>
     * You should pass the project id to delete it. Passing the project name
     * won't delete. To get the project id run getProject() with projectName
     * and get the Id.
     * </p>
     *
     * @param projectId pass the project id
     * @return object of deleted project with url
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<OperationReference> deleteAsync(String projectId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("projectId", projectId)
                .build()
                .executeAsync(OperationReference.class);
    }

    /**
     * Get project with the specified id or name
     *
     * @param projectId pass the project name or id
     * @return project object {@link Project}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Project> getAsync(String projectId) throws AzDException {
        return builder()
                .serviceEndpoint("projectId", projectId)
                .build()
                .executeAsync(Project.class);
    }

    /**
     * Get project with the specified id or name
     *
     * @param projectId pass the project name or id
     * @return project object {@link Project}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Project> getAsync(String projectId, Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("projectId", projectId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(Project.class);
    }

    /**
     * Get the current project. This should be set when creating the service client object using
     * AzureDevOpsServices {@link AzDService}
     *
     * @return project object {@link Project}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Project> getAsync() throws AzDException {
        return builder()
                .serviceEndpoint("projectId", accessTokenCredential.getProjectName())
                .build()
                .executeAsync(Project.class);
    }

    /**
     * Get all projects in the organization that the authenticated user has access to.
     *
     * @return array of project {@link Projects}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Projects> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(Projects.class);
    }

    /**
     * Get all projects in the organization that the authenticated user has access to.
     *
     * @param requestConfiguration Consumer of request configuration that represent the query parameters.
     * @return array of project {@link Projects}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Projects> listAsync(Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(Projects.class);
    }

    /**
     * Update an existing project's name, abbreviation, description, or restore a project.
     *
     * @param project   Project object to perform update operation.
     * @param projectId The project id of the project to update.
     * @return OperationReference object {@link OperationReference}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<OperationReference> updateAsync(String projectId, Project project) throws AzDException {
        return builder()
                .PATCH(project)
                .serviceEndpoint("projectId", projectId)
                .build()
                .executeAsync(OperationReference.class);
    }

    /**
     * Creates a project for given process id
     *
     * @param projectCreationParameters Request body to create a new project.
     * @return object with link to the project
     * @throws AzDException Default Api Exception handler.
     */
    public OperationReference create(ProjectCreationParameters projectCreationParameters) throws AzDException {
        Objects.requireNonNull(projectCreationParameters, "Project parameters cannot be null.");
        LinkedHashMap<String, Object> body = new LinkedHashMap<>() {{
            put("name", projectCreationParameters.name);
            put("description", projectCreationParameters.description);
            put("capabilities", new LinkedHashMap<String, Object>() {{
                put("versioncontrol", new LinkedHashMap<String, Object>() {{
                    put("sourceControlType", projectCreationParameters.sourceControlType);
                }});
                put("processTemplate", new LinkedHashMap<String, Object>() {{
                    put("templateTypeId", projectCreationParameters.templateTypeId);
                }});
            }});
        }};

        return builder()
                .POST(body)
                .build()
                .execute(OperationReference.class);
    }

    /**
     * Queues a project to be deleted.
     * <p>
     * You should pass the project id to delete it. Passing the project name
     * won't delete. To get the project id run getProject() with projectName
     * and get the Id.
     * </p>
     *
     * @param projectId pass the project id
     * @return object of deleted project with url
     * @throws AzDException Default Api Exception handler.
     */
    public OperationReference delete(String projectId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("projectId", projectId)
                .build()
                .execute(OperationReference.class);
    }

    /**
     * Get project with the specified id or name
     *
     * @param projectId pass the project name or id
     * @return project object {@link Project}
     * @throws AzDException Default Api Exception handler.
     */
    public Project get(String projectId) throws AzDException {
        return builder()
                .serviceEndpoint("projectId", projectId)
                .build()
                .execute(Project.class);
    }

    /**
     * Get project with the specified id or name
     *
     * @param projectId pass the project name or id
     * @return project object {@link Project}
     * @throws AzDException Default Api Exception handler.
     */
    public Project get(String projectId, Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("projectId", projectId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(Project.class);
    }

    /**
     * Get the current project. This should be set when creating the service client object using
     * AzureDevOpsServices {@link AzDService}
     *
     * @return project object {@link Project}
     * @throws AzDException Default Api Exception handler.
     */
    public Project get() throws AzDException {
        return builder()
                .serviceEndpoint("projectId", accessTokenCredential.getProjectName())
                .build()
                .execute(Project.class);
    }

    /**
     * Get all projects in the organization that the authenticated user has access to.
     *
     * @return array of project {@link Projects}
     * @throws AzDException Default Api Exception handler.
     */
    public Projects list() throws AzDException {
        return builder()
                .build()
                .execute(Projects.class);
    }

    /**
     * Get all projects in the organization that the authenticated user has access to.
     *
     * @param requestConfiguration Consumer of request configuration that represent the query parameters.
     * @return array of project {@link Projects}
     * @throws AzDException Default Api Exception handler.
     */
    public Projects list(Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(Projects.class);
    }

    /**
     * Update an existing project's name, abbreviation, description, or restore a project.
     *
     * @param project   Project object to perform update operation.
     * @param projectId The project id of the project to update.
     * @return OperationReference object {@link OperationReference}
     * @throws AzDException Default Api Exception handler.
     */
    public OperationReference update(String projectId, Project project) throws AzDException {
        return builder()
                .PATCH(project)
                .serviceEndpoint("projectId", projectId)
                .build()
                .execute(OperationReference.class);
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

