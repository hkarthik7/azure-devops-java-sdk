package org.azd;

import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.connection.Connection;
import org.azd.utils.ResourceId;
import org.azd.utils.Url;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("serial")
public class UrlTest {

    @Test
    public void shouldCreateUrlClassAndReturnProjectUrl() throws ConnectionException, AzDException {
        // Given
        String organization = "Test";
        String token = "myPersonalAccessToken";
        String expectedUrl = "https://test.visualstudio.com/_apis/projects?api-version=6.1-preview.4";

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

        // Act and assert
        assertEquals(expectedUrl, projectUrl);
    }

    @Test
    public void shouldCreateUrlClassAndReturnProjectUrlWithQueryParameters() throws ConnectionException, AzDException {
        // Given
        String organization = "Test";
        String token = "myPersonalAccessToken";
        String stateFilter = "all";
        int top = 5;
        String expectedUrl = "https://test.visualstudio.com/_apis/projects?api-version=6.1-preview.4&$top=5&stateFilter=all";

        // When
        Connection defaultParameters = new Connection(organization, token);

        HashMap<String, Object> m = new HashMap<>() {{
            put("$top", top);
            put("stateFilter", stateFilter);
        }};

        String projectUrl = Url.buildRequestUrl(
                organization,
                ResourceId.CORE,
                null,
                "projects",
                null,
                null,
                "6.1-preview.4",
                m);


        // Act and assert
        assertEquals(expectedUrl, projectUrl);
    }
}