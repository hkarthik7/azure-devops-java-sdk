package org.azd.unittests;

import org.azd.UnitTestConfiguration;
import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.enums.ExtensionStateFlags;
import org.azd.enums.Instance;
import org.azd.exceptions.AzDException;
import org.azd.extensionmanagement.types.InstallExtensionRequest;
import org.azd.extensionmanagement.types.UnInstallExtensionRequest;
import org.azd.extensionmanagement.types.UpdateExtensionRequest;
import org.azd.legacy.MockParameters;
import org.azd.serviceclient.AzDService;
import org.azd.serviceclient.AzDServiceClient;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class ExtensionManagementRequestBuilderTest {
    private static final SerializerContext serializer = InstanceFactory.createSerializerContext();
    private static AzDServiceClient client;
    private static UnitTestConfiguration testConfiguration;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        var file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        var configFile = new File(dir + "/src/test/java/org/azd/config.json");
        var m = serializer.deserialize(file, MockParameters.class);
        testConfiguration = serializer.deserialize(configFile, UnitTestConfiguration.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        var pat = new PersonalAccessTokenCredential(Instance.BASE_INSTANCE.append(organization), project, token);
        client = AzDService.builder()
                .authentication(pat)
                .buildClient();
    }

    @Test
    public void shouldReturnListOfExtensions() throws AzDException {
        client.extensionManagement().list();
    }

    @Test(expected = AzDException.class)
    public void shouldInstallExtension() throws AzDException {
        var installExtensionRequest = new InstallExtensionRequest();
        installExtensionRequest.publisherId = "publisherId";
        installExtensionRequest.extensionId = "extensionId";
        installExtensionRequest.version = null;

        client.extensionManagement().install(installExtensionRequest);
    }

    @Test
    public void shouldUnInstallExtension() throws AzDException {
        var uninstallExtensionRequest = new UnInstallExtensionRequest();
        uninstallExtensionRequest.publisherId = "publisherId";
        uninstallExtensionRequest.extensionId = "extensionId";
        uninstallExtensionRequest.reason = "";
        uninstallExtensionRequest.reasonCode = "";

        client.extensionManagement().uninstall(uninstallExtensionRequest);
    }

    @Test(expected = AzDException.class)
    public void shouldUpdateExtension() throws AzDException {
        var updateExtensionRequest = new UpdateExtensionRequest();
        updateExtensionRequest.publisherId = "publisherId";
        updateExtensionRequest.extensionState = ExtensionStateFlags.NONE;
        updateExtensionRequest.extensionId = "extensionId";

        client.extensionManagement().update(updateExtensionRequest);
    }
}
