package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.release.types.ProjectReference;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VariableGroupProjectReference {
    @JsonProperty("description")
    private String description;
    @JsonProperty("name")
    private String name;
    @JsonProperty("projectReference")
    private ProjectReference projectReference;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProjectReference getProjectReference() {
        return projectReference;
    }

    public void setProjectReference(ProjectReference projectReference) {
        this.projectReference = projectReference;
    }

    @Override
    public String toString() {
        return "VariableGroupProjectReferences{" +
                "description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", projectReference=" + projectReference +
                '}';
    }
}
