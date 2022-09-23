package org.azd.git.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * The set of ref mappings to use when performing a sync or create.
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class SourceToTargetRef extends BaseAbstractMethod {
	/**
 	* The source ref to copy. For example, refs/heads/master.
	**/
	@JsonProperty("sourceRef")
	private String sourceRef;
	/**
 	* The target ref to update. For example, refs/heads/master.
	**/
	@JsonProperty("targetRef")
	private String targetRef;

	public String getSourceRef() { return sourceRef; }
	
	public void setSourceRef(String sourceRef) { this.sourceRef = sourceRef; }
	
	public String getTargetRef() { return targetRef; }
	
	public void setTargetRef(String targetRef) { this.targetRef = targetRef; }
	
}
