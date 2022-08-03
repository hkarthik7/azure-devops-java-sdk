package org.azd.git.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitCommitChanges extends BaseAbstractMethod {

	@JsonProperty("changeCounts")
	private Object changeCounts;

	@JsonProperty("changes")
	private List<GitChange> changes;

	public Object getChangeCounts() { return changeCounts; }

	public void setChangeCounts(Object changeCounts) { this.changeCounts = changeCounts; }

	public List<GitChange> getChanges() { return changes; }

	public void setChanges(List<GitChange> changes) { this.changes = changes; }

}
