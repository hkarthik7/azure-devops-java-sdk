package org.azd.utils;

import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.interfaces.SerializerContext;

public abstract class BaseRequestBuilder {
    protected AccessTokenCredential accessTokenCredential;
    protected RequestAdapter requestAdapter;
    protected SerializerContext serializer = AzDDefaultRegisterFactory.createSerializerContext();
    protected String service;
    protected String project;
    protected String apiVersion;

    protected BaseRequestBuilder(final AccessTokenCredential accessTokenCredential, final RequestAdapter requestAdapter,
                                 final String service, final String apiVersion) {
        this.accessTokenCredential = accessTokenCredential;
        this.requestAdapter = requestAdapter;
        this.project = accessTokenCredential.getProjectName();
        this.service = service;
        this.apiVersion = apiVersion;
    }

    protected BaseRequestBuilder(final AccessTokenCredential accessTokenCredential, final RequestAdapter requestAdapter) {
        this(accessTokenCredential, requestAdapter, null, null);
    }
}
