package org.azd.unittests;

import org.azd.MockParameters;
import org.azd.UnitTestConfiguration;
import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.dashboard.DashboardRequestBuilder;
import org.azd.dashboard.types.Dashboard;
import org.azd.dashboard.types.DashboardGroup;
import org.azd.dashboard.types.Widget;
import org.azd.dashboard.types.WidgetSize;
import org.azd.enums.Instance;
import org.azd.exceptions.AzDException;
import org.azd.serviceclient.AzDService;
import org.azd.serviceclient.AzDServiceClient;
import org.azd.utils.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

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
        String project = testConfiguration.properties.core.projectName;
        var pat = new PersonalAccessTokenCredential(Instance.BASE_INSTANCE.append(organization), project, token);
        client = AzDService.builder()
                .authentication(pat)
                .buildClient();
        d = client.dashboard();
        teamName = testConfiguration.properties.core.teamName;
        createTeamIfNotExists();
    }

    @Test
    public void shouldListDashboards() {
        try {
            var dashboards = d.dashboards().list(teamName);
            assertNotNull(dashboards);
            assertNotNull(dashboards.getDashboards());
            assertTrue(dashboards.getDashboards().size() > 0);
        } catch (AzDException ignored){}
    }

    @Test
    public void shouldGetADashboard() {
        try {
            var dashboards = d.dashboards().list(teamName);
            var dashboardId = dashboards.getDashboards().get(0).getId();
            var dashboard = d.dashboards().get(teamName, dashboardId);
            assertNotNull(dashboard);
            assertNotNull(dashboard.getId());
            assertEquals(dashboardId, dashboard.getId());
        } catch (AzDException ignored){}
    }

    @Test
    public void shouldCreateAndDeleteDashboard() {
        try {
            var dashboard = new Dashboard();
            dashboard.setName("TestDashboard-JavaSDK");
            dashboard.setDescription("Created by azure-devops-java-sdk test");

            var created = d.dashboards().create(teamName, dashboard);
            assertNotNull(created);
            assertNotNull(created.getId());
            assertEquals("TestDashboard-JavaSDK", created.getName());

            // Clean up
            d.dashboards().delete(teamName, created.getId());
        } catch (AzDException ignored){}
    }

    @Test
    public void shouldReplaceDashboard() {
        try {
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
        } catch (AzDException ignored){}
    }

    @Test
    public void shouldGetWidgetTypes() {
        try {
            var widgetTypes = d.widgetTypes().list("project_team");
            assertNotNull(widgetTypes);
            assertNotNull(widgetTypes.getWidgetTypes());
            assertTrue(widgetTypes.getWidgetTypes().size() > 0);
        } catch (AzDException ignored){}
    }

    @Test
    public void shouldListWidgets() {
        try {
            var dashboardList = d.dashboards().list(teamName);
            assertNotNull(dashboardList);
            if (dashboardList.getDashboards() == null || dashboardList.getDashboards().isEmpty()) return;
            var dashboardId = dashboardList.getDashboards().get(0).getId();
            var widgets = d.widgets().list(teamName, dashboardId);
            assertNotNull(widgets);
        } catch (AzDException ignored){}
    }

    @Test
    public void shouldCreateAndDeleteWidget() {
        try {
            var dashboardList = d.dashboards().list(teamName);
            assertNotNull(dashboardList);
            if (dashboardList.getDashboards() == null || dashboardList.getDashboards().isEmpty()) return;
            var dashboardId = dashboardList.getDashboards().get(0).getId();

            var widgetTypes = d.widgetTypes().list("project_team");
            assertNotNull(widgetTypes);
            if (widgetTypes.getWidgetTypes() == null || widgetTypes.getWidgetTypes().isEmpty()) return;
            var contributionId = widgetTypes.getWidgetTypes().get(0).getContributionId();
            var allowedSizes = widgetTypes.getWidgetTypes().get(0).getAllowedSizes();

            var widget = new Widget();
            widget.setName("TestWidget-JavaSDK");
            widget.setContributionId(contributionId);
            if (allowedSizes != null && !allowedSizes.isEmpty()) {
                widget.setSize(allowedSizes.get(0));
            } else {
                var size = new WidgetSize();
                size.setColumnSpan(2);
                size.setRowSpan(1);
                widget.setSize(size);
            }

            var created = d.widgets().create(teamName, dashboardId, widget);
            assertNotNull(created);
            assertNotNull(created.getId());

            // Clean up
            d.widgets().delete(teamName, dashboardId, created.getId());
        } catch (AzDException ignored){}
    }

    @Test
    public void shouldReplaceDashboards() {
        try {
            var dashboardList = d.dashboards().list(teamName);
            assertNotNull(dashboardList);
            if (dashboardList.getDashboards() == null || dashboardList.getDashboards().isEmpty()) return;

            var group = new DashboardGroup();
            group.setDashboardEntries(dashboardList.getDashboards());

            var result = d.dashboards().replaceDashboards(teamName, group);
            assertNotNull(result);
        } catch (AzDException ignored){}
    }

    private void createTeamIfNotExists() throws AzDException {
        var projectId = client.core().projects().get().getId();
        try {
            client.core().teams().get(projectId, teamName);
        } catch (AzDException ex) {
            if (ex.getMessage().contains("TeamNotFoundException")) {
                System.out.println("========= Team " + teamName + " doesn't exits. =========");
                System.out.println("========= Creating " + teamName + " =========");
                client.core().teams().create(projectId, teamName);
            }
        }
    }
}
