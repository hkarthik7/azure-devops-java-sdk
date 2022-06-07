package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Status context that uniquely identifies the status.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitStatusContext {
    /**
     * Genre of the status. Typically name of the service/tool generating the status, can be empty.
     */
    @JsonProperty("genre")
    private String genre;
    /**
     * Name identifier of the status, cannot be null or empty.
     */
    @JsonProperty("name")
    private String name;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GitStatusContext{" +
                "genre='" + genre + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
