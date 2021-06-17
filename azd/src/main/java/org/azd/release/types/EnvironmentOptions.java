package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EnvironmentOptions {
    @JsonProperty("autoLinkWorkItems")
    private boolean autoLinkWorkItems;
    @JsonProperty("badgeEnabled")
    private boolean badgeEnabled;
    @JsonProperty("publishDeploymentStatus")
    private boolean publishDeploymentStatus;
    @JsonProperty("pullRequestDeploymentEnabled")
    private boolean pullRequestDeploymentEnabled;

    public boolean isAutoLinkWorkItems() {
        return autoLinkWorkItems;
    }

    public void setAutoLinkWorkItems(boolean autoLinkWorkItems) {
        this.autoLinkWorkItems = autoLinkWorkItems;
    }

    public boolean isBadgeEnabled() {
        return badgeEnabled;
    }

    public void setBadgeEnabled(boolean badgeEnabled) {
        this.badgeEnabled = badgeEnabled;
    }

    public boolean isPublishDeploymentStatus() {
        return publishDeploymentStatus;
    }

    public void setPublishDeploymentStatus(boolean publishDeploymentStatus) {
        this.publishDeploymentStatus = publishDeploymentStatus;
    }

    public boolean isPullRequestDeploymentEnabled() {
        return pullRequestDeploymentEnabled;
    }

    public void setPullRequestDeploymentEnabled(boolean pullRequestDeploymentEnabled) {
        this.pullRequestDeploymentEnabled = pullRequestDeploymentEnabled;
    }

    @Override
    public String toString() {
        return "EnvironmentOptions{" +
                "autoLinkWorkItems=" + autoLinkWorkItems +
                ", badgeEnabled=" + badgeEnabled +
                ", publishDeploymentStatus=" + publishDeploymentStatus +
                ", pullRequestDeploymentEnabled=" + pullRequestDeploymentEnabled +
                '}';
    }
}
