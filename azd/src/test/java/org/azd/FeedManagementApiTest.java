package org.azd;

import org.azd.enums.FeedViewType;
import org.azd.enums.FeedVisibility;
import org.azd.exceptions.AzDException;
import org.azd.feedmanagement.types.Feed;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.AzDClient;
import org.azd.interfaces.FeedManagementDetails;
import org.azd.utils.AzDClientApi;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.UUID;

public class FeedManagementApiTest {

    private static final JsonMapper MAPPER = new JsonMapper();
    private static AzDClient webApi;
    private static FeedManagementDetails f;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        webApi = new AzDClientApi(organization, project, token);
        f = webApi.getFeedManagementApi();
    }

    @Test(expected = AzDException.class)
    public void shouldCreateAFeed() throws AzDException {
        f.createFeed("myFeed", "My Test Feed", false, true);
    }

    @Test(expected = AzDException.class)
    public void shouldCreateAFeedView() throws AzDException {
        f.createFeedView("myFeed", "TestFeedView", FeedViewType.RELEASE, FeedVisibility.ORGANIZATION);
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteAFeedView() throws AzDException {
        f.deleteFeedView("myFeed", "TestFeedView");
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteAFeed() throws AzDException {
        f.deleteFeed("myFeed");
    }

    @Test
    public void shouldGetAFeed() throws AzDException {
        f.getFeed("newTestFeed");
    }

    @Test(expected = AzDException.class)
    public void shouldGetAFeedWithQueryParameters() throws AzDException {
        f.getFeed("myFeed", false);
    }

    @Test
    public void shouldGetAFeedPermissions() throws AzDException {
        f.getFeedPermissions("TestFeed");
    }

    @Test(expected = AzDException.class)
    public void shouldGetAFeedPermissionsWithQueryParameters() throws AzDException {
        f.getFeedPermissions("TestFeed", true, null, true, true);
    }

    @Test
    public void shouldGetAFeedView() throws AzDException {
        f.getFeedView("TestFeed", "myView");
    }

    @Test
    public void shouldGetFeedViews() throws AzDException {
        f.getFeedViews("TestFeed");
    }

    @Test
    public void shouldGetFeeds() throws AzDException {
        f.getFeeds();
    }

    @Test
    public void shouldGetFeedsWithQueryParameters() throws AzDException {
        f.getFeeds("Administrator", true, true);
    }

    @Test
    public void shouldSetFeedPermissions() throws AzDException {
        var feedPermissions = f.getFeedPermissions("TestFeed");
        f.setFeedPermissions("TestFeed", feedPermissions);
    }

    @Test
    public void shouldUpdateAFeed() throws AzDException {
         var feed = f.getFeed("TestFeed");
        feed.setBadgesEnabled(false);
        f.updateFeed(feed.getId(), feed);
    }

    @Test
    public void shouldUpdateAFeedView() throws AzDException {
        var feedView = f.getFeedView("TestFeed", "myView");
        feedView.setVisibility(FeedVisibility.PRIVATE);
        f.updateFeedView("TestFeed", feedView.getName(), feedView);
    }

    @Test
    public void shouldCreateAndUpdateAFeed() throws AzDException {
        String feedName = "MyTestFeed-" + UUID.randomUUID();
        try {
            f.createFeed(feedName, "this is a new feed", true, true);
            Thread.sleep(2000l); // to allow for feed creation
        } catch (AzDException e) {
            // ignore feed already exists
        } catch (InterruptedException e) {
            // ignore wait interrupt
        }
        Feed feed = f.getFeed(feedName);
//        f.updateFeed(feed.getId(), feedName, true, "my description", true, false);

        f.deleteFeed(feed.getId());
    }
}