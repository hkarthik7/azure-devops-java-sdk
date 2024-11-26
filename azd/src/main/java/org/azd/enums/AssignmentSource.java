package org.azd.enums;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Assignment Source of the License (e.g. Group, Unknown etc. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum AssignmentSource {

	@JsonProperty("groupRule")
	GROUP_RULE,

	@JsonProperty("none")
	NONE,

	@JsonProperty("unknown")
	UNKNOWN
}