package org.azd.test;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.test.attachments.AttachmentsRequestBuilder;
import org.azd.test.codecoverage.CodeCoverageRequestBuilder;
import org.azd.test.iterations.IterationsRequestBuilder;
import org.azd.test.points.PointsRequestBuilder;
import org.azd.test.results.ResultsRequestBuilder;
import org.azd.test.runs.RunsRequestBuilder;
import org.azd.test.session.SessionRequestBuilder;
import org.azd.test.testcases.TestCasesRequestBuilder;
import org.azd.test.testhistory.TestHistoryRequestBuilder;
import org.azd.test.testsuites.TestSuitesRequestBuilder;

/**
 * Provides functionality to work with Test Api.
 */
public class TestRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public TestRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Test attachments Api.
     *
     * @return AttachmentsRequestBuilder {@link AttachmentsRequestBuilder}
     */
    public AttachmentsRequestBuilder attachments() {
        return new AttachmentsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Test runs Api.
     *
     * @return RunsRequestBuilder {@link RunsRequestBuilder}
     */
    public RunsRequestBuilder runs() {
        return new RunsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Test results Api.
     *
     * @return ResultsRequestBuilder {@link ResultsRequestBuilder}
     */
    public ResultsRequestBuilder results() {
        return new ResultsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Test code coverage Api.
     *
     * @return CodeCoverageRequestBuilder {@link CodeCoverageRequestBuilder}
     */
    public CodeCoverageRequestBuilder codeCoverage() {
        return new CodeCoverageRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Test iterations Api.
     *
     * @return IterationsRequestBuilder {@link IterationsRequestBuilder}
     */
    public IterationsRequestBuilder iterations() {
        return new IterationsRequestBuilder(organizationUrl, accessTokenCredential);
    }
  
    /**
     * Provides functionality to work with Test session Api.
     *
     * @return SessionRequestBuilder {@link SessionRequestBuilder}
     */
    public SessionRequestBuilder session() {
        return new SessionRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Test suites Api.
     *
     * @return TestSuitesRequestBuilder {@link TestSuitesRequestBuilder}
     */
    public TestSuitesRequestBuilder testSuites() {
        return new TestSuitesRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Test cases Api.
     *
     * @return TestCasesRequestBuilder {@link TestCasesRequestBuilder}
     */
    public TestCasesRequestBuilder testCases() {
        return new TestCasesRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Test history Api.
     *
     * @return TestHistoryRequestBuilder {@link TestHistoryRequestBuilder}
     */
    public TestHistoryRequestBuilder testHistory() {
        return new TestHistoryRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Test points Api.
     *
     * @return PointsRequestBuilder {@link PointsRequestBuilder}
     */
    public PointsRequestBuilder points() {
        return new PointsRequestBuilder(organizationUrl, accessTokenCredential);
    }
}
