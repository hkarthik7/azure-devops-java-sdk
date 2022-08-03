package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.Optional;

/***
 * data object representing project feature
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectFeature extends BaseAbstractMethod {
    /***
     * string identifier for feature. See {@link org.azd.enums.FeatureManagement} for in-library usage
     */
    @JsonProperty("featureId")
    String featureId;
    /***
     * current state of feature in project. This is one of 'enabled', 'disabled', or 'undefined'
     * Call to set feature state in a '0' or '1' instead
     */
    @JsonProperty("state")
    String state;
    /***
     * presumably the applicable scope of feature. Not documented so ignore
     */
    @JsonProperty("scope")
    Scope scope;

    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Optional<Boolean> getStateAsBoolean() {
        if (state == null) {
            return Optional.empty();
        }
        if (state.equals("enabled") || state.equals("1")) {
            return Optional.of(Boolean.TRUE);
        } else if (state.equals("disabled") || state.equals("0")) {
            return Optional.of(Boolean.FALSE);
        }
        return Optional.empty();
    }

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Scope extends BaseAbstractMethod {
        /***
         * scope value. Undocumented in Azdo api
         */
        @JsonProperty("userScoped")
        boolean userScoped;
        /***
         * scope setting. Undocumented in Azdo api
         */
        @JsonProperty("settingScope")
        String settingScope;

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
}
