package org.azd;

import org.azd.build.types.Builds;
import org.azd.common.ApiVersion;
import org.azd.common.ResourceId;
import org.azd.enums.CustomHeader;
import org.azd.enums.Instance;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.utils.AzDClientApi;
import org.azd.utils.RestClient;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.text.MessageFormat;
import java.util.Map;

public class RestClientTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static AzDClientApi webApi;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        webApi = new AzDClientApi(organization, project, token);
    }

    @Test
    public void shouldCallBuildApiAndReturnAllBuilds() throws AzDException {
        // GET https://dev.azure.com/{organization}/{project}/_apis/build/builds?api-version=7.1-preview.7
        // The base instance returns -> https://dev.azure.com/
        var requestUrl = MessageFormat.format("{0}/{1}/{2}/_apis/build/builds?api-version={3}",
                Instance.BASE_INSTANCE.getInstance(), webApi.getConnection().getOrganization(),
                webApi.getConnection().getProject(), ApiVersion.BUILD);
        // Pass the request url, connection object, request method, request body (in this case it is null),
        // content type (json), whether to look for redirect url or not and in this case it is false.
        var response = RestClient.send(requestUrl, webApi.getConnection(), RequestMethod.GET,
                null, CustomHeader.JSON, false);

        // Now that we the response, we can deserialize the json and convert it to POJO.
        var mapper = new JsonMapper();
        var builds = mapper.mapJsonResponse(response, Builds.class);

        builds.getBuildResults().get(0).getDefinition().getName();
    }

    @Test
    public void shouldListAllTestRuns() throws AzDException {
        // GET GET https://dev.azure.com/{organization}/{project}/_apis/test/runs?api-version=7.1-preview.3
        // The base instance returns -> https://dev.azure.com/
        // Request method -> Get, connection object, resource id, project, area, id, resource, apiVersion, query string,
        // request body (for post/put/patch) and content type -> defaults to "Accept": "application/json".
        // optionally we can set the custom headers by calling setCustomHeaders(name, value).
        // Adding query string
        // If there are more than one query string, you can create a HashMap<String, Object>() and add the query parameters.
        var response = RestClient.send(RequestMethod.GET, webApi.getConnection(), ResourceId.TEST, webApi.getConnection().getProject(),
                "test/runs", null, null, ApiVersion.TEST_RUNS,
                Map.of("includeRunDetails", true), null, null);

        // If there is no definition found you can create your own definition class and deserialize it or
        // convert it to jsonNode.
        var mapper = new JsonMapper();
        var jsonNode = mapper.convertToJson(response);
        // Test - Runs returns an array of results in {"count": <int>, "value": []} format
        jsonNode.get("value").get(0);
    }
}
