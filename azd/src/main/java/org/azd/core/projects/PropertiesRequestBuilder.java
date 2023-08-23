package org.azd.core.projects;

import org.azd.common.ApiVersion;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

public class PropertiesRequestBuilder extends BaseRequestBuilder {
    public PropertiesRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "projects", ApiVersion.PROJECT_PROPERTIES);
    }


}
