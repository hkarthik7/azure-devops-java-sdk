package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The usage of the field. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum FieldUsage {
	/**
 	* Empty usage. 
	**/
	@JsonProperty("none")
	NONE,
	/**
 	* Treenode field usage. 
	**/
	@JsonProperty("tree")
	TREE,
	/**
 	* Work item field usage. 
	**/
	@JsonProperty("workItem")
	WORKITEM,
	/**
 	* Work item link field usage. 
	**/
	@JsonProperty("workItemLink")
	WORKITEMLINK,
	/**
 	* Work Item Type Extension usage. 
	**/
	@JsonProperty("workItemTypeExtension")
	WORKITEMTYPEEXTENSION;
}