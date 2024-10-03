package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represent feature Ids
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum FeatureManagement {
    /**
     * Continuous delivery with artifact feeds containing NuGet, npm, Maven, Universal, and Python packages
     */
    @JsonProperty("ms.azure-artifacts.feature")
    ARTIFACTS("ms.azure-artifacts.feature"),
    /**
     * Enable the updated Artifacts (Feed) UI experience
     */
    @JsonProperty("ms.azure-artifacts.new-artifacts-preview-feature")
    NEW_ARTIFACTS_FEEDS_EXPERIENCE("ms.azure-artifacts.new-artifacts-preview-feature"),
    /**
     * Artifacts experimental features.
     */
    @JsonProperty("ms.feed.feed-experiments")
    EMPTY_HUB_FOR_PERFORMANCE_MEASURE("ms.feed.feed-experiments"),
    /**
     * Continuous delivery with artifact feeds containing NuGet, npm, Maven, Universal, and Python packages
     */
    @JsonProperty("ms.feed.feed")
    ARTIFACTS_FEED("ms.feed.feed"),
    /**
     * Enables subscription template for PCAs for single org tokens
     */
    @JsonProperty("ms.vss-admin-web.single-org-subscription-template-feature")
    NEW_ORGANIZATION_POLICIES_SUBSCRIPTION_SETTINGS_PAGE("ms.vss-admin-web.single-org-subscription-template-feature"),
    /**
     * Show the new collapsible Organization Settings hub
     */
    @JsonProperty("ms.vss-admin-web.collection-admin-masterdetail")
    NEW_COLLAPSIBLE_ORGANIZATION_SETTINGS_HUB("ms.vss-admin-web.collection-admin-masterdetail"),
    /**
     * Show the new project settings hub with icons
     */
    @JsonProperty("ms.vss-admin-web.project-admin-icons")
    NEW_PROJECT_SETTINGS_HUB_WITH_ICONS("ms.vss-admin-web.project-admin-icons"),
    /**
     * Show the new collapsible Project Settings hub
     */
    @JsonProperty("ms.vss-admin-web.project-admin-masterdetail")
    NEW_COLLAPSIBLE_PROJECT_SETTINGS_HUB("ms.vss-admin-web.project-admin-masterdetail"),
    /**
     * Show the new user settings hub with icons
     */
    @JsonProperty("ms.vss-admin-web.user-admin-icons")
    NEW_USER_SETTINGS_HUB_WITH_ICONS("ms.vss-admin-web.user-admin-icons"),
    /**
     * Show the new collapsible User Settings hub
     */
    @JsonProperty("ms.vss-admin-web.user-admin-masterdetail")
    NEW_COLLAPSIBLE_USER_SETTINGS_HUB("ms.vss-admin-web.user-admin-masterdetail"),
    /**
     * Enables User profile data sync.
     */
    @JsonProperty("ms.vss-admin-web.user-profile-sync-feature")
    PROFILE_SYNC("ms.vss-admin-web.user-profile-sync-feature"),
    /**
     * Lights up new SSH Public Keys tab
     */
    @JsonProperty("ms.vss-admin-web.user-admin-sshpublickeys")
    NEW_SSH_PUBLIC_KEYS_PAGE("ms.vss-admin-web.user-admin-sshpublickeys"),
    /**
     * Lights up new Authorizations tab
     */
    @JsonProperty("ms.vss-admin-web.user-admin-authorizations")
    NEW_AUTHORIZATIONS_PAGE("ms.vss-admin-web.user-admin-authorizations"),
    /**
     * Lights up new Refresh Permissions tab
     */
    @JsonProperty("ms.vss-admin-web.user-admin-refresh-permissions")
    NEW_REFRESH_PERMISSIONS_PAGE("ms.vss-admin-web.user-admin-refresh-permissions"),
    /**
     * Lights up new Profile Organizations tab
     */
    @JsonProperty("ms.vss-admin-web.user-admin-organizations")
    NEW_PROFILE_ORGANIZATIONS_PAGE("ms.vss-admin-web.user-admin-organizations"),
    /**
     * Enables new teams page
     */
    @JsonProperty("ms.vss-admin-web.admin-project-teams-feature-new")
    NEW_TEAMS_PAGE("ms.vss-admin-web.admin-project-teams-feature-new"),
    /**
     * Enables new dashboards permissions page
     */
    @JsonProperty("ms.vss-admin-web.admin-project-settings-team-dashboards-feature")
    NEW_DASHBOARDS_PERMISSIONS_PAGE("ms.vss-admin-web.admin-project-settings-team-dashboards-feature"),
    /**
     * Lights up new organization projects page
     */
    @JsonProperty("ms.vss-admin-web.organization-admin-new-projects-feature")
    NEW_ORGANIZATION_PROJECTS_SETTINGS_PAGE("ms.vss-admin-web.organization-admin-new-projects-feature"),
    /**
     * Lights up version 2 of the permissions tab
     */
    @JsonProperty("ms.vss-admin-web.organization-admin-orggroups-new")
    ORGANIZATION_PERMISSIONS_SETTINGS_PAGE_V2("ms.vss-admin-web.organization-admin-orggroups-new"),
    /**
     * Enable organization administrators in Azure DevOps to restrict users from seeing and collaborating with users in different projects
     */
    @JsonProperty("ms.vss-admin-web.organization-admin-project-scope-users-group")
    LIMIT_USER_VISIBILITY_AND_COLLABORATION_TO_SPECIFIC_PROJECTS("ms.vss-admin-web.organization-admin-project-scope-users-group"),
    /**
     * Enables settings search
     */
    @JsonProperty("ms.vss-admin-web.organization-admin-settings-search-feature")
    NEW_SETTINGS_SEARCH_IN_THE_ORGANIZATION_SETTINGS_PANEL("ms.vss-admin-web.organization-admin-settings-search-feature"),
    /**
     * Lights up new organization policies page
     */
    @JsonProperty("ms.vss-admin-web.organization-admin-new-policies-feature")
    NEW_ORGANIZATION_POLICIES_SETTINGS_PAGE("ms.vss-admin-web.organization-admin-new-policies-feature"),
    /**
     * Lights up new GitHub Connection tab
     */
    @JsonProperty("ms.vss-admin-web.organization-admin-githubconnect")
    NEW_GITHUB_CONNECTION_PAGE("ms.vss-admin-web.organization-admin-githubconnect"),
    /**
     * Enables invite users toggle on new GitHub connection page
     */
    @JsonProperty("ms.vss-admin-web.organization-admin-githubtoggle")
    GITHUB_CONNECTION_USER_INVITE_TOGGLE("ms.vss-admin-web.organization-admin-githubtoggle"),
    /**
     * Turns on Admin Roles View
     */
    @JsonProperty("ms.vss-admin-web.organization-admin-adminroles")
    NEW_ADMIN_ROLES_PAGE("ms.vss-admin-web.organization-admin-adminroles"),
    /**
     * Lights up new project permissions hub
     */
    @JsonProperty("ms.vss-admin-web.admin-project-groups-feature-new")
    PROJECT_PERMISSIONS_SETTINGS_PAGE("ms.vss-admin-web.admin-project-groups-feature-new"),
    /**
     * Turns on Code Mapper Tool in Engineering Hub Group.
     */
    @JsonProperty("ms.vss-aex-code-mapper.code-mapper-feature")
    CODE_MAPPER_TOOL("ms.vss-aex-code-mapper.code-mapper-feature"),
    /**
     * Lights up new user hub interface
     */
    @JsonProperty("ms.vss-aex-user-management.user-hub-modern-feature")
    NEW_USER_HUB("ms.vss-aex-user-management.user-hub-modern-feature"),
    /**
     * Build, manage, and scale your deployments to the cloud
     */
    @JsonProperty("ms.vss-build.pipelines")
    PIPELINES("ms.vss-build.pipelines"),
    /**
     * Reports if classic build pipeline creation is disabled for the project
     */
    @JsonProperty("ms.vss-build-web.disable-classic-build-pipeline-creation")
    NEW_DISABLE_CLASSIC_BUILD_PIPELINE_BUILD_CREATION_TOGGLE("ms.vss-build-web.disable-classic-build-pipeline-creation"),
    /**
     * Reports if classic release pipeline creation is disabled for the project
     */
    @JsonProperty("ms.vss-build-web.disable-classic-release-pipeline-creation")
    NEW_DISABLE_CLASSIC_RELEASE_PIPELINE_RELEASE_CREATION_TOGGLE("ms.vss-build-web.disable-classic-release-pipeline-creation"),
    /**
     * Reports if classic pipeline creation is disabled for the project
     */
    @JsonProperty("ms.vss-build-web.disable-classic-pipeline-creation")
    NEW_DISABLE_CLASSIC_PIPELINE_CREATION_TOGGLE("ms.vss-build-web.disable-classic-pipeline-creation"),
    /**
     * Enables pipeline specific diagnostics bar.
     */
    @JsonProperty("ms.vss-build-web.build-diag-dev-display")
    ENABLE_PIPELINES_DIAGNOSIS_DEV("ms.vss-build-web.build-diag-dev-display"),
    /**
     * New YAML editor with support for editing templates.
     */
    @JsonProperty("ms.vss-build-web.build-template-editor-feature")
    YAML_TEMPLATES_EDITOR("ms.vss-build-web.build-template-editor-feature"),
    /**
     * Repos, pull requests, advanced file management and more
     */
    @JsonProperty("ms.vss-code.version-control")
    REPOS("ms.vss-code.version-control"),
    /**
     * Enables the new code coverage experience.
     */
    @JsonProperty("ms.vss-codecoverage-ci-web.codecoverage-selection-feature")
    NEW_CODE_COVERAGE_EXPERIENCE("ms.vss-codecoverage-ci-web.codecoverage-selection-feature"),
    /**
     * Enable version control git graph
     */
    @JsonProperty("ms.vss-code-web.version-control-git-graph")
    VERSION_CONTROL_GIT_GRAPH("ms.vss-code-web.version-control-git-graph"),
    /**
     * Legacy pull requests experience.
     */
    @JsonProperty("ms.vss-code-web.repos-old-pull-requests-feature")
    REPOS_LEGACY_PULL_REQUEST_EXPERIENCE("ms.vss-code-web.repos-old-pull-requests-feature"),
    /**
     * Enables a file content load experience for large files in the Pull request summary.
     */
    @JsonProperty("ms.vss-code-web.large-file-loading-in-pullrequest-summary")
    PULL_REQUEST_SUMMARY_LOAD_OF_LARGE_FILES("ms.vss-code-web.large-file-loading-in-pullrequest-summary"),
    /**
     * Display the new dashboard panel when you create and manage dashboards.
     */
    @JsonProperty("ms.vss-dashboards.new-dashboard-management-experience-feature")
    NEW_DASHBOARD_CREATION_AND_MANAGEMENT_EXPERIENCE("ms.vss-dashboards.new-dashboard-management-experience-feature"),
    /**
     * Allow the option to create project-scoped dashboards.
     */
    @JsonProperty("ms.vss-dashboards.team-agnostic-dashboards-feature")
    TEAM_AGNOSTIC_DASHBOARDS("ms.vss-dashboards.team-agnostic-dashboards-feature"),
    /**
     * Enables a fuzzy search experience in the Widget Catalog that allows misspellings when searching for widget name, title, and publisher name.
     */
    @JsonProperty("ms.vss-dashboards.dashboard-widget-catalog-fuzzy-search-feature")
    WIDGET_CATALOG_FUZZY_SEARCH_FEATURE("ms.vss-dashboards.dashboard-widget-catalog-fuzzy-search-feature"),
    /**
     * Allows for vertical categories in the widget catalog, along with visible tags associated with each widget.
     */
    @JsonProperty("ms.vss-dashboards.dashboard-widget-catalog-categorization-feature")
    WIDGET_CATALOG_CATEGORIZATION("ms.vss-dashboards.dashboard-widget-catalog-categorization-feature"),
    /**
     * Allows users to access help information about any widget they are using.
     */
    @JsonProperty("ms.vss-dashboards.dashboard-widget-help-feature")
    WIDGET_HELP_MENU("ms.vss-dashboards.dashboard-widget-help-feature"),
    /**
     * Improved dashboard management and favoriting experience, plus dashboard directories.
     */
    @JsonProperty("ms.vss-dashboards-web.dashboards-new-experience-feature")
    NEW_DASHBOARDS_EXPERIENCE("ms.vss-dashboards-web.dashboards-new-experience-feature"),
    /**
     * Display template page on viewing a new/empty dashboard with options for blank and other presets.
     */
    @JsonProperty("ms.vss-dashboards-web.dashboard-template-page-feature")
    DASHBOARD_TEMPLATE_PAGE("ms.vss-dashboards-web.dashboard-template-page-feature"),
    /**
     * Exposes copy dashboard experience on a dashboard.
     */
    @JsonProperty("ms.vss-dashboards-web.copy-dashboard-feature")
    COPY_DASHBOARD_EXPERIENCE("ms.vss-dashboards-web.copy-dashboard-feature"),
    /**
     * Disable prefixing user display name for project level dashboards.
     */
    @JsonProperty("ms.vss-dashboards-web.project-level-dashboard-disable-user-prefix-feature")
    DISABLE_USER_NAME_PREFIX_FOR_PROJECT_LEVEL_DASHBOARDS("ms.vss-dashboards-web.project-level-dashboard-disable-user-prefix-feature"),
    /**
     * Enables adding new sprint burndown experience as a widget from catalog and sprint report page.
     */
    @JsonProperty("ms.vss-dashboards-web.sprint-burndown-availability")
    NEW_SPRINT_BURN_DOWN_WIDGET("ms.vss-dashboards-web.sprint-burndown-availability"),
    /**
     * Enables advanced configuration on Lead and Cycle Time widgets
     */
    @JsonProperty("ms.vss-dashboards-web.advanced-kanban-time-widget-config-feature")
    ADVANCED_CONFIGURATION_FOR_LEAD_AND_CYCLE_TIME_WIDGETS("ms.vss-dashboards-web.advanced-kanban-time-widget-config-feature"),
    /**
     * Lights up new logs reader for Pipelines.
     */
    @JsonProperty("ms.vss-distributedtask-web.log-reader")
    NEW_LOG_READER_FOR_PIPELINES("ms.vss-distributedtask-web.log-reader"),
    /**
     * Allows you to create ARM service connections with the Workload Identity federation authentication scheme. It eliminates the need to manage and rotate secrets.
     */
    @JsonProperty("ms.vss-distributedtask-web.workload-identity-federation")
    WORKLOAD_IDENTITY_FEDERATION_FOR_ARM_SERVICE_CONNECTIONS("ms.vss-distributedtask-web.workload-identity-federation"),
    /**
     * Turns on the new service connections experience.
     */
    @JsonProperty("ms.vss-distributedtask-web.new-serviceconnections-ui")
    NEW_SERVICE_CONNECTIONS_EXPERIENCE("ms.vss-distributedtask-web.new-serviceconnections-ui"),
    /**
     * Allow account members to be automatically notified about activity in the account relevant to them, like when they are assigned a work item or added to a pull request.
     */
    @JsonProperty("ms.vss-notifications.default-subscriptions-feature")
    OUT_OF_THE_BOX_NOTIFICATIONS("ms.vss-notifications.default-subscriptions-feature"),
    /**
     * Events can be associated with specific users or groups, including teams. With this feature enabled, default subscriptions and other role-based subscriptions that match an event associated with a team will result in each team member receiving a notification.
     */
    @JsonProperty("ms.vss-notifications.expand-teams-in-roles-feature")
    TEAM_EXPANSION_FOR_NOTIFICATIONS("ms.vss-notifications.expand-teams-in-roles-feature"),
    /**
     * Render email notifications with new templates
     */
    @JsonProperty("ms.vss-notifications.use-email-templates-v2-feature")
    NEW_EMAIL_TEMPLATES("ms.vss-notifications.use-email-templates-v2-feature"),
    /**
     * Package Search provides fast and flexible search across all packages.
     */
    @JsonProperty("ms.vss-package-search.enable-package-search")
    NEW_PACKAGE_SEARCH("ms.vss-package-search.enable-package-search"),
    /**
     * Lights up pipline lead time analytics features.
     */
    @JsonProperty("ms.vss-pipelineanalytics-web.pipeline-leadtime-analytics-feature")
    PIPELINE_LEAD_TIME("ms.vss-pipelineanalytics-web.pipeline-leadtime-analytics-feature"),
    /**
     * Enables insights toast for the failed tasks in Pipeline Run.
     */
    @JsonProperty("ms.vss-pipelineanalytics-web.task-insights-feature-availibilty")
    TASK_INSIGHTS_FOR_FAILED_PIPELINE_RUNS("ms.vss-pipelineanalytics-web.task-insights-feature-availibilty"),
    /**
     * Turn on the new release views to visualize the progress of your deployment pipelines.
     */
    @JsonProperty("ms.vss-releaseManagement-web.new-release-view-feature")
    NEW_RELEASE_PROGRESS_VIEWS("ms.vss-releaseManagement-web.new-release-view-feature"),
    /**
     * Turns on selective artifacts download feature in release pipelines. This feature isn't supported if you have agents behind proxy in your release pipelines.
     */
    @JsonProperty("ms.vss-releaseManagement-web.selective-artifacts-download-feature")
    SELECTIVE_ARTIFACTS_DOWNLOAD_FEATURE_FOR_COLLECTION_PROJECT("ms.vss-releaseManagement-web.selective-artifacts-download-feature"),
    /**
     * Turn on interactive reports in boards pages, replacing CFD, Velocity and Burndown charts in boards headers.
     */
    @JsonProperty("ms.vss-reporting-web.reporting-boards-reports-feature")
    NEW_BOARDS_REPORTS("ms.vss-reporting-web.reporting-boards-reports-feature"),
    /**
     * Enables preloading of Boards Reports scripts and data when boards, backlog or sprints pages are loaded so that tab switch to analytics loads reports faster
     */
    @JsonProperty("ms.vss-reporting-web.reporting-boards-reports-preload")
    BOARDS_REPORT_PRELOADING_REPORTS("ms.vss-reporting-web.reporting-boards-reports-preload"),
    /**
     * Enables display of AX backed header chart in place of the legacy charts
     */
    @JsonProperty("ms.vss-reporting-web.reporting-boards-ax-header-chart")
    BOARDS_REPORT_AX_HEADER_CHART("ms.vss-reporting-web.reporting-boards-ax-header-chart"),
    /**
     * Lights up a new service hooks page in project settings
     */
    @JsonProperty("ms.vss-servicehooks-web.projectsettings-servicehooks-tab-new-feature")
    SERVICE_HOOKS_SETTING_PAGE_IMPROVEMENTS("ms.vss-servicehooks-web.projectsettings-servicehooks-tab-new-feature"),
    /**
     * Structured manual testing at any scale for teams of all sizes
     */
    @JsonProperty("ms.vss-test-web.test")
    TEST_PLANS("ms.vss-test-web.test"),
    /**
     * Lights up the new Test Plans page which offers streamlined views, new UX and additional capabilities.
     */
    @JsonProperty("ms.vss-test-web.testplans-hub-refresh-feature")
    NEW_TEST_PLANS_PAGE("ms.vss-test-web.testplans-hub-refresh-feature"),
    /**
     * Enable the NWP Test Steps Control
     */
    @JsonProperty("ms.vss-test-web.nwp-test-steps-control-feature")
    NWP_TEST_STEPS_CONTROL("ms.vss-test-web.nwp-test-steps-control-feature"),
    /**
     * Lights up the new Test Plans Library hub.
     */
    @JsonProperty("ms.vss-test-web.testplans-library-feature")
    TEST_PLANS_LIBRARY("ms.vss-test-web.testplans-library-feature"),
    /**
     * Get similar test results using failure bucketing.
     */
    @JsonProperty("ms.vss-test-web.similar-test-results-feature")
    SIMILAR_TEST_RESULTS("ms.vss-test-web.similar-test-results-feature"),
    /**
     * Enables mobile-friendly views for the pages which support mobile.
     */
    @JsonProperty("ms.vss-tfs-web.new-mobile-feature")
    MOBILE_SUPPORT("ms.vss-tfs-web.new-mobile-feature"),
    /**
     * Enable instant search of work items in Azure Boards and wiki pages in Azure Devops Wiki.
     */
    @JsonProperty("ms.vss-tfs-web.enable-search-suggestions")
    INSTANT_SEARCH("ms.vss-tfs-web.enable-search-suggestions"),
    /**
     * Adds test component to project hub group and settings page for Collection, user and project
     */
    @JsonProperty("ms.vss-tfs-web.feature-empty-test-hubs")
    PAGE_CONTENT_TEST_COMPONENT("ms.vss-tfs-web.feature-empty-test-hubs"),
    /**
     * Lights up the Engineering Hubs under Engineering Hub Group (Engineering Scorecard, DRI Tool, Theme Generator).
     */
    @JsonProperty("ms.vss-tfs-web.engineering-feature")
    ENGINEERING_HUBS("ms.vss-tfs-web.engineering-feature"),
    /**
     * Lights up VSSUI components related Internal Engineering Samples under Engineering Hub Group.
     */
    @JsonProperty("ms.vss-tfs-web.internal-engineering-feature")
    ENGINEERING_SAMPLES_INTERNAL("ms.vss-tfs-web.internal-engineering-feature"),
    /**
     * TFS vertical navigation feature
     */
    @JsonProperty("ms.vss-tfs-web.vertical-navigation")
    NEW_NAVIGATION("ms.vss-tfs-web.vertical-navigation"),
    /**
     * Lights up sample hubs that use the New Web Platform
     */
    @JsonProperty("ms.vss-tfs-web.preview-feature")
    WEB_PLATFORM_SAMPLE_HUBS("ms.vss-tfs-web.preview-feature"),
    /**
     * Adds an early preview of various themes to the Theme management panel.
     */
    @JsonProperty("ms.vss-web.additional-preview-themes-feature")
    EXPERIMENTAL_THEMES("ms.vss-web.additional-preview-themes-feature"),
    /**
     * Enables editing of wiki templates in wiki hub.
     */
    @JsonProperty("ms.vss-wiki-web.wiki-templates-editing")
    WIKI_TEMPLATES("ms.vss-wiki-web.wiki-templates-editing"),
    /**
     * Enable new Wiki feature in your account.
     */
    @JsonProperty("ms.vss-wiki-web.wiki-feature")
    WIKI("ms.vss-wiki-web.wiki-feature"),
    /**
     * Enable new Wiki feature in your project.
     */
    @JsonProperty("ms.vss-wiki-web.wiki-first-party-rollout-feature")
    WIKI_PROJECT("ms.vss-wiki-web.wiki-first-party-rollout-feature"),
    /**
     * Enables new wiki experience in the wiki hub.
     */
    @JsonProperty("ms.vss-wiki-web.wiki-new-overview-feature")
    NEW_WIKI_EXPERIENCE("ms.vss-wiki-web.wiki-new-overview-feature"),
    /**
     * Flexible agile planning with boards and cross-product issues
     */
    @JsonProperty("ms.vss-work.agile")
    BOARDS("ms.vss-work.agile"),
    /**
     * Work Item Search provides fast and flexible search across all work item fields.
     */
    @JsonProperty("ms.vss-workitem-search.enable-workitem-search")
    NEW_WORK_ITEM_SEARCH("ms.vss-workitem-search.enable-workitem-search"),
    /**
     * Enables new web platform Boards hubs.
     */
    @JsonProperty("ms.vss-work-web.new-boards-hub-feature")
    NEW_BOARDS_HUBS("ms.vss-work-web.new-boards-hub-feature"),
    /**
     * Columnstore Index Experiment
     */
    @JsonProperty("ms.vss-work-web.columnstore-index-experiment")
    COLUMN_STORE_INDEX_EXPERIMENT("ms.vss-work-web.columnstore-index-experiment"),
    /**
     * Identity ConstId Optimization Experiment
     */
    @JsonProperty("ms.vss-work-web.identity-constid-experiment")
    IDENTITY_CONST_ID_OPTIMIZATION_EXPERIMENT("ms.vss-work-web.identity-constid-experiment"),
    /**
     * AB testing experiment for measuring performance impact of using data providers instead of MVC for loading metadata for the work item form.
     */
    @JsonProperty("ms.vss-work-web.work-item-form-data-providers-experiment")
    WIT_FORM_DATA_PROVIDERS_EXPERIMENT("ms.vss-work-web.work-item-form-data-providers-experiment");

    private final String featureId;

    FeatureManagement(String id) {
        featureId = id;
    }

    public String getFeatureId() {
        return featureId;
    }
}
