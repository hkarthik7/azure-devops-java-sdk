package org.azd.interfaces;

import org.azd.enums.AccountLicenseType;
import org.azd.enums.GroupType;
import org.azd.enums.LicensingSource;
import org.azd.exceptions.AzDException;
import org.azd.memberentitlementmanagement.types.*;

import java.util.List;

public interface MemberEntitlementManagementDetails {
    GroupEntitlements getGroupEntitlements() throws AzDException;

    GroupEntitlement getGroupEntitlement(String groupId) throws AzDException;

    UsersSummary getUserEntitlementSummary() throws AzDException;

    PagedGraphMemberList getMembers(String groupId) throws AzDException;

    PagedGraphMemberList getMembers(String groupId, int maxResults, String pagingToken) throws AzDException;

    Void removeMemberFromGroup(String groupId, String memberId) throws AzDException;

    UserEntitlementsResponse addUserEntitlement(AccountLicenseType accountLicenseType, String emailId, GroupType groupType, String projectId)
            throws AzDException;

    Void deleteUserEntitlement(String userId) throws AzDException;

    UserEntitlement getUserEntitlement(String userId) throws AzDException;

    PagedGraphMemberList getUserEntitlements() throws AzDException;

    UserEntitlementsResponse updateUserEntitlement(String userId, List<Object> requestBody) throws AzDException;

    UserEntitlementsResponse updateUserEntitlement(String userId, AccountLicenseType accountLicenseType, LicensingSource licensingSource)
            throws AzDException;
}
