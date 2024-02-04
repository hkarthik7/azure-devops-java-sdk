package org.azd.helpers.graph;

import org.azd.authentication.AccessTokenCredential;
import org.azd.enums.GraphTraversalDirection;
import org.azd.exceptions.AzDException;
import org.azd.graph.GraphRequestBuilder;
import org.azd.graph.types.*;

import java.util.ArrayList;

/**
 * Helper request builder that combines multiple Apis to create logical helper methods for ease of use.
 */
public class GraphHelpersRequestBuilder extends GraphRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public GraphHelpersRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * Materialize an existing AAD or MSA user into the VSTS account.
     * NOTE: Created users are not active in an account unless they have been explicitly
     * assigned a parent group at creation time or have signed in and been autolicensed through AAD group memberships.
     * Adding a user to an account is required before the user can be added to VSTS groups or assigned an asset.
     * Create a new user using the principal name as a reference to an existing user from an external AD or AAD backed provider.
     * If the user to be added corresponds to a user that was previously deleted, then that user will be restored.
     *
     * @param emailId provide the user principal name (email address) of the user to be added.
     * @return GraphUser {@link GraphUser}
     * @throws AzDException Default Api Exception handler.
     */
    public GraphUser createUser(String emailId) throws AzDException {
        var user = new GraphUserPrincipalNameCreationContext();
        user.principalName = emailId;

        return users().create(user);
    }

    /**
     * Materialize an existing AAD or MSA user into the VSTS account. Add the newly created user as a member of an existing VSTS group
     * by providing the group descriptor.
     *
     * @param emailId         provide the user principal name (email address) of the user to be added.
     * @param groupDescriptor provide the group descriptor.
     * @return GraphUser {@link GraphUser}
     * @throws AzDException Default Api Exception handler.
     */
    public GraphUser addUserToGroup(String emailId, String groupDescriptor) throws AzDException {

        var user = new GraphUserPrincipalNameCreationContext();
        user.principalName = emailId;

        return users().create(user, c -> c.queryParameters.groupDescriptors = groupDescriptor);
    }

    /**
     * get subjects (users, groups) that are a member of the specified group
     *
     * @param groupDescriptor The descriptor of the container group
     * @return GraphMemberships {@link GraphMemberships}
     * @throws AzDException Default Api Exception handler.
     */
    public GraphMemberships getGroupMembersOf(String groupDescriptor) throws AzDException {
        return memberships().list(groupDescriptor, r -> r.queryParameters.direction = GraphTraversalDirection.DOWN);
    }

    /**
     * get groups that the specified subject (user, group) belongs to
     *
     * @param subjectDescriptor The descriptor of the subject (either user or group) that belongs to a container
     * @return GraphMemberships {@link GraphMemberships}
     * @throws AzDException Default Api Exception handler.
     */
    public GraphMemberships getMemberOfGroups(String subjectDescriptor) throws AzDException {
        return memberships().list(subjectDescriptor, r -> r.queryParameters.direction = GraphTraversalDirection.UP);
    }


    /**
     * create a local group at the collection level
     *
     * @param displayName The name of the group
     * @param description A generally more verbose description of the group
     * @return GraphMembership {@link GraphMembership}
     * @throws AzDException Default Api Exception handler.
     */
    public GraphGroup createGroup(String displayName, String description) throws AzDException {
        return createGroup(displayName, description, null);
    }

    /**
     * create a local group at the project level
     *
     * @param displayName The name of the group
     * @param description A generally more verbose description of the group
     * @return GraphMembership {@link GraphMembership}
     * @throws AzDException Default Api Exception handler.
     */
    public GraphGroup createGroup(String displayName, String description, String projectDescriptor) throws AzDException {
        var group = new GraphGroupVstsCreationContext();
        group.description = description;
        group.displayName = displayName;

        return groups().create(group, r -> r.queryParameters.scopeDescriptor = projectDescriptor);
    }

    /**
     * resolve descriptors to subjects
     * <p>
     * Refer to REST API documentation on <a href="https://docs.microsoft.com/en-us/rest/api/azure/devops/graph/?view=azure-devops-rest-7.1#storage-keys">storage keys</a>
     *
     * @param descriptors user and group descriptor strings
     * @return SubjectLookupResponse {@link SubjectLookupResponse}
     * @throws AzDException Default Api Exception handler.
     */
    public SubjectLookupResponse subjectLookup(String... descriptors) throws AzDException {
        var subjectLookup = new GraphSubjectLookup();
        var subjectLookupKeys = new ArrayList<GraphSubjectLookupKey>();
        for (var descriptor : descriptors)
            subjectLookupKeys.add(new GraphSubjectLookupKey(descriptor));
        subjectLookup.setLookupKeys(subjectLookupKeys);

        return subjectLookup().lookup(subjectLookup);
    }
}
