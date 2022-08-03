package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.EnvironmentTriggerType;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnvironmentTrigger extends BaseAbstractMethod {
	/**
 	* Definition environment ID on which this trigger applicable. 
	**/
	@JsonProperty("definitionEnvironmentId")
	private Integer definitionEnvironmentId;
	/**
 	* ReleaseDefinition ID on which this trigger applicable. 
	**/
	@JsonProperty("releaseDefinitionId")
	private Integer releaseDefinitionId;
	/**
 	* Gets or sets the trigger content. 
	**/
	@JsonProperty("triggerContent")
	private String triggerContent;
	/**
 	* Gets or sets the trigger type. 
	**/
	@JsonProperty("triggerType")
	private EnvironmentTriggerType triggerType;

	public Integer getDefinitionEnvironmentId() { return definitionEnvironmentId; }

	public void setDefinitionEnvironmentId(Integer definitionEnvironmentId) { this.definitionEnvironmentId = definitionEnvironmentId; }

	public Integer getReleaseDefinitionId() { return releaseDefinitionId; }

	public void setReleaseDefinitionId(Integer releaseDefinitionId) { this.releaseDefinitionId = releaseDefinitionId; }

	public String getTriggerContent() { return triggerContent; }

	public void setTriggerContent(String triggerContent) { this.triggerContent = triggerContent; }

	public EnvironmentTriggerType getTriggerType() { return triggerType; }

	public void setTriggerType(EnvironmentTriggerType triggerType) { this.triggerType = triggerType; }

}
