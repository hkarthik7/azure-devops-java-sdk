package org.azd.accounts.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {
    @JsonProperty("accountId")
    private String accountId;
    @JsonProperty("accountName")
    private String accountName;
    @JsonProperty("accountOwner")
    private String accountOwner;
    @JsonProperty("accountStatus")
    private String accountStatus;
    @JsonProperty("accountType")
    private String accountType;
    @JsonProperty("accountUri")
    private String accountUri;
    @JsonProperty("createdBy")
    private String createdBy;
    @JsonProperty("hasMoved")
    private boolean hasMoved;
    @JsonProperty("lastUpdatedBy")
    private String lastUpdatedBy;
    @JsonProperty("lastUpdatedDate")
    private String lastUpdatedDate;
    @JsonProperty("namespaceId")
    private String namespaceId;
    @JsonProperty("newCollectionId")
    private String newCollectionId;
    @JsonProperty("organizationName")
    private String organizationName;
    @JsonProperty("properties")
    private PropertiesCollection properties;
    @JsonProperty("statusReason")
    private String statusReason;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountUri() {
        return accountUri;
    }

    public void setAccountUri(String accountUri) {
        this.accountUri = accountUri;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public boolean isHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getNamespaceId() {
        return namespaceId;
    }

    public void setNamespaceId(String namespaceId) {
        this.namespaceId = namespaceId;
    }

    public String getNewCollectionId() {
        return newCollectionId;
    }

    public void setNewCollectionId(String newCollectionId) {
        this.newCollectionId = newCollectionId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public PropertiesCollection getProperties() {
        return properties;
    }

    public void setProperties(PropertiesCollection properties) {
        this.properties = properties;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountOwner='" + accountOwner + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                ", accountType='" + accountType + '\'' +
                ", accountUri='" + accountUri + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", hasMoved=" + hasMoved +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", lastUpdatedDate='" + lastUpdatedDate + '\'' +
                ", namespaceId='" + namespaceId + '\'' +
                ", newCollectionId='" + newCollectionId + '\'' +
                ", organizationName='" + organizationName + '\'' +
                ", properties=" + properties +
                ", statusReason='" + statusReason + '\'' +
                '}';
    }
}
