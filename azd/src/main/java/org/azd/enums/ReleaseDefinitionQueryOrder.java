package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ReleaseDefinitionQueryOrder {
	/**
 	* Return results based on release definition Id ascending order. 
	**/
	@JsonProperty("idAscending")
	ID_ASCENDING,
	/**
 	* Return results based on release definition Id descending order. 
	**/
	@JsonProperty("idDescending")
	ID_DESCENDING,
	/**
 	* Return results based on release definition name ascending order. 
	**/
	@JsonProperty("nameAscending")
	NAME_ASCENDING,
	/**
 	* Return results based on release definition name descending order. 
	**/
	@JsonProperty("nameDescending")
	NAME_DESCENDING;
}