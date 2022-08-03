package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * List of task agent
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskAgents extends BaseAbstractMethod {
    /***
     * List of task agent
     */
    @JsonProperty("value")
    private List<TaskAgent> taskAgents;

    public List<TaskAgent> getTaskAgents() {
        return taskAgents;
    }

    public void setTaskAgents(List<TaskAgent> taskAgents) {
        this.taskAgents = taskAgents;
    }

}
