package org.azd.pipelines.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * A collection of logs.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LogCollection extends BaseAbstractMethod {
    /***
     * The list of logs.
     */
    @JsonProperty("logs")
    private List<PipelineLog> logs;
    /***
     * A signed url allowing limited-time anonymous access to private resources.
     */
    @JsonProperty("signedContent")
    private SignedUrl signedContent;
    /***
     * URL of the log.
     */
    @JsonProperty("url")
    private String url;

    public List<PipelineLog> getLogs() {
        return logs;
    }

    public void setLogs(List<PipelineLog> logs) {
        this.logs = logs;
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
