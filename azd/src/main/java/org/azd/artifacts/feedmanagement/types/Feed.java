package org.azd.artifacts.feedmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.definitions.ReferenceLinks;
import org.azd.core.types.Project;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Feed {
    @JsonProperty("description")
    private String description;
    @JsonProperty("url")
    private String url;
    @JsonProperty("_links")
    private ReferenceLinks _links;
    @JsonProperty("hideDeletedPackageVersions")
    private boolean hideDeletedPackageVersions;
    @JsonProperty("defaultViewId")
    private String defaultViewId;
    @JsonProperty("badgesEnabled")
    private boolean badgesEnabled;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("upstreamEnabled")
    private boolean upstreamEnabled;
    @JsonProperty("viewId")
    private String viewId;
    @JsonProperty("viewName")
    private String viewName;
    @JsonProperty("fullyQualifiedName")
    private String fullyQualifiedName;
    @JsonProperty("fullyQualifiedId")
    private String fullyQualifiedId;
    @JsonProperty("upstreamSources")
    private List<UpstreamSources> upstreamSources;
    @JsonProperty("capabilities")
    private String capabilities;
    @JsonProperty("project")
    private Project project;

    public ReferenceLinks get_links() {
        return _links;
    }

    public void set_links(ReferenceLinks _links) {
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
                "description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", _links=" + _links +
                ", hideDeletedPackageVersions=" + hideDeletedPackageVersions +
                ", defaultViewId='" + defaultViewId + '\'' +
                ", badgesEnabled=" + badgesEnabled +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", upstreamEnabled=" + upstreamEnabled +
                ", viewId='" + viewId + '\'' +
                ", viewName='" + viewName + '\'' +
                ", fullyQualifiedName='" + fullyQualifiedName + '\'' +
                ", fullyQualifiedId='" + fullyQualifiedId + '\'' +
                ", upstreamSources=" + upstreamSources +
                ", capabilities='" + capabilities + '\'' +
                ", project=" + project +
                '}';
    }
}
