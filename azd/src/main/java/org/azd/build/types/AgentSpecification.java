package org.azd.build.types;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specification of the agent defined by the pool provider. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgentSpecification {
    /**
     * Agent specification unique identifier.
     **/
    @JsonProperty("identifier")
    private String identifier;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return "AgentSpecification{" +
                "identifier='" + identifier + '\'' +
                '}';
    }
}