package org.azd.graph;

import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;
import org.azd.graph.types.GraphGroup;
import org.azd.graph.types.GraphGroups;
import org.azd.graph.types.GraphUser;
import org.azd.graph.types.GraphUsers;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.GraphDetails;
import org.azd.connection.Connection;
import org.azd.utils.ResourceId;

import java.util.HashMap;
import java.util.Map;

import static org.azd.utils.Client.request;

/***
 * GraphApi class to manage graph users and groups
 */
public class GraphApi implements GraphDetails {
    /***
     * Connection object
     */
    private final Connection CONNECTION;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "graph";

    /***
     * Instantiate the class with instance of AzDDefaultParameters
     * @param connection Connection object
     */
    public GraphApi(Connection connection) { this.CONNECTION = connection; }

    /***
     * Materialize an existing AAD or MSA user into the VSTS account.
     * NOTE: Created users are not active in an account unless they have been explicitly
     * assigned a parent group at creation time or have signed in and been autolicensed through AAD group memberships.
     * Adding a user to an account is required before the user can be added to VSTS groups or assigned an asset.
     * Create a new user using the principal name as a reference to an existing user from an external AD or AAD backed provider.
     * If the user to be added corresponds to a user that was previously deleted, then that user will be restored.
     * @param emailId provide the user principal name (email address) of the user to be added.
     * @param userDescriptor provide the user descriptor for reference
     * @return GraphUser {@link GraphUser}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public GraphUser createUser(String emailId, String userDescriptor) throws DefaultParametersException, AzDException {
        var b = new HashMap<String, Object>(){{
            put("principalName", emailId);
        }};

        String r = request(RequestMethod.POST, CONNECTION, ResourceId.GRAPH, null,
                AREA, null, "users/" + userDescriptor, GraphVersion.VERSION, null, b);

        return MAPPER.mapJsonResponse(r, GraphUser.class);
    }

    /***
     * Materialize an existing AAD or MSA user into the VSTS account. Add the newly created user as a member of an existing VSTS group
     * by providing the group descriptor.
     * @param emailId provide the user principal name (email address) of the user to be added.
     * @param groupDescriptor provide the group descriptor.
     * @return GraphUser {@link GraphUser}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public GraphUser addUserToGroup(String emailId, String groupDescriptor) throws DefaultParametersException, AzDException {
        var b = new HashMap<String, Object>(){{
            put("principalName", emailId);
        }};

        var q = new HashMap<String, Object>(){{
            put("groupDescriptors", groupDescriptor);
        }};

        String r = request(RequestMethod.POST, CONNECTION, ResourceId.GRAPH, null,
                AREA, null, "users", GraphVersion.VERSION, q, b);

        return MAPPER.mapJsonResponse(r, GraphUser.class);
    }

    /***
     * Disables a user. The user will still be visible, but membership checks for the user will return false.”
     * @param userDescriptor The descriptor of the user to delete.
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public void deleteUser(String userDescriptor) throws DefaultParametersException, AzDException {
        try {
            String r = request(RequestMethod.DELETE, CONNECTION, ResourceId.GRAPH, null,
                    AREA, null, "users/" + userDescriptor, GraphVersion.VERSION, null, null);

            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (DefaultParametersException | AzDException e) {
            throw e;
        }
    }

    /***
     * Get a user by its descriptor.
     * @param userDescriptor The descriptor of the desired user.
     * @return GraphUser {@link GraphUser}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public GraphUser getUser(String userDescriptor) throws DefaultParametersException, AzDException {
        String r = request(RequestMethod.GET, CONNECTION, ResourceId.GRAPH, null,
                AREA, null, "users/" + userDescriptor, GraphVersion.VERSION, null, null);

        return MAPPER.mapJsonResponse(r, GraphUser.class);
    }

    /***
     * Get a list of all users in a given scope.
     * @return GraphUsers {@link GraphUsers}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public GraphUsers getUsers() throws DefaultParametersException, AzDException {
        String r = request(RequestMethod.GET, CONNECTION, ResourceId.GRAPH, null,
                AREA, null, "users", GraphVersion.VERSION, null, null);

        return MAPPER.mapJsonResponse(r, GraphUsers.class);
    }

    /***
     *Get a list of all users in a given scope.
     * Since the list of users may be large, results are returned in pages of users.
     * If there are more results than can be returned in a single page, the result set will
     * contain a continuation token for retrieval of the next set of results.
     * @param continuationToken An opaque data blob that allows the next page of data to resume immediately
     * after where the previous page ended. The only reliable way to know if there is more data left is the
     * presence of a continuation token.
     * @param scopeDescriptor Specify a non-default scope (collection, project) to search for users.
     * @param subjectTypes String array of user subject subtypes to reduce the retrieved
     * results, e.g. msa’, ‘aad’, ‘svc’ (service identity), ‘imp’ (imported identity), etc.
     * @return GraphUsers {@link GraphUsers}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public GraphUsers getUsers(String continuationToken, String scopeDescriptor, String subjectTypes) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("subjectTypes", String.join(",", subjectTypes));
            put("continuationToken", continuationToken);
            put("scopeDescriptor", scopeDescriptor);
        }};

        String r = request(RequestMethod.GET, CONNECTION, ResourceId.GRAPH, null,
                AREA, null, "users", GraphVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, GraphUsers.class);
    }

    /***
     * Get a group by its descriptor. The group will be returned even if it has been deleted from the account or has had all its memberships deleted.
     * @param groupDescriptor The descriptor of the desired graph group.
     * @return GraphGroup {@link GraphGroup}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public GraphGroup getGroup(String groupDescriptor) throws DefaultParametersException, AzDException {
        String r = request(RequestMethod.GET, CONNECTION, ResourceId.GRAPH, null,
                AREA, null, "groups/" + groupDescriptor, GraphVersion.VERSION, null, null);

        return MAPPER.mapJsonResponse(r, GraphGroup.class);
    }

    /***
     * Gets a list of all groups in the current scope (usually organization or account).
     * @return GraphGroups {@link GraphGroups}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public GraphGroups getGroups() throws DefaultParametersException, AzDException {
        String r = request(RequestMethod.GET, CONNECTION, ResourceId.GRAPH, null,
                AREA, null, "groups", GraphVersion.VERSION, null, null);

        return MAPPER.mapJsonResponse(r, GraphGroups.class);
    }
}
