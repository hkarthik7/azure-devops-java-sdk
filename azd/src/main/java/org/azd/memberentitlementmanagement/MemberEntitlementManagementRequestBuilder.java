package org.azd.memberentitlementmanagement;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.memberentitlementmanagement.groupentitlements.GroupEntitlementsRequestBuilder;
import org.azd.memberentitlementmanagement.memberentitlements.MemberEntitlementsRequestBuilder;
import org.azd.memberentitlementmanagement.members.MembersRequestBuilder;
import org.azd.memberentitlementmanagement.serviceprincipalentitlements.ServicePrincipalEntitlementsRequestBuilder;
import org.azd.memberentitlementmanagement.userentitlements.UserEntitlementsRequestBuilder;
import org.azd.memberentitlementmanagement.userentitlementsummary.UserEntitlementSummaryRequestBuilder;

/**
 * Provides functionality to work with Member Entitlement Management Api.
 */
public class MemberEntitlementManagementRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public MemberEntitlementManagementRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Group Entitlements Api.
     *
     * @return GroupEntitlementsRequestBuilder {@link GroupEntitlementsRequestBuilder}
     */
    public GroupEntitlementsRequestBuilder groupEntitlements() {
        return new GroupEntitlementsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Group Entitlements Api.
     *
     * @return MemberEntitlementsRequestBuilder {@link MemberEntitlementsRequestBuilder}
     */
    public MemberEntitlementsRequestBuilder memberEntitlements() {
        return new MemberEntitlementsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Members Api.
     *
     * @return MembersRequestBuilder {@link MembersRequestBuilder}
     */
    public MembersRequestBuilder members() {
        return new MembersRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Service principal entitlements Api.
     *
     * @return ServicePrincipalEntitlementsRequestBuilder {@link ServicePrincipalEntitlementsRequestBuilder}
     */
    public ServicePrincipalEntitlementsRequestBuilder servicePrincipalEntitlements() {
        return new ServicePrincipalEntitlementsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage User entitlement summary Api.
     *
     * @return UserEntitlementSummaryRequestBuilder {@link UserEntitlementSummaryRequestBuilder}
     */
    public UserEntitlementSummaryRequestBuilder userEntitlementSummary() {
        return new UserEntitlementSummaryRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage User entitlements Api.
     *
     * @return UserEntitlementsRequestBuilder {@link UserEntitlementsRequestBuilder}
     */
    public UserEntitlementsRequestBuilder userEntitlements() {
        return new UserEntitlementsRequestBuilder(organizationUrl, accessTokenCredential);
    }
}
