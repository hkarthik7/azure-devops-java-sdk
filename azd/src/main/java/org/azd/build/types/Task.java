package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Represents a task in a step
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task extends BaseAbstractMethod {
    /***
     * Task id
     */
    @JsonProperty("id")
    private String id;
    /***
     * Task version specification
     */
    @JsonProperty("versionSpec")
    private String versionSpec;
    /***
     * Definition type
     */
    @JsonProperty("definitionType")
    private String definitionType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersionSpec() {
        return versionSpec;
    }

    public void setVersionSpec(String versionSpec) {
        this.versionSpec = versionSpec;
    }

    public String getDefinitionType() {
        return definitionType;
    }

    public void setDefinitionType(String definitionType) {
        this.definitionType = definitionType;
    }

}
