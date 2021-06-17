package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDefinitionGatesOptions {
    @JsonProperty("isEnabled")
    private boolean isEnabled;
    @JsonProperty("minimumSuccessDuration")
    private int minimumSuccessDuration;
    @JsonProperty("samplingInterval")
    private int samplingInterval;
    @JsonProperty("stabilizationTime")
    private int stabilizationTime;
    @JsonProperty("timeout")
    private int timeout;

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public int getMinimumSuccessDuration() {
        return minimumSuccessDuration;
    }

    public void setMinimumSuccessDuration(int minimumSuccessDuration) {
        this.minimumSuccessDuration = minimumSuccessDuration;
    }

    public int getSamplingInterval() {
        return samplingInterval;
    }

    public void setSamplingInterval(int samplingInterval) {
        this.samplingInterval = samplingInterval;
    }

    public int getStabilizationTime() {
        return stabilizationTime;
    }

    public void setStabilizationTime(int stabilizationTime) {
        this.stabilizationTime = stabilizationTime;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Override
    public String toString() {
        return "ReleaseDefinitionGatesOptions{" +
                "isEnabled=" + isEnabled +
                ", minimumSuccessDuration=" + minimumSuccessDuration +
                ", samplingInterval=" + samplingInterval +
                ", stabilizationTime=" + stabilizationTime +
                ", timeout=" + timeout +
                '}';
    }
}
