package org.azd.policy.policytypes;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.policy.types.PolicyType;
import org.azd.policy.types.PolicyTypes;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Policy Types Api.
 */
public class TypesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public TypesRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "policy", "44096322-2d3d-466a-bb30-d1b7de69f61f", ApiVersion.POLICY);
    }

    /**
     * Retrieve a specific policy type by ID.
     *
     * @param typeId Guid of the configuration policy type.
     * @return PolicyType object {@link PolicyType}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<PolicyType> getAsync(String typeId) throws AzDException {
        return builder()
                .serviceEndpoint("typeId", typeId)
                .build()
                .executeAsync(PolicyType.class);
    }

    /**
     * Retrieve all available policy types.
     *
     * @return PolicyTypes object {@link PolicyTypes}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<PolicyTypes> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(PolicyTypes.class);
    }

    /**
     * Retrieve a specific policy type by ID.
     *
     * @param typeId Guid of the configuration policy type.
     * @return PolicyType object {@link PolicyType}
     * @throws AzDException Default Api Exception handler.
     */
    public PolicyType get(String typeId) throws AzDException {
        return builder()
                .serviceEndpoint("typeId", typeId)
                .build()
                .execute(PolicyType.class);
    }

    /**
     * Retrieve all available policy types.
     *
     * @return PolicyTypes object {@link PolicyTypes}
     * @throws AzDException Default Api Exception handler.
     */
    public PolicyTypes list() throws AzDException {
        return builder()
                .build()
                .execute(PolicyTypes.class);
    }

}
