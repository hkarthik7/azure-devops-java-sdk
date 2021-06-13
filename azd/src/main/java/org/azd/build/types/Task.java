package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Task {
    @JsonProperty("id")
    private String id;
    @JsonProperty("versionSpec")
    private String versionSpec;
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
