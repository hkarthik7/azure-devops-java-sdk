# Feed Management

- [REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/artifacts/feed%20%20management?view=azure-devops-rest-6.1)
- API Version: 6.1

## Example

Before getting started you require personal access token to authenticate with **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

You can omit the project name for calling Feed Management API as it is not a mandatory parameter.
If you do omit the project name you will end up working with feeds across your organisation.
Provide the project name if you want to work with feeds scoped to a project. You can always set the
project name parameter pointing to different project by creating a 'Connection' object.

```java
public class Main {
    public static void main(String[] args) {
        String organisation = "myOrganisationName";
        String project = "myProject";
        String personalAccessToken = "accessToken";

        // Connect Azure DevOps API with organisation name and personal access token.
        var webApi = new AzDClientApi(organisation, project, personalAccessToken);

        // call the respective API with created webApi client connection object;
        var feedManagement = webApi.feedManagementApi();
        try {
            // create new feed
            feedManagement.createFeed("myFeed", "To store maven packages", true, true);

            // create feed view
            feedManagement.createFeedView("myFeed", "myFeedView", "release", "private");

            // delete a feed
            feedManagement.deleteFeed("myUnwantedFeed");

            // delete a feed view in a particular feed
            feedManagement.deleteFeedView("myUnwantedFeed", "myUnwantedFeedView");

            // get a feed by name; This returns a feed object where you can get a particular value from it.
            feedManagement.getFeed("myFeed");
            feedManagement.getFeed("myFeed").getId();
            feedManagement.getFeed("myFeed").getDescription();
            feedManagement.getFeed("myFeed").getUrl();
            feedManagement.getFeed("myFeed").getUpstreamSources();

            // get a feed with optional parameters
            feedManagement.getFeed("myFeed", true);

            // get the permissions for a feed
            feedManagement.getFeedPermissions("myFeed");

            // list all the views in a feed
            feedManagement.getFeedViews("myFeed");

            // list all the feeds; if you don't set project name list of feeds will be retrieved which are scoped to organisation
            feedManagement.getFeeds().getFeed().stream().forEach(System.out::println);

            // update the existing feed;
            feedManagement.updateFeed("myFeed", true, "My new feed", true, true);
        } 
        catch (ConnectionException | AzDException e1) {
            e1.printStackTrace();
        }
    }
}

``` 
