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
import org.azd.enums.ApprovalStatus;
import org.azd.enums.ApprovalType;

import java.util.List;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseApproval extends BaseAbstractMethod {
	/**
 	* Gets or sets the type of approval. 
	**/
	@JsonProperty("approvalType")
	private ApprovalType approvalType;
	/**
 	* Gets the identity who approved. 
	**/
	@JsonProperty("approvedBy")
	private Author approvedBy;
	/**
 	* Gets or sets the identity who should approve. 
	**/
	@JsonProperty("approver")
	private Author approver;
	/**
 	* Gets or sets attempt which specifies as which deployment attempt it belongs. 
	**/
	@JsonProperty("attempt")
	private int attempt;
	/**
 	* Gets or sets comments for approval. 
	**/
	@JsonProperty("comments")
	private String comments;
	/**
 	* Gets date on which it got created. 
	**/
	@JsonProperty("createdOn")
	private String createdOn;
	/**
 	* Gets history which specifies all approvals associated with this approval. 
	**/
	@JsonProperty("history")
	private List<ReleaseApprovalHistory> history;
	/**
 	* Gets the unique identifier of this field. 
	**/
	@JsonProperty("id")
	private int id;
	/**
 	* Gets or sets as approval is automated or not. 
	**/
	@JsonProperty("isAutomated")
	private boolean isAutomated;
	/**
 	* Gets date on which it got modified. 
	**/
	@JsonProperty("modifiedOn")
	private String modifiedOn;
	/**
 	* Gets or sets rank which specifies the order of the approval. e.g. Same rank denotes parallel approval. 
	**/
	@JsonProperty("rank")
	private int rank;
	/**
 	* Gets releaseReference which specifies the reference of the release to which this approval is associated. 
	**/
	@JsonProperty("release")
	private ReleaseShallowReference release;
	/**
 	* Gets releaseDefinitionReference which specifies the reference of the release definition to which this approval is associated. 
	**/
	@JsonProperty("releaseDefinition")
	private ReleaseDefinitionShallowReference releaseDefinition;
	/**
 	* Gets releaseEnvironmentReference which specifies the reference of the release environment to which this approval is associated. 
	**/
	@JsonProperty("releaseEnvironment")
	private ReleaseEnvironmentShallowReference releaseEnvironment;
	/**
 	* Gets the revision number. 
	**/
	@JsonProperty("revision")
	private int revision;
	/**
 	* Gets or sets the status of the approval. 
	**/
	@JsonProperty("status")
	private ApprovalStatus status;
	/**
 	* Gets url to access the approval. 
	**/
	@JsonProperty("url")
	private String url;

	public ApprovalType getApprovalType() { return approvalType; }

	public void setApprovalType(ApprovalType approvalType) { this.approvalType = approvalType; }

	public Author getApprovedBy() { return approvedBy; }

	public void setApprovedBy(Author approvedBy) { this.approvedBy = approvedBy; }

	public Author getApprover() { return approver; }

	public void setApprover(Author approver) { this.approver = approver; }

	public int getAttempt() { return attempt; }

	public void setAttempt(int attempt) { this.attempt = attempt; }

	public String getComments() { return comments; }

	public void setComments(String comments) { this.comments = comments; }

	public String getCreatedOn() { return createdOn; }

	public void setCreatedOn(String createdOn) { this.createdOn = createdOn; }

	public List<ReleaseApprovalHistory> getHistory() { return history; }

	public void setHistory(List<ReleaseApprovalHistory> history) { this.history = history; }

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public boolean getIsAutomated() { return isAutomated; }

	public void setIsAutomated(boolean isAutomated) { this.isAutomated = isAutomated; }

	public String getModifiedOn() { return modifiedOn; }

	public void setModifiedOn(String modifiedOn) { this.modifiedOn = modifiedOn; }

	public int getRank() { return rank; }

	public void setRank(int rank) { this.rank = rank; }

	public ReleaseShallowReference getRelease() { return release; }

	public void setRelease(ReleaseShallowReference release) { this.release = release; }

	public ReleaseDefinitionShallowReference getReleaseDefinition() { return releaseDefinition; }

	public void setReleaseDefinition(ReleaseDefinitionShallowReference releaseDefinition) { this.releaseDefinition = releaseDefinition; }

	public ReleaseEnvironmentShallowReference getReleaseEnvironment() { return releaseEnvironment; }

	public void setReleaseEnvironment(ReleaseEnvironmentShallowReference releaseEnvironment) { this.releaseEnvironment = releaseEnvironment; }

	public int getRevision() { return revision; }

	public void setRevision(int revision) { this.revision = revision; }

	public ApprovalStatus getStatus() { return status; }

	public void setStatus(ApprovalStatus status) { this.status = status; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

}
