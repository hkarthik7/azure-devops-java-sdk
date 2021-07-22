package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Reference;
import org.azd.common.types.ReferenceLink;

/***
 * Links to other related objects.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PullRequestReferenceLinks extends ReferenceLink {
    /***
     * Link to the repository
     */
    @JsonProperty("repository")
    private Reference repository;
    /***
     * Link to workitem associated with the pull request
     */
    @JsonProperty("workItems")
    private Reference workItems;
    /***
     * Link to source branch
     */
    @JsonProperty("sourceBranch")
    private Reference sourceBranch;
    /***
     * Link to target branch
     */
    @JsonProperty("targetBranch")
    private Reference targetBranch;
    /***
     * Link to source commit
     */
    @JsonProperty("sourceCommit")
    private Reference sourceCommit;
    /***
     * Link to target commit
     */
    @JsonProperty("targetCommit")
    private Reference targetCommit;
    /***
     * Create by
     */
    @JsonProperty("createdBy")
    private Reference createdBy;
    /***
     * Iterations if any
     */
    @JsonProperty("iterations")
    private Reference iterations;

    public Reference getRepository() {
        return repository;
    }

    public void setRepository(Reference repository) {
        this.repository = repository;
    }

    public Reference getWorkItems() {
        return workItems;
    }

    public void setWorkItems(Reference workItems) {
        this.workItems = workItems;
    }

    public Reference getSourceBranch() {
        return sourceBranch;
    }

    public void setSourceBranch(Reference sourceBranch) {
        this.sourceBranch = sourceBranch;
    }

    public Reference getTargetBranch() {
        return targetBranch;
    }

    public void setTargetBranch(Reference targetBranch) {
        this.targetBranch = targetBranch;
    }

    public Reference getSourceCommit() {
        return sourceCommit;
    }

    public void setSourceCommit(Reference sourceCommit) {
        this.sourceCommit = sourceCommit;
    }

    public Reference getTargetCommit() {
        return targetCommit;
    }

    public void setTargetCommit(Reference targetCommit) {
        this.targetCommit = targetCommit;
    }

    public Reference getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Reference createdBy) {
        this.createdBy = createdBy;
    }

    public Reference getIterations() {
        return iterations;
    }

    public void setIterations(Reference iterations) {
        this.iterations = iterations;
    }

    @Override
    public String toString() {
        return "PullRequestReferenceLinks{" +
                "repository=" + repository +
                ", workItems=" + workItems +
                ", sourceBranch=" + sourceBranch +
                ", targetBranch=" + targetBranch +
                ", sourceCommit=" + sourceCommit +
                ", targetCommit=" + targetCommit +
                ", createdBy=" + createdBy +
                ", iterations=" + iterations +
                '}';
    }
}
