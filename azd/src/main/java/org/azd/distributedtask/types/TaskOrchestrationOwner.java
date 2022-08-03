package org.azd.distributedtask.types;
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
public class TaskOrchestrationOwner extends BaseAbstractMethod {
	/**
 	* The class to represent a collection of REST reference links. 
	**/
	@JsonProperty("_links")
	private Object _links;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("name")
	private String name;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

}
