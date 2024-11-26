package org.azd.featuremanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * The scope to which a feature setting applies
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContributedFeatureSettingScope extends SerializableEntity {
    /**
     * The name of the settings scope to use when reading/writing the setting
     */
    @JsonProperty("userScoped")
    private boolean userScoped;
    /**
     * Whether this is a user-scope or this is a host-wide (all users) setting
     */
    @JsonProperty("settingScope")
    private String settingScope;

    public boolean isUserScoped() {
        return userScoped;
    }

    public void setUserScoped(boolean userScoped) {
        this.userScoped = userScoped;
    }

    public String getSettingScope() {
        return settingScope;
    }

    public void setSettingScope(String settingScope) {
        this.settingScope = settingScope;
    }
}
