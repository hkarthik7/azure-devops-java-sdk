# Wiki

- [REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/wiki/wikis?view=azure-devops-rest-6.1)
- API Version: 6.1-preview

## Example

Before getting started you require personal access token to authenticate with **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

You are required to create a connection object before calling Wiki Api.

```java
public class Main {
    public static void main(String[] args) {
        String organisation = "myOrganisationName";
        String project = "myProject";
        String personalAccessToken = "accessToken";

        // Connect Azure DevOps API with organisation name and personal access token.
        var webApi = new AzDClientApi(organisation, project, personalAccessToken);

        // call the respective API with created webApi client connection object;
        var wiki = webApi.getWikiApi();
        var core = webApi.getCoreApi();
        var git = webApi.getGitApi();
        try {
            // Create a Wiki Page
            // It is expected that the documents to be uploaded to wiki should exists in the branch.
            // So, you pass the branch name, type of wiki, Wiki name, project id, repository id and name of the
            // documents folder.
            var projectId = core.getProject("my-project").getId();
            var repoId = git.getRepository("testRepository").getId();
            var wikiPage = wiki.getWiki("NewWiki").getName();

            wiki.createWiki("develop", WikiType.CODEWIKI, "MyProjectWiki", projectId, repoId, "/docs");
            
            // Get a wiki page
            wiki.getWiki("NewWiki");
            
            // Get all available Wiki pages
            wiki.getWikis();
            
            // delete a wiki page
            wiki.deleteWiki("MyProjectWiki");   
        } catch (AzDException e) {
            e.printStackTrace();
        }
    }
}
```