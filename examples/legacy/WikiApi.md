# Wiki

- [REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/wiki/wikis?view=azure-devops-rest-6.1)
- API Version: 6.1-preview

## Example

Before getting started you require personal access token to authenticate to **Azure DevOps** services REST API.
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

            var wikiCreateParameters = new WikiCreateParameters("/docs", "NewWiki", projectId, repoId, WikiType.CODEWIKI,
                    new GitVersionDescriptor("develop"));
            w.createWiki(wikiCreateParameters);
            
            // Get a wiki page
            wiki.getWiki("NewWiki");
            
            // Get all available Wiki pages
            wiki.getWikis();
            
            // delete a wiki page
            wiki.deleteWiki("MyProjectWiki"); 
            
            // Create a Wiki page
            var wiki = w.getWikis().getWikiPages();
            var wikiId = wiki.get(0).getId();
            var page = "DevOps Ways of Working";
            String contents = "# DevOps Ways of Working \n This is the first line \n This is the second line.";

            // Note that you can get the contents of Markdown from a file and create the wiki page. This Api
            // supports Code wiki which means it commits the file to Azure repo.  
            wiki.createOrUpdateWikiPage(wikiId, page, "Page initial commit", null, "develop", GitVersionType.BRANCH,
                    GitVersionOptions.NONE, contents);
            
            // Delete a wiki page
            var wikis = w.getWikis().getWikiPages();
            var wikiId = wiki.get(0).getId();
            var page = "DevOps Ways of Working";

            wiki.deleteWikiPage(wikiId, page, "Page deleted", "develop", GitVersionType.BRANCH,
                    GitVersionOptions.NONE);
            
            // Get a Wiki page
            var wikis = w.getWikis().getWikiPages();
            var wikiId = wiki.get(0).getId();
            var page = "DevOps Ways of Working";
            
            wiki.getWikiPage(wikiId, false, page, VersionControlRecursionType.FULL,
                    "Get wiki page", "develop", GitVersionType.BRANCH, GitVersionOptions.NONE);
            
            // Get a Wiki page by id
            var wikis = w.getWikis().getWikiPages();
            var wikiId = wiki.get(0).getId();
            var page = "DevOps Ways of Working";

            var wikiPage = w.getWikiPage(wikiId, false, page, VersionControlRecursionType.FULL,
                    "Get wiki page", "develop", GitVersionType.BRANCH, GitVersionOptions.NONE);
            
            wiki.getWikiPageById(wikiPage.getId().toString(), wikiId, true, VersionControlRecursionType.FULL);
            
            // Get the contents of the Wiki page
            var wikis = w.getWikis().getWikiPages();
            var wikiId = wiki.get(0).getId();
            var page = "DevOps Ways of Working";

            var wikiPage = w.getWikiPage(wikiId, false, page, VersionControlRecursionType.FULL,
                    "Get wiki page", "develop", GitVersionType.BRANCH, GitVersionOptions.NONE);
            
            wiki.getWikiPageContent(wikiPage.getId().toString(), wikiId);
            
            // Download the Wiki page as a Zip file
            var wikis = w.getWikis().getWikiPages();
            var wikiId = wiki.get(0).getId();
            var page = "DevOps Ways of Working";

            var wikiPage = w.getWikiPage(wikiId, false, page, VersionControlRecursionType.FULL,
                    "Get wiki page", "develop", GitVersionType.BRANCH, GitVersionOptions.NONE);
            
            var res = w.getWikiPageAsZip(wikiPage.getId().toString(), wikiId);
            StreamHelper.download(page + ".zip", res);
            
            // Update a wiki page
            var wiki = w.getWikis().getWikiPages();
            var wikiId = wiki.get(0).getId();
            var page = "DevOps Ways of Working";

            var wikiPage = w.getWikiPage(wikiId, false, page, VersionControlRecursionType.FULL,
                    "Get wiki page", "develop", GitVersionType.BRANCH, GitVersionOptions.NONE);
            
            wiki.updateWikiPage(wikiPage.getId().toString(), wikiId, "Updated page content", wikiPage.geteTag(), "# Heading\n" +
                    "This is updated content. \n ## Second Heading \n Place holder for safe landing project.");
        } catch (AzDException e) {
            e.printStackTrace();
        }
    }
}
```