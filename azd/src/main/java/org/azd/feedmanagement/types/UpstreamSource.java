package org.azd.feedmanagement.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.UpstreamSourceType;
import org.azd.enums.UpstreamStatus;

import java.util.List;

/**
 * Source type, such as Public or Internal. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpstreamSource extends BaseAbstractMethod {
	/**
 	* UTC date that this upstream was deleted. 
	**/
	@JsonProperty("deletedDate")
	private String deletedDate;
	/**
 	* Locator for connecting to the upstream source in a user friendly format, that may potentially change over time 
	**/
	@JsonProperty("displayLocation")
	private String displayLocation;
	/**
 	* Identity of the upstream source. 
	**/
	@JsonProperty("id")
	private String id;
	/**
 	* For an internal upstream type, track the Azure DevOps organization that contains it. 
	**/
	@JsonProperty("internalUpstreamCollectionId")
	private String internalUpstreamCollectionId;
	/**
 	* For an internal upstream type, track the feed id being referenced. 
	**/
	@JsonProperty("internalUpstreamFeedId")
	private String internalUpstreamFeedId;
	/**
 	* For an internal upstream type, track the project of the feed being referenced. 
	**/
	@JsonProperty("internalUpstreamProjectId")
	private String internalUpstreamProjectId;
	/**
 	* For an internal upstream type, track the view of the feed being referenced. 
	**/
	@JsonProperty("internalUpstreamViewId")
	private String internalUpstreamViewId;
	/**
 	* Consistent locator for connecting to the upstream source. 
	**/
	@JsonProperty("location")
	private String location;
	/**
 	* Display name. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* Package type associated with the upstream source. 
	**/
	@JsonProperty("protocol")
	private String protocol;
	/**
 	* The identity of the service endpoint that holds credentials to use when accessing the upstream. 
	**/
	@JsonProperty("serviceEndpointId")
	private String serviceEndpointId;
	/**
 	* Specifies the projectId of the Service Endpoint. 
	**/
	@JsonProperty("serviceEndpointProjectId")
	private String serviceEndpointProjectId;
	/**
 	* Specifies the status of the upstream. 
	**/
	@JsonProperty("status")
	private UpstreamStatus status;
	/**
 	* Provides a human-readable reason for the status of the upstream. 
	**/
	@JsonProperty("statusDetails")
	private List<UpstreamStatusDetail> statusDetails;
	/**
 	* Source type, such as Public or Internal. 
	**/
	@JsonProperty("upstreamSourceType")
	private UpstreamSourceType upstreamSourceType;

	public String getDeletedDate() { return deletedDate; }

	public void setDeletedDate(String deletedDate) { this.deletedDate = deletedDate; }

	public String getDisplayLocation() { return displayLocation; }

	public void setDisplayLocation(String displayLocation) { this.displayLocation = displayLocation; }

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public String getInternalUpstreamCollectionId() { return internalUpstreamCollectionId; }

	public void setInternalUpstreamCollectionId(String internalUpstreamCollectionId) { this.internalUpstreamCollectionId = internalUpstreamCollectionId; }

	public String getInternalUpstreamFeedId() { return internalUpstreamFeedId; }

	public void setInternalUpstreamFeedId(String internalUpstreamFeedId) { this.internalUpstreamFeedId = internalUpstreamFeedId; }

	public String getInternalUpstreamProjectId() { return internalUpstreamProjectId; }

	public void setInternalUpstreamProjectId(String internalUpstreamProjectId) { this.internalUpstreamProjectId = internalUpstreamProjectId; }

	public String getInternalUpstreamViewId() { return internalUpstreamViewId; }

	public void setInternalUpstreamViewId(String internalUpstreamViewId) { this.internalUpstreamViewId = internalUpstreamViewId; }

	public String getLocation() { return location; }

	public void setLocation(String location) { this.location = location; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getProtocol() { return protocol; }

	public void setProtocol(String protocol) { this.protocol = protocol; }

	public String getServiceEndpointId() { return serviceEndpointId; }

	public void setServiceEndpointId(String serviceEndpointId) { this.serviceEndpointId = serviceEndpointId; }

	public String getServiceEndpointProjectId() { return serviceEndpointProjectId; }

	public void setServiceEndpointProjectId(String serviceEndpointProjectId) { this.serviceEndpointProjectId = serviceEndpointProjectId; }

	public UpstreamStatus getStatus() { return status; }

	public void setStatus(UpstreamStatus status) { this.status = status; }

	public List<UpstreamStatusDetail> getStatusDetails() { return statusDetails; }

	public void setStatusDetails(List<UpstreamStatusDetail> statusDetails) { this.statusDetails = statusDetails; }

	public UpstreamSourceType getUpstreamSourceType() { return upstreamSourceType; }

	public void setUpstreamSourceType(UpstreamSourceType upstreamSourceType) { this.upstreamSourceType = upstreamSourceType; }

}
