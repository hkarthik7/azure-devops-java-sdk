package org.azd.security;

import org.azd.common.ApiVersion;
import org.azd.connection.Connection;
import org.azd.enums.ApiExceptionTypes;
import org.azd.enums.CustomHeader;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.helpers.URLHelper;
import org.azd.interfaces.SecurityDetails;
import org.azd.security.types.*;
import org.azd.utils.AzDAsyncApi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.azd.utils.RestClient.send;

public class SecurityApi extends AzDAsyncApi<SecurityApi> implements SecurityDetails {
    private final Connection CONNECTION;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String SECURITY = "2e426be0-da4d-48c4-9178-978da8562255";
    private final String IDENTITY = "fc3682be-3d6c-427a-87c8-e527b16a1d05";
    private final String AREA_NAMESPACE = "securitynamespaces";
    private final String AREA_ACL = "accesscontrollists";
    private final String AREA_ACE = "accesscontrolentries";
    private final String AREA_IDENTITIES = "identities";

    /***
     * Pass the connection object to work with Security Api
     * @param connection Connection object
     */
    public SecurityApi(Connection connection) {
        this.CONNECTION = connection;
    }

    /***
     * return all security namespaces, remote and local
     *
     * Security namespaces are used to store access control lists (ACLs) on tokens.
     * @return SecurityNamespaces {@link SecurityNamespaces}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public SecurityNamespaces getNamespaces() throws AzDException {
        return getNamespaces(false);
    }

    /***
     * return all security namespaces, remote and local
     *
     * Local vs. remote
     * <ul>
     * <li>Security namespaces may have their data mastered in one microservice, but still be visible in other microservices.</li>
     * <li>If a security namespace's data is mastered in microservice X, it is said to be local to that microservice. Otherwise, it is said to be remote.</li>
     * </ul>
     *
     * @param localOnly whether to include only local or all namespaces
     * @return SecurityNamespaces {@link SecurityNamespaces}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public SecurityNamespaces getNamespaces(boolean localOnly) throws AzDException {
        LinkedHashMap<String, Object> q = new LinkedHashMap<>() {{
            put("localOnly", localOnly);
        }};

        String r = send(RequestMethod.GET, CONNECTION, SECURITY, null,
                AREA_NAMESPACE, null, null, ApiVersion.SECURITY, q, null, null);

        return MAPPER.mapJsonResponse(r, SecurityNamespaces.class);
    }

    /***
     * return a namespace with the specific identifier
     *
     * @param namespaceId namespace identifier
     * @return SecurityNamespace {@link SecurityNamespace}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public SecurityNamespace getNamespace(String namespaceId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, SECURITY, null,
                AREA_NAMESPACE, namespaceId, null, ApiVersion.SECURITY, null, null, null);

        SecurityNamespaces securityNamespaces = MAPPER.mapJsonResponse(r, SecurityNamespaces.class);
        return securityNamespaces.getSecurityNamespaces().get(0);
    }

    /***
     * Return a list of access control lists for the specified security namespace and token.
     * All ACLs in the security namespace will be retrieved if no optional parameters are provided.
     *
     * @param namespaceId identifier of namespace
     * @return ACLs {@link ACLs}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ACLs getAccessControlLists(String namespaceId) throws AzDException {
        return getAccessControlLists(namespaceId, null, null, false, false);
    }

    /***
     * Return a list of access control lists for the specified security namespace and token. All ACLs in the security namespace will be retrieved if no optional parameters are provided.
     *
     * @param namespaceId identifier of namespace
     * @param descriptors An optional filter string containing a list of identity descriptors separated by ',' whose ACEs should be retrieved. If this is left null, entire ACLs will be returned.
     * @param token Security token. See <a href="https://docs.microsoft.com/en-us/azure/devops/organizations/security/namespace-reference?view=azure-devops">Security namespace and permission reference for Azure DevOps</a>
     * @param includeExtendedInfo If true, populate the extended information properties for the access control entries contained in the returned lists.
     * @param recurse If true and this is a hierarchical namespace, return child ACLs of the specified token.
     * @return ACLs {@link ACLs}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ACLs getAccessControlLists(String namespaceId, String[] descriptors, String token,
                                      boolean includeExtendedInfo, boolean recurse) throws AzDException {
        HashMap<String, Object> q = new HashMap<>() {{
            if (descriptors != null && descriptors.length > 0) {
                put("descriptors", Arrays.stream(descriptors)
                        .filter(x -> x != null && !x.isBlank())
                        .map(URLHelper::encodeSpecialWithSpace)
                        .collect(Collectors.joining(",")));
            }
            if (token != null) {
                put("token", URLHelper.encodeSpecialWithSpace(token));
            }
            put("includeExtendedInfo", includeExtendedInfo);
            put("recurse", recurse);
        }};
        String r = send(RequestMethod.GET, CONNECTION, SECURITY, null,
                AREA_ACL, namespaceId, null, ApiVersion.SECURITY, q, null, null);

        return MAPPER.mapJsonResponse(r, ACLs.class);
    }

    /***
     * Resolve legacy identity information for use with older APIs such as the Security APIs
     *
     * @param descriptors A list of identity descriptors to resolve
     * @param identityIds A list of storage keys to resolve
     * @param subjectDescriptors list of subject descriptors to resolve
     * @param filterValue The search value, as specified by the searchFilter.
     * @param queryMembership The membership information to include with the identities. Values can be None for no membership data or Direct to include the groups that the identity is a member of and the identities that are a member of this identity (groups only)
     * @param searchFilter The type of search to perform. Values can be AccountName (domain\alias), DisplayName, MailAddress, General (display name, account name, or unique name), or LocalGroupName (only search Azure Devops groups).
     * @return Identities {@link Identities}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Identities getIdentities(String[] descriptors, String[] identityIds, String[] subjectDescriptors,
                                    String filterValue, String queryMembership, String searchFilter) throws AzDException {
        LinkedHashMap<String, Object> q = new LinkedHashMap<>() {{
            if (descriptors != null && descriptors.length > 0) {
                put("descriptors", Arrays.stream(descriptors)
                        .filter(x -> x != null && !x.isBlank())
                        .map(URLHelper::encodeSpecialWithSpace)
                        .collect(Collectors.joining(",")));
            }
            if (identityIds != null && identityIds.length > 0) {
                put("identityIds", Arrays.stream(identityIds)
                        .filter(x -> x != null && !x.isBlank())
                        .map(URLHelper::encodeSpecialWithSpace)
                        .collect(Collectors.joining(",")));
            }
            if (subjectDescriptors != null && subjectDescriptors.length > 0) {
                put("subjectDescriptors", Arrays.stream(subjectDescriptors)
                        .filter(x -> x != null && !x.isBlank())
                        .map(URLHelper::encodeSpecialWithSpace)
                        .collect(Collectors.joining(",")));
            }
            if (filterValue != null) put("filterValue", URLHelper.encodeSpecialWithSpace(filterValue));
            if (validIdentityQueryMembership(queryMembership))
                put("queryMembership", URLHelper.encodeSpecialWithSpace(queryMembership));
            if (validIdentitySearchFilter(searchFilter))
                put("searchFilter", URLHelper.encodeSpecialWithSpace(searchFilter));
        }};
        String r = send(RequestMethod.GET, CONNECTION, IDENTITY, null,
                AREA_IDENTITIES, null, null, ApiVersion.IDENTITY, q, null, null);
        return MAPPER.mapJsonResponse(r, Identities.class);
    }

    /***
     * see {@link SecurityApi#getIdentities(String[], String[], String[], String, String, String)}
     * shortcut to provide var args list of subjectDescriptors only
     *
     * @param subjectDescriptors list of subject descriptors to resolve
     * @return Identities {@link Identities}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Identities getIdentitiesFromSubjectDescriptors(String... subjectDescriptors) throws AzDException {
        return getIdentities(null, null, subjectDescriptors, null, null, null);
    }

    /**
     * Add or update ACEs in the ACL for the provided token.  The request body contains the target token, a list of ACEs and a optional merge parameter.
     * In the case of a collision (by identity descriptor) with an existing ACE in the ACL, the "merge" parameter determines the behavior.
     * If set, the existing ACE has its allow and deny merged with the incoming ACE's allow and deny. If unset, the existing ACE is displaced.
     *
     * @param namespaceId Security namespace identifier.
     * @param payload     An array of {@link ACEs}. Class for encapsulating the allowed and denied permissions for a given IdentityDescriptor.
     * @return ACEs {@link ACEs}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ACEs setAccessControlEntries(String namespaceId, ACEs payload) throws AzDException {
        String r = send(RequestMethod.POST, CONNECTION, SECURITY, null,
                AREA_ACE, namespaceId, null, ApiVersion.SECURITY, null, payload, CustomHeader.JSON_CONTENT_TYPE);
        return MAPPER.mapJsonResponse(r, ACEs.class);
    }

    /**
     * Remove the specified ACEs from the ACL belonging to the specified token.
     *
     * @param namespaceId Security namespace identifier.
     * @param descriptors A list of identity descriptors whose entries should be removed.
     * @param tokens      A list of tokens whose ACL should be modified.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void removeAccessControlEntries(String namespaceId, String[] descriptors, String[] tokens) throws AzDException {
        if (tokens == null || tokens.length == 0) {
            throw new AzDException(ApiExceptionTypes.InvalidArgumentException.name(), "Tokens list must not be empty.");
        }
        if (tokens == null || tokens.length == 0) {
            throw new AzDException(ApiExceptionTypes.InvalidArgumentException.name(), "Descriptors list must not be empty.");
        }
        HashMap<String, Object> q = new HashMap<>() {{
            put("tokens", Arrays.stream(tokens)
                    .filter(x -> x != null && !x.isBlank())
                    .map(URLHelper::encodeSpecialWithSpace)
                    .collect(Collectors.joining(",")));
            put("descriptors", Arrays.stream(descriptors)
                    .filter(x -> x != null && !x.isBlank())
                    .map(URLHelper::encodeSpecialWithSpace)
                    .collect(Collectors.joining(",")));
        }};
        String r = send(RequestMethod.DELETE, CONNECTION, SECURITY, null,
                AREA_ACE, namespaceId, null, ApiVersion.SECURITY, q, null, null);
        return null;
    }

    /***
     * Create or update one or more access control lists. All data that currently exists for the ACLs supplied will be overwritten.
     *
     * @param namespaceId Security namespace identifier.
     * @param payload ACLs {@link ACLs}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void setAccessControlList(String namespaceId, ACLs payload) throws AzDException {
        String r = send(RequestMethod.POST, CONNECTION, SECURITY, null,
                AREA_ACL, namespaceId, null, ApiVersion.SECURITY, null, payload, CustomHeader.JSON_CONTENT_TYPE);
        return null;
    }

    /***
     * Remove access control lists under the specified security namespace.
     *
     * @param namespaceId Security namespace identifier.
     * @param recurse If true and this is a hierarchical namespace, also remove child ACLs of the specified tokens.
     * @param tokens One or more comma-separated security tokens
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void removeAccessControlLists(String namespaceId, boolean recurse, String[] tokens) throws AzDException {
        if (tokens == null || tokens.length == 0) {
            throw new AzDException(ApiExceptionTypes.InvalidArgumentException.name(), "Tokens list must not be empty.");
        }
        HashMap<String, Object> q = new HashMap<>() {{
            put("tokens", Arrays.stream(tokens)
                    .filter(x -> x != null && !x.isBlank())
                    .map(URLHelper::encodeSpecialWithSpace)
                    .collect(Collectors.joining(",")));
            put("recurse", recurse);
        }};
        String r = send(RequestMethod.DELETE, CONNECTION, SECURITY, null,
                AREA_ACL, namespaceId, null, ApiVersion.SECURITY, q, null, null);
        return null;
    }

    private boolean validIdentityQueryMembership(String queryMembership) {
        return queryMembership != null && List.of("none", "direct").contains(queryMembership.toLowerCase());
    }

    private boolean validIdentitySearchFilter(String searchFilter) {
        return searchFilter != null && List.of("accountname", "displayname", "mailaddress", "general", "localgroupname").contains(searchFilter.toLowerCase());
    }
}
