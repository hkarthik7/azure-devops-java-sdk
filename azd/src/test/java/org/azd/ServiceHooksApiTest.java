package org.azd;

import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;
import org.azd.feedmanagement.FeedManagementApi;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.ServiceHooks;
import org.azd.servicehooks.ServiceHooksApi;
import org.azd.utils.AzDDefaultParameters;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class ServiceHooksApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static ServiceHooks s;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        AzDDefaultParameters defaultParameters = new AzDDefaultParameters(organization, project, token);
        s = new ServiceHooksApi(defaultParameters);
    }

    @Test(expected = AzDException.class)
    public void shouldGetASubscription() throws DefaultParametersException, AzDException {
        s.getSubscription("0000-00000-00000-00000");
    }

    @Test
    public void shouldGetSubscriptions() throws DefaultParametersException, AzDException {
        s.getSubscriptions();
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteASubscription() throws DefaultParametersException, AzDException {
        s.deleteSubscription("0000-00000-00000-00000");
    }
}
