package org.azd.extensionmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtensionEventCallbackCollection extends BaseAbstractMethod {
    /***
     * Defines an endpoint that gets called via a POST request to notify that an extension disable has occurred.
     */
    @JsonProperty("postDisable")
    private ExtensionEventCallback postDisable;
    /***
     * Defines an endpoint that gets called via a POST request to notify that an extension enable has occurred.
     */
    @JsonProperty("postEnable")
    private ExtensionEventCallback postEnable;
    /***
     * Defines an endpoint that gets called via a POST request to notify that an extension install has completed.
     */
    @JsonProperty("postInstall")
    private ExtensionEventCallback postInstall;
    /***
     * Defines an endpoint that gets called via a POST request to notify that an extension uninstall has occurred.
     */
    @JsonProperty("postUninstall")
    private ExtensionEventCallback postUninstall;
    /***
     * Defines an endpoint that gets called via a POST request to notify that an extension update has occurred.
     */
    @JsonProperty("postUpdate")
    private ExtensionEventCallback postUpdate;
    /***
     * Defines an endpoint that gets called via a POST request to notify that an extension install is about to occur.
     * Response indicates whether to proceed or abort.
     */
    @JsonProperty("preInstall")
    private ExtensionEventCallback preInstall;
    /***
     * For multi-version extensions, defines an endpoint that gets called via an
     * OPTIONS request to determine the particular version of the extension to be used
     */
    @JsonProperty("versionCheck")
    private ExtensionEventCallback versionCheck;

    public ExtensionEventCallback getPostDisable() {
        return postDisable;
    }

    public void setPostDisable(ExtensionEventCallback postDisable) {
        this.postDisable = postDisable;
    }

    public ExtensionEventCallback getPostEnable() {
        return postEnable;
    }

    public void setPostEnable(ExtensionEventCallback postEnable) {
        this.postEnable = postEnable;
    }

    public ExtensionEventCallback getPostInstall() {
        return postInstall;
    }

    public void setPostInstall(ExtensionEventCallback postInstall) {
        this.postInstall = postInstall;
    }

    public ExtensionEventCallback getPostUninstall() {
        return postUninstall;
    }

    public void setPostUninstall(ExtensionEventCallback postUninstall) {
        this.postUninstall = postUninstall;
    }

    public ExtensionEventCallback getPostUpdate() {
        return postUpdate;
    }

    public void setPostUpdate(ExtensionEventCallback postUpdate) {
        this.postUpdate = postUpdate;
    }

    public ExtensionEventCallback getPreInstall() {
        return preInstall;
    }

    public void setPreInstall(ExtensionEventCallback preInstall) {
        this.preInstall = preInstall;
    }

    public ExtensionEventCallback getVersionCheck() {
        return versionCheck;
    }

    public void setVersionCheck(ExtensionEventCallback versionCheck) {
        this.versionCheck = versionCheck;
    }

}
