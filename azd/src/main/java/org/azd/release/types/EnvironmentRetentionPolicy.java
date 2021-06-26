package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EnvironmentRetentionPolicy {
    @JsonProperty("daysToKeep")
    private int daysToKeep;
    @JsonProperty("releasesToKeep")
    private int releasesToKeep;
    @JsonProperty("retainBuild")
    private boolean retainBuild;

    public int getDaysToKeep() {
        return daysToKeep;
    }

    public void setDaysToKeep(int daysToKeep) {
        this.daysToKeep = daysToKeep;
    }

    public int getReleasesToKeep() {
        return releasesToKeep;
    }

    public void setReleasesToKeep(int releasesToKeep) {
        this.releasesToKeep = releasesToKeep;
    }

    public boolean isRetainBuild() {
        return retainBuild;
    }

    public void setRetainBuild(boolean retainBuild) {
        this.retainBuild = retainBuild;
    }

    @Override
    public String toString() {
        return "EnvironmentRetentionPolicy{" +
                "daysToKeep=" + daysToKeep +
                ", releasesToKeep=" + releasesToKeep +
                ", retainBuild=" + retainBuild +
                '}';
    }
}
