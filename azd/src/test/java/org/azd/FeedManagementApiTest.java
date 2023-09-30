package org.azd;

import org.azd.artifacts.feedmanagement.FeedManagementRequestBuilder;
import org.azd.feedmanagement.types.Feed;
import org.azd.feedmanagement.types.FeedView;
import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.enums.FeedRole;
import org.azd.enums.FeedViewType;
import org.azd.enums.FeedVisibility;
import org.azd.exceptions.AzDException;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.serializer.JsonSerializer;
import org.azd.serviceClient.AzDServiceClient;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.UUID;
import java.util.concurrent.CompletionException;

public class FeedManagementApiTest {

    private static final JsonSerializer serializer = new JsonSerializer();
    private static FeedManagementRequestBuilder f;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = serializer.deserialize(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        AccessTokenCredential accessTokenCredential = new PersonalAccessTokenCredential(organization, project, token);
        AzDServiceClient client = new AzDServiceClient(accessTokenCredential);
        f = client.artifacts().feedManagement();
    }

    @Test(expected = CompletionException.class)
    public void shouldCreateAFeed() throws AzDException {
        var feed = new Feed();
        feed.setName("myFeed");
        feed.setDescription("My Test Feed");
        feed.setBadgesEnabled(false);
        feed.setHideDeletedPackageVersions(true);

        f.create(feed).join();
    }

    @Test(expected = CompletionException.class)
    public void shouldCreateAFeedView() throws AzDException {
        var feedView = new FeedView();
        feedView.setName("TestFeedView");
        feedView.setType(FeedViewType.RELEASE);
        feedView.setVisibility(FeedVisibility.ORGANIZATION);

        f.view().create("myFeed", feedView).join();
    }

    @Test(expected = CompletionException.class)
    public void shouldDeleteAFeedView() throws AzDException {
        f.view().delete("myFeed", "TestFeedView").join();
    }

    @Test(expected = CompletionException.class)
    public void shouldDeleteAFeed() throws AzDException {
        f.delete("myFeed").join();
    }

    @Test
    public void shouldGetAFeed() throws AzDException {
        f.get("newTestFeed").join();
    }

    @Test(expected = CompletionException.class)
    public void shouldGetAFeedWithQueryParameters() throws AzDException {
        f.get("myFeed", false).join();
    }

    @Test
    public void shouldGetAFeedPermissions() throws AzDException {
        f.permissions().get("TestFeed").join();
    }

    @Test
    public void shouldGetAFeedPermissionsWithQueryParameters() throws AzDException {
        f.permissions().get("TestFeed", requestConfiguration -> {
            requestConfiguration.queryParameters.includeDeletedFeeds = true;
            requestConfiguration.queryParameters.excludeInheritedPermissions = false;
            requestConfiguration.queryParameters.identityDescriptor = null;
            requestConfiguration.queryParameters.includeIds = false;
        }).join();
    }

    @Test
    public void shouldGetAFeedView() throws AzDException {
        f.view().get("TestFeed", "myView").join();
    }

    @Test
    public void shouldGetFeedViews() throws AzDException {
        f.view().list("TestFeed").join();
    }

    @Test
    public void shouldGetFeeds() throws AzDException {
        f.list();
    }

    @Test
    public void shouldGetFeedsWithQueryParameters() throws AzDException {
        f.list(r -> {
            r.queryParameters.feedRole = FeedRole.ADMINISTRATOR;
            r.queryParameters.includeDeletedUpstreams = true;
            r.queryParameters.includeUrls = true;
        }).join();
    }

    @Test
    public void shouldSetFeedPermissions() throws AzDException {
        f.permissions().get("TestFeed").thenAcceptAsync(feedPermissions -> {
            try {
                f.permissions().set("TestFeed", feedPermissions);
            } catch (AzDException e) { }
        }).join();
    }

    @Test
    public void shouldUpdateAFeed() throws AzDException {
         var feed = f.get("TestFeed").join();
        feed.setBadgesEnabled(false);
        f.update(feed.getId(), feed);
    }

    @Test
    public void shouldUpdateAFeedView() throws AzDException {
        var feedView = f.view().get("TestFeed", "myView").join();
        feedView.setVisibility(FeedVisibility.PRIVATE);
        f.view().update("TestFeed", feedView.getName(), feedView).join();
    }

    @Test
    public void shouldCreateAndUpdateAFeed() throws AzDException {
        String feedName = "MyTestFeed-" + UUID.randomUUID();
        try {
            var feed = new Feed();
            feed.setName(feedName);
            feed.setDescription("My Test Feed");
            feed.setBadgesEnabled(false);
            feed.setHideDeletedPackageVersions(true);

            f.create(feed).join();
            Thread.sleep(2000l); // to allow for feed creation
        } catch (AzDException e) {
            // ignore feed already exists
        } catch (InterruptedException e) {
            // ignore wait interrupt
        }
        var newFeed = f.get(feedName).join();
        newFeed.setName(feedName);
        newFeed.setDescription("my description");
        newFeed.setBadgesEnabled(true);
        newFeed.setHideDeletedPackageVersions(false);

        f.update(newFeed.getId(), newFeed).join();
        f.delete(newFeed.getId());
    }
}