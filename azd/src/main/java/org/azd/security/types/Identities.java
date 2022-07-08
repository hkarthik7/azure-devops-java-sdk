package org.azd.security.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * collection of identities
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Identities {
    @JsonProperty("value")
    List<Identity> identities;

    public List<Identity> getIdentities() {
        return identities;
    }

    public void setIdentities(List<Identity> identities) {
        this.identities = identities;
    }

    @Override
    public String toString() {
        return "Identities{" +
                "identities=" + identities +
                '}';
    }
}
