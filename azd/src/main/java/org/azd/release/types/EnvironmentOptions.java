package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnvironmentOptions extends BaseAbstractMethod {
	/**
 	* Gets and sets as the auto link workitems or not. 
	**/
	@JsonProperty("autoLinkWorkItems")
	private boolean autoLinkWorkItems;
	/**
 	* Gets and sets as the badge enabled or not. 
	**/
	@JsonProperty("badgeEnabled")
	private boolean badgeEnabled;
	/**
 	* Gets and sets as the publish deployment status or not. 
	**/
	@JsonProperty("publishDeploymentStatus")
	private boolean publishDeploymentStatus;
	/**
 	* Gets and sets as the.pull request deployment enabled or not. 
	**/
	@JsonProperty("pullRequestDeploymentEnabled")
	private boolean pullRequestDeploymentEnabled;

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

	public boolean getAutoLinkWorkItems() { return autoLinkWorkItems; }

	public void setAutoLinkWorkItems(boolean autoLinkWorkItems) { this.autoLinkWorkItems = autoLinkWorkItems; }

	public boolean getBadgeEnabled() { return badgeEnabled; }

	public void setBadgeEnabled(boolean badgeEnabled) { this.badgeEnabled = badgeEnabled; }

	public boolean getPublishDeploymentStatus() { return publishDeploymentStatus; }

	public void setPublishDeploymentStatus(boolean publishDeploymentStatus) { this.publishDeploymentStatus = publishDeploymentStatus; }

	public boolean getPullRequestDeploymentEnabled() { return pullRequestDeploymentEnabled; }

	public void setPullRequestDeploymentEnabled(boolean pullRequestDeploymentEnabled) { this.pullRequestDeploymentEnabled = pullRequestDeploymentEnabled; }

}
