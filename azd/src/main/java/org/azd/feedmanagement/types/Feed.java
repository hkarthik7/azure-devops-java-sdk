package org.azd.feedmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.ReferenceLinks;
import org.azd.core.types.Project;
import java.lang.String;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Feed {
    @JsonProperty("_links")
    private FeedReferenceLinks _links;
    @JsonProperty("badgesEnabled")
    private boolean badgesEnabled;
    @JsonProperty("capabilities")
    private String capabilities;
    @JsonProperty("defaultViewId")
    private String defaultViewId;
    @JsonProperty("deletedDate")
    private String deletedDate;
    @JsonProperty("description")
    private String description;
    @JsonProperty("fullyQualifiedId")
    private String fullyQualifiedId;
    @JsonProperty("fullyQualifiedName")
    private String fullyQualifiedName;
    @JsonProperty("hideDeletedPackageVersions")
    private boolean hideDeletedPackageVersions;
    @JsonProperty("id")
    private String id;
    @JsonProperty("isReadOnly")
    private boolean isReadOnly;
    @JsonProperty("name")
    private String name;
    @JsonProperty("permanentDeletedDate")
    private String permanentDeletedDate;
    @JsonProperty("permissions")
    private FeedPermissions permissions;
    @JsonProperty("project")
    private Project project;
    @JsonProperty("scheduledPermanentDeleteDate")
    private String scheduledPermanentDeleteDate;
    @JsonProperty("upstreamEnabled")
    private boolean upstreamEnabled;
    @JsonProperty("upstreamEnabledChangedDate")
    private String upstreamEnabledChangedDate;
    @JsonProperty("upstreamSources")
    private List<UpstreamSources> upstreamSources;
    @JsonProperty("url")
    private String url;
    @JsonProperty("view")
    private FeedView view;
    @JsonProperty("viewId")
    private String viewId;
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

    public FeedPermissions getPermissions() {
        return permissions;
    }

    public void setPermissions(FeedPermissions permissions) {
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

    public void setDescription(String description) { this.description = description; }

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

    public boolean isUpstreamEnabled() {
        return upstreamEnabled;
    }

    public void setUpstreamEnabled(boolean upstreamEnabled) {
        this.upstreamEnabled = upstreamEnabled;
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
                ", upstreamEnabled=" + upstreamEnabled +
                ", upstreamEnabledChangedDate='" + upstreamEnabledChangedDate + '\'' +
                ", upstreamSources=" + upstreamSources +
                ", url='" + url + '\'' +
                ", view=" + view +
                ", viewId='" + viewId + '\'' +
                ", viewName='" + viewName + '\'' +
                '}';
    }
}
