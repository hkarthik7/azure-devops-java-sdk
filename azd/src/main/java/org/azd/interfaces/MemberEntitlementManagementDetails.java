package org.azd.interfaces;

import org.azd.enums.AccountLicenseType;
import org.azd.enums.GroupType;
import org.azd.enums.LicensingSource;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;
import org.azd.memberentitlementmanagement.types.*;

import java.util.List;

public interface MemberEntitlementManagementDetails {
    GroupEntitlements getGroupEntitlements() throws DefaultParametersException, AzDException;
    GroupEntitlement getGroupEntitlement(String groupId) throws DefaultParametersException, AzDException;
    UsersSummary getUserEntitlementSummary() throws DefaultParametersException, AzDException;
    PagedGraphMemberList getMembers(String groupId) throws DefaultParametersException, AzDException;
    PagedGraphMemberList getMembers(String groupId, int maxResults, String pagingToken) throws DefaultParametersException, AzDException;
    void removeMemberFromGroup(String groupId, String memberId) throws DefaultParametersException, AzDException;
    UserEntitlementsResponse addUserEntitlement(AccountLicenseType accountLicenseType, String emailId, GroupType groupType, String projectId)
            throws DefaultParametersException, AzDException;
    void deleteUserEntitlement(String userId) throws DefaultParametersException, AzDException;
    UserEntitlement getUserEntitlement(String userId) throws DefaultParametersException, AzDException;
    PagedGraphMemberList getUserEntitlements() throws DefaultParametersException, AzDException;
    UserEntitlementsResponse updateUserEntitlement (String userId, List<Object> requestBody) throws DefaultParametersException, AzDException;
    UserEntitlementsResponse updateUserEntitlement (String userId, AccountLicenseType accountLicenseType, LicensingSource licensingSource)
            throws DefaultParametersException, AzDException;
}
