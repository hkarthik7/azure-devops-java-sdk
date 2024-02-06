package org.azd.pipelines.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.Map;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class RunResourcesParameters extends SerializableEntity {

	@JsonProperty("builds")
	private Map<String, BuildResourceParameters> builds;

	@JsonProperty("containers")
	private Map<String, ContainerResourceParameters> containers;

	@JsonProperty("packages")
	private Map<String, PackageResourceParameters> packages;

	@JsonProperty("pipelines")
	private Map<String, PipelineResourceParameters> pipelines;

	@JsonProperty("repositories")
	private Map<String, RepositoryResourceParameters> repositories;

	public Map<String, BuildResourceParameters> getBuilds() { return builds; }

	public void setBuilds(Map<String, BuildResourceParameters> builds) { this.builds = builds; }

	public Map<String, ContainerResourceParameters> getContainers() { return containers; }

	public void setContainers(Map<String, ContainerResourceParameters> containers) { this.containers = containers; }

	public Map<String, PackageResourceParameters> getPackages() { return packages; }

	public void setPackages(Map<String, PackageResourceParameters> packages) { this.packages = packages; }

	public Map<String, PipelineResourceParameters> getPipelines() { return pipelines; }

	public void setPipelines(Map<String, PipelineResourceParameters> pipelines) { this.pipelines = pipelines; }

	public Map<String, RepositoryResourceParameters> getRepositories() { return repositories; }

	public void setRepositories(Map<String, RepositoryResourceParameters> repositories) { this.repositories = repositories; }

}