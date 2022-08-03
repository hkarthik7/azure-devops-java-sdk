package org.azd.work.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Represents a shallow ref for a single iteration.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamSettingsIteration extends BaseAbstractMethod {
    /***
     * Id of the iteration.
     */
    @JsonProperty("id")
    private String id;
    /***
     * Name of the iteration.
     */
    @JsonProperty("name")
    private String name;
    /***
     * Relative path of the iteration.
     */
    @JsonProperty("path")
    private String path;
    /***
     * Attributes of the iteration such as start and end date.
     */
    @JsonProperty("attributes")
    private TeamIterationAttributes attributes;
    /***
     * Full http link to the resource
     */
    @JsonProperty("url")
    private String url;


    public TeamIterationAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(TeamIterationAttributes attributes) {
        this.attributes = attributes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
