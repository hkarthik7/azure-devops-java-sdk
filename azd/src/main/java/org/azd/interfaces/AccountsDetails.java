package org.azd.interfaces;

import org.azd.accounts.types.Accounts;
import org.azd.accounts.types.Organization;
import org.azd.accounts.types.Profile;
import org.azd.exceptions.AzDException;

import java.util.List;

public interface AccountsDetails {
    Accounts getAccounts(String memberId) throws AzDException;

    List<Organization> getOrganizations() throws AzDException;

    Profile getProfile() throws AzDException;

    Profile getProfile(String id) throws AzDException;
}
