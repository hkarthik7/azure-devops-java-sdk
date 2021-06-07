package org.azd;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.azd.artifacts.feedmanagement.implementation.FeedManagement;
import org.azd.exceptions.DefaultParametersException;
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
    public void shouldCreateAFeed() throws DefaultParametersException, IOException {
        f.createFeed("myFeed", "My Test Feed", false, true);
    }

    @Test
    public void shouldCreateAFeedView() throws DefaultParametersException, IOException {
        f.createFeedView("myFeed", "TestFeedView", "release" , "organization");
    }

    @Test
    public void shouldDeleteAFeedView() throws DefaultParametersException, IOException {
        f.deleteFeedView("myFeed", "TestFeedView");
    }

    @Test
    public void shouldDeleteAFeed() throws DefaultParametersException, IOException {
        f.deleteFeed("myFeed");
    }

    @Test
    public void shouldGetAFeed() throws DefaultParametersException, IOException {
        f.getFeed("myFeed");
    }

    @Test
    public void shouldGetAFeedWithQueryParameters() throws DefaultParametersException, IOException {
        f.getFeed("myFeed", false);
    }

    @Test
    public void shouldGetAFeedPermissions() throws DefaultParametersException, IOException {
        f.getFeedPermissions("TestFeed");
    }

    @Test
    public void shouldGetAFeedPermissionsWithQueryParameters() throws DefaultParametersException, IOException {
        f.getFeedPermissions("TestFeed", true, null, true, true);
    }

    @Test
    public void shouldGetAFeedView() throws DefaultParametersException, IOException {
        f.getFeedView("TestFeed", "myView");
    }

    @Test
    public void shouldGetFeedViews() throws DefaultParametersException, IOException {
        f.getFeedViews("TestFeed");
    }

    @Test
    public void shouldGetFeeds() throws DefaultParametersException, IOException {
        f.getFeeds();
    }

    @Test
    public void shouldGetFeedsWithQueryParameters() throws DefaultParametersException, IOException {
        f.getFeeds("Administrator", true, true);
    }

    @Test
    public void shouldSetFeedPermissions() throws DefaultParametersException, IOException {
        f.setFeedPermissions("TestFeed", null, "", false, "reader");
    }

    @Test
    public void shouldUpdateAFeed() throws DefaultParametersException, IOException {
        f.updateFeed("TestFeed", true, null, false, true);
    }

    @Test
    public void shouldUpdateAFeedView() throws DefaultParametersException, IOException {
        f.updateFeedView("TestFeed", "myView", "release", "organization");
    }
}