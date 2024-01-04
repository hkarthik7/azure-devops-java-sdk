package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.GitHistoryMode;
import org.azd.wiki.types.GitVersionDescriptor;

import java.util.List;

/**
 * Represents a request body object for Get Commits Batch API.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitCommitsBatch extends SerializableEntity {
    /**
     * Number of entries to skip
     */
    @JsonProperty("$skip")
    public Number skip;
    /**
     * Maximum number of entries to retrieve
     */
    @JsonProperty("$top")
    public Number top;
    /**
     * Alias or display name of the author
     */
    @JsonProperty("author")
    public String author;
    /**
     * Only applicable when ItemVersion specified. If provided, start walking history starting at this commit.
     */
    @JsonProperty("compareVersion")
    public GitVersionDescriptor compareVersion;
    /**
     * Only applies when an itemPath is specified. This determines whether to exclude delete entries of the specified path.
     */
    @JsonProperty("excludeDeletes")
    public Boolean excludeDeletes;
    /**
     * If provided, a lower bound for filtering commits alphabetically
     */
    @JsonProperty("fromCommitId")
    public String fromCommitId;
    /**
     * If provided, only include history entries created after this date (string)
     */
    @JsonProperty("fromDate")
    public String fromDate;
    /**
     * What Git history mode should be used. This only applies to the search criteria when Ids = null and an itemPath is specified.
     */
    @JsonProperty("historyMode")
    public GitHistoryMode historyMode;
    /**
     * If provided, specifies the exact commit ids of the commits to fetch. May not be combined with other parameters.
     */
    @JsonProperty("ids")
    public List<String> ids;
    /**
     * Whether to include the _links field on the shallow references
     */
    @JsonProperty("includeLinks")
    public Boolean includeLinks;
    /**
     * Whether to include the push information
     */
    @JsonProperty("includePushData")
    public Boolean includePushData;
    /**
     * Whether to include the image Url for committers and authors
     */
    @JsonProperty("includeUserImageUrl")
    public Boolean includeUserImageUrl;
    /**
     * Whether to include linked work items
     */
    @JsonProperty("includeWorkItems")
    public Boolean includeWorkItems;
    /**
     * Path of item to search under
     */
    @JsonProperty("itemPath")
    public String itemPath;
    /**
     * If provided, identifies the commit or branch to search
     */
    @JsonProperty("itemVersion")
    public GitVersionDescriptor itemVersion;
    /**
     * If enabled, this option will ignore the itemVersion and compareVersion parameters
     */
    @JsonProperty("showOldestCommitsFirst")
    public Boolean showOldestCommitsFirst;
    /**
     * If provided, an upper bound for filtering commits alphabetically
     */
    @JsonProperty("toCommitId")
    public String toCommitId;
    /**
     * If provided, only include history entries created before this date (string)
     */
    @JsonProperty("toDate")
    public String toDate;
    /**
     * Alias or display name of the committer
     */
    @JsonProperty("user")
    public String user;
}
