package org.azd.release.types;
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
public class EnvironmentRetentionPolicy extends BaseAbstractMethod {
	/**
 	* Gets and sets the number of days to keep environment. 
	**/
	@JsonProperty("daysToKeep")
	private Integer daysToKeep;
	/**
 	* Gets and sets the number of releases to keep. 
	**/
	@JsonProperty("releasesToKeep")
	private Integer releasesToKeep;
	/**
 	* Gets and sets as the build to be retained or not. 
	**/
	@JsonProperty("retainBuild")
	private boolean retainBuild;

	public Integer getDaysToKeep() { return daysToKeep; }

	public void setDaysToKeep(Integer daysToKeep) { this.daysToKeep = daysToKeep; }

	public Integer getReleasesToKeep() { return releasesToKeep; }

	public void setReleasesToKeep(Integer releasesToKeep) { this.releasesToKeep = releasesToKeep; }

	public boolean getRetainBuild() { return retainBuild; }

	public void setRetainBuild(boolean retainBuild) { this.retainBuild = retainBuild; }

}
