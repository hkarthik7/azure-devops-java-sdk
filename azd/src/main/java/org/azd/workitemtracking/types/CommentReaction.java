package org.azd.workitemtracking.types;

/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.CommentReactionType;


/**
 * Contains information about work item comment reaction for a particular reaction type.
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentReaction extends SerializableEntity {
	/**
 	* Link references to related REST resources. 
	**/
	@JsonProperty("_links")
	private Object _links;
	/**
 	* The id of the comment this reaction belongs to. 
	**/
	@JsonProperty("commentId")
	private int commentId;
	/**
 	* Total number of reactions for the CommentReactionType. 
	**/
	@JsonProperty("count")
	private int count;
	/**
 	* Flag to indicate if the current user has engaged on this particular EngagementType (e.g. if they liked the associated comment). 
	**/
	@JsonProperty("isCurrentUserEngaged")
	private boolean isCurrentUserEngaged;
	/**
 	* Type of the reaction. 
	**/
	@JsonProperty("type")
	private CommentReactionType type;
	/**
 	* REST URL for the resource. 
	**/
	@JsonProperty("url")
	private String url;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public int getCommentId() { return commentId; }

	public void setCommentId(int commentId) { this.commentId = commentId; }

	public int getCount() { return count; }

	public void setCount(int count) { this.count = count; }

	public Boolean getIsCurrentUserEngaged() { return isCurrentUserEngaged; }

	public void setIsCurrentUserEngaged(Boolean isCurrentUserEngaged) { this.isCurrentUserEngaged = isCurrentUserEngaged; }

	public CommentReactionType getType() { return type; }

	public void setType(CommentReactionType type) { this.type = type; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }
}
