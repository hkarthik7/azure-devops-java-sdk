package org.azd.build.controllers;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.build.types.BuildController;
import org.azd.build.types.BuildControllers;
import org.azd.exceptions.AzDException;

import java.util.concurrent.CompletableFuture;

/**
 * Provides the functionality to manage Build Controllers Api.
 */
public class ControllersRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ControllersRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "build", "fcac1932-2ee1-437f-9b6f-7f696be858f6");
    }

    /***
     * Gets a controller
     * @param controllerId pass the controller id
     * @throws AzDException Default Api Exception handler.
     * @return build controller {@link BuildController}
     */
    public CompletableFuture<BuildController> getAsync(int controllerId) throws AzDException {
        return builder()
                .serviceEndpoint("controllerId", controllerId)
                .build()
                .executeAsync(BuildController.class);
    }

    /***
     * Gets controllers
     * @throws AzDException Default Api Exception handler.
     * @return array of build controller {@link BuildControllers}
     */
    public CompletableFuture<BuildControllers> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(BuildControllers.class);
    }

    /***
     * Gets controller, optionally filtered by name
     * @param name pass the controller name
     * @throws AzDException Default Api Exception handler.
     * @return array of build controller {@link BuildControllers}
     */
    public CompletableFuture<BuildControllers> listAsync(String name) throws AzDException {
        return builder()
                .query("name", name)
                .build()
                .executeAsync(BuildControllers.class);
    }

    /***
     * Gets a controller
     * @param controllerId pass the controller id
     * @throws AzDException Default Api Exception handler.
     * @return build controller {@link BuildController}
     */
    public BuildController get(int controllerId) throws AzDException {
        return builder()
                .serviceEndpoint("controllerId", controllerId)
                .build()
                .execute(BuildController.class);
    }

    /***
     * Gets controllers
     * @throws AzDException Default Api Exception handler.
     * @return array of build controller {@link BuildControllers}
     */
    public BuildControllers list() throws AzDException {
        return builder()
                .build()
                .execute(BuildControllers.class);
    }

    /***
     * Gets controller, optionally filtered by name
     * @param name pass the controller name
     * @throws AzDException Default Api Exception handler.
     * @return array of build controller {@link BuildControllers}
     */
    public BuildControllers list(String name) throws AzDException {
        return builder()
                .query("name", name)
                .build()
                .execute(BuildControllers.class);
    }
}
