package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * The agent specification for the build.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgentSpecification {
    /***
     * Agent specification unique identifier.
     */
    @JsonProperty("identifier")
    private String identifier;

    @Override
    public String toString() {
        return "AgentSpecification{" +
                "identifier='" + identifier + '\'' +
                '}';
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
