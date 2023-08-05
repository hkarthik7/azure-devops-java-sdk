package org.azd.workitemtracking.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

/**
 * Stores process ID. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcessIdModel extends SerializableEntity {
	/**
 	* The ID of the process. 
	**/
	@JsonProperty("typeId")
	private String typeId;

	public String getTypeId() { return typeId; }

	public void setTypeId(String typeId) { this.typeId = typeId; }

}
