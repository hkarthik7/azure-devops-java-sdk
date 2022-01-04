package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * The pipeline associated with this request
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskOrchestrationOwner {
    /***
     * Id of the pipeline
     */
    @JsonProperty("id")
    private int id;
    /***
     * Name of the pipeline
     */
    @JsonProperty("name")
    private String name;

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

    @Override
    public String toString() {
        return "TaskOrchestrationOwner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
