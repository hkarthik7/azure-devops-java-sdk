package org.azd;

import org.azd.enums.AccountLicenseType;
import org.azd.enums.GroupType;
import org.azd.enums.LicensingSource;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.AzDClient;
import org.azd.interfaces.CoreDetails;
import org.azd.interfaces.MemberEntitlementManagementDetails;
import org.azd.utils.AzDClientApi;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class MemberEntitlementManagementApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static AzDClient webApi;
    private static MemberEntitlementManagementDetails mem;
    private static CoreDetails c;

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
        c = webApi.getCoreApi();
    }

    @Test
    public void shouldGetGroupEntitlements() throws AzDException {
        mem.getGroupEntitlements();
    }

    @Test(expected = AzDException.class)
    public void shouldGetGroupEntitlement() throws AzDException {
        mem.getGroupEntitlement("0000-000000-0000-0000-0000");
    }

    @Test
    public void shouldGetUsersEntitlementSummary() throws AzDException {
        mem.getUserEntitlementSummary();
    }

    @Test
    public void shouldAddUserEntitlement() throws AzDException {
        var p = c.getProject("azure-devops-java-sdk");
        mem.addUserEntitlement(AccountLicenseType.EXPRESS,
                "test@xmail.com", GroupType.PROJECTCONTRIBUTOR, p.getId());
    }

    @Test
    public void shouldGetUsersEntitlements() throws AzDException {
        mem.getUserEntitlements();
    }

    @Test
    public void shouldUpdateUsersEntitlement() throws AzDException {
        var userId = mem.getUserEntitlements().getMembers().stream()
                .filter(x -> x.getUser().getDisplayName().equals("test@xmail.com"))
                .findFirst().get().getId();

        mem.updateUserEntitlement(userId, AccountLicenseType.STAKEHOLDER, LicensingSource.ACCOUNT);
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteUsersEntitlement() throws AzDException {
//        var userId = mem.getUserEntitlements().getMembers().stream()
//                .filter(x -> x.getUser().getDisplayName().equals("test@xmail.com"))
//                .findFirst().get().getId();
        // Muting it as it is clashing with other tests
        mem.deleteUserEntitlement("0000-00000-00000-000000-000000");
    }

}
