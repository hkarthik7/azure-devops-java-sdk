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
public class TaskAgentPublicKey extends BaseAbstractMethod {
	/**
 	* Gets or sets the exponent for the public key. 
	**/
	@JsonProperty("exponent")
	private String[] exponent;
	/**
 	* Gets or sets the modulus for the public key. 
	**/
	@JsonProperty("modulus")
	private String[] modulus;

	public String[] getExponent() { return exponent; }

	public void setExponent(String[] exponent) { this.exponent = exponent; }

	public String[] getModulus() { return modulus; }

	public void setModulus(String[] modulus) { this.modulus = modulus; }

}
