package org.azd.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Represents the Api location response.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiLocation extends SerializableEntity {
    /**
     * Represents the id of the location.
     */
    @JsonProperty("id")
    public String id;
    /**
     * Represents the service area.
     */
    @JsonProperty("area")
    public String area;
    /**
     * Represents the resource name.
     */
    @JsonProperty("resourceName")
    public String resourceName;
    /**
     * Represents the route template value.
     */
    @JsonProperty("routeTemplate")
    public String routeTemplate;
    /**
     * Resource that represents preview of the api version.
     */
    @JsonProperty("resourceVersion")
    public int resourceVersion;
    /**
     * Minimum api version required.
     */
    @JsonProperty("minVersion")
    public String minVersion;
    /**
     * Maximum Api version required.
     */
    @JsonProperty("maxVersion")
    public String maxVersion;
    /**
     * Released Api version.
     */
    @JsonProperty("releasedVersion")
    public String releasedVersion;
}
