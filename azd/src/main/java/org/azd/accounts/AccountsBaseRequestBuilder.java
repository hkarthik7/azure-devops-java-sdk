package org.azd.accounts;

import org.azd.accounts.organization.OrganizationRequestBuilder;
import org.azd.accounts.profile.ProfileRequestBuilder;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

/**
 * Provides functionality to manage Accounts Api, and it's related entities.
 */
public class AccountsBaseRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates the Accounts request builder with required values.
     * @param accessTokenCredential Authentication type {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public AccountsBaseRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter);
    }

    /**
     * Provides functionality to manage Accounts Api.
     * @return AccountsRequestBuilder {@link AccountsRequestBuilder}
     */
    public AccountsRequestBuilder accounts() {
        return new AccountsRequestBuilder(accessTokenCredential, requestAdapter);
    }

    /**
     * Provides functionality to manage the Organization Api.
     * @return OrganizationRequestBuilder {@link OrganizationRequestBuilder}
     */
    public OrganizationRequestBuilder organization() {
        return new OrganizationRequestBuilder(accessTokenCredential, requestAdapter);
    }

    /**
     * Provides functionality to manage Profile Api.
     * @return ProfileRequestBuilder {@link ProfileRequestBuilder}
     */
    public ProfileRequestBuilder profile() {
        return new ProfileRequestBuilder(accessTokenCredential, requestAdapter);
    }
}
