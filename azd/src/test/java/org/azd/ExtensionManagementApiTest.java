package org.azd;

import org.azd.enums.ExtensionStateFlags;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.AzDClient;
import org.azd.interfaces.ExtensionManagementDetails;
import org.azd.utils.AzDClientApi;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class ExtensionManagementApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static AzDClient webApi;
    private static ExtensionManagementDetails e;


    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        webApi = new AzDClientApi(organization, project, token);
        e = webApi.getExtensionManagementApi();
    }

    @Test
    public void shouldReturnListOfExtensions() throws AzDException {
        e.getExtensions();
    }

    @Test(expected = AzDException.class)
    public void shouldInstallExtension() throws AzDException {
        e.installExtension("publisherId", "extensionId", null);
    }

    @Test
    public void shouldUnInstallExtension() throws AzDException {
        e.uninstallExtension("publisherId", "extensionId");
    }

    @Test(expected = AzDException.class)
    public void shouldUpdateExtension() throws AzDException {
        e.updateExtension("publisherId", "extensionId", ExtensionStateFlags.NONE);
    }
}
