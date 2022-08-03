package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;

/***
 * Graph user entity
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphUser extends GraphEntity {
    /***
     * The short, generally unique name for the user in the backing directory.
     * For AAD users, this corresponds to the mail nickname, which is often but not
     * necessarily similar to the part of the user's mail address before the @ sign.
     * For GitHub users, this corresponds to the GitHub user handle.
     */
    @JsonProperty("directoryAlias")
    private String directoryAlias;
    /***
     * When true, the group has been deleted in the identity provider
     */
    @JsonProperty("isDeletedInOrigin")
    private boolean isDeletedInOrigin;
    /***
     * The legacy descriptor is here in case you need to access old version IMS using identity descriptor.
     */
    @JsonProperty("legacyDescriptor")
    private String legacyDescriptor;
    /***
     * The meta type of the user in the origin, such as "member", "guest", etc. See UserMetaType for the set of possible values.
     */
    @JsonProperty("metaType")
    private String metaType;

    public String getDirectoryAlias() {
        return directoryAlias;
    }

    public void setDirectoryAlias(String directoryAlias) {
        this.directoryAlias = directoryAlias;
    }

    public boolean isDeletedInOrigin() {
        return isDeletedInOrigin;
    }

    public void setDeletedInOrigin(boolean deletedInOrigin) {
        isDeletedInOrigin = deletedInOrigin;
    }

    public String getLegacyDescriptor() {
        return legacyDescriptor;
    }

    public void setLegacyDescriptor(String legacyDescriptor) {
        this.legacyDescriptor = legacyDescriptor;
    }

    public String getMetaType() {
        return metaType;
    }

    public void setMetaType(String metaType) {
        this.metaType = metaType;
    }

    @Override
    public String toString() {
        String res = null;
        var mapper = new JsonMapper();

        try {
            res = mapper.convertToString(this);
        } catch (AzDException ignored) { }

        return res;
    }
}
