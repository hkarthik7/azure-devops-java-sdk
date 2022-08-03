package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDefinitionGatesStep extends BaseAbstractMethod {
	/**
 	* Gets or sets the gates. 
	**/
	@JsonProperty("gates")
	private List<ReleaseDefinitionGate> gates;
	/**
 	* Gets or sets the gate options. 
	**/
	@JsonProperty("gatesOptions")
	private ReleaseDefinitionGatesOptions gatesOptions;
	/**
 	* ID of the ReleaseDefinitionGateStep. 
	**/
	@JsonProperty("id")
	private Integer id;

	public List<ReleaseDefinitionGate> getGates() { return gates; }

	public void setGates(List<ReleaseDefinitionGate> gates) { this.gates = gates; }

	public ReleaseDefinitionGatesOptions getGatesOptions() { return gatesOptions; }

	public void setGatesOptions(ReleaseDefinitionGatesOptions gatesOptions) { this.gatesOptions = gatesOptions; }

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

}
