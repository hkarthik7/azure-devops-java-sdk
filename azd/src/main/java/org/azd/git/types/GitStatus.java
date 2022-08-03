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
import org.azd.enums.GitStatusState;

/**
 * The class to represent a collection of REST reference links. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitStatus extends BaseAbstractMethod {
	/**
 	* Reference links. 
	**/
	@JsonProperty("_links")
	private Object _links;
	/**
 	* Context of the status. 
	**/
	@JsonProperty("context")
	private GitStatusContext context;
	/**
 	* Identity that created the status. 
	**/
	@JsonProperty("createdBy")
	private Author createdBy;
	/**
 	* Creation date and time of the status. 
	**/
	@JsonProperty("creationDate")
	private String creationDate;
	/**
 	* Status description. Typically describes current state of the status. 
	**/
	@JsonProperty("description")
	private String description;
	/**
 	* Status identifier. 
	**/
	@JsonProperty("id")
	private int id;
	/**
 	* State of the status. 
	**/
	@JsonProperty("state")
	private GitStatusState state;
	/**
 	* URL with status details. 
	**/
	@JsonProperty("targetUrl")
	private String targetUrl;
	/**
 	* Last update date and time of the status. 
	**/
	@JsonProperty("updatedDate")
	private String updatedDate;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public GitStatusContext getContext() { return context; }

	public void setContext(GitStatusContext context) { this.context = context; }

	public Author getCreatedBy() { return createdBy; }

	public void setCreatedBy(Author createdBy) { this.createdBy = createdBy; }

	public String getCreationDate() { return creationDate; }

	public void setCreationDate(String creationDate) { this.creationDate = creationDate; }

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public GitStatusState getState() { return state; }

	public void setState(GitStatusState state) { this.state = state; }

	public String getTargetUrl() { return targetUrl; }

	public void setTargetUrl(String targetUrl) { this.targetUrl = targetUrl; }

	public String getUpdatedDate() { return updatedDate; }

	public void setUpdatedDate(String updatedDate) { this.updatedDate = updatedDate; }
}
