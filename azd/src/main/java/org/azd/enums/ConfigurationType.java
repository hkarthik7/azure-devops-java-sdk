package org.azd.enums;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Type of configuration. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ConfigurationType {
	/**
 	* Designer-JSON. 
	**/
	@JsonProperty("designerHyphenJson")
	DESIGNER_HYPHEN_JSON,
	/**
 	* Designer JSON. 
	**/
	@JsonProperty("designerJson")
	DESIGNER_JSON,
	/**
 	* Just-in-time. 
	**/
	@JsonProperty("justInTime")
	JUST_IN_TIME,
	/**
 	* Unknown type. 
	**/
	@JsonProperty("unknown")
	UNKNOWN,
	/**
 	* YAML. 
	**/
	@JsonProperty("yaml")
	YAML;

	@Override
	public String toString() {
		return this.name().toLowerCase().replaceAll("_", "");
	}
}