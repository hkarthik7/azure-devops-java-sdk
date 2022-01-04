package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/***
 * Represents the public key portion of an RSA asymmetric key.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskAgentPublicKey {
    /***
     * Gets or sets the exponent for the public key.
     */
    @JsonProperty("exponent")
    private String[] exponent;
    /***
     * Gets or sets the modulus for the public key.
     */
    @JsonProperty("modulus")
    private String[] modulus;

    public String[] getExponent() {
        return exponent;
    }

    public void setExponent(String[] exponent) {
        this.exponent = exponent;
    }

    public String[] getModulus() {
        return modulus;
    }

    public void setModulus(String[] modulus) {
        this.modulus = modulus;
    }

    @Override
    public String toString() {
        return "TaskAgentPublicKey{" +
                "exponent=" + Arrays.toString(exponent) +
                ", modulus=" + Arrays.toString(modulus) +
                '}';
    }
}
