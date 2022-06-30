package org.azd;

import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.AzDClient;
import org.azd.interfaces.GitDetails;
import org.azd.interfaces.PolicyDetails;
import org.azd.utils.AzDClientApi;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class PolicyApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static PolicyDetails p;
    private static GitDetails g;
    private static AzDClient webApi;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        webApi = new AzDClientApi(organization, project, token);
        p = webApi.getPolicyApi();
        g = webApi.getGitApi();
    }

    @Test(expected = AzDException.class)
    public void shouldCreatePolicyConfiguration() throws AzDException {
        String repoId = g.getRepository("azure-devops-java-sdk").getId();
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

        p.createPolicyConfiguration("fa4e907d-c16b-4a4c-9dfa-4906e5d171dd", true, false, settings);
    }

    @Test
    public void shouldGetPolicyConfigurations() throws AzDException {
        p.getPolicyConfigurations().getPolicyConfigurations();
    }

    @Test
    public void shouldGetPolicyConfiguration() throws AzDException {
        p.getPolicyConfiguration(1);
    }

    @Test
    public void shouldUpdatePolicyConfiguration() throws AzDException {
        String repoId = g.getRepository("azure-devops-java-sdk").getId();
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

        p.updatePolicyConfiguration(1, "fa4e907d-c16b-4a4c-9dfa-4906e5d171dd", true, false, settings);
    }

    @Test
    public void shouldGetPolicyTypes() throws AzDException {
        p.getPolicyTypes().getPolicyTypes();
    }

    @Test
    public void shouldGetPolicyType() throws AzDException {
        p.getPolicyType("fa4e907d-c16b-4a4c-9dfa-4906e5d171dd");
    }
}
