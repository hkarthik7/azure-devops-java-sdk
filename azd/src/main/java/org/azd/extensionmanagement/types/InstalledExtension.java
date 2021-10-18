package org.azd.extensionmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;

/***
 * Represents a VSTS extension along with its installation state
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstalledExtension {
    /***
     * Uri used as base for other relative uri's defined in extension
     */
    @JsonProperty("baseUri")
    private String baseUri;
    @JsonProperty("constraints")
    private List<ContributionConstraint> constraints;
    @JsonProperty("contributionTypes")
    private List<ContributionType> contributionTypes;
    @JsonProperty("contributions")
    private List<Contribution> contributions;
    @JsonProperty("demands")
    private String[] demands;
    @JsonProperty("eventCallbacks")
    private ExtensionEventCallbackCollection eventCallbacks;
    @JsonProperty("extensionId")
    private String extensionId;
    @JsonProperty("extensionName")
    private String extensionName;
    @JsonProperty("fallbackBaseUri")
    private String fallbackBaseUri;
    @JsonProperty("files")
    private List<ExtensionFile> files;
    @JsonProperty("flags")
    private String flags;
    @JsonProperty("installState")
    private InstalledExtensionState installState;
    @JsonProperty("language")
    private String language;
    @JsonProperty("lastPublished")
    private String lastPublished;
    @JsonProperty("licensing")
    private ExtensionLicensing licensing;
    @JsonProperty("manifestVersion")
    private int manifestVersion;
    @JsonProperty("publisherId")
    private String publisherId;
    @JsonProperty("publisherName")
    private String publisherName;
    @JsonProperty("registrationId")
    private String registrationId;
    @JsonProperty("restrictedTo")
    private String[] restrictedTo;
    @JsonProperty("scopes")
    private String[] scopes;
    @JsonProperty("serviceInstanceType")
    private String serviceInstanceType;
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

    @Override
    public String toString() {
        return "InstalledExtension{" +
                "baseUri='" + baseUri + '\'' +
                ", constraints=" + constraints +
                ", contributionTypes=" + contributionTypes +
                ", contributions=" + contributions +
                ", demands=" + Arrays.toString(demands) +
                ", eventCallbacks=" + eventCallbacks +
                ", extensionId='" + extensionId + '\'' +
                ", extensionName='" + extensionName + '\'' +
                ", fallbackBaseUri='" + fallbackBaseUri + '\'' +
                ", files=" + files +
                ", flags=" + flags +
                ", installState=" + installState +
                ", language='" + language + '\'' +
                ", lastPublished='" + lastPublished + '\'' +
                ", licensing=" + licensing +
                ", manifestVersion=" + manifestVersion +
                ", publisherId='" + publisherId + '\'' +
                ", publisherName='" + publisherName + '\'' +
                ", registrationId='" + registrationId + '\'' +
                ", restrictedTo=" + Arrays.toString(restrictedTo) +
                ", scopes=" + Arrays.toString(scopes) +
                ", serviceInstanceType='" + serviceInstanceType + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
