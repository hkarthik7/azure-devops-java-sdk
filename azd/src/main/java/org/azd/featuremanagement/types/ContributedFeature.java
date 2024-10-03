package org.azd.featuremanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * A feature that can be enabled or disabled
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContributedFeature extends SerializableEntity {
    /**
     * The full contribution id of the feature
     */
    @JsonProperty("id")
    private String id;
    /**
     * The friendly name of the feature
     */
    @JsonProperty("name")
    private String name;
    /**
     * The description of the feature
     */
    @JsonProperty("description")
    private String description;
    /**
     * Named links describing the feature
     */
    @JsonProperty("_links")
    private Object links;
    /**
     * The scopes/levels at which settings can set the enabled/disabled state of this feature
     */
    @JsonProperty("scopes")
    private List<ContributedFeatureSettingScope> scopes;
    /**
     * If true, the feature is enabled unless overridden at some scope
     */
    @JsonProperty("defaultState")
    private boolean defaultState;
    /**
     * If this is set to true, then the id for this feature will be added to the list of claims for the request.
     */
    @JsonProperty("includeAsClaim")
    private boolean includeAsClaim;
    /**
     * Tags associated with the feature.
     */
    @JsonProperty("tags")
    private List<String> tags;
    /**
     * Suggested order to display feature in.
     */
    @JsonProperty("order")
    private int order;
    /**
     * Extra properties for the feature
     */
    @JsonProperty("featureProperties")
    private FeatureProperties featureProperties;
    /**
     * Rules for setting the default value if not specified by any setting/scope. Evaluated in order until a rule
     * returns an Enabled or Disabled state (not Undefined)
     */
    @JsonProperty("defaultValueRules")
    private List<ContributedFeatureValueRule> defaultValueRules;
    /**
     * Handler for listening to setter calls on feature value. These listeners are only invoked after a successful set has occurred
     */
    @JsonProperty("featureStateChangedListeners")
    private List<ContributedFeatureListener> featureStateChangedListeners;
    /**
     * The service instance id of the service that owns this feature
     */
    @JsonProperty("serviceInstanceType")
    private String serviceInstanceType;
    /**
     * Rules for overriding a feature value. These rules are run before explicit user/host state values are checked.
     * They are evaluated in order until a rule returns an Enabled or Disabled state (not Undefined)
     */
    @JsonProperty("overrideRules")
    private List<ContributedFeatureValueRule> overrideRules;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getLinks() {
        return links;
    }

    public void setLinks(Object links) {
        this.links = links;
    }

    public List<ContributedFeatureSettingScope> getScopes() {
        return scopes;
    }

    public void setScopes(List<ContributedFeatureSettingScope> scopes) {
        this.scopes = scopes;
    }

    public boolean isDefaultState() {
        return defaultState;
    }

    public void setDefaultState(boolean defaultState) {
        this.defaultState = defaultState;
    }

    public boolean isIncludeAsClaim() {
        return includeAsClaim;
    }

    public void setIncludeAsClaim(boolean includeAsClaim) {
        this.includeAsClaim = includeAsClaim;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public FeatureProperties getFeatureProperties() {
        return featureProperties;
    }

    public void setFeatureProperties(FeatureProperties featureProperties) {
        this.featureProperties = featureProperties;
    }

    public List<ContributedFeatureValueRule> getDefaultValueRules() {
        return defaultValueRules;
    }

    public void setDefaultValueRules(List<ContributedFeatureValueRule> defaultValueRules) {
        this.defaultValueRules = defaultValueRules;
    }

    public List<ContributedFeatureListener> getFeatureStateChangedListeners() {
        return featureStateChangedListeners;
    }

    public void setFeatureStateChangedListeners(List<ContributedFeatureListener> featureStateChangedListeners) {
        this.featureStateChangedListeners = featureStateChangedListeners;
    }

    public List<ContributedFeatureValueRule> getOverrideRules() {
        return overrideRules;
    }

    public void setOverrideRules(List<ContributedFeatureValueRule> overrideRules) {
        this.overrideRules = overrideRules;
    }

    public String getServiceInstanceType() {
        return serviceInstanceType;
    }

    public void setServiceInstanceType(String serviceInstanceType) {
        this.serviceInstanceType = serviceInstanceType;
    }
}
