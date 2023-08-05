package org.azd.serviceClient;

import org.azd.interfaces.AccessTokenCredential;

public class AzDServiceClient extends BaseAzDServiceClient {
    public AzDServiceClient(AccessTokenCredential accessTokenCredential) {
        super(accessTokenCredential);
    }
}
