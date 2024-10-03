# Pipelines

- [REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/pipelines/?view=azure-devops-rest-6.1)
- API Version: 6.1

## Example

Before getting started you require personal access token to authenticate to **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

You are required to create a connection object before calling Accounts Api.

```java
public class Main {
    public static void main(String[] args) {
        String organisation = "myOrganisationName";
        String personalAccessToken = "accessToken";
        String project = "projectName";
        
        // Connect Azure DevOps API with organisation name and personal access token.
        var webApi = new AzDClientApi(organisation, project, personalAccessToken);
    
        // call the respective API with created webApi client connection object;
        var pipelines = webApi.getPipelinesApi();
        var git  = webApi.getGitApi();

        try {
            // get Pipeline artifacts with pipeline id, build id and artifact name
            pipelines.getArtifacts(22, 41, "drop");
            
            // get pipeline artifacts with optional values
            pipelines.getArtifacts(22, 41, "drop", PipelinesExpandOptions.SIGNEDCONTENT);
            
            // List all pipelines
            pipelines.getPipelines();
            
            // Get pipeline logs with log Id
            pipelines.getPipelineLog(22, 41, 1);
            
            // Get a pipeline's logs listed
            pipelines.getPipelineLog(22, 41);
            
            // Create a new pipeline with pipeline name,
            // folder name, path to yaml file, repository Id and repository name
            String repoId = git.getRepository("newRepo").getId();
            pipelines.createPipeline("Demo-Pipeline-CI", "/", "/azure-pipelines.yaml", repoId, "newRepo");
            
            // Queue a dry run of the pipeline and get the yaml file as a result
            pipelines.previewPipeline(22, true);
            
            // Run a pipeline with id
            pipelines.runPipeline(22);

        } catch (AzDException e) {
            e.printStackTrace();
        }
    }
}
```

