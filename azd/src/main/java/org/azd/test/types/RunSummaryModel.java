package org.azd.test.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.enums.TestOutcome;
import org.azd.serializer.SerializableEntity;

/**
 * An abstracted reference to some other resource. This class is used to provide the build data contracts with a uniform way to reference other resources in a way that provides easy traversal through links. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class RunSummaryModel extends SerializableEntity {
	/**
 	* Total time taken in milliseconds. 
	**/
	@JsonProperty("duration")
	private Integer duration;
	/**
 	* Number of results for Outcome TestOutcome 
	**/
	@JsonProperty("resultCount")
	private Integer resultCount;
	/**
 	* Summary is based on outcome 
	**/
	@JsonProperty("testOutcome")
	private TestOutcome testOutcome;

	public Integer getDuration() { return duration; }

	public void setDuration(Integer duration) { this.duration = duration; }

	public Integer getResultCount() { return resultCount; }

	public void setResultCount(Integer resultCount) { this.resultCount = resultCount; }

	public TestOutcome getTestOutcome() { return testOutcome; }

	public void setTestOutcome(TestOutcome testOutcome) { this.testOutcome = testOutcome; }

}