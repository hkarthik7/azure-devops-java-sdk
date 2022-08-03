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
 * Identity information including a vote on a pull request.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class IdentityRefWithVote extends BaseAbstractMethod {
	/**
	 * This field contains zero or more interesting links about the graph subject. These links may be invoked to obtain additional relationships or more detailed information about this graph subject.
	 **/
	@JsonProperty("_links")
	private Object _links;
	/**
	 * The descriptor is the primary way to reference the graph subject while the system is running. This field will uniquely identify the same graph subject across both Accounts and Organizations.
	 **/
	@JsonProperty("descriptor")
	private String descriptor;
	/**
	 * Deprecated - Can be retrieved by querying the Graph user referenced in the "self" entry of the IdentityRef "_links" dictionary
	 **/
	@JsonProperty("directoryAlias")
	private String directoryAlias;
	/**
	 * This is the non-unique display name of the graph subject. To change this field, you must alter its value in the source provider.
	 **/
	@JsonProperty("displayName")
	private String displayName;
	/**
	 * Indicates if this reviewer has declined to review this pull request.
	 **/
	@JsonProperty("hasDeclined")
	private boolean hasDeclined;

	@JsonProperty("id")
	private String id;
	/**
	 * Deprecated - Available in the "avatar" entry of the IdentityRef "_links" dictionary
	 **/
	@JsonProperty("imageUrl")
	private String imageUrl;
	/**
	 * Deprecated - Can be retrieved by querying the Graph membership state referenced in the "membershipState" entry of the GraphUser "_links" dictionary
	 **/
	@JsonProperty("inactive")
	private boolean inactive;
	/**
	 * Deprecated - Can be inferred from the subject type of the descriptor (Descriptor.IsAadUserType/Descriptor.IsAadGroupType)
	 **/
	@JsonProperty("isAadIdentity")
	private boolean isAadIdentity;
	/**
	 * Deprecated - Can be inferred from the subject type of the descriptor (Descriptor.IsGroupType)
	 **/
	@JsonProperty("isContainer")
	private boolean isContainer;

	@JsonProperty("isDeletedInOrigin")
	private boolean isDeletedInOrigin;
	/**
	 * Indicates if this reviewer is flagged for attention on this pull request.
	 **/
	@JsonProperty("isFlagged")
	private boolean isFlagged;
	/**
	 * Indicates if this is a required reviewer for this pull request.  Branches can have policies that require particular reviewers are required for pull requests.
	 **/
	@JsonProperty("isRequired")
	private boolean isRequired;
	/**
	 * Deprecated - not in use in most preexisting implementations of ToIdentityRef
	 **/
	@JsonProperty("profileUrl")
	private String profileUrl;
	/**
	 * URL to retrieve information about this identity
	 **/
	@JsonProperty("reviewerUrl")
	private String reviewerUrl;
	/**
	 * Deprecated - use Domain+PrincipalName instead
	 **/
	@JsonProperty("uniqueName")
	private String uniqueName;
	/**
	 * This url is the full route to the source resource of this graph subject.
	 **/
	@JsonProperty("url")
	private String url;
	/**
	 * Vote on a pull request: 10 - approved 5 - approved with suggestions 0 - no vote -5 - waiting for author -10 - rejected
	 **/
	@JsonProperty("vote")
	private int vote;
	/**
	 * Groups or teams that that this reviewer contributed to.  Groups and teams can be reviewers on pull requests but can not vote directly.  When a member of the group or team votes, that vote is rolled up into the group or team vote.  VotedFor is a list of such votes.
	 **/
	@JsonProperty("votedFor")
	private List<IdentityRefWithVote> votedFor;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public String getDescriptor() { return descriptor; }

	public void setDescriptor(String descriptor) { this.descriptor = descriptor; }

	public String getDirectoryAlias() { return directoryAlias; }

	public void setDirectoryAlias(String directoryAlias) { this.directoryAlias = directoryAlias; }

	public String getDisplayName() { return displayName; }

	public void setDisplayName(String displayName) { this.displayName = displayName; }

	public boolean getHasDeclined() { return hasDeclined; }

	public void setHasDeclined(boolean hasDeclined) { this.hasDeclined = hasDeclined; }

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public String getImageUrl() { return imageUrl; }

	public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

	public boolean getInactive() { return inactive; }

	public void setInactive(boolean inactive) { this.inactive = inactive; }

	public boolean getIsAadIdentity() { return isAadIdentity; }

	public void setIsAadIdentity(boolean isAadIdentity) { this.isAadIdentity = isAadIdentity; }

	public boolean getIsContainer() { return isContainer; }

	public void setIsContainer(boolean isContainer) { this.isContainer = isContainer; }

	public boolean getIsDeletedInOrigin() { return isDeletedInOrigin; }

	public void setIsDeletedInOrigin(boolean isDeletedInOrigin) { this.isDeletedInOrigin = isDeletedInOrigin; }

	public boolean getIsFlagged() { return isFlagged; }

	public void setIsFlagged(boolean isFlagged) { this.isFlagged = isFlagged; }

	public boolean getIsRequired() { return isRequired; }

	public void setIsRequired(boolean isRequired) { this.isRequired = isRequired; }

	public String getProfileUrl() { return profileUrl; }

	public void setProfileUrl(String profileUrl) { this.profileUrl = profileUrl; }

	public String getReviewerUrl() { return reviewerUrl; }

	public void setReviewerUrl(String reviewerUrl) { this.reviewerUrl = reviewerUrl; }

	public String getUniqueName() { return uniqueName; }

	public void setUniqueName(String uniqueName) { this.uniqueName = uniqueName; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

	public int getVote() { return vote; }

	public void setVote(int vote) { this.vote = vote; }

	public List<IdentityRefWithVote> getVotedFor() { return votedFor; }

	public void setVotedFor(List<IdentityRefWithVote> votedFor) { this.votedFor = votedFor; }

}
