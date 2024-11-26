package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Who is the provider for this user and what is the identifier and domain that is used to uniquely identify the user.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphProviderInfo extends SerializableEntity {
    /**
     * The descriptor is the primary way to reference the graph subject while the system is running.
     * This field will uniquely identify the same graph subject across both Accounts and Organizations.
     */
    @JsonProperty("descriptor")
    private String descriptor;
    /**
     * This represents the name of the container of origin for a graph member.
     * (For MSA this is "Windows Live ID", for AAD the tenantID of the directory.)
     */
    @JsonProperty("domain")
    private String domain;
    /**
     * The type of source provider for the origin identifier (ex: "aad", "msa")
     */
    @JsonProperty("origin")
    private String origin;
    /**
     * The unique identifier from the system of origin. (For MSA this is the PUID in hex notation, for AAD this is the object id.)
     */
    @JsonProperty("originId")
    private String originId;

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }
}
