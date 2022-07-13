package org.azd.security.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * List of Access Control Lists
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ACLs {
    /***
     * List of access control lists
     */
    @JsonProperty("value")
    private List<ACL> ACLs;

    public List<ACL> getACLs() {
        return ACLs;
    }

    public void setACLs(List<ACL> ACLs) {
        this.ACLs = ACLs;
    }

    @Override
    public String toString() {
        return "ACLs{" +
                "ACLs=" + ACLs +
                '}';
    }
}
