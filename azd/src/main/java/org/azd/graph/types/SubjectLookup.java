package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubjectLookup {
    @JsonProperty("_links")
    private GraphReferenceLinks _links;

    @JsonProperty("descriptor")
    private String descriptor;

    @JsonProperty("subjectKind")
    private String subjectKind;

    @JsonProperty("description")
    private String description;

    @JsonProperty("domain")
    private String domain;

    @JsonProperty("principalName")
    private String principalName;

    @JsonProperty("mailAddress")
    private String mailAddress;

    @JsonProperty("origin")
    private String origin;

    @JsonProperty("originId")
    private String originId;

    @JsonProperty("displayName")
    private String displayName;

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

    public String getSubjectKind() {
        return subjectKind;
    }

    public void setSubjectKind(String subjectKind) {
        this.subjectKind = subjectKind;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "SubjectLookup{" +
                "_links=" + _links +
                ", descriptor='" + descriptor + '\'' +
                ", subjectKind='" + subjectKind + '\'' +
                ", description='" + description + '\'' +
                ", domain='" + domain + '\'' +
                ", principalName='" + principalName + '\'' +
                ", mailAddress='" + mailAddress + '\'' +
                ", origin='" + origin + '\'' +
                ", originId='" + originId + '\'' +
                ", displayName='" + displayName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
