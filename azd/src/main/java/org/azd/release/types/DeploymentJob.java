package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * Contains the gates job details of each evaluation.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeploymentJob {
    /***
     * Parent task of all executed tasks.
     */
    @JsonProperty("job")
    private ReleaseTask job;
    /***
     * List of executed tasks with in job.
     */
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
