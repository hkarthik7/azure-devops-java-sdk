package org.azd.unittests;

import com.fasterxml.jackson.databind.JsonNode;
import org.azd.UnitTestConfiguration;
import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.enums.Instance;
import org.azd.exceptions.AzDException;
import org.azd.legacy.MockParameters;
import org.azd.policy.PolicyRequestBuilder;
import org.azd.policy.types.PolicyConfiguration;
import org.azd.policy.types.PolicyTypeRef;
import org.azd.serviceclient.AzDService;
import org.azd.serviceclient.AzDServiceClient;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class PolicyRequestBuilderTest {
    private static final SerializerContext serializer = InstanceFactory.createSerializerContext();
    private static AzDServiceClient client;
    private static UnitTestConfiguration testConfiguration;
    private static PolicyRequestBuilder p;

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
        p = client.policy();
    }

    @Test(expected = AzDException.class)
    public void shouldCreatePolicyConfiguration() throws AzDException {
        String repoId = client.git().repositories().get(testConfiguration.properties.git.repositoryName).getId();
        var policyConfig = new PolicyConfiguration();
        policyConfig.setEnabled(true);
        policyConfig.setBlocking(false);

        var policyTypeRef = new PolicyTypeRef();
        policyTypeRef.setId("fa4e907d-c16b-4a4c-9dfa-4906e5d171dd");

        var scope = new ArrayList<>();
        var obj = new HashMap<String, Object>() {{
            put("repositoryId", repoId);
            put("refName", "refs/heads/develop");
            put("matchKind", "exact");
        }};

        scope.add(obj);
        var settings = new HashMap<String, Object>() {{
            put("minimumApproverCount", 1);
            put("creatorVoteCounts", false);
            put("scope", scope);
        }};

        policyConfig.setType(policyTypeRef);
        policyConfig.setSettings(settings);

        p.configurations().create(policyConfig);
    }

    @Test
    public void shouldGetPolicyConfigurations() throws AzDException {
        p.configurations().list().getPolicyConfigurations();
    }

    @Test
    public void shouldGetPolicyConfiguration() throws AzDException {
        p.configurations().get(1);
    }

    @Test
    public void shouldUpdatePolicyConfiguration() throws AzDException {
        String repoId = client.git().repositories().get(testConfiguration.properties.git.repositoryName).getId();
        var policyConfig = new PolicyConfiguration();
        policyConfig.setEnabled(true);
        policyConfig.setBlocking(false);

        var policyTypeRef = new PolicyTypeRef();
        policyTypeRef.setId("fa4e907d-c16b-4a4c-9dfa-4906e5d171dd");

        var scope = new ArrayList<>();
        var obj = new HashMap<String, Object>() {{
            put("repositoryId", repoId);
            put("refName", "refs/heads/develop");
            put("matchKind", "exact");
        }};

        scope.add(obj);
        var settings = new HashMap<String, Object>() {{
            put("minimumApproverCount", 1);
            put("creatorVoteCounts", false);
            put("scope", scope);
        }};

        policyConfig.setType(policyTypeRef);
        policyConfig.setSettings(settings);

        p.configurations().update(1, policyConfig);
    }

    @Test
    public void shouldGetPolicyTypes() throws AzDException {
        p.types().list();
    }

    @Test
    public void shouldGetPolicyType() throws AzDException {
        p.types().get("fa4e907d-c16b-4a4c-9dfa-4906e5d171dd");
    }
}
