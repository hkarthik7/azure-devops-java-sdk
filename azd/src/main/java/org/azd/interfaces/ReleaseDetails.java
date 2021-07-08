package org.azd.interfaces;

import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.release.types.*;

public interface ReleaseDetails {
    Release createRelease(int releaseDefinitionId, String description, String artifactAlias,
                          String artifactId, String artifactName,
                          boolean isDraft) throws ConnectionException, AzDException;
    Release getRelease(int releaseId) throws ConnectionException, AzDException;
    Release getRelease(int releaseId, SingleReleaseExpands expand) throws ConnectionException, AzDException;
    Release getRelease(int releaseId, SingleReleaseExpands expand,
                       ReleaseApprovalFilters approvalFilters, String[] propertyFilters,
                       int topGateRecords) throws ConnectionException, AzDException;
    ReleaseEnvironment getReleaseEnvironment(int releaseId, int environmentId) throws ConnectionException, AzDException;
    ReleaseEnvironment getReleaseEnvironment(int releaseId, int environmentId, SingleReleaseExpands expand)
            throws ConnectionException, AzDException;
    Releases getReleases() throws ConnectionException, AzDException;
    Releases getReleases(ReleaseExpands expand) throws ConnectionException, AzDException;
    Releases getReleases(int definitionId) throws ConnectionException, AzDException;
    Releases getReleases(ReleaseExpands expand, int top) throws ConnectionException, AzDException;
    Releases getReleases(String[] releaseIdFilter) throws ConnectionException, AzDException;
    Releases getReleases(ReleaseExpands expand, String artifactVersionId) throws ConnectionException, AzDException;
    Releases getReleases(ReleaseExpands expand, int top, String artifactTypeId,
                         String artifactVersionId, int continuationToken, String createdBy,
                         int definitionEnvironmentId, int definitionId, int environmentStatusFilter,
                         boolean isDeleted, String maxCreatedTime, String minCreatedTime,
                         String path, String[] propertyFilters, ReleaseQueryOrder queryOrder,
                         String[] releaseIdFilter, String searchText, String sourceBranchFilter,
                         String sourceId, ReleaseStatus statusFilter, String[] tagFilter) throws ConnectionException, AzDException;
    ReleaseDefinition createReleaseDefinition(String releaseDefinitionParameters) throws ConnectionException, AzDException;
    void deleteReleaseDefinition(int definitionId) throws ConnectionException, AzDException;
    void deleteReleaseDefinition(int definitionId, String comment, boolean forceDelete) throws ConnectionException, AzDException;
    ReleaseDefinition getReleaseDefinition(int definitionId) throws ConnectionException, AzDException;
    ReleaseDefinitionRevisions getReleaseDefinitionHistory(int definitionId) throws ConnectionException, AzDException;
    ReleaseDefinitions getReleaseDefinitions() throws ConnectionException, AzDException;

}
