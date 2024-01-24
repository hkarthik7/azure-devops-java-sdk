package org.azd.featuremanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.ContributedFeatureEnabledValue;

/**
 * A contributed feature/state pair
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContributedFeatureState extends SerializableEntity {
    /**
     * The full contribution id of the feature
     */
    @JsonProperty("featureId")
    private String featureId;
    /**
     * True if the effective state was set by an override rule (indicating that the state cannot be managed by the end user)
     */
    @JsonProperty("overridden")
    private boolean overridden;
    /**
     * Reason that the state was set (by a plugin/rule).
     */
    @JsonProperty("reason")
    private String reason;
    /**
     * The scope at which this state applies
     */
    @JsonProperty("scope")
    private ContributedFeatureSettingScope scope;
    /**
     * The current state of this feature
     */
    @JsonProperty("state")
    private ContributedFeatureEnabledValue state;

    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }

    public boolean isOverridden() {
        return overridden;
    }

    public void setOverridden(boolean overridden) {
        this.overridden = overridden;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ContributedFeatureSettingScope getScope() {
        return scope;
    }

    public void setScope(ContributedFeatureSettingScope scope) {
        this.scope = scope;
    }

    public ContributedFeatureEnabledValue getState() {
        return state;
    }

    public void setState(ContributedFeatureEnabledValue state) {
        this.state = state;
    }
}
