package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * List of pull request reviewers.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PullRequestReviewers extends BaseAbstractMethod {
    /***
     * List of pull request reviewers.
     */
    @JsonProperty("value")
    private List<IdentityRefWithVote> pullRequestReviewers;


    public List<IdentityRefWithVote> getPullRequestReviewers() {
        return pullRequestReviewers;
    }

    public void setPullRequestReviewers(List<IdentityRefWithVote> pullRequestReviewers) {
        this.pullRequestReviewers = pullRequestReviewers;
    }
}
