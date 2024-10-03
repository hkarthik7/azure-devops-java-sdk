package org.azd.git.types;

import org.azd.enums.PullRequestStatus;
import org.azd.enums.PullRequestTimeRange;

import java.util.HashMap;
import java.util.Map;

public class GitPullRequestQueryParameters {
    /**
     * The number of pull requests to retrieve.
     */
    public Integer top;
    /**
     * The number of pull requests to ignore. For example, to retrieve results 101-150, set top to 50 and skip to 100.
     */
    public Integer skip;
    /**
     * If set, search for pull requests that were created by this identity.
     */
    public String creatorId;
    /**
     * Whether to include the _links field on the shallow references
     */
    public Boolean includeLinks = false;
    /**
     * If specified, filters pull requests that created/closed before this date based on the queryTimeRangeType specified.
     */
    public String maxTime;
    /**
     * If specified, filters pull requests that created/closed after this date based on the queryTimeRangeType specified.
     */
    public String minTime;
    /**
     * The type of time range which should be used for minTime and maxTime. Defaults to Created if unset.
     */
    public PullRequestTimeRange queryTimeRangeType;
    /**
     * If set, search for pull requests whose target branch is in this repository.
     */
    public String repositoryId;
    /**
     * If set, search for pull requests that have this identity as a reviewer.
     */
    public String reviewerId;
    /**
     * If set, search for pull requests from this branch.
     */
    public String sourceRefName;
    /**
     * If set, search for pull requests whose source branch is in this repository.
     */
    public String sourceRepositoryId;
    /**
     * If set, search for pull requests that are in this state. Defaults to Active if unset.
     */
    public PullRequestStatus status;
    /**
     * If set, search for pull requests into this branch.
     */
    public String targetRefName;

    public Map<String, Object> get() {
        var queryParams = new HashMap<String, Object>();
        if (top != null) queryParams.put("$top", top);
        if (skip != null) queryParams.put("$skip", skip);
        if (creatorId != null) queryParams.put("searchCriteria.creatorId", creatorId);
        if (includeLinks) queryParams.put("searchCriteria.includeLinks", true);
        if (maxTime != null) queryParams.put("searchCriteria.maxTime", maxTime);
        if (minTime != null) queryParams.put("searchCriteria.minTime", minTime);
        if (queryTimeRangeType != null) queryParams.put("searchCriteria.queryTimeRangeType", queryTimeRangeType);
        if (repositoryId != null) queryParams.put("searchCriteria.repositoryId", repositoryId);
        if (reviewerId != null) queryParams.put("searchCriteria.reviewerId", reviewerId);
        if (sourceRefName != null) queryParams.put("searchCriteria.sourceRefName", sourceRefName);
        if (sourceRepositoryId != null) queryParams.put("searchCriteria.sourceRepositoryId", sourceRepositoryId);
        if (status != null) queryParams.put("searchCriteria.status", status);
        if (targetRefName != null) queryParams.put("searchCriteria.targetRefName", targetRefName);
        return queryParams;
    }
}
