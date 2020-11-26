package org.azd;

import org.azd.exceptions.DefaultParametersException;
import org.junit.Test;
import org.azd.utils.AzDDefaultParameters;
import org.azd.utils.RequestAPI;
import org.azd.utils.ResourceId;
import org.azd.utils.Url;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("serial")
public class RequestAPITest {

    @Test
    public void shouldMockGetRequestToAPI() throws DefaultParametersException {
        // Given
        String organization = "Test";
        String token = "myPersonalAccessToken";

        // When
        AzDDefaultParameters defaultParameters = new AzDDefaultParameters(organization, token);
        String projectUrl = new Url(defaultParameters).buildRequestUrl(
                ResourceId.CORE,
                null,
                "projects",
                null,
                null,
                "6.1-preview.4",
                null);

        RequestAPI.get(projectUrl, token);
    }

    @Test
    public void shouldMockPostRequestToAPI() throws DefaultParametersException, IOException {
        // Given
        String organization = "Test";
        String project = "AzD";
        String token = "myPersonalAccessToken";

        // When
        AzDDefaultParameters defaultParameters = new AzDDefaultParameters(organization, token);

        String feedUrl = new Url(defaultParameters).buildRequestUrl(
                ResourceId.PACKAGING,
                    project,
                    "packaging/Feeds",
                    null,
                    "TestFeed/packagemetricsbatch",
                    "6.1-preview.1",
                    null);

        // Mock the package Id to call Feed Management API
        String[] l = new String[]{"d4010626-c2be-4baf-8e24-e9fd0218d4ad"};

        var values = new HashMap<String, Object>() {{
            put("packageIds", l);
        }};

        RequestAPI.post(feedUrl, token, values);
    }

    @Test
    public void shouldMockPatchRequestToAPI() throws DefaultParametersException, IOException {
        // Given
        String organization = "Test";
        String project = "AzD";
        String token = "myPersonalAccessToken";

        // When
        AzDDefaultParameters defaultParameters = new AzDDefaultParameters(organization, token);

        // Set the permission of a feed
        var permissionSettings = new HashMap<String, Object>() {{
            put("role", "reader");
            put("identityDescriptor", "Microsoft.IdentityModel.Claims.ClaimsIdentity;43fd6cf5-e8be-49d0-9d6a-68fe11cb4e59\\mock-user@gmail.com");
            put("isInheritedRole", false);
        }};

        // feed management API accepts list of FeedPermissions
        List<Object> v = List.of(permissionSettings);

        String feedUrl = new Url(defaultParameters).buildRequestUrl(
                ResourceId.PACKAGING,
                project,
                "packaging/Feeds",
                null,
                "910b9285-5a1d-46df-8369-44c25dff01b4/permissions",
                "6.1-preview.1",
                null);

        RequestAPI.patch(feedUrl, token, v);
    }

    @Test
    public void shouldMockDeleteRequestToAPI() throws DefaultParametersException {
        // Given
        String organization = "Test";
        String project = "AzD";
        String token = "myPersonalAccessToken";

        // When
        AzDDefaultParameters defaultParameters = new AzDDefaultParameters(organization, token);

        String feedUrl = new Url(defaultParameters).buildRequestUrl(
                ResourceId.PACKAGING,
                project,
                "packaging/Feeds",
                null,
                "PickUp",
                "6.1-preview.1",
                null);

        RequestAPI.delete(feedUrl, token);
    }
}