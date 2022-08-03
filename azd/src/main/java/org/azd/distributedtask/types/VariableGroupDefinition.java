package org.azd.distributedtask.types;

import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.VariableGroupType;
import org.azd.enums.VariableValue;
import org.azd.release.types.ProjectReference;

import java.util.Map;

/***
 * Represents the request body for adding and updating a variable group.
 */
public class VariableGroupDefinition extends BaseAbstractMethod {
    /***
     * Sets name of the variable group.
     */
    private String name;
    /***
     * Sets description of the variable group.
     */
    private String description;
    /***
     * Sets type of the variable group.
     */
    private VariableGroupType type;
    /***
     * Sets variables contained in the variable group.
     */
    private Map<String, VariableValue> variables;
    /***
     * Sets provider data.
     */
    private VariableGroupProviderData providerData;
    /***
     * A shallow reference of project.
     */
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

    public Map<String, VariableValue> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, VariableValue> variables) {
        this.variables = variables;
    }

    public VariableGroupProviderData getProviderData() {
        return providerData;
    }

    public void setProviderData(VariableGroupProviderData providerData) {
        this.providerData = providerData;
    }

}
