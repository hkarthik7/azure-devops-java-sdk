package org.azd;

import org.azd.accounts.AccountsBaseRequestBuilder;
import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.AzDClient;
import org.azd.interfaces.MemberEntitlementManagementDetails;
import org.azd.serviceClient.AzDServiceClient;
import org.azd.utils.AzDClientApi;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class AccountsApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static MemberEntitlementManagementDetails mem;
    private static AccountsBaseRequestBuilder a;
    private static AzDClient webApi;
    private static AzDServiceClient client;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        webApi = new AzDClientApi(organization, project, token);
        client = new AzDServiceClient(new PersonalAccessTokenCredential(organization, project, token));
        mem = webApi.getMemberEntitlementManagementApi();
        a = client.accounts();
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

        a.accounts().list(uId).join();
    }

    @Test
    public void shouldGetAllAccessibleOrganizations() throws AzDException {
        a.organization().get().join();
    }

    @Test
    public void shouldGetAUserProfile() throws AzDException {
        a.profile().get().join();
    }

    @Test
    public void shouldGetAUserProfileWithId() throws AzDException {
        var id = a.profile().get().join().getId();
        a.profile().getById(id).join();
    }

    @Test
    public void shouldTest() throws AzDException {
        var pat = new PersonalAccessTokenCredential("harishkarthic", "azure-devops-java-sdk",
                "dxay3seppthjy4srmricowjgqtx5vaeszmlturibu2ooco4g3twa");

        var client = new AzDServiceClient(pat);
//        var acc = client.build().builds().logs().get(2112, 1, r -> {
//            r.queryParameters.startLine = 1;
//            r.queryParameters.endLine = 5;
//        });

        var acc = client.build().builds().workItems().get(2112).join();
        System.out.println(acc);
    }
}
