package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcessParameters {
	/**
 	* Represents binding of data source for the service endpoint request. 
	**/
	@JsonProperty("dataSourceBindings")
	private List<DataSourceBindingBase> dataSourceBindings;

	@JsonProperty("inputs")
	private List<TaskInputDefinitionBase> inputs;

	@JsonProperty("sourceDefinitions")
	private List<TaskSourceDefinitionBase> sourceDefinitions;

	public List<DataSourceBindingBase> getDataSourceBindings() { return dataSourceBindings; }

	public void setDataSourceBindings(List<DataSourceBindingBase> dataSourceBindings) { this.dataSourceBindings = dataSourceBindings; }

	public List<TaskInputDefinitionBase> getInputs() { return inputs; }

	public void setInputs(List<TaskInputDefinitionBase> inputs) { this.inputs = inputs; }

	public List<TaskSourceDefinitionBase> getSourceDefinitions() { return sourceDefinitions; }

	public void setSourceDefinitions(List<TaskSourceDefinitionBase> sourceDefinitions) { this.sourceDefinitions = sourceDefinitions; }

	@Override
	public String toString() { 
	return 	"ProcessParameters{" +
		"dataSourceBindings='" + dataSourceBindings + '\'' +
		",inputs='" + inputs + '\'' +
		",sourceDefinitions='" + sourceDefinitions + '\'' +
		'}';
	}
}