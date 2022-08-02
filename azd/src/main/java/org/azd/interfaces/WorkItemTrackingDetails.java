package org.azd.interfaces;

import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.workitemtracking.types.*;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface WorkItemTrackingDetails {
    WorkItem createWorkItem(String workItemType, WorkItemOperation operation, String title)
            throws AzDException;

    WorkItem createWorkItem(String workItemType, WorkItemOperation operation, String title, String description,
                            String[] tags) throws AzDException;

    WorkItem createWorkItem(String workItemType, String title, String description,
                            Map<String, Object> additionalFields) throws AzDException;

    WorkItemDelete deleteWorkItem(int id) throws AzDException;

    Void deleteWorkItem(int id, boolean destroy) throws AzDException;

    WorkItem getWorkItem(int id) throws AzDException;

    WorkItem getWorkItem(int id, WorkItemExpand expand) throws AzDException;

    WorkItem getWorkItem(int id, WorkItemExpand expand, String asOf) throws AzDException;

    WorkItem getWorkItem(int id, WorkItemExpand expand, String[] fields) throws AzDException;

    WorkItem getWorkItem(int id, WorkItemExpand expand, String[] fields, String asOf)
            throws AzDException;

    WorkItemList getWorkItems(int[] ids) throws AzDException;

    WorkItemList getWorkItems(int[] ids, WorkItemExpand expand) throws AzDException;

    WorkItemList getWorkItems(int[] ids, WorkItemExpand expand, String asOf) throws AzDException;

    WorkItemList getWorkItems(int[] ids, WorkItemExpand expand, String[] fields)
            throws AzDException;

    WorkItemList getWorkItems(int[] ids, WorkItemExpand expand, String[] fields, String asOf,
                              WorkItemErrorPolicy errorPolicy) throws AzDException;

    WorkItemList getWorkItemRevisions(int workItemId) throws AzDException;

    WorkItemList getWorkItemRevisions(int workItemId, WorkItemExpand expand) throws AzDException;

    WorkItemList getWorkItemRevisions(int workItemId, WorkItemExpand expand, int top, int skip)
            throws AzDException;

    WorkItem getWorkItemRevision(int workItemId, int revisionNumber) throws AzDException;

    WorkItem getWorkItemRevision(int workItemId, int revisionNumber, WorkItemExpand expand)
            throws AzDException;

    WorkItemQueryResult queryByWiql(String team, String query) throws AzDException;

    WorkItemQueryResult queryByWiql(String team, String query, int top, boolean timePrecision)
            throws AzDException;

    Void removeWorkItemFromRecycleBin(int id) throws AzDException;

    WorkItemDeleteReference getWorkItemFromRecycleBin(int id) throws AzDException;

    WorkItemDeleteShallowReferences getDeletedWorkItemsFromRecycleBin() throws AzDException;

    WorkItemDeleteReferences getDeletedWorkItemsFromRecycleBin(int[] ids) throws AzDException;

    WorkItemDeleteReference restoreWorkItemFromRecycleBin(int id) throws AzDException;

    WorkItem updateWorkItem(int workItemId, Map<String, Object> fieldsToUpdate)
            throws AzDException;

    WorkItem updateWorkItem(int workItemId, Map<String, Object> fieldsToUpdate, WorkItemOperation operation)
            throws AzDException;

    WorkItem updateWorkItem(int workItemId, WorkItemExpand expand, boolean bypassRules, boolean suppressNotifications,
                            boolean validateOnly, Map<String, Object> fieldsToUpdate) throws AzDException;

    WorkItem updateWorkItem(int workItemId, WorkItemExpand expand, boolean bypassRules, boolean suppressNotifications,
                            boolean validateOnly, Map<String, Object> fieldsToUpdate, WorkItemOperation operation) throws AzDException;

    WorkItem addHyperLinks(int workItemId, Map<String, String> hyperlinksMap) throws AzDException;

    WorkItem removeHyperLinks(int workItemId, List<String> urls) throws AzDException;

    WorkItemTypes getWorkItemTypes() throws AzDException;

    WorkItemType getWorkItemType(String workItemTypeName) throws AzDException;

    AttachmentReference createAttachment(String fileName, AttachmentUploadType uploadType, String teamAreaPath, String contents) throws AzDException;

    String getAttachment(String id, String fileName) throws AzDException;

    AttachmentReference createAttachment(String fileName, AttachmentUploadType uploadType, String teamAreaPath, InputStream contentStream) throws AzDException;

    InputStream getAttachmentContent(String id, String fileName, boolean download) throws AzDException;

    InputStream getAttachmentAsZip(String id, String fileName, boolean download) throws AzDException;

    WorkItem addWorkItemAttachment(int workItemId, Map<String, String> fieldsToUpdate) throws AzDException;

    WorkItem removeWorkItemAttachment(int workItemId, List<String> attachmentUrl) throws AzDException;

    AccountRecentActivityWorkItems getMyWorkRecentActivity() throws AzDException;

    WorkItemFieldTypes getWorkItemFields() throws AzDException;

    WorkItemFieldTypes getWorkItemFields(GetFieldsExpand expand) throws AzDException;

    WorkItemField getWorkItemField(String fieldNameOrRefName) throws AzDException;

    WorkItemField createWorkItemField(WorkItemField workItemField) throws AzDException;

    Void deleteWorkItemField(String fieldNameOrRefName) throws AzDException;

    WorkItemField updateWorkItemField(String fieldNameOrRefName, boolean isDeleted) throws AzDException;

    ProcessMigrationResultModel migrateProjectProcess(String processId) throws AzDException;

    QueryHierarchyItem createQuery(String query, QueryHierarchyItem queryHierarchyItem) throws AzDException;

    QueryHierarchyItems getQueries() throws AzDException;

    QueryHierarchyItems getQueries(int depth, QueryExpand expand, boolean includeDeleted) throws AzDException;

    QueryHierarchyItem getQuery(String query) throws AzDException;

    QueryHierarchyItem getQuery(String query, int depth, QueryExpand expand, boolean includeDeleted, boolean useIsoDateFormat) throws AzDException;

    Void deleteQuery(String query) throws AzDException;

    QueryHierarchyItems getQueryBatches(QueryErrorPolicy errorPolicy, QueryExpand expand, String[] ids) throws AzDException;

    QueryHierarchyItemsResult searchQuery(String filter) throws AzDException;

    QueryHierarchyItemsResult searchQuery(String filter, QueryExpand expand, boolean includeDeleted, int top) throws AzDException;
}
