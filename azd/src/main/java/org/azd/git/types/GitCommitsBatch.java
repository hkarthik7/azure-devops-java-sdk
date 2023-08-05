package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.enums.GitHistoryMode;
import org.azd.serializer.SerializableEntity;
import org.azd.wiki.types.GitVersionDescriptor;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a request body object for Get Commits Batch API.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitCommitsBatch extends SerializableEntity {
    /**
     * Number of entries to skip
     */
    @JsonProperty("$skip")
    private int skip;
    /**
     * Maximum number of entries to retrieve
     */
    @JsonProperty("$top")
    private int top;
    /**
     * Alias or display name of the author
     */
    @JsonProperty("author")
    private String author;
    /**
     * Only applicable when ItemVersion specified. If provided, start walking history starting at this commit.
     */
    @JsonProperty("compareVersion")
    private GitVersionDescriptor compareVersion;
    /**
     * Only applies when an itemPath is specified. This determines whether to exclude delete entries of the specified path.
     */
    @JsonProperty("excludeDeletes")
    private boolean excludeDeletes;
    /**
     * If provided, a lower bound for filtering commits alphabetically
     */
    @JsonProperty("fromCommitId")
    private String fromCommitId;
    /**
     * If provided, only include history entries created after this date (string)
     */
    @JsonProperty("fromDate")
    private String fromDate;
    /**
     * What Git history mode should be used. This only applies to the search criteria when Ids = null and an itemPath is specified.
     */
    @JsonProperty("historyMode")
    private GitHistoryMode historyMode;
    /**
     * If provided, specifies the exact commit ids of the commits to fetch. May not be combined with other parameters.
     */
    @JsonProperty("ids")
    private String[] ids;
    /**
     * Whether to include the _links field on the shallow references
     */
    @JsonProperty("includeLinks")
    private boolean includeLinks;
    /**
     * Whether to include the push information
     */
    @JsonProperty("includePushData")
    private boolean includePushData;
    /**
     * Whether to include the image Url for committers and authors
     */
    @JsonProperty("includeUserImageUrl")
    private boolean includeUserImageUrl;
    /**
     * Whether to include linked work items
     */
    @JsonProperty("includeWorkItems")
    private boolean includeWorkItems;
    /**
     * Path of item to search under
     */
    @JsonProperty("itemPath")
    private String itemPath;
    /**
     * If provided, identifies the commit or branch to search
     */
    @JsonProperty("itemVersion")
    private GitVersionDescriptor itemVersion;
    /**
     * If enabled, this option will ignore the itemVersion and compareVersion parameters
     */
    @JsonProperty("showOldestCommitsFirst")
    private boolean showOldestCommitsFirst;
    /**
     * If provided, an upper bound for filtering commits alphabetically
     */
    @JsonProperty("toCommitId")
    private String toCommitId;
    /**
     * If provided, only include history entries created before this date (string)
     */
    @JsonProperty("toDate")
    private String toDate;
    /**
     * Alias or display name of the committer
     */
    @JsonProperty("user")
    private String user;

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public GitVersionDescriptor getCompareVersion() {
        return compareVersion;
    }

    public void setCompareVersion(GitVersionDescriptor compareVersion) {
        this.compareVersion = compareVersion;
    }

    public boolean isExcludeDeletes() {
        return excludeDeletes;
    }

    public void setExcludeDeletes(boolean excludeDeletes) {
        this.excludeDeletes = excludeDeletes;
    }

    public String getFromCommitId() {
        return fromCommitId;
    }

    public void setFromCommitId(String fromCommitId) {
        this.fromCommitId = fromCommitId;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public GitHistoryMode getHistoryMode() {
        return historyMode;
    }

    public void setHistoryMode(GitHistoryMode historyMode) {
        this.historyMode = historyMode;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public boolean isIncludeLinks() {
        return includeLinks;
    }

    public void setIncludeLinks(boolean includeLinks) {
        this.includeLinks = includeLinks;
    }

    public boolean isIncludePushData() {
        return includePushData;
    }

    public void setIncludePushData(boolean includePushData) {
        this.includePushData = includePushData;
    }

    public boolean isIncludeUserImageUrl() {
        return includeUserImageUrl;
    }

    public void setIncludeUserImageUrl(boolean includeUserImageUrl) {
        this.includeUserImageUrl = includeUserImageUrl;
    }

    public boolean isIncludeWorkItems() {
        return includeWorkItems;
    }

    public void setIncludeWorkItems(boolean includeWorkItems) {
        this.includeWorkItems = includeWorkItems;
    }

    public String getItemPath() {
        return itemPath;
    }

    public void setItemPath(String itemPath) {
        this.itemPath = itemPath;
    }

    public GitVersionDescriptor getItemVersion() {
        return itemVersion;
    }

    public void setItemVersion(GitVersionDescriptor itemVersion) {
        this.itemVersion = itemVersion;
    }

    public boolean isShowOldestCommitsFirst() {
        return showOldestCommitsFirst;
    }

    public void setShowOldestCommitsFirst(boolean showOldestCommitsFirst) {
        this.showOldestCommitsFirst = showOldestCommitsFirst;
    }

    public String getToCommitId() {
        return toCommitId;
    }

    public void setToCommitId(String toCommitId) {
        this.toCommitId = toCommitId;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Helper method to strip out the unused parameters.
     * @param gitCommitsBatch Current git commits batch object that user passes.
     * @return a Map of request body to call get commits batch API.
     */
    public static Map<String, Object> build(GitCommitsBatch gitCommitsBatch) {
        var requestBody = new HashMap<String, Object>();
        if (gitCommitsBatch.getAuthor() != null) requestBody.put("author", gitCommitsBatch.getAuthor());
        if (gitCommitsBatch.getCompareVersion() != null)
            requestBody.put("compareVersion", gitCommitsBatch.getCompareVersion());
        if (gitCommitsBatch.isExcludeDeletes()) requestBody.put("excludeDeletes", gitCommitsBatch.isExcludeDeletes());
        if (gitCommitsBatch.getFromCommitId() != null) requestBody.put("fromCommitId", gitCommitsBatch.getFromCommitId());
        if (gitCommitsBatch.getFromDate() != null) requestBody.put("fromDate", gitCommitsBatch.getFromDate());
        if (gitCommitsBatch.getHistoryMode() != null) requestBody.put("historyMode", gitCommitsBatch.getHistoryMode());
        if (gitCommitsBatch.getIds() != null) requestBody.put("ids", String.join(",", gitCommitsBatch.getIds()));
        if (gitCommitsBatch.isIncludeLinks()) requestBody.put("includeLinks", gitCommitsBatch.isIncludeLinks());
        if (gitCommitsBatch.isIncludePushData()) requestBody.put("includePushData", gitCommitsBatch.isIncludePushData());
        if (gitCommitsBatch.isIncludeUserImageUrl())
            requestBody.put("includeUserImageUrl", gitCommitsBatch.isIncludeUserImageUrl());
        if (gitCommitsBatch.isIncludeWorkItems()) requestBody.put("includeWorkItems", gitCommitsBatch.isIncludeWorkItems());
        if (gitCommitsBatch.getItemPath() != null) requestBody.put("itemPath", gitCommitsBatch.getItemPath());
        if (gitCommitsBatch.getItemVersion() != null) requestBody.put("itemVersion", gitCommitsBatch.getItemVersion());
        if (gitCommitsBatch.isShowOldestCommitsFirst())
            requestBody.put("showOldestCommitsFirst", gitCommitsBatch.isShowOldestCommitsFirst());
        if (gitCommitsBatch.getToCommitId() != null) requestBody.put("toCommitId", gitCommitsBatch.getToCommitId());
        if (gitCommitsBatch.getToDate() != null) requestBody.put("toDate", gitCommitsBatch.getToDate());
        if (gitCommitsBatch.getUser() != null) requestBody.put("user", gitCommitsBatch.getUser());
        if (gitCommitsBatch.getSkip() > 0) requestBody.put("$skip", gitCommitsBatch.getSkip());
        if (gitCommitsBatch.getTop() > 0) requestBody.put("$top", gitCommitsBatch.getTop());

        return requestBody;
    }
}
