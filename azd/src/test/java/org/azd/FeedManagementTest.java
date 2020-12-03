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

    private static ObjectMapper mapper = new ObjectMapper();
    private static String dir;
    private static File file;
    private static MockParameters m;
    private static String organization;
    private static String token;
    private static String project;
    private static AzDDefaultParameters defaultParameters;
    private static FeedManagement f;


    @Before
    public void init() throws IOException {
        dir = System.getProperty("user.dir");
        file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        m = mapper.readValue(file, MockParameters.class);
        organization = m.getO();
        token = m.getT();
        project = m.getP();
        defaultParameters = new AzDDefaultParameters(organization, project, token);
        f = new FeedManagement(defaultParameters);
    }

    @Test
    public void shouldCreateAFeed() throws IOException, DefaultParametersException {
        f.createFeed("myFeed", "My Test Feed", false, true);
    }

    @Test
    public void shouldCreateAFeedView() throws IOException, DefaultParametersException {
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
    public void shouldGetAFeed() throws IOException, DefaultParametersException {
        f.getFeed("myFeed");
    }

    @Test
    public void shouldGetAFeedWithQueryParameters() throws IOException, DefaultParametersException {
        f.getFeed("myFeed", false);
    }

    @Test
    public void shouldGetAFeedPermissions() throws IOException, DefaultParametersException {
        f.getFeedPermissions("TestFeed");
    }

    @Test
    public void shouldGetAFeedPermissionsWithQueryParameters() throws IOException, DefaultParametersException {
        f.getFeedPermissions("TestFeed", true, null, true, true);
    }

    @Test
    public void shouldGetAFeedView() throws IOException, DefaultParametersException {
        f.getFeedView("TestFeed", "myView");
    }

    @Test
    public void shouldGetFeedViews() throws IOException, DefaultParametersException {
        f.getFeedViews("TestFeed");
    }

    @Test
    public void shouldGetFeeds() throws IOException, DefaultParametersException {
        f.getFeeds();
    }

    @Test
    public void shouldGetFeedsWithQueryParameters() throws IOException, DefaultParametersException {
        f.getFeeds("Administrator", true, true);
    }

    @Test
    public void shouldSetFeedPermissions() throws IOException, DefaultParametersException {
        f.setFeedPermissions("TestFeed", null, "", false, "reader");
    }

    @Test
    public void shouldUpdateAFeed() throws IOException, DefaultParametersException {
        f.updateFeed("TestFeed", true, null, false, true);
    }

    @Test
    public void shouldUpdateAFeedView() throws IOException, DefaultParametersException {
        f.updateFeedView("TestFeed", "myView", "release", "organization");
    }
}