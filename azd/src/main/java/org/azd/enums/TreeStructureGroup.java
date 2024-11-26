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
 * Structure group of the classification node, area or iteration. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum TreeStructureGroup {
	@JsonProperty("areas")
	AREAS,
	@JsonProperty("iterations")
	ITERATIONS
}