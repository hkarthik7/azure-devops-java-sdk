package org.azd.pipelines.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * Collection of ResourcePipelinePermission
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourcePipelinePermissions extends SerializableEntity {
    /**
     * Collection of ResourcePipelinePermission
     */
    @JsonProperty("value")
    private List<ResourcePipelinePermission> resourcePipelinePermissions;

    public List<ResourcePipelinePermission> getResourcePipelinePermissions() {
        return resourcePipelinePermissions;
    }

    public void setResourcePipelinePermissions(List<ResourcePipelinePermission> resourcePipelinePermissions) {
        this.resourcePipelinePermissions = resourcePipelinePermissions;
    }
}
