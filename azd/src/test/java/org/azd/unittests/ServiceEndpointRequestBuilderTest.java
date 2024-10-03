package org.azd.unittests;

import org.azd.UnitTestConfiguration;
import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.enums.Instance;
import org.azd.exceptions.AzDException;
import org.azd.legacy.MockParameters;
import org.azd.release.types.ProjectReference;
import org.azd.serviceclient.AzDService;
import org.azd.serviceclient.AzDServiceClient;
import org.azd.serviceendpoint.ServiceEndpointRequestBuilder;
import org.azd.serviceendpoint.types.ServiceEndpointProjectReference;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class ServiceEndpointRequestBuilderTest {
    private static final SerializerContext serializer = InstanceFactory.createSerializerContext();
    private static AzDServiceClient client;
    private static UnitTestConfiguration testConfiguration;
    private static ServiceEndpointRequestBuilder s;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        var file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        var configFile = new File(dir + "/src/test/java/org/azd/config.json");
        var m = serializer.deserialize(file, MockParameters.class);
        testConfiguration = serializer.deserialize(configFile, UnitTestConfiguration.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        var pat = new PersonalAccessTokenCredential(Instance.BASE_INSTANCE.append(organization), project, token);
        client = AzDService.builder()
                .authentication(pat)
                .buildClient();
        s = client.serviceEndpoint();
    }

    @Test(expected = AzDException.class)
    public void shouldCreateAzureRMServiceEndpoint() throws AzDException {
        client.helpers().serviceEndpoint().createAzureRMServiceEndpoint(
                "myEndpoint",
                "servicePrincipalId",
                "servicePrincipalKey",
                "tenantId",
                "subscriptionId",
                "subscriptionName");
    }

    @Test
    public void shouldGetAllServiceEndpoints() throws AzDException {
        s.endpoints().list();
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteAServiceEndpoint() throws AzDException {
        s.endpoints().delete("endpointId", r -> r.queryParameters.projectIds = new String[]{"projectName"});
    }

    @Test
    public void shouldShareServiceEndpointConnection() throws AzDException {
        try {
            var endpointId = s.endpoints().list().getServiceEndpoints()
                    .stream()
                    .filter(x -> x.getName().equals("myEndpoint"))
                    .findFirst()
                    .get()
                    .getId();
            var seProjectRefs = new ServiceEndpointProjectReference();
            var projectRef = new ProjectReference();
            projectRef.setName("projectName");
            seProjectRefs.setProjectReference(projectRef);
            seProjectRefs.setName("mySharedConnection");
            s.endpoints().share(endpointId, List.of(seProjectRefs));
        } catch (Exception ignored) {
        }
    }
}
