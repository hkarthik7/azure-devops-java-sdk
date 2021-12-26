package org.azd.interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.azd.enums.WorkItemErrorPolicy;
import org.azd.enums.WorkItemExpand;
import org.azd.enums.WorkItemOperation;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.workitemtracking.types.WorkItem;
import org.azd.workitemtracking.types.WorkItemDelete;
import org.azd.workitemtracking.types.WorkItemDeleteReference;
import org.azd.workitemtracking.types.WorkItemDeleteReferences;
import org.azd.workitemtracking.types.WorkItemDeleteShallowReferences;
import org.azd.workitemtracking.types.WorkItemList;
import org.azd.workitemtracking.types.WorkItemQueryResult;
import org.azd.workitemtracking.types.WorkItemType;
import org.azd.workitemtracking.types.WorkItemTypes;

public interface WorkItemTrackingDetails {
	WorkItem createWorkItem(String workItemType, WorkItemOperation operation, String title)
			throws ConnectionException, AzDException;
	WorkItem createWorkItem(String workItemType, WorkItemOperation operation, String title, String description,
			String[] tags) throws ConnectionException, AzDException;
	WorkItem createWorkItem(String workItemType, String title, String description,
			HashMap<String, Object> additionalFields) throws ConnectionException, AzDException;
	WorkItemDelete deleteWorkItem(int id) throws ConnectionException, AzDException;
	void deleteWorkItem(int id, boolean destroy) throws ConnectionException, AzDException;
	WorkItem getWorkItem(int id) throws ConnectionException, AzDException;
	WorkItem getWorkItem(int id, WorkItemExpand expand) throws ConnectionException, AzDException;
	WorkItem getWorkItem(int id, WorkItemExpand expand, String asOf) throws ConnectionException, AzDException;
	WorkItem getWorkItem(int id, WorkItemExpand expand, String[] fields) throws ConnectionException, AzDException;
	WorkItem getWorkItem(int id, WorkItemExpand expand, String[] fields, String asOf)
			throws ConnectionException, AzDException;
	WorkItemList getWorkItems(int[] ids) throws ConnectionException, AzDException;
	WorkItemList getWorkItems(int[] ids, WorkItemExpand expand) throws ConnectionException, AzDException;
	WorkItemList getWorkItems(int[] ids, WorkItemExpand expand, String asOf) throws ConnectionException, AzDException;
	WorkItemList getWorkItems(int[] ids, WorkItemExpand expand, String[] fields)
			throws ConnectionException, AzDException;
	WorkItemList getWorkItems(int[] ids, WorkItemExpand expand, String[] fields, String asOf,
			WorkItemErrorPolicy errorPolicy) throws ConnectionException, AzDException;
	WorkItemList getWorkItemRevisions(int workItemId) throws ConnectionException, AzDException;
	WorkItemList getWorkItemRevisions(int workItemId, WorkItemExpand expand) throws ConnectionException, AzDException;
	WorkItemList getWorkItemRevisions(int workItemId, WorkItemExpand expand, int top, int skip)
			throws ConnectionException, AzDException;
	WorkItem getWorkItemRevision(int workItemId, int revisionNumber) throws ConnectionException, AzDException;
	WorkItem getWorkItemRevision(int workItemId, int revisionNumber, WorkItemExpand expand)
			throws ConnectionException, AzDException;
	WorkItemQueryResult queryByWiql(String team, String query) throws ConnectionException, AzDException;
	WorkItemQueryResult queryByWiql(String team, String query, int top, boolean timePrecision)
			throws ConnectionException, AzDException;
	void removeWorkItemFromRecycleBin(int id) throws ConnectionException, AzDException;
	WorkItemDeleteReference getWorkItemFromRecycleBin(int id) throws ConnectionException, AzDException;
	WorkItemDeleteShallowReferences getDeletedWorkItemsFromRecycleBin() throws ConnectionException, AzDException;
	WorkItemDeleteReferences getDeletedWorkItemsFromRecycleBin(int[] ids) throws ConnectionException, AzDException;
	WorkItemDeleteReference restoreWorkItemFromRecycleBin(int id) throws ConnectionException, AzDException;
	WorkItem updateWorkItem(int workItemId, HashMap<String, Object> fieldsToUpdate)
			throws ConnectionException, AzDException;
	WorkItem updateWorkItem(int workItemId, HashMap<String, Object> fieldsToUpdate, WorkItemOperation operation)
			throws ConnectionException, AzDException;
	WorkItem updateWorkItem(int workItemId, WorkItemExpand expand, boolean bypassRules, boolean suppressNotifications,
			boolean validateOnly, HashMap<String, Object> fieldsToUpdate) throws ConnectionException, AzDException;
	WorkItem updateWorkItem(int workItemId, WorkItemExpand expand, boolean bypassRules, boolean suppressNotifications,
			boolean validateOnly, HashMap<String, Object> fieldsToUpdate, WorkItemOperation operation)
			throws ConnectionException, AzDException;
	WorkItem addHyperLinks(int workItemId, Map<String, String> hyperlinksMap) throws ConnectionException, AzDException;
	WorkItem removeHyperLinks(int workItemId, List<String> urls) throws ConnectionException, AzDException;
	WorkItemTypes getWorkItemTypes() throws ConnectionException, AzDException;
	WorkItemType getWorkItemType(String workItemTypeName) throws ConnectionException, AzDException;
}
