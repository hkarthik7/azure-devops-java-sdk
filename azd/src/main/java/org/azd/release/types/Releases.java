package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Releases {
    @JsonProperty("value")
    private List<Release> Releases;

    public List<Release> getReleases() {
        return Releases;
    }

    public void setReleases(List<Release> releases) {
        Releases = releases;
    }

    @Override
    public String toString() {
        return "Releases{" +
                "Releases=" + Releases +
                '}';
    }
}
