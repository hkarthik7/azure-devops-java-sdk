package org.azd.pipelines.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Pipeline Run object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PipelineRun extends BaseAbstractMethod {
    /***
     * Pipeline created date
     */
    @JsonProperty("createdDate")
    private String createdDate;
    /***
     * YAML string
     */
    @JsonProperty("finalYaml")
    private String finalYaml;
    /***
     * Pipeline finished date
     */
    @JsonProperty("finishedDate")
    private String finishedDate;
    /***
     * Pipeline Id
     */
    @JsonProperty("id")
    private int id;
    /***
     * Name of the pipeline
     */
    @JsonProperty("name")
    private String name;
    /***
     * A reference to a Pipeline.
     */
    @JsonProperty("pipeline")
    private PipelineReference pipeline;
    /***
     * Pipeline resources
     */
    @JsonProperty("resources")
    private JsonNode resources;
    /***
     * Result
     */
    @JsonProperty("result")
    private String result;
    /***
     * State of the pipeline. E.g., Running
     */
    @JsonProperty("state")
    private String state;
    /***
     * URL of the pipeline
     */
    @JsonProperty("url")
    private String url;
    /***
     * Pipeline variables
     */
    @JsonProperty("variables")
    private JsonNode variables;

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getFinalYaml() {
        return finalYaml;
    }

    public void setFinalYaml(String finalYaml) {
        this.finalYaml = finalYaml;
    }

    public String getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(String finishedDate) {
        this.finishedDate = finishedDate;
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

    public PipelineReference getPipeline() {
        return pipeline;
    }

    public void setPipeline(PipelineReference pipeline) {
        this.pipeline = pipeline;
    }

    public JsonNode getResources() {
        return resources;
    }

    public void setResources(JsonNode resources) {
        this.resources = resources;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public JsonNode getVariables() {
        return variables;
    }

    public void setVariables(JsonNode variables) {
        this.variables = variables;
    }

}
