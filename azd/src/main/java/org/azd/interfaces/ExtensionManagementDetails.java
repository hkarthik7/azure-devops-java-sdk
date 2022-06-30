package org.azd.interfaces;

import org.azd.enums.ExtensionStateFlags;
import org.azd.exceptions.AzDException;
import org.azd.extensionmanagement.types.InstalledExtension;
import org.azd.extensionmanagement.types.InstalledExtensions;

public interface ExtensionManagementDetails {
    InstalledExtension getExtension(String extensionId, String publisherId) throws AzDException;

    InstalledExtension getExtension(String extensionId, String publisherId, String[] assetTypes) throws AzDException;

    InstalledExtensions getExtensions() throws AzDException;

    InstalledExtension installExtension(String publisherId, String extensionId, String version) throws AzDException;

    Void uninstallExtension(String publisherId, String extensionId) throws AzDException;

    Void uninstallExtension(String publisherId, String extensionId, String reason, String reasonCode) throws AzDException;

    InstalledExtension updateExtension(String publisherId, String extensionId, ExtensionStateFlags extensionState)
            throws AzDException;
}
