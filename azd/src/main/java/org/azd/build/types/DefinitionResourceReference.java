package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Definition resource
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DefinitionResourceReference extends SerializableEntity {
    /**
     * Indicates whether the resource is authorized for use.
     */
    @JsonProperty("authorized")
    private boolean authorized;
    /**
     * The id of the resource.
     */
    @JsonProperty("id")
    private String id;
    /**
     * A friendly name for the resource.
     */
    @JsonProperty("name")
    private String name;
    /**
     * The type of the resource.
     */
    @JsonProperty("type")
    private String type;

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
