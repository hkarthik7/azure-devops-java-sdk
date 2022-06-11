package org.azd.security;


import org.azd.exceptions.AzDException;

import java.util.Map;
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
     * @throws AzDException
     */
    public static String generate(SecurityToken.Scope scope, Map<String, String> keys) throws AzDException {
        String output = scope.format;
        if (scope.format.equals("")) { return scope.format; }
        Matcher matcher = tokenPattern.matcher(scope.format);
        while (matcher.find()) {
            output = matcher.replaceFirst(keys.getOrDefault(matcher.group(1), ""));
            matcher.reset(output);
        }
        return output.replaceAll("/*$", ""); // strip forward slash at end of string
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
        ReleaseManagement("c788c23e-1b46-4162-8f5e-d7585343b5de", "{PROJECT_ID}/{folderName}/{RELEASE_DEFINITION_ID}"),
        // Project-level namespaces and permissions
        Project("52d39943-cb85-4d7f-8fa8-c6baac873819", "$PROJECT:vstfs:///Classification/TeamProject/{PROJECT_ID}"),
        // Organization-level namespaces and permissions
        BuildAdministration("302acaca-b667-436d-a946-87133492041c"),
        Collection("3e65f728-f8bc-4ecd-8764-7e378b19bfa7"),
        Process("2dab47f9-bd70-49ed-9bd5-8eb051e59c02"),
        // Role-based namespaces and permissions
        // Internal namespaces and permissions
        Identity("5a27515b-ccd7-42c9-84f1-54c998f03866", "{PROJECT_ID}\\{GROUP_ID}")
        ;

        Scope(String namespace) {
            this.namespace = namespace;
            this.format = "";
        }
        Scope(String namespace, String format) {
            this.namespace = namespace;
            this.format = format;
        }
        private String namespace;
        private String format;

        public String getNamespace() {
            return namespace;
        }

        public String getFormat() {
            return format;
        }
    }
}
