package org.azd.memberentitlementmanagement;

import org.azd.enums.AccountLicenseType;
import org.azd.enums.GroupType;
import org.azd.enums.LicensingSource;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.MemberEntitlementManagementDetails;
import org.azd.memberentitlementmanagement.types.*;
import org.azd.connection.Connection;
import org.azd.utils.ResourceId;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.azd.utils.Client.request;

/***
 * MemberEntitlementManagementApi class to manage groups and user entitlements API
 */
public class MemberEntitlementManagementApi implements MemberEntitlementManagementDetails {
    /***
     * Connection object
     */
    private final Connection CONNECTION;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String GROUP_AREA = "groupentitlements";
    private final String USER_AREA = "userentitlements";

    /***
     * Pass the connection object to work with Member Entitlement Management Api
     * @param connection Connection object
     */
    public MemberEntitlementManagementApi(Connection connection) { this.CONNECTION = connection; }

    /***
     * Get the group entitlements for an account.
     * @return GroupEntitlements {@link GroupEntitlements}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public GroupEntitlements getGroupEntitlements() throws DefaultParametersException, AzDException {
        String r = request(RequestMethod.GET, CONNECTION, ResourceId.MEMBERENTITLEMENTMANAGEMENT, null,
                GROUP_AREA, null, null, MemberEntitlementManagementVersion.VERSION, null, null);

        return MAPPER.mapJsonResponse(r, GroupEntitlements.class);
    }

    /***
     * Get a group entitlement. If the group entitlement does not exist, returns null.
     * @param groupId ID of the group.
     * @return GroupEntitlement {@link GroupEntitlement}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public GroupEntitlement getGroupEntitlement(String groupId) throws DefaultParametersException, AzDException {
        String r = request(RequestMethod.GET, CONNECTION, ResourceId.MEMBERENTITLEMENTMANAGEMENT, null,
                GROUP_AREA, groupId, null, MemberEntitlementManagementVersion.VERSION, null, null);

        return MAPPER.mapJsonResponse(r, GroupEntitlement.class);
    }

    /***
     * Get summary of Licenses, Extension, Projects, Groups and their assignments in the collection.
     * @return UsersSummary {@link UsersSummary}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public UsersSummary getUserEntitlementSummary() throws DefaultParametersException, AzDException {
        String r = request(RequestMethod.GET, CONNECTION, ResourceId.MEMBERENTITLEMENTMANAGEMENT, null,
                "userentitlementsummary", null, null, MemberEntitlementManagementVersion.VERSION, null, null);

        return MAPPER.mapJsonResponse(r, UsersSummary.class);
    }

    /***
     * Get direct members of a Group.
     * @param groupId Id of the Group.
     * @return PagedGraphMemberList {@link PagedGraphMemberList}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public PagedGraphMemberList getMembers(String groupId) throws DefaultParametersException, AzDException {
        String r = request(RequestMethod.GET, CONNECTION, ResourceId.MEMBERENTITLEMENTMANAGEMENT, null,
                GROUP_AREA, groupId, "members", MemberEntitlementManagementVersion.VERSION, null, null);

        return MAPPER.mapJsonResponse(r, PagedGraphMemberList.class);
    }

    /***
     * Get direct members of a Group.
     * @param groupId Id of the Group.
     * @param maxResults Maximum number of results to retrieve.
     * @param pagingToken Paging Token from the previous page fetched.
     * If the 'pagingToken' is null, the results would be fetched from the beginning of the Members List.
     * @return PagedGraphMemberList {@link PagedGraphMemberList}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public PagedGraphMemberList getMembers(String groupId, int maxResults, String pagingToken) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
           put("maxResults", maxResults);
            put("pagingToken", pagingToken);
        }};

        String r = request(RequestMethod.GET, CONNECTION, ResourceId.MEMBERENTITLEMENTMANAGEMENT, null,
                GROUP_AREA, groupId, "members", MemberEntitlementManagementVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, PagedGraphMemberList.class);
    }

    /***
     * Remove a member from a Group.
     * @param groupId Id of the group.
     * @param memberId Id of the group.
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public void removeMemberFromGroup(String groupId, String memberId) throws DefaultParametersException, AzDException {
        try {
            String r = request(RequestMethod.DELETE, CONNECTION, ResourceId.MEMBERENTITLEMENTMANAGEMENT, null,
                    GROUP_AREA, groupId, "members/" + memberId,
                    MemberEntitlementManagementVersion.VERSION, null, null);

            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);

        } catch (DefaultParametersException | AzDException e) {
            throw e;
        }
    }

    /***
     * Add a user, assign license and make them a member of a project group in an account.
     * @param accountLicenseType Type of Account License (e.g. Express, Stakeholder etc.) {@link AccountLicenseType}
     * @param emailId Email address of the user.
     * @param groupType Type of the group. (e.g. Project Administrator, Project Contributor, etc.) {@link GroupType}
     * @param projectId Id of the project. Get the project id by running getProjects() or getProject("projectName") from CoreApi.
     * @return UserEntitlementsResponse {@link UserEntitlementsResponse}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public UserEntitlementsResponse addUserEntitlement(AccountLicenseType accountLicenseType, String emailId, GroupType groupType, String projectId)
            throws DefaultParametersException, AzDException {

        var projectEntitlement = new LinkedHashMap<String, Object>(){{
            put("group", new LinkedHashMap<String, Object>(){{
                put("groupType", groupType.toString().toLowerCase());
            }});
            put("projectRef", new LinkedHashMap<String, Object>(){{
                put("id", projectId);
            }});
        }};

        var body = new LinkedHashMap<String, Object>(){{
            put("accessLevel", new LinkedHashMap<String, Object>(){{
                put("accountLicenseType", accountLicenseType.toString().toLowerCase());
            }});
            put("user", new LinkedHashMap<String, Object>(){{
                put("principalName", emailId);
                put("subjectKind", "user");
            }});
            put("projectEntitlements", List.of(projectEntitlement));
        }};

        String r = request(RequestMethod.POST, CONNECTION, ResourceId.MEMBERENTITLEMENTMANAGEMENT, null,
                USER_AREA, null, null, MemberEntitlementManagementVersion.USER_ENTITLEMENTS, null, body);

        return MAPPER.mapJsonResponse(r, UserEntitlementsResponse.class);
    }

    /***
     * Delete a user from the account.
     * The delete operation includes unassigning Extensions and Licenses and removing the user from all project memberships.
     * The user would continue to have access to the account if she is member of an AAD group, that is added directly to the account.
     * @param userId userId ID of the user. Run getUserEntitlements() to get a list of users and get the user id.
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public void deleteUserEntitlement(String userId) throws DefaultParametersException, AzDException {
        try {
            String r = request(RequestMethod.DELETE, CONNECTION, ResourceId.MEMBERENTITLEMENTMANAGEMENT, null,
                    USER_AREA, userId, null,
                    MemberEntitlementManagementVersion.USER_ENTITLEMENTS, null, null);

            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);

        } catch (DefaultParametersException | AzDException e) {
            throw e;
        }
    }

    /***
     * Get User Entitlement for a user.
     * @param userId userId ID of the user. Run getUserEntitlements() to get a list of users and get the user id.
     * @return UserEntitlement {@link UserEntitlement}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public UserEntitlement getUserEntitlement(String userId) throws DefaultParametersException, AzDException {
        String r = request(RequestMethod.GET, CONNECTION, ResourceId.MEMBERENTITLEMENTMANAGEMENT, null,
                USER_AREA, userId, null, MemberEntitlementManagementVersion.USER_ENTITLEMENTS, null, null);

        return MAPPER.mapJsonResponse(r, UserEntitlement.class);
    }

    /***
     * Get a list of users/members entitlements.
     * @return PagedGraphMemberList {@link PagedGraphMemberList}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public PagedGraphMemberList getUserEntitlements() throws DefaultParametersException, AzDException {
        String r = request(RequestMethod.GET, CONNECTION, ResourceId.MEMBERENTITLEMENTMANAGEMENT, null,
                USER_AREA, null, null, MemberEntitlementManagementVersion.USER_ENTITLEMENTS, null, null);

        return MAPPER.mapJsonResponse(r, PagedGraphMemberList.class);
    }

    /***
     * Edit the entitlements (License, Extensions, Projects, Teams etc) for a user. Pass a list of items that you want to edit for a user.
     * @param userId ID of the user. Run getUserEntitlements() to get a list of users and get the user id.
     * @return UserEntitlementsResponse {@link UserEntitlementsResponse}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public UserEntitlementsResponse updateUserEntitlement(String userId, List<Object> requestBody) throws DefaultParametersException, AzDException {
        String r = request(RequestMethod.PATCH, CONNECTION, ResourceId.MEMBERENTITLEMENTMANAGEMENT, null,
                USER_AREA, userId, null, MemberEntitlementManagementVersion.USER_ENTITLEMENTS, null,
                null, requestBody, "application/json-patch+json");

        return MAPPER.mapJsonResponse(r, UserEntitlementsResponse.class);
    }

    /***
     * Edit the entitlements License for a user. Set the license account type and license source type for a user.
     * @param userId ID of the user. Run getUserEntitlements() to get a list of users and get the user id.
     * @param accountLicenseType Type of Account License (e.g. Express, Stakeholder etc.) {@link AccountLicenseType}
     * @param licensingSource Licensing Source (e.g. Account. MSDN etc.) {@link LicensingSource}
     * @return UserEntitlementsResponse {@link UserEntitlementsResponse}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public UserEntitlementsResponse updateUserEntitlement(String userId, AccountLicenseType accountLicenseType, LicensingSource licensingSource)
            throws DefaultParametersException, AzDException {
        var pos = new LinkedHashMap<String, Object>(){{
            put("from", "");
            put("op", "replace");
            put("path", "/accessLevel");
            put("value", new LinkedHashMap<String, Object>(){{
                put("accountLicenseType", accountLicenseType.toString().toLowerCase());
                put("licensingSource", licensingSource.toString().toLowerCase());
            }});
        }};

        String r = request(RequestMethod.PATCH, CONNECTION, ResourceId.MEMBERENTITLEMENTMANAGEMENT, null,
                USER_AREA, userId, null, MemberEntitlementManagementVersion.USER_ENTITLEMENTS, null,
                null, List.of(pos), "application/json-patch+json");

        return MAPPER.mapJsonResponse(r, UserEntitlementsResponse.class);
    }
}
