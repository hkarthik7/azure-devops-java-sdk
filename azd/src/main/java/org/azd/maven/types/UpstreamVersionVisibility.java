package org.azd.maven.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Indicates whether external upstream versions should be considered for this
 * package
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpstreamVersionVisibility {

    /***
     * .
     */
    @JsonProperty("allowExternalVersions")
    private String allowExternalVersions;

    /***
     * 
     */
    @JsonProperty("auto")
    private String auto;

    public String getAllowExternalVersions() {
        return allowExternalVersions;
    }

    public void setAllowExternalVersions(String allowExternalVersions) {
        this.allowExternalVersions = allowExternalVersions;
    }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    @Override
    public String toString() {
        return "UpstreamVersionVisibility{" +
                "allowExternalVersions='" + allowExternalVersions + '\'' +
                ", auto=" + auto + '\'' +
                '}';
    }
}
