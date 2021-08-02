package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Retention policy of the environment
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnvironmentRetentionPolicy {
    /***
     * Gets and sets the number of days to keep environment.
     */
    @JsonProperty("daysToKeep")
    private int daysToKeep;
    /***
     * Gets and sets the number of releases to keep.
     */
    @JsonProperty("releasesToKeep")
    private int releasesToKeep;
    /***
     * Gets and sets as the build to be retained or not.
     */
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
