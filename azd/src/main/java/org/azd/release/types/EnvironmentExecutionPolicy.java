package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Defines policy on environment queuing at Release Management side queue.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnvironmentExecutionPolicy {
    /***
     * This policy decides, how many environments would be with Environment Runner.
     */
    @JsonProperty("concurrencyCount")
    private int concurrencyCount;
    /***
     * Queue depth in the EnvironmentQueue table, this table keeps the environment entries
     * till Environment Runner is free [as per it's policy] to take another environment for running.
     */
    @JsonProperty("queueDepthCount")
    private int queueDepthCount;

    public int getConcurrencyCount() {
        return concurrencyCount;
    }

    public void setConcurrencyCount(int concurrencyCount) {
        this.concurrencyCount = concurrencyCount;
    }

    public int getQueueDepthCount() {
        return queueDepthCount;
    }

    public void setQueueDepthCount(int queueDepthCount) {
        this.queueDepthCount = queueDepthCount;
    }

    @Override
    public String toString() {
        return "EnvironmentExecutionPolicy{" +
                "concurrencyCount=" + concurrencyCount +
                ", queueDepthCount=" + queueDepthCount +
                '}';
    }
}
