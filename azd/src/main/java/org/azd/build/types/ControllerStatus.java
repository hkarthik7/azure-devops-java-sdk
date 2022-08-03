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
 * The quality of the definition document (draft, etc.) 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ControllerStatus extends BaseAbstractMethod {
    /**
     * Indicates that the build controller is currently available.
     **/
    @JsonProperty("available")
    private String available;
    /**
     * Indicates that the build controller has taken itself offline.
     **/
    @JsonProperty("offline")
    private String offline;
    /**
     * Indicates that the build controller cannot be contacted.
     **/
    @JsonProperty("unavailable")
    private String unavailable;

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getOffline() {
        return offline;
    }

    public void setOffline(String offline) {
        this.offline = offline;
    }

    public String getUnavailable() {
        return unavailable;
    }

    public void setUnavailable(String unavailable) {
        this.unavailable = unavailable;
    }

}
