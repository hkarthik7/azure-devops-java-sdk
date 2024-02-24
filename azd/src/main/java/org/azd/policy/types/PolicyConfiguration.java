package org.azd.policy.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.common.types.Author;

/**
 * The full policy configuration with settings.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolicyConfiguration extends SerializableEntity {
    /**
     * A reference to the identity that created the policy.
     */
    @JsonProperty("createdBy")
    private Author createdBy;
    /**
     * The date and time when the policy was created.
     */
    @JsonProperty("createdDate")
    private String createdDate;
    /**
     * The policy configuration ID.
     */
    @JsonProperty("id")
    private Integer id;
    /**
     * Indicates whether the policy is blocking.
     */
    @JsonProperty("isBlocking")
    private Boolean isBlocking;
    /**
     * Indicates whether the policy has been (soft) deleted.
     */
    @JsonProperty("isDeleted")
    private Boolean isDeleted;
    /**
     * Indicates whether the policy is enabled.
     */
    @JsonProperty("isEnabled")
    private Boolean isEnabled;
    /**
     * If set, this policy requires "Manage Enterprise Policies" permission to create, edit, or delete.
     */
    @JsonProperty("isEnterpriseManaged")
    private Boolean isEnterpriseManaged;
    /**
     * The policy configuration revision ID.
     */
    @JsonProperty("revision")
    private Integer revision;
    /**
     * The policy configuration settings.
     */
    @JsonProperty("settings")
    private JsonNode settings;
    /**
     * The policy configuration type.
     */
    @JsonProperty("type")
    private PolicyTypeRef type;
    /**
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean isBlocking() {
        return isBlocking;
    }

    public void setBlocking(Boolean blocking) {
        isBlocking = blocking;
    }

    public Boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public Boolean isEnterpriseManaged() {
        return isEnterpriseManaged;
    }

    public void setEnterpriseManaged(Boolean enterpriseManaged) {
        isEnterpriseManaged = enterpriseManaged;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
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
