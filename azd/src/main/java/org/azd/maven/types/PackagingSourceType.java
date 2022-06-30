package org.azd.maven.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Source type, such as Public or Internal.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PackagingSourceType {
    /***
     * Azure DevOps upstream source.
     */
    @JsonProperty("internal")
    private String internal;

    /***
     * Publicly available source.
     */
    @JsonProperty("public")
    private String _public;

    public String getInternal() {
        return internal;
    }

    public void setInternal(String internal) {
        this.internal = internal;
    }

    public String get_public() {
        return _public;
    }

    public void set_public(String _public) {
        this._public = _public;
    }

    @Override
    public String toString() {
        return "PackagingSourceType{" +
                "internal='" + internal + '\'' +
                ", public=" + _public + '\'' +
                '}';
    }
}
