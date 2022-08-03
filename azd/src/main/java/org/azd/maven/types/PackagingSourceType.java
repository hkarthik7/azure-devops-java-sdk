package org.azd.maven.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Source type, such as Public or Internal.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PackagingSourceType extends BaseAbstractMethod {
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

}
