package org.azd.accounts;

import org.azd.accounts.types.Accounts;
import org.azd.common.ApiVersion;
import org.azd.enums.Instance;
import org.azd.exceptions.AzDException;
import org.azd.http.RequestInformation;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to manage Accounts Api.
 */
public class AccountsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new AccountsRequestBuilder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public AccountsRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "accounts", ApiVersion.ACCOUNTS);
    }

    /**
     * Get a list of accounts for a specific member. MemberId parameter is required.
     * @param memberId ID for a member of the accounts.
     * @return Accounts future object {@link Accounts}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Accounts> list(String memberId) throws AzDException {
        Objects.requireNonNull(memberId, "Member Id cannot be null or empty.");
        var requestInfo = toGetRequestInfo(memberId);
        return  requestAdapter.sendAsync(requestInfo, org.azd.accounts.types.Accounts.class);
    }

    /**
     * Constructs the request information for Accounts Api.
     * @param memberId ID of the member.
     * @return RequestInformation object {@link RequestInformation}.
     */
    private RequestInformation toGetRequestInfo(String memberId) {
        var requestInfo = new RequestInformation();
        requestInfo.setRequestUrl(MessageFormat.format("{0}/_apis/{1}?api-version={2}&memberId={3}",
                Instance.ACCOUNT_INSTANCE.getInstance(), service, apiVersion, memberId));
        return requestInfo;
    }
}
