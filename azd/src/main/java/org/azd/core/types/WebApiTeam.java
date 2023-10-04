package org.azd.core.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

/**
 * Represents WebApiTeam
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebApiTeam extends SerializableEntity {
	/**
 	* Team description 
	**/
	@JsonProperty("description")
	private String description;
	/**
 	* Team (Identity) Guid. A Team Foundation ID. 
	**/
	@JsonProperty("id")
	private String id;
	/**
 	* Team identity. 
	**/
	@JsonProperty("identity")
	private Identity identity;
	/**
 	* Identity REST API Url to this team 
	**/
	@JsonProperty("identityUrl")
	private String identityUrl;
	/**
 	* Team name 
	**/
	@JsonProperty("name")
	private String name;

	@JsonProperty("projectId")
	private String projectId;

	@JsonProperty("projectName")
	private String projectName;
	/**
 	* Team REST API Url 
	**/
	@JsonProperty("url")
	private String url;

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public Identity getIdentity() { return identity; }

	public void setIdentity(Identity identity) { this.identity = identity; }

	public String getIdentityUrl() { return identityUrl; }

	public void setIdentityUrl(String identityUrl) { this.identityUrl = identityUrl; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getProjectId() { return projectId; }

	public void setProjectId(String projectId) { this.projectId = projectId; }

	public String getProjectName() { return projectName; }

	public void setProjectName(String projectName) { this.projectName = projectName; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

}