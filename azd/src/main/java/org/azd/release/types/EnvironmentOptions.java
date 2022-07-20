package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Gets environment options.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnvironmentOptions {
    @JsonProperty("emailNotificationType")
    private String emailNotificationType;
    @JsonProperty("emailRecipients")
    private String emailRecipients;
    @JsonProperty("skipArtifactsDownload")
    private boolean skipArtifactsDownload;
    @JsonProperty("timeoutInMinutes")
    private int timeoutInMinutes;
    @JsonProperty("enableAccessToken")
    private boolean enableAccessToken;
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

    public String getEmailNotificationType() {
        return emailNotificationType;
    }

    public void setEmailNotificationType(String emailNotificationType) {
        this.emailNotificationType = emailNotificationType;
    }

    public String getEmailRecipients() {
        return emailRecipients;
    }

    public void setEmailRecipients(String emailRecipients) {
        this.emailRecipients = emailRecipients;
    }

    public boolean isSkipArtifactsDownload() {
        return skipArtifactsDownload;
    }

    public void setSkipArtifactsDownload(boolean skipArtifactsDownload) {
        this.skipArtifactsDownload = skipArtifactsDownload;
    }

    public int getTimeoutInMinutes() {
        return timeoutInMinutes;
    }

    public void setTimeoutInMinutes(int timeoutInMinutes) {
        this.timeoutInMinutes = timeoutInMinutes;
    }

    public boolean isEnableAccessToken() {
        return enableAccessToken;
    }

    public void setEnableAccessToken(boolean enableAccessToken) {
        this.enableAccessToken = enableAccessToken;
    }

    @Override
    public String toString() {
        return "EnvironmentOptions{" +
                "emailNotificationType='" + emailNotificationType + '\'' +
                ", emailRecipients='" + emailRecipients + '\'' +
                ", skipArtifactsDownload=" + skipArtifactsDownload +
                ", timeoutInMinutes=" + timeoutInMinutes +
                ", enableAccessToken=" + enableAccessToken +
                ", autoLinkWorkItems=" + autoLinkWorkItems +
                ", badgeEnabled=" + badgeEnabled +
                ", publishDeploymentStatus=" + publishDeploymentStatus +
                ", pullRequestDeploymentEnabled=" + pullRequestDeploymentEnabled +
                '}';
    }

}
