package org.azd;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.azd.artifacts.feedmanagement.implementation.FeedManagement;
import org.azd.utils.AzDDefaultParameters;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FeedManagementTest {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static FeedManagement f;


    @Before
    public void init() throws IOException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.readValue(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        AzDDefaultParameters defaultParameters = new AzDDefaultParameters(organization, project, token);
        f = new FeedManagement(defaultParameters);
    }

    @Test
    public void shouldCreateAFeed() {
        f.createFeed("myFeed", "My Test Feed", false, true);
    }

    @Test
    public void shouldCreateAFeedView() {
        f.createFeedView("myFeed", "TestFeedView", "release" , "organization");
    }

    @Test
    public void shouldDeleteAFeedView() {
        f.deleteFeedView("myFeed", "TestFeedView");
    }

    @Test
    public void shouldDeleteAFeed() {
        f.deleteFeed("myFeed");
    }

    @Test
    public void shouldGetAFeed() {
        f.getFeed("myFeed");
    }

    @Test
    public void shouldGetAFeedWithQueryParameters() {
        f.getFeed("myFeed", false);
    }

    @Test
    public void shouldGetAFeedPermissions() {
        f.getFeedPermissions("TestFeed");
    }

    @Test
    public void shouldGetAFeedPermissionsWithQueryParameters() {
        f.getFeedPermissions("TestFeed", true, null, true, true);
    }

    @Test
    public void shouldGetAFeedView() {
        f.getFeedView("TestFeed", "myView");
    }

    @Test
    public void shouldGetFeedViews() {
        f.getFeedViews("TestFeed");
    }

    @Test
    public void shouldGetFeeds() {
        f.getFeeds();
    }

    @Test
    public void shouldGetFeedsWithQueryParameters() {
        f.getFeeds("Administrator", true, true);
    }

    @Test
    public void shouldSetFeedPermissions() {
        f.setFeedPermissions("TestFeed", null, "", false, "reader");
    }

    @Test
    public void shouldUpdateAFeed() {
        f.updateFeed("TestFeed", true, null, false, true);
    }

    @Test
    public void shouldUpdateAFeedView() {
        f.updateFeedView("TestFeed", "myView", "release", "organization");
    }
}