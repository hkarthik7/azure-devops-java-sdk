# Release

- [REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/release/?view=azure-devops-rest-6.1)
- API Version: 6.1

## Example

Before getting started you require personal access token to authenticate with **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

You are required to set the default parameters before calling Core class in the library.

```java
public class Main {
    public static void main(String[] args) {
        String organisation = "myOrganisationName";
        String project = "myProject";
        String personalAccessToken = "accessToken";

        // Create a connection object with organisation name, project and personal access token.
        var connection = new Connection(organisation, project, personalAccessToken);

        // call API with default connection object;
        var build = new BuildApi(defaultParameters);
        var buildNumber = build.getBuild(176).getBuildNumber();
        var release = new ReleaseApi(defaultParameters);
        
        try {
            // create a release with the following parameters
            // release definition/pipeline id;
            // description for the release
            // artifact alias name (This is usually will be the name of build pipeline name prefixed with _)
            // artifact id (build number)
            // build pipeline name
            // isDraft - false/true
            release.createRelease(2, "Sample Release", "_Demo-CI", buildNumber,
                    "Demo-CI", false);

            // get a release
            release.getRelease("definition id");
            
            // get all releases
            release.getReleases();
            
            // get release environment
            var res = release.getRelease(4, SingleReleaseExpands.TASKS);
            release.getReleaseEnvironment(res.getId(), res.getEnvironments().stream().findFirst().get().getId());
            
            // get release definitions
            release.getReleaseDefinitions();
            
            // get a release definition
            release.getReleaseDefinition(2);
            
            // get release definition history
            release.getReleaseDefinitionHistory(2);
            
        } catch (AzDException | DefaultParametersException e) {
            e.printStackTrace();
        }
    }
}
```