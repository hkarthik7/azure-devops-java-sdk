package org.azd.pipelines.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.Map;

/**
 * Settings which influence pipeline runs.
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class RunPipelineParameters extends SerializableEntity {
	/**
 	* If true, don't actually create a new run. Instead, return the final YAML document after parsing templates. 
	**/
	@JsonProperty("previewRun")
	private boolean previewRun;
	/**
 	* The resources the run requires. 
	**/
	@JsonProperty("resources")
	private RunResourcesParameters resources;

	@JsonProperty("stagesToSkip")
	private String[] stagesToSkip;

	@JsonProperty("templateParameters")
	private Object templateParameters;

	@JsonProperty("variables")
	private Map<String, Variable> variables;
	/**
 	* If you use the preview run option, you may optionally supply different YAML. This allows you to preview the final YAML document without committing a changed file. 
	**/
	@JsonProperty("yamlOverride")
	private String yamlOverride;

	public boolean getPreviewRun() { return previewRun; }

	public void setPreviewRun(boolean previewRun) { this.previewRun = previewRun; }

	public RunResourcesParameters getResources() { return resources; }

	public void setResources(RunResourcesParameters resources) { this.resources = resources; }

	public String[] getStagesToSkip() { return stagesToSkip; }

	public void setStagesToSkip(String[] stagesToSkip) { this.stagesToSkip = stagesToSkip; }

	public Object getTemplateParameters() { return templateParameters; }

	public void setTemplateParameters(Object templateParameters) { this.templateParameters = templateParameters; }

	public Map<String, Variable> getVariables() { return variables; }

	public void setVariables(Map<String, Variable> variables) { this.variables = variables; }

	public String getYamlOverride() { return yamlOverride; }

	public void setYamlOverride(String yamlOverride) { this.yamlOverride = yamlOverride; }

}