package org.azd.security;


import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 * refer to <A href="https://docs.microsoft.com/en-us/azure/devops/organizations/security/namespace-reference?view=azure-devops">Security Token Reference Documentation</A>
 *
 * In order to reference and assign access control entries, scope must be specified via a token, which varies depending on the security namespace and resource.
 * For instance, git repositories security scope range from:
 * <ul>
 *     <LI>repoV2/[project_id]/[repo_id] - applies to a specific repository in a specific project</LI>
 *     <LI>repoV2/[project_id] - applies to all repositories in a specific project</LI>
 *     <LI>repoV2 - applies to all repositories</LI>
 * </ul>
 *
 * Not guaranteed to generate an acceptable token across all resources, as it does not appear to be implemented in an entirely consistent fashion
 *
 * TODO: incomplete list. Scope items added as needed
 */
public class SecurityToken {
    /***
     * matching regex pattern for token replacement in generate function
     */
    private final static Pattern tokenPattern = Pattern.compile("\\{([^{}]*?)\\}");

    /***
     * Based on the scope parameter, map replacement tokens in the token format string to values in the provided hashmap
     * @param scope pre-defined scope entry in enum set below
     * @param keys hashmap containing replacement values for token string.
     * @return String token reference path
     */
    public static String generate(SecurityToken.Scope scope, Map<String, String> keys) {
        String output = scope.format;
        if (scope.format.equals("")) {
            return scope.format;
        }
        Matcher matcher = tokenPattern.matcher(scope.format);
        while (matcher.find()) {
            output = matcher.replaceFirst(keys.getOrDefault(matcher.group(1), ""));
            matcher.reset(output);
        }
        return output.replaceAll("/*$", ""); // strip forward slash at end of string
    }

    /***
     * Extract set of keys required to populate token string fully
     * @param scope security scope entry in enum set
     * @return collection of unique strings (property key names)
     */
    public static Set<String> keys(SecurityToken.Scope scope) {
        Set<String> output = new HashSet<>();
        if (scope == null || scope.format.equals("")) {
            return output;
        }
        Matcher matcher = tokenPattern.matcher(scope.format);
        while (matcher.find()) {
            String match = matcher.group(1);
            if (match != null && !match.isBlank()) output.add(matcher.group(1));
        }
        return output;
    }

    public enum Scope {
        // https://docs.microsoft.com/en-us/azure/devops/organizations/security/namespace-reference?view=azure-devops
        // TODO: incomplete list

        // Object-level namespaces and permissions
        AnalyticsViews("d34d3680-dfe5-4cc6-a949-7d9c68f73cba", "$/Shared/{PROJECT_ID}"),
        Build("33344d9c-fc72-4d6f-aba5-fa317101a7e9", "{PROJECT_ID}/{BUILD_DEFINITION_ID}"),
        CSS("83e28ad4-2d72-4ceb-97b0-c7726d5502c3", "{CSS_ID}"),
        DashboardsPrivileges("8adf73b7-389a-4276-b638-fe1653f7efc7", "{PROJECT_ID}"),
        GIT("2e9eb7ed-3c0a-47d4-87c1-0ffdd275fd87", "repoV2/{PROJECT_ID}/{REPO_ID}"),
        Iteration("bf7bfa03-b2b7-47db-8113-fa2e002cc5b1", "vstfs:///Classification/Node/{PROJECT}:vstfs:///Classification/Node/{TEAM}:vstfs:///Classification/Node/{CHILD}"),
        MetaTask("f6a4de49-dbe2-4704-86dc-f8ec1a294436", "{PROJECT_ID}/{PARENT_TASK_ID}/{METATASK_ID}"),
        Plan("bed337f8-e5f3-4fb9-80da-81e17d06e7a8"),
        ReleaseManagement("c788c23e-1b46-4162-8f5e-d7585343b5de", "{PROJECT_ID}/{folderName}/{RELEASE_DEFINITION_ID}"),
        WorkItemQueryFolders("71356614-aad7-4757-8f2c-0fb3bff6f680"),

        // Project-level namespaces and permissions
        Project("52d39943-cb85-4d7f-8fa8-c6baac873819", "$PROJECT:vstfs:///Classification/TeamProject/{PROJECT_ID}"),
        Tagging("bb50f182-8e5e-40b8-bc21-e8752a1e7ae2", "/{PROJECT_ID}"),
        VersionControlItems("a39371cf-0841-4c16-bbd3-276e341bc052"),

