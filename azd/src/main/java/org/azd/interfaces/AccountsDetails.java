package org.azd.interfaces;

import org.azd.accounts.types.Accounts;
import org.azd.accounts.types.Organizations;
import org.azd.accounts.types.Profile;
import org.azd.exceptions.AzDException;

public interface AccountsDetails {
    Accounts getAccounts(String memberId) throws AzDException;

    Organizations getOrganizations() throws AzDException;

    Profile getProfile() throws AzDException;

    Profile getProfile(String id) throws AzDException;
}
