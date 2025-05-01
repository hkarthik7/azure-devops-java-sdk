package org.azd.memberentitlementmanagement.userentitlementsummary;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.helpers.Utils;
import org.azd.memberentitlementmanagement.types.UsersSummary;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with User entitlement summary Api.
 */
public class UserEntitlementSummaryRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public UserEntitlementSummaryRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "memberEntitlementManagement", "5ae55b13-c9dd-49d1-957e-6e76c152e3d9",
                ApiVersion.USER_ENTITLEMENT_SUMMARY);
    }

    /**
     * Get summary of Licenses, Extension, Projects, Groups and their assignments in the collection.
     *
     * @param select Comma (",") separated list of properties to select. Supported property names are {AccessLevels, Licenses, Projects, Groups}.
     * @return Users summary object {@link UsersSummary}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<UsersSummary> getAsync(String... select) throws AzDException {
        return builder()
                .query("select", Utils.toString(select))
                .build()
                .executeAsync(UsersSummary.class);
    }

    /**
     * Get summary of Licenses, Extension, Projects, Groups and their assignments in the collection.
     *
     * @param select Comma (",") separated list of properties to select. Supported property names are {AccessLevels, Licenses, Projects, Groups}.
     * @return Users summary object {@link UsersSummary}
     * @throws AzDException Default Api exception handler.
     */
    public UsersSummary get(String... select) throws AzDException {
        return builder()
                .query("select", Utils.toString(select))
                .build()
                .execute(UsersSummary.class);
    }
}
