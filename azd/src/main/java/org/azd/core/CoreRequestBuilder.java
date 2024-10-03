package org.azd.core;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.core.processes.ProcessesRequestBuilder;
import org.azd.core.projects.ProjectsRequestBuilder;
import org.azd.core.teams.TeamsRequestBuilder;

/**
 * Provides functionality to work with Core Api.
 */
public class CoreRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public CoreRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);

    }

    /**
     * Provides functionality to manage Core processes Api.
     *
     * @return ProcessesRequestBuilder {@link ProcessesRequestBuilder}
     */
    public ProcessesRequestBuilder processes() {
        return new ProcessesRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Core projects Api.
     *
     * @return ProjectsRequestBuilder {@link ProjectsRequestBuilder}
     */
    public ProjectsRequestBuilder projects() {
        return new ProjectsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Core teams Api.
     *
     * @return TeamsRequestBuilder {@link TeamsRequestBuilder}
     */
    public TeamsRequestBuilder teams() {
        return new TeamsRequestBuilder(organizationUrl, accessTokenCredential);
    }
}

