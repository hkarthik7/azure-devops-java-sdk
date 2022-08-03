package org.azd.accounts.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Represents Azure DevOps Account
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account extends BaseAbstractMethod {
    /***
     * Identifier for an Account
     */
    @JsonProperty("accountId")
    private String accountId;
    /***
     * Name for an account
     */
    @JsonProperty("accountName")
    private String accountName;
    /***
     * Owner of account
     */
    @JsonProperty("accountOwner")
    private String accountOwner;
    /***
     * Current account status
     */
    @JsonProperty("accountStatus")
    private String accountStatus;
    /***
     * Type of account: Personal, Organization
     */
    @JsonProperty("accountType")
    private String accountType;
    /***
     * Uri for an account
     */
    @JsonProperty("accountUri")
    private String accountUri;
    /***
     * Who created the account
     */
    @JsonProperty("createdBy")
    private String createdBy;
    /***
     * has the account moved
     */
    @JsonProperty("hasMoved")
    private boolean hasMoved;
    /***
     * Identity of last person to update the account
     */
    @JsonProperty("lastUpdatedBy")
    private String lastUpdatedBy;
    /***
     * Date account was last updated
     */
    @JsonProperty("lastUpdatedDate")
    private String lastUpdatedDate;
    /***
     * Namespace for an account
     */
    @JsonProperty("namespaceId")
    private String namespaceId;
    /***
     * new collection Id
     */
    @JsonProperty("newCollectionId")
    private String newCollectionId;
    /***
     * Organization that created the account
     */
    @JsonProperty("organizationName")
    private String organizationName;
    /***
     * Extended properties
     */
    @JsonProperty("properties")
    private PropertiesCollection properties;
    /***
     * Reason for current status
     */
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

}
