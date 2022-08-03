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

import java.util.List;

/**
 * This class contains the metadata of a service/extension posting a status. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitRef extends BaseAbstractMethod {
	/**
 	* The class to represent a collection of REST reference links. 
	**/
	@JsonProperty("_links")
	private Object _links;

	@JsonProperty("creator")
	private Author creator;

	@JsonProperty("isLocked")
	private boolean isLocked;

	@JsonProperty("isLockedBy")
	private Author isLockedBy;

	@JsonProperty("name")
	private String name;

	@JsonProperty("objectId")
	private String objectId;

	@JsonProperty("peeledObjectId")
	private String peeledObjectId;
	/**
 	* This class contains the metadata of a service/extension posting a status. 
	**/
	@JsonProperty("statuses")
	private List<GitStatus> statuses;

	@JsonProperty("url")
	private String url;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public Author getCreator() { return creator; }

	public void setCreator(Author creator) { this.creator = creator; }

	public boolean getIsLocked() { return isLocked; }

	public void setIsLocked(boolean isLocked) { this.isLocked = isLocked; }

	public Author getIsLockedBy() { return isLockedBy; }

	public void setIsLockedBy(Author isLockedBy) { this.isLockedBy = isLockedBy; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getObjectId() { return objectId; }

	public void setObjectId(String objectId) { this.objectId = objectId; }

	public String getPeeledObjectId() { return peeledObjectId; }

	public void setPeeledObjectId(String peeledObjectId) { this.peeledObjectId = peeledObjectId; }

	public List<GitStatus> getStatuses() { return statuses; }

	public void setStatuses(List<GitStatus> statuses) { this.statuses = statuses; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

}
