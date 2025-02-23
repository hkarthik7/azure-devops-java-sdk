package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * Filter to get TestCase result history.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestHistoryQuery extends SerializableEntity {
    /**
     * Automated test name of the TestCase.
     */
    @JsonProperty("automatedTestName")
    private String automatedTestName;
    /**
     * Results to be get for a particular branches.
     */
    @JsonProperty("branch")
    private String branch;
    /**
     * Get the results history only for this BuildDefinitionId. This to get used in query GroupBy should be Branch. If this is provided, Branch will have no use.
     */
    @JsonProperty("buildDefinitionId")
    private Integer buildDefinitionId;
    /**
     * It will be filled by server. If not null means there are some results still to be get, and we need to call this REST API with this ContinuousToken. It is not supposed to be created (or altered, if received from server in last batch) by user.
     */
    @JsonProperty("continuationToken")
    private String continuationToken;
    /**
     * Group the result on the basis of TestResultGroupBy. This can be Branch, Environment or null(if results are fetched by BuildDefinitionId)
     */
    @JsonProperty("groupBy")
    private TestResultGroupBy groupBy;
    /**
     * History to get between time interval MaxCompleteDate and  (MaxCompleteDate - TrendDays). Default is current date time.
     */
    @JsonProperty("maxCompleteDate")
    private String maxCompleteDate;
    /**
     * Get the results history only for this ReleaseEnvDefinitionId. This to get used in query GroupBy should be Environment.
     */
    @JsonProperty("releaseEnvDefinitionId")
    private Integer releaseEnvDefinitionId;
    /**
     * List of TestResultHistoryForGroup which are grouped by GroupBy
     */
    @JsonProperty("resultsForGroup")
    private List<TestResultHistoryForGroup> resultsForGroup;
    /**
     * Get the results history only for this testCaseId. This to get used in query to filter the result along with automatedtestname
     */
    @JsonProperty("testCaseId")
    private Integer testCaseId;
    /**
     of days for which history to collect. Maximum supported value is 7 days. Default is 7 days.
     */
    @JsonProperty("trendDays")
    private Integer trendDays;

    public String getAutomatedTestName() {
        return automatedTestName;
    }

    public void setAutomatedTestName(String automatedTestName) {
        this.automatedTestName = automatedTestName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Integer getBuildDefinitionId() {
        return buildDefinitionId;
    }

    public void setBuildDefinitionId(Integer buildDefinitionId) {
        this.buildDefinitionId = buildDefinitionId;
    }

    public String getContinuationToken() {
        return continuationToken;
    }

    public void setContinuationToken(String continuationToken) {
        this.continuationToken = continuationToken;
    }

    public TestResultGroupBy getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(TestResultGroupBy groupBy) {
        this.groupBy = groupBy;
    }

    public String getMaxCompleteDate() {
        return maxCompleteDate;
    }

    public void setMaxCompleteDate(String maxCompleteDate) {
        this.maxCompleteDate = maxCompleteDate;
    }

    public Integer getReleaseEnvDefinitionId() {
        return releaseEnvDefinitionId;
    }

    public void setReleaseEnvDefinitionId(Integer releaseEnvDefinitionId) {
        this.releaseEnvDefinitionId = releaseEnvDefinitionId;
    }

    public List<TestResultHistoryForGroup> getResultsForGroup() {
        return resultsForGroup;
    }

    public void setResultsForGroup(List<TestResultHistoryForGroup> resultsForGroup) {
        this.resultsForGroup = resultsForGroup;
    }

    public Integer getTestCaseId() {
        return testCaseId;
    }

    public void setTestCaseId(Integer testCaseId) {
        this.testCaseId = testCaseId;
    }

    public Integer getTrendDays() {
        return trendDays;
    }

    public void setTrendDays(Integer trendDays) {
        this.trendDays = trendDays;
    }
}
