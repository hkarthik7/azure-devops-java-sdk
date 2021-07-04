package org.azd.workitemtracking;

import org.azd.enums.RequestMethod;
import org.azd.enums.WorkItemErrorPolicy;
import org.azd.enums.WorkItemExpand;
import org.azd.enums.WorkItemOperation;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.WorkItemDetails;
import org.azd.utils.AzDDefaultParameters;
import org.azd.utils.ResourceId;
import org.azd.workitemtracking.types.*;

import java.util.*;

import static org.azd.helpers.URLHelper.encodeSpace;
import static org.azd.utils.Client.request;

/***
 * WORKITEMTRACKING class to manage work items API
 * @author Harish karthic
 */
public class WorkItemTrackingApi implements WorkItemDetails {
    /***
     * Instance of AzDDefaultParameters
     */
    private final AzDDefaultParameters DEFAULT_PARAMETERS;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "wit";


    /***
     * Instantiate the class with instance of AzDDefaultParameters
     * @param defaultParameters instance of AzDDefaultParameters
     */
    public WorkItemTrackingApi(AzDDefaultParameters defaultParameters) { this.DEFAULT_PARAMETERS = defaultParameters; }

    /***
     * Creates a single work item.
     * @param workItemType The work item type of the work item to create. e.g., "user story", "bug", "task"
     * @param operation The patch operation {@link WorkItemOperation}
     * @param title The title for the work item
     * @return {@link WorkItem}
     * @throws DefaultParametersException user must instantiate AzDDefaultParameters before calling this method
     * @throws AzDException Exception handler
     */
    @Override
    public WorkItem createWorkItem(String workItemType,
                                   WorkItemOperation operation,
                                   String title) throws DefaultParametersException, AzDException {
        var req = new HashMap<String, Object>(){{
            put("op", operation.toString().toLowerCase());
            put("path", "/fields/System.Title");
            put("from", null);
            put("value", title);
        }};

        String r = request(RequestMethod.POST, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/workitems",  null, "$"+ encodeSpace(workItemType), WorkItemVersion.VERSION,
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
     * @throws DefaultParametersException user must instantiate AzDDefaultParameters before calling this method
     * @throws AzDException Exception handler
     */
    @Override
    public WorkItem createWorkItem(String workItemType,
                                   WorkItemOperation operation, String title,
                                   String description, String[] tags) throws DefaultParametersException, AzDException {
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

        var req = new ArrayList();
        req.add(t);
        req.add(d);
        req.add(tt);

        String r = request(RequestMethod.POST, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/workitems",  null, "$"+ encodeSpace(workItemType), WorkItemVersion.VERSION,
                null, null, req, null);

        return MAPPER.mapJsonResponse(r, WorkItem.class);
    }

    /***
     * Deletes the specified work item and sends it to the Recycle Bin, so that it can be restored back, if required.
      * @param id ID of the work item to be deleted
     * @return {@link WorkItemDelete}
     * @throws DefaultParametersException user must instantiate AzDDefaultParameters before calling this method
     * @throws AzDException Exception handler
     */
    @Override
    public WorkItemDelete deleteWorkItem(int id) throws DefaultParametersException, AzDException {
        String r = request(RequestMethod.DELETE, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/workitems",  String.valueOf(id),null , WorkItemVersion.VERSION, null, null);

        return MAPPER.mapJsonResponse(r, WorkItemDelete.class);
    }

    /***
     * Deletes the specified work item permanently if the destroy parameter has been set to true,
     * WARNING: If the destroy parameter is set to true, work items deleted by this command will
     * NOT go to recycle-bin and there is no way to restore/recover them after deletion.
     * It is recommended NOT to use this parameter. If you do, please use this parameter with extreme caution.
     * @param id ID of the work item to be deleted
     * @param destroy Optional parameter, if set to true, the work item is deleted permanently.
     *                Please note: the destroy action is PERMANENT and cannot be undone.
     * @return {@link WorkItemDelete}
     * @throws DefaultParametersException user must instantiate AzDDefaultParameters before calling this method
     * @throws AzDException Exception handler
     */
    @Override
    public WorkItemDelete deleteWorkItem(int id, boolean destroy) throws DefaultParametersException, AzDException {

        var q = new HashMap<String, Object>(){{put("destroy", destroy);}};

        String r = request(RequestMethod.DELETE, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/workitems",  String.valueOf(id),null , WorkItemVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, WorkItemDelete.class);
    }

    /***
     * Returns a single work item.
     * @param id The work item id
     * @return WorkItem {@link WorkItem}
     * @throws DefaultParametersException user must instantiate AzDDefaultParameters before calling this method
     * @throws AzDException Exception handler
     */
    @Override
    public WorkItem getWorkItem(int id) throws DefaultParametersException, AzDException {
        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/workitems", Integer.toString(id), null, WorkItemVersion.VERSION, null, null);

        return MAPPER.mapJsonResponse(r, WorkItem.class);
    }

    /***
     * Returns a single work item.
     * @param id The work item id
     * @param expand The expand parameters for work item attributes.
     * Possible options are { None, Relations, Fields, Links, All }. {@link WorkItemExpand}
     * @return WorkItem {@link WorkItem}
     * @throws DefaultParametersException user must instantiate AzDDefaultParameters before calling this method
     * @throws AzDException Exception handler
     */
    @Override
    public WorkItem getWorkItem(int id, WorkItemExpand expand) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
           put("$expand", expand.toString().toLowerCase());
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/workitems", Integer.toString(id), null, WorkItemVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, WorkItem.class);
    }

    /***
     * Returns a single work item.
     * @param id The work item id
     * @param expand The expand parameters for work item attributes.
     * Possible options are { None, Relations, Fields, Links, All }. {@link WorkItemExpand}
     * @param asOf AsOf UTC date time string
     * @return WorkItem {@link WorkItem}
     * @throws DefaultParametersException user must instantiate AzDDefaultParameters before calling this method
     * @throws AzDException Exception handler
     */
    @Override
    public WorkItem getWorkItem(int id, WorkItemExpand expand, String asOf) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("asOf", asOf);
            put("$expand", expand.toString().toLowerCase());
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/workitems", Integer.toString(id), null, WorkItemVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, WorkItem.class);
    }

    /***
     * Returns a single work item.
     * @param id The work item id
     * @param expand The expand parameters for work item attributes.
     * Possible options are { None, Relations, Fields, Links, All }. {@link WorkItemExpand}
     * @param fields Comma-separated list of requested fields
     * @return WorkItem {@link WorkItem}
     * @throws DefaultParametersException user must instantiate AzDDefaultParameters before calling this method
     * @throws AzDException Exception handler
     */
    @Override
    public WorkItem getWorkItem(int id, WorkItemExpand expand, String[] fields) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("fields", String.join(",", fields));
            put("$expand", expand.toString().toLowerCase());
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/workitems", Integer.toString(id), null, WorkItemVersion.VERSION, q, null);

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
     * @throws DefaultParametersException user must instantiate AzDDefaultParameters before calling this method
     * @throws AzDException Exception handler
     */
    @Override
    public WorkItem getWorkItem(int id, WorkItemExpand expand, String[] fields, String asOf) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("fields", String.join(",", fields));
            put("asOf", asOf);
            put("$expand", expand.toString().toLowerCase());
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/workitems", Integer.toString(id), null, WorkItemVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, WorkItem.class);
    }

    /***
     * Returns a list of work items (Maximum 200)
     * @param ids Integer array of requested work item ids. (Maximum 200 ids allowed).
     * @return {@link WorkItemList}
     * @throws DefaultParametersException user must instantiate AzDDefaultParameters before calling this method
     * @throws AzDException Exception handler
     */
    @Override
    public WorkItemList getWorkItems(int[] ids) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{put("ids", intArrayToString(ids));}};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/workitems", null, null, WorkItemVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, WorkItemList.class);
    }

    /***
     * Returns a list of work items (Maximum 200)
     * @param ids Integer array of requested work item ids. (Maximum 200 ids allowed).
     * @param expand The expand parameters for work item attributes.
     * Possible options are { None, Relations, Fields, Links, All }. {@link WorkItemExpand}
     * @return {@link WorkItemList}
     * @throws DefaultParametersException user must instantiate AzDDefaultParameters before calling this method
     * @throws AzDException Exception handler
     */
    @Override
    public WorkItemList getWorkItems(int[] ids, WorkItemExpand expand) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("ids", intArrayToString(ids));
            put("$expand", expand.toString().toLowerCase());
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/workitems", null, null, WorkItemVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, WorkItemList.class);
    }

    /***
     * Returns a list of work items (Maximum 200)
     * @param ids Integer array of requested work item ids. (Maximum 200 ids allowed).
     * @param expand The expand parameters for work item attributes.
     * Possible options are { None, Relations, Fields, Links, All }. {@link WorkItemExpand}
     * @param asOf AsOf UTC date time string
     * @return {@link WorkItemList}
     * @throws DefaultParametersException user must instantiate AzDDefaultParameters before calling this method
     * @throws AzDException Exception handler
     */
    @Override
    public WorkItemList getWorkItems(int[] ids, WorkItemExpand expand, String asOf) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("ids", intArrayToString(ids));
            put("$expand", expand.toString().toLowerCase());
            put("fields", asOf);
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/workitems", null, null, WorkItemVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, WorkItemList.class);
    }

    /***
     * Returns a list of work items (Maximum 200)
     * @param ids Integer array of requested work item ids. (Maximum 200 ids allowed).
     * @param expand The expand parameters for work item attributes.
     * Possible options are { None, Relations, Fields, Links, All }. {@link WorkItemExpand}
     * @param fields Comma-separated list of requested fields
     * @return {@link WorkItemList}
     * @throws DefaultParametersException user must instantiate AzDDefaultParameters before calling this method
     * @throws AzDException Exception handler
     */
    @Override
    public WorkItemList getWorkItems(int[] ids, WorkItemExpand expand, String[] fields) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("ids", intArrayToString(ids));
            put("$expand", expand.toString().toLowerCase());
            put("fields", String.join(",", fields));
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/workitems", null, null, WorkItemVersion.VERSION, q, null);

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
     * @throws DefaultParametersException user must instantiate AzDDefaultParameters before calling this method
     * @throws AzDException Exception handler
     */
    @Override
    public WorkItemList getWorkItems(int[] ids, WorkItemExpand expand, String[] fields, String asOf, WorkItemErrorPolicy errorPolicy) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("ids", intArrayToString(ids));
            put("$expand", expand.toString().toLowerCase());
            put("asOf", asOf);
            put("fields", String.join(",", fields));
            put("errorPolicy", errorPolicy.toString().toLowerCase());
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/workitems", null, null, WorkItemVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, WorkItemList.class);
    }

    /***
     * Returns the list of fully hydrated work item revisions.
     * @param workItemId The id of the work item
     * @return {@link WorkItemList}
     * @throws DefaultParametersException user must instantiate AzDDefaultParameters before calling this method
     * @throws AzDException Exception handler
     */
    @Override
    public WorkItemList getWorkItemRevisions(int workItemId) throws DefaultParametersException, AzDException {
        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/workitems", Integer.toString(workItemId), "revisions", WorkItemVersion.VERSION, null, null);

        return MAPPER.mapJsonResponse(r, WorkItemList.class);
    }

    /***
     * Returns the list of fully hydrated work item revisions.
     * @param workItemId The id of the work item
     * @param expand The expand parameters for work item attributes.
     * Possible options are { None, Relations, Fields, Links, All }. {@link WorkItemExpand}
     * @return {@link WorkItemList}
     * @throws DefaultParametersException user must instantiate AzDDefaultParameters before calling this method
     * @throws AzDException Exception handler
     */
    @Override
    public WorkItemList getWorkItemRevisions(int workItemId, WorkItemExpand expand) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{put("$expand", expand.toString().toLowerCase());}};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/workitems", Integer.toString(workItemId), "revisions", WorkItemVersion.VERSION, q, null);

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
     * @throws DefaultParametersException user must instantiate AzDDefaultParameters before calling this method
     * @throws AzDException Exception handler
     */
    @Override
    public WorkItemList getWorkItemRevisions(int workItemId, WorkItemExpand expand, int top, int skip) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("$expand", expand.toString().toLowerCase());
            put("$top", top);
            put("$skip", skip);
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/workitems", Integer.toString(workItemId), "revisions", WorkItemVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, WorkItemList.class);
    }

    /***
     * Returns a fully hydrated work item for the requested revision
     * @param workItemId The id of the work item
     * @param revisionNumber The work item revision number
     * @return {@link WorkItem}
     * @throws DefaultParametersException user must instantiate AzDDefaultParameters before calling this method
     * @throws AzDException Exception handler
     */
    @Override
    public WorkItem getWorkItemRevision(int workItemId, int revisionNumber) throws DefaultParametersException, AzDException {
        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/workitems", Integer.toString(workItemId), "revisions/" + revisionNumber,
                WorkItemVersion.VERSION, null, null);

        return MAPPER.mapJsonResponse(r, WorkItem.class);
    }

    /***
     * Returns a fully hydrated work item for the requested revision
     * @param workItemId The id of the work item
     * @param revisionNumber The work item revision number
     * @param expand The expand parameters for work item attributes.
     * Possible options are { None, Relations, Fields, Links, All }. {@link WorkItemExpand}
     * @return {@link WorkItem}
     * @throws DefaultParametersException user must instantiate AzDDefaultParameters before calling this method
     * @throws AzDException Exception handler
     */
    @Override
    public WorkItem getWorkItemRevision(int workItemId, int revisionNumber, WorkItemExpand expand) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{put("$expand", expand.toString().toLowerCase());}};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/workitems", Integer.toString(workItemId), "revisions/" + revisionNumber,
                WorkItemVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, WorkItem.class);
    }

    /***
     * Gets the results of the query given its WIQL.
     * @param team Team ID or team name
     * @param query Specify the query to list the work items. E.g., "Select * From WorkItems Where [System.WorkItemType] = 'User Story'"
     * @return WorkItemQueryResult {@link WorkItemQueryResult}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public WorkItemQueryResult queryByWiql(String team, String query) throws DefaultParametersException, AzDException {
        var body = new HashMap<String, Object>(){{put("query", query);}};

        String r = request(RequestMethod.POST, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject() + "/" + encodeSpace(team),
                AREA, null, "wiql", WorkItemVersion.WIQL_VERSION, null, body);

        return MAPPER.mapJsonResponse(r, WorkItemQueryResult.class);
    }

    /***
     * Gets the results of the query given its WIQL.
     * @param team Team ID or team name
     * @param query Specify the query to list the work items. E.g., "Select * From WorkItems Where [System.WorkItemType] = 'User Story'"
     * @param top The max number of results to return.
     * @param timePrecision The max number of results to return.
     * @return WorkItemQueryResult {@link WorkItemQueryResult}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public WorkItemQueryResult queryByWiql(String team, String query, int top, boolean timePrecision) throws DefaultParametersException, AzDException {
        var body = new HashMap<String, Object>(){{put("query", query);}};

        var q = new HashMap<String, Object>(){{
            put("$top", top);
            put("timePrecision", timePrecision);
        }};

        String r = request(RequestMethod.POST, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject() + "/" + encodeSpace(team),
                AREA, null, "wiql", WorkItemVersion.WIQL_VERSION, q, body);

        return MAPPER.mapJsonResponse(r, WorkItemQueryResult.class);
    }

    /***
     * Destroys the specified work item permanently from the Recycle Bin. This action can not be undone.
     * @param id ID of the work item to be destroyed permanently
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public void removeWorkItemFromRecycleBin(int id) throws DefaultParametersException, AzDException {
        try {
            String r = request(RequestMethod.DELETE, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                    AREA + "/recyclebin", Integer.toString(id), null, WorkItemVersion.RECYCLE_BIN_VERSION, null, null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (DefaultParametersException | AzDException e) {
            throw e;
        }
    }

    /***
     * Gets a deleted work item from Recycle Bin.
     * @param id ID of the work item to be returned
     * @return WorkItemDeleteReference {@link WorkItemDeleteReference}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public WorkItemDeleteReference getWorkItemFromRecycleBin(int id) throws DefaultParametersException, AzDException {
        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/recyclebin", Integer.toString(id), null, WorkItemVersion.RECYCLE_BIN_VERSION, null, null);

        return MAPPER.mapJsonResponse(r, WorkItemDeleteReference.class);
    }

    /***
     * Gets a list of the IDs and the URLs of the deleted the work items in the Recycle Bin.
     * @return WorkItemDeleteShallowReferences {@link WorkItemDeleteShallowReferences}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public WorkItemDeleteShallowReferences getDeletedWorkItemsFromRecycleBin() throws DefaultParametersException, AzDException {
        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/recyclebin", null, null, WorkItemVersion.RECYCLE_BIN_VERSION, null, null);

        return MAPPER.mapJsonResponse(r, WorkItemDeleteShallowReferences.class);
    }

    /***
     * Gets the work items from the recycle bin, whose IDs have been specified in the parameters
     * @param ids array of workitem ids
     * @return WorkItemDeleteReferences {@link WorkItemDeleteReferences}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public WorkItemDeleteReferences getDeletedWorkItemsFromRecycleBin(int[] ids) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
           put("ids", intArrayToString(ids));
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/recyclebin", null, null, WorkItemVersion.RECYCLE_BIN_VERSION, q, null);

        return MAPPER.mapJsonResponse(r, WorkItemDeleteReferences.class);
    }

    /***
     * Restores the deleted work item from Recycle Bin.
     * @param id ID of the work item to be restored
     * @return WorkItemDeleteReference {@link WorkItemDeleteReference}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public WorkItemDeleteReference restoreWorkItemFromRecycleBin(int id) throws DefaultParametersException, AzDException {
        var b = new HashMap<String, Object>(){{
            put("isDeleted", false);
        }};

        String r = request(RequestMethod.PATCH, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/recyclebin", Integer.toString(id), null, WorkItemVersion.RECYCLE_BIN_VERSION, null, b);

        return MAPPER.mapJsonResponse(r, WorkItemDeleteReference.class);
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
