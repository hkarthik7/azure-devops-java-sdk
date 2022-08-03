package org.azd.git.types;
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
 * User info and date for Git operations. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitPushRef extends BaseAbstractMethod {
	/**
 	* The class to represent a collection of REST reference links. 
	**/
	@JsonProperty("_links")
	private Object _links;

	@JsonProperty("date")
	private String date;

	@JsonProperty("pushId")
	private int pushId;

	@JsonProperty("pushedBy")
	private Author pushedBy;

	@JsonProperty("url")
	private String url;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public String getDate() { return date; }

	public void setDate(String date) { this.date = date; }

	public int getPushId() { return pushId; }

	public void setPushId(int pushId) { this.pushId = pushId; }

	public Author getPushedBy() { return pushedBy; }

	public void setPushedBy(Author pushedBy) { this.pushedBy = pushedBy; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

}
