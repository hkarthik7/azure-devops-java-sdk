package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * Represents an item in a repository from a source provider.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SourceRepositoryItem extends BaseAbstractMethod {
    /**
     * Whether the item is able to have sub-items (e.g., is a folder).
     */
    @JsonProperty("isContainer")
    private boolean isContainer;
    /**
     * The full path of the item, relative to the root of the repository.
     */
    @JsonProperty("path")
    private String path;
    /**
     * The type of the item (folder, file, etc).
     */
    @JsonProperty("type")
    private String type;
    /**
     * The URL of the item.
     */
    @JsonProperty("url")
    private String url;

    public boolean isContainer() {
        return isContainer;
    }

    public void setContainer(boolean container) {
        isContainer = container;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
