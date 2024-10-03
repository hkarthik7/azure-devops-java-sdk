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
 * The class to represent a collection of REST reference links. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum InputFilterOperator {
	@JsonProperty("equals")
	EQUALS,
	@JsonProperty("notEquals")
	NOT_EQUALS
}