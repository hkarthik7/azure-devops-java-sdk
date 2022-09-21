package org.azd.git.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import org.azd.common.types.BaseAbstractMethod;

/**
 * A list of git repositories.
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitRepositoryRefs extends BaseAbstractMethod {
	/***
     * List of git repositories
     */
    @JsonProperty("value")
    private List<GitRepositoryRef> gitRepositoryRefs;

	public List<GitRepositoryRef> getResourceRefs() {
        return gitRepositoryRefs;
    }

    public void setResourceRefs(List<GitRepositoryRef> gitRepositoryRefs) {
        this.gitRepositoryRefs = gitRepositoryRefs;
    }
}
