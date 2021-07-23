package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Gets environment options.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnvironmentOptions {
    /***
     * Gets and sets as the auto link workitems or not.
     */
    @JsonProperty("autoLinkWorkItems")
    private boolean autoLinkWorkItems;
    /***
     * Gets and sets as the badge enabled or not.
     */
    @JsonProperty("badgeEnabled")
    private boolean badgeEnabled;
    /***
     * Gets and sets as the publish deployment status or not.
     */
    @JsonProperty("publishDeploymentStatus")
    private boolean publishDeploymentStatus;
    /***
     * Gets and sets as the.pull request deployment enabled or not.
     */
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
