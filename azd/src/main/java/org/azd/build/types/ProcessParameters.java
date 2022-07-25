package org.azd.build.types;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * Additional options for queueing the build. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcessParameters {
    /**
     * Represents binding of data source for the service endpoint request.
     **/
    @JsonProperty("dataSourceBindings")
    private DataSourceBindingBase[] dataSourceBindings;

    @JsonProperty("inputs")
    private TaskInputDefinitionBase[] inputs;

    @JsonProperty("sourceDefinitions")
    private TaskSourceDefinitionBase[] sourceDefinitions;

    public DataSourceBindingBase[] getDataSourceBindings() {
        return dataSourceBindings;
    }

    public void setDataSourceBindings(DataSourceBindingBase[] dataSourceBindings) {
        this.dataSourceBindings = dataSourceBindings;
    }

    public TaskInputDefinitionBase[] getInputs() {
        return inputs;
    }

    public void setInputs(TaskInputDefinitionBase[] inputs) {
        this.inputs = inputs;
    }

    public TaskSourceDefinitionBase[] getSourceDefinitions() {
        return sourceDefinitions;
    }

    public void setSourceDefinitions(TaskSourceDefinitionBase[] sourceDefinitions) {
        this.sourceDefinitions = sourceDefinitions;
    }

    @Override
    public String toString() {
        return "ProcessParameters{" +
                "dataSourceBindings=" + Arrays.toString(dataSourceBindings) +
                ", inputs=" + Arrays.toString(inputs) +
                ", sourceDefinitions=" + Arrays.toString(sourceDefinitions) +
                '}';
    }
}