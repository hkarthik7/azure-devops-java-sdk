package org.azd;

import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.AzDClient;
import org.azd.interfaces.ServiceEndpointDetails;
import org.azd.utils.AzDClientApi;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class ServiceEndpointApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static AzDClient webApi;
    private static ServiceEndpointDetails s;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        webApi = new AzDClientApi(organization, project, token);
        s = webApi.getServiceEndpointApi();
    }

    @Test(expected = AzDException.class)
    public void shouldCreateAzureRMServiceEndpoint() throws AzDException {

        s.createAzureRMServiceEndpoint(
                "myEndpoint",
                "servicePrincipalId",
                "servicePrincipalKey",
                "tenantId",
                "subscriptionId",
                "subscriptionName");
    }

    @Test
    public void shouldGetAllServiceEndpoints() throws AzDException {
        s.getServiceEndpoints();
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteAServiceEndpoint() throws AzDException {
        s.deleteServiceEndpoint("endpointId", new String[]{"projectName"});
    }

    @Test(expected = AzDException.class)
    public void shouldShareServiceEndpointConnection() throws AzDException {
        var endpointId = s.getServiceEndpoints().getServiceEndpoints()
                .stream()
                .filter(x -> x.getName().equals("myEndpoint"))
                .findFirst()
                .get()
                .getId();
        s.shareServiceEndpoint(endpointId, "projectName", "mySharedConnection");
    }
}
