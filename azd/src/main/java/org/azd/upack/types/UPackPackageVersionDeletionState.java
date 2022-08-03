package org.azd.upack.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Deletion state of a Universal package.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UPackPackageVersionDeletionState extends BaseAbstractMethod {
    /***
     * UTC date the package was deleted.
     */
    @JsonProperty("deletedDate")
    private String deletedDate;

    /***
     * Name of the package.
     */
    @JsonProperty("name")
    private String name;

    /***
     * The version of the package.
     */
    @JsonProperty("version")
    private String version;

    public String getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(String deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
