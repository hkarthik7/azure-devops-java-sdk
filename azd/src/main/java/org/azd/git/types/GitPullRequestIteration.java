package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.common.types.ReferenceLinks;
import org.azd.test.types.IdentityRef;

public class GitPullRequestIteration extends SerializableEntity {

    /**
     * A collection of related REST reference links..
     **/
    @JsonProperty("_links")
    private ReferenceLinks links;

    /**
     * Author of the pull request iteration.
     **/
    @JsonProperty("author")
    private IdentityRef author;

    /**
     * Changes included with the pull request iteration.
     */
    @JsonProperty("changeList")
    private GitPullRequestChange changeList;

    /**
     * The commits included with the pull request iteration.
     */
    @JsonProperty("commits")
    private GitCommitRef[] commits;

    /**
     * The first common Git commit of the source and target refs.
     */
    @JsonProperty("commonRefCommit")
    private GitCommitRef commonRefCommit;

    /**
     * The creation date of the pull request iteration.
     **/
    @JsonProperty("createdDate")
    private String createdDate;

    /**
     * Description of the pull request iteration.
     **/
    @JsonProperty("description")
    private String description;

    /**
     * Indicates if the Commits property contains a truncated list of commits in this pull request iteration.
     **/
    @JsonProperty("hasMoreCommits")
    private boolean hasMoreCommits;

    /**
     * ID of the pull request iteration. Iterations are created as a result of creating and pushing updates to a pull request.
     **/
    @JsonProperty("id")
    private int id;

    /**
     * If the iteration reason is Retarget, this is the refName of the new target
     **/
    @JsonProperty("newTargetRefName")
    private String newTargetRefName;

    /**
     * If the iteration reason is Retarget, this is the original target refName
     **/
    @JsonProperty("oldTargetRefName")
    private String oldTargetRefName;

    /**
     * The Git push information associated with this pull request iteration.
     */
    @JsonProperty("push")
    private GitPushRef push;

    /**
     * The reason for which the pull request iteration was created.
     */
    @JsonProperty("reason")
    private IterationReason reason;

    /**
     * The source Git commit of this iteration.
     */
    @JsonProperty("sourceRefCommit")
    private GitCommitRef sourceRefCommit;

    /**
     * The target Git commit of this iteration.
     */
    @JsonProperty("targetRefCommit")
    private GitCommitRef targetRefCommit;

    /**
     * The updated date of the pull request iteration.
     */
    @JsonProperty("updatedDate")
    private String updatedDate;

    public ReferenceLinks getLinks() {
        return links;
    }

    public void setLinks(ReferenceLinks links) {
        this.links = links;
    }

    public IdentityRef getAuthor() {
        return author;
    }

    public void setAuthor(IdentityRef author) {
        this.author = author;
    }

    public GitPullRequestChange getChangeList() {
        return changeList;
    }

    public void setChangeList(GitPullRequestChange changeList) {
        this.changeList = changeList;
    }

    public GitCommitRef[] getCommits() {
        return commits;
    }

    public void setCommits(GitCommitRef[] commits) {
        this.commits = commits;
    }

    public GitCommitRef getCommonRefCommit() {
        return commonRefCommit;
    }

    public void setCommonRefCommit(GitCommitRef commonRefCommit) {
        this.commonRefCommit = commonRefCommit;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHasMoreCommits() {
        return hasMoreCommits;
    }

    public void setHasMoreCommits(boolean hasMoreCommits) {
        this.hasMoreCommits = hasMoreCommits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewTargetRefName() {
        return newTargetRefName;
    }

    public void setNewTargetRefName(String newTargetRefName) {
        this.newTargetRefName = newTargetRefName;
    }

    public String getOldTargetRefName() {
        return oldTargetRefName;
    }

    public void setOldTargetRefName(String oldTargetRefName) {
        this.oldTargetRefName = oldTargetRefName;
    }

    public GitPushRef getPush() {
        return push;
    }

    public void setPush(GitPushRef push) {
        this.push = push;
    }

    public IterationReason getReason() {
        return reason;
    }

    public void setReason(IterationReason reason) {
        this.reason = reason;
    }

    public GitCommitRef getSourceRefCommit() {
        return sourceRefCommit;
    }

    public void setSourceRefCommit(GitCommitRef sourceRefCommit) {
        this.sourceRefCommit = sourceRefCommit;
    }

    public GitCommitRef getTargetRefCommit() {
        return targetRefCommit;
    }

    public void setTargetRefCommit(GitCommitRef targetRefCommit) {
        this.targetRefCommit = targetRefCommit;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }
}
