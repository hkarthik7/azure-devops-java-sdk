package org.azd.memberentitlementmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Project Group (e.g. Contributor, Reader etc.)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Group extends BaseAbstractMethod {
    /***
     * Display Name of the Group
     */
    @JsonProperty("displayName")
    private String displayName;
    /***
     * Group Type
     */
    @JsonProperty("groupType")
    private String groupType;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

}
