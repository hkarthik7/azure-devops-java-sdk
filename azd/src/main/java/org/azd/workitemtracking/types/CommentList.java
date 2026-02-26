package org.azd.workitemtracking.types;

/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;


/**
 * Represents a list of work item comments.
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentList extends SerializableEntity {
	/**
 	* Link references to related REST resources. 
	**/
	@JsonProperty("_links")
	private Object _links;
	/**
 	* List of comments in the current batch. 
	**/
	@JsonProperty("comments")
	private List<Comment> comments;
	/**
 	* A string token that can be used to retrieving next page of comments if available. Otherwise null. 
	**/
	@JsonProperty("continuationToken")
	private String continuationToken;
	/**
 	* The count of comments in the current batch. 
	**/
	@JsonProperty("count")
	private int count;
	/**
 	* Uri to the next page of comments if it is available. Otherwise null. 
	**/
	@JsonProperty("nextPage")
	private String nextPage;
	/**
 	* Total count of comments on a work item. 
	**/
	@JsonProperty("totalCount")
	private int totalCount;
	/**
 	* REST URL for the resource. 
	**/
	@JsonProperty("url")
	private String url;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public List<Comment> getComments() { return comments; }

	public void setComments(List<Comment> comments) { this.comments = comments; }

	public String getContinuationToken() { return continuationToken; }

	public void setContinuationToken(String continuationToken) { this.continuationToken = continuationToken; }

	public int getCount() { return count; }

	public void setCount(int count) { this.count = count; }

	public String getNextPage() { return nextPage; }

	public void setNextPage(String nextPage) { this.nextPage = nextPage; }

	public int getTotalCount() { return totalCount; }

	public void setTotalCount(int totalCount) { this.totalCount = totalCount; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }
}
