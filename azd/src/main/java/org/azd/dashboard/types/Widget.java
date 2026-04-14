package org.azd.dashboard.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * Widget data.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Widget extends SerializableEntity {
    /**
     * Refers to the allowed sizes for the widget. This gets populated when user wants to configure the widget.
     */
    @JsonProperty("allowedSizes")
    private List<WidgetSize> allowedSizes;
    /**
     * Read-Only Property from Dashboard Service. Indicates if settings are blocked for the current user.
     */
    @JsonProperty("areSettingsBlockedForUser")
    private Boolean areSettingsBlockedForUser;
    /**
     * Refers to unique identifier of a feature artifact. Used for pinning+unpinning a specific artifact.
     */
    @JsonProperty("artifactId")
    private String artifactId;
    /**
     * The id of the underlying contribution defining the supplied Widget Configuration.
     */
    @JsonProperty("configurationContributionId")
    private String configurationContributionId;
    /**
     * Optional partial relative id of the contribution providing configuration for the widget.
     */
    @JsonProperty("configurationContributionRelativeId")
    private String configurationContributionRelativeId;
    /**
     * The content URI for the widget.
     */
    @JsonProperty("contentUri")
    private String contentUri;
    /**
     * The contribution ID of the widget.
     */
    @JsonProperty("contributionId")
    private String contributionId;
    /**
     * Optional partial dashboard content, to support exchanging dashboard-level version ETag for widget-level APIs.
     */
    @JsonProperty("dashboard")
    private Dashboard dashboard;
    /**
     * Server defined version tracking value.
     */
    @JsonProperty("eTag")
    private String eTag;
    /**
     * ID of the widget.
     */
    @JsonProperty("id")
    private String id;
    /**
     * Is the widget enabled.
     */
    @JsonProperty("isEnabled")
    private Boolean isEnabled;
    /**
     * Is the widget name configurable.
     */
    @JsonProperty("isNameConfigurable")
    private Boolean isNameConfigurable;
    /**
     * Lightbox configuration.
     */
    @JsonProperty("lightboxOptions")
    private LightboxOptions lightboxOptions;
    /**
     * Loading image URL.
     */
    @JsonProperty("loadingImageUrl")
    private String loadingImageUrl;
    /**
     * Name of the widget.
     */
    @JsonProperty("name")
    private String name;
    /**
     * Position of the widget.
     */
    @JsonProperty("position")
    private WidgetPosition position;
    /**
     * Settings for the widget.
     */
    @JsonProperty("settings")
    private String settings;
    /**
     * Settings version.
     */
    @JsonProperty("settingsVersion")
    private SemanticVersion settingsVersion;
    /**
     * Size of the widget.
     */
    @JsonProperty("size")
    private WidgetSize size;
    /**
     * Type ID of the widget.
     */
    @JsonProperty("typeId")
    private String typeId;
    /**
     * URL of the widget.
     */
    @JsonProperty("url")
    private String url;
    /**
     * Links
     */
    @JsonProperty("_links")
    private Object links;

    public List<WidgetSize> getAllowedSizes() {
        return allowedSizes;
    }

    public void setAllowedSizes(List<WidgetSize> allowedSizes) {
        this.allowedSizes = allowedSizes;
    }

    public Boolean getAreSettingsBlockedForUser() {
        return areSettingsBlockedForUser;
    }

    public void setAreSettingsBlockedForUser(Boolean areSettingsBlockedForUser) {
        this.areSettingsBlockedForUser = areSettingsBlockedForUser;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getConfigurationContributionId() {
        return configurationContributionId;
    }

    public void setConfigurationContributionId(String configurationContributionId) {
        this.configurationContributionId = configurationContributionId;
    }

    public String getConfigurationContributionRelativeId() {
        return configurationContributionRelativeId;
    }

    public void setConfigurationContributionRelativeId(String configurationContributionRelativeId) {
        this.configurationContributionRelativeId = configurationContributionRelativeId;
    }

    public String getContentUri() {
        return contentUri;
    }

    public void setContentUri(String contentUri) {
        this.contentUri = contentUri;
    }

    public String getContributionId() {
        return contributionId;
    }

    public void setContributionId(String contributionId) {
        this.contributionId = contributionId;
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    public String getETag() {
        return eTag;
    }

    public void setETag(String eTag) {
        this.eTag = eTag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Boolean getIsNameConfigurable() {
        return isNameConfigurable;
    }

    public void setIsNameConfigurable(Boolean isNameConfigurable) {
        this.isNameConfigurable = isNameConfigurable;
    }

    public LightboxOptions getLightboxOptions() {
        return lightboxOptions;
    }

    public void setLightboxOptions(LightboxOptions lightboxOptions) {
        this.lightboxOptions = lightboxOptions;
    }

    public String getLoadingImageUrl() {
        return loadingImageUrl;
    }

    public void setLoadingImageUrl(String loadingImageUrl) {
        this.loadingImageUrl = loadingImageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WidgetPosition getPosition() {
        return position;
    }

    public void setPosition(WidgetPosition position) {
        this.position = position;
    }

    public String getSettings() {
        return settings;
    }

    public void setSettings(String settings) {
        this.settings = settings;
    }

    public SemanticVersion getSettingsVersion() {
        return settingsVersion;
    }

    public void setSettingsVersion(SemanticVersion settingsVersion) {
        this.settingsVersion = settingsVersion;
    }

    public WidgetSize getSize() {
        return size;
    }

    public void setSize(WidgetSize size) {
        this.size = size;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getLinks() {
        return links;
    }

    public void setLinks(Object links) {
        this.links = links;
    }
}
