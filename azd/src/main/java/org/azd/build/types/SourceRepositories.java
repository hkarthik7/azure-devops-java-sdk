package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * A set of repositories returned from the source provider.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SourceRepositories {
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

    public String getContinuationToken() {
        return continuationToken;
    }

    public void setContinuationToken(String continuationToken) {
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

    @Override
    public String toString() {
        return "SourceRepositories{" +
                "continuationToken='" + continuationToken + '\'' +
                ", pageLength=" + pageLength +
                ", repositories=" + repositories +
                ", totalPageCount=" + totalPageCount +
                '}';
    }
}
