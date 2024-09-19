# Build

- [REST API](https://learn.microsoft.com/en-us/rest/api/azure/devops/build/?view=azure-devops-rest-7.1)
- API Version: 7.1

## Example

Before getting started you require personal access token to authenticate with **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

You are required to create a client object before calling Build Api.

```java
public class Main {
    public static void main(String[] args) {
        // Organisation Url -> https://dev.azure.com/{organisation} for Azure DevOps services
        // and http://{server:port}/tfs/{collection} for TFS server.
        // Running Instance.BASE_INSTANCE.getInstance() will return -> https://dev.azure.com/
        // or run Instance.BASE_INSTANCE.append("organisationName") which returns
        // https://dev.azure.com/organisationName

        // Declare variables
        String organisationUrl = Instance.BASE_INSTANCE.append("myOrganisation");
        String projectName = "myProject";
        String personalAccessToken = "myPersonalAccessToken";

        // 1) Choose authentication provider
        AccessTokenCredential pat = new PersonalAccessTokenCredential(organisationUrl, projectName, personalAccessToken);
        // or
        AccessTokenCredential oauth = new OAuthAccessTokenCredential(organisationUrl, projectName,
                "appSecret", "authCode", "callbackUrl");

        // 2) Build client using the authentication provider.
        AzDServiceClient client = AzDService.builder().authentication(pat).buildClient();
        // or
        AzDServiceClient client = AzDService.builder().authentication(oauth).buildClient();
        
        try {
            
            // clone a build pipeline/definition
            String definitionName = "Deploy-WebApp-CI";
            String definitionCloneName = "Deploy-WebApp-CI-Copy";
            
            int def = client.build().definitions().list()
                    .getBuildDefinitions()
                    .stream()
                    .filter(x -> x.getName().equals(definitionName))
                    .findFirst()
                    .get()
                    .getId();

            if (!Integer.toString(def).isEmpty()) {
                var definitionObject = definitions().get(def);
                definitionObject.setName(definitionCloneName);
                definitions().create(definitionObject, r -> r.definitionQueryParameters.definitionToCloneId = def);
            }
            
            // You can also use helper package to create a clone of the build pipeline.
            client.helpers().build().cloneBuildDefinition(definitionName, definitionCloneName);
        
            // delete a build by id
            client.build().builds().delete(25);

            // delete a pipeline/definition by definition id
            client.build().definitions().delete(9);

            // get a build by Id
            client.build().builds().get(20);

            // list the build controllers
            client.build().controllers().list();

            // list the build definitions
            client.build().definitions().list().getBuildDefinitions().getBuildDefinition().stream().forEach(System.out::println);

            // get the logs for a specific build
            client.build().builds().logs().get(20, 3);

            // get all work items associated to a build
            client.build().builds().workItems().get(22);

            // list all builds and filter a particular id
            client.build().builds().list().getBuildResults().stream().filter(id -> id.getId() == 22).forEach(System.out::println);

            // queue a build with its' definition Id
            client.build().builds().queue(12);
            
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

