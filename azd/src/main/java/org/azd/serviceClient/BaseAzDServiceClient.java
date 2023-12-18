package org.azd.serviceClient;

import org.azd.accounts.AccountsBaseRequestBuilder;
import org.azd.artifacts.ArtifactsRequestBuilder;
import org.azd.build.BuildBaseRequestBuilder;
import org.azd.core.CoreRequestBuilder;
import org.azd.distributedtask.DistributedTaskRequestBuilder;
import org.azd.enums.Instance;
import org.azd.extensionmanagement.ExtensionManagementRequestBuilder;
import org.azd.http.DefaultRequestAdapter;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.InstanceFactory;

import java.util.Objects;

public class BaseAzDServiceClient {
    public AccountsBaseRequestBuilder accounts() { return new AccountsBaseRequestBuilder(accessTokenCredential, requestAdapter); }

    public ArtifactsRequestBuilder artifacts() { return new ArtifactsRequestBuilder(accessTokenCredential, requestAdapter); }

    public BuildBaseRequestBuilder build() { return new BuildBaseRequestBuilder(accessTokenCredential, requestAdapter); }

    public CoreRequestBuilder core() { return new CoreRequestBuilder(accessTokenCredential, requestAdapter); }

    public DistributedTaskRequestBuilder distributedTask() { return new DistributedTaskRequestBuilder(accessTokenCredential, requestAdapter); }

    public ExtensionManagementRequestBuilder extensionManagement() { return new ExtensionManagementRequestBuilder(accessTokenCredential, requestAdapter); }

    public BaseAzDServiceClient(AccessTokenCredential accessTokenCredential) {
        Objects.requireNonNull(accessTokenCredential);
        this.accessTokenCredential = accessTokenCredential;
        InstanceFactory.registerDefaultBaseInstance(Instance.BASE_INSTANCE.getInstance() + accessTokenCredential.getOrganization());
        this.requestAdapter = InstanceFactory.createDefaultRequestAdapter(accessTokenCredential);
    }

    private final AccessTokenCredential accessTokenCredential;
    private final RequestAdapter requestAdapter;
}
