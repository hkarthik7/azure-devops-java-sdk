package org.azd.unittests;

import org.azd.MockParameters;
import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.enums.Instance;
import org.azd.exceptions.AzDException;
import org.azd.serviceclient.AzDService;
import org.azd.serviceclient.AzDServiceClient;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Objects;

public class AccountsRequestBuilderTest {
    private static final SerializerContext serializer = InstanceFactory.createSerializerContext();
    private static AzDServiceClient client;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        var file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        var m = serializer.deserialize(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        var pat = new PersonalAccessTokenCredential(Instance.BASE_INSTANCE.append(organization), project, token);
        client = AzDService.builder()
                .authentication(pat)
                .buildClient();
    }

    @Test
    public void shouldGetAccounts() throws AzDException {
        var id = client.accounts().profile().get().getId();
        assert client.accounts().list(id).getAccounts().get(0).getAccountId() != null;
    }

    @Test
    public void shouldGetAllAccessibleOrganizations() throws AzDException {
        assert client.accounts().organization().get() != null;
    }

    @Test
    public void shouldGetAUserProfile() throws AzDException {
        assert client.accounts().profile().get() != null;
    }

    @Test
    public void shouldGetAUserProfileWithId() throws AzDException {
        var id = client.accounts().profile().get().getId();
        assert Objects.equals(client.accounts().profile().get(id).getId(), id);
    }
}
