package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * Get a list of release approvals
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseApprovals extends BaseAbstractMethod {
    /***
     * Get a list of release approvals
     */
    @JsonProperty("value")
    private List<ReleaseApproval> releaseApprovals;

    public List<ReleaseApproval> getReleaseApprovals() {
        return releaseApprovals;
    }

    public void setReleaseApprovals(List<ReleaseApproval> releaseApprovals) {
        this.releaseApprovals = releaseApprovals;
    }

}
