package org.azd.utils;

import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.interfaces.SerializerContext;

import java.util.Objects;

public abstract class BaseRequestBuilder {
    protected AccessTokenCredential accessTokenCredential;
    protected RequestAdapter requestAdapter;
    protected SerializerContext serializer = AzDDefaultRegisterFactory.createSerializerContext();
    protected String service;
    protected String project;
    protected String apiVersion;
    protected BaseRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter,
                                 String service, String apiVersion) {
        this.accessTokenCredential = Objects.requireNonNull(accessTokenCredential);
        this.requestAdapter = Objects.requireNonNull(requestAdapter);
        this.service = service;
        this.project = accessTokenCredential.getProjectName();
        this.apiVersion = apiVersion;
    }

    protected BaseRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        this(accessTokenCredential, requestAdapter, null, null);
    }
}
