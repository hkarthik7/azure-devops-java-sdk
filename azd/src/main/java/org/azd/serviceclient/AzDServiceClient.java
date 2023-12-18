package org.azd.serviceclient;

import org.azd.interfaces.AccessTokenCredential;

public class AzDServiceClient extends BaseAzDServiceClient {
    public AzDServiceClient(AccessTokenCredential accessTokenCredential) {
        super(accessTokenCredential);
    }
}
