package org.azd.interfaces;

import org.azd.exceptions.AzDException;
import org.azd.maven.types.JsonPatchOperation;
import org.azd.maven.types.MavenPackageVersionDeletionState;
import org.azd.maven.types.Package;
import org.azd.maven.types.UpstreamingBehavior;

public interface MavenDetails {
        Package getPackageVersion(String feedId, String groupId, String artifactId, String version) throws AzDException;

        Package getPackageVersion(String feedId, String groupId, String artifactId, String version, boolean showDeleted)
                        throws AzDException;

        MavenPackageVersionDeletionState getPackageVersionFromRecycleBin(String feedId, String groupId,
                        String artifactId,
                        String version) throws AzDException;

        UpstreamingBehavior getUpstreamingBehavior(String feedId, String groupId, String artifactId)
                        throws AzDException;

        // String downloadPackage(String feedId, String groupId, String artifactId,
        //                 String version, String fileName)
        //                 throws AzDException;

        void updatePackageVersion(String feedId, String groupId, String artifactId, String version,
                        String promote) throws AzDException;

        // void updatePackageVersions(String feedId) throws AzDException;

        // void updateRecycleBinPackages(String feedId) throws AzDException;

        void deletePackageVersion(String feedId, String groupId, String artifactId,
        String version) throws AzDException;

        void deletePackageVersionFromRecycleBin(String feedId, String groupId, String
        artifactId, String version)
        throws AzDException;

        // void restorePackageVersionFromRecycleBin(String feedId, String groupId,
        // String artifactId, String version)
        // throws AzDException;

        // void setUpstreamingBehavior(String feedId, String groupId, String artifactId)
        // throws AzDException;
}
