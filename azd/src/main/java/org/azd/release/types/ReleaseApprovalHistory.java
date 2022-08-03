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
public class ReleaseApprovalHistory extends BaseAbstractMethod {
	/**
 	* Identity of the approver. 
	**/
	@JsonProperty("approver")
	private Author approver;
	/**
 	* Identity of the object who changed approval. 
	**/
	@JsonProperty("changedBy")
	private Author changedBy;
	/**
 	* Approval history comments. 
	**/
	@JsonProperty("comments")
	private String comments;
	/**
 	* Time when this approval created. 
	**/
	@JsonProperty("createdOn")
	private String createdOn;
	/**
 	* Time when this approval modified. 
	**/
	@JsonProperty("modifiedOn")
	private String modifiedOn;
	/**
 	* Approval history revision. 
	**/
	@JsonProperty("revision")
	private int revision;

	public Author getApprover() { return approver; }

	public void setApprover(Author approver) { this.approver = approver; }

	public Author getChangedBy() { return changedBy; }

	public void setChangedBy(Author changedBy) { this.changedBy = changedBy; }

	public String getComments() { return comments; }

	public void setComments(String comments) { this.comments = comments; }

	public String getCreatedOn() { return createdOn; }

	public void setCreatedOn(String createdOn) { this.createdOn = createdOn; }

	public String getModifiedOn() { return modifiedOn; }

	public void setModifiedOn(String modifiedOn) { this.modifiedOn = modifiedOn; }

	public int getRevision() { return revision; }

	public void setRevision(int revision) { this.revision = revision; }

}
