package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.types.Author;
import org.azd.common.types.BaseAbstractMethod;

/**
 * Represents a pull request object. These are retrieved from Source Providers.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SourceProviderPullRequest extends BaseAbstractMethod {
    /**
     * The links to other objects related to this object.
     */
    @JsonProperty("_links")
    private JsonNode _links;
    /**
     * Author of the pull request.
     */
    @JsonProperty("author")
    private Author author;
    /**
     * Current state of the pull request, e.g. open, merged, closed, conflicts, etc.
     */
    @JsonProperty("currentState")
    private String currentState;
    /**
     * Description for the pull request.
     */
    @JsonProperty("description")
    private String description;
    /**
     * Returns if pull request is draft
     */
    @JsonProperty("draft")
    private boolean draft;
    /**
     * Unique identifier for the pull request
     */
    @JsonProperty("id")
    private String id;
    /**
     * The name of the provider this pull request is associated with.
     */
    @JsonProperty("providerName")
    private String providerName;
    /**
     * Source branch ref of this pull request
     */
    @JsonProperty("sourceBranchRef")
    private String sourceBranchRef;
    /**
     * Owner of the source repository of this pull request
     */
    @JsonProperty("sourceRepositoryOwner")
    private String sourceRepositoryOwner;
    /**
     * Target branch ref of this pull request
     */
    @JsonProperty("targetBranchRef")
    private String targetBranchRef;
    /**
     * Owner of the target repository of this pull request
     */
    @JsonProperty("targetRepositoryOwner")
    private String targetRepositoryOwner;
    /**
     * Title of the pull request.
     */
    @JsonProperty("title")
    private String title;

    public JsonNode get_links() {
        return _links;
    }

    public void set_links(JsonNode _links) {
        this._links = _links;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDraft() {
        return draft;
    }

    public void setDraft(boolean draft) {
        this.draft = draft;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getSourceBranchRef() {
        return sourceBranchRef;
    }

    public void setSourceBranchRef(String sourceBranchRef) {
        this.sourceBranchRef = sourceBranchRef;
    }

    public String getSourceRepositoryOwner() {
        return sourceRepositoryOwner;
    }

    public void setSourceRepositoryOwner(String sourceRepositoryOwner) {
        this.sourceRepositoryOwner = sourceRepositoryOwner;
    }

    public String getTargetBranchRef() {
        return targetBranchRef;
    }

    public void setTargetBranchRef(String targetBranchRef) {
        this.targetBranchRef = targetBranchRef;
    }

    public String getTargetRepositoryOwner() {
        return targetRepositoryOwner;
    }

    public void setTargetRepositoryOwner(String targetRepositoryOwner) {
        this.targetRepositoryOwner = targetRepositoryOwner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
