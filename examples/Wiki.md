# Wiki

- [REST API](https://learn.microsoft.com/en-us/rest/api/azure/devops/wiki/wikis?view=azure-devops-rest-7.1)
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

        // Create a Wiki Page
        // It is expected that the documents to be uploaded to wiki should exists in the branch.
        // So, you pass the branch name, type of wiki, Wiki name, project id, repository id and name of the
        // documents folder.
        String projectId = client.core().projects().get().getId();
        String repoId = client.git().repositories().get("myRepo").getId();
        
        GitVersionDescriptor gitVersionDescriptor = new GitVersionDescriptor();
        gitVersionDescriptor.versionType = GitVersionType.BRANCH;
        gitVersionDescriptor.version = "develop";

        WikiCreateParameters wikiCreateParameters = new WikiCreateParameters("/docs", "NewWiki", projectId, repoId, WikiType.CODEWIKI,
                gitVersionDescriptor);

        client.wiki().wikis().create(wikiCreateParameters);

        // Get a wiki page
        client.wiki().wikis().get("NewWiki");

        // Get all available Wiki pages
        client.wiki().wikis().list();

        // delete a wiki page
        client.wiki().wikis().delete("MyProjectWiki");

        // Create a Wiki page
        // Note that you can get the contents of Markdown from a file and create the wiki page. This Api
        // supports Code wiki which means it commits the file to Azure repo.  
        String wikiId = client.wiki().wikis().get("NewWiki").getId();
        
        WikiCreateOrUpdateParameters createOrUpdateParameters = new WikiCreateOrUpdateParameters();
        createOrUpdateParameters.wikiIdentifier = wikiId;
        createOrUpdateParameters.content = "# DevOps Ways of Working \n This is the first line \n This is the second line.";
        
        // For editing please pass eTag version.
        createOrUpdateParameters.eTagVersion = "eTagVersion";

        client.wiki().pages().createOrUpdate(createOrUpdateParameters, r ->
        {
            r.queryParameters.comment = URLHelper.encodeSpecialWithSpace("Page initial commit");
            r.queryParameters.path = "DevOps Ways of Working";
            r.queryParameters.version = "develop";
            r.queryParameters.versionOptions = GitVersionOptions.NONE;
            r.queryParameters.versionType = GitVersionType.BRANCH;
        });

        // Delete a wiki page
        client.wiki().pages().delete("NewWiki", r ->
        {
            r.queryParameters.comment = URLHelper.encodeSpecialWithSpace("Page deleted");
            r.queryParameters.path = "DevOps Ways of Working";
            r.queryParameters.version = "develop";
            r.queryParameters.versionOptions = GitVersionOptions.NONE;
            r.queryParameters.versionType = GitVersionType.BRANCH;
        });

        // Get a Wiki page
        client.wiki().pages().get("NewWiki", r ->
        {
            r.queryParameters.includeContent = false;
            r.queryParameters.path = "DevOps Ways of Working";
            r.queryParameters.version = "develop";
            r.queryParameters.versionOptions = GitVersionOptions.NONE;
            r.queryParameters.versionType = GitVersionType.BRANCH;
            r.queryParameters.recursionLevel = VersionControlRecursionType.FULL;
            r.queryParameters.comment = URLHelper.encodeSpecialWithSpace("Get Wiki page");
        });

        // Get a Wiki page by id
        client.wiki().pages().getById("NewWiki", 2, r ->
        {
            r.queryParameters.includeContent = false;
            r.queryParameters.recursionLevel = VersionControlRecursionType.FULL;
        })

        // Get the contents of the Wiki page
        client.wiki().pages().getAsText("NewWiki", r ->
        {
            r.queryParameters.includeContent = true;
            r.queryParameters.path = "DevOps Ways of Working";
            r.queryParameters.version = "develop";
            r.queryParameters.versionOptions = GitVersionOptions.NONE;
            r.queryParameters.versionType = GitVersionType.BRANCH;
            r.queryParameters.recursionLevel = VersionControlRecursionType.FULL;
            r.queryParameters.comment = URLHelper.encodeSpecialWithSpace("Get Wiki page");
        });

        // Download the Wiki page as a Zip file
        InputStream response = client.wiki().pages().getAsZip("NewWiki", r ->
        {
            r.queryParameters.includeContent = true;
            r.queryParameters.path = "DevOps Ways of Working";
            r.queryParameters.version = "develop";
            r.queryParameters.versionOptions = GitVersionOptions.NONE;
            r.queryParameters.versionType = GitVersionType.BRANCH;
            r.queryParameters.recursionLevel = VersionControlRecursionType.FULL;
            r.queryParameters.comment = URLHelper.encodeSpecialWithSpace("Get Wiki page");
        });

        StreamHelper.download("myWikiFile.zip", response);

        // Update a wiki page
        WikiPage page = client.wiki().pages().get("NewWiki", r ->
        {
            r.queryParameters.includeContent = false;
            r.queryParameters.path = "DevOps Ways of Working";
            r.queryParameters.version = "develop";
            r.queryParameters.versionOptions = GitVersionOptions.NONE;
            r.queryParameters.versionType = GitVersionType.BRANCH;
            r.queryParameters.recursionLevel = VersionControlRecursionType.FULL;
            r.queryParameters.comment = URLHelper.encodeSpecialWithSpace("Get Wiki page");
        });

        WikiUpdateParameters updateParameters = new WikiUpdateParameters();
        updateParameters.wikiIdentifier = "NewWiki";
        updateParameters.eTagVersion = "eTagVersion";
        updateParameters.content = "# Heading\n This is updated content. \n ## Second Heading \n Place holder for safe landing project.";
        updateParameters.id = page.getId().toString();
        updateParameters.comment = URLHelper.encodeSpecialWithSpace("Updated page content");

        client.wiki().pages().update(updateParameters);
    }
}
```