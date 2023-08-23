package org.azd.core;

import org.azd.core.processes.ProcessesRequestBuilder;
import org.azd.core.projects.ProjectsRequestBuilder;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

/**
 * Provides functionality to work with Core Api.
 */
public class CoreRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public CoreRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter);
    }

    /**
     * Provides functionality to manage Core processes Api.
     * @return ProcessesRequestBuilder {@link ProcessesRequestBuilder}
     */
    public ProcessesRequestBuilder processes() { return new ProcessesRequestBuilder(accessTokenCredential, requestAdapter); }

    /**
     * Provides functionality to manage Core projects Api.
     * @return ProjectsRequestBuilder {@link ProjectsRequestBuilder}
     */
    public ProjectsRequestBuilder projects() { return new ProjectsRequestBuilder(accessTokenCredential, requestAdapter); }
}
