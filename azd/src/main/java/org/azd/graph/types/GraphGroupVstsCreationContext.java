package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Use this type to create a new Vsts group that is not backed by an external provider.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphGroupVstsCreationContext extends GraphGroupCreationContext {
    /**
     * Used by VSTS groups; if set this will be the group description, otherwise ignored
     */
    @JsonProperty("description")
    public String description;
    /**
     * Used by VSTS groups; if set this will be the group DisplayName, otherwise ignored
     */
    @JsonProperty("displayName")
    public String displayName;
}
