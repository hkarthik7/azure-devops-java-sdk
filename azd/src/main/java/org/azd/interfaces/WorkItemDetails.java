package org.azd.interfaces;

import org.azd.enums.WorkItemErrorPolicy;
import org.azd.enums.WorkItemExpand;
import org.azd.enums.WorkItemOperation;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.workitemtracking.types.*;

public interface WorkItemDetails {
    WorkItem createWorkItem(String workItemType, WorkItemOperation operation, String title) throws ConnectionException, AzDException;
    WorkItem createWorkItem(String workItemType,
                            WorkItemOperation operation, String title, String description,
                            String[] tags) throws ConnectionException, AzDException;
    WorkItemDelete deleteWorkItem(int id) throws ConnectionException, AzDException;
    WorkItemDelete deleteWorkItem(int id, boolean destroy) throws ConnectionException, AzDException;
    WorkItem getWorkItem(int id) throws ConnectionException, AzDException;
    WorkItem getWorkItem(int id, WorkItemExpand expand) throws ConnectionException, AzDException;
    WorkItem getWorkItem(int id, WorkItemExpand expand, String asOf) throws ConnectionException, AzDException;
    WorkItem getWorkItem(int id, WorkItemExpand expand, String[] fields) throws ConnectionException, AzDException;
    WorkItem getWorkItem(int id, WorkItemExpand expand, String[] fields, String asOf) throws ConnectionException, AzDException;
    WorkItemList getWorkItems(int[] ids) throws ConnectionException, AzDException;
    WorkItemList getWorkItems(int[] ids, WorkItemExpand expand) throws ConnectionException, AzDException;
    WorkItemList getWorkItems(int[] ids, WorkItemExpand expand, String asOf) throws ConnectionException, AzDException;
    WorkItemList getWorkItems(int[] ids, WorkItemExpand expand, String[] fields) throws ConnectionException, AzDException;
    WorkItemList getWorkItems(int[] ids, WorkItemExpand expand, String[] fields,
                              String asOf, WorkItemErrorPolicy errorPolicy) throws ConnectionException, AzDException;
    WorkItemList getWorkItemRevisions(int workItemId) throws ConnectionException, AzDException;
    WorkItemList getWorkItemRevisions(int workItemId, WorkItemExpand expand) throws ConnectionException, AzDException;
    WorkItemList getWorkItemRevisions(int workItemId, WorkItemExpand expand, int top, int skip) throws ConnectionException, AzDException;
    WorkItem getWorkItemRevision(int workItemId, int revisionNumber) throws ConnectionException, AzDException;
    WorkItem getWorkItemRevision(int workItemId, int revisionNumber, WorkItemExpand expand) throws ConnectionException, AzDException;
    WorkItemQueryResult queryByWiql(String team, String query) throws ConnectionException, AzDException;
    WorkItemQueryResult queryByWiql(String team, String query, int top, boolean timePrecision) throws ConnectionException, AzDException;
    void removeWorkItemFromRecycleBin(int id) throws ConnectionException, AzDException;
    WorkItemDeleteReference getWorkItemFromRecycleBin(int id) throws ConnectionException, AzDException;
    WorkItemDeleteShallowReferences getDeletedWorkItemsFromRecycleBin() throws ConnectionException, AzDException;
    WorkItemDeleteReferences getDeletedWorkItemsFromRecycleBin(int[] ids) throws ConnectionException, AzDException;
    WorkItemDeleteReference restoreWorkItemFromRecycleBin(int id) throws ConnectionException, AzDException;
}
