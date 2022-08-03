package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * Represents a repository returned from a source provider.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SourceRepository extends BaseAbstractMethod {
    /**
     * The name of the default branch.
     */
    @JsonProperty("defaultBranch")
    private String defaultBranch;
    /**
     * The full name of the repository.
     */
    @JsonProperty("fullName")
    private String fullName;
    /**
     * The ID of the repository.
     */
    @JsonProperty("id")
    private String id;
    /**
     * The friendly name of the repository.
     */
    @JsonProperty("name")
    private String name;
    /**
     * Represents the properties of source repository.
     */
    @JsonProperty("properties")
    private SourceRepositoryProperties properties;
    /**
     * The name of the source provider the repository is from.
     */
    @JsonProperty("sourceProviderName")
    private String sourceProviderName;
    /**
     * The URL of the repository.
     */
    @JsonProperty("url")
    private String url;

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SourceRepositoryProperties getProperties() {
        return properties;
    }

    public void setProperties(SourceRepositoryProperties properties) {
        this.properties = properties;
    }

    public String getSourceProviderName() {
        return sourceProviderName;
    }

    public void setSourceProviderName(String sourceProviderName) {
        this.sourceProviderName = sourceProviderName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
