package org.azd.interfaces;

import org.azd.exceptions.AzDException;
import org.azd.test.types.RunCreateModel;
import org.azd.test.types.TestRun;
import org.azd.test.types.TestRunStatistic;
import org.azd.test.types.TestRuns;

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
}
