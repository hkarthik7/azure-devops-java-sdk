package org.azd.interfaces;

import org.azd.enums.PackagePromote;
import org.azd.enums.PackagesBatchOperation;
import org.azd.exceptions.AzDException;
import org.azd.upack.types.Package;
import org.azd.upack.types.UPackPackageVersionDeletionState;

import java.util.List;
import java.util.Map;

public interface UpackDetails {
    Package getPackageVersion(String feedId, String packageName, String version) throws AzDException;

    Package getPackageVersion(String feedId, String packageName, String version, boolean showDeleted)
            throws AzDException;

    UPackPackageVersionDeletionState getPackageVersionFromRecycleBin(String feedId, String packageName,
                                                                     String version) throws AzDException;

    // String downloadPackage(String feedId, String packageName,
    // String version, String fileName)
    // throws AzDException;

    void updatePackageVersion(String feedId, String packageName, String version, PackagePromote promote)
            throws AzDException;

    void updatePackageVersion(String feedId, String packageName, String version, String promote)
            throws AzDException;

    void updatePackageVersions(String feedId, String viewId, PackagesBatchOperation operation,
                               List<Map<String, Object>> packages) throws AzDException;

    void updateRecycleBinPackages(String feedId, PackagesBatchOperation operation,
                                  List<Map<String, Object>> packages) throws AzDException;

    void deletePackageVersion(String feedId, String packageName, String version) throws AzDException;

    void deletePackageVersionFromRecycleBin(String feedId, String packageName, String version) throws AzDException;

    void restorePackageVersionFromRecycleBin(String feedId, String packageName, String version) throws AzDException;
}
