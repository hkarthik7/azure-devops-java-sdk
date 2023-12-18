package org.azd.accounts;

import org.azd.accounts.types.Accounts;
import org.azd.accounts.types.Organizations;
import org.azd.accounts.types.Profile;
import org.azd.exceptions.AzDException;
import org.azd.interfaces.AccountsDetails;
import org.azd.serviceclient.AzDServiceClient;
import org.azd.utils.AzDAsyncApi;

/***
 * Accounts class to manage Accounts Api
 */
public class AccountsApi extends AzDAsyncApi<AccountsApi> implements AccountsDetails {
    private final AccountsBaseRequestBuilder ACCOUNTS;

    /**
     * Requires the instance of AzDServiceClient.
     * @param client Pass the instance of {@link AzDServiceClient}
     */
    public AccountsApi(AzDServiceClient client) {
        ACCOUNTS = client.accounts();
    }

    /***
     * Get a list of accounts for a specific member.
     *
     * @param memberId Specify the member Id. This can be obtained by running getUserEntitlements() from MemberEntitlementManagementApi.
     * @return Accounts object {@link Accounts}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Accounts getAccounts(String memberId) throws AzDException {
        return ACCOUNTS.accounts().list(memberId);
    }

    /***
     * Get the list of organizations that you have access to. Note that while creating and granting access to the personal
     * access token select all organizations to apply the access on all available organizations.
     *
     * @return A list of Organization. {@link Organizations}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Organizations getOrganizations() throws AzDException {
        return ACCOUNTS.organization().get();
    }

    /***
     * Gets the logged in user profile.
     *
     * @return a profile object. {@link Profile}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Profile getProfile() throws AzDException {
        return ACCOUNTS.profile().get();
    }

    /***
     * Gets a user profile.
     *
     * @param id pass the user id
     * @return a profile object. {@link Profile}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Profile getProfile(String id) throws AzDException {
        return ACCOUNTS.profile().get(id);
    }
}
