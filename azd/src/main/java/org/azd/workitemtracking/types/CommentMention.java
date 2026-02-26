package org.azd.workitemtracking.types;

/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;


/**
 * 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentMention extends SerializableEntity {
	/**
 	* Link references to related REST resources. 
	**/
	@JsonProperty("_links")
	private Object _links;
	/**
 	* The artifact portion of the parsed text. (i.e. the work item's id) 
	**/
	@JsonProperty("artifactId")
	private String artifactId;
	/**
 	* The type the parser assigned to the mention. (i.e. person, work item, etc) 
	**/
	@JsonProperty("artifactType")
	private String artifactType;
	/**
 	* The comment id of the mention. 
	**/
	@JsonProperty("commentId")
	private int commentId;
	/**
 	* The resolved target of the mention. An example of this could be a user's tfid 
	**/
	@JsonProperty("targetId")
	private String targetId;
	/**
 	* REST URL for the resource. 
	**/
	@JsonProperty("url")
	private String url;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public String getArtifactId() { return artifactId; }

	public void setArtifactId(String artifactId) { this.artifactId = artifactId; }

	public String getArtifactType() { return artifactType; }

	public void setArtifactType(String artifactType) { this.artifactType = artifactType; }

	public int getCommentId() { return commentId; }

	public void setCommentId(int commentId) { this.commentId = commentId; }

	public String getTargetId() { return targetId; }

	public void setTargetId(String targetId) { this.targetId = targetId; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }
}
