package org.azd.accounts.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * A user profile.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Profile extends BaseAbstractMethod {
    /***
     * User display name
     */
    @JsonProperty("displayName")
    private String displayName;
    /***
     * GUID of the alias name
     */
    @JsonProperty("publicAlias")
    private String publicAlias;
    /***
     * user email address
     */
    @JsonProperty("emailAddress")
    private String emailAddress;
    /**
     * revision number
     */
    @JsonProperty("coreRevision")
    private int coreRevision;
    /***
     * time stamp
     */
    @JsonProperty("timeStamp")
    private String timeStamp;
    /***
     * GUID of a user
     */
    @JsonProperty("id")
    private String id;
    /***
     * revision number
     */
    @JsonProperty("revision")
    private int revision;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPublicAlias() {
        return publicAlias;
    }

    public void setPublicAlias(String publicAlias) {
        this.publicAlias = publicAlias;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getCoreRevision() {
        return coreRevision;
    }

    public void setCoreRevision(int coreRevision) {
        this.coreRevision = coreRevision;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

}
