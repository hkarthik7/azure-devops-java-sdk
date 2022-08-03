package org.azd.build.types;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * Represents metadata about builds in the system. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildDefinitionVariable extends BaseAbstractMethod {
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
}
