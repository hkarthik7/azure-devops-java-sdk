package org.azd.enums;

public enum ResourceName {
    Accounts("accounts"),
    /**
     * Artifacts
     */

    Artifact_Details("artifactDetails"),
    Change_Tracking("changeTracking"),
    Feed_Management("feedManagement"),
    Feed_Recycle_Bin("feedRecycleBin"),
    Provenance("provenance"),
    Recycle_Bin("recycleBin"),
    Retention_Policies("retentionPolicies"),
    Service_Settings("serviceSettings"),

    /**
     * Artifacts Package Types
     */
    Maven("maven"),
    Npm("npm"),
    NuGet("nuget"),
    Python("python"),
    Universal("universal"),

    /**
     * Audit
     */

    Actions("actions"),
    Audit_Log("auditLog"),
    Download_Log("downloadLog"),
    Streams("streams"),

    /**
     * Build
     */

    Artifacts("artifacts"),
    Attachments("attachments"),
    Authorized_Resources("authorizedResources"),
    Badge("badge"),
    Builds("builds"),
    Controllers("controllers"),
    Definitions("definitions"),
    Folders("folders"),
    General_Settings("generalSettings"),
    History("history"),
    Latest("latest"),
    Leases("leases"),
    Metrics("metrics"),
    Options("options"),
    Properties("properties"),
    Report("report"),
    Resource_Usage("resourceUsage"),
    Resources("resources"),
    Retention("retention"),
    Settings("settings"),
    Source_Providers("sourceProviders"),
    Stages("stages"),
    Status("status"),
    Tags("tags"),
    Templates("templates"),
    Timeline("timeline"),
    Yaml("yaml"),

    /**
     * Core
     */

    Avatar("avatar"),
    Categorized_Teams("categorizedTeams"),
    Processes("processes"),
    Projects("projects"),
    Teams("teams"),

    /**
     * Dashboard
     */

    Dashboards("dashboards"),
    Widget_Types("widgetTypes"),
    Widgets("widgets"),

    /**
     * Distributed_Task
     */

    Agent_Clouds("agentClouds"),
    Agent_Cloud_Types("agentCloudTypes"),
    Agents("agents"),
    Deployment_Groups("deploymentGroups"),
    Elastic_Pool_Logs("elasticPoolLogs"),
    Elastic_Pools("elasticPools"),
    Environment_Deployment_Records("environmentDeploymentRecords"),
    Environments("environments"),
    Events("events"),
    Kubernetes("kubernetes"),
    Logs("logs"),
    Nodes("nodes"),
    Oidc_Token("oidcToken"),
    Pools("pools"),
    Queues("queues"),
    Records("records"),
    Requests("requests"),
    Targets("targets"),
    Task_Groups("taskGroups"),
    Variable_Groups("variableGroups"),
    Yaml_Schema("yamlSchema"),

    /**
     * Extension_Management
     */

    Installed_Extensions("installedExtensions"),

    /**
     * Favorite
     */

    Favorites("favorites"),

    /**
     * Git
     */

    Annotated_Tags("annotatedTags"),
    Blobs("blobs"),
    Cherry_Picks("cherryPicks"),
    Commits("commits"),
    Diffs("diffs"),
    Forks("forks"),
    Import_Requests("importRequests"),
    Items("items"),
    Merge_Bases("mergeBases"),
    Merges("merges"),
    Policy_Configurations("policyConfigurations"),
    Pull_Request_Attachments("pullRequestAttachments"),
    Pull_Request_Comment_Likes("pullRequestCommentLikes"),
    Pull_Request_Commits("pullRequestCommits"),
    Pull_Request_Iteration_Changes("pullRequestIterationChanges"),
    Pull_Request_Iteration_Statuses("pullRequestIterationStatuses"),
    Pull_Request_Iterations("pullRequestIterations"),
    Pull_Request_Labels("pullRequestLabels"),
    Pull_Request_Properties("pullRequestProperties"),
    Pull_Request_Query("pullRequestQuery"),
    Pull_Request_Reviewers("pullRequestReviewers"),
    Pull_Request_Share("pullRequestShare"),
    Pull_Request_Statuses("pullRequestStatuses"),
    Pull_Request_Thread_Comments("pullRequestThreadComments"),
    Pull_Request_Threads("pullRequestThreads"),
    Pull_Request_Work_Items("pullRequestWorkItems"),
    Pull_Requests("pullRequests"),
    Pushes("pushes"),
    Refs("refs"),
    Refs_Favorites("refsFavorites"),
    Repositories("repositories"),
    Reverts("reverts"),
    Stats("stats"),
    Statuses("statuses"),
    Suggestions("suggestions"),
    Trees("trees"),

    /**
     * Graph
     */

    Avatars("avatars"),
    Descriptors("descriptors"),
    Groups("groups"),
    Membership_States("membershipStates"),
    Memberships("memberships"),
    Provider_Info("providerInfo"),
    Request_Access("requestAccess"),
    Service_Principals("servicePrincipals"),
    Storage_Keys("storageKeys"),
    Subject_Lookup("subjectLookup"),
    Subject_Query("subjectQuery"),
    Users("users"),

    /**
     * Identities
     */

    Identities("identities"),

    /**
     * Member_Entitlement_Management
     */

    Group_Entitlements("groupEntitlements"),
    Member_Entitlements("memberEntitlements"),
    Members("members"),
    Service_Principal_Entitlements("servicePrincipalEntitlements"),
    User_Entitlement_Summary("userEntitlementSummary"),
    User_Entitlements("userEntitlements"),

    /**
     * Notification
     */

    Diagnostic_Logs("diagnosticLogs"),
    Diagnostics("diagnostics"),
    Event_Types("eventTypes"),
    Subscribers("subscribers"),
    Subscriptions("subscriptions"),

    /**
     * Operations
     */

    Operations("operations"),

    /**
     * Permissions_Report
     */

    Permissions_Report("permissionsReport"),
    Report_Download("permissionsReportDownload"),

    /**
     * Pipelines
     */

    Pipelines("pipelines"),
    Preview("preview"),
    Runs("runs"),

    /**
     * Policy
     */

    Configurations("configurations"),
    Evaluations("evaluations"),
    Revisions("revisions"),
    Types("types"),

    /**
     * Profile
     */

    Profiles("profiles"),

    /**
     * Release
     */

    Approvals("approvals"),
    Deployments("deployments"),
    Gates("gates"),
    Manual_Interventions("manualInterventions"),
    Releases("releases"),

    /**
     * Search
     */

    Code_Search_Results("codeSearchResults"),
    Package_Search_Results("packageSearchResults"),
    Search_Repositories("repositories"),
    Tfvc("tfvc"),
    Search_Results("wikiSearchResults"),
    Work_Item_Search_Results("workItemSearchResults"),

    /**
     * Security
     */

    Access_Control_Entries("accessControlEntries"),
    Access_Control_Lists("accessControlLists"),
    Permissions("permissions"),
    Security_Namespaces("securityNamespaces"),

    /**
     * Security_Roles
     */

    Role_Assignments("roleAssignments"),
    Role_Definitions("roleDefinitions"),

    /**
     * Service_Endpoint
     */

    Endpoint_Proxy("endpointProxy"),
    Endpoints("endpoints"),
    Execution_History("executionHistory"),

    /**
     * Service_Hooks
     */

    Consumers("consumers"),
    Notifications("notifications"),
    Publishers("publishers"),

    /**
     * Status
     */

    Health("health"),

    /**
     * Symbol
     */

    Availability("availability"),
    Client("client"),
    Contents("contents"),
    Sym_Srv("symSrv"),

    /**
     * Test
     */

    Code_Coverage("codeCoverage"),
    Iterations("iterations"),
    Points("points"),
    Result_Retention_Settings("resultRetentionSettings"),
    Results("results"),
    Session("session"),
    Test_Suites("testSuites"),
    Test_Cases("testCases"),
    Test_History("testHistory"),

    /**
     * Test_Plan
     */

