package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Represents a build log.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildLog extends BaseAbstractMethod {
    /***
     * The number of lines in the log.
     */
    @JsonProperty("lineCount")
    private int lineCount;
    /***
     * The date and time the log was created.
     */
    @JsonProperty("createdOn")
    private String createdOn;
    /***
     * The date and time the log was last changed.
     */
    @JsonProperty("lastChangedOn")
    private String lastChangedOn;
    /***
     * The ID of the log.
     */
    @JsonProperty("id")
    private int id;
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

    public int getLineCount() {
        return lineCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getLastChangedOn() {
        return lastChangedOn;
    }

    public void setLastChangedOn(String lastChangedOn) {
        this.lastChangedOn = lastChangedOn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
