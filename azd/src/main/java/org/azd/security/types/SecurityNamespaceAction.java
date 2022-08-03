package org.azd.security.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * represents an action in a particular security namespace
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SecurityNamespaceAction extends BaseAbstractMethod {
    /***
     * bitmask position, power of 2 value
     */
    @JsonProperty("bit")
    private int bit;
    /***
     * name of security action
     */
    @JsonProperty("name")
    private String name;
    /***
     * display name of security action
     */
    @JsonProperty("displayName")
    private String displayName;
    /***
     * UUID of security action
     */
    @JsonProperty("namespaceId")
    private String namespaceId;

    public int getBit() {
        return bit;
    }

    public void setBit(int bit) {
        this.bit = bit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getNamespaceId() {
        return namespaceId;
    }

    public void setNamespaceId(String namespaceId) {
        this.namespaceId = namespaceId;
    }

}
