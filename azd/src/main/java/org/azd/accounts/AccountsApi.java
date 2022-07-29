package org.azd.accounts;

import org.azd.accounts.types.Accounts;
import org.azd.accounts.types.Organization;
import org.azd.accounts.types.Organizations;
import org.azd.accounts.types.Profile;
import org.azd.common.ApiVersion;
import org.azd.connection.Connection;
import org.azd.enums.CustomHeader;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.AccountsDetails;
import org.azd.utils.AzDAsyncApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.azd.utils.RestClient.send;

/***
 * Accounts class to manage Accounts Api
 */
public class AccountsApi extends AzDAsyncApi<AccountsApi> implements AccountsDetails {
    /***
     * Connection object
     */
    private final Connection CONNECTION;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "accounts";

    /***
     * Pass the connection object to work with Accounts Api
     *
     * @param connection Connection object
     */
    public AccountsApi(Connection connection) {
        this.CONNECTION = connection;
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
        var q = new HashMap<String, Object>() {{
            put("memberId", memberId);
        }};

        String r = send(RequestMethod.GET, CONNECTION, AREA, null, AREA, null,
                null, ApiVersion.ACCOUNTS, q, null, null);

        return MAPPER.mapJsonResponse(r, Accounts.class);
    }

    /***
     * Get the list of organizations that you have access to. Note that while creating and granting access to the personal
     * access token select all organizations to apply the access on all available organizations.
     *
     * @return A list of Organization. {@link Organizations}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public List<Organization> getOrganizations() throws AzDException {
        var ids = new ArrayList<>();
        ids.add("ms.vss-features.my-organizations-data-provider");

        var b = new HashMap<String, Object>() {{
            put("contributionIds", ids);
            put("dataProviderContext", new HashMap<String, Object>() {{
                put("properties", "{}");
            }});
        }};

        String r = send(RequestMethod.POST, CONNECTION, null, null, "Contribution", null,
                "HierarchyQuery", ApiVersion.ACCOUNTS, null, b, CustomHeader.JSON_CONTENT_TYPE);

        var res = MAPPER.mapJsonResponse(r, Organizations.class);

        return  res.getDataProviders().getOrganizationsProvider().getOrganizations();
    }

    /***
     * Gets the logged in user profile.
     *
     * @return a profile object. {@link Profile}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Profile getProfile() throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, AREA, null,
                "/profile/profiles", "me", null, ApiVersion.PROFILE, null, null, null);

        return MAPPER.mapJsonResponse(r, Profile.class);
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
        String r = send(RequestMethod.GET, CONNECTION, AREA, null,
                "/profile/profiles", id, null, ApiVersion.PROFILE, null, null, null);

        return MAPPER.mapJsonResponse(r, Profile.class);
    }
}
