package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseArtifacts {
    @JsonProperty("alias")
    private String alias;
    @JsonProperty("definitionReference")
    private JsonNode definitionReference;
    @JsonProperty("isPrimary")
    private boolean isPrimary;
    @JsonProperty("isRetained")
    private String isRetained;
    @JsonProperty("type")
    private String type;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public JsonNode getDefinitionReference() {
        return definitionReference;
    }

    public void setDefinitionReference(JsonNode definitionReference) {
        this.definitionReference = definitionReference;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public String getIsRetained() {
        return isRetained;
    }

    public void setIsRetained(String isRetained) {
        this.isRetained = isRetained;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ReleaseArtifacts{" +
                "alias='" + alias + '\'' +
                ", definitionReference=" + definitionReference +
                ", isPrimary=" + isPrimary +
                ", isRetained='" + isRetained + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
