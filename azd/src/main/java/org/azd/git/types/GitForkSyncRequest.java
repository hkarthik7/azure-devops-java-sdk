package org.azd.git.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.GitAsyncOperationStatus;

/**
 * Request to sync data between two forks.
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitForkSyncRequest extends BaseAbstractMethod {
	/**
 	* Collection of related links
	**/
	@JsonProperty("_links")
	private Object _links;
	/**
 	* Status information about a requested fork operation.
	**/
	@JsonProperty("detailedStatus")
	private GitForkOperationStatusDetail detailedStatus;
	/**
 	* Unique identifier for the operation. 
	**/
	@JsonProperty("operationId")
	private Integer operationId;
	/**
 	* Fully-qualified identifier for the source repository. 
	**/
	@JsonProperty("source")
	private GlobalGitRepositoryKey source;
	/**
 	* If supplied, the set of ref mappings to use when performing a "sync" or create. If missing, all refs will be synchronized.
	**/
	@JsonProperty("sourceToTargetRefs")
	private SourceToTargetRef[] sourceToTargetRefs;
	/**
 	*  Comment
	**/
	@JsonProperty("status")
	private GitAsyncOperationStatus status;

	public Object getLinks() {
		return _links;
	}

	public void setLinks(Object _links) {
		this._links = _links;
	}

	public GitForkOperationStatusDetail getDetailedStatus() {
		return detailedStatus;
	}

	public void setDetailedStatus(GitForkOperationStatusDetail detailedStatus) {
		this.detailedStatus = detailedStatus;
	}

	public Integer getOperationId() {
		return operationId;
	}

	public void setOperationId(Integer operationId) {
		this.operationId = operationId;
	}

	public GlobalGitRepositoryKey getSource() {
		return source;
	}

	public void setSource(GlobalGitRepositoryKey source) {
		this.source = source;
	}

	public SourceToTargetRef[] getSourceToTargetRefs() {
		return sourceToTargetRefs;
	}

	public void setSourceToTargetRefs(SourceToTargetRef[] sourceToTargetRefs) {
		this.sourceToTargetRefs = sourceToTargetRefs;
	}

	public GitAsyncOperationStatus getStatus() {
		return status;
	}

	public void setStatus(GitAsyncOperationStatus status) {
		this.status = status;
	}

}

