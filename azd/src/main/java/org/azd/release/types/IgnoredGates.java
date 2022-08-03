package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Ignored gates.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IgnoredGates extends BaseAbstractMethod {
    /***
     * Gets the date on which gate is last ignored.
     */
    @JsonProperty("lastModifiedOn")
    private String lastModifiedOn;
    /***
     * Name of gate ignored.
     */
    @JsonProperty("name")
    private String name;

    public String getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(String lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
