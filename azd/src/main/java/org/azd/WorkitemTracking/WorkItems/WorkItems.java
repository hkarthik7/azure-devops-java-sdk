package org.azd.WorkitemTracking.WorkItems;

import org.azd.WorkitemTracking.types.WorkItem;
import org.azd.WorkitemTracking.types.WorkItemDelete;
import org.azd.WorkitemTracking.types.WorkItemList;
import org.azd.enums.WorkItemErrorPolicy;
import org.azd.enums.WorkItemExpand;
import org.azd.enums.WorkItemOperation;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.WorkItemDetails;
import org.azd.utils.AzDDefaultParameters;
import org.azd.utils.Request;
import org.azd.utils.RequestMethod;
import org.azd.utils.ResourceId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.azd.helpers.URLHelper.encodeSpace;

public class WorkItems implements WorkItemDetails {
    /***
     * Instance of AzDDefaultParameters
     */
    private final AzDDefaultParameters DEFAULT_PARAMETERS;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "wit/workitems";


    /***
     * Instantiate the class with instance of AzDDefaultParameters
     * @param defaultParameters instance of AzDDefaultParameters
     */
    public WorkItems(AzDDefaultParameters defaultParameters) { this.DEFAULT_PARAMETERS = defaultParameters; }

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

        String r = Request.request(RequestMethod.POST, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA,  null, "$"+ encodeSpace(workItemType), WorkItemVersion.VERSION, null, null, List.of(req), null);

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

        String r = Request.request(RequestMethod.POST, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA,  null, "$"+ encodeSpace(workItemType), WorkItemVersion.VERSION, null, null, req, null);

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
        String r = Request.request(RequestMethod.DELETE, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA,  String.valueOf(id),null , WorkItemVersion.VERSION, null, null);

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

        String r = Request.request(RequestMethod.DELETE, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA,  String.valueOf(id),null , WorkItemVersion.VERSION, q, null);

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
        String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA, Integer.toString(id), null, WorkItemVersion.VERSION, null, null);

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

        String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA, Integer.toString(id), null, WorkItemVersion.VERSION, q, null);

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

        String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA, Integer.toString(id), null, WorkItemVersion.VERSION, q, null);

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

        String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA, Integer.toString(id), null, WorkItemVersion.VERSION, q, null);

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

        String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA, Integer.toString(id), null, WorkItemVersion.VERSION, q, null);

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

        String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA, null, null, WorkItemVersion.VERSION, q, null);

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

        String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA, null, null, WorkItemVersion.VERSION, q, null);

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

        String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA, null, null, WorkItemVersion.VERSION, q, null);

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

        String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA, null, null, WorkItemVersion.VERSION, q, null);

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

        String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA, null, null, WorkItemVersion.VERSION, q, null);

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
        String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA, Integer.toString(workItemId), "revisions", WorkItemVersion.VERSION, null, null);

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

        String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA, Integer.toString(workItemId), "revisions", WorkItemVersion.VERSION, q, null);

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

        String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA, Integer.toString(workItemId), "revisions", WorkItemVersion.VERSION, q, null);

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
        String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA, Integer.toString(workItemId), "revisions/" + revisionNumber,
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

        String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.WIT, DEFAULT_PARAMETERS.getProject(),
                AREA, Integer.toString(workItemId), "revisions/" + revisionNumber,
                WorkItemVersion.VERSION, q, null);

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
