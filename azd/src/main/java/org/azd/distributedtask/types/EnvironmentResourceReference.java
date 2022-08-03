package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * EnvironmentResourceReference.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnvironmentResourceReference extends BaseAbstractMethod {
    /***
     * Id of the resource.
     */
    @JsonProperty("id")
    private int id;
    /***
     * Name of the resource.
     */
    @JsonProperty("name")
    private String name;
    /***
     * Tags of the Environment Resource Reference.
     */
    @JsonProperty("tags")
    private String[] tags;
    /***
     * Type of the resource.
     */
    @JsonProperty("type")
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
