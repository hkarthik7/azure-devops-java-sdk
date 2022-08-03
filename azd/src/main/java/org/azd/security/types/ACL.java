package org.azd.security.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.Map;

/***
 * Access Control List entry
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ACL extends BaseAbstractMethod {
    /***
     * inherits permissions
     */
    @JsonProperty("inheritPermissions")
    private boolean inheritPermissions;
    /***
     * token identifier
     */
    @JsonProperty("token")
    private String token;
    /***
     * ACL aceDictionary entry
     */
    @JsonProperty("acesDictionary")
    private Map<String, ACE> acesDictionary;


    public boolean isInheritPermissions() {
        return inheritPermissions;
    }

    public void setInheritPermissions(boolean inheritPermissions) {
        this.inheritPermissions = inheritPermissions;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Map<String, ACE> getAcesDictionary() {
        return acesDictionary;
    }

    public void setAcesDictionary(Map<String, ACE> acesDictionary) {
        this.acesDictionary = acesDictionary;
    }

}
