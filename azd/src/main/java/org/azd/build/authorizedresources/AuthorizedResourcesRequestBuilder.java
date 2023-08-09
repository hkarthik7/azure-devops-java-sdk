package org.azd.build.authorizedresources;

import org.azd.build.types.DefinitionResourceReference;
import org.azd.build.types.DefinitionResourceReferences;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
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
        return requestAdapter.sendAsync(toPatchRequestInformation(definitionResourceReferences), DefinitionResourceReferences.class);
    }

    /**
     * Get a collection of Authorize Project Resources.
     * @return A future object of collection of DefinitionResourceReference {@link DefinitionResourceReferences}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<DefinitionResourceReferences> list() throws AzDException {
        return requestAdapter.sendAsync(toGetRequestInformation(), DefinitionResourceReferences.class);
    }

    /**
     * Get a collection of Authorize Project Resources.
     * @param type Type of the authorized resource.
     * @param id ID of the authorized resource.
     * @return Collection of DefinitionResourceReference {@link DefinitionResourceReferences}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<DefinitionResourceReferences> list(String type, String id) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.setQueryParameter("type", type);
        reqInfo.setQueryParameter("id", id);

        return requestAdapter.sendAsync(reqInfo, DefinitionResourceReferences.class);
    }
}
