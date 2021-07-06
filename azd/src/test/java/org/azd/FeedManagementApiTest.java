package org.azd;

import org.azd.connection.Connection;
import org.azd.enums.FeedViewType;
import org.azd.enums.FeedVisibility;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.feedmanagement.FeedManagementApi;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.FeedManagementDetails;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class FeedManagementApiTest {

    private static final JsonMapper MAPPER = new JsonMapper();
    private static FeedManagementDetails f;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        Connection defaultParameters = new Connection(organization, project, token);
        f = new FeedManagementApi(defaultParameters);
    }

    @Test(expected = AzDException.class)
    public void shouldCreateAFeed() throws ConnectionException, AzDException {
        f.createFeed("myFeed", "My Test Feed", false, true);
    }

    @Test(expected = AzDException.class)
    public void shouldCreateAFeedView() throws ConnectionException, AzDException {
        f.createFeedView("myFeed", "TestFeedView", FeedViewType.RELEASE, FeedVisibility.ORGANIZATION);
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteAFeedView() throws ConnectionException, AzDException {
        f.deleteFeedView("myFeed", "TestFeedView");
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteAFeed() throws ConnectionException, AzDException {
        f.deleteFeed("myFeed");
    }

    @Test
    public void shouldGetAFeed() throws ConnectionException, AzDException {
        f.getFeed("newTestFeed");
    }

    @Test(expected = AzDException.class)
    public void shouldGetAFeedWithQueryParameters() throws ConnectionException, AzDException {
        f.getFeed("myFeed", false);
    }

    @Test
    public void shouldGetAFeedPermissions() throws ConnectionException, AzDException {
        f.getFeedPermissions("TestFeed");
    }

    @Test(expected = AzDException.class)
    public void shouldGetAFeedPermissionsWithQueryParameters() throws ConnectionException, AzDException {
        f.getFeedPermissions("TestFeed", true, null, true, true);
    }

    @Test
    public void shouldGetAFeedView() throws ConnectionException, AzDException {
        f.getFeedView("TestFeed", "myView");
    }

    @Test
    public void shouldGetFeedViews() throws ConnectionException, AzDException {
        f.getFeedViews("TestFeed");
    }

    @Test
    public void shouldGetFeeds() throws ConnectionException, AzDException {
        f.getFeeds();
    }

    @Test
    public void shouldGetFeedsWithQueryParameters() throws ConnectionException, AzDException {
        f.getFeeds("Administrator", true, true);
    }

    @Test(expected = AzDException.class)
    public void shouldSetFeedPermissions() throws ConnectionException, AzDException {
        f.setFeedPermissions("TestFeed", null, "", false, "reader");
    }

    @Test(expected = AzDException.class)
    public void shouldUpdateAFeed() throws ConnectionException, AzDException {
        f.updateFeed("TestFeed", true, null, false, true);
    }

    @Test
    public void shouldUpdateAFeedView() throws ConnectionException, AzDException {
        f.updateFeedView("TestFeed", "myView", "release", "organization");
    }
}