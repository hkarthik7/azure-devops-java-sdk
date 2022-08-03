package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Gets or sets the list of artifacts.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseArtifacts extends BaseAbstractMethod {
    /***
     * Gets or sets alias.
     */
    @JsonProperty("alias")
    private String alias;
    /***
     * Definition reference.
     */
    @JsonProperty("definitionReference")
    private JsonNode definitionReference;
    /***
     * Indicates whether artifact is primary or not.
     */
    @JsonProperty("isPrimary")
    private boolean isPrimary;
    /***
     * Indicates whether artifact is retained by release or not.
     */
    @JsonProperty("isRetained")
    private String isRetained;
    /***
     * Gets or sets type. It can have value as 'Build', 'Jenkins', 'GitHub', 'Nuget',
     * 'Team Build (external)', 'ExternalTFSBuild', 'Git', 'TFVC', 'ExternalTfsXamlBuild'.
     */
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

}
