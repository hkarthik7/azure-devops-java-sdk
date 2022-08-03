package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * List of repositories
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repositories extends BaseAbstractMethod {
    /***
     * List of repositories
     */
    @JsonProperty("value")
    private List<GitRepository> value;

    public List<GitRepository> getRepositories() {
        return value;
    }

    public void setRepositories(List<GitRepository> value) {
        this.value = value;
    }

}
