package org.azd.test.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

import java.util.List;

/**
 * Test run statistics. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestRunStatistic extends SerializableEntity {
	/**
 	* An abstracted reference to some other resource. This class is used to provide the build data contracts with a uniform way to reference other resources in a way that provides easy traversal through links. 
	**/
	@JsonProperty("run")
	private ShallowReference run;
	/**
 	* Test run statistics per outcome. 
	**/
	@JsonProperty("runStatistics")
	private List<RunStatistic> runStatistics;

	public ShallowReference getRun() { return run; }

	public void setRun(ShallowReference run) { this.run = run; }

	public List<RunStatistic> getRunStatistics() { return runStatistics; }

	public void setRunStatistics(List<RunStatistic> runStatistics) { this.runStatistics = runStatistics; }

}