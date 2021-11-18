package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * List of pull request reviewers.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PullRequestReviewers {
    /***
     * List of pull request reviewers.
     */
    @JsonProperty("value")
    private List<PullRequestReviewer> pullRequestReviewers;

    @Override
    public String toString() {
        return "PullRequestReviewers{" +
                "pullRequestReviewers=" + pullRequestReviewers +
                '}';
    }

    public List<PullRequestReviewer> getPullRequestReviewers() {
        return pullRequestReviewers;
    }

    public void setPullRequestReviewers(List<PullRequestReviewer> pullRequestReviewers) {
        this.pullRequestReviewers = pullRequestReviewers;
    }
}
