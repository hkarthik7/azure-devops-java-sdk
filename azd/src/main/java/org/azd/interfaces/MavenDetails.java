package org.azd.interfaces;

import org.azd.enums.PackagePromote;
import org.azd.enums.PackagesBatchOperation;
import org.azd.exceptions.AzDException;
import org.azd.maven.types.MavenPackageVersionDeletionState;
import org.azd.maven.types.Package;
import org.azd.maven.types.UpstreamingBehavior;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface MavenDetails {
    Package getPackageVersion(String feedId, String groupId, String artifactId, String version) throws AzDException;

    Package getPackageVersion(String feedId, String groupId, String artifactId, String version, boolean showDeleted)
            throws AzDException;

    MavenPackageVersionDeletionState getPackageVersionFromRecycleBin(String feedId, String groupId,
                                                                     String artifactId,
                                                                     String version) throws AzDException;

    UpstreamingBehavior getUpstreamingBehavior(String feedId, String groupId, String artifactId)
            throws AzDException;

    InputStream downloadPackage(String feedId, String groupId, String artifactId, String version, String fileName) throws AzDException;

    void updatePackageVersion(String feedId, String groupId, String artifactId, String version,
                              PackagePromote promote) throws AzDException;

    void updatePackageVersion(String feedId, String groupId, String artifactId, String version,
                              String promote) throws AzDException;

    void updatePackageVersions(String feedId, String viewId, PackagesBatchOperation operation, List<Map<String, Object>> packages)
            throws AzDException;

    void updateRecycleBinPackages(String feedId, PackagesBatchOperation operation, List<Map<String, Object>> packages)
            throws AzDException;

    void deletePackageVersion(String feedId, String groupId, String artifactId,
                              String version) throws AzDException;

    void deletePackageVersionFromRecycleBin(String feedId, String groupId, String artifactId, String version)
            throws AzDException;

    void restorePackageVersionFromRecycleBin(String feedId, String groupId,
                                             String artifactId, String version)
            throws AzDException;

    void setUpstreamingBehavior(String feedId, String groupId, String artifactId)
            throws AzDException;

    void setUpstreamingBehavior(String feedId, String groupId, String artifactId, String upstreamingBehavior)
            throws AzDException;

    void clearUpstreamingBehavior(String feedId, String groupId, String artifactId) throws AzDException;

    void uploadPackage(String feedId, String groupId, String artifactId, String version, String fileName, InputStream content) throws AzDException;

}
