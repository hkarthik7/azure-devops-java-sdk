package org.azd.security.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * return security roles
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SecurityRoles {
    /***
     * list of security role definitions
     */
    @JsonProperty("value")
    List<SecurityRole> securityRoles;

    public List<SecurityRole> getSecurityRoles() {
        return securityRoles;
    }

    public void setSecurityRoles(List<SecurityRole> securityRoles) {
        this.securityRoles = securityRoles;
    }

    @Override
    public String toString() {
        return "SecurityRoles{" +
                "securityRoles=" + securityRoles +
                '}';
    }
}
