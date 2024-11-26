package org.azd.servicehooks.types;
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
 * An expression which can be applied to filter a list of subscription inputs 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputFilter extends SerializableEntity {
	/**
 	* Groups of input filter expressions. This filter matches a set of inputs if any (one or more) of the groups evaluates to true. 
	**/
	@JsonProperty("conditions")
	private List<InputFilterCondition> conditions;

	public List<InputFilterCondition> getConditions() { return conditions; }

	public void setConditions(List<InputFilterCondition> conditions) { this.conditions = conditions; }

}