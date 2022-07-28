package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Type of object (Commit, Tree, Blob, Tag) 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum GitObjectType {
	@JsonProperty("bad")
	BAD,
	@JsonProperty("blob")
	BLOB,
	@JsonProperty("commit")
	COMMIT,
	@JsonProperty("ext2")
	EXT2,
	@JsonProperty("ofsDelta")
	OFSDELTA,
	@JsonProperty("refDelta")
	REFDELTA,
	@JsonProperty("tag")
	TAG,
	@JsonProperty("tree")
	TREE;
}