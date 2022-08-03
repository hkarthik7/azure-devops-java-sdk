package org.azd.upack.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Package version metadata for a Universal package
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Package extends BaseAbstractMethod {
    /***
     * Related REST links.
     */
    @JsonProperty("_links")
    private ReferenceLinks _links;

    /***
     * If and when the package was deleted.
     */
    @JsonProperty("deletedDate")
    private String deletedDate;

    /***
     * Package Id.
     */
    @JsonProperty("id")
    private String id;

    /***
     * The display name of the package.
     */
    @JsonProperty("name")
    private String name;

    /***
     * If and when the package was permanently deleted.
     */
    @JsonProperty("permanentlyDeletedDate")
    private String permanentlyDeletedDate;

    /***
     * The version of the package.
     */
    @JsonProperty("version")
    private String version;

    public ReferenceLinks get_links() {
        return _links;
    }

    public void set_links(ReferenceLinks _links) {
        this._links = _links;
    }

    public String getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(String deletedDate) {
        this.deletedDate = deletedDate;
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

    public String getPermanentlyDeletedDate() {
        return permanentlyDeletedDate;
    }

    public void setPermanentlyDeletedDate(String permanentlyDeletedDate) {
        this.permanentlyDeletedDate = permanentlyDeletedDate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
