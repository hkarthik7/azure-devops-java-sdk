package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.enums.ReleaseTriggerType;
import org.azd.serializer.SerializableEntity;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseTriggerBase extends SerializableEntity {
	/**
 	* Type of release trigger. 
	**/
	@JsonProperty("triggerType")
	private ReleaseTriggerType triggerType;

	public ReleaseTriggerType getTriggerType() { return triggerType; }

	public void setTriggerType(ReleaseTriggerType triggerType) { this.triggerType = triggerType; }

}
