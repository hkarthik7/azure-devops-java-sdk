package org.azd.extensionmanagement;

import org.azd.common.ApiVersion;
import org.azd.common.types.QueryParameter;
import org.azd.exceptions.AzDException;
import org.azd.extensionmanagement.types.*;
import org.azd.helpers.URLHelper;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Extension management request builder to manage Extension management Api.
 */
public class ExtensionManagementRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public ExtensionManagementRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "extmgmt", "extensionmanagement/installedextensionsbyname", ApiVersion.EXTENSION_MANAGEMENT);
    }

    /***
     * Get an installed extension by its publisher and extension id.
     * @param extensionId Id of the extension. Example: "sonarqube".
     * @param publisherId Id of the publisher. Example: "sonarsource".
     * @return InstalledExtension {@link InstalledExtension}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<InstalledExtension> getAsync(String extensionId, String publisherId) throws AzDException {
        String id =  URLHelper.encodeSpecialWithSpace(publisherId) + "/" + URLHelper.encodeSpecialWithSpace(extensionId);

        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + id;

        return requestAdapter.sendAsync(reqInfo, InstalledExtension.class);
    }

    /***
     * Get an installed extension by its publisher and extension id.
     * @param extensionId Id of the extension. Example: "sonarqube".
     * @param publisherId Id of the publisher. Example: "sonarsource".
     * @param assetTypes type of asset
     * @return InstalledExtension {@link InstalledExtension}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<InstalledExtension> getAsync(String extensionId, String publisherId, String[] assetTypes) throws AzDException {
        String id =  URLHelper.encodeSpecialWithSpace(publisherId) + "/" + URLHelper.encodeSpecialWithSpace(extensionId);

        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + id;
        if (assetTypes != null) reqInfo.setQueryParameter("assetTypes", String.join(",", assetTypes));

        return requestAdapter.sendAsync(reqInfo, InstalledExtension.class);
    }

    /***
     * List the installed extensions
     * @return InstalledExtensions {@link InstalledExtensions}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<InstalledExtensions> listAsync() throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service.replace("installedextensionsbyname", "installedextensions");

        return requestAdapter.sendAsync(reqInfo, InstalledExtensions.class);
    }

    /***
     * List the installed extensions
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return InstalledExtensions {@link InstalledExtensions}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<InstalledExtensions> listAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service.replace("installedextensionsbyname", "installedextensions");

        if (requestConfiguration != null) {
            final var config = new RequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.sendAsync(reqInfo, InstalledExtensions.class);
    }

    /***
     * Install the specified extension
     * @param installExtensionRequest Publisher id and Extension id to install the extension. Optionally specify the version.
     * @return InstalledExtension {@link InstalledExtension}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<InstalledExtension> installAsync(InstallExtensionRequest installExtensionRequest) throws AzDException {
        String id =  URLHelper.encodeSpecialWithSpace(installExtensionRequest.publisherId) + "/"
                + URLHelper.encodeSpecialWithSpace(installExtensionRequest.extensionId);

        if (installExtensionRequest.version != null) {
            id += "/" + installExtensionRequest.version;
        }

        var reqInfo = toPostRequestInformation(null);
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + id;

        return requestAdapter.sendAsync(reqInfo, InstalledExtension.class);
    }

    /***
     * Uninstall the specified extension
     * @param unInstallExtensionRequest Specify the publisher id and extension id to uninstall the extension. Optionally specify
     * the reason and reason code.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> uninstallAsync(UnInstallExtensionRequest unInstallExtensionRequest)
            throws AzDException {
        String id =  URLHelper.encodeSpecialWithSpace(unInstallExtensionRequest.publisherId) + "/"
                + URLHelper.encodeSpecialWithSpace(unInstallExtensionRequest.extensionId);

        var reqInfo = toDeleteRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + id;
        reqInfo.setQueryParameter("reason", unInstallExtensionRequest.reason);
        reqInfo.setQueryParameter("reasonCode", unInstallExtensionRequest.reasonCode);

        return requestAdapter.sendPrimitiveAsync(reqInfo);
    }

    /***
     * Enable/disable an extension
     * @param updateExtensionRequest Specify the publisher id, extension id and extension flag value to enable/disable the extension.
     * @return InstalledExtension {@link InstalledExtension}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<InstalledExtension> updateAsync(UpdateExtensionRequest updateExtensionRequest) throws AzDException {

        var body = new HashMap<String, Object>() {{
            put("publisherId", updateExtensionRequest.publisherId);
            put("extensionId", updateExtensionRequest.extensionId);
            put("installState", new HashMap<String, Object>() {{
                put("flags", updateExtensionRequest.extensionState);
            }});
        }};

        var reqInfo = toPatchRequestInformation(body);
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service.replace("installedextensionsbyname", "installedextensions");

        return requestAdapter.sendAsync(reqInfo, InstalledExtension.class);
    }

    /***
     * Get an installed extension by its publisher and extension id.
     * @param extensionId Id of the extension. Example: "sonarqube".
     * @param publisherId Id of the publisher. Example: "sonarsource".
     * @return InstalledExtension {@link InstalledExtension}
     * @throws AzDException Default Api Exception handler.
     */
    public InstalledExtension get(String extensionId, String publisherId) throws AzDException {
        String id =  URLHelper.encodeSpecialWithSpace(publisherId) + "/" + URLHelper.encodeSpecialWithSpace(extensionId);

        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + id;

        return requestAdapter.send(reqInfo, InstalledExtension.class);
    }

    /***
     * Get an installed extension by its publisher and extension id.
     * @param extensionId Id of the extension. Example: "sonarqube".
     * @param publisherId Id of the publisher. Example: "sonarsource".
     * @param assetTypes type of asset
     * @return InstalledExtension {@link InstalledExtension}
     * @throws AzDException Default Api Exception handler.
     */
    public InstalledExtension get(String extensionId, String publisherId, String[] assetTypes) throws AzDException {
        String id =  URLHelper.encodeSpecialWithSpace(publisherId) + "/" + URLHelper.encodeSpecialWithSpace(extensionId);

        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + id;
        if (assetTypes != null) reqInfo.setQueryParameter("assetTypes", String.join(",", assetTypes));

        return requestAdapter.send(reqInfo, InstalledExtension.class);
    }

    /***
     * List the installed extensions
     * @return InstalledExtensions {@link InstalledExtensions}
     * @throws AzDException Default Api Exception handler.
     */
    public InstalledExtensions list() throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service.replace("installedextensionsbyname", "installedextensions");
        System.out.println(reqInfo.getRequestUrl());

        return requestAdapter.send(reqInfo, InstalledExtensions.class);
    }

    /***
     * List the installed extensions
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return InstalledExtensions {@link InstalledExtensions}
     * @throws AzDException Default Api Exception handler.
     */
    public InstalledExtensions list(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service.replace("installedextensionsbyname", "installedextensions");

        if (requestConfiguration != null) {
            final var config = new RequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.send(reqInfo, InstalledExtensions.class);
    }

    /***
     * Install the specified extension
     * @param installExtensionRequest Publisher id and Extension id to install the extension. Optionally specify the version.
     * @return InstalledExtension {@link InstalledExtension}
     * @throws AzDException Default Api Exception handler.
     */
    public InstalledExtension install(InstallExtensionRequest installExtensionRequest) throws AzDException {
        String id =  URLHelper.encodeSpecialWithSpace(installExtensionRequest.publisherId) + "/"
                + URLHelper.encodeSpecialWithSpace(installExtensionRequest.extensionId);

        if (installExtensionRequest.version != null) {
            id += "/" + installExtensionRequest.version;
        }

        var reqInfo = toPostRequestInformation(null);
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + id;

        return requestAdapter.send(reqInfo, InstalledExtension.class);
    }

    /***
     * Uninstall the specified extension
     * @param unInstallExtensionRequest Specify the publisher id and extension id to uninstall the extension. Optionally specify
     * the reason and reason code.
     * @throws AzDException Default Api Exception handler.
     */
    public Void uninstall(UnInstallExtensionRequest unInstallExtensionRequest)
            throws AzDException {
        String id =  URLHelper.encodeSpecialWithSpace(unInstallExtensionRequest.publisherId) + "/"
                + URLHelper.encodeSpecialWithSpace(unInstallExtensionRequest.extensionId);

        var reqInfo = toDeleteRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + id;
        reqInfo.setQueryParameter("reason", unInstallExtensionRequest.reason);
        reqInfo.setQueryParameter("reasonCode", unInstallExtensionRequest.reasonCode);

        return requestAdapter.sendPrimitive(reqInfo);
    }

    /***
     * Enable/disable an extension
     * @param updateExtensionRequest Specify the publisher id, extension id and extension flag value to enable/disable the extension.
     * @return InstalledExtension {@link InstalledExtension}
     * @throws AzDException Default Api Exception handler.
     */
    public InstalledExtension update(UpdateExtensionRequest updateExtensionRequest) throws AzDException {

        var body = new HashMap<String, Object>() {{
            put("publisherId", updateExtensionRequest.publisherId);
            put("extensionId", updateExtensionRequest.extensionId);
            put("installState", new HashMap<String, Object>() {{
                put("flags", updateExtensionRequest.extensionState);
            }});
        }};

        var reqInfo = toPatchRequestInformation(body);
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service.replace("installedextensionsbyname", "installedextensions");

        return requestAdapter.send(reqInfo, InstalledExtension.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Determines which files are returned in the files array. Provide the wildcard '*' to return all files,
         * or a colon separated list to retrieve files with specific asset types.
         */
        @QueryParameter(name = "assetTypes")
        public String assetTypes;
        /**
         * If true (the default), include disabled extensions in the results.
         */
        @QueryParameter(name = "includeDisabledExtensions")
        public Boolean includeDisabledExtensions;
        /**
         * If true, include installed extensions with errors.
         */
        @QueryParameter(name = "includeErrors")
        public Boolean includeErrors;
        /**
         * If true includes installation errors.
         */
        @QueryParameter(name = "includeInstallationIssues")
        public Boolean includeInstallationIssues;;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

}
