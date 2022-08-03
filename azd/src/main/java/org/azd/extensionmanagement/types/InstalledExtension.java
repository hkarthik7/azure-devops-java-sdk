package org.azd.extensionmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * Represents a VSTS extension along with its installation state
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstalledExtension extends BaseAbstractMethod {
    /***
     * Uri used as base for other relative uri's defined in extension
     */
    @JsonProperty("baseUri")
    private String baseUri;
    /***
     * List of shared constraints defined by this extension
     */
    @JsonProperty("constraints")
    private List<ContributionConstraint> constraints;
    /***
     * List of contribution types defined by this extension
     */
    @JsonProperty("contributionTypes")
    private List<ContributionType> contributionTypes;
    /***
     * List of contributions made by this extension
     */
    @JsonProperty("contributions")
    private List<Contribution> contributions;
    /***
     * List of explicit demands required by this extension
     */
    @JsonProperty("demands")
    private String[] demands;
    /***
     * Collection of endpoints that get called when particular extension events occur
     */
    @JsonProperty("eventCallbacks")
    private ExtensionEventCallbackCollection eventCallbacks;
    /***
     * The friendly extension id for this extension - unique for a given publisher.
     */
    @JsonProperty("extensionId")
    private String extensionId;
    /***
     * The display name of the extension.
     */
    @JsonProperty("extensionName")
    private String extensionName;
    /***
     * Secondary location that can be used as base for other relative uri's defined in extension
     */
    @JsonProperty("fallbackBaseUri")
    private String fallbackBaseUri;
    /***
     * This is the set of files available from the extension.
     */
    @JsonProperty("files")
    private List<ExtensionFile> files;
    /***
     * Extension flags relevant to contribution consumers
     */
    @JsonProperty("flags")
    private String flags;
    /***
     * Information about this particular installation of the extension
     */
    @JsonProperty("installState")
    private InstalledExtensionState installState;
    /***
     * Language Culture Name set by the Gallery
     */
    @JsonProperty("language")
    private String language;
    /***
     * This represents the date/time the extensions was last updated in the gallery.
     * This doesn't mean this version was updated the value represents changes to any and all versions of the extension.
     */
    @JsonProperty("lastPublished")
    private String lastPublished;
    /***
     * How this extension behaves with respect to licensing
     */
    @JsonProperty("licensing")
    private ExtensionLicensing licensing;
    /***
     * Version of the extension manifest format/content
     */
    @JsonProperty("manifestVersion")
    private int manifestVersion;
    /***
     * Unique id of the publisher of this extension
     */
    @JsonProperty("publisherId")
    private String publisherId;
    /***
     * The display name of the publisher
     */
    @JsonProperty("publisherName")
    private String publisherName;
    /***
     * Unique id for this extension (the same id is used for all versions of a single extension)
     */
    @JsonProperty("registrationId")
    private String registrationId;
    /***
     * Default user claims applied to all contributions
     * (except the ones which have been specified restrictedTo explicitly) to control the visibility of a contribution.
     */
    @JsonProperty("restrictedTo")
    private String[] restrictedTo;
    /***
     * List of all oauth scopes required by this extension
     */
    @JsonProperty("scopes")
    private String[] scopes;
    /***
     * The ServiceInstanceType(Guid) of the VSTS service that must be available to an account in order for the extension to be installed
     */
    @JsonProperty("serviceInstanceType")
    private String serviceInstanceType;
    /***
     * Version of this extension
     */
    @JsonProperty("version")
    private String version;

    public String getBaseUri() {
        return baseUri;
    }

    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }

    public List<ContributionConstraint> getConstraints() {
        return constraints;
    }

    public void setConstraints(List<ContributionConstraint> constraints) {
        this.constraints = constraints;
    }

    public List<ContributionType> getContributionTypes() {
        return contributionTypes;
    }

    public void setContributionTypes(List<ContributionType> contributionTypes) {
        this.contributionTypes = contributionTypes;
    }

    public List<Contribution> getContributions() {
        return contributions;
    }

    public void setContributions(List<Contribution> contributions) {
        this.contributions = contributions;
    }

    public String[] getDemands() {
        return demands;
    }

    public void setDemands(String[] demands) {
        this.demands = demands;
    }

    public ExtensionEventCallbackCollection getEventCallbacks() {
        return eventCallbacks;
    }

    public void setEventCallbacks(ExtensionEventCallbackCollection eventCallbacks) {
        this.eventCallbacks = eventCallbacks;
    }

    public String getExtensionId() {
        return extensionId;
    }

    public void setExtensionId(String extensionId) {
        this.extensionId = extensionId;
    }

    public String getExtensionName() {
        return extensionName;
    }

    public void setExtensionName(String extensionName) {
        this.extensionName = extensionName;
    }

    public String getFallbackBaseUri() {
        return fallbackBaseUri;
    }

    public void setFallbackBaseUri(String fallbackBaseUri) {
        this.fallbackBaseUri = fallbackBaseUri;
    }

    public List<ExtensionFile> getFiles() {
        return files;
    }

    public void setFiles(List<ExtensionFile> files) {
        this.files = files;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public InstalledExtensionState getInstallState() {
        return installState;
    }

    public void setInstallState(InstalledExtensionState installState) {
        this.installState = installState;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLastPublished() {
        return lastPublished;
    }

    public void setLastPublished(String lastPublished) {
        this.lastPublished = lastPublished;
    }

    public ExtensionLicensing getLicensing() {
        return licensing;
    }

    public void setLicensing(ExtensionLicensing licensing) {
        this.licensing = licensing;
    }

    public int getManifestVersion() {
        return manifestVersion;
    }

    public void setManifestVersion(int manifestVersion) {
        this.manifestVersion = manifestVersion;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String[] getRestrictedTo() {
        return restrictedTo;
    }

    public void setRestrictedTo(String[] restrictedTo) {
        this.restrictedTo = restrictedTo;
    }

    public String[] getScopes() {
        return scopes;
    }

    public void setScopes(String[] scopes) {
        this.scopes = scopes;
    }

    public String getServiceInstanceType() {
        return serviceInstanceType;
    }

    public void setServiceInstanceType(String serviceInstanceType) {
        this.serviceInstanceType = serviceInstanceType;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
