package org.azd.feedmanagement.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.FeedCapabilities;

import java.util.List;

/**
 * A container for artifacts. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Feed extends BaseAbstractMethod {
	/**
 	* Related REST links. 
	**/
	@JsonProperty("_links")
	private Object _links;
	/**
 	* If set, this feed supports generation of package badges. 
	**/
	@JsonProperty("badgesEnabled")
	private boolean badgesEnabled;
	/**
 	* Supported capabilities of a feed. 
	**/
	@JsonProperty("capabilities")
	private FeedCapabilities capabilities;
	/**
 	* The view that the feed administrator has indicated is the default experience for readers. 
	**/
	@JsonProperty("defaultViewId")
	private String defaultViewId;
	/**
 	* The date that this feed was deleted. 
	**/
	@JsonProperty("deletedDate")
	private String deletedDate;
	/**
 	* A description for the feed.  Descriptions must not exceed 255 characters. 
	**/
	@JsonProperty("description")
	private String description;
	/**
 	* This will either be the feed GUID or the feed GUID and view GUID depending on how the feed was accessed. 
	**/
	@JsonProperty("fullyQualifiedId")
	private String fullyQualifiedId;
	/**
 	* Full name of the view, in feed@view format. 
	**/
	@JsonProperty("fullyQualifiedName")
	private String fullyQualifiedName;
	/**
 	* If set, the feed will hide all deleted/unpublished versions 
	**/
	@JsonProperty("hideDeletedPackageVersions")
	private boolean hideDeletedPackageVersions;
	/**
 	* A GUID that uniquely identifies this feed. 
	**/
	@JsonProperty("id")
	private String id;
	/**
 	* If set, all packages in the feed are immutable.  It is important to note that feed views are immutable; therefore, this flag will always be set for views. 
	**/
	@JsonProperty("isReadOnly")
	private boolean isReadOnly;
	/**
 	* A name for the feed. feed names must follow these rules:  Must not exceed 64 characters  Must not contain whitespaces  Must not start with an underscore or a period  Must not end with a period  Must not contain any of the following illegal characters:  @, ~, ;, {, }, \, +, =, <, >, |, /, \\, ?, :, &, $, *, \", #, [, ] 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* The date that this feed was permanently deleted. 
	**/
	@JsonProperty("permanentDeletedDate")
	private String permanentDeletedDate;
	/**
 	* Explicit permissions for the feed. 
	**/
	@JsonProperty("permissions")
	private List<FeedPermission> permissions;
	/**
 	* The project that this feed is associated with. 
	**/
	@JsonProperty("project")
	private ProjectReference project;
	/**
 	* The date that this feed is scheduled to be permanently deleted. 
	**/
	@JsonProperty("scheduledPermanentDeleteDate")
	private String scheduledPermanentDeleteDate;
	/**
 	* This should always be true. Setting to false will override all sources in UpstreamSources. 
	**/
	@JsonProperty("upstreamEnabled")
	private boolean upstreamEnabled;
	/**
 	* If set, time that the UpstreamEnabled property was changed. Will be null if UpstreamEnabled was never changed after Feed creation. 
	**/
	@JsonProperty("upstreamEnabledChangedDate")
	private String upstreamEnabledChangedDate;
	/**
 	* A list of sources that this feed will fetch packages from.  An empty list indicates that this feed will not search any additional sources for packages. 
	**/
	@JsonProperty("upstreamSources")
	private List<UpstreamSource> upstreamSources;
	/**
 	* The URL of the base feed in GUID form. 
	**/
	@JsonProperty("url")
	private String url;
	/**
 	* Definition of the view. 
	**/
	@JsonProperty("view")
	private FeedView view;
	/**
 	* View Id. 
	**/
	@JsonProperty("viewId")
	private String viewId;
	/**
 	* View name. 
	**/
	@JsonProperty("viewName")
	private String viewName;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public boolean getBadgesEnabled() { return badgesEnabled; }

	public void setBadgesEnabled(boolean badgesEnabled) { this.badgesEnabled = badgesEnabled; }

	public FeedCapabilities getCapabilities() { return capabilities; }

	public void setCapabilities(FeedCapabilities capabilities) { this.capabilities = capabilities; }

	public String getDefaultViewId() { return defaultViewId; }

	public void setDefaultViewId(String defaultViewId) { this.defaultViewId = defaultViewId; }

	public String getDeletedDate() { return deletedDate; }

	public void setDeletedDate(String deletedDate) { this.deletedDate = deletedDate; }

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }

	public String getFullyQualifiedId() { return fullyQualifiedId; }

	public void setFullyQualifiedId(String fullyQualifiedId) { this.fullyQualifiedId = fullyQualifiedId; }

	public String getFullyQualifiedName() { return fullyQualifiedName; }

	public void setFullyQualifiedName(String fullyQualifiedName) { this.fullyQualifiedName = fullyQualifiedName; }

	public boolean getHideDeletedPackageVersions() { return hideDeletedPackageVersions; }

	public void setHideDeletedPackageVersions(boolean hideDeletedPackageVersions) { this.hideDeletedPackageVersions = hideDeletedPackageVersions; }

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public boolean getIsReadOnly() { return isReadOnly; }

	public void setIsReadOnly(boolean isReadOnly) { this.isReadOnly = isReadOnly; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getPermanentDeletedDate() { return permanentDeletedDate; }

	public void setPermanentDeletedDate(String permanentDeletedDate) { this.permanentDeletedDate = permanentDeletedDate; }

	public List<FeedPermission> getPermissions() { return permissions; }

	public void setPermissions(List<FeedPermission> permissions) { this.permissions = permissions; }

	public ProjectReference getProject() { return project; }

	public void setProject(ProjectReference project) { this.project = project; }

	public String getScheduledPermanentDeleteDate() { return scheduledPermanentDeleteDate; }

	public void setScheduledPermanentDeleteDate(String scheduledPermanentDeleteDate) { this.scheduledPermanentDeleteDate = scheduledPermanentDeleteDate; }

	public boolean getUpstreamEnabled() { return upstreamEnabled; }

	public void setUpstreamEnabled(boolean upstreamEnabled) { this.upstreamEnabled = upstreamEnabled; }

	public String getUpstreamEnabledChangedDate() { return upstreamEnabledChangedDate; }

	public void setUpstreamEnabledChangedDate(String upstreamEnabledChangedDate) { this.upstreamEnabledChangedDate = upstreamEnabledChangedDate; }

	public List<UpstreamSource> getUpstreamSources() { return upstreamSources; }

	public void setUpstreamSources(List<UpstreamSource> upstreamSources) { this.upstreamSources = upstreamSources; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

	public FeedView getView() { return view; }

	public void setView(FeedView view) { this.view = view; }

	public String getViewId() { return viewId; }

	public void setViewId(String viewId) { this.viewId = viewId; }

	public String getViewName() { return viewName; }

	public void setViewName(String viewName) { this.viewName = viewName; }
}
