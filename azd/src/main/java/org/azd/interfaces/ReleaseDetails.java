package org.azd.interfaces;

import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;
import org.azd.release.types.Release;
import org.azd.release.types.ReleaseEnvironment;
import org.azd.release.types.Releases;

public interface ReleaseDetails {
    Release createRelease(int releaseDefinitionId, String description, String artifactAlias,
                          String artifactId, String artifactName,
                          boolean isDraft, String reason) throws DefaultParametersException, AzDException;
    Release getRelease(int releaseId) throws DefaultParametersException, AzDException;
    Release getRelease(int releaseId, SingleReleaseExpands expand) throws DefaultParametersException, AzDException;
    Release getRelease(int releaseId, SingleReleaseExpands expand,
                       ReleaseApprovalFilters approvalFilters, String[] propertyFilters,
                       int topGateRecords) throws DefaultParametersException, AzDException;
    ReleaseEnvironment getReleaseEnvironment(int releaseId, int environmentId) throws DefaultParametersException, AzDException;
    ReleaseEnvironment getReleaseEnvironment(int releaseId, int environmentId, SingleReleaseExpands expand)
            throws DefaultParametersException, AzDException;
    Releases getReleases() throws DefaultParametersException, AzDException;
    Releases getReleases(ReleaseExpands expand) throws DefaultParametersException, AzDException;
    Releases getReleases(int definitionId) throws DefaultParametersException, AzDException;
    Releases getReleases(ReleaseExpands expand, int top) throws DefaultParametersException, AzDException;
    Releases getReleases(String[] releaseIdFilter) throws DefaultParametersException, AzDException;
    Releases getReleases(ReleaseExpands expand, int top, String artifactTypeId,
                         String artifactVersionId, int continuationToken, String createdBy,
                         int definitionEnvironmentId, int definitionId, int environmentStatusFilter,
                         boolean isDeleted, String maxCreatedTime, String minCreatedTime,
                         String path, String[] propertyFilters, ReleaseQueryOrder queryOrder,
                         String[] releaseIdFilter, String searchText, String sourceBranchFilter,
                         String sourceId, ReleaseStatus statusFilter, String[] tagFilter) throws DefaultParametersException, AzDException;

}
