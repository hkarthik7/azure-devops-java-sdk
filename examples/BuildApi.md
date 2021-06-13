# Build

- [REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/build/builds?view=azure-devops-rest-6.1)
- API Version: 6.1

## Example

Before getting started you require personal access token to authenticate with **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

You are required to set the default parameters before calling Build class in the library.

```java
public class Main {
    public static void main(String[] args) {
        String organisation = "myOrganisationName";
        String project = "myProject";
        String personalAccessToken = "accessToken";
        
        // instantiate AzDDefaultParameters with organisation name, project and personal access token.
        AzDDefaultParameters defaultParameters = new AzDDefaultParameters(organisation, project, personalAccessToken);
    
        // call API with the default parameters;
        BuildApi build = new BuildApi(defaultParameters);
        try {
        
            // delete a build by id
            build.deleteBuild(25);

            // delete a pipeline/definition by definition id
            build.deleteBuildDefinition(9);

            // get a build by Id
            build.getBuild(20);

            // list the build controllers
            build.getBuildControllers();

            // list the build definitions
            build.getBuildDefinitions().getBuildDefinition().stream().forEach(System.out::println);

            // get the logs for a specific build
            build.getBuildLog(20, 3);

            // get all work items associated to a build
            build.getBuildWorkItems(22);

            // list all builds and filter a particular id
            build.getBuilds().getBuildResults().stream().filter(id -> id.getId() == 22).forEach(System.out::println);

            // queue a build with its' definition Id
            build.queueBuild(12);

        } catch (DefaultParametersException | AzDException e) {
            e.printStackTrace();
        }
    }
}
```