    Suite_Test_Case("suiteTestCase"),
    Test_Plan_Test_Plans("testPlans"),
    Test_Suite_Entry("testSuiteEntry"),
    Test_Case_Clone("testCaseClone"),
    Test_Plan_Clone("testPlanClone"),
    Test_Point("testPoint"),
    Test_Suite_Clone("testSuiteClone"),
    Variables("variables"),

    /**
     * Test_Results
     */

    Result_Meta_Data("resultMetaData"),
    Test_Attachments("testAttachments"),
    Test_Results_Test_Failure_Type("testFailureType"),
    Test_Results_Test_Log("testLog"),
    Test_Results_Test_Log_Store_Endpoint("testLogStoreEndpoint"),

    /**
     * Tfvc
     */

    Branches("branches"),
    Changesets("changesets"),
    Labels("labels"),
    Shelve_Sets("shelveSets"),

    /**
     * Token_Admin
     */

    Personal_Access_Tokens("personalAccessTokens"),
    Revocation_Rules("revocationRules"),
    Revocations("revocations"),

    /**
     * Tokens
     */

    Pats("pats"),

    /**
     * Wiki
     */
    Page_Moves("pageMoves"),
    Page_Stats("pageStats"),
    Pages("pages"),
    Pages_Batch("pagesBatch"),
    Wikis("wikis"),

    /**
     * Work
     */

    Back_Log_Configuration("backLogConfiguration"),
    Backlogs("backlogs"),
    Board_Columns("boardColumns"),
    Board_Parents("boardParents"),
    Board_Rows("boardRows"),
    Boards("boards"),
    Board_User_Settings("boardUserSettings"),
    Capacities("capacities"),
    Card_Rule_Settings("cardRuleSettings"),
    Card_Settings("cardSettings"),
    Chart_Images("chartImages"),
    Charts("charts"),
    Columns("columns"),
    Delivery_Timeline("deliveryTimeline"),
    Iteration_Capacities("iterationCapacities"),
    Plans("plans"),
    Process_Configuration("processConfiguration"),
    Rows("rows"),
    Task_Board_Columns("taskBoardColumns"),
    Task_Board_Work_Items("taskBoardWorkItems"),
    Team_Days_Off("teamDaysOff"),
    Team_Field_Values("teamFieldValues"),
    Team_Settings("teamSettings"),
    Work_Items_Order("workItemsOrder"),

    /**
     * Work_Item_Tracking
     */

    Account_My_Work_Recent_Activity("accountMyWorkRecentActivity"),
    Artifact_Link_Types("artifactLinkTypes"),
    Artifact_Uri_Query("artifactUriQuery"),
    Classification_Nodes("classificationNodes"),
    Comment_Reactions_Engaged_Users("commentReactionsEngagedUsers"),
    Comments("comments"),
    Comments_Reactions("commentsReactions"),
    Comments_Versions("commentsVersions"),
    Fields("fields"),
    Project_Process_Migration("projectProcessMigration"),
    Queries("queries"),
    RecycleBin("recycleBin"),
    Reporting_Work_Item_Links("reportingWorkItemLinks"),
    Reporting_Work_Item_Revisions("reportingWorkItemRevisions"),
    Send_Mail("sendMail"),
    Temp_Queries("tempQueries"),
    Updates("updates"),
    Wiql("wiql"),
    Work_Item_Icons("workItemIcons"),
    Work_Item_Relation_Types("workItemRelationTypes"),
    Work_Item_Revisions_Discussions("workItemRevisionsDiscussions"),
    Work_Item_Transitions("workItemTransitions"),
    Work_Item_Type_Categories("workItemTypeCategories"),
    Work_Item_Type_States("workItemTypeStates"),
    Work_Item_Types("workItemTypes"),
    Work_Item_Types_Field("workItemTypesField"),
    Work_Items("workItems"),

    /**
     * Work_Item_Tracking_Process
     */

    Behaviors("behaviors"),
    Controls("controls"),
    Layout("layout"),
    Lists("lists"),
    Rules("rules"),
    States("states"),
    System_Controls("systemControls"),
    Work_Item_Types_Behaviors("workItemTypesBehaviors");


    private final String resourceName;

    ResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getName() {
        return resourceName;
    }
}
