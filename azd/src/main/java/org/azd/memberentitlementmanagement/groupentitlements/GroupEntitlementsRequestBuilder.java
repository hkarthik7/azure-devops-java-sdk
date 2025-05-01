package org.azd.memberentitlementmanagement.groupentitlements;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.common.types.JsonPatchDocument;
import org.azd.enums.CustomHeader;
import org.azd.enums.RuleOption;
import org.azd.exceptions.AzDException;
import org.azd.memberentitlementmanagement.types.GroupEntitlement;
import org.azd.memberentitlementmanagement.types.GroupEntitlementOperationReference;
import org.azd.memberentitlementmanagement.types.GroupEntitlements;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Group Entitlements Api.
 */
public class GroupEntitlementsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public GroupEntitlementsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "memberEntitlementManagement", "2280bffa-58a2-49da-822e-0764a1bb44f7",
                ApiVersion.MEMBERSHIP_ENTITLEMENT_MANAGEMENT);
    }

    /**
     * Create a group entitlement with license rule, extension rule.
     *
     * @param groupEntitlement Group entitlement object to add.
     * @return Operation reference of the group entitlement.
     * @throws AzDException Default Api request handler.
     */
    public CompletableFuture<GroupEntitlementOperationReference> addAsync(GroupEntitlement groupEntitlement) throws AzDException {
        return builder()
                .POST(groupEntitlement)
                .build()
                .executeAsync(GroupEntitlementOperationReference.class);
    }

    /**
     * Create a group entitlement with license rule, extension rule.
     *
     * @param groupEntitlement Group entitlement object to add.
     * @param ruleOption       RuleOption [ApplyGroupRule/TestApplyGroupRule] - specifies if the rules defined in group
     *                         entitlement should be created and applied to it’s members (default option) or just be tested
     * @return Operation reference of the group entitlement.
     * @throws AzDException Default Api request handler.
     */
    public CompletableFuture<GroupEntitlementOperationReference> addAsync(GroupEntitlement groupEntitlement, RuleOption ruleOption)
            throws AzDException {
        return builder()
                .POST(groupEntitlement)
                .query("ruleOption", ruleOption)
                .build()
                .executeAsync(GroupEntitlementOperationReference.class);
    }

    /**
     * Delete a group entitlement.
     *
     * @param groupId ID of the group to delete.
     * @throws AzDException Default Api request handler.
     */
    public CompletableFuture<Void> deleteAsync(String groupId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("groupId", groupId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Delete a group entitlement.
     *
     * @param groupId    ID of the group to delete.
     * @param ruleOption RuleOption [ApplyGroupRule/TestApplyGroupRule] - specifies if the rules defined in group
     *                   entitlement should be created and applied to it’s members (default option) or just be tested
     * @throws AzDException Default Api request handler.
     */
    public CompletableFuture<Void> deleteAsync(String groupId, RuleOption ruleOption) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("groupId", groupId)
                .query("ruleOption", ruleOption)
                .build()
                .executePrimitiveAsync();
    }


    /**
     * Get a group entitlement. If the group entitlement does not exist, returns null.
     *
     * @param groupId ID of the group.
     * @return Group entitlement object {@link GroupEntitlement}
     * @throws AzDException Default Api request handler.
     */
    public CompletableFuture<GroupEntitlement> getAsync(String groupId) throws AzDException {
        return builder()
                .serviceEndpoint("groupId", groupId)
                .build()
                .executeAsync(GroupEntitlement.class);
    }

    /**
     * Get the group entitlements for an account.
     *
     * @return Collection of Group entitlement object {@link GroupEntitlements}
     * @throws AzDException Default Api request handler.
     */
    public CompletableFuture<GroupEntitlements> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(GroupEntitlements.class);
    }

    /**
     * Update entitlements (License Rule, Extensions Rule, Project memberships etc.) for a group.
     *
     * @param jsonPatchDocument Request body to update the group entitlement.
     * @param groupId           ID of the group.
     * @return Operation reference of the group entitlement.
     * @throws AzDException Default Api request handler.
     */
    public CompletableFuture<GroupEntitlementOperationReference> updateAsync(JsonPatchDocument jsonPatchDocument, String groupId)
            throws AzDException {
        return builder()
                .PATCH(jsonPatchDocument)
                .serviceEndpoint("groupId", groupId)
                .header(CustomHeader.JSON_PATCH)
                .build()
                .executeAsync(GroupEntitlementOperationReference.class);
    }

    /**
     * Update entitlements (License Rule, Extensions Rule, Project memberships etc.) for a group.
     *
     * @param jsonPatchDocument Request body to update the group entitlement.
     * @param groupId           ID of the group.
     * @param ruleOption        RuleOption [ApplyGroupRule/TestApplyGroupRule] - specifies if the rules defined in group
     *                          entitlement should be created and applied to it’s members (default option) or just be tested
     * @return Operation reference of the group entitlement.
     * @throws AzDException Default Api request handler.
     */
    public CompletableFuture<GroupEntitlementOperationReference> updateAsync(JsonPatchDocument jsonPatchDocument, String groupId,
                                                                             RuleOption ruleOption)
            throws AzDException {
        return builder()
                .PATCH(jsonPatchDocument)
                .header(CustomHeader.JSON_PATCH)
                .serviceEndpoint("groupId", groupId)
                .query("ruleOption", ruleOption)
                .build()
                .executeAsync(GroupEntitlementOperationReference.class);
    }

    /**
     * Create a group entitlement with license rule, extension rule.
     *
     * @param groupEntitlement Group entitlement object to add.
     * @return Operation reference of the group entitlement.
     * @throws AzDException Default Api request handler.
     */
    public GroupEntitlementOperationReference add(GroupEntitlement groupEntitlement) throws AzDException {
        return builder()
                .POST(groupEntitlement)
                .build()
                .execute(GroupEntitlementOperationReference.class);
    }

    /**
     * Create a group entitlement with license rule, extension rule.
     *
     * @param groupEntitlement Group entitlement object to add.
     * @param ruleOption       RuleOption [ApplyGroupRule/TestApplyGroupRule] - specifies if the rules defined in group
     *                         entitlement should be created and applied to it’s members (default option) or just be tested
     * @return Operation reference of the group entitlement.
     * @throws AzDException Default Api request handler.
     */
    public GroupEntitlementOperationReference add(GroupEntitlement groupEntitlement, RuleOption ruleOption)
            throws AzDException {
        return builder()
                .POST(groupEntitlement)
                .query("ruleOption", ruleOption)
                .build()
                .execute(GroupEntitlementOperationReference.class);
    }

    /**
     * Delete a group entitlement.
     *
     * @param groupId ID of the group to delete.
     * @throws AzDException Default Api request handler.
     */
    public Void delete(String groupId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("groupId", groupId)
                .build()
                .executePrimitive();
    }

    /**
     * Delete a group entitlement.
     *
     * @param groupId    ID of the group to delete.
     * @param ruleOption RuleOption [ApplyGroupRule/TestApplyGroupRule] - specifies if the rules defined in group
     *                   entitlement should be created and applied to it’s members (default option) or just be tested
     * @throws AzDException Default Api request handler.
     */
    public Void delete(String groupId, RuleOption ruleOption) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("groupId", groupId)
                .query("ruleOption", ruleOption)
                .build()
                .executePrimitive();
    }


    /**
     * Get a group entitlement. If the group entitlement does not exist, returns null.
     *
     * @param groupId ID of the group.
     * @return Group entitlement object {@link GroupEntitlement}
     * @throws AzDException Default Api request handler.
     */
    public GroupEntitlement get(String groupId) throws AzDException {
        return builder()
                .serviceEndpoint("groupId", groupId)
                .build()
                .execute(GroupEntitlement.class);
    }

    /**
     * Get the group entitlements for an account.
     *
     * @return Collection of Group entitlement object {@link GroupEntitlements}
     * @throws AzDException Default Api request handler.
     */
    public GroupEntitlements list() throws AzDException {
        return builder()
                .build()
                .execute(GroupEntitlements.class);
    }

    /**
     * Update entitlements (License Rule, Extensions Rule, Project memberships etc.) for a group.
     *
     * @param jsonPatchDocument Request body to update the group entitlement.
     * @param groupId           ID of the group.
     * @return Operation reference of the group entitlement.
     * @throws AzDException Default Api request handler.
     */
    public GroupEntitlementOperationReference update(JsonPatchDocument jsonPatchDocument, String groupId)
            throws AzDException {
        return builder()
                .PATCH(jsonPatchDocument)
                .header(CustomHeader.JSON_PATCH)
                .serviceEndpoint("groupId", groupId)
                .build()
                .execute(GroupEntitlementOperationReference.class);
    }

    /**
     * Update entitlements (License Rule, Extensions Rule, Project memberships etc.) for a group.
     *
     * @param jsonPatchDocument Request body to update the group entitlement.
     * @param groupId           ID of the group.
     * @param ruleOption        RuleOption [ApplyGroupRule/TestApplyGroupRule] - specifies if the rules defined in group
     *                          entitlement should be created and applied to it’s members (default option) or just be tested
     * @return Operation reference of the group entitlement.
     * @throws AzDException Default Api request handler.
     */
    public GroupEntitlementOperationReference update(JsonPatchDocument jsonPatchDocument, String groupId,
                                                     RuleOption ruleOption)
            throws AzDException {
        return builder()
                .PATCH(jsonPatchDocument)
                .header(CustomHeader.JSON_PATCH)
                .serviceEndpoint("groupId", groupId)
                .query("ruleOption", ruleOption)
                .build()
                .execute(GroupEntitlementOperationReference.class);
    }
}
