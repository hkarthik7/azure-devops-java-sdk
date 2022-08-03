package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * Represents a reference to a task.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskReference extends BaseAbstractMethod {
    /**
     * The ID of the task definition.
     */
    @JsonProperty("id")
    private String id;
    /**
     * The name of the task definition.
     */
    @JsonProperty("name")
    private String name;
    /**
     * The version of the task definition.
     */
    @JsonProperty("version")
    private String version;

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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
