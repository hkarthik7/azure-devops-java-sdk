package org.azd.memberentitlementmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Group option to add a user to
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupOptions extends BaseAbstractMethod {
    /***
     * Access Level
     */
    @JsonProperty("accessLevel")
    private AccessLevel accessLevel;
    /***
     * Group
     */
    @JsonProperty("group")
    private Group group;

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

}
