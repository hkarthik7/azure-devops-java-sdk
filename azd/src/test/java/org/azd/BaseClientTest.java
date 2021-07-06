package org.azd;

import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.connection.Connection;
import org.azd.utils.BaseClient;
import org.azd.utils.ResourceId;
import org.azd.utils.Url;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class BaseClientTest {

    @Test
    public void shouldMockGetRequestToAPI() throws ConnectionException, AzDException {
        // Given
        String organization = "Test";
        String token = "myPersonalAccessToken";

        // When
        Connection defaultParameters = new Connection(organization, token);
        String projectUrl = Url.buildRequestUrl(
                organization,
                ResourceId.CORE,
                null,
                "projects",
                null,
                null,
                "6.1-preview.4",
                null);

        BaseClient.get(projectUrl, token);
    }

    @Test
    public void shouldMockPostRequestToAPI() throws ConnectionException, AzDException {
        // Given
        String organization = "Test";
        String project = "AzD";
        String token = "myPersonalAccessToken";

        // When
        Connection defaultParameters = new Connection(organization, token);

        String feedUrl = Url.buildRequestUrl(
                organization,
                ResourceId.PACKAGING,
                    project,
                    "packaging/Feeds",
                    null,
                    "TestFeed/packagemetricsbatch",
                    "6.1-preview.1",
                    null);

        // Mock the package Id to call Feed Management API
        String[] l = new String[]{"00000000-0000-0000-0000-000000000000"};

        var values = new HashMap<String, Object>() {{
            put("packageIds", l);
        }};

        BaseClient.post(feedUrl, token, values);
    }

    @Test
    public void shouldMockPatchRequestToAPI() throws ConnectionException, AzDException {
        // Given
        String organization = "Test";
        String project = "AzD";
        String token = "myPersonalAccessToken";

        // When
        Connection defaultParameters = new Connection(organization, token);

        // Set the permission of a feed
        var permissionSettings = new HashMap<String, Object>() {{
            put("role", "reader");
            put("identityDescriptor", "Microsoft.IdentityModel.Claims.ClaimsIdentity;00000000-0000-0000-0000-000000000000\\mock-user@gmail.com");
            put("isInheritedRole", false);
        }};

        // feed management API accepts list of FeedPermissions
        List<Object> v = List.of(permissionSettings);

        String feedUrl = Url.buildRequestUrl(
                organization,
                ResourceId.PACKAGING,
                project,
                "packaging/Feeds",
                null,
                "00000000-0000-0000-0000-000000000000/permissions",
                "6.1-preview.1",
                null);

        BaseClient.patch(feedUrl, token, v);
    }

    @Test
    public void shouldMockDeleteRequestToAPI() throws ConnectionException, AzDException {
        // Given
        String organization = "Test";
        String project = "AzD";
        String token = "myPersonalAccessToken";

        // When
        Connection defaultParameters = new Connection(organization, token);

        String feedUrl = Url.buildRequestUrl(
                organization,
                ResourceId.PACKAGING,
                project,
                "packaging/Feeds",
                null,
                "PickUp",
                "6.1-preview.1",
                null);

        BaseClient.delete(feedUrl, token);
    }
}