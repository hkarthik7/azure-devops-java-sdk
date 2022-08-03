package org.azd.build.types;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * The result. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class RetentionPolicy extends BaseAbstractMethod {

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
    private int daysToKeep;
    /**
     * Indicates whether the build record itself should be deleted.
     **/
    @JsonProperty("deleteBuildRecord")
    private boolean deleteBuildRecord;
    /**
     * Indicates whether to delete test results associated with the build.
     **/
    @JsonProperty("deleteTestResults")
    private boolean deleteTestResults;
    /**
     * The minimum number of builds to keep.
     **/
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

    public boolean getDeleteBuildRecord() {
        return deleteBuildRecord;
    }

    public void setDeleteBuildRecord(boolean deleteBuildRecord) {
        this.deleteBuildRecord = deleteBuildRecord;
    }

    public boolean getDeleteTestResults() {
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

}
