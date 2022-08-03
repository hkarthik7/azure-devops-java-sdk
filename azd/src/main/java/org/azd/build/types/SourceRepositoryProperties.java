package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SourceRepositoryProperties extends BaseAbstractMethod {
    @JsonProperty("apiUrl")
    private String apiUrl;
    @JsonProperty("branchesUrl")
    private String branchesUrl;
    @JsonProperty("cloneUrl")
    private String cloneUrl;
    @JsonProperty("connectedServiceId")
    private String connectedServiceId;
    @JsonProperty("defaultBranch")
    private String defaultBranch;
    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("hasAdminPermissions")
    private boolean hasAdminPermissions;
    @JsonProperty("isFork")
    private boolean isFork;
    @JsonProperty("isPrivate")
    private boolean isPrivate;
    @JsonProperty("lastUpdated")
    private String lastUpdated;
    @JsonProperty("manageUrl")
    private String manageUrl;
    @JsonProperty("nodeId")
    private String nodeId;
    @JsonProperty("ownerId")
    private String ownerId;
    @JsonProperty("orgName")
    private String orgName;
    @JsonProperty("refsUrl")
    private String refsUrl;
    @JsonProperty("safeRepository")
    private String safeRepository;
    @JsonProperty("shortName")
    private String shortName;
    @JsonProperty("ownerAvatarUrl")
    private String ownerAvatarUrl;
    @JsonProperty("archived")
    private boolean archived;
    @JsonProperty("externalId")
    private String externalId;
    @JsonProperty("ownerIsAUser")
    private boolean ownerIsAUser;

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getBranchesUrl() {
        return branchesUrl;
    }

    public void setBranchesUrl(String branchesUrl) {
        this.branchesUrl = branchesUrl;
    }

    public String getCloneUrl() {
        return cloneUrl;
    }

    public void setCloneUrl(String cloneUrl) {
        this.cloneUrl = cloneUrl;
    }

    public String getConnectedServiceId() {
        return connectedServiceId;
    }

    public void setConnectedServiceId(String connectedServiceId) {
        this.connectedServiceId = connectedServiceId;
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isHasAdminPermissions() {
        return hasAdminPermissions;
    }

    public void setHasAdminPermissions(boolean hasAdminPermissions) {
        this.hasAdminPermissions = hasAdminPermissions;
    }

    public boolean isFork() {
        return isFork;
    }

    public void setFork(boolean fork) {
        isFork = fork;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getManageUrl() {
        return manageUrl;
    }

    public void setManageUrl(String manageUrl) {
        this.manageUrl = manageUrl;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRefsUrl() {
        return refsUrl;
    }

    public void setRefsUrl(String refsUrl) {
        this.refsUrl = refsUrl;
    }

    public String getSafeRepository() {
        return safeRepository;
    }

    public void setSafeRepository(String safeRepository) {
        this.safeRepository = safeRepository;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getOwnerAvatarUrl() {
        return ownerAvatarUrl;
    }

    public void setOwnerAvatarUrl(String ownerAvatarUrl) {
        this.ownerAvatarUrl = ownerAvatarUrl;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public boolean isOwnerIsAUser() {
        return ownerIsAUser;
    }

    public void setOwnerIsAUser(boolean ownerIsAUser) {
        this.ownerIsAUser = ownerIsAUser;
    }

}
