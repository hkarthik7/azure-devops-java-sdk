package org.azd.memberentitlementmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersSummary {
    @JsonProperty("availableAccessLevels")
    private List<AccessLevel> availableAccessLevels;
    @JsonProperty("defaultAccessLevel")
    private AccessLevel defaultAccessLevel;
    @JsonProperty("groupOptions")
    private List<GroupOptions> groupOptions;
    @JsonProperty("licenses")
    private List<LicenseSummaryData> licenses;
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

    @Override
    public String toString() {
        return "UsersSummary{" +
                "availableAccessLevels=" + availableAccessLevels +
                ", defaultAccessLevel=" + defaultAccessLevel +
                ", groupOptions=" + groupOptions +
                ", licenses=" + licenses +
                ", projectRefs=" + projectRefs +
                '}';
    }

}
