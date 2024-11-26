package org.azd.unittests;

import org.azd.UnitTestConfiguration;
import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.enums.Instance;
import org.azd.exceptions.AzDException;
import org.azd.legacy.MockParameters;
import org.azd.serviceclient.AzDService;
import org.azd.serviceclient.AzDServiceClient;
import org.azd.servicehooks.ServiceHooksRequestBuilder;
import org.azd.servicehooks.types.ServiceHooksSubscription;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.LinkedHashMap;

import static org.junit.Assert.assertSame;

public class ServiceHooksRequestBuilderTest {
    private static final SerializerContext serializer = InstanceFactory.createSerializerContext();
    private static AzDServiceClient client;
    private static UnitTestConfiguration testConfiguration;
    private static ServiceHooksRequestBuilder s;

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
        s = client.serviceHooks();
    }

    @Test
    public void shouldCreateASubscription() throws AzDException {
        var project = client.core().projects().get();
        var pI = new LinkedHashMap<String, Object>() {{
            put("buildStatus", "Failed");
            put("definitionName", "Demo-CI");
            put("projectId", project.getId());
        }};

        var cI = new LinkedHashMap<String, Object>() {{
            put("url", "https://mywebsite/api/webhook");
        }};

        var serviceHooksSubscriptions = new ServiceHooksSubscription();
        serviceHooksSubscriptions.setPublisherId("tfs");
        serviceHooksSubscriptions.setEventType("build.complete");
        serviceHooksSubscriptions.setResourceVersion("1.0-preview.1");
        serviceHooksSubscriptions.setConsumerId("webHooks");
        serviceHooksSubscriptions.setConsumerActionId("httpRequest");
        serviceHooksSubscriptions.setPublisherInputs(pI);
        serviceHooksSubscriptions.setConsumerInputs(cI);

        var res = s.subscriptions().create(serviceHooksSubscriptions);

        res.getId();
    }

    @Test
    public void shouldGetASubscription() throws AzDException {
        var subscriptions = s.subscriptions().list();
        s.subscriptions().get(subscriptions.getSubscriptions().stream().findFirst().get().getId());
    }

    @Test
    public void shouldGetSubscriptions() throws AzDException {
        s.subscriptions().list();
    }

    @Test
    public void shouldDeleteASubscription() throws AzDException {
        var subscriptions = s.subscriptions().list();
        s.subscriptions().delete(subscriptions.getSubscriptions().stream().findFirst().get().getId());
    }
}
