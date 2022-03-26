package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Represents a repository's webhook returned from a source provider.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryWebhook {
    /**
     * The friendly name of the repository.
     */
    @JsonProperty("name")
    private String name;
    /**
     * Type array
     */
    @JsonProperty("types")
    private JsonNode types;
    /**
     * The URL of the repository.
     */
    @JsonProperty("url")
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JsonNode getTypes() {
        return types;
    }

    public void setTypes(JsonNode types) {
        this.types = types;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "RepositoryWebhook{" +
                "name='" + name + '\'' +
                ", types=" + types +
                ", url='" + url + '\'' +
                '}';
    }
}
