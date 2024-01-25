package org.azd.core.processes;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.core.types.Process;
import org.azd.core.types.Processes;
import org.azd.exceptions.AzDException;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Core Processes Api.
 */
public class ProcessesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ProcessesRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "core", "93878975-88c5-4e6a-8abb-7ddd77a8a7d8");
    }

    /**
     * Get a list of processes.
     *
     * @param processId ID for a process.
     * @return a list of processes {@link Processes}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Process> getAsync(String processId) throws AzDException {
        return builder()
                .serviceEndpoint("processId", processId)
                .build()
                .executeAsync(Process.class);
    }

    /**
     * Get a list of processes.
     *
     * @return a list of processes {@link Processes}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Processes> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(Processes.class);
    }

    /**
     * Get a list of processes.
     *
     * @param processId ID for a process.
     * @return a list of processes {@link Processes}
     * @throws AzDException Default Api Exception handler.
     */
    public Process get(String processId) throws AzDException {
        return builder()
                .serviceEndpoint("processId", processId)
                .build()
                .execute(Process.class);
    }

    /**
     * Get a list of processes.
     *
     * @return a list of processes {@link Processes}
     * @throws AzDException Default Api Exception handler.
     */
    public Processes list() throws AzDException {
        return builder()
                .build()
                .execute(Processes.class);
    }
}
