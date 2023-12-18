package org.azd.extensionmanagement;

import org.azd.enums.ExtensionStateFlags;
import org.azd.exceptions.AzDException;
import org.azd.extensionmanagement.types.*;
import org.azd.interfaces.ExtensionManagementDetails;
import org.azd.serviceclient.AzDServiceClient;
import org.azd.utils.AzDAsyncApi;

/***
 * ExtensionManagementApi class to manage installed extensions API
 */
public class ExtensionManagementApi extends AzDAsyncApi<ExtensionManagementApi> implements ExtensionManagementDetails {
    /**
     * Extension management request builder object to manage Extension Management API.
     */
    private final ExtensionManagementRequestBuilder BUILDER;

    /**
     * Requires the instance of AzDServiceClient.
     * @param client Pass the instance of {@link AzDServiceClient}
     */
    public ExtensionManagementApi(AzDServiceClient client) {
        BUILDER = client.extensionManagement();
    }

    /***
     * Get an installed extension by its publisher and extension id.
     * @param extensionId Id of the extension. Example: "sonarqube".
     * @param publisherId Id of the publisher. Example: "sonarsource".
     * @return InstalledExtension {@link InstalledExtension}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public InstalledExtension getExtension(String extensionId, String publisherId) throws AzDException {
        return BUILDER.get(extensionId, publisherId);
    }

    /***
     * Get an installed extension by its publisher and extension id.
     * @param extensionId Id of the extension. Example: "sonarqube".
     * @param publisherId Id of the publisher. Example: "sonarsource".
     * @param assetTypes type of asset
     * @return InstalledExtension {@link InstalledExtension}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public InstalledExtension getExtension(String extensionId, String publisherId, String[] assetTypes)
            throws AzDException {
        return BUILDER.get(extensionId, publisherId, assetTypes);
    }

    /***
     * List the installed extensions
     * @return InstalledExtensions {@link InstalledExtensions}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public InstalledExtensions getExtensions() throws AzDException {
        return BUILDER.list();
    }

    /***
     * Install the specified extension
     * @param extensionId Id of the extension. Example: "sonarqube".
     * @param publisherId Id of the publisher. Example: "sonarsource".
     * @param version if null latest version will be selected
     * @return InstalledExtension {@link InstalledExtension}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public InstalledExtension installExtension(String publisherId, String extensionId, String version)
            throws AzDException {
        var installExtensionRequest = new InstallExtensionRequest();
        installExtensionRequest.extensionId = extensionId;
        installExtensionRequest.publisherId = publisherId;
        installExtensionRequest.version = version;

        return BUILDER.install(installExtensionRequest);
    }

    /***
     * Uninstall the specified extension
     * @param extensionId Id of the extension. Example: "sonarqube".
     * @param publisherId Id of the publisher. Example: "sonarsource".
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void uninstallExtension(String publisherId, String extensionId) throws AzDException {
        var unInstallExtensionRequest = new UnInstallExtensionRequest();
        unInstallExtensionRequest.extensionId = extensionId;
        unInstallExtensionRequest.publisherId = publisherId;

        return BUILDER.uninstall(unInstallExtensionRequest);
    }

    /***
     * Uninstall the specified extension
     * @param extensionId Id of the extension. Example: "sonarqube".
     * @param publisherId Id of the publisher. Example: "sonarsource".
     * @param reason reason for uninstall
     * @param reasonCode reason code for uninstall
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void uninstallExtension(String publisherId, String extensionId, String reason, String reasonCode)
            throws AzDException {
        var unInstallExtensionRequest = new UnInstallExtensionRequest();
        unInstallExtensionRequest.extensionId = extensionId;
        unInstallExtensionRequest.publisherId = publisherId;
        unInstallExtensionRequest.reason = reason;
        unInstallExtensionRequest.reasonCode = reasonCode;

        return BUILDER.uninstall(unInstallExtensionRequest);
    }

    /***
     * Enable/disable an extension
     * @param extensionId Id of the extension. Example: "sonarqube".
     * @param publisherId Id of the publisher. Example: "sonarsource".
     * @param extensionState If none extension will be enabled. {@link ExtensionStateFlags}
     * @return InstalledExtension {@link InstalledExtension}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public InstalledExtension updateExtension(String publisherId, String extensionId, ExtensionStateFlags extensionState)
            throws AzDException {
        var updateExtensionRequest = new UpdateExtensionRequest();
        updateExtensionRequest.extensionId = extensionId;
        updateExtensionRequest.publisherId = publisherId;
        updateExtensionRequest.extensionState = extensionState;

        return BUILDER.update(updateExtensionRequest);
    }
}
