package org.azd.memberentitlementmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * Summary of licenses and extensions assigned to users in the organization
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersSummary extends BaseAbstractMethod {
    /***
     * Available Access Levels
     */
    @JsonProperty("availableAccessLevels")
    private List<AccessLevel> availableAccessLevels;
    /***
     * Default Access Level
     */
    @JsonProperty("defaultAccessLevel")
    private AccessLevel defaultAccessLevel;
    /***
     * Group Options
     */
    @JsonProperty("groupOptions")
    private List<GroupOptions> groupOptions;
    /***
     * Summary of Licenses in the organization
     */
    @JsonProperty("licenses")
    private List<LicenseSummaryData> licenses;
    /***
     * Summary of Projects in the organization
     */
    @JsonProperty("projectRefs")
    private List<ProjectRef> projectRefs;

    public List<AccessLevel> getAvailableAccessLevels() {
        return availableAccessLevels;
    }

    public void setAvailableAccessLevels(List<AccessLevel> availableAccessLevels) {
        this.availableAccessLevels = availableAccessLevels;
    }

    public AccessLevel getDefaultAccessLevel() {
        return defaultAccessLevel;
    }

    public void setDefaultAccessLevel(AccessLevel defaultAccessLevel) {
        this.defaultAccessLevel = defaultAccessLevel;
    }

    public List<GroupOptions> getGroupOptions() {
        return groupOptions;
    }

    public void setGroupOptions(List<GroupOptions> groupOptions) {
        this.groupOptions = groupOptions;
    }

    public List<LicenseSummaryData> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<LicenseSummaryData> licenses) {
        this.licenses = licenses;
    }

    public List<ProjectRef> getProjectRefs() {
        return projectRefs;
    }

    public void setProjectRefs(List<ProjectRef> projectRefs) {
        this.projectRefs = projectRefs;
    }


}
