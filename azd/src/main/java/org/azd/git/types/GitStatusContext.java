package org.azd.git.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * The type of change that was made to the item. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitStatusContext extends BaseAbstractMethod {
	/**
 	* Genre of the status. Typically name of the service/tool generating the status, can be empty. 
	**/
	@JsonProperty("genre")
	private String genre;
	/**
 	* Name identifier of the status, cannot be null or empty. 
	**/
	@JsonProperty("name")
	private String name;

	public String getGenre() { return genre; }

	public void setGenre(String genre) { this.genre = genre; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

}
