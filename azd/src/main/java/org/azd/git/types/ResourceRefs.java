package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceRefs {
    @JsonProperty("value")
    private List<ResourceRef> resourceRefs;

    public List<ResourceRef> getResourceRefs() {
        return resourceRefs;
    }

    public void setResourceRefs(List<ResourceRef> resourceRefs) {
        this.resourceRefs = resourceRefs;
    }

    @Override
    public String toString() {
        return "ResourceRefs{" +
                "resourceRefs=" + resourceRefs +
                '}';
    }
}
