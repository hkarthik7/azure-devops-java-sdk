package org.azd.accounts;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.accounts.organization.OrganizationRequestBuilder;
import org.azd.accounts.profile.ProfileRequestBuilder;
import org.azd.authentication.AccessTokenCredential;

/**
 * Provides functionality to manage Accounts Api, and it's related entities.
 */
public class AccountsBaseRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public AccountsBaseRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Accounts Api.
     *
     * @return AccountsRequestBuilder {@link AccountsRequestBuilder}
     */
    public AccountsRequestBuilder accounts() {
        return new AccountsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage the Organization Api.
     *
     * @return OrganizationRequestBuilder {@link OrganizationRequestBuilder}
     */
    public OrganizationRequestBuilder organization() {
        return new OrganizationRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Profile Api.
     *
     * @return ProfileRequestBuilder {@link ProfileRequestBuilder}
     */
    public ProfileRequestBuilder profile() {
        return new ProfileRequestBuilder(organizationUrl, accessTokenCredential);
    }
}

