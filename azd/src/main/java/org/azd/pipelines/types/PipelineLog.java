package org.azd.pipelines.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Log for a pipeline.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PipelineLog extends BaseAbstractMethod {
    /***
     * The date and time the log was created.
     */
    @JsonProperty("createdOn")
    private String createdOn;
    /***
     * The ID of the log.
     */
    @JsonProperty("id")
    private String id;
    /***
     * The date and time the log was last changed.
     */
    @JsonProperty("lastChangedOn")
    private String lastChangedOn;
    /***
     * The number of lines in the log.
     */
    @JsonProperty("lineCount")
    private int lineCount;
    /***
     * A signed url allowing limited-time anonymous access to private resources.
     */
    @JsonProperty("signedContent")
    private SignedUrl signedContent;
    /***
     * Url string
     */
    @JsonProperty("url")
    private String url;

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastChangedOn() {
        return lastChangedOn;
    }

    public void setLastChangedOn(String lastChangedOn) {
        this.lastChangedOn = lastChangedOn;
    }

    public int getLineCount() {
        return lineCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }

    public SignedUrl getSignedContent() {
        return signedContent;
    }

    public void setSignedContent(SignedUrl signedContent) {
        this.signedContent = signedContent;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
