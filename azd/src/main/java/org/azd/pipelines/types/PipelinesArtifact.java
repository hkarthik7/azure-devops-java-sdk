package org.azd.pipelines.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Artifacts are collections of files produced by a pipeline. Use artifacts to share files between stages in a pipeline or between different pipelines.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PipelinesArtifact extends BaseAbstractMethod {
    /***
     * The name of the artifact.
     */
    @JsonProperty("name")
    private String name;
    /***
     * Signed url for downloading this artifact
     */
    @JsonProperty("signedContent")
    private SignedUrl signedContent;
    /***
     * Self-referential url
     */
    @JsonProperty("url")
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
