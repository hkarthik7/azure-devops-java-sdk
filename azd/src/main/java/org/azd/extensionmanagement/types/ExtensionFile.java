package org.azd.extensionmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * This is the set of files available from the extension.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtensionFile extends BaseAbstractMethod {
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

}
