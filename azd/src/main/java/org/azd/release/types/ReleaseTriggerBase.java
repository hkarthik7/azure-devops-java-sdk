package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.ReleaseTriggerType;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseTriggerBase extends BaseAbstractMethod {
	/**
 	* Type of release trigger. 
	**/
	@JsonProperty("triggerType")
	private ReleaseTriggerType triggerType;

	public ReleaseTriggerType getTriggerType() { return triggerType; }

	public void setTriggerType(ReleaseTriggerType triggerType) { this.triggerType = triggerType; }

}
