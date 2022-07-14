package org.azd.security.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * this is a list of access control entries, for posting to replace or merge ACEs
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ACEs {
    @JsonProperty
    private String token;
    @JsonProperty
    private boolean merge;
    @JsonProperty
    private List<ACE> accessControlEntries;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isMerge() {
        return merge;
    }

    public void setMerge(boolean merge) {
        this.merge = merge;
    }

    public List<ACE> getAccessControlEntries() {
        return accessControlEntries;
    }

    public void setAccessControlEntries(List<ACE> accessControlEntries) {
        this.accessControlEntries = accessControlEntries;
    }

    @Override
    public String toString() {
        return "ACEs{" +
                "token='" + token + '\'' +
                ", merge=" + merge +
                ", accessControlEntries=" + accessControlEntries +
                '}';
    }
}
