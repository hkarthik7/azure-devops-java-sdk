package org.azd.release.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.ReleaseStatus;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseUpdateMetadata extends SerializableEntity {
	/**
 	* Sets comment for release. 
	**/
	@JsonProperty("comment")
	private String comment;
	/**
 	* Set 'true' to exclude the release from retention policies. 
	**/
	@JsonProperty("keepForever")
	private boolean keepForever;
	/**
 	* Sets list of manual environments. 
	**/
	@JsonProperty("manualEnvironments")
	private String[] manualEnvironments;
	/**
 	* Sets name of the release. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* Sets status of the release. 
	**/
	@JsonProperty("status")
	private ReleaseStatus status;

	public String getComment() { return comment; }

	public void setComment(String comment) { this.comment = comment; }

	public boolean getKeepForever() { return keepForever; }

	public void setKeepForever(boolean keepForever) { this.keepForever = keepForever; }

	public String[] getManualEnvironments() { return manualEnvironments; }

	public void setManualEnvironments(String[] manualEnvironments) { this.manualEnvironments = manualEnvironments; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public ReleaseStatus getStatus() { return status; }

	public void setStatus(ReleaseStatus status) { this.status = status; }

}