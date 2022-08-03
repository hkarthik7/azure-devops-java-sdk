package org.azd.policy.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.types.Author;
import org.azd.common.types.BaseAbstractMethod;

/***
 * The full policy configuration with settings.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolicyConfiguration extends BaseAbstractMethod {
    /***
     * A reference to the identity that created the policy.
     */
    @JsonProperty("createdBy")
    private Author createdBy;
    /***
     * The date and time when the policy was created.
     */
    @JsonProperty("createdDate")
    private String createdDate;
    /***
     * The policy configuration ID.
     */
    @JsonProperty("id")
    private int id;
    /***
     * Indicates whether the policy is blocking.
     */
    @JsonProperty("isBlocking")
    private boolean isBlocking;
    /***
     * Indicates whether the policy has been (soft) deleted.
     */
    @JsonProperty("isDeleted")
    private boolean isDeleted;
    /***
     * Indicates whether the policy is enabled.
     */
    @JsonProperty("isEnabled")
    private boolean isEnabled;
    /***
     * If set, this policy requires "Manage Enterprise Policies" permission to create, edit, or delete.
     */
    @JsonProperty("isEnterpriseManaged")
    private boolean isEnterpriseManaged;
    /***
     * The policy configuration revision ID.
     */
    @JsonProperty("revision")
    private int revision;
    /***
     * The policy configuration settings.
     */
    @JsonProperty("settings")
    private JsonNode settings;
    /***
     * The policy configuration type.
     */
    @JsonProperty("type")
    private PolicyTypeRef type;
    /***
     * The URL where the policy configuration can be retrieved.
     */
    @JsonProperty("url")
    private String url;

    public Author getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Author createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBlocking() {
        return isBlocking;
    }

    public void setBlocking(boolean blocking) {
        isBlocking = blocking;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public boolean isEnterpriseManaged() {
        return isEnterpriseManaged;
    }

    public void setEnterpriseManaged(boolean enterpriseManaged) {
        isEnterpriseManaged = enterpriseManaged;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public JsonNode getSettings() {
        return settings;
    }

    public void setSettings(JsonNode settings) {
        this.settings = settings;
    }

    public PolicyTypeRef getType() {
        return type;
    }

    public void setType(PolicyTypeRef type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
