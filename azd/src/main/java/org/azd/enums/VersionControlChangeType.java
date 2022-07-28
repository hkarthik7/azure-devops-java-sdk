package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum VersionControlChangeType {
	@JsonProperty("add")
	ADD,
	@JsonProperty("all")
	ALL,
	@JsonProperty("branch")
	BRANCH,
	@JsonProperty("delete")
	DELETE,
	@JsonProperty("edit")
	EDIT,
	@JsonProperty("encoding")
	ENCODING,
	@JsonProperty("lock")
	LOCK,
	@JsonProperty("merge")
	MERGE,
	@JsonProperty("none")
	NONE,
	@JsonProperty("property")
	PROPERTY,
	@JsonProperty("rename")
	RENAME,
	@JsonProperty("rollback")
	ROLLBACK,
	@JsonProperty("sourceRename")
	SOURCERENAME,
	@JsonProperty("targetRename")
	TARGETRENAME,
	@JsonProperty("undelete")
	UNDELETE;
}