package org.azd.extensionmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LicensingOverride {
    @JsonProperty("behavior")
    private String behavior;
    @JsonProperty("id")
    private String id;

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LicensingOverride{" +
                "behavior=" + behavior +
                ", id='" + id + '\'' +
                '}';
    }
}
