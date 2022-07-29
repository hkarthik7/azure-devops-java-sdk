package org.azd.extensionmanagement;

import org.azd.common.ApiVersion;
import org.azd.connection.Connection;
import org.azd.enums.CustomHeader;
import org.azd.enums.ExtensionStateFlags;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.extensionmanagement.types.InstalledExtension;
import org.azd.extensionmanagement.types.InstalledExtensions;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.ExtensionManagementDetails;
import org.azd.utils.AzDAsyncApi;

import java.util.HashMap;
import java.util.Map;

import static org.azd.utils.RestClient.send;

/***
 * ExtensionManagementApi class to manage installed extensions API
 */
public class ExtensionManagementApi extends AzDAsyncApi<ExtensionManagementApi> implements ExtensionManagementDetails {
    /***
     * Connection object
     */
    private final Connection CONNECTION;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "extensionmanagement";
    private final String EXTENSIONMANAGEMENT = "6c2b0933-3600-42ae-bf8b-93d4f7e83594";

    /***
     * Pass the connection object to work with Member Entitlement Management Api
     * @param connection Connection object
     */
    public ExtensionManagementApi(Connection connection) {
        this.CONNECTION = connection;
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
        String r = send(RequestMethod.GET, CONNECTION, EXTENSIONMANAGEMENT, null,
                AREA + "/installedextensions", extensionId + "/" + publisherId, null,
                ApiVersion.EXTENSION_MANAGEMENT, null, null, null);

        return MAPPER.mapJsonResponse(r, InstalledExtension.class);
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
        var q = new HashMap<String, Object>() {{
            put("assetTypes", String.join(",", assetTypes));
        }};
        String r = send(RequestMethod.GET, CONNECTION, EXTENSIONMANAGEMENT, null,
                AREA + "/installedextensions", extensionId + "/" + publisherId, null,
                ApiVersion.EXTENSION_MANAGEMENT, q, null, null);

        return MAPPER.mapJsonResponse(r, InstalledExtension.class);
    }

    /***
     * List the installed extensions
     * @return InstalledExtensions {@link InstalledExtensions}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public InstalledExtensions getExtensions() throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, EXTENSIONMANAGEMENT, null,
                AREA + "/installedextensions", null, null, ApiVersion.EXTENSION_MANAGEMENT,
                null, null, null);

        return MAPPER.mapJsonResponse(r, InstalledExtensions.class);
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
        String id = publisherId + "/" + extensionId;

        if (version != null) {
            id += "/" + version;
        }

        String r = send(RequestMethod.POST, CONNECTION, EXTENSIONMANAGEMENT, null,
                AREA + "/installedextensionsbyname", id, null, ApiVersion.EXTENSION_MANAGEMENT,
                null, null, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, InstalledExtension.class);
    }

    /***
     * Uninstall the specified extension
     * @param extensionId Id of the extension. Example: "sonarqube".
     * @param publisherId Id of the publisher. Example: "sonarsource".
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void uninstallExtension(String publisherId, String extensionId) throws AzDException {
        try {
            String id = publisherId + "/" + extensionId;

            String r = send(RequestMethod.DELETE, CONNECTION, EXTENSIONMANAGEMENT, null,
                    AREA + "/installedextensionsbyname", id, null, ApiVersion.EXTENSION_MANAGEMENT,
                    null, null, null);

            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);

        } catch (AzDException e) {
            throw e;
        }
        return null;
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
        try {
            String id = publisherId + "/" + extensionId;
            var q = new HashMap<String, Object>() {{
                put("reason", reason);
                put("reasonCode", reasonCode);
            }};

            String r = send(RequestMethod.DELETE, CONNECTION, EXTENSIONMANAGEMENT, null,
                    AREA + "/installedextensionsbyname", id, null, ApiVersion.EXTENSION_MANAGEMENT,
                    q, null, null);

            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);

        } catch (AzDException e) {
            throw e;
        }
        return null;
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
        var body = new HashMap<String, Object>() {{
            put("publisherId", publisherId);
            put("extensionId", extensionId);
            put("installState", new HashMap<String, Object>() {{
                put("flags", extensionState.toString().toLowerCase());
            }});
        }};

        String r = send(RequestMethod.PATCH, CONNECTION, EXTENSIONMANAGEMENT, null,
                AREA + "/installedextensions", null, null, ApiVersion.EXTENSION_MANAGEMENT,
                null, body, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, InstalledExtension.class);
    }
}
