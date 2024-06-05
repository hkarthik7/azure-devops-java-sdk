package org.azd.unittests;

import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.enums.FeedRole;
import org.azd.enums.FeedViewType;
import org.azd.enums.FeedVisibility;
import org.azd.enums.Instance;
import org.azd.exceptions.AzDException;
import org.azd.feedmanagement.types.Feed;
import org.azd.feedmanagement.types.FeedView;
import org.azd.legacy.MockParameters;
import org.azd.serviceclient.AzDService;
import org.azd.serviceclient.AzDServiceClient;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.UUID;

public class ArtifactsRequestBuilderTest {
    private static final SerializerContext serializer = InstanceFactory.createSerializerContext();
    private static AzDServiceClient client;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        var file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        var m = serializer.deserialize(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        var pat = new PersonalAccessTokenCredential(Instance.BASE_INSTANCE.append(organization), project, token);
        client = AzDService.builder()
                .authentication(pat)
                .buildClient();
    }

    @Test
    public void shouldCreateAFeed() {
        var feed = new Feed();
        feed.setName("myFeed");
        feed.setDescription("My Test Feed");
        feed.setBadgesEnabled(false);
        feed.setHideDeletedPackageVersions(true);

        try {
            client.artifacts().feedManagement().create(feed);
        } catch (AzDException ignored) {
        }
    }

    @Test
    public void shouldCreateAFeedView() {
        var feedView = new FeedView();
        feedView.setName("TestFeedView");
        feedView.setType(FeedViewType.RELEASE);
        feedView.setVisibility(FeedVisibility.ORGANIZATION);

        try {
            client.artifacts().feedManagement().view().create("myFeed", feedView);
        } catch (AzDException ignored) {
        }
    }

    @Test
    public void shouldDeleteAFeedView() {
        try {
            client.artifacts().feedManagement().view().delete("myFeed", "TestFeedView");
        } catch (AzDException ignored) {
        }
    }

    @Test
    public void shouldDeleteAFeed() {
        try {
            client.artifacts().feedManagement().delete("myFeed");
        } catch (AzDException ignored) {
        }
    }

    @Test
    public void shouldGetAFeed() throws AzDException {
        client.artifacts().feedManagement().get("newTestFeed");
    }

    @Test
    public void shouldGetAFeedWithQueryParameters() {
        try {
            client.artifacts().feedManagement().get("myFeed", false);
        } catch (AzDException ignored) {

        }
    }

    @Test
    public void shouldGetAFeedPermissions() throws AzDException {
        client.artifacts().feedManagement().permissions().get("TestFeed");
    }

    @Test
    public void shouldGetAFeedPermissionsWithQueryParameters() throws AzDException {
        var descriptor = client.locations().getConnectionData().getAuthenticatedUser().getDescriptor();

        client.artifacts().feedManagement().permissions().get("TestFeed", r -> {
            r.queryParameters.includeDeletedFeeds = true;
            r.queryParameters.includeIds = true;
            r.queryParameters.excludeInheritedPermissions = true;
            r.queryParameters.identityDescriptor = descriptor;
        });
    }

    @Test
    public void shouldGetAFeedView() throws AzDException {
        client.artifacts().feedManagement().view().get("TestFeed", "myView");
    }

    @Test
    public void shouldGetFeedViews() throws AzDException {
        client.artifacts().feedManagement().view().list("TestFeed");
    }

    @Test
    public void shouldGetFeeds() throws AzDException {
        client.artifacts().feedManagement().list();
    }

    @Test
    public void shouldGetFeedsWithQueryParameters() throws AzDException {
        client.artifacts().feedManagement().list(r -> {
            r.queryParameters.includeDeletedUpstreams = true;
            r.queryParameters.includeUrls = true;
            r.queryParameters.feedRole = FeedRole.ADMINISTRATOR;
        });
    }

    @Test
    public void shouldSetFeedPermissions() throws AzDException {
        var feedPermissions = client.artifacts().feedManagement().permissions().get("TestFeed");
        client.artifacts().feedManagement().permissions().set("TestFeed", feedPermissions);
    }

    @Test
    public void shouldUpdateAFeed() throws AzDException {
        var feed = client.artifacts().feedManagement().get("TestFeed");
        feed.setBadgesEnabled(false);

        client.artifacts().feedManagement().update(feed.getId(), feed);
    }

    @Test
    public void shouldUpdateAFeedView() throws AzDException {
        var feedView = client.artifacts().feedManagement().view().get("TestFeed", "myView");
        feedView.setVisibility(FeedVisibility.PRIVATE);

        client.artifacts().feedManagement().view().update("TestFeed", feedView.getName(), feedView);
    }

    @Test
    public void shouldCreateAndUpdateAFeed() throws AzDException {
        String feedName = "MyTestFeed-" + UUID.randomUUID();
        try {
            var feed = new Feed();
            feed.setName(feedName);
            feed.setDescription("this is a new feed");
            feed.setBadgesEnabled(true);
            feed.setHideDeletedPackageVersions(true);

            client.artifacts().feedManagement().create(feed);

            Thread.sleep(2000l); // to allow for feed creation
        } catch (AzDException e) {
            // ignore feed already exists
        } catch (InterruptedException e) {
            // ignore wait interrupt
        }
        var feed = client.artifacts().feedManagement().get(feedName);
        client.artifacts().feedManagement().delete(feed.getId());
    }
}
