package org.azd.utils;

import org.azd.enums.CustomHeader;
import org.azd.enums.RequestMethod;
import org.azd.http.RequestInformation;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.interfaces.SerializerContext;

public abstract class BaseRequestBuilder {
    protected AccessTokenCredential accessTokenCredential;
    protected RequestAdapter requestAdapter;
    protected SerializerContext serializer = AzDDefaultRegisterFactory.createSerializerContext();
    protected String service;
    protected String subdomain;
    protected String project;
    protected String apiVersion;

    protected BaseRequestBuilder(final AccessTokenCredential accessTokenCredential, final RequestAdapter requestAdapter,
                                 final String subdomain, final String service,  final String apiVersion) {
        this.accessTokenCredential = accessTokenCredential;
        this.requestAdapter = requestAdapter;
        this.project = accessTokenCredential.getProjectName();
        this.service = service;
        this.subdomain = subdomain;
        this.apiVersion = apiVersion;
    }

    protected BaseRequestBuilder(final AccessTokenCredential accessTokenCredential, final RequestAdapter requestAdapter,
                                 final String service, final String apiVersion) {
        this(accessTokenCredential, requestAdapter, null, service, apiVersion);
    }

    protected BaseRequestBuilder(final AccessTokenCredential accessTokenCredential, final RequestAdapter requestAdapter) {
        this(accessTokenCredential, requestAdapter, null, null, null);
    }

    /**
     * Constructs the request information for Build Api.
     * @return RequestInformation object {@link RequestInformation}
     */
    protected RequestInformation toGetRequestInformation() {
        var reqInfo = new RequestInformation();
        reqInfo.subdomain = subdomain;
        reqInfo.project = accessTokenCredential.getProjectName();
        reqInfo.serviceEndpoint = service;
        reqInfo.apiVersion = apiVersion;
        return reqInfo;
    }

    /**
     * Constructs the request information for Artifacts feed management Api.
     * @return RequestInformation object {@link RequestInformation}
     */
    protected RequestInformation toPostRequestInformation(Object requestBody) {
        var reqInfo = new RequestInformation();
        reqInfo.requestMethod = RequestMethod.POST;
        reqInfo.subdomain = subdomain;
        reqInfo.project = accessTokenCredential.getProjectName();
        reqInfo.serviceEndpoint = service;
        reqInfo.apiVersion = apiVersion;
        reqInfo.requestBody = requestBody;
        reqInfo.requestHeaders.add(CustomHeader.JSON_CONTENT_TYPE);
        return reqInfo;
    }

    /**
     * Constructs the request information for Artifacts feed management Api.
     * @return RequestInformation object {@link RequestInformation}
     */
    protected RequestInformation toDeleteRequestInformation() {
        var reqInfo = new RequestInformation();
        reqInfo.requestMethod = RequestMethod.DELETE;
        reqInfo.subdomain = subdomain;
        reqInfo.project = accessTokenCredential.getProjectName();
        reqInfo.serviceEndpoint = service;
        reqInfo.apiVersion = apiVersion;
        return reqInfo;
    }

    /**
     * Constructs the request information for Build Authorized Resources Api.
     * @return Request information object {@link RequestInformation}
     */
    protected RequestInformation toPatchRequestInformation(Object requestBody) {
        var reqInfo = new RequestInformation();
        reqInfo.requestMethod = RequestMethod.PATCH;
        reqInfo.subdomain = subdomain;
        reqInfo.project = accessTokenCredential.getProjectName();
        reqInfo.serviceEndpoint = service;
        reqInfo.apiVersion = apiVersion;
        reqInfo.requestBody = requestBody;
        reqInfo.requestHeaders.add(CustomHeader.JSON_PATCH);
        return reqInfo;
    }
}
