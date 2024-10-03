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
 * RuleOption [ApplyGroupRule/TestApplyGroupRule] - specifies if the rules defined in group entitlement should be
 * created and applied to members (default option) or just be tested
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ProjectPermissionInherited {
	@JsonProperty("inherited")
	INHERITED,

	@JsonProperty("notInherited")
	NOT_INHERITED,

	@JsonProperty("notSet")
	NOT_SET
}