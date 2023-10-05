package org.azd.distributedtask.variablegroups;

import org.azd.common.ApiVersion;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

public class VariableGroupsRequestBuilder extends BaseRequestBuilder {
    public VariableGroupsRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "distributedtask/variablegroups", ApiVersion.DISTRIBUTED_TASK);
    }
}
