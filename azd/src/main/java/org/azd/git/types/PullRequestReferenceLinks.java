package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Reference;
import org.azd.common.types.ReferenceLink;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PullRequestReferenceLinks extends ReferenceLink {
    @JsonProperty("repository")
    private Reference repository;
    @JsonProperty("workItems")
    private Reference workItems;
    @JsonProperty("sourceBranch")
    private Reference sourceBranch;
    @JsonProperty("targetBranch")
    private Reference targetBranch;
    @JsonProperty("sourceCommit")
    private Reference sourceCommit;
    @JsonProperty("targetCommit")
    private Reference targetCommit;
    @JsonProperty("createdBy")
    private Reference createdBy;
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
