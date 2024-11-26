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
 * created and applied to it’s members (default option) or just be tested
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum RuleOption {
	@JsonProperty("applyGroupRule")
	APPLY_GROUP_RULE,

	@JsonProperty("testApplyGroupRule")
	TEST_APPLY_GROUP_RULE;

}