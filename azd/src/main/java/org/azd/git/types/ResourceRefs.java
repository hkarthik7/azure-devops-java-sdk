package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

import java.util.List;

/***
 * List of the resource references
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceRefs extends SerializableEntity {
    /***
     * List of the resource references
     */
    @JsonProperty("value")
    private List<ResourceRef> resourceRefs;

    public List<ResourceRef> getResourceRefs() {
        return resourceRefs;
    }

    public void setResourceRefs(List<ResourceRef> resourceRefs) {
        this.resourceRefs = resourceRefs;
    }

}
