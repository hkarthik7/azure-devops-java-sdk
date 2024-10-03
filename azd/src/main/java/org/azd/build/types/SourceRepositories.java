package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * A set of repositories returned from the source provider.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SourceRepositories extends SerializableEntity {
    /**
     * A token used to continue this paged request; 'null' if the request is complete
     */
    @JsonProperty("continuationToken")
    private String continuationToken;
    /**
     * The number of repositories requested for each page
     */
    @JsonProperty("pageLength")
    private int pageLength;
    /**
     * A list of repositories
     */
    @JsonProperty("repositories")
    private List<SourceRepository> repositories;
    /**
     * The total number of pages, or '-1' if unknown
     */
    @JsonProperty("totalPageCount")
    private int totalPageCount;

    public String getContinuationTokenValue() {
        return continuationToken;
    }

    public void setContinuationTokenValue(String continuationToken) {
        this.continuationToken = continuationToken;
    }

    public int getPageLength() {
        return pageLength;
    }

    public void setPageLength(int pageLength) {
        this.pageLength = pageLength;
    }

    public List<SourceRepository> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<SourceRepository> repositories) {
        this.repositories = repositories;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

}
