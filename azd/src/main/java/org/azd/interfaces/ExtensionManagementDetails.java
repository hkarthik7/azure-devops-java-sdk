package org.azd.interfaces;

import org.azd.enums.ExtensionStateFlags;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.extensionmanagement.types.InstalledExtension;
import org.azd.extensionmanagement.types.InstalledExtensions;

public interface ExtensionManagementDetails {
    InstalledExtension getExtension(String extensionId, String publisherId) throws ConnectionException, AzDException;
    InstalledExtension getExtension(String extensionId, String publisherId, String[] assetTypes) throws ConnectionException, AzDException;
    InstalledExtensions getExtensions() throws ConnectionException, AzDException;
    InstalledExtension installExtension(String publisherId, String extensionId, String version) throws ConnectionException, AzDException;
    void uninstallExtension(String publisherId, String extensionId) throws ConnectionException, AzDException;
    void uninstallExtension(String publisherId, String extensionId, String reason, String reasonCode) throws ConnectionException, AzDException;
    InstalledExtension updateExtension(String publisherId, String extensionId, ExtensionStateFlags extensionState)
            throws ConnectionException, AzDException;
}
