# Build

- [REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/build/builds?view=azure-devops-rest-6.1)
- API Version: 6.1

## Example

Before getting started you require personal access token to authenticate with **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

You are required to create a connection object before calling Build Api.

```java
public class Main {
    public static void main(String[] args) {
        String organisation = "myOrganisationName";
        String project = "myProject";
        String personalAccessToken = "accessToken";

        // Connect Azure DevOps API with organisation name and personal access token.
        var webApi = new AzDClientApi(organisation, project, personalAccessToken);

        // call the respective API with created webApi client connection object;
        var build = webApi.getBuildApi();
        try {
            
            // clone a build pipeline/definition
            build.cloneBuildDefinition("Deploy-WebApp-CI", "Deploy-WebApp-CI-Copy");
        
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
            
            // get the file contents from a source provider repository
            // Name of the source provider, service endpoint id, complete name of repository name,
            // branch name and the name of file to get the contents from.
            build.getFileContents("Github", "a7054ra9-0a34-46ac-bfdf-b8a1da865tdfd6",
                    "hkarthik7/PSDB", "master", "LICENSE");
            
            // Get the list of files and folders from the source provider repository path
            build.getPathContents("Github", "a7054ra9-0a34-46ac-bfdf-b8a1da865tdfd6",
                    "hkarthik7/PSDB", "master", "/");
            
            // Get the build timeline with build id.
            build.getTimeline(122);
            
            // Get the stage name, state of the stage and result of the stage from build timeline API
            var timeline = b.getTimeline(122);
            for(var record: timeline.getRecords()) {
                System.out.println(record.getName() + " - " + record.getState() + " - " + record.getResult());
            }

        } catch (AzDException e) {
            e.printStackTrace();
        }
    }
}
```

