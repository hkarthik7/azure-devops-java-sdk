package org.azd.memberentitlementmanagement.serviceprincipalentitlements;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.common.types.JsonPatchDocument;
import org.azd.enums.CustomHeader;
import org.azd.exceptions.AzDException;
import org.azd.memberentitlementmanagement.types.ServicePrincipalEntitlement;
import org.azd.memberentitlementmanagement.types.ServicePrincipalEntitlementOperationReference;
import org.azd.memberentitlementmanagement.types.ServicePrincipalEntitlementsPatchResponse;
import org.azd.memberentitlementmanagement.types.ServicePrincipalEntitlementsPostResponse;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Members Api.
 */
public class ServicePrincipalEntitlementsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ServicePrincipalEntitlementsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "memberEntitlementManagement", "1d491a66-190b-43ae-86b8-9c2688c55186",
                ApiVersion.MEMBERSHIP_ENTITLEMENT_MANAGEMENT);
    }

    /**
     * Add a service principal, assign license and extensions and make them a member of a project group in an account.
     * <p>
     * <br /><strong>NOTE:</strong> If you are working with AAD app registration, you can find service principal of your app in enterprise
     * applications, and make sure to use service principal's object id as originId parameter in the request body
     *
     * @param servicePrincipalEntitlement Request body of service principal object {@link ServicePrincipalEntitlement}
     * @return Post response of service principal entitlement {@link ServicePrincipalEntitlementsPostResponse}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ServicePrincipalEntitlementsPostResponse> addAsync(ServicePrincipalEntitlement servicePrincipalEntitlement)
            throws AzDException {
        return builder()
                .POST(servicePrincipalEntitlement)
                .location("f03dbf50-80f8-41b7-8ca2-65b6a178caba")
                .build()
                .executeAsync(ServicePrincipalEntitlementsPostResponse.class);
    }

    /**
     * Delete a service principal from the account.
     * <p>
     * <br />The delete operation includes un-assigning Extensions and Licenses and removing the service principal from
     * all project memberships. The service principal would continue to have access to the account if it is member
     * of an AAD group, that is added directly to the account.
     *
     * @param servicePrincipalId ID of the service principal.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<Void> deleteAsync(String servicePrincipalId)
            throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("servicePrincipalId", servicePrincipalId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get Service principal Entitlement for a service principal.
     *
     * @param servicePrincipalId ID of the service principal.
     * @return ServicePrincipalEntitlement object {@link ServicePrincipalEntitlement}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ServicePrincipalEntitlement> getAsync(String servicePrincipalId)
            throws AzDException {
        return builder()
                .serviceEndpoint("servicePrincipalId", servicePrincipalId)
                .build()
                .executeAsync(ServicePrincipalEntitlement.class);
    }

    /**
     * Edit the entitlements (License, Extensions, Projects, Teams etc) for a service principal.
     *
     * @param servicePrincipalId ID of the service principal.
     * @param jsonPatchDocument  Parameters for update operation.
     * @return ServicePrincipalEntitlement object {@link ServicePrincipalEntitlement}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ServicePrincipalEntitlementsPatchResponse> updateAsync(String servicePrincipalId, List<JsonPatchDocument> jsonPatchDocument)
            throws AzDException {
        return builder()
                .PATCH(jsonPatchDocument)
                .serviceEndpoint("servicePrincipalId", servicePrincipalId)
                .header(CustomHeader.JSON_PATCH)
                .build()
                .executeAsync(ServicePrincipalEntitlementsPatchResponse.class);
    }

    /**
     * Edit the entitlements (License, Extensions, Projects, Teams etc) for one or more service principals.
     *
     * @param jsonPatchDocument Parameters for update operation.
     * @return ServicePrincipalEntitlementOperationReference object {@link ServicePrincipalEntitlementOperationReference}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ServicePrincipalEntitlementOperationReference> updateAsync(List<JsonPatchDocument> jsonPatchDocument)
            throws AzDException {
        return builder()
                .PATCH(jsonPatchDocument)
                .location("f03dbf50-80f8-41b7-8ca2-65b6a178caba")
                .header(CustomHeader.JSON_PATCH)
                .build()
                .executeAsync(ServicePrincipalEntitlementOperationReference.class);
    }

    /**
     * Add a service principal, assign license and extensions and make them a member of a project group in an account.
     * <p>
     * <br /><strong>NOTE:</strong> If you are working with AAD app registration, you can find service principal of your app in enterprise
     * applications, and make sure to use service principal's object id as originId parameter in the request body
     *
     * @param servicePrincipalEntitlement Request body of service principal object {@link ServicePrincipalEntitlement}
     * @return Post response of service principal entitlement {@link ServicePrincipalEntitlementsPostResponse}
     * @throws AzDException Default Api exception handler.
     */
    public ServicePrincipalEntitlementsPostResponse add(ServicePrincipalEntitlement servicePrincipalEntitlement)
            throws AzDException {
        return builder()
                .POST(servicePrincipalEntitlement)
                .location("f03dbf50-80f8-41b7-8ca2-65b6a178caba")
                .build()
                .execute(ServicePrincipalEntitlementsPostResponse.class);
    }

    /**
     * Delete a service principal from the account.
     * <p>
     * <br />The delete operation includes un-assigning Extensions and Licenses and removing the service principal from
     * all project memberships. The service principal would continue to have access to the account if it is member
     * of an AAD group, that is added directly to the account.
     *
     * @param servicePrincipalId ID of the service principal.
     * @throws AzDException Default Api exception handler.
     */
    public Void delete(String servicePrincipalId)
            throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("servicePrincipalId", servicePrincipalId)
                .build()
                .executePrimitive();
    }

    /**
     * Get Service principal Entitlement for a service principal.
     *
     * @param servicePrincipalId ID of the service principal.
     * @return ServicePrincipalEntitlement object {@link ServicePrincipalEntitlement}
     * @throws AzDException Default Api exception handler.
     */
    public ServicePrincipalEntitlement get(String servicePrincipalId)
            throws AzDException {
        return builder()
                .serviceEndpoint("servicePrincipalId", servicePrincipalId)
                .build()
                .execute(ServicePrincipalEntitlement.class);
    }

    /**
     * Edit the entitlements (License, Extensions, Projects, Teams etc) for a service principal.
     *
     * @param servicePrincipalId ID of the service principal.
     * @param jsonPatchDocument  Parameters for update operation.
     * @return ServicePrincipalEntitlement object {@link ServicePrincipalEntitlement}
     * @throws AzDException Default Api exception handler.
     */
    public ServicePrincipalEntitlementsPatchResponse update(String servicePrincipalId, JsonPatchDocument jsonPatchDocument)
            throws AzDException {
        return builder()
                .PATCH(jsonPatchDocument)
                .serviceEndpoint("servicePrincipalId", servicePrincipalId)
                .header(CustomHeader.JSON_PATCH)
                .build()
                .execute(ServicePrincipalEntitlementsPatchResponse.class);
    }

    /**
     * Edit the entitlements (License, Extensions, Projects, Teams etc) for one or more service principals.
     *
     * @param jsonPatchDocument Parameters for update operation.
     * @return ServicePrincipalEntitlementOperationReference object {@link ServicePrincipalEntitlementOperationReference}
     * @throws AzDException Default Api exception handler.
     */
    public ServicePrincipalEntitlementOperationReference update(JsonPatchDocument jsonPatchDocument)
            throws AzDException {
        return builder()
                .PATCH(jsonPatchDocument)
                .location("f03dbf50-80f8-41b7-8ca2-65b6a178caba")
                .header(CustomHeader.JSON_PATCH)
                .build()
                .execute(ServicePrincipalEntitlementOperationReference.class);
    }
}
