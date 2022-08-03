package org.azd.git.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.GitObjectType;

/**
 * Git object identifier and type information. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitObject extends BaseAbstractMethod {
	/**
 	* Object Id (Sha1Id). 
	**/
	@JsonProperty("objectId")
	private String objectId;
	/**
 	* Type of object (Commit, Tree, Blob, Tag) 
	**/
	@JsonProperty("objectType")
	private GitObjectType objectType;

	public String getObjectId() { return objectId; }

	public void setObjectId(String objectId) { this.objectId = objectId; }

	public GitObjectType getObjectType() { return objectType; }

	public void setObjectType(GitObjectType objectType) { this.objectType = objectType; }

}
