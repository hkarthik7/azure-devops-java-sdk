package org.azd.dashboard.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * Contribution based information describing Dashboard Widgets.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WidgetMetadata extends SerializableEntity {
    /**
     * Sizes supported by the Widget.
     */
    @JsonProperty("allowedSizes")
    private List<WidgetSize> allowedSizes;
    /**
     * Opt-in boolean that indicates if the widget requires the Analytics Service to function.
     * Widgets that have this set to true will not be allowed in dashboards for different scope levels.
     */
    @JsonProperty("analyticsServiceRequired")
    private Boolean analyticsServiceRequired;
    /**
     * Resource for an icon in the widget catalog.
     */
    @JsonProperty("catalogIconUrl")
    private String catalogIconUrl;
    /**
     * Opt-in URL string pointing at widget information. Defaults to extension marketplace URL if available
     */
    @JsonProperty("catalogInfoUrl")
    private String catalogInfoUrl;
    /**
     * The id of the underlying contribution defining the supplied Widget custom configuration UI.
     */
    @JsonProperty("configurationContributionId")
    private String configurationContributionId;
    /**
     * Optional relative id of the contribution providing configuration for the widget.
     */
    @JsonProperty("configurationContributionRelativeId")
    private String configurationContributionRelativeId;
    /**
     * Indicates if the widget requires configuration for it to be useful.
     */
    @JsonProperty("configurationRequired")
    private Boolean configurationRequired;
    /**
     * Contribution ID.
     */
    @JsonProperty("contributionId")
    private String contributionId;
    /**
     * The content URI for the widget.
     */
    @JsonProperty("contentUri")
    private String contentUri;
    /**
     * Optional description for the widget.
     */
    @JsonProperty("description")
    private String description;
    /**
     * Indicates whether the widget is enabled.
     */
    @JsonProperty("isEnabled")
    private Boolean isEnabled;
    /**
     * Is the widget name configurable.
     */
    @JsonProperty("isNameConfigurable")
    private Boolean isNameConfigurable;
    /**
     * Indicates if the widget is visible from the widget catalog in the add widget dialog.
     */
    @JsonProperty("isVisibleFromCatalog")
    private Boolean isVisibleFromCatalog;
    /**
     * Lightbox options.
     */
    @JsonProperty("lightboxOptions")
    private LightboxOptions lightboxOptions;
    /**
     * Loading image URL.
     */
    @JsonProperty("loadingImageUrl")
    private String loadingImageUrl;
    /**
     * Widget name.
     */
    @JsonProperty("name")
    private String name;
    /**
     * Publisher name.
     */
    @JsonProperty("publisherName")
    private String publisherName;
    /**
     * Data contract required for the widget to function in a webaccess area or page.
     */
    @JsonProperty("supportedScopes")
    private List<String> supportedScopes;
    /**
     * Tags for the widget.
     */
    @JsonProperty("tags")
    private List<String> tags;
    /**
     * Contribution target IDs.
     */
    @JsonProperty("targets")
    private List<String> targets;
    /**
     * Type ID for the widget.
     */
    @JsonProperty("typeId")
    private String typeId;

    public List<WidgetSize> getAllowedSizes() {
        return allowedSizes;
    }

    public void setAllowedSizes(List<WidgetSize> allowedSizes) {
        this.allowedSizes = allowedSizes;
    }

    public Boolean getAnalyticsServiceRequired() {
        return analyticsServiceRequired;
    }

    public void setAnalyticsServiceRequired(Boolean analyticsServiceRequired) {
        this.analyticsServiceRequired = analyticsServiceRequired;
    }

    public String getCatalogIconUrl() {
        return catalogIconUrl;
    }

    public void setCatalogIconUrl(String catalogIconUrl) {
        this.catalogIconUrl = catalogIconUrl;
    }

    public String getCatalogInfoUrl() {
        return catalogInfoUrl;
    }

    public void setCatalogInfoUrl(String catalogInfoUrl) {
        this.catalogInfoUrl = catalogInfoUrl;
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

    public Boolean getConfigurationRequired() {
        return configurationRequired;
    }

    public void setConfigurationRequired(Boolean configurationRequired) {
        this.configurationRequired = configurationRequired;
    }

    public String getContributionId() {
        return contributionId;
    }

    public void setContributionId(String contributionId) {
        this.contributionId = contributionId;
    }

    public String getContentUri() {
        return contentUri;
    }

    public void setContentUri(String contentUri) {
        this.contentUri = contentUri;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Boolean getIsVisibleFromCatalog() {
        return isVisibleFromCatalog;
    }

    public void setIsVisibleFromCatalog(Boolean isVisibleFromCatalog) {
        this.isVisibleFromCatalog = isVisibleFromCatalog;
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

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public List<String> getSupportedScopes() {
        return supportedScopes;
    }

    public void setSupportedScopes(List<String> supportedScopes) {
        this.supportedScopes = supportedScopes;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getTargets() {
        return targets;
    }

    public void setTargets(List<String> targets) {
        this.targets = targets;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
}
