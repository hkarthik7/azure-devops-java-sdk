package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EnvironmentExecutionPolicy {
    @JsonProperty("concurrencyCount")
    private int concurrencyCount;
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
