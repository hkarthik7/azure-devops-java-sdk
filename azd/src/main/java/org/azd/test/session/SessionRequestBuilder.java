package org.azd.test.session;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.TestSessionSource;
import org.azd.exceptions.AzDException;
import org.azd.test.types.TestSession;
import org.azd.test.types.TestSessions;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Test session Api.
 */
public class SessionRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public SessionRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "test", "1500b4b4-6c69-4ca6-9b18-35e9e97fe2ac", ApiVersion.TEST_SESSION);
    }

    /**
     * Create a test session.
     *
     * @param projectTeam Team ID or team name.
     * @param testSession Session create model object to create a test session.
     * @return Test session Object {@link TestSession}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<TestSession> createAsync(String projectTeam, TestSession testSession) throws AzDException {
        return builder()
                .serviceEndpoint("team", projectTeam)
                .POST(testSession)
                .build()
                .executeAsync(TestSession.class);
    }

    /**
     * Get a list of test sessions.
     *
     * @param projectTeam Team ID or team name.
     * @return Array of Test session Object {@link TestSessions}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<TestSessions> listAsync(String projectTeam) throws AzDException {
        return builder()
                .serviceEndpoint("team", projectTeam)
                .build()
                .executeAsync(TestSessions.class);
    }

    /**
     * Get a list of test sessions.
     *
     * @param projectTeam Team ID or team name.
     * @param requestConfiguration Represents the query parameters.
     * @return Array of Test session Object {@link TestSessions}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<TestSessions> listAsync(String projectTeam, Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("team", projectTeam)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(TestSessions.class);
    }

    /**
     * Update a test session
     *
     * @param projectTeam Team ID or team name.
     * @param testSession Session create model object to create a test session.
     * @return Test session Object {@link TestSession}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<TestSession> updateAsync(String projectTeam, TestSession testSession) throws AzDException {
        return builder()
                .serviceEndpoint("team", projectTeam)
                .PATCH(testSession)
                .build()
                .executeAsync(TestSession.class);
    }

    /**
     * Create a test session.
     *
     * @param projectTeam Team ID or team name.
     * @param testSession Session create model object to create a test session.
     * @return Test session Object {@link TestSession}
     * @throws AzDException Default Api Exception handler.
     **/
    public TestSession create(String projectTeam, TestSession testSession) throws AzDException {
        return builder()
                .serviceEndpoint("team", projectTeam)
                .POST(testSession)
                .build()
                .execute(TestSession.class);
    }

    /**
     * Get a list of test sessions.
     *
     * @param projectTeam Team ID or team name.
     * @return Array of Test session Object {@link TestSessions}
     * @throws AzDException Default Api Exception handler.
     **/
    public TestSessions list(String projectTeam) throws AzDException {
        return builder()
                .serviceEndpoint("team", projectTeam)
                .build()
                .execute(TestSessions.class);
    }

    /**
     * Get a list of test sessions.
     *
     * @param projectTeam Team ID or team name.
     * @param requestConfiguration Represents the query parameters.
     * @return Array of Test session Object {@link TestSessions}
     * @throws AzDException Default Api Exception handler.
     **/
    public TestSessions list(String projectTeam, Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("team", projectTeam)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(TestSessions.class);
    }

    /**
     * Update a test session
     *
     * @param projectTeam Team ID or team name.
     * @param testSession Session create model object to create a test session.
     * @return Test session Object {@link TestSession}
     * @throws AzDException Default Api Exception handler.
     **/
    public TestSession update(String projectTeam, TestSession testSession) throws AzDException {
        return builder()
                .serviceEndpoint("team", projectTeam)
                .PATCH(testSession)
                .build()
                .execute(TestSession.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * If false, returns test sessions for current user. Otherwise, it returns test sessions for all users
         */
        @QueryParameter(name = "allSessions")
        public Boolean allSessions;
        /**
         * If true, it returns all properties of the test sessions. Otherwise, it returns the skinny version.
         */
        @QueryParameter(name = "includeAllProperties")
        public Boolean includeAllProperties;
        /**
         * If true, it returns test sessions in completed state. Otherwise, it returns test sessions for all states
         */
        @QueryParameter(name = "includeOnlyCompletedSessions")
        public Boolean includeOnlyCompletedSessions;
        /**
         * Period in days from now, for which test sessions are fetched.
         */
        @QueryParameter(name = "period")
        public Integer period;
        /**
         * Source of the test session.
         */
        @QueryParameter(name = "source")
        public TestSessionSource source;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}
