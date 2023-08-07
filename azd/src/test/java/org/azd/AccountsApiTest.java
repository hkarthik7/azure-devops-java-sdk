package org.azd;

import org.azd.accounts.AccountsBaseRequestBuilder;
import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.exceptions.AzDException;
import org.azd.serializer.JsonSerializer;
import org.azd.serviceClient.AzDServiceClient;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class AccountsApiTest {
    private static final JsonSerializer serializer = new JsonSerializer();
    private static AccountsBaseRequestBuilder a;
    private static AzDServiceClient client;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = serializer.deserialize(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        client = new AzDServiceClient(new PersonalAccessTokenCredential(organization, project, token));
        a = client.accounts();
    }

    @Test
    public void shouldGetAccounts() throws AzDException {
        a.profile().get()
                .thenAcceptAsync(p -> {
                    try {
                        a.accounts().list(p.getId()).join();
                    } catch (AzDException e) {
                        throw new RuntimeException(e);
                    }
                }).join();
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
        a.profile().get()
                .thenAcceptAsync(p -> {
                    try {
                        a.profile().getById(p.getId());
                    } catch (AzDException e) {
                        throw new RuntimeException(e);
                    }
                }).join();
    }

    @Test
    public void shouldTest() throws AzDException {
        var acc = client.build().builds().workItems().get(2112).join();
        System.out.println(acc);
    }
}
