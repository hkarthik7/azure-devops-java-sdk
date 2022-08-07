package org.azd.interfaces;

import org.azd.distributedtask.types.VariableGroupMap;
import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.release.types.*;

public interface ReleaseDetails {
    Release createRelease(int releaseDefinitionId, String description, String artifactAlias,
                          String artifactId, String artifactName,
                          boolean isDraft) throws AzDException;

    Release getRelease(int releaseId) throws AzDException;

    Release getRelease(int releaseId, SingleReleaseExpands expand) throws AzDException;

    Release getRelease(int releaseId, SingleReleaseExpands expand,
                       ReleaseApprovalFilters approvalFilters, String[] propertyFilters,
                       int topGateRecords) throws AzDException;

    ReleaseEnvironment getReleaseEnvironment(int releaseId, int environmentId) throws AzDException;

    ReleaseEnvironment getReleaseEnvironment(int releaseId, int environmentId, SingleReleaseExpands expand)
            throws AzDException;

    Releases getReleases() throws AzDException;

    Releases getReleases(ReleaseExpands expand) throws AzDException;

    Releases getReleases(int definitionId) throws AzDException;

    Releases getReleases(ReleaseExpands expand, int top) throws AzDException;

    Releases getReleases(String[] releaseIdFilter) throws AzDException;

    Releases getReleases(ReleaseExpands expand, String artifactVersionId) throws AzDException;

    Releases getReleases(ReleaseExpands expand, int top, String artifactTypeId,
                         String artifactVersionId, int continuationToken, String createdBy,
                         int definitionEnvironmentId, int definitionId, int environmentStatusFilter,
                         boolean isDeleted, String maxCreatedTime, String minCreatedTime,
                         String path, String[] propertyFilters, ReleaseQueryOrder queryOrder,
                         String[] releaseIdFilter, String searchText, String sourceBranchFilter,
                         String sourceId, ReleaseStatus statusFilter, String[] tagFilter) throws AzDException;

    ReleaseDefinition createReleaseDefinition(String releaseDefinitionParameters) throws AzDException;

    Void deleteReleaseDefinition(int definitionId) throws AzDException;

    Void deleteReleaseDefinition(int definitionId, String comment, boolean forceDelete) throws AzDException;

    ReleaseDefinition getReleaseDefinition(int definitionId) throws AzDException;

    ReleaseDefinitionRevisions getReleaseDefinitionHistory(int definitionId) throws AzDException;

    ReleaseDefinitions getReleaseDefinitions() throws AzDException;

    ReleaseDefinitions getReleaseDefinitions(ReleaseDefinitionExpands expands) throws AzDException;

    ReleaseDefinitions getReleaseDefinitions(int top) throws AzDException;

    ReleaseDefinitions getReleaseDefinitions(String artifactSourceId) throws AzDException;

    ReleaseDefinitions getReleaseDefinitions(int[] definitionIdFilter) throws AzDException;

    ReleaseDefinitions getReleaseDefinitions(ReleaseDefinitionExpands expands, int top, String artifactSourceId,
                                             String artifactType, String continuationToken, int[] definitionIdFilter,
                                             boolean isDeleted, boolean isExactNameMatch, String path,
                                             String[] propertyFilters, ReleaseDefinitionQueryOrder queryOrder,
                                             String searchText, boolean searchTextContainsFolderName, String[] tagFilter) throws AzDException;

    ReleaseDefinition updateReleaseDefinition(ReleaseDefinition releaseDefinition) throws AzDException;

    Void deleteRelease(int releaseId) throws AzDException;

    Release updateRelease(int releaseId, Release release) throws AzDException;

    ReleaseEnvironment updateReleaseEnvironment(int releaseId, int environmentId, String comment,
                                                String scheduledDeploymentTime, ReleaseEnvironmentStatus status, VariableGroupMap variables)
            throws AzDException;

    Release updateReleaseResource(int releaseId, String comment, boolean keepForever,
                                  String[] manualEnvironments, ReleaseStatus status, String name)
            throws AzDException;

    ReleaseEnvironment queueRelease(int releaseId, String environmentName) throws AzDException;

    Release abandonRelease(int releaseId) throws AzDException;

    ReleaseApprovals getReleaseApprovals() throws AzDException;

    ReleaseApprovals getReleaseApprovals(int[] releaseIdsFilter) throws AzDException;

    ReleaseApprovals getReleaseApprovals(String assignedToFilter, int continuationToken, boolean includeMyGroupApprovals,
                                         ReleaseQueryOrder queryOrder, int[] releaseIdsFilter, ReleaseApprovalStatus statusFilter,
                                         int top, ReleaseApprovalType typeFilter) throws AzDException;

    ReleaseApproval updateApproval(int approvalId, ReleaseApprovalStatus status, String comments) throws AzDException;

    ManualIntervention getManualIntervention(int releaseId, int manualInterventionId) throws AzDException;

    ManualInterventions getManualInterventions(int releaseId) throws AzDException;

    ManualIntervention updateManualIntervention(int releaseId, int manualInterventionId, String comment, ManualInterventionStatus status)
            throws AzDException;

}
