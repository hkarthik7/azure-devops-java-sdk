package org.azd.maven.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Deletion state of a maven package.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MavenPackageVersionDeletionState extends BaseAbstractMethod {

    /***
     * Artifact Id of the package.
     */
    @JsonProperty("artifactId")
    private String artifactId;

    /***
     * UTC date the package was deleted.
     */
    @JsonProperty("deletedDate")
    private String deletedDate;

    /***
     * Group Id of the package.
     */
    @JsonProperty("groupId")
    private String groupId;

    /***
     * The version of the package.
     */
    @JsonProperty("version")
    private String version;

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(String deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
