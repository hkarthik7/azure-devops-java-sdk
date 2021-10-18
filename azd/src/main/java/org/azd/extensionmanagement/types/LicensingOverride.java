package org.azd.extensionmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Maps a contribution to a licensing behavior
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LicensingOverride {
    /***
     * How the inclusion of this contribution should change based on licensing
     */
    @JsonProperty("behavior")
    private String behavior;
    /***
     * Fully qualified contribution id which we want to define licensing behavior for
     */
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
