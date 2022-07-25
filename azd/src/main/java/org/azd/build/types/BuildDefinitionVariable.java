package org.azd.build.types;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents metadata about builds in the system. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildDefinitionVariable {
    /**
     * Indicates whether the value can be set at queue time.
     **/
    @JsonProperty("allowOverride")
    private Boolean allowOverride;
    /**
     * Indicates whether the variable's value is a secret.
     **/
    @JsonProperty("isSecret")
    private Boolean isSecret;
    /**
     * The value of the variable.
     **/
    @JsonProperty("value")
    private String value;

    public Boolean getAllowOverride() {
        return allowOverride;
    }

    public void setAllowOverride(Boolean allowOverride) {
        this.allowOverride = allowOverride;
    }

    public Boolean getIsSecret() {
        return isSecret;
    }

    public void setIsSecret(Boolean isSecret) {
        this.isSecret = isSecret;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BuildDefinitionVariable{" +
                "allowOverride=" + allowOverride +
                ", isSecret=" + isSecret +
                ", value='" + value + '\'' +
                '}';
    }
}