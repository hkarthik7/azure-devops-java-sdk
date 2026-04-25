# Dashboard

- [REST API](https://learn.microsoft.com/en-us/rest/api/azure/devops/dashboard/?view=azure-devops-rest-7.2)
- API Version: 7.2

## Example

Before getting started you require personal access token to authenticate to **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

Or if you are using OAuth token, follow
- [Authorize access to REST APIs with OAuth 2.0](https://learn.microsoft.com/en-us/azure/devops/integrate/get-started/authentication/oauth?view=azure-devops)
- [Use Azure DevOps OAuth 2.0 to create a web app](https://learn.microsoft.com/en-us/azure/devops/integrate/get-started/authentication/azure-devops-oauth?toc=%2Fazure%2Fdevops%2Fmarketplace-extensibility%2Ftoc.json&view=azure-devops)

Use [VsoScope](https://github.com/hkarthik7/azure-devops-java-sdk/blob/feature/v6.0/azd/src/main/java/org/azd/enums/VsoScope.java) to easily access
the API scope values.

```java
public class Main {
    public static void main(String[] args) throws AzDException {
        // Organisation Url -> https://dev.azure.com/{organisation} for Azure DevOps services
        // and http://{server:port}/tfs/{collection} for TFS server.
        // Running Instance.BASE_INSTANCE.getInstance() will return -> https://dev.azure.com/
        // or run Instance.BASE_INSTANCE.append("organisationName") which returns
        // https://dev.azure.com/organisationName

        String organisationUrl = Instance.BASE_INSTANCE.append("myOrganisation");
        String projectName = "myProject";
        String personalAccessToken = "myPersonalAccessToken";
        String teamName = "myTeam";

        // 1) Choose authentication provider
        AccessTokenCredential pat = new PersonalAccessTokenCredential(organisationUrl, projectName,
                personalAccessToken);
        // or
        AccessTokenCredential oauth = new OAuthAccessTokenCredential(organisationUrl, projectName,
                "appSecret", "authCode", "callbackUrl");

        // 2) Build client using the authentication provider.
        AzDServiceClient client = AzDService.builder().authentication(pat).buildClient();
        // or
        AzDServiceClient client = AzDService.builder().authentication(oauth).buildClient();

        // Use client object to call the APIs.

        // -- Dashboards --

        // list all dashboards for a team
        client.dashboard().dashboards().list(teamName);

        // get a specific dashboard by ID
        client.dashboard().dashboards().get(teamName, "dashboardId");

        // create a new dashboard
        Dashboard dashboard = new Dashboard();
        dashboard.setName("My Dashboard");
        dashboard.setDescription("Created via azure-devops-java-sdk");
        Dashboard created = client.dashboard().dashboards().create(teamName, dashboard);

        // replace (update) a dashboard
        created.setDescription("Updated description");
        client.dashboard().dashboards().replace(teamName, created.getId(), created);

        // bulk update dashboard positions/names in a group (removes omitted dashboards)
        DashboardGroup group = new DashboardGroup();
        group.setDashboardEntries(client.dashboard().dashboards().list(teamName).getDashboards());
        client.dashboard().dashboards().replaceDashboards(teamName, group);

        // delete a dashboard
        client.dashboard().dashboards().delete(teamName, created.getId());

        // -- Async variants --

        // list dashboards asynchronously
        client.dashboard().dashboards().listAsync(teamName)
                .thenAccept(dashboards -> dashboards.getDashboards().forEach(System.out::println));

        // -- Widgets --

        // list all widgets on a dashboard
        client.dashboard().widgets().list(teamName, "dashboardId");

        // get a specific widget
        client.dashboard().widgets().get(teamName, "dashboardId", "widgetId");

        // create a widget on a dashboard
        Widget widget = new Widget();
        widget.setName("My Widget");
        widget.setContributionId("ms.vss-dashboards-web.Microsoft.VisualStudioOnline.Dashboards.MarkdownWidget");
        WidgetSize size = new WidgetSize();
        size.setColumnSpan(2);
        size.setRowSpan(1);
        widget.setSize(size);
        Widget createdWidget = client.dashboard().widgets().create(teamName, "dashboardId", widget);

        // override (replace) the state of a widget
        client.dashboard().widgets().replace(teamName, "dashboardId", createdWidget.getId(), createdWidget);

        // partially update a widget (PATCH)
        Widget patch = new Widget();
        patch.setName("Renamed Widget");
        client.dashboard().widgets().update(teamName, "dashboardId", createdWidget.getId(), patch);

        // delete a widget
        client.dashboard().widgets().delete(teamName, "dashboardId", createdWidget.getId());

        // -- Widget Types --

        // list all available widget types (team scope)
        client.dashboard().widgetTypes().list("project_team");

        // list all available widget types (project scope)
        client.dashboard().widgetTypes().list("project");

        // get metadata for a specific widget contribution
        client.dashboard().widgetTypes().getMetadata("ms.vss-dashboards-web.Microsoft.VisualStudioOnline.Dashboards.MarkdownWidget");
    }
}
```
