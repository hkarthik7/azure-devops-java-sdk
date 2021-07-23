package org.azd;

import org.azd.accounts.AccountsApi;
import org.azd.connection.Connection;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.MemberEntitlementManagementDetails;
import org.azd.memberentitlementmanagement.MemberEntitlementManagementApi;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class AccountsApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static MemberEntitlementManagementDetails mem;
    private static AccountsApi a;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        Connection connection = new Connection(organization, project, token);
        mem = new MemberEntitlementManagementApi(connection);
        a = new AccountsApi(connection);
    }

    @Test
    public void shouldGetAccounts() throws ConnectionException, AzDException {
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
    public void shouldGetAllAccessibleOrganizations() throws ConnectionException, AzDException {
        a.getOrganizations();
    }
}
