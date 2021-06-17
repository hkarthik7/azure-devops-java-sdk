package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeploymentJob {
    @JsonProperty("job")
    private ReleaseTask job;
    @JsonProperty("tasks")
    private List<ReleaseTask> tasks;

    public ReleaseTask getJob() {
        return job;
    }

    public void setJob(ReleaseTask job) {
        this.job = job;
    }

    public List<ReleaseTask> getTasks() {
        return tasks;
    }

    public void setTasks(List<ReleaseTask> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "DeploymentJob{" +
                "job=" + job +
                ", tasks=" + tasks +
                '}';
    }
}
