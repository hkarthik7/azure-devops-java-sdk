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
 * Represents a request to create a work item comment.
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentCreate extends SerializableEntity {
	/**
 	* The text of the comment. 
	**/
	@JsonProperty("text")
	private String text;

	public String getText() { return text; }

	public void setText(String text) { this.text = text; }
}
