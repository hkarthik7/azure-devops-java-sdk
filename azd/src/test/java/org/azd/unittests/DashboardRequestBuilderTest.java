package org.azd.unittests;

import org.azd.MockParameters;
import org.azd.UnitTestConfiguration;
import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.dashboard.DashboardRequestBuilder;
import org.azd.dashboard.types.Dashboard;
import org.azd.dashboard.types.Widget;
import org.azd.enums.Instance;
import org.azd.exceptions.AzDException;
import org.azd.serviceclient.AzDService;
import org.azd.serviceclient.AzDServiceClient;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.File;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DashboardRequestBuilderTest {
    private static final SerializerContext serializer = InstanceFactory.createSerializerContext();
    private static AzDServiceClient client;
    private static UnitTestConfiguration testConfiguration;
    private static DashboardRequestBuilder d;
    private static String teamName;

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
        d = client.dashboard();
        teamName = testConfiguration.properties.core.teamName;
    }

    @Test
    public void shouldListDashboards() throws AzDException {
        var dashboards = d.dashboards().list(teamName);
        assertNotNull(dashboards);
        assertNotNull(dashboards.getDashboards());
        assertTrue(dashboards.getDashboards().size() > 0);
    }

    @Test
    public void shouldGetADashboard() throws AzDException {
        var dashboards = d.dashboards().list(teamName);
        var dashboardId = dashboards.getDashboards().get(0).getId();
        var dashboard = d.dashboards().get(teamName, dashboardId);
        assertNotNull(dashboard);
        assertNotNull(dashboard.getId());
        assertEquals(dashboardId, dashboard.getId());
    }

    @Test
    public void shouldCreateAndDeleteDashboard() throws AzDException {
        var dashboard = new Dashboard();
        dashboard.setName("TestDashboard-JavaSDK");
        dashboard.setDescription("Created by azure-devops-java-sdk test");

        var created = d.dashboards().create(teamName, dashboard);
        assertNotNull(created);
        assertNotNull(created.getId());
        assertEquals("TestDashboard-JavaSDK", created.getName());

        // Clean up
        d.dashboards().delete(teamName, created.getId());
    }

    @Test
    public void shouldReplaceDashboard() throws AzDException {
        // Create a dashboard first
        var dashboard = new Dashboard();
        dashboard.setName("TestReplace-JavaSDK");
        dashboard.setDescription("Test replace");

        var created = d.dashboards().create(teamName, dashboard);
        assertNotNull(created);

        try {
            // Update via replace
            created.setDescription("Updated description via replace");
            var replaced = d.dashboards().replace(teamName, created.getId(), created);
            assertNotNull(replaced);
        } finally {
            // Clean up
            d.dashboards().delete(teamName, created.getId());
        }
    }

    @Test
    public void shouldGetWidgetTypes() throws AzDException {
        var widgetTypes = d.widgetTypes().list("project_team");
        assertNotNull(widgetTypes);
        assertNotNull(widgetTypes.getWidgetTypes());
        assertTrue(widgetTypes.getWidgetTypes().size() > 0);
    }
}
