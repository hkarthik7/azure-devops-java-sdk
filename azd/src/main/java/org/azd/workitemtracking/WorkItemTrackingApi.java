package org.azd.workitemtracking;

import org.azd.common.ApiVersion;
import org.azd.connection.Connection;
import org.azd.enums.RequestMethod;
import org.azd.enums.WorkItemErrorPolicy;
import org.azd.enums.WorkItemExpand;
import org.azd.enums.WorkItemOperation;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.WorkItemTrackingDetails;
import org.azd.workitemtracking.types.*;

import java.util.*;

import static org.azd.helpers.URLHelper.encodeSpace;
import static org.azd.utils.Client.send;

/***
 * WorkItem Tracking class to manage work items API
 */
public class WorkItemTrackingApi implements WorkItemTrackingDetails {
    /***
     * Connection object
     */
    private final Connection CONNECTION;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "wit";
    private final String WIT = "5264459e-e5e0-4bd8-b118-0985e68a4ec5";

    /***
     * Pass the connection object to work with WorkItem Tracking Api
     * @param connection Connection object
     */
    public WorkItemTrackingApi(Connection connection) { this.CONNECTION = connection; }

    /***
     * Creates a single work item.
     * @param workItemType The work item type of the work item to create. e.g., "user story", "bug", "task"
     * @param operation The patch operation {@link WorkItemOperation}
     * @param title The title for the work item
     * @return {@link WorkItem}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WorkItem createWorkItem(String workItemType,
                                   WorkItemOperation operation,
                                   String title) throws ConnectionException, AzDException {
        var req = new HashMap<String, Object>(){{
            put("op", operation.toString().toLowerCase());
            put("path", "/fields/System.Title");
            put("from", null);
            put("value", title);
        }};

        String r = send(RequestMethod.POST, CONNECTION, WIT, CONNECTION.getProject(),
                AREA + "/workitems",  null, "$"+ encodeSpace(workItemType), ApiVersion.WORK_ITEM_TRACKING,
                null, null, List.of(req), null);

        return MAPPER.mapJsonResponse(r, WorkItem.class);
    }

    /***
     * Creates a single work item.
     * @param workItemType The work item type of the work item to create. e.g., "user story", "bug", "task"
     * @param operation The patch operation {@link WorkItemOperation}
     * @param title The title for the work item
     * @param description Description for the work item
     * @param tags Tags for the work item
     * @return {@link WorkItem}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WorkItem createWorkItem(String workItemType,
                                   WorkItemOperation operation, String title,
                                   String description, String[] tags) throws ConnectionException, AzDException {
        var t = new HashMap<String, Object>(){{
            put("op", operation.toString().toLowerCase());
            put("path", "/fields/System.Title");
            put("from", null);
            put("value", title);
        }};

        var d = new HashMap<String, Object>(){{
            put("op", operation.toString().toLowerCase());
            put("path", "/fields/System.Description");
            put("from", null);
            put("value", description);
        }};

        var tt = new HashMap<String, Object>(){{
            put("op", operation.toString().toLowerCase());
            put("path", "/fields/System.Tags");
            put("from", null);
            put("value", String.join(",", tags));
        }};

        var req = new ArrayList<>();
        req.add(t);
        req.add(d);
        req.add(tt);

        String r = send(RequestMethod.POST, CONNECTION, WIT, CONNECTION.getProject(),
                AREA + "/workitems",  null, "$"+ encodeSpace(workItemType), ApiVersion.WORK_ITEM_TRACKING,
                null, null, req, null);

        return MAPPER.mapJsonResponse(r, WorkItem.class);
    }

    /***
     * Creates a single work item optionally with additional fields.
     * @param workItemType The work item type of the work item to create. e.g., "user story", "bug", "task"
     * @param title The title for the work item
     * @param description Description for the work item
     * @param additionalFields Provide the additional fields as a HashMap to create the work item.
     * This requires the internal fields to be specified. E.g., System.Tags, System.AreaPath, System.State, System.Reason etc.,
     * @return {@link WorkItem}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WorkItem createWorkItem(String workItemType, String title, String description, HashMap<String, Object> additionalFields)
            throws ConnectionException, AzDException {
        var req = new ArrayList<>();

        var t = new HashMap<String, Object>(){{
            put("op", "add");
            put("path", "/fields/System.Title");
            put("from", null);
            put("value", title);
        }};

        var d = new HashMap<String, Object>(){{
            put("op", "add");
            put("path", "/fields/System.Description");
            put("from", null);
            put("value", description);
        }};

        req.add(t);
        req.add(d);

        for (var key : additionalFields.keySet()) {
            var i = new HashMap<String, Object>(){{
                put("op", "add");
                put("path", "/fields/" + key);
                put("from", null);
                put("value", additionalFields.get(key));
            }};

            req.add(i);
        }

        String r = send(RequestMethod.POST, CONNECTION, WIT, CONNECTION.getProject(),
                AREA + "/workitems",  null, "$"+ encodeSpace(workItemType), ApiVersion.WORK_ITEM_TRACKING,
                null, null, req, null);

        return MAPPER.mapJsonResponse(r, WorkItem.class);
    }

    /***
     * Deletes the specified work item and sends it to the Recycle Bin, so that it can be restored back, if required.
      * @param id ID of the work item to be deleted
     * @return {@link WorkItemDelete}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WorkItemDelete deleteWorkItem(int id) throws ConnectionException, AzDException {
        String r = send(RequestMethod.DELETE, CONNECTION, WIT, CONNECTION.getProject(),
                AREA + "/workitems",  String.valueOf(id),null , ApiVersion.WORK_ITEM_TRACKING, null, null);

        return MAPPER.mapJsonResponse(r, WorkItemDelete.class);
    }

    /***
     * Deletes the specified work item permanently if the destroy parameter has been set to true,
     * WARNING: If the destroy parameter is set to true, work items deleted by this command will
     * NOT go to recycle-bin and there is no way to restore/recover them after deletion.
     * It is recommended NOT to use this parameter. If you do, please use this parameter with extreme caution.
     * @param id ID of the work item to be deleted
     * @param destroy Optional parameter, if set to true, the work item is deleted permanently.
     * Please note: the destroy action is PERMANENT and cannot be undone.
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public void deleteWorkItem(int id, boolean destroy) throws ConnectionException, AzDException {
        try {
            var q = new HashMap<String, Object>(){{put("destroy", destroy);}};

            String r = send(RequestMethod.DELETE, CONNECTION, WIT, CONNECTION.getProject(),
                    AREA + "/workitems",  String.valueOf(id),null , ApiVersion.WORK_ITEM_TRACKING, q, null);

            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (ConnectionException | AzDException e) {
            throw e;
        }
    }

    /***
     * Returns a single work item.
     * @param id The work item id
     * @return WorkItem {@link WorkItem}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WorkItem getWorkItem(int id) throws ConnectionException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, WIT, CONNECTION.getProject(),
                AREA + "/workitems", Integer.toString(id), null, ApiVersion.WORK_ITEM_TRACKING, null, null);

        return MAPPER.mapJsonResponse(r, WorkItem.class);
    }

    /***
     * Returns a single work item.
     * @param id The work item id
     * @param expand The expand parameters for work item attributes.
     * Possible options are { None, Relations, Fields, Links, All }. {@link WorkItemExpand}
     * @return WorkItem {@link WorkItem}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WorkItem getWorkItem(int id, WorkItemExpand expand) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
           put("$expand", expand.toString().toLowerCase());
        }};

        String r = send(RequestMethod.GET, CONNECTION, WIT, CONNECTION.getProject(),
                AREA + "/workitems", Integer.toString(id), null, ApiVersion.WORK_ITEM_TRACKING, q, null);

        return MAPPER.mapJsonResponse(r, WorkItem.class);
    }

    /***
     * Returns a single work item.
     * @param id The work item id
     * @param expand The expand parameters for work item attributes.
     * Possible options are { None, Relations, Fields, Links, All }. {@link WorkItemExpand}
     * @param asOf AsOf UTC date time string
     * @return WorkItem {@link WorkItem}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WorkItem getWorkItem(int id, WorkItemExpand expand, String asOf) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("asOf", asOf);
            put("$expand", expand.toString().toLowerCase());
        }};

        String r = send(RequestMethod.GET, CONNECTION, WIT, CONNECTION.getProject(),
                AREA + "/workitems", Integer.toString(id), null, ApiVersion.WORK_ITEM_TRACKING, q, null);

        return MAPPER.mapJsonResponse(r, WorkItem.class);
    }

    /***
     * Returns a single work item.
     * @param id The work item id
     * @param expand The expand parameters for work item attributes.
     * Possible options are { None, Relations, Fields, Links, All }. {@link WorkItemExpand}
     * @param fields Comma-separated list of requested fields
     * @return WorkItem {@link WorkItem}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WorkItem getWorkItem(int id, WorkItemExpand expand, String[] fields) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("fields", String.join(",", fields));
            put("$expand", expand.toString().toLowerCase());
        }};

        String r = send(RequestMethod.GET, CONNECTION, WIT, CONNECTION.getProject(),
                AREA + "/workitems", Integer.toString(id), null, ApiVersion.WORK_ITEM_TRACKING, q, null);

        return MAPPER.mapJsonResponse(r, WorkItem.class);
    }

    /***
     * Returns a single work item.
     * @param id The work item id
     * @param expand The expand parameters for work item attributes.
     * Possible options are { None, Relations, Fields, Links, All }. {@link WorkItemExpand}
     * @param fields Comma-separated list of requested fields
     * @param asOf AsOf UTC date time string
     * @return WorkItem {@link WorkItem}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WorkItem getWorkItem(int id, WorkItemExpand expand, String[] fields, String asOf) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("fields", String.join(",", fields));
            put("asOf", asOf);
            put("$expand", expand.toString().toLowerCase());
        }};

        String r = send(RequestMethod.GET, CONNECTION, WIT, CONNECTION.getProject(),
                AREA + "/workitems", Integer.toString(id), null, ApiVersion.WORK_ITEM_TRACKING, q, null);

        return MAPPER.mapJsonResponse(r, WorkItem.class);
    }

    /***
     * Returns a list of work items (Maximum 200)
     * @param ids Integer array of requested work item ids. (Maximum 200 ids allowed).
     * @return {@link WorkItemList}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WorkItemList getWorkItems(int[] ids) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{put("ids", intArrayToString(ids));}};

        String r = send(RequestMethod.GET, CONNECTION, WIT, CONNECTION.getProject(),
                AREA + "/workitems", null, null, ApiVersion.WORK_ITEM_TRACKING, q, null);

        return MAPPER.mapJsonResponse(r, WorkItemList.class);
    }

    /***
     * Returns a list of work items (Maximum 200)
     * @param ids Integer array of requested work item ids. (Maximum 200 ids allowed).
     * @param expand The expand parameters for work item attributes.
     * Possible options are { None, Relations, Fields, Links, All }. {@link WorkItemExpand}
     * @return {@link WorkItemList}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WorkItemList getWorkItems(int[] ids, WorkItemExpand expand) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("ids", intArrayToString(ids));
            put("$expand", expand.toString().toLowerCase());
        }};

        String r = send(RequestMethod.GET, CONNECTION, WIT, CONNECTION.getProject(),
                AREA + "/workitems", null, null, ApiVersion.WORK_ITEM_TRACKING, q, null);

        return MAPPER.mapJsonResponse(r, WorkItemList.class);
    }

    /***
     * Returns a list of work items (Maximum 200)
     * @param ids Integer array of requested work item ids. (Maximum 200 ids allowed).
     * @param expand The expand parameters for work item attributes.
     * Possible options are { None, Relations, Fields, Links, All }. {@link WorkItemExpand}
     * @param asOf AsOf UTC date time string
     * @return {@link WorkItemList}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WorkItemList getWorkItems(int[] ids, WorkItemExpand expand, String asOf) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("ids", intArrayToString(ids));
            put("$expand", expand.toString().toLowerCase());
            put("fields", asOf);
        }};

        String r = send(RequestMethod.GET, CONNECTION, WIT, CONNECTION.getProject(),
                AREA + "/workitems", null, null, ApiVersion.WORK_ITEM_TRACKING, q, null);

        return MAPPER.mapJsonResponse(r, WorkItemList.class);
    }

    /***
     * Returns a list of work items (Maximum 200)
     * @param ids Integer array of requested work item ids. (Maximum 200 ids allowed).
     * @param expand The expand parameters for work item attributes.
     * Possible options are { None, Relations, Fields, Links, All }. {@link WorkItemExpand}
     * @param fields Comma-separated list of requested fields
     * @return {@link WorkItemList}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WorkItemList getWorkItems(int[] ids, WorkItemExpand expand, String[] fields) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("ids", intArrayToString(ids));
            put("$expand", expand.toString().toLowerCase());
            put("fields", String.join(",", fields));
        }};

        String r = send(RequestMethod.GET, CONNECTION, WIT, CONNECTION.getProject(),
                AREA + "/workitems", null, null, ApiVersion.WORK_ITEM_TRACKING, q, null);

        return MAPPER.mapJsonResponse(r, WorkItemList.class);
    }

    /***
     * Returns a list of work items (Maximum 200)
     * @param ids Integer array of requested work item ids. (Maximum 200 ids allowed).
     * @param expand The expand parameters for work item attributes.
     * Possible options are { None, Relations, Fields, Links, All }. {@link WorkItemExpand}
     * @param fields Comma-separated list of requested fields
     * @param asOf AsOf UTC date time string
     * @param errorPolicy The flag to control error policy in a bulk get work items request.
     * Possible options are {Fail, Omit}. {@link WorkItemErrorPolicy}
     * @return {@link WorkItemList}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WorkItemList getWorkItems(int[] ids, WorkItemExpand expand, String[] fields, String asOf, WorkItemErrorPolicy errorPolicy) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("ids", intArrayToString(ids));
            put("$expand", expand.toString().toLowerCase());
            put("asOf", asOf);
            put("fields", String.join(",", fields));
            put("errorPolicy", errorPolicy.toString().toLowerCase());
        }};

        String r = send(RequestMethod.GET, CONNECTION, WIT, CONNECTION.getProject(),
                AREA + "/workitems", null, null, ApiVersion.WORK_ITEM_TRACKING, q, null);

        return MAPPER.mapJsonResponse(r, WorkItemList.class);
    }

    /***
     * Returns the list of fully hydrated work item revisions.
     * @param workItemId The id of the work item
     * @return {@link WorkItemList}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WorkItemList getWorkItemRevisions(int workItemId) throws ConnectionException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, WIT, CONNECTION.getProject(),
                AREA + "/workitems", Integer.toString(workItemId), "revisions", ApiVersion.WORK_ITEM_TRACKING, null, null);

        return MAPPER.mapJsonResponse(r, WorkItemList.class);
    }

    /***
     * Returns the list of fully hydrated work item revisions.
     * @param workItemId The id of the work item
     * @param expand The expand parameters for work item attributes.
     * Possible options are { None, Relations, Fields, Links, All }. {@link WorkItemExpand}
     * @return {@link WorkItemList}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WorkItemList getWorkItemRevisions(int workItemId, WorkItemExpand expand) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{put("$expand", expand.toString().toLowerCase());}};

        String r = send(RequestMethod.GET, CONNECTION, WIT, CONNECTION.getProject(),
                AREA + "/workitems", Integer.toString(workItemId), "revisions", ApiVersion.WORK_ITEM_TRACKING, q, null);

        return MAPPER.mapJsonResponse(r, WorkItemList.class);
    }

    /***
     *
     * Returns the list of fully hydrated work item revisions, paged.
     * @param workItemId The id of the work item
     * @param expand The expand parameters for work item attributes.
     * Possible options are { None, Relations, Fields, Links, All }. {@link WorkItemExpand}
     * @param top Specify top pages to list
     * @param skip Specify to skip pages
     * @return {@link WorkItemList}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WorkItemList getWorkItemRevisions(int workItemId, WorkItemExpand expand, int top, int skip) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("$expand", expand.toString().toLowerCase());
            put("$top", top);
            put("$skip", skip);
        }};

        String r = send(RequestMethod.GET, CONNECTION, WIT, CONNECTION.getProject(),
                AREA + "/workitems", Integer.toString(workItemId), "revisions", ApiVersion.WORK_ITEM_TRACKING, q, null);

        return MAPPER.mapJsonResponse(r, WorkItemList.class);
    }

    /***
     * Returns a fully hydrated work item for the requested revision
     * @param workItemId The id of the work item
     * @param revisionNumber The work item revision number
     * @return {@link WorkItem}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WorkItem getWorkItemRevision(int workItemId, int revisionNumber) throws ConnectionException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, WIT, CONNECTION.getProject(),
                AREA + "/workitems", Integer.toString(workItemId), "revisions/" + revisionNumber,
                ApiVersion.WORK_ITEM_TRACKING, null, null);

        return MAPPER.mapJsonResponse(r, WorkItem.class);
    }

    /***
     * Returns a fully hydrated work item for the requested revision
     * @param workItemId The id of the work item
     * @param revisionNumber The work item revision number
     * @param expand The expand parameters for work item attributes.
     * Possible options are { None, Relations, Fields, Links, All }. {@link WorkItemExpand}
     * @return {@link WorkItem}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WorkItem getWorkItemRevision(int workItemId, int revisionNumber, WorkItemExpand expand) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{put("$expand", expand.toString().toLowerCase());}};

        String r = send(RequestMethod.GET, CONNECTION, WIT, CONNECTION.getProject(),
                AREA + "/workitems", Integer.toString(workItemId), "revisions/" + revisionNumber,
                ApiVersion.WORK_ITEM_TRACKING, q, null);

        return MAPPER.mapJsonResponse(r, WorkItem.class);
    }

    /***
     * Gets the results of the query given its WIQL.
     * @param team Team ID or team name
     * @param query Specify the query to list the work items. E.g., "Select * From WorkItems Where [System.WorkItemType] = 'User Story'"
     * @return WorkItemQueryResult {@link WorkItemQueryResult}
     * @throws ConnectionException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public WorkItemQueryResult queryByWiql(String team, String query) throws ConnectionException, AzDException {
        var body = new HashMap<String, Object>(){{put("query", query);}};

        String r = send(RequestMethod.POST, CONNECTION, WIT, CONNECTION.getProject() + "/" + encodeSpace(team),
                AREA, null, "wiql", ApiVersion.WIT_WIQL, null, body);

        return MAPPER.mapJsonResponse(r, WorkItemQueryResult.class);
    }

    /***
     * Gets the results of the query given its WIQL.
     * @param team Team ID or team name
     * @param query Specify the query to list the work items. E.g., "Select * From WorkItems Where [System.WorkItemType] = 'User Story'"
     * @param top The max number of results to return.
     * @param timePrecision The max number of results to return.
     * @return WorkItemQueryResult {@link WorkItemQueryResult}
     * @throws ConnectionException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public WorkItemQueryResult queryByWiql(String team, String query, int top, boolean timePrecision) throws ConnectionException, AzDException {
        var body = new HashMap<String, Object>(){{put("query", query);}};

        var q = new HashMap<String, Object>(){{
            put("$top", top);
            put("timePrecision", timePrecision);
        }};

        String r = send(RequestMethod.POST, CONNECTION, WIT, CONNECTION.getProject() + "/" + encodeSpace(team),
                AREA, null, "wiql", ApiVersion.WIT_WIQL, q, body);

        return MAPPER.mapJsonResponse(r, WorkItemQueryResult.class);
    }

    /***
     * Destroys the specified work item permanently from the Recycle Bin. This action can not be undone.
     * @param id ID of the work item to be destroyed permanently
     * @throws ConnectionException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public void removeWorkItemFromRecycleBin(int id) throws ConnectionException, AzDException {
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, WIT, CONNECTION.getProject(),
                    AREA + "/recyclebin", Integer.toString(id), null, ApiVersion.WIT_RECYCLE_BIN, null, null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (ConnectionException | AzDException e) {
            throw e;
        }
    }

    /***
     * Gets a deleted work item from Recycle Bin.
     * @param id ID of the work item to be returned
     * @return WorkItemDeleteReference {@link WorkItemDeleteReference}
     * @throws ConnectionException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public WorkItemDeleteReference getWorkItemFromRecycleBin(int id) throws ConnectionException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, WIT, CONNECTION.getProject(),
                AREA + "/recyclebin", Integer.toString(id), null, ApiVersion.WIT_RECYCLE_BIN, null, null);

        return MAPPER.mapJsonResponse(r, WorkItemDeleteReference.class);
    }

    /***
     * Gets a list of the IDs and the URLs of the deleted the work items in the Recycle Bin.
     * @return WorkItemDeleteShallowReferences {@link WorkItemDeleteShallowReferences}
     * @throws ConnectionException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public WorkItemDeleteShallowReferences getDeletedWorkItemsFromRecycleBin() throws ConnectionException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, WIT, CONNECTION.getProject(),
                AREA + "/recyclebin", null, null, ApiVersion.WIT_RECYCLE_BIN, null, null);

        return MAPPER.mapJsonResponse(r, WorkItemDeleteShallowReferences.class);
    }

    /***
     * Gets the work items from the recycle bin, whose IDs have been specified in the parameters
     * @param ids array of workitem ids
     * @return WorkItemDeleteReferences {@link WorkItemDeleteReferences}
     * @throws ConnectionException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public WorkItemDeleteReferences getDeletedWorkItemsFromRecycleBin(int[] ids) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
           put("ids", intArrayToString(ids));
        }};

        String r = send(RequestMethod.GET, CONNECTION, WIT, CONNECTION.getProject(),
                AREA + "/recyclebin", null, null, ApiVersion.WIT_RECYCLE_BIN, q, null);

        return MAPPER.mapJsonResponse(r, WorkItemDeleteReferences.class);
    }

    /***
     * Restores the deleted work item from Recycle Bin.
     * @param id ID of the work item to be restored
     * @return WorkItemDeleteReference {@link WorkItemDeleteReference}
     * @throws ConnectionException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public WorkItemDeleteReference restoreWorkItemFromRecycleBin(int id) throws ConnectionException, AzDException {
        var b = new HashMap<String, Object>(){{
            put("isDeleted", false);
        }};

        String r = send(RequestMethod.PATCH, CONNECTION, WIT, CONNECTION.getProject(),
                AREA + "/recyclebin", Integer.toString(id), null, ApiVersion.WIT_RECYCLE_BIN, null, b);

        return MAPPER.mapJsonResponse(r, WorkItemDeleteReference.class);
    }

    /***
     * Update a single work item with the internal field names.
     * @param workItemId The id of the work item to update
     * @param fieldsToUpdate HashMap of internal field names to update. E.g., System.Title, System.Description etc and it's associated values.
     * @return WorkItemDeleteReference {@link WorkItemDeleteReference}
     * @throws ConnectionException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public WorkItem updateWorkItem(int workItemId, HashMap<String, Object> fieldsToUpdate) throws ConnectionException, AzDException {
        var req = new ArrayList<>();

        for (var key : fieldsToUpdate.keySet()) {
            var i = new HashMap<String, Object>(){{
                put("op", "add");
                put("path", "/fields/" + key);
                put("from", null);
                put("value", fieldsToUpdate.get(key));
            }};

            req.add(i);
        }

        String r = send(RequestMethod.PATCH, CONNECTION, WIT, CONNECTION.getProject(),
                AREA + "/workitems",  Integer.toString(workItemId), null, ApiVersion.WORK_ITEM_TRACKING,
                null, null, req, "application/json-patch+json; charset=utf-8");

        return MAPPER.mapJsonResponse(r, WorkItem.class);
    }

    /***
     * Update a single work item with the internal field names.
     * @param workItemId The id of the work item to update
     * @param expand The expand parameters for work item attributes. Possible options are { None, Relations, Fields, Links, All }. {@link WorkItemExpand}
     * @param bypassRules Do not enforce the work item type rules on this update
     * @param suppressNotifications Do not fire any notifications for this change
     * @param validateOnly Indicate if you only want to validate the changes without saving the work item
     * @param fieldsToUpdate HashMap of internal field names to update. E.g., System.Title, System.Description etc and it's associated values.
     * @return WorkItemDeleteReference {@link WorkItemDeleteReference}
     * @throws ConnectionException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public WorkItem updateWorkItem(int workItemId, WorkItemExpand expand, boolean bypassRules, boolean suppressNotifications,
                                   boolean validateOnly, HashMap<String, Object> fieldsToUpdate) throws ConnectionException, AzDException {
        var req = new ArrayList<>();

        for (var key : fieldsToUpdate.keySet()) {
            var i = new HashMap<String, Object>(){{
                put("op", "add");
                put("path", "/fields/" + key);
                put("from", null);
                put("value", fieldsToUpdate.get(key));
            }};

            req.add(i);
        }

        var q = new HashMap<String, Object>(){{
            put("validateOnly", validateOnly);
            put("bypassRules", bypassRules);
            put("suppressNotifications", suppressNotifications);
            put("$expand", expand.toString().toLowerCase());
        }};

        String r = send(RequestMethod.PATCH, CONNECTION, WIT, CONNECTION.getProject(),
                AREA + "/workitems",  Integer.toString(workItemId), null, ApiVersion.WORK_ITEM_TRACKING,
                q, null, req, "application/json-patch+json; charset=utf-8");

        return MAPPER.mapJsonResponse(r, WorkItem.class);
    }

    /***
     * Helper method to convert integer array to string.
     * @param i integer array
     * @return {@link String}
     */
    private String intArrayToString(int[] i) {
        var r = Arrays.stream(i).mapToObj(String::valueOf).toArray(String[]::new);
        return String.join(",", r);
    }
}
