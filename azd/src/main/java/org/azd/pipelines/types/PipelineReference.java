package org.azd.pipelines.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * A reference to a Pipeline.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PipelineReference extends BaseAbstractMethod {
    /***
     * Pipeline folder
     */
    @JsonProperty("folder")
    private String folder;
    /***
     * Pipeline ID
     */
    @JsonProperty("id")
    private String id;
    /***
     * Pipeline name
     */
    @JsonProperty("name")
    private String name;
    /***
     *
     * Revision number
     */
    @JsonProperty("revision")
    private String revision;
    /***
     * URL string
     */
    @JsonProperty("url")
    private String url;

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
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

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
