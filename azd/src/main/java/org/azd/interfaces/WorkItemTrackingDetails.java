package org.azd.interfaces;

import org.azd.enums.WorkItemErrorPolicy;
import org.azd.enums.WorkItemExpand;
import org.azd.enums.WorkItemOperation;
import org.azd.exceptions.AzDException;
import org.azd.workitemtracking.types.*;

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
	void deleteWorkItem(int id, boolean destroy) throws AzDException;
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
	void removeWorkItemFromRecycleBin(int id) throws AzDException;
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
			boolean validateOnly, Map<String, Object> fieldsToUpdate, WorkItemOperation operation)
			throws AzDException;
	WorkItem addHyperLinks(int workItemId, Map<String, String> hyperlinksMap) throws AzDException;
	WorkItem removeHyperLinks(int workItemId, List<String> urls) throws AzDException;
	WorkItemTypes getWorkItemTypes() throws AzDException;
	WorkItemType getWorkItemType(String workItemTypeName) throws AzDException;
}
