package org.azd.workitemtracking.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * Field Instance of a workItemype with detailed references. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemTypeFieldWithReference extends SerializableEntity {
	/**
 	* The list of field allowed values. 
	**/
	@JsonProperty("allowedValues")
	private List<Object> allowedValues;
	/**
 	* Indicates whether field value is always required. 
	**/
	@JsonProperty("alwaysRequired")
	private boolean alwaysRequired;
	/**
 	* Represents the default value of the field. 
	**/
	@JsonProperty("defaultValue")
	private Object defaultValue;
	/**
 	* The list of dependent fields. 
	**/
	@JsonProperty("dependentFields")
	private List<WorkItemFieldReference> dependentFields;
	/**
 	* Gets the help text for the field. 
	**/
	@JsonProperty("helpText")
	private String helpText;
	/**
 	* The friendly name of the field. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* The reference name of the field. 
	**/
	@JsonProperty("referenceName")
	private String referenceName;
	/**
 	* The REST URL of the resource. 
	**/
	@JsonProperty("url")
	private String url;

	public List<Object> getAllowedValues() { return allowedValues; }

	public void setAllowedValues(List<Object> allowedValues) { this.allowedValues = allowedValues; }

	public boolean getAlwaysRequired() { return alwaysRequired; }

	public void setAlwaysRequired(boolean alwaysRequired) { this.alwaysRequired = alwaysRequired; }

	public Object getDefaultValue() { return defaultValue; }

	public void setDefaultValue(Object defaultValue) { this.defaultValue = defaultValue; }

	public List<WorkItemFieldReference> getDependentFields() { return dependentFields; }

	public void setDependentFields(List<WorkItemFieldReference> dependentFields) { this.dependentFields = dependentFields; }

	public String getHelpText() { return helpText; }

	public void setHelpText(String helpText) { this.helpText = helpText; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getReferenceName() { return referenceName; }

	public void setReferenceName(String referenceName) { this.referenceName = referenceName; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

}