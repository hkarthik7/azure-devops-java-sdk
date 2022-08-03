package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;
import org.azd.common.types.BaseAbstractMethod;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDefinitionApprovalStep extends BaseAbstractMethod {
	/**
 	* Gets and sets the approver. 
	**/
	@JsonProperty("approver")
	private Author approver;
	/**
 	* ID of the approval or deploy step. 
	**/
	@JsonProperty("id")
	private Integer id;
	/**
 	* Indicates whether the approval automated. 
	**/
	@JsonProperty("isAutomated")
	private boolean isAutomated;
	/**
 	* Indicates whether the approval notification set. 
	**/
	@JsonProperty("isNotificationOn")
	private boolean isNotificationOn;
	/**
 	* Gets or sets the rank of approval step. 
	**/
	@JsonProperty("rank")
	private Integer rank;

	public Author getApprover() { return approver; }

	public void setApprover(Author approver) { this.approver = approver; }

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public boolean getIsAutomated() { return isAutomated; }

	public void setIsAutomated(boolean isAutomated) { this.isAutomated = isAutomated; }

	public boolean getIsNotificationOn() { return isNotificationOn; }

	public void setIsNotificationOn(boolean isNotificationOn) { this.isNotificationOn = isNotificationOn; }

	public Integer getRank() { return rank; }

	public void setRank(Integer rank) { this.rank = rank; }

}
