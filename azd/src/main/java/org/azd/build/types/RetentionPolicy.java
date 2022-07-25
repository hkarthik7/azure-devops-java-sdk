package org.azd.build.types;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * The result. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class RetentionPolicy {

    @JsonProperty("artifactTypesToDelete")
    private String[] artifactTypesToDelete;

    @JsonProperty("artifacts")
    private String[] artifacts;

    @JsonProperty("branches")
    private String[] branches;
    /**
     * The number of days to keep builds.
     **/
    @JsonProperty("daysToKeep")
    private Integer daysToKeep;
    /**
     * Indicates whether the build record itself should be deleted.
     **/
    @JsonProperty("deleteBuildRecord")
    private Boolean deleteBuildRecord;
    /**
     * Indicates whether to delete test results associated with the build.
     **/
    @JsonProperty("deleteTestResults")
    private Boolean deleteTestResults;
    /**
     * The minimum number of builds to keep.
     **/
    @JsonProperty("minimumToKeep")
    private Integer minimumToKeep;

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

    public Integer getDaysToKeep() {
        return daysToKeep;
    }

    public void setDaysToKeep(Integer daysToKeep) {
        this.daysToKeep = daysToKeep;
    }

    public Boolean getDeleteBuildRecord() {
        return deleteBuildRecord;
    }

    public void setDeleteBuildRecord(Boolean deleteBuildRecord) {
        this.deleteBuildRecord = deleteBuildRecord;
    }

    public Boolean getDeleteTestResults() {
        return deleteTestResults;
    }

    public void setDeleteTestResults(Boolean deleteTestResults) {
        this.deleteTestResults = deleteTestResults;
    }

    public Integer getMinimumToKeep() {
        return minimumToKeep;
    }

    public void setMinimumToKeep(Integer minimumToKeep) {
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