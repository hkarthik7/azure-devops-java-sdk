package org.azd.extensionmanagement;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.exceptions.AzDException;
import org.azd.extensionmanagement.types.*;
import org.azd.helpers.URLHelper;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Extension management request builder to manage Extension management Api.
 */
public class ExtensionManagementRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ExtensionManagementRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "extensionmanagement", "fb0da285-f23e-4b56-8b53-3ef5f9f6de66");
    }

    /**
     * Get an installed extension by its publisher and extension id.
     *
     * @param extensionId Id of the extension. Example: "sonarqube".
     * @param publisherId Id of the publisher. Example: "sonarsource".
     * @return InstalledExtension {@link InstalledExtension}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<InstalledExtension> getAsync(String extensionId, String publisherId) throws AzDException {
        return builder()
                .serviceEndpoint("publisherName", URLHelper.encodeSpecialWithSpace(publisherId))
                .serviceEndpoint("extensionName", URLHelper.encodeSpecialWithSpace(extensionId))
                .build()
                .executeAsync(InstalledExtension.class);
    }

    /**
     * Get an installed extension by its publisher and extension id.
     *
     * @param extensionId Id of the extension. Example: "sonarqube".
     * @param publisherId Id of the publisher. Example: "sonarsource".
     * @param assetTypes  type of asset
     * @return InstalledExtension {@link InstalledExtension}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<InstalledExtension> getAsync(String extensionId, String publisherId, String[] assetTypes) throws AzDException {
        return builder()
                .serviceEndpoint("publisherName", URLHelper.encodeSpecialWithSpace(publisherId))
                .serviceEndpoint("extensionName", URLHelper.encodeSpecialWithSpace(extensionId))
                .query("assetTypes", String.join(",", assetTypes))
                .build()
                .executeAsync(InstalledExtension.class);
    }

    /**
     * List the installed extensions
     *
     * @return InstalledExtensions {@link InstalledExtensions}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<InstalledExtensions> listAsync() throws AzDException {
        return builder()
                .location("275424d0-c844-4fe2-bda6-04933a1357d8")
                .build()
                .executeAsync(InstalledExtensions.class);
    }

    /**
     * List the installed extensions
     *
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return InstalledExtensions {@link InstalledExtensions}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<InstalledExtensions> listAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("275424d0-c844-4fe2-bda6-04933a1357d8")
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(InstalledExtensions.class);
    }

    /**
     * Install the specified extension
     *
     * @param installExtensionRequest Publisher id and Extension id to install the extension. Optionally specify the version.
     * @return InstalledExtension {@link InstalledExtension}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<InstalledExtension> installAsync(InstallExtensionRequest installExtensionRequest) throws AzDException {
        Objects.requireNonNull(installExtensionRequest, "Install extension request cannot be null.");

        var builder = builder()
                .serviceEndpoint("publisherName", URLHelper.encodeSpecialWithSpace(installExtensionRequest.publisherId))
                .serviceEndpoint("extensionName", URLHelper.encodeSpecialWithSpace(installExtensionRequest.extensionId));
        builder = installExtensionRequest.version != null ? builder.serviceEndpoint("version", installExtensionRequest.version) : builder;
        return builder
                .build()
                .executeAsync(InstalledExtension.class);
    }

    /**
     * Uninstall the specified extension
     *
     * @param unInstallExtensionRequest Specify the publisher id and extension id to uninstall the extension. Optionally specify
     *                                  the reason and reason code.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> uninstallAsync(UnInstallExtensionRequest unInstallExtensionRequest)
            throws AzDException {
        Objects.requireNonNull(unInstallExtensionRequest, "Uninstall extension request cannot be null.");

        return builder()
                .DELETE()
                .serviceEndpoint("publisherName", URLHelper.encodeSpecialWithSpace(unInstallExtensionRequest.publisherId))
                .serviceEndpoint("extensionName", URLHelper.encodeSpecialWithSpace(unInstallExtensionRequest.extensionId))
                .query("reason", unInstallExtensionRequest.reason)
                .query("reasonCode", unInstallExtensionRequest.reasonCode)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Enable/disable an extension
     *
     * @param updateExtensionRequest Specify the publisher id, extension id and extension flag value to enable/disable the extension.
     * @return InstalledExtension {@link InstalledExtension}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<InstalledExtension> updateAsync(UpdateExtensionRequest updateExtensionRequest) throws AzDException {
        Objects.requireNonNull(updateExtensionRequest, "Update extension request cannot be null.");
        var body = new HashMap<String, Object>() {{
            put("publisherId", updateExtensionRequest.publisherId);
            put("extensionId", updateExtensionRequest.extensionId);
            put("installState", new HashMap<String, Object>() {{
                put("flags", updateExtensionRequest.extensionState);
            }});
        }};

        return builder()
                .PATCH(body)
                .location("275424d0-c844-4fe2-bda6-04933a1357d8")
                .build()
                .executeAsync(InstalledExtension.class);
    }

    /**
     * Get an installed extension by its publisher and extension id.
     *
     * @param extensionId Id of the extension. Example: "sonarqube".
     * @param publisherId Id of the publisher. Example: "sonarsource".
     * @return InstalledExtension {@link InstalledExtension}
     * @throws AzDException Default Api Exception handler.
     */
    public InstalledExtension get(String extensionId, String publisherId) throws AzDException {
        return builder()
                .serviceEndpoint("publisherName", URLHelper.encodeSpecialWithSpace(publisherId))
                .serviceEndpoint("extensionName", URLHelper.encodeSpecialWithSpace(extensionId))
                .build()
                .execute(InstalledExtension.class);
    }

    /**
     * Get an installed extension by its publisher and extension id.
     *
     * @param extensionId Id of the extension. Example: "sonarqube".
     * @param publisherId Id of the publisher. Example: "sonarsource".
     * @param assetTypes  type of asset
     * @return InstalledExtension {@link InstalledExtension}
     * @throws AzDException Default Api Exception handler.
     */
    public InstalledExtension get(String extensionId, String publisherId, String[] assetTypes) throws AzDException {
        return builder()
                .serviceEndpoint("publisherName", URLHelper.encodeSpecialWithSpace(publisherId))
                .serviceEndpoint("extensionName", URLHelper.encodeSpecialWithSpace(extensionId))
                .query("assetTypes", String.join(",", assetTypes))
                .build()
                .execute(InstalledExtension.class);
    }

    /**
     * List the installed extensions
     *
     * @return InstalledExtensions {@link InstalledExtensions}
     * @throws AzDException Default Api Exception handler.
     */
    public InstalledExtensions list() throws AzDException {
        return builder()
                .location("275424d0-c844-4fe2-bda6-04933a1357d8")
                .build()
                .execute(InstalledExtensions.class);
    }

    /**
     * List the installed extensions
     *
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return InstalledExtensions {@link InstalledExtensions}
     * @throws AzDException Default Api Exception handler.
     */
    public InstalledExtensions list(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("275424d0-c844-4fe2-bda6-04933a1357d8")
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(InstalledExtensions.class);
    }

    /**
     * Install the specified extension
     *
     * @param installExtensionRequest Publisher id and Extension id to install the extension. Optionally specify the version.
     * @return InstalledExtension {@link InstalledExtension}
     * @throws AzDException Default Api Exception handler.
     */
    public InstalledExtension install(InstallExtensionRequest installExtensionRequest) throws AzDException {
        Objects.requireNonNull(installExtensionRequest, "Install extension request cannot be null.");

        var builder = builder()
                .serviceEndpoint("publisherName", URLHelper.encodeSpecialWithSpace(installExtensionRequest.publisherId))
                .serviceEndpoint("extensionName", URLHelper.encodeSpecialWithSpace(installExtensionRequest.extensionId));
        builder = installExtensionRequest.version != null ? builder.serviceEndpoint("version", installExtensionRequest.version) : builder;
        return builder
                .build()
                .execute(InstalledExtension.class);
    }

    /**
     * Uninstall the specified extension
     *
     * @param unInstallExtensionRequest Specify the publisher id and extension id to uninstall the extension. Optionally specify
     *                                  the reason and reason code.
     * @throws AzDException Default Api Exception handler.
     */
    public Void uninstall(UnInstallExtensionRequest unInstallExtensionRequest)
            throws AzDException {
        Objects.requireNonNull(unInstallExtensionRequest, "Uninstall extension request cannot be null.");

        return builder()
                .DELETE()
                .serviceEndpoint(URLHelper.encodeSpecialWithSpace(unInstallExtensionRequest.publisherId),
                        URLHelper.encodeSpecialWithSpace(unInstallExtensionRequest.extensionId))
                .query("reason", unInstallExtensionRequest.reason)
                .query("reasonCode", unInstallExtensionRequest.reasonCode)
                .build()
                .executePrimitive();
    }

    /**
     * Enable/disable an extension
     *
     * @param updateExtensionRequest Specify the publisher id, extension id and extension flag value to enable/disable the extension.
     * @return InstalledExtension {@link InstalledExtension}
     * @throws AzDException Default Api Exception handler.
     */
    public InstalledExtension update(UpdateExtensionRequest updateExtensionRequest) throws AzDException {
        Objects.requireNonNull(updateExtensionRequest, "Update extension request cannot be null.");
        var body = new HashMap<String, Object>() {{
            put("publisherId", updateExtensionRequest.publisherId);
            put("extensionId", updateExtensionRequest.extensionId);
            put("installState", new HashMap<String, Object>() {{
                put("flags", updateExtensionRequest.extensionState);
            }});
        }};

        return builder()
                .PATCH(body)
                .location("275424d0-c844-4fe2-bda6-04933a1357d8")
                .build()
                .execute(InstalledExtension.class);
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
        public Boolean includeInstallationIssues;
        ;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

}