        // Organization-level namespaces and permissions
        AuditLog("a6cc6381-a1ca-4b36-b3c1-4e65211e82b6", "/AllPermissions"),
        BuildAdministration("302acaca-b667-436d-a946-87133492041c"),
        Collection("3e65f728-f8bc-4ecd-8764-7e378b19bfa7"),
        Process("2dab47f9-bd70-49ed-9bd5-8eb051e59c02"),
        Workspaces("93bafc04-9075-403a-9367-b7164eac6b5c", "/{WORKSPACE_NAME};{OWNER_ID}"),
        VersionControlPrivileges("66312704-deb5-43f9-b51c-ab4ff5e351c3"),

        // Role-based namespaces and permissions
        DistributedTask("101eae8c-1709-47f9-b228-0e476c35b3ba"),
        Environment("83d4c2e6-e57d-4d6e-892b-b87222b7ad20"),
        ExtensionManagement("5d6d7b80-3c63-4ab0-b699-b6a5910f8029"),
        Library("b7e84409-6553-448a-bbb2-af228e07cbeb"),
        ServiceEndpoints("49b48001-ca20-4adc-8111-5b60c903a50c"),

        // Internal namespaces and permissions
        AccountAdminSecurity("11238e09-49f2-40c7-94d0-8f0307204ce4"),
        Analytics("58450c49-b02d-465a-ab12-59ae512d6531", "$/{PROJECT_ID}"),
        BlobStoreBlobPrivileges("19F9F97D-7CB7-45F7-8160-DD308A6BD48E"),
        Boards("251e12d9-bea3-43a8-bfdb-901b98c0125e"),
        BoardsExternalIntegration("5ab15bc8-4ea1-d0f3-8344-cab8fe976877"),
        Chat("bc295513-b1a2-4663-8d1a-7017fd760d18"),
        DiscussionThreads("0d140cae-8ac1-4f48-b6d1-c93ce0301a12"),
        EventPublish("7cd317f2-adc6-4b6c-8d99-6074faeaf173"),
        EventSubscriber("2bf24a2b-70ba-43d3-ad97-3d9e1f75622f"),
        EventSubscription("58b176e7-3411-457a-89d0-c6d0ccb3c52b"),
        Identity("5a27515b-ccd7-42c9-84f1-54c998f03866", "{PROJECT_ID}\\{GROUP_ID}"),
        Licensing("453e2db3-2e81-474f-874d-3bf51027f2ee"),
        PermissionLevel("25fb0ed7-eb8f-42b8-9a5e-836a25f67e37"),
        OrganizationLevelData("F0003BCE-5F45-4F93-A25D-90FC33FE3AA9"),
        PipelineCachePrivileges("62a7ad6b-8b8d-426b-ba10-76a7090e94d5"),
        ReleaseManagementUI("7c7d32f7-0e86-4cd6-892e-b35dbba870bd"), // duplicate "ReleaseManagement" with different UUID
        SearchSecurity("ca535e7e-67ce-457f-93fe-6e53aa4e4160"),
        ServiceHooks("cb594ebe-87dd-4fc9-ac2c-6a10a4c92046"),
        UtilizationPermissions("83abde3a-4593-424e-b45f-9898af99034d", "/"),
        WorkItemTrackingAdministration("445d2788-c5fb-4132-bbef-09c4045ad93f"),
        WorkItemTrackingProvision("5a6cd233-6615-414d-9393-48dbb252bd23", "$/{PROJECT_ID}") // root token has the format "/$"
        ;

        private String namespace;
        private String format;

        /***
         * For informational purposes, the following namespaces are deprecated and read-only:
         *
         * CrossProjectWidgetView
         * DataProvider
         * Favorites
         * Graph
         * Identity2
         * IdentityPicker
         * Job
         * Location
         * ProjectAnalysisLanguageMetrics
         * Proxy
         * Publish
         * Registry
         * Security
         *
         * ServicingOrchestration
         * SettingEntries
         * Social
         * StrongBox
         * TeamLabSecurity
         * TestManagement
         * VersionControlItems2
         * ViewActivityPaneSecurity
         * WebPlatform
         * WorkItemsHub
         * WorkItemTracking
         * WorkItemTrackingConfiguration
         *
         */


        Scope(String namespace) {
            this.namespace = namespace;
            this.format = "";
        }

        Scope(String namespace, String format) {
            this.namespace = namespace;
            this.format = format;
        }

        public String getNamespace() {
            return namespace;
        }

        public String getFormat() {
            return format;
        }
    }
}
