package org.azd.accounts.organization;

import org.azd.accounts.types.Organizations;
import org.azd.common.ApiVersion;
import org.azd.enums.CustomHeader;
import org.azd.enums.Instance;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.http.RequestInformation;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to manage Organizations Api.
 */
public class OrganizationRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new OrganizationRequestBuilder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public OrganizationRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "Contribution/HierarchyQuery", ApiVersion.ACCOUNTS);
    }

    /**
     * Get the list of future object of organization.
     * @return A list of organizations {@link Organizations}.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Organizations> get() throws AzDException {
        return requestAdapter.sendAsync(toPostRequestInfo(), Organizations.class);
    }

    /**
     * Constructs the request information for Organization Api.
     * @return RequestInformation object {@link RequestInformation}.
     */
    private RequestInformation toPostRequestInfo() {
        var reqBody = new HashMap<String, Object>() {{
            put("contributionIds", List.of("ms.vss-features.my-organizations-data-provider"));
            put("dataProviderContext", new HashMap<String, Object>() {{
                put("properties", "{}");
            }});
        }};

        var requestInfo = toPostRequestInformation(reqBody);
        requestInfo.setRequestUrl(MessageFormat.format("{0}/_apis/{1}?api-version={2}",
                Instance.ACCOUNT_INSTANCE.getInstance(), service, apiVersion));

        return requestInfo;
    }
}
