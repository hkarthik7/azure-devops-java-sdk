package org.azd.build.authorizedresources;

import org.azd.build.types.DefinitionResourceReference;
import org.azd.build.types.DefinitionResourceReferences;
import org.azd.common.ApiVersion;
import org.azd.enums.CustomHeader;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.http.RequestInformation;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Provides the functionality to manage Build Authorized resources Api.
 */
public class AuthorizedResourcesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public AuthorizedResourcesRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "build/authorizedresources", ApiVersion.BUILD_AUTHORIZED_RESOURCES);
    }

    /**
     * Authorize Project Resources.
     * @param definitionResourceReferences Collection of DefinitionResourceReference.
     * @return A future object of collection of DefinitionResourceReference {@link DefinitionResourceReferences}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<DefinitionResourceReferences> authorize(
            List<DefinitionResourceReference> definitionResourceReferences) throws AzDException {
        return requestAdapter.sendAsync(toPatchInformation(definitionResourceReferences), DefinitionResourceReferences.class);
    }

    /**
     * Get a collection of Authorize Project Resources.
     * @return A future object of collection of DefinitionResourceReference {@link DefinitionResourceReferences}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<DefinitionResourceReferences> list() throws AzDException {
        return requestAdapter.sendAsync(toGetInformation(null, null), DefinitionResourceReferences.class);
    }

    /**
     * Get a collection of Authorize Project Resources.
     * @return Collection of DefinitionResourceReference {@link DefinitionResourceReferences}
     * @throws AzDException Default Api exception handler.
     */
    public DefinitionResourceReferences get() throws AzDException {
        var result = requestAdapter.sendStringAsync(toGetInformation(null, null)).join();
        return serializer.deserialize(result, DefinitionResourceReferences.class);
    }

    /**
     * Get a collection of Authorize Project Resources.
     * @param type Type of the authorized resource.
     * @param id ID of the authorized resource.
     * @return Collection of DefinitionResourceReference {@link DefinitionResourceReferences}
     * @throws AzDException Default Api exception handler.
     */
    public DefinitionResourceReferences get(String type, String id) throws AzDException {
        var result = requestAdapter.sendStringAsync(toGetInformation(type, id)).join();
        return serializer.deserialize(result, DefinitionResourceReferences.class);
    }

    /**
     * Constructs the request information for Build Authorized Resources Api.
     * @param definitionResourceReferences Definition references object
     * @return Request information object {@link RequestInformation}
     */
    private RequestInformation toPatchInformation(List<DefinitionResourceReference> definitionResourceReferences) {
        var reqInfo = new RequestInformation();
        reqInfo.requestMethod = RequestMethod.PATCH;
        reqInfo.project = project;
        reqInfo.serviceEndpoint = service;
        reqInfo.apiVersion = apiVersion;
        reqInfo.requestBody = definitionResourceReferences;
        reqInfo.requestHeaders.add(CustomHeader.JSON_PATCH);
        return reqInfo;
    }

    /**
     * Constructs the request information for Build Authorized Resources Api.
     * @param type Type of the authorized resource.
     * @param id ID of the authorized resource.
     * @return Request information object {@link RequestInformation}
     */
    private RequestInformation toGetInformation(String type, String id) {
        var reqInfo = new RequestInformation();
        reqInfo.project = project;
        reqInfo.serviceEndpoint = service;
        if (type != null && id != null) {
            reqInfo.setQueryParameter("type", type);
            reqInfo.setQueryParameter("id", id);
        }
        reqInfo.apiVersion = apiVersion;
        return reqInfo;
    }
}
