package org.azd.pipelines.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Variable
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Variable extends SerializableEntity {

	@JsonProperty("isSecret")
	private Boolean isSecret;

	@JsonProperty("value")
	private String value;

	public Boolean getIsSecret() { return isSecret; }

	public void setIsSecret(Boolean isSecret) { this.isSecret = isSecret; }

	public String getValue() { return value; }

	public void setValue(String value) { this.value = value; }

}