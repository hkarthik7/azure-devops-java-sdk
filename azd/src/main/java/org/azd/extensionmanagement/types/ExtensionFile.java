package org.azd.extensionmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * This is the set of files available from the extension.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtensionFile {
    @JsonProperty("assetType")
    private String assetType;
    @JsonProperty("language")
    private String language;
    @JsonProperty("source")
    private String source;

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "ExtensionFile{" +
                "assetType='" + assetType + '\'' +
                ", language='" + language + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
