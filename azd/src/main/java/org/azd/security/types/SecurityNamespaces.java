package org.azd.security.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * List of security namespaces
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SecurityNamespaces {
    /***
     * List of security namespaces
     */
    @JsonProperty("value")
    private List<SecurityNamespace> securityNamespaces;

    public List<SecurityNamespace> getSecurityNamespaces() {
        return securityNamespaces;
    }

    public void setSecurityNamespaces(List<SecurityNamespace> securityNamespaces) {
        this.securityNamespaces = securityNamespaces;
    }

    @Override
    public String toString() {
        return "SecurityNamespaces{" +
                "securityNamespaces=" + securityNamespaces +
                '}';
    }
}
