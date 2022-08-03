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
 * A Git annotated tag. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitAnnotatedTag extends BaseAbstractMethod {
	/**
 	* The tagging Message 
	**/
	@JsonProperty("message")
	private String message;
	/**
 	* The name of the annotated tag. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* The objectId (Sha1Id) of the tag. 
	**/
	@JsonProperty("objectId")
	private String objectId;
	/**
 	* User info and date of tagging. 
	**/
	@JsonProperty("taggedBy")
	private GitUserDate taggedBy;
	/**
 	* Tagged git object. 
	**/
	@JsonProperty("taggedObject")
	private GitObject taggedObject;

	@JsonProperty("url")
	private String url;

	public String getMessage() { return message; }

	public void setMessage(String message) { this.message = message; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getObjectId() { return objectId; }

	public void setObjectId(String objectId) { this.objectId = objectId; }

	public GitUserDate getTaggedBy() { return taggedBy; }

	public void setTaggedBy(GitUserDate taggedBy) { this.taggedBy = taggedBy; }

	public GitObject getTaggedObject() { return taggedObject; }

	public void setTaggedObject(GitObject taggedObject) { this.taggedObject = taggedObject; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

}
