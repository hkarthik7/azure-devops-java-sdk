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

	/***
	 * Update a single work item with the internal field names. The operation
	 * type that will be used is {@link WorkItemOperation#ADD}.
	 *
	 * @param workItemId
	 *            The id of the work item to update
	 * @param fieldsToUpdate
	 *            HashMap of internal field names to update. E.g., System.Title,
	 *            System.Description etc and it's associated values.
	 *
	 * @return The updated {@link WorkItem}.
	 *
	 * @throws ConnectionException
	 *             If the default parameters (organization name, project name
	 *             and personal access token) are wrong or not set.
	 * @throws AzDException
	 *             Handles errors from REST API and validates passed arguments.
	 */
	WorkItem updateWorkItem(int workItemId, HashMap<String, Object> fieldsToUpdate)
			throws ConnectionException, AzDException;

	/***
	 * Update a single work item with the internal field names.
	 *
	 * @param workItemId
	 *            The id of the work item to update
	 * @param fieldsToUpdate
	 *            HashMap of internal field names to update. E.g., System.Title,
	 *            System.Description etc and it's associated values.
	 * @param operation
	 *            The {@link WorkItemOperation}.
	 *
	 * @return The updated {@link WorkItem}.
	 *
	 * @throws ConnectionException
	 *             If the default parameters (organization name, project name
	 *             and personal access token) are wrong or not set.
	 * @throws AzDException
	 *             Handles errors from REST API and validates passed arguments.
	 */
	WorkItem updateWorkItem(int workItemId, HashMap<String, Object> fieldsToUpdate, WorkItemOperation operation)
			throws ConnectionException, AzDException;

	/***
	 * Update a single work item with the internal field names. The operation
	 * type that will be used is {@link WorkItemOperation#ADD}.
	 *
	 * @param workItemId
	 *            The id of the work item to update
	 * @param expand
	 *            The expand parameters for work item attributes. Possible
	 *            options are { None, Relations, Fields, Links, All }.
	 *            {@link WorkItemExpand}
	 * @param bypassRules
	 *            Do not enforce the work item type rules on this update
	 * @param suppressNotifications
	 *            Do not fire any notifications for this change
	 * @param validateOnly
	 *            Indicate if you only want to validate the changes without
	 *            saving the work item
	 * @param fieldsToUpdate
	 *            HashMap of internal field names to update. E.g., System.Title,
	 *            System.Description etc and it's associated values.
	 *
	 * @return WorkItemDeleteReference {@link WorkItemDeleteReference}
	 *
	 * @throws ConnectionException
	 *             If the default parameters (organization name, project name
	 *             and personal access token) are wrong or not set.
	 * @throws AzDException
	 *             Handles errors from REST API and validates passed arguments.
	 */
	WorkItem updateWorkItem(int workItemId, WorkItemExpand expand, boolean bypassRules, boolean suppressNotifications,
			boolean validateOnly, HashMap<String, Object> fieldsToUpdate) throws ConnectionException, AzDException;

	/***
	 * Update a single work item with the internal field names.
	 *
	 * @param workItemId
	 *            The id of the work item to update
	 * @param expand
	 *            The expand parameters for work item attributes. Possible
	 *            options are { None, Relations, Fields, Links, All }.
	 *            {@link WorkItemExpand}
	 * @param bypassRules
	 *            Do not enforce the work item type rules on this update
	 * @param suppressNotifications
	 *            Do not fire any notifications for this change
	 * @param validateOnly
	 *            Indicate if you only want to validate the changes without
	 *            saving the work item
	 * @param fieldsToUpdate
	 *            HashMap of internal field names to update. E.g., System.Title,
	 *            System.Description etc and it's associated values.
	 * @param operation
	 *            The {@link WorkItemOperation}.
	 *
	 * @return WorkItemDeleteReference {@link WorkItemDeleteReference}
	 *
	 * @throws ConnectionException
	 *             If the default parameters (organization name, project name
	 *             and personal access token) are wrong or not set.
	 * @throws AzDException
	 *             Handles errors from REST API and validates passed arguments.
	 */
	WorkItem updateWorkItem(int workItemId, WorkItemExpand expand, boolean bypassRules, boolean suppressNotifications,
			boolean validateOnly, HashMap<String, Object> fieldsToUpdate, WorkItemOperation operation)
			throws ConnectionException, AzDException;

	/**
	 * Create hyperlinks for the given work item.
	 *
	 * @param workItemId
	 *            The work item's ID.
	 * @param hyperlinksMap
	 *            A {@link Map} that each entry represents a hyperlink. The key
	 *            is the hyperlink URL and the value is its comment. If a
	 *            comment is not desired then the value can either be null (if
	 *            its supported by the map) or an empty string.
	 *
	 * @return The updated {@link WorkItem}.
	 *
	 * @throws ConnectionException
	 *             If the default parameters (organization name, project name
	 *             and personal access token) are wrong or not set.
	 * @throws AzDException
	 *             Handles errors from REST API and validates passed arguments.
	 */
	WorkItem addHyperLinks(int workItemId, Map<String, String> hyperlinksMap) throws ConnectionException, AzDException;

	/**
	 * Remove hyperlinks for the given work item.
	 *
	 * <p>
	 * <b>Note:</b> All hyperlinks must exist in order to be removed. Even if
	 * one doesn't then an {@link AzDException} is thrown.
	 * </p>
	 *
	 * @param workItemId
	 *            The work item's ID.
	 * @param urls
	 *            A {@link List} with the URL of the hyperlinks.
	 *
	 * @return The updated {@link WorkItem}.
	 *
	 * @throws ConnectionException
	 *             If the default parameters (organization name, project name
	 *             and personal access token) are wrong or not set.
	 * @throws AzDException
	 *             Handles errors from REST API and validates passed arguments.
	 */
	WorkItem removeHyperLinks(int workItemId, List<String> urls) throws ConnectionException, AzDException;

	WorkItemTypes getWorkItemTypes() throws ConnectionException, AzDException;

	WorkItemType getWorkItemType(String workItemTypeName) throws ConnectionException, AzDException;
}
