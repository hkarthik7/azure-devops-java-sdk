package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Represents a task in a step
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task {
    /***
     * Task id
     */
    @JsonProperty("id")
    private String id;
    /***
     * Task version specification
     */
    @JsonProperty("versionSpec")
    private String versionSpec;
    /***
     * Definition type
     */
    @JsonProperty("definitionType")
    private String definitionType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersionSpec() {
        return versionSpec;
    }

    public void setVersionSpec(String versionSpec) {
        this.versionSpec = versionSpec;
    }

    public String getDefinitionType() {
        return definitionType;
    }

    public void setDefinitionType(String definitionType) {
        this.definitionType = definitionType;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", versionSpec='" + versionSpec + '\'' +
                ", definitionType='" + definitionType + '\'' +
                '}';
    }
}
