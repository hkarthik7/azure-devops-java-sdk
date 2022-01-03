package org.azd.distributedtask.types;

import org.azd.enums.VariableGroupType;
import org.azd.release.types.ProjectReference;

import java.util.Map;

public class VariableGroupDefinition {
    private String name;
    private String description;
    private VariableGroupType type;
    private Map variables;
    private VariableGroupProviderData providerData;
    private ProjectReference projectReference;

    public ProjectReference getProjectReference() {
        return projectReference;
    }

    public void setProjectReference(ProjectReference projectReference) {
        this.projectReference = projectReference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public VariableGroupType getType() {
        return type;
    }

    public void setType(VariableGroupType type) {
        this.type = type;
    }

    public Map getVariables() {
        return variables;
    }

    public void setVariables(Map variables) {
        this.variables = variables;
    }

    public VariableGroupProviderData getProviderData() {
        return providerData;
    }

    public void setProviderData(VariableGroupProviderData providerData) {
        this.providerData = providerData;
    }

    @Override
    public String toString() {
        return "VariableGroupDefinition{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", variables=" + variables +
                ", providerData=" + providerData +
                ", projectReference=" + projectReference +
                '}';
    }
}
