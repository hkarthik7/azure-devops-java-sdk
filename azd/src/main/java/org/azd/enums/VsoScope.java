package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum VsoScope {
    /**
     * Grants the ability to view tasks, pools, queues, agents, and currently running or recently completed jobs for agents.
     */
    @JsonProperty("vso.agentpools")
    AGENT_POOLS,
    /**
     * Grants the ability to manage pools, queues, and agents.
     */
    @JsonProperty("vso.agentpools_manage")
    AGENT_POOLS_MANAGE,
    /**
     * Grants the ability to manage pools, queues, agents, and environments.
     */
    @JsonProperty("vso.environment_manage")
    ENVIRONMENT_MANAGE,
    /**
     * Grants the ability to query analytics data.
     */
    @JsonProperty("vso.analytics")
    ANALYTICS,
    /**
     * Grants the ability to read the auditing log to users.
     */
    @JsonProperty("vso.auditlog")
    AUDIT_LOG,
    /**
     * Grants the ability to manage auditing streams to users.
     */
    @JsonProperty("vso.auditstreams_manage")
    AUDIT_STREAMS_MANAGE,
    /**
     * Grants the ability to access build artifacts, including build results, definitions, and requests,
     * and the ability to receive notifications about build events via service hooks.
     */
    @JsonProperty("vso.build")
    BUILD,
    /**
     * Grants the ability to access build artifacts, including build results, definitions, and requests, and the
     * ability to queue a build, update build properties, and the ability to receive notifications about build
     * events via service hooks.
     */
    @JsonProperty("vso.build_execute")
    BUILD_EXECUTE,
    /**
     * Grants the ability to read source code and metadata about commits, changesets, branches, and other version
     * control artifacts. Also grants the ability to search code and get notified about version control events via service hooks.
     */
    @JsonProperty("vso.code")
    CODE,
    /**
     * Grants the ability to read, update, and delete source code, access metadata about commits, changesets, branches,
     * and other version control artifacts. Also grants the ability to create and manage pull requests and code reviews
     * and to receive notifications about version control events via service hooks.
     */
    @JsonProperty("vso.code_write")
    CODE_WRITE,
    /**
     * Grants the ability to read, update, and delete source code, access metadata about commits, changesets,
     * branches, and other version control artifacts. Also grants the ability to create and manage code repositories,
     * create and manage pull requests and code reviews, and to receive notifications about version control events via service hooks.
     */
    @JsonProperty("vso.code_manage")
    CODE_MANAGE,
    /**
     * Grants full access to source code, metadata about commits, changesets,
     * branches, and other version control artifacts. Also grants the ability to create and manage code repositories,
     * create and manage pull requests and code reviews, and to receive notifications about version control events via
     * service hooks. Also includes limited support for Client OM APIs.
     */
    @JsonProperty("vso.code_full")
    CODE_FULL,
    /**
     * Grants the ability to read and write commit and pull request status.
     */
    @JsonProperty("vso.code_status")
    CODE_STATUS,
    /**
     * Grants the ability to access endpoints needed from an on-prem connected server.
     */
    @JsonProperty("vso.connected_server")
    CONNECTED_SERVER,
    /**
     * Provides read only access to licensing entitlements endpoint to get account entitlements.
     */
    @JsonProperty("vso.entitlements")
    ENTITLEMENTS,
    /**
     * Grants the ability to read users, their licenses as well as projects and extensions they can access.
     */
    @JsonProperty("vso.memberentitlementmanagement")
    MEMBER_ENTITLEMENT_MANAGEMENT,
    /**
     * Grants the ability to manage users, their licenses as well as projects and extensions they can access.
     */
    @JsonProperty("vso.memberentitlementmanagement_write")
    MEMBER_ENTITLEMENT_MANAGEMENT_WRITE,
    /**
     * Grants the ability to read installed extensions.
     */
    @JsonProperty("vso.extension")
    EXTENSION,
    /**
     * Grants the ability to install, uninstall, and perform other administrative actions on installed extensions.
     */
    @JsonProperty("vso.extension_manage")
    EXTENSION_MANAGE,
    /**
     * Grants the ability to read data (settings and documents) stored by installed extensions.
     */
    @JsonProperty("vso.extension.data")
    EXTENSION_DATA,
    /**
     * Grants the ability to read and write data (settings and documents) stored by installed extensions.
     */
    @JsonProperty("vso.extension.data_write")
    EXTENSION_DATA_WRITE,
    /**
     * Grants the ability to read user, group, scope, and group membership information.
     */
    @JsonProperty("vso.graph")
    GRAPH,
    /**
     * Grants the ability to read user, group, scope and group membership information, and to add users, groups, and manage group memberships.
     */
    @JsonProperty("vso.graph_manage")
    GRAPH_MANAGE,
    /**
     * Grants the ability to read identities and groups.
     */
    @JsonProperty("vso.identity")
    IDENTITY,
    /**
     * Grants the ability to read, write, and manage identities and groups.
     */
    @JsonProperty("vso.identity_manage")
    IDENTITY_MANAGE,
    /**
     * Grants the ability to read your load test runs, test results, and APM artifacts.
     */
    @JsonProperty("vso.loadtest")
    LOAD_TEST,
    /**
     * Grants the ability to create and update load test runs, and read metadata including test results and APM artifacts.
     */
    @JsonProperty("vso.loadtest_write")
    LOAD_TEST_WRITE,
    /**
     * Provides ability to manage deployment group and agent pools.
     */
    @JsonProperty("vso.machinegroup_manage")
    MACHINE_GROUP_MANAGE,
    /**
     * Grants read access to public and private items and publishers.
     */
    @JsonProperty("vso.gallery")
    GALLERY,
    /**
     * Grants read access and the ability to acquire items.
     */
    @JsonProperty("vso.gallery_acquire")
    GALLERY_ACQUIRE,
    /**
     * Grants read access and the ability to upload, update, and share items.
     */
    @JsonProperty("vso.gallery_publish")
    GALLERY_PUBLISH,
    /**
     * Grants read access and the ability to publish and manage items and publishers.
     */
    @JsonProperty("vso.gallery_manage")
    GALLERY_MANAGE,
    /**
     * Provides read access to subscriptions and event metadata, including filterable field values.
     */
    @JsonProperty("vso.notification")
    NOTIFICATION,
    /**
     * Provides read and write access to subscriptions and read access to event metadata, including filterable field values.
     */
    @JsonProperty("vso.notification_write")
    NOTIFICATION_WRITE,
    /**
     * Provides read, write, and management access to subscriptions and read access to event metadata, including filterable field values.
     */
    @JsonProperty("vso.notification_manage")
    NOTIFICATION_MANAGE,
    /**
     * Provides access to notification-related diagnostic logs and provides the ability to enable diagnostics for individual subscriptions.
     */
    @JsonProperty("vso.notification_diagnostics")
    NOTIFICATION_DIAGNOSTICS,
    /**
     * Grants the ability to read feeds and packages.
     */
    @JsonProperty("vso.packaging")
    PACKAGING,
    /**
     * Grants the ability to create and read feeds and packages.
     */
    @JsonProperty("vso.packaging_write")
    PACKAGING_WRITE,
    /**
     * Grants the ability to create, read, update, and delete feeds and packages.
     */
    @JsonProperty("vso.packaging_manage")
    PACKAGING_MANAGE,
    /**
     * Grants the ability to approve a pipeline's request to use a protected resource: agent pool, environment, queue, repository, secure files, service connection, and variable group.
     */
    @JsonProperty("vso.pipelineresources_use")
    PIPELINE_RESOURCES_USE,
    /**
     * Grants the ability to manage a protected resource or a pipeline's request to use a protected resource: agent pool, environment, queue, repository, secure files, service connection, and variable group.
     */
    @JsonProperty("vso.pipelineresources_manage")
    PIPELINE_RESOURCES_MANAGE,
    /**
     * Grants the ability to read projects and teams.
     */
    @JsonProperty("vso.project")
    PROJECT,
    /**
     * Grants the ability to read and update projects and teams.
     */
    @JsonProperty("vso.project_write")
    PROJECT_WRITE,
    /**
     * Grants the ability to create, read, update, and delete projects and teams.
     */
    @JsonProperty("vso.project_manage")
    PROJECT_MANAGE,
    /**
     * Grants the ability to read release artifacts, including releases, release definitions and release environment.
     */
    @JsonProperty("vso.release")
    RELEASE,
    /**
     * Grants the ability to read and update release artifacts, including releases, release definitions and release environment, and the ability to queue a new release.
     */
    @JsonProperty("vso.release_execute")
    RELEASE_EXECUTE,
    /**
     * Grants the ability to read, update, and delete release artifacts, including releases, release definitions and release environment, and the ability to queue and approve a new release.
     */
    @JsonProperty("vso.release_manage")
    RELEASE_MANAGE,
    /**
     * Grants the ability to read secure files.
     */
    @JsonProperty("vso.securefiles_read")
    SECURE_FILES_READ,
    /**
     * Grants the ability to read and create secure files.
     */
    @JsonProperty("vso.securefiles_write")
    SECURE_FILES_WRITE,
    /**
     * Grants the ability to read, create, and manage secure files.
     */
    @JsonProperty("vso.securefiles_manage")
    SECURE_FILES_MANAGE,
    /**
     * Grants the ability to read, write, and manage security permissions.
     */
    @JsonProperty("vso.security_manage")
    SECURITY_MANAGE,
    /**
     * Grants the ability to read service endpoints.
     */
    @JsonProperty("vso.serviceendpoint")
    SERVICE_ENDPOINT,
    /**
     * Grants the ability to read and query service endpoints.
     */
    @JsonProperty("vso.serviceendpoint_query")
    SERVICE_ENDPOINT_QUERY,
    /**
     * Grants the ability to read, query, and manage service endpoints.
     */
    @JsonProperty("vso.serviceendpoint_manage")
    SERVICE_ENDPOINT_MANAGE,
    /**
     * Grants the ability to read settings.
     */
    @JsonProperty("vso.settings")
    SETTINGS,
    /**
     * Grants the ability to create and read settings.
     */
    @JsonProperty("vso.settings_write")
    SETTINGS_WRITE,
    /**
     * Grants the ability to read symbols.
     */
    @JsonProperty("vso.symbols")
    SYMBOLS,
    /**
     * Grants the ability to read and write symbols.
     */
    @JsonProperty("vso.symbols_write")
    SYMBOLS_WRITE,
    /**
     * Grants the ability to read, write, and manage symbols.
     */
    @JsonProperty("vso.symbols_manage")
    SYMBOLS_MANAGE,
    /**
     * Grants the ability to read task groups.
     */
    @JsonProperty("vso.taskgroups_read")
    TASK_GROUPS_READ,
    /**
     * Grants the ability to read and create task groups.
     */
    @JsonProperty("vso.taskgroups_write")
    TASKGROUPS_WRITE,
    /**
     * Grants the ability to read, create and manage taskgroups.
     */
    @JsonProperty("vso.taskgroups_manage")
    TASKGROUPS_MANAGE,
    /**
     * Grants the ability to read team dashboard information.
     */
    @JsonProperty("vso.dashboards")
    DASHBOARDS,
    /**
     * Grants the ability to manage team dashboard information.
     */
    @JsonProperty("vso.dashboards_manage")
    DASHBOARDS_MANAGE,
    /**
     * Grants the ability to read test plans, cases, results and other test management related artifacts.
     */
    @JsonProperty("vso.test")
    TEST,
    /**
     * Grants the ability to read, create, and update test plans, cases, results and other test management related artifacts.
     */
    @JsonProperty("vso.test_write")
    TEST_WRITE,
    /**
     * Grants the ability to read and write to pull request comment threads.
     */
    @JsonProperty("vso.threads_full")
    THREADS_FULL,
    /**
     * Grants the ability to manage delegated authorization tokens to users.
     */
    @JsonProperty("vso.tokens")
    TOKENS,
    /**
     * Grants the ability to manage (view and revoke) existing tokens to organization administrators.
     */
    @JsonProperty("vso.tokenadministration")
    TOKEN_ADMINISTRATION,
    /**
     * Grants the ability to read your profile, accounts, collections, projects, teams, and other top-level organizational artifacts.
     */
    @JsonProperty("vso.profile")
    PROFILE,
    /**
     * Grants the ability to write to your profile.
     */
    @JsonProperty("vso.profile_write")
    PROFILE_WRITE,
    /**
     * Grants the ability to read variable groups.
     */
    @JsonProperty("vso.variablegroups_read")
    VARIABLE_GROUPS_READ,
    /**
     * Grants the ability to read and create variable groups.
     */
    @JsonProperty("vso.variablegroups_write")
    VARIABLE_GROUPS_WRITE,
    /**
     * Grants the ability to read, create and manage variable groups.
     */
    @JsonProperty("vso.variablegroups_manage")
    VARIABLE_GROUPS_MANAGE,
    /**
     * Grants the ability to read wikis, wiki pages and wiki attachments. Also grants the ability to search wiki pages.
     */
    @JsonProperty("vso.wiki")
    WIKI,
    /**
     * Grants the ability to read, create and updates wikis, wiki pages and wiki attachments.
     */
    @JsonProperty("vso.wiki_write")
    WIKI_WRITE,
    /**
     * Grants the ability to read work items, queries, boards, area and iterations paths, and other work item
     * tracking related metadata. Also grants the ability to execute queries, search work items and to receive
     * notifications about work item events via service hooks.
     */
    @JsonProperty("vso.work")
    WORK,
    /**
     * Grants the ability to read, create, and update work items and queries, update board metadata, read area and
     * iterations paths other work item tracking related metadata, execute queries, and to receive
     * notifications about work item events via service hooks.
     */
    @JsonProperty("vso.work_write")
    WORK_WRITE,
    /**
     * Grants full access to work items, queries, backlogs, plans, and work item tracking metadata,
     * including process template imports. Also provides the ability to receive notifications about
     * work item events via service hooks.
     */
    @JsonProperty("vso.work_full")
    WORK_FULL
}
