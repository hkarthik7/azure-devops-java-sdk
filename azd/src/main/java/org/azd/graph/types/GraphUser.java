package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphUser {
    @JsonProperty("_links")
    private GraphReferenceLinks _links;
    @JsonProperty("descriptor")
    private String descriptor;
    @JsonProperty("directoryAlias")
    private String directoryAlias;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("isDeletedInOrigin")
    private boolean isDeletedInOrigin;
    @JsonProperty("legacyDescriptor")
    private String legacyDescriptor;
    @JsonProperty("mailAddress")
    private String mailAddress;
    @JsonProperty("metaType")
    private String metaType;
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

    public GraphReferenceLinks get_links() {
        return _links;
    }

    public void set_links(GraphReferenceLinks _links) {
        this._links = _links;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public String getDirectoryAlias() {
        return directoryAlias;
    }

    public void setDirectoryAlias(String directoryAlias) {
        this.directoryAlias = directoryAlias;
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

    public boolean isDeletedInOrigin() {
        return isDeletedInOrigin;
    }

    public void setDeletedInOrigin(boolean deletedInOrigin) {
        isDeletedInOrigin = deletedInOrigin;
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

    public String getMetaType() {
        return metaType;
    }

    public void setMetaType(String metaType) {
        this.metaType = metaType;
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
        return "GraphUser{" +
                "_links=" + _links +
                ", descriptor='" + descriptor + '\'' +
                ", directoryAlias='" + directoryAlias + '\'' +
                ", displayName='" + displayName + '\'' +
                ", domain='" + domain + '\'' +
                ", isDeletedInOrigin=" + isDeletedInOrigin +
                ", legacyDescriptor='" + legacyDescriptor + '\'' +
                ", mailAddress='" + mailAddress + '\'' +
                ", metaType='" + metaType + '\'' +
                ", origin='" + origin + '\'' +
                ", originId='" + originId + '\'' +
                ", principalName='" + principalName + '\'' +
                ", subjectKind='" + subjectKind + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
