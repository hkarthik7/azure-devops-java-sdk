package org.azd.core.projects;

import org.azd.common.ApiVersion;
import org.azd.core.types.*;
import org.azd.exceptions.AzDException;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.LinkedHashMap;
import java.util.concurrent.CompletableFuture;

public class ProjectsRequestBuilder extends BaseRequestBuilder {
    public ProjectsRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "projects", ApiVersion.PROJECT);
    }

    /***
     * Creates a default scrum project
     * @param projectName pass the project name
     * @param description pass the description for the project
     * @throws AzDException Default Api Exception handler.
     * @return object with link to the project
     */
    public CompletableFuture<OperationReference> create(String projectName, String description) throws AzDException {
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
    public CompletableFuture<OperationReference> create(String projectName, String description,
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
    public CompletableFuture<OperationReference> delete(String projectId) throws AzDException {
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
    public CompletableFuture<Project> get(String projectName) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + projectName;

        return requestAdapter.sendAsync(reqInfo, Project.class);
    }

    /***
     * Get the current project name. This should be set when creating the service client object using AzDServiceClient {@link org.azd.serviceClient.AzDServiceClient}
     * @throws AzDException Default Api Exception handler.
     * @return project object {@link Project}
     */
    public CompletableFuture<Project> get() throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + project;

        return requestAdapter.sendAsync(reqInfo, Project.class);
    }

    /***
     * Get a collection of team project properties.
     * @param projectId provide the project guid not the project name
     * @throws AzDException Default Api Exception handler.
     * @return ProjectProperties {@link ProjectProperties}
     */
    public CompletableFuture<ProjectProperties> getProperties(String projectId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + projectId + "/properties";
        reqInfo.apiVersion = ApiVersion.PROJECT_PROPERTIES;

        return requestAdapter.sendAsync(reqInfo, ProjectProperties.class);
    }

    /***
     * Get a collection of team project properties.
     * @throws AzDException Default Api Exception handler.
     * @return ProjectProperties {@link ProjectProperties}
     */
    public CompletableFuture<ProjectProperties> getProperties() throws AzDException {
        var projectId = get().join().getId();

        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + projectId + "/properties";
        reqInfo.apiVersion = ApiVersion.PROJECT_PROPERTIES;

        return requestAdapter.sendAsync(reqInfo, ProjectProperties.class);
    }

    /***
     * Get all projects in the organization that the authenticated user has access to.
     * @throws AzDException Default Api Exception handler.
     * @return array of projects {@link Projects}
     */
    public CompletableFuture<Projects> list() throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;

        return requestAdapter.sendAsync(reqInfo, Projects.class);
    }


}
