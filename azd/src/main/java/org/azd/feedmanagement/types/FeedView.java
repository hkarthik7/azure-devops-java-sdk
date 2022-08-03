package org.azd.feedmanagement.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.FeedViewType;
import org.azd.enums.FeedVisibility;

/**
 * A view on top of a feed. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedView extends BaseAbstractMethod {
	/**
 	* Related REST links. 
	**/
	@JsonProperty("_links")
	private Object _links;
	/**
 	* Id of the view. 
	**/
	@JsonProperty("id")
	private String id;
	/**
 	* Name of the view. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* Type of view. 
	**/
	@JsonProperty("type")
	private FeedViewType type;
	/**
 	* Url of the view. 
	**/
	@JsonProperty("url")
	private String url;
	/**
 	* Visibility status of the view. 
	**/
	@JsonProperty("visibility")
	private FeedVisibility visibility;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public FeedViewType getType() { return type; }

	public void setType(FeedViewType type) { this.type = type; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

	public FeedVisibility getVisibility() { return visibility; }

	public void setVisibility(FeedVisibility visibility) { this.visibility = visibility; }
}
