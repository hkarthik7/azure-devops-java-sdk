package org.azd.accounts;

import org.azd.accounts.types.Accounts;
import org.azd.accounts.types.Organization;
import org.azd.accounts.types.Organizations;
import org.azd.connection.Connection;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.AccountsDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.azd.utils.Client.send;

/***
 * Accounts class to manage Accounts Api
 */
public class AccountsApi implements AccountsDetails {
    /***
     * Connection object
     */
    private final Connection CONNECTION;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "accounts";
    private final String ACCOUNTS = "0d55247a-1c47-4462-9b1f-5e2125590ee6";

    /***
     * Pass the connection object to work with Build Api
     * @param connection Connection object
     */
    public AccountsApi(Connection connection) { this.CONNECTION = connection; }

    /***
     * Get a list of accounts for a specific member.
     * @param memberId Specify the member Id. This can be obtained by running getUserEntitlements() from MemberEntitlementManagementApi.
     * @return Accounts object {@link Accounts}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Accounts getAccounts(String memberId) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("memberId", memberId);
        }};

        String r = send(RequestMethod.GET, CONNECTION, AREA, null,
                AREA, null, null, AccountsVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, Accounts.class);
    }

    /***
     * Get the list of organizations that you have access to. Note that while creating and granting access to the personal
     * access token select all organizations to apply the access on all organizations.
     * @return A list of Organization. {@link Organizations}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public List<Organization> getOrganizations() throws ConnectionException, AzDException {
        var ids = new ArrayList<>();
        ids.add("ms.vss-features.my-organizations-data-provider");

        var b = new HashMap<String, Object>(){{
            put("contributionIds", ids);
            put("dataProviderContext", new HashMap<String, Object>(){{ put("properties", "{}"); }});
        }};

        String r = send(RequestMethod.POST, CONNECTION, null, null,
                "Contribution", null, "HierarchyQuery", AccountsVersion.VERSION, null, b);

        var res = MAPPER.mapJsonResponse(r, Organizations.class);

        return res.getDataProviders().getOrganizationsProvider().getOrganizations();
    }
}