package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Represents a build log.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Logs extends BaseAbstractMethod {
    /***
     * The ID of the log.
     */
    @JsonProperty("id")
    private String id;
    /***
     * The type of the log location.
     */
    @JsonProperty("type")
    private String type;
    /***
     * A full link to the log resource.
     */
    @JsonProperty("url")
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

}
