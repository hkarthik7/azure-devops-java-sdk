package org.azd;

import org.azd.exceptions.AzDException;
import org.azd.interfaces.AccountsDetails;
import org.azd.interfaces.AzDClient;
import org.azd.interfaces.SerializerContext;
import org.azd.utils.AzDClientApi;
import org.azd.utils.InstanceFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class AccountsApiTest {
    private static final SerializerContext serializer = InstanceFactory.createSerializerContext();
    private static AccountsDetails a;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = serializer.deserialize(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        AzDClient webApi = new AzDClientApi(organization, project, token);
        a = webApi.getAccountsApi();
    }

    @Test
    public void shouldGetAccounts() throws AzDException {
        var id = a.getProfile().getId();
        a.getAccounts(id);
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
