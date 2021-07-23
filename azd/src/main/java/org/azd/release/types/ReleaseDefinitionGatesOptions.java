package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Gets or sets the gate options.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDefinitionGatesOptions {
    /***
     * Gets or sets as the gates enabled or not.
     */
    @JsonProperty("isEnabled")
    private boolean isEnabled;
    /***
     * Gets or sets the minimum duration for steady results after a successful gates evaluation.
     */
    @JsonProperty("minimumSuccessDuration")
    private int minimumSuccessDuration;
    /***
     * Gets or sets the time between re-evaluation of gates.
     */
    @JsonProperty("samplingInterval")
    private int samplingInterval;
    /***
     * Gets or sets the delay before evaluation.
     */
    @JsonProperty("stabilizationTime")
    private int stabilizationTime;
    /***
     * Gets or sets the timeout after which gates fail.
     */
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
