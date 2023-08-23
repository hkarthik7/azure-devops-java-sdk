package org.azd.serviceClient;

import org.azd.accounts.AccountsBaseRequestBuilder;
import org.azd.artifacts.ArtifactsRequestBuilder;
import org.azd.build.BuildBaseRequestBuilder;
import org.azd.core.CoreRequestBuilder;
import org.azd.enums.Instance;
import org.azd.http.DefaultRequestAdapter;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.InstanceFactory;

public class BaseAzDServiceClient {
    public AccountsBaseRequestBuilder accounts() { return new AccountsBaseRequestBuilder(accessTokenCredential, requestAdapter); }

    public ArtifactsRequestBuilder artifacts() { return new ArtifactsRequestBuilder(accessTokenCredential, requestAdapter); }

    public BuildBaseRequestBuilder build() { return new BuildBaseRequestBuilder(accessTokenCredential, requestAdapter); }

    public CoreRequestBuilder core() { return new CoreRequestBuilder(accessTokenCredential, requestAdapter); }

    public BaseAzDServiceClient(AccessTokenCredential accessTokenCredential) {
        this.accessTokenCredential = accessTokenCredential;
        InstanceFactory.registerDefaultBaseInstance(Instance.BASE_INSTANCE.getInstance() + accessTokenCredential.getOrganization());
        this.requestAdapter = new DefaultRequestAdapter(accessTokenCredential);
    }

    private final AccessTokenCredential accessTokenCredential;
    private final RequestAdapter requestAdapter;
}
