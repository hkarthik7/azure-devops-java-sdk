package org.azd.pipelines.types;

/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;


/**
 * Resource pipeline permissions
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourcePipelinePermission extends SerializableEntity {
	/**
	 * All pipelines
	 */
	@JsonProperty("allPipelines")
	private Permission allPipelines;
	/**
	 * Pipelines
	 */
	@JsonProperty("pipelines")
	private List<PipelinePermission> pipelines;
	/**
	 * Resource
	 */
	@JsonProperty("resource")
	private Resource resource;

	public Permission getAllPipelines() { return allPipelines; }

	public void setAllPipelines(Permission allPipelines) { this.allPipelines = allPipelines; }

	public List<PipelinePermission> getPipelines() { return pipelines; }

	public void setPipelines(List<PipelinePermission> pipelines) { this.pipelines = pipelines; }

	public Resource getResource() { return resource; }

	public void setResource(Resource resource) { this.resource = resource; }
}
