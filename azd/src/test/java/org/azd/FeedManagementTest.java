package org.azd;

import org.azd.artifacts.feedmanagement.implementation.FeedManagement;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.FeedManagementDetails;
import org.azd.utils.AzDDefaultParameters;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class FeedManagementTest {

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
        AzDDefaultParameters defaultParameters = new AzDDefaultParameters(organization, project, token);
        f = new FeedManagement(defaultParameters);
    }

    @Test(expected = AzDException.class)
    public void shouldCreateAFeed() throws DefaultParametersException, AzDException {
        f.createFeed("myFeed", "My Test Feed", false, true);
    }

    @Test(expected = AzDException.class)
    public void shouldCreateAFeedView() throws DefaultParametersException, AzDException {
        f.createFeedView("myFeed", "TestFeedView", "release" , "organization");
    }

    @Test
    public void shouldDeleteAFeedView() throws DefaultParametersException, AzDException {
        f.deleteFeedView("myFeed", "TestFeedView");
    }

    @Test
    public void shouldDeleteAFeed() throws DefaultParametersException, AzDException {
        f.deleteFeed("myFeed");
    }

    @Test(expected = AzDException.class)
    public void shouldGetAFeed() throws DefaultParametersException, AzDException {
        f.getFeed("myFeed");
    }

    @Test(expected = AzDException.class)
    public void shouldGetAFeedWithQueryParameters() throws DefaultParametersException, AzDException {
        f.getFeed("myFeed", false);
    }

    @Test
    public void shouldGetAFeedPermissions() throws DefaultParametersException, AzDException {
        f.getFeedPermissions("TestFeed");
    }

    @Test(expected = AzDException.class)
    public void shouldGetAFeedPermissionsWithQueryParameters() throws DefaultParametersException, AzDException {
        f.getFeedPermissions("TestFeed", true, null, true, true);
    }

    @Test
    public void shouldGetAFeedView() throws DefaultParametersException, AzDException {
        f.getFeedView("TestFeed", "myView");
    }

    @Test
    public void shouldGetFeedViews() throws DefaultParametersException, AzDException {
        f.getFeedViews("TestFeed");
    }

    @Test
    public void shouldGetFeeds() throws DefaultParametersException, AzDException {
        f.getFeeds();
    }

    @Test
    public void shouldGetFeedsWithQueryParameters() throws DefaultParametersException, AzDException {
        f.getFeeds("Administrator", true, true);
    }

    @Test(expected = AzDException.class)
    public void shouldSetFeedPermissions() throws DefaultParametersException, AzDException {
        f.setFeedPermissions("TestFeed", null, "", false, "reader");
    }

    @Test(expected = AzDException.class)
    public void shouldUpdateAFeed() throws DefaultParametersException, AzDException {
        f.updateFeed("TestFeed", true, null, false, true);
    }

    @Test
    public void shouldUpdateAFeedView() throws DefaultParametersException, AzDException {
        f.updateFeedView("TestFeed", "myView", "release", "organization");
    }
}