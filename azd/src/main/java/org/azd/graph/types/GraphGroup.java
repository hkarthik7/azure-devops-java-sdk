package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphGroup {
    @JsonProperty("_links")
    private GroupReferenceLinks _links;
    @JsonProperty("description")
    private String description;
    @JsonProperty("descriptor")
    private String descriptor;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("legacyDescriptor")
    private String legacyDescriptor;
    @JsonProperty("mailAddress")
    private String mailAddress;
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("originId")
    private String originId;
    @JsonProperty("principalName")
    private String principalName;
    @JsonProperty("subjectKind")
    private String subjectKind;
    @JsonProperty("url")
    private String url;

    public GroupReferenceLinks get_links() {
        return _links;
    }

    public void set_links(GroupReferenceLinks _links) {
        this._links = _links;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getLegacyDescriptor() {
        return legacyDescriptor;
    }

    public void setLegacyDescriptor(String legacyDescriptor) {
        this.legacyDescriptor = legacyDescriptor;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public String getSubjectKind() {
        return subjectKind;
    }

    public void setSubjectKind(String subjectKind) {
        this.subjectKind = subjectKind;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "GraphGroup{" +
                "_links=" + _links +
                ", description='" + description + '\'' +
                ", descriptor='" + descriptor + '\'' +
                ", displayName='" + displayName + '\'' +
                ", domain='" + domain + '\'' +
                ", legacyDescriptor='" + legacyDescriptor + '\'' +
                ", mailAddress='" + mailAddress + '\'' +
                ", origin='" + origin + '\'' +
                ", originId='" + originId + '\'' +
                ", principalName='" + principalName + '\'' +
                ", subjectKind='" + subjectKind + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
