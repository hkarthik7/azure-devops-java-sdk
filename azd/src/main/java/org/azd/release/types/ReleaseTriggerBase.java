package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.enums.ReleaseTriggerType;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseTriggerBase {
	/**
 	* Type of release trigger. 
	**/
	@JsonProperty("triggerType")
	private ReleaseTriggerType triggerType;

	public ReleaseTriggerType getTriggerType() { return triggerType; }

	public void setTriggerType(ReleaseTriggerType triggerType) { this.triggerType = triggerType; }

	@Override
	public String toString() { 
	return 	"ReleaseTriggerBase{" +
		"triggerType='" + triggerType + '\'' +
		'}';
	}
}