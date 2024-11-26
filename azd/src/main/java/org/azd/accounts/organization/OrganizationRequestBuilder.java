package org.azd.accounts.organization;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.accounts.types.Organizations;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.http.ClientRequest;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to manage Organizations Api.
 */
public class OrganizationRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public OrganizationRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "Contribution", "3353e165-a11e-43aa-9d88-14f2bb09b6d9", ApiVersion.ACCOUNTS);
    }

    /**
     * Get the list of future object of organization.
     *
     * @return A list of organizations {@link Organizations}.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Organizations> getAsync() throws AzDException {
        return getRequestBuilder()
                .executeAsync(Organizations.class);
    }

    /**
     * Get the list of future object of organization.
     *
     * @return A list of organizations {@link Organizations}.
     * @throws AzDException Default Api Exception handler.
     */
    public Organizations get() throws AzDException {
        return getRequestBuilder()
                .execute(Organizations.class);
    }

    /**
     * Constructs the request information for Organization Api.
     *
     * @return ClientRequest object {@link ClientRequest}.
     */
    private ClientRequest getRequestBuilder() {
        var reqBody = new HashMap<String, Object>() {{
            put("contributionIds", List.of("ms.vss-features.my-organizations-data-provider"));
            put("dataProviderContext", new HashMap<String, Object>() {{
                put("properties", "{}");
            }});
        }};

        return builder()
                .baseInstance(organizationUrl)
                .POST(reqBody)
                .build();
    }
}
