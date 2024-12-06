package org.azd.test;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.test.results.ResultsRequestBuilder;
import org.azd.test.runs.RunsRequestBuilder;

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
}
