# Pipelines

- [REST API](https://learn.microsoft.com/en-us/rest/api/azure/devops/pipelines/?view=azure-devops-rest-7.1)
- API Version: 7.1

## Example

Before getting started you require personal access token to authenticate to **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

Or if you are using OAuth token, follow
- [Authorize access to REST APIs with OAuth 2.0](https://learn.microsoft.com/en-us/azure/devops/integrate/get-started/authentication/oauth?view=azure-devops)
- [Use Azure DevOps OAuth 2.0 to create a web app](https://learn.microsoft.com/en-us/azure/devops/integrate/get-started/authentication/azure-devops-oauth?toc=%2Fazure%2Fdevops%2Fmarketplace-extensibility%2Ftoc.json&view=azure-devops)

Use [VsoScope](https://github.com/hkarthik7/azure-devops-java-sdk/blob/feature/v6.0/azd/src/main/java/org/azd/enums/VsoScope.java) to easily access
the API scope values.


```java
public class Main {
    public static void main(String[] args) throws AzDException {
        // Organisation Url -> https://dev.azure.com/{organisation} for Azure DevOps services
        // and http://{server:port}/tfs/{collection} for TFS server.
        // Running Instance.BASE_INSTANCE.getInstance() will return -> https://dev.azure.com/
        // or run Instance.BASE_INSTANCE.append("organisationName") which returns
        // https://dev.azure.com/organisationName

        String organisationUrl = Instance.BASE_INSTANCE.append("myOrganisation");
        String projectName = "myProject";
        String personalAccessToken = "myPersonalAccessToken";
        // 1) Choose authentication provider
        AccessTokenCredential pat = new PersonalAccessTokenCredential(organisationUrl, projectName, 
                personalAccessToken);
        // or
        AccessTokenCredential oauth = new OAuthAccessTokenCredential(organisationUrl, projectName,
                "appSecret", "authCode", "callbackUrl");

        // 2) Build client using the authentication provider. 
        AzDServiceClient client = AzDService.builder().authentication(pat).buildClient();
        // or
        AzDServiceClient client = AzDService.builder().authentication(oauth).buildClient();

        // Use client object to call the APIs.

        // get Pipeline artifacts with pipeline id, build id and artifact name
        client.pipelines().artifacts().get(22, 41, r -> r.queryParameters.artifactName = "drop");

        // get pipeline artifacts with optional values
        client.pipelines().artifacts().get(22, 41, r ->
        {
            r.queryParameters.artifactName = "drop";
            r.queryParameters.expand = GetArtifactExpandOptions.SIGNED_CONTENT;
        });

        // List all pipelines
        client.pipelines().pipelines().list();

        // Get pipeline logs with log Id
        client.pipelines().logs().get(22, 41, 1);

        // Get a pipeline's logs listed
        client.pipelines().logs().list(22, 41);

        // Create a new pipeline
        GitRepository repository = client.git().repositories().get("newRepo");

        CreatePipelineRepositoryReference repositoryReference = new CreatePipelineRepositoryReference();
        repositoryReference.repositoryName = repository.getName();
        repositoryReference.repositoryId = repository.getId();

        CreatePipelineConfigurationParameters configurationParameters = new CreatePipelineConfigurationParameters();
        configurationParameters.yamlFilePath = "/azure-pipelines.yaml";
        configurationParameters.type = ConfigurationType.YAML;
        configurationParameters.repository = repositoryReference;

        CreatePipelineParameters pipelineParameters = new CreatePipelineParameters();
        pipelineParameters.name = "Demo-Pipeline-CI";
        pipelineParameters.folder = "/";
        pipelineParameters.configuration = configurationParameters;

        client.pipelines().pipelines().create(pipelineParameters);

        // Queue a dry run of the pipeline and get the yaml file as a result
        RunPipelineParameters pipelineParameters = new RunPipelineParameters();
        pipelineParameters.setPreviewRun(true);

        client.pipelines().preview().preview(22, pipelineParameters);

        // Run a pipeline with id
        RunPipelineParameters runPipelineParameters = new RunPipelineParameters();
        runPipelineParameters.setResources(new RunResourcesParameters());

        client.pipelines().runs().run(22, runPipelineParameters);
    }
}
```