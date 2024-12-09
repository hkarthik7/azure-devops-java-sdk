package org.azd.interfaces;

import org.azd.enums.TestRunPublishContext;
import org.azd.enums.TestRunState;
import org.azd.exceptions.AzDException;
import org.azd.test.types.*;

public interface TestDetails {
    TestRun createTestRun(RunCreateModel runCreateModel) throws AzDException;

    TestRun getTestRunById(int runId) throws AzDException;

    TestRuns getTestRuns() throws AzDException;

    TestRuns getTestRuns(int top) throws AzDException;

    TestRuns getTestRuns(String buildUri) throws AzDException;

    TestRuns getTestRuns(int skip, int top, boolean automated, String buildUri, boolean includeRunDetails, String owner,
                         int planId, String tmiRunId) throws AzDException;

    TestRunStatistic getTestRunStatistics(int runId) throws AzDException;

    Void deleteTestRun(int runId) throws AzDException;

    TestRuns queryTestRuns(String maxLastUpdatedDate, String minLastUpdatedDate) throws AzDException;

    TestRuns queryTestRuns(String maxLastUpdatedDate, String minLastUpdatedDate, int top) throws AzDException;

    TestRuns queryTestRuns(String maxLastUpdatedDate, String minLastUpdatedDate, String[] buildIds) throws AzDException;

    TestRuns queryTestRuns(String maxLastUpdatedDate, String minLastUpdatedDate, TestRunState testRunState) throws AzDException;

    TestRuns queryTestRuns(String maxLastUpdatedDate, String minLastUpdatedDate, String branchName, String[] buildDefIds,
                           String continuationToken, boolean isAutomated,
                           String[] planIds, TestRunPublishContext publishContext, String[] releaseDefIds,
                           String[] releaseEnvDefIds, String[] releaseEnvIds, String[] releaseIds,
                           String runTitle) throws AzDException;

    TestRun updateTestRun(int runId, TestRun testRun) throws AzDException;

    TestCaseResults updateTestResults(int runId, TestCaseResults testCaseResults) throws AzDException;
}
