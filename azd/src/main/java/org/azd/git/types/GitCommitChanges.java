package org.azd.git.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitCommitChanges {

	@JsonProperty("changeCounts")
	private Object changeCounts;

	@JsonProperty("changes")
	private List<GitChange> changes;

	public Object getChangeCounts() { return changeCounts; }

	public void setChangeCounts(Object changeCounts) { this.changeCounts = changeCounts; }

	public List<GitChange> getChanges() { return changes; }

	public void setChanges(List<GitChange> changes) { this.changes = changes; }

	@Override
	public String toString() {
		return "GitCommitChanges{" +
				"changeCounts=" + changeCounts +
				", changes=" + changes +
				'}';
	}
}