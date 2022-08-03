package org.azd.git.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * This class contains the metadata of a service/extension posting a status. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitPullRequestMergeOptions extends BaseAbstractMethod {
	/**
 	* If true, conflict resolutions applied during the merge will be put in separate commits to preserve authorship info for git blame, etc. 
	**/
	@JsonProperty("conflictAuthorshipCommits")
	private boolean conflictAuthorshipCommits;

	@JsonProperty("detectRenameFalsePositives")
	private boolean detectRenameFalsePositives;
	/**
 	* If true, rename detection will not be performed during the merge. 
	**/
	@JsonProperty("disableRenames")
	private boolean disableRenames;

	public boolean getConflictAuthorshipCommits() { return conflictAuthorshipCommits; }

	public void setConflictAuthorshipCommits(boolean conflictAuthorshipCommits) { this.conflictAuthorshipCommits = conflictAuthorshipCommits; }

	public boolean getDetectRenameFalsePositives() { return detectRenameFalsePositives; }

	public void setDetectRenameFalsePositives(boolean detectRenameFalsePositives) { this.detectRenameFalsePositives = detectRenameFalsePositives; }

	public boolean getDisableRenames() { return disableRenames; }

	public void setDisableRenames(boolean disableRenames) { this.disableRenames = disableRenames; }

}
