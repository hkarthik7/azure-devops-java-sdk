package org.azd.interfaces;

import org.azd.accounts.types.Accounts;
import org.azd.accounts.types.Organization;
import org.azd.accounts.types.Profile;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;

import java.util.List;

public interface AccountsDetails {
    Accounts getAccounts(String memberId) throws ConnectionException, AzDException;
    List<Organization> getOrganizations() throws ConnectionException, AzDException;
    Profile getProfile() throws ConnectionException, AzDException;
    Profile getProfile(String id) throws ConnectionException, AzDException;
}
