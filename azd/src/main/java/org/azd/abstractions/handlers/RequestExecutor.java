package org.azd.abstractions.handlers;

import org.azd.abstractions.ApiResponse;
import org.azd.abstractions.RequestInformation;
import org.azd.abstractions.ResponseHandler;
import org.azd.authentication.AccessTokenCredential;
import org.azd.exceptions.AzDException;
import org.azd.http.ClientRequest;

public class RequestExecutor {
    private final RequestInformation reqInfo;
    private final AccessTokenCredential accessTokenCredential;

    public RequestExecutor(AccessTokenCredential accessTokenCredential,
                           RequestInformation requestInformation) {
        this.reqInfo = requestInformation;
        this.accessTokenCredential = accessTokenCredential;
    }

    public ApiResponse execute() throws AzDException {
        ClientRequest.builder(accessTokenCredential)
                .request(reqInfo)
                .build()
                .executeStringAsync()
                .join();
        return ResponseHandler.getResponse();
    }
}
