package org.azd.memberentitlementmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.graph.types.GraphUser;

import java.util.List;

/***
 * A user entity with additional properties including their license, extensions, and project membership
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserEntitlement extends BaseAbstractMethod {
    /***
     * User's access level denoted by a license.
     */
    @JsonProperty("accessLevel")
    private AccessLevel accessLevel;
    /***
     * Date the user was added to the collection.
     */
    @JsonProperty("dateCreated")
    private String dateCreated;
    /***
     * GroupEntitlements that this user belongs to.
     */
    @JsonProperty("groupAssignments")
    private List<GroupEntitlement> groupAssignments;
    /***
     * The unique identifier which matches the Id of the Identity associated with the GraphMember.
     */
    @JsonProperty("id")
    private String id;
    /***
     * Date the user last accessed the collection.
     */
    @JsonProperty("lastAccessedDate")
    private String lastAccessedDate;
    /***
     * Relation between a project and the user's effective permissions in that project.
     */
    @JsonProperty("projectEntitlements")
    private List<ProjectEntitlement> projectEntitlements;
    /***
     * User reference.
     */
    @JsonProperty("user")
    private GraphUser user;

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<GroupEntitlement> getGroupAssignments() {
        return groupAssignments;
    }

    public void setGroupAssignments(List<GroupEntitlement> groupAssignments) {
        this.groupAssignments = groupAssignments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastAccessedDate() {
        return lastAccessedDate;
    }

    public void setLastAccessedDate(String lastAccessedDate) {
        this.lastAccessedDate = lastAccessedDate;
    }

    public List<ProjectEntitlement> getProjectEntitlements() {
        return projectEntitlements;
    }

    public void setProjectEntitlements(List<ProjectEntitlement> projectEntitlements) {
        this.projectEntitlements = projectEntitlements;
    }

    public GraphUser getUser() {
        return user;
    }

    public void setUser(GraphUser user) {
        this.user = user;
    }

}
