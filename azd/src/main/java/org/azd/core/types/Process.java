package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Represents process
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Process extends BaseAbstractMethod {
    /***
     * Process id
     */
    @JsonProperty("id")
    private String id;
    /***
     * Description of a process
     */
    @JsonProperty("description")
    private String description;
    /***
     * If process is set as default or not
     */
    @JsonProperty("isDefault")
    private boolean isDefault;
    /***
     * Type of process
     */
    @JsonProperty("type")
    private String type;
    /***
     * Process url
     */
    @JsonProperty("url")
    private String url;
    /***
     * Name of the process
     */
    @JsonProperty("name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
