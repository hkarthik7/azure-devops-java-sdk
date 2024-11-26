package org.azd.security.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * List of Access Control Lists
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ACLs extends SerializableCollectionEntity {
    /**
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

}
