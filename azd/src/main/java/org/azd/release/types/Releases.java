package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * List of release
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Releases extends BaseAbstractMethod {
    /***
     * List of release
     */
    @JsonProperty("value")
    private List<Release> Releases;

    public List<Release> getReleases() {
        return Releases;
    }

    public void setReleases(List<Release> releases) {
        Releases = releases;
    }

}
