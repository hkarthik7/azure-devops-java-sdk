package org.azd.memberentitlementmanagement.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.OperationStatus;

import java.util.List;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServicePrincipalEntitlementOperationReference extends SerializableEntity {
	/**
 	* Operation completed with success or failure. 
	**/
	@JsonProperty("completed")
	private boolean completed;
	/**
 	* True if all operations were successful. 
	**/
	@JsonProperty("haveResultsSucceeded")
	private boolean haveResultsSucceeded;
	/**
 	* Unique identifier for the operation. 
	**/
	@JsonProperty("id")
	private String id;
	/**
 	* Unique identifier for the plugin. 
	**/
	@JsonProperty("pluginId")
	private String pluginId;
	/**
 	* List of results for each operation. 
	**/
	@JsonProperty("results")
	private List<ServicePrincipalEntitlementOperationResult> results;
	/**
 	* The current status of the operation. 
	**/
	@JsonProperty("status")
	private OperationStatus status;
	/**
 	* URL to get the full operation object. 
	**/
	@JsonProperty("url")
	private String url;

	public boolean getCompleted() { return completed; }

	public void setCompleted(boolean completed) { this.completed = completed; }

	public boolean getHaveResultsSucceeded() { return haveResultsSucceeded; }

	public void setHaveResultsSucceeded(boolean haveResultsSucceeded) { this.haveResultsSucceeded = haveResultsSucceeded; }

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public String getPluginId() { return pluginId; }

	public void setPluginId(String pluginId) { this.pluginId = pluginId; }

	public List<ServicePrincipalEntitlementOperationResult> getResults() { return results; }

	public void setResults(List<ServicePrincipalEntitlementOperationResult> results) { this.results = results; }

	public OperationStatus getStatus() { return status; }

	public void setStatus(OperationStatus status) { this.status = status; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

}