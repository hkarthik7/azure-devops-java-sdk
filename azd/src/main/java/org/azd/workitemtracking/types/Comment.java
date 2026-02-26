package org.azd.workitemtracking.types;

/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.common.types.Author;
import org.azd.enums.CommentFormat;

import java.util.List;


/**
 * Comment on a Work Item.
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment extends SerializableEntity {
	/**
 	* Link references to related REST resources. 
	**/
	@JsonProperty("_links")
	private Object _links;
	/**
 	* org.azd.common.types.Author of the creator of the comment.
	**/
	@JsonProperty("createdBy")
	private Author createdBy;
	/**
 	* The creation date of the comment. 
	**/
	@JsonProperty("createdDate")
	private String createdDate;
	/**
 	* Effective Date/time value for adding the comment. Can be optionally different from CreatedDate. 
	**/
	@JsonProperty("createdOnBehalfDate")
	private String createdOnBehalfDate;
	/**
 	* Identity on whose behalf this comment has been added. Can be optionally different from CreatedBy. 
	**/
	@JsonProperty("createdOnBehalfOf")
	private Author createdOnBehalfOf;
	/**
 	* Represents the possible types for the comment format. 
	**/
	@JsonProperty("format")
	private CommentFormat format;
	/**
 	* The id assigned to the comment. 
	**/
	@JsonProperty("id")
	private int id;
	/**
 	* Indicates if the comment has been deleted. 
	**/
	@JsonProperty("isDeleted")
	private boolean isDeleted;
	/**
 	* The mentions of the comment. 
	**/
	@JsonProperty("mentions")
	private List<CommentMention> mentions;
	/**
 	* Author of the user who last modified the comment.
	**/
	@JsonProperty("modifiedBy")
	private Author modifiedBy;
	/**
 	* The last modification date of the comment. 
	**/
	@JsonProperty("modifiedDate")
	private String modifiedDate;
	/**
 	* The reactions of the comment. 
	**/
	@JsonProperty("reactions")
	private List<CommentReaction> reactions;
	/**
 	* The text of the comment in HTML format. 
	**/
	@JsonProperty("renderedText")
	private String renderedText;
	/**
 	* The text of the comment. 
	**/
	@JsonProperty("text")
	private String text;
	/**
 	* REST URL for the resource. 
	**/
	@JsonProperty("url")
	private String url;
	/**
 	* The current version of the comment. 
	**/
	@JsonProperty("version")
	private int version;
	/**
 	* The id of the work item this comment belongs to. 
	**/
	@JsonProperty("workItemId")
	private int workItemId;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public Author getCreatedBy() { return createdBy; }

	public void setCreatedBy(Author createdBy) { this.createdBy = createdBy; }

	public String getCreatedDate() { return createdDate; }

	public void setCreatedDate(String createdDate) { this.createdDate = createdDate; }

	public String getCreatedOnBehalfDate() { return createdOnBehalfDate; }

	public void setCreatedOnBehalfDate(String createdOnBehalfDate) { this.createdOnBehalfDate = createdOnBehalfDate; }

	public Author getCreatedOnBehalfOf() { return createdOnBehalfOf; }

	public void setCreatedOnBehalfOf(Author createdOnBehalfOf) { this.createdOnBehalfOf = createdOnBehalfOf; }

	public CommentFormat getFormat() { return format; }

	public void setFormat(CommentFormat format) { this.format = format; }

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public Boolean getIsDeleted() { return isDeleted; }

	public void setIsDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }

	public List<CommentMention> getMentions() { return mentions; }

	public void setMentions(List<CommentMention> mentions) { this.mentions = mentions; }

	public Author getModifiedBy() { return modifiedBy; }

	public void setModifiedBy(Author modifiedBy) { this.modifiedBy = modifiedBy; }

	public String getModifiedDate() { return modifiedDate; }

	public void setModifiedDate(String modifiedDate) { this.modifiedDate = modifiedDate; }

	public List<CommentReaction> getReactions() { return reactions; }

	public void setReactions(List<CommentReaction> reactions) { this.reactions = reactions; }

	public String getRenderedText() { return renderedText; }

	public void setRenderedText(String renderedText) { this.renderedText = renderedText; }

	public String getText() { return text; }

	public void setText(String text) { this.text = text; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

	public int getVersion() { return version; }

	public void setVersion(int version) { this.version = version; }

	public int getWorkItemId() { return workItemId; }

	public void setWorkItemId(int workItemId) { this.workItemId = workItemId; }
}
