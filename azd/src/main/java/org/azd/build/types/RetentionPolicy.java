package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/***
 * Represents a retention policy for a build definition.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RetentionPolicy {
    /***
     * Type of artifacts to delete
     */
    @JsonProperty("artifactTypesToDelete")
    private String[] artifactTypesToDelete;
    /***
     * Artifacts
     */
    @JsonProperty("artifacts")
    private String[] artifacts;
    /***
     * Build repository branches
     */
    @JsonProperty("branches")
    private String[] branches;
    /***
     * The number of days to keep builds.
     */
    @JsonProperty("daysToKeep")
    private int daysToKeep;
    /***
     * Indicates whether the build record itself should be deleted.
     */
    @JsonProperty("deleteBuildRecord")
    private boolean deleteBuildRecord;
    /***
     * Indicates whether to delete test results associated with the build.
     */
    @JsonProperty("deleteTestResults")
    private boolean deleteTestResults;
    /***
     * The minimum number of builds to keep.
     */
    @JsonProperty("minimumToKeep")
    private int minimumToKeep;

    public String[] getArtifactTypesToDelete() {
        return artifactTypesToDelete;
    }

    public void setArtifactTypesToDelete(String[] artifactTypesToDelete) {
        this.artifactTypesToDelete = artifactTypesToDelete;
    }

    public String[] getArtifacts() {
        return artifacts;
    }

    public void setArtifacts(String[] artifacts) {
        this.artifacts = artifacts;
    }

    public String[] getBranches() {
        return branches;
    }

    public void setBranches(String[] branches) {
        this.branches = branches;
    }

    public int getDaysToKeep() {
        return daysToKeep;
    }

    public void setDaysToKeep(int daysToKeep) {
        this.daysToKeep = daysToKeep;
    }

    public boolean isDeleteBuildRecord() {
        return deleteBuildRecord;
    }

    public void setDeleteBuildRecord(boolean deleteBuildRecord) {
        this.deleteBuildRecord = deleteBuildRecord;
    }

    public boolean isDeleteTestResults() {
        return deleteTestResults;
    }

    public void setDeleteTestResults(boolean deleteTestResults) {
        this.deleteTestResults = deleteTestResults;
    }

    public int getMinimumToKeep() {
        return minimumToKeep;
    }

    public void setMinimumToKeep(int minimumToKeep) {
        this.minimumToKeep = minimumToKeep;
    }

    @Override
    public String toString() {
        return "RetentionPolicy{" +
                "artifactTypesToDelete=" + Arrays.toString(artifactTypesToDelete) +
                ", artifacts=" + Arrays.toString(artifacts) +
                ", branches=" + Arrays.toString(branches) +
                ", daysToKeep=" + daysToKeep +
                ", deleteBuildRecord=" + deleteBuildRecord +
                ", deleteTestResults=" + deleteTestResults +
                ", minimumToKeep=" + minimumToKeep +
                '}';
    }
}
