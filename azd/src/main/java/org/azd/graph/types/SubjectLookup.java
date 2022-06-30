package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Response object from a subject lookup via descriptor
 *
 * This contains information about the object kind (user or group) and origin source (aad, vsts, etc)
 * Not all fields may be populated in the response.
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubjectLookup {
    /***
     * This field contains zero or more interesting links about the graph subject.
     * These links may be invoked to obtain additional relationships or more detailed information about this graph subject.
     */
    @JsonProperty("_links")
    private GraphReferenceLinks _links;
    /***
     * The descriptor is the primary way to reference the graph subject while the system is running.
     * This field will uniquely identify the same graph subject across both Accounts and Organizations.
     */
    @JsonProperty("descriptor")
    private String descriptor;
    /***
     * Identifies whether this is a 'group' or a 'user'
     */
    @JsonProperty("subjectKind")
    private String subjectKind;
    /***
     * verbose description of the subject
     */
    @JsonProperty("description")
    private String description;
    /***
     * This represents the name of the container of origin for a graph member.
     */
    @JsonProperty("domain")
    private String domain;
    /***
     * This is the PrincipalName of this graph member from the source provider.
     * The source provider may change this field over time and it is not guaranteed
     * to be immutable for the life of the graph member by VSTS.
     */
    @JsonProperty("principalName")
    private String principalName;
    /***
     * The email address of record for a given graph member. This may be different than the principal name.
     */
    @JsonProperty("mailAddress")
    private String mailAddress;
    /***
     * The type of source provider for the origin identifier (ex:AD, AAD, MSA)
     */
    @JsonProperty("origin")
    private String origin;
    /***
     * The unique identifier from the system of origin.
     * Typically a sid, object id or Guid. Linking and unlinking operations
     * can cause this value to change for a user because the user is not backed by a different provider
     * and has a different unique id in the new provider.
     */
    @JsonProperty("originId")
    private String originId;
    /***
     * This is the non-unique display name of the graph subject.
     */
    @JsonProperty("displayName")
    private String displayName;
    /***
     * This url is the full route to the source resource of this graph subject.
     */
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
