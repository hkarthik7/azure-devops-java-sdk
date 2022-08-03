package org.azd.pipelines.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Definition of a pipeline.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pipeline extends BaseAbstractMethod {
    /***
     * Pipeline configuration object
     */
    @JsonProperty("configuration")
    private PipelineConfiguration configuration;
    /***
     * Pipeline folder
     */
    @JsonProperty("folder")
    private String folder;
    /***
     * Pipeline ID
     */
    @JsonProperty("id")
    private int id;
    /***
     * Pipeline name
     */
    @JsonProperty("name")
    private String name;
    /***
     * Revision number
     */
    @JsonProperty("revision")
    private String revision;
    /***
     * URL of the pipeline
     */
    @JsonProperty("url")
    private String url;

    public PipelineConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(PipelineConfiguration configuration) {
        this.configuration = configuration;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

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
