# Core

- [REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/core/?view=azure-devops-rest-6.1)
- API Version: 6.1

## Example

Before getting started you require personal access token to authenticate with **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

You are required to create a connection object before calling Core Api.

```java
public class Main {
    public static void main(String[] args) {
        String organisation = "myOrganisationName";
        String project = "myProject";
        String personalAccessToken = "accessToken";

        // Connect Azure DevOps API with organisation name and personal access token.
        var webApi = new AzDClientApi(organisation, project, personalAccessToken);

        // call the respective API with created webApi client connection object;
        var core = webApi.getCoreApi();
        try {        
            // create a new project
            // This creates a default project with scrum process
            core.createProject("projectName", "description");
    
            // create project with additional parameters. You can aquire the template type id by
            // running core.getProcesses()
            core.createProject("projectName", "description", "sourceControlType", "templateTypeId");
    
            // create a new team
            core.createTeam("projectName", "teamName");
    
            // delete a project
            core.deleteProject("projectId");
    
            // get a project by name
            core.getProject("projectName");
    
            // update a project
            HashMap<String, Object> projectParameters = new HashMap<>(){{
                put("name", "new name for the project");
                put("description", "new description for the project");
            }};
            core.updateProject("projectId", projectParameters);
    
            core.getProcesses().getProcesses().stream().forEach(name -> System.out.println(name.getName()));
        } catch (AzDException | ConnectionException e) {
            e.printStackTrace();
        }
    }
}
```