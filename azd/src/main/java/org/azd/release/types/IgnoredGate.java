package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class IgnoredGate {
	/**
 	* Gets the date on which gate is last ignored. 
	**/
	@JsonProperty("lastModifiedOn")
	private String lastModifiedOn;
	/**
 	* Name of gate ignored. 
	**/
	@JsonProperty("name")
	private String name;

	public String getLastModifiedOn() { return lastModifiedOn; }

	public void setLastModifiedOn(String lastModifiedOn) { this.lastModifiedOn = lastModifiedOn; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	@Override
	public String toString() { 
	return 	"IgnoredGate{" +
		"lastModifiedOn='" + lastModifiedOn + '\'' +
		",name='" + name + '\'' +
		'}';
	}
}