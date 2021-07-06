package org.azd.interfaces;

import org.azd.enums.AccountLicenseType;
import org.azd.enums.GroupType;
import org.azd.enums.LicensingSource;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.memberentitlementmanagement.types.*;

import java.util.List;

public interface MemberEntitlementManagementDetails {
    GroupEntitlements getGroupEntitlements() throws ConnectionException, AzDException;
    GroupEntitlement getGroupEntitlement(String groupId) throws ConnectionException, AzDException;
    UsersSummary getUserEntitlementSummary() throws ConnectionException, AzDException;
    PagedGraphMemberList getMembers(String groupId) throws ConnectionException, AzDException;
    PagedGraphMemberList getMembers(String groupId, int maxResults, String pagingToken) throws ConnectionException, AzDException;
    void removeMemberFromGroup(String groupId, String memberId) throws ConnectionException, AzDException;
    UserEntitlementsResponse addUserEntitlement(AccountLicenseType accountLicenseType, String emailId, GroupType groupType, String projectId)
            throws ConnectionException, AzDException;
    void deleteUserEntitlement(String userId) throws ConnectionException, AzDException;
    UserEntitlement getUserEntitlement(String userId) throws ConnectionException, AzDException;
    PagedGraphMemberList getUserEntitlements() throws ConnectionException, AzDException;
    UserEntitlementsResponse updateUserEntitlement (String userId, List<Object> requestBody) throws ConnectionException, AzDException;
    UserEntitlementsResponse updateUserEntitlement (String userId, AccountLicenseType accountLicenseType, LicensingSource licensingSource)
            throws ConnectionException, AzDException;
}
