package org.azd.core.processes;

import org.azd.common.ApiVersion;
import org.azd.core.types.Process;
import org.azd.core.types.Processes;
import org.azd.exceptions.AzDException;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Core Processes Api.
 */
public class ProcessesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public ProcessesRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "process/processes", ApiVersion.CORE);
    }

    /***
     * Get a list of processes.
     * @param processId ID for a process.
     * @throws AzDException Default Api Exception handler.
     * @return a list of processes {@link Processes}
     */
    public CompletableFuture<Process> getAsync(String processId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + processId;
        reqInfo.project = null;

        return requestAdapter.sendAsync(reqInfo, Process.class);
    }

    /***
     * Get a list of processes.
     * @throws AzDException Default Api Exception handler.
     * @return a list of processes {@link Processes}
     */
    public CompletableFuture<Processes> listAsync() throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;

        return requestAdapter.sendAsync(reqInfo, Processes.class);
    }

    /***
     * Get a list of processes.
     * @param processId ID for a process.
     * @throws AzDException Default Api Exception handler.
     * @return a list of processes {@link Processes}
     */
    public Process get(String processId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + processId;
        reqInfo.project = null;

        return requestAdapter.send(reqInfo, Process.class);
    }

    /***
     * Get a list of processes.
     * @throws AzDException Default Api Exception handler.
     * @return a list of processes {@link Processes}
     */
    public Processes list() throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;

        return requestAdapter.send(reqInfo, Processes.class);
    }
}
