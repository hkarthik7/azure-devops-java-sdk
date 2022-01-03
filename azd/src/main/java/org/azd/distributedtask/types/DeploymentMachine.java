package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeploymentMachine {
    @JsonProperty("agent")
    private TaskAgent agent;
    @JsonProperty("id")
    private int id;
    @JsonProperty("properties")
    private JsonNode properties;
    @JsonProperty("tags")
    private String[] tags;

    public TaskAgent getAgent() {
        return agent;
    }

    public void setAgent(TaskAgent agent) {
        this.agent = agent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JsonNode getProperties() {
        return properties;
    }

    public void setProperties(JsonNode properties) {
        this.properties = properties;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "DeploymentMachine{" +
                "agent=" + agent +
                ", id=" + id +
                ", properties=" + properties +
                ", tags=" + Arrays.toString(tags) +
                '}';
    }
}
