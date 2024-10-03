# Feed Management

- [REST API](https://learn.microsoft.com/en-us/rest/api/azure/devops/artifacts/feed-management?view=azure-devops-rest-7.1)
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

        // create new feed
        Feed feed = new Feed();
        feed.setName("myFeed");
        feed.setDescription("To store maven packages");
        feed.setBadgesEnabled(true);
        feed.setHideDeletedPackageVersions(true);

        client.artifacts().feedManagement().create(feed);

        // create feed view
        FeedView feedView = new FeedView();
        feedView.setName("myFeedView");
        feedView.setType(FeedViewType.RELEASE);
        feedView.setVisibility(FeedVisibility.PRIVATE);

        client.artifacts().feedManagement().view().create("myFeed", feedView);

        // delete a feed
        client.artifacts().feedManagement().delete("myUnwantedFeed");

        // delete a feed view in a particular feed
        client.artifacts().feedManagement().view().delete("myUnwantedFeed", "myUnwantedFeedView");

        // get a feed by name; This returns a feed object where you can get a particular value from it.
        client.artifacts().feedManagement().get("myFeed");
        client.artifacts().feedManagement().get("myFeed").getId();
        client.artifacts().feedManagement().get("myFeed").getDescription();
        client.artifacts().feedManagement().get("myFeed").getUrl();
        client.artifacts().feedManagement().get("myFeed").getUpstreamSources();

        // get a feed with optional parameters
        client.artifacts().feedManagement().get("myFeed", true);

        // get the permissions for a feed
        client.artifacts().feedManagement().permissions().get("myFeed");

        // list all the views in a feed
        client.artifacts().feedManagement().view().get("myFeed");

        // list all the feeds; if you don't set project name list of feeds will be retrieved which are scoped to organisation
        client.artifacts().feedManagement().list().getFeeds().stream().forEach(System.out::println);

        // update the existing feed;
        var myFeed = client.artifacts().feedManagement().get("myFeed");
        myFeed.setHideDeletedPackageVersions(false);
        myFeed.setUpstreamEnabled(true);
        
        client.artifacts().feedManagement().update(myFeed.getId(), myFeed);
    }
}
```