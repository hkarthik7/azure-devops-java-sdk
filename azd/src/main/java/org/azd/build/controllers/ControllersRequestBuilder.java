package org.azd.build.controllers;

import org.azd.build.types.BuildController;
import org.azd.build.types.BuildControllers;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.concurrent.CompletableFuture;

/**
 * Provides the functionality to manage Build Controllers Api.
 */
public class ControllersRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public ControllersRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "build/controllers", ApiVersion.BUILD_CONTROLLERS);
    }

    /***
     * Gets a controller
     * @param controllerId pass the controller id
     * @throws AzDException Default Api Exception handler.
     * @return build controller {@link BuildController}
     */
    public CompletableFuture<BuildController> getAsync(int controllerId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + controllerId;

        return requestAdapter.sendAsync(reqInfo, BuildController.class);
    }

    /***
     * Gets controllers
     * @throws AzDException Default Api Exception handler.
     * @return array of build controller {@link BuildControllers}
     */
    public CompletableFuture<BuildControllers> listAsync() throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;

        return requestAdapter.sendAsync(reqInfo, BuildControllers.class);
    }

    /***
     * Gets controller, optionally filtered by name
     * @param name pass the controller name
     * @throws AzDException Default Api Exception handler.
     * @return array of build controller {@link BuildControllers}
     */
    public CompletableFuture<BuildControllers> listAsync(String name) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.setQueryParameter("name", name);
        reqInfo.project = null;

        return requestAdapter.sendAsync(reqInfo, BuildControllers.class);
    }

    /***
     * Gets a controller
     * @param controllerId pass the controller id
     * @throws AzDException Default Api Exception handler.
     * @return build controller {@link BuildController}
     */
    public BuildController get(int controllerId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + controllerId;

        return requestAdapter.send(reqInfo, BuildController.class);
    }

    /***
     * Gets controllers
     * @throws AzDException Default Api Exception handler.
     * @return array of build controller {@link BuildControllers}
     */
    public BuildControllers list() throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;

        return requestAdapter.send(reqInfo, BuildControllers.class);
    }

    /***
     * Gets controller, optionally filtered by name
     * @param name pass the controller name
     * @throws AzDException Default Api Exception handler.
     * @return array of build controller {@link BuildControllers}
     */
    public BuildControllers list(String name) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.setQueryParameter("name", name);
        reqInfo.project = null;

        return requestAdapter.send(reqInfo, BuildControllers.class);
    }
}
