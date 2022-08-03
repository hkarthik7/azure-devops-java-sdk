package org.azd.workitemtracking.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * Describes a work item field operation. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemFieldOperation extends BaseAbstractMethod {
	/**
 	* Friendly name of the operation. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* Reference name of the operation. 
	**/
	@JsonProperty("referenceName")
	private String referenceName;

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getReferenceName() { return referenceName; }

	public void setReferenceName(String referenceName) { this.referenceName = referenceName; }

}
