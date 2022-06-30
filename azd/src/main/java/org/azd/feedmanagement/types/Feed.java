package org.azd.feedmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.core.types.Project;

import java.util.List;

/***
 * A container for artifacts.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Feed {
    /***
     * Related REST links.
     */
    @JsonProperty("_links")
    private FeedReferenceLinks _links;
    /***
     * If set, this feed supports generation of package badges.
     */
    @JsonProperty("badgesEnabled")
    private boolean badgesEnabled;
    /***
     * Supported capabilities of a feed. {@link org.azd.enums.FeedCapabilities}
     */
    @JsonProperty("capabilities")
    private String capabilities;
    /***
     * The view that the feed administrator has indicated is the default experience for readers.
     */
    @JsonProperty("defaultViewId")
    private String defaultViewId;
    /***
     * The date that this feed was deleted.
     */
    @JsonProperty("deletedDate")
    private String deletedDate;
    /***
     * A description for the feed. Descriptions must not exceed 255 characters.
     */
    @JsonProperty("description")
    private String description;
    /***
     * This will either be the feed GUID or the feed GUID and view GUID depending on how the feed was accessed.
     */
    @JsonProperty("fullyQualifiedId")
    private String fullyQualifiedId;
    /***
     * Full name of the view, in feed@view format.
     */
    @JsonProperty("fullyQualifiedName")
    private String fullyQualifiedName;
    /***
     * If set, the feed will hide all deleted/unpublished versions
     */
    @JsonProperty("hideDeletedPackageVersions")
    private boolean hideDeletedPackageVersions;
    /***
     * A GUID that uniquely identifies this feed.
     */
    @JsonProperty("id")
    private String id;
    /***
     * If set, all packages in the feed are immutable.
     * It is important to note that feed views are immutable; therefore, this flag will always be set for views.
     */
    @JsonProperty("isReadOnly")
    private boolean isReadOnly;
    /***
     * A name for the feed. feed names must follow these rules:
     * Must not exceed 64 characters Must not contain whitespaces Must not start with an underscore or
     * a period Must not end with a period Must not contain any of the following illegal
     * characters: , |, /, \\, ?, :, &, $, *, \", #, [, ] ]]>
     */
    @JsonProperty("name")
    private String name;
    /***
     * The date that this feed was permanently deleted.
     */
    @JsonProperty("permanentDeletedDate")
    private String permanentDeletedDate;
    /***
     *
     */
    @JsonProperty("permissions")
    private List<FeedPermission> permissions;
    /***
     * The project that this feed is associated with.
     */
    @JsonProperty("project")
    private Project project;
    /***
     * The date that this feed is scheduled to be permanently deleted.
     */
    @JsonProperty("scheduledPermanentDeleteDate")
    private String scheduledPermanentDeleteDate;
    /***
     * If set, time that the UpstreamEnabled property was changed. Will be null if UpstreamEnabled was never changed after Feed creation.
     */
    @JsonProperty("upstreamEnabledChangedDate")
    private String upstreamEnabledChangedDate;
    /***
     * A list of sources that this feed will fetch packages from. An empty list indicates that this feed will not search any additional sources for packages.
     */
    @JsonProperty("upstreamSources")
    private List<UpstreamSources> upstreamSources;
    /***
     * The URL of the base feed in GUID form.
     */
    @JsonProperty("url")
    private String url;
    /***
     * Definition of the view.
     */
    @JsonProperty("view")
    private FeedView view;
    /***
     * View Id.
     */
    @JsonProperty("viewId")
    private String viewId;
    /***
     * View name.
     */
    @JsonProperty("viewName")
    private String viewName;


    public String getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(String deletedDate) {
        this.deletedDate = deletedDate;
    }

    public boolean isReadOnly() {
        return isReadOnly;
    }

    public void setReadOnly(boolean readOnly) {
        isReadOnly = readOnly;
    }

    public String getPermanentDeletedDate() {
        return permanentDeletedDate;
    }

    public void setPermanentDeletedDate(String permanentDeletedDate) {
        this.permanentDeletedDate = permanentDeletedDate;
    }

    public List<FeedPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<FeedPermission> permissions) {
        this.permissions = permissions;
    }

    public String getScheduledPermanentDeleteDate() {
        return scheduledPermanentDeleteDate;
    }

    public void setScheduledPermanentDeleteDate(String scheduledPermanentDeleteDate) {
        this.scheduledPermanentDeleteDate = scheduledPermanentDeleteDate;
    }

    public String getUpstreamEnabledChangedDate() {
        return upstreamEnabledChangedDate;
    }

    public void setUpstreamEnabledChangedDate(String upstreamEnabledChangedDate) {
        this.upstreamEnabledChangedDate = upstreamEnabledChangedDate;
    }

    public FeedView getView() {
        return view;
    }

    public void setView(FeedView view) {
        this.view = view;
    }

    public FeedReferenceLinks get_links() {
        return _links;
    }

    public void set_links(FeedReferenceLinks _links) {
        this._links = _links;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isHideDeletedPackageVersions() {
        return hideDeletedPackageVersions;
    }

    public void setHideDeletedPackageVersions(boolean hideDeletedPackageVersions) {
        this.hideDeletedPackageVersions = hideDeletedPackageVersions;
    }

    public String getDefaultViewId() {
        return defaultViewId;
    }

    public void setDefaultViewId(String defaultViewId) {
        this.defaultViewId = defaultViewId;
    }

    public boolean isBadgesEnabled() {
        return badgesEnabled;
    }

    public void setBadgesEnabled(boolean badgesEnabled) {
        this.badgesEnabled = badgesEnabled;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getViewId() {
        return viewId;
    }

    public void setViewId(String viewId) {
        this.viewId = viewId;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public String getFullyQualifiedName() {
        return fullyQualifiedName;
    }

    public void setFullyQualifiedName(String fullyQualifiedName) {
        this.fullyQualifiedName = fullyQualifiedName;
    }

    public String getFullyQualifiedId() {
        return fullyQualifiedId;
    }

    public void setFullyQualifiedId(String fullyQualifiedId) {
        this.fullyQualifiedId = fullyQualifiedId;
    }

    public List<UpstreamSources> getUpstreamSources() {
        return upstreamSources;
    }

    public void setUpstreamSources(List<UpstreamSources> upstreamSources) {
        this.upstreamSources = upstreamSources;
    }

    public String getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(String capabilities) {
        this.capabilities = capabilities;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "_links=" + _links +
                ", badgesEnabled=" + badgesEnabled +
                ", capabilities='" + capabilities + '\'' +
                ", defaultViewId='" + defaultViewId + '\'' +
                ", deletedDate='" + deletedDate + '\'' +
                ", description='" + description + '\'' +
                ", fullyQualifiedId='" + fullyQualifiedId + '\'' +
                ", fullyQualifiedName='" + fullyQualifiedName + '\'' +
                ", hideDeletedPackageVersions=" + hideDeletedPackageVersions +
                ", id='" + id + '\'' +
                ", isReadOnly=" + isReadOnly +
                ", name='" + name + '\'' +
                ", permanentDeletedDate='" + permanentDeletedDate + '\'' +
                ", permissions=" + permissions +
                ", project=" + project +
                ", scheduledPermanentDeleteDate='" + scheduledPermanentDeleteDate + '\'' +
                ", upstreamEnabledChangedDate='" + upstreamEnabledChangedDate + '\'' +
                ", upstreamSources=" + upstreamSources +
                ", url='" + url + '\'' +
                ", view=" + view +
                ", viewId='" + viewId + '\'' +
                ", viewName='" + viewName + '\'' +
                '}';
    }
}
