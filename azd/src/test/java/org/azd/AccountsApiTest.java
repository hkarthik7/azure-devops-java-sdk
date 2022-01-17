package org.azd;

import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.AccountsDetails;
import org.azd.interfaces.AzDClient;
import org.azd.interfaces.MemberEntitlementManagementDetails;
import org.azd.utils.AzDClientApi;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class AccountsApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static MemberEntitlementManagementDetails mem;
    private static AccountsDetails a;
    private static AzDClient webApi;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        webApi = new AzDClientApi(organization, project, token);
        mem = webApi.getMemberEntitlementManagementApi();
        a = webApi.getAccountsApi();
    }

    @Test
    public void shouldGetAccounts() throws AzDException {
        var uId = mem
                .getUserEntitlements()
                .getMembers()
                .stream()
                .filter(x -> x.getUser().getDisplayName().contains("Ha"))
                .findFirst()
                .get()
                .getId();

        a.getAccounts(uId);
    }

    @Test
    public void shouldGetAllAccessibleOrganizations() throws AzDException {
        a.getOrganizations();
    }

    @Test
    public void shouldGetAUserProfile() throws AzDException {
        a.getProfile();
    }

    @Test
    public void shouldGetAUserProfileWithId() throws AzDException {
        a.getProfile(a.getProfile().getId());
    }
}
