package org.azd.maven.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Upstream source definition, including its Identity, package type, and other
 * associated information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpstreamSourceInfo extends BaseAbstractMethod {

    /***
     * Locator for connecting to the upstream source in a user friendly format, that
     * may potentially change over time.
     */
    @JsonProperty("displayLocation")
    private String displayLocation;

    /***
     * Identity of the upstream source.
     */
    @JsonProperty("id")
    private String id;

    /***
     * Locator for connecting to the upstream source.
     */
    @JsonProperty("location")
    private String location;

    /***
     * Display name.
     */
    @JsonProperty("name")
    private String name;

    /***
     * Source type, such as Public or Internal.
     */
    @JsonProperty("sourceType")
    private PackagingSourceType sourceType;

    public String getDisplayLocation() {
        return displayLocation;
    }

    public void setDisplayLocation(String displayLocation) {
        this.displayLocation = displayLocation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PackagingSourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(PackagingSourceType sourceType) {
        this.sourceType = sourceType;
    }


}
