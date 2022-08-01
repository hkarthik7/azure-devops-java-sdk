package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type of query. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum QueryType {
	/**
 	* Gets a flat list of work items. 
	**/
	@JsonProperty("flat")
	FLAT,
	/**
 	* Gets a list of work items and their direct links. 
	**/
	@JsonProperty("oneHop")
	ONEHOP,
	/**
 	* Gets a tree of work items showing their link hierarchy. 
	**/
	@JsonProperty("tree")
	TREE;
}