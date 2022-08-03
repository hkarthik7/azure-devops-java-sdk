package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * The class represents a property bag as a collection of key-value pairs. Values of all primitive types (any type with a TypeCode != TypeCode.Object) except for DBNull are accepted. Values of type Byte[], Int32, Double, DateType and String preserve their type, other primitives are retuned as a String. Byte[] expected as base64 encoded string. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConditionType extends BaseAbstractMethod {
	/**
 	* The condition type is artifact. 
	**/
	@JsonProperty("artifact")
	private String artifact;
	/**
 	* The condition type is environment state. 
	**/
	@JsonProperty("environmentState")
	private String environmentState;
	/**
 	* The condition type is event. 
	**/
	@JsonProperty("event")
	private String event;
	/**
 	* The condition type is undefined. 
	**/
	@JsonProperty("undefined")
	private String undefined;

	public String getArtifact() { return artifact; }

	public void setArtifact(String artifact) { this.artifact = artifact; }

	public String getEnvironmentState() { return environmentState; }

	public void setEnvironmentState(String environmentState) { this.environmentState = environmentState; }

	public String getEvent() { return event; }

	public void setEvent(String event) { this.event = event; }

	public String getUndefined() { return undefined; }

	public void setUndefined(String undefined) { this.undefined = undefined; }

}
