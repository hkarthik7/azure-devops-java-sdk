package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The link query mode. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum LinkQueryMode {
	/**
 	* Returns work items that satisfy the source, only if no linked work item satisfies the link and target criteria. 
	**/
	@JsonProperty("linksOneHopDoesNotContain")
	LINKSONEHOPDOESNOTCONTAIN,
	/**
 	* Returns work items that satisfy the source and link criteria, even if no linked work item satisfies the target criteria. 
	**/
	@JsonProperty("linksOneHopMayContain")
	LINKSONEHOPMAYCONTAIN,
	/**
 	* Returns work items where the source, target, and link criteria are all satisfied. 
	**/
	@JsonProperty("linksOneHopMustContain")
	LINKSONEHOPMUSTCONTAIN,

	@JsonProperty("linksRecursiveDoesNotContain")
	LINKSRECURSIVEDOESNOTCONTAIN,
	/**
 	* Returns work items a hierarchy of work items that by default satisfy the source 
	**/
	@JsonProperty("linksRecursiveMayContain")
	LINKSRECURSIVEMAYCONTAIN,

	@JsonProperty("linksRecursiveMustContain")
	LINKSRECURSIVEMUSTCONTAIN,
	/**
 	* Returns flat list of work items. 
	**/
	@JsonProperty("workItems")
	WORKITEMS;
}