package org.azd.security.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/***
 * return security roles
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SecurityRoles extends SerializableCollectionEntity {
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

}
