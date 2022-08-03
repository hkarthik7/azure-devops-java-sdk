package org.azd.security.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;
import java.util.Objects;

/***
 * Represents a security namespace.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SecurityNamespace extends BaseAbstractMethod {
    /***
     * uuid of namespace
     */
    @JsonProperty("namespaceId")
    private String namespaceId;
    /***
     * name of security namespace
     */
    @JsonProperty("name")
    private String name;
    /***
     * display name of security namespace
     */
    @JsonProperty("displayName")
    private String displayName;
    /***
     * separator value
     */
    @JsonProperty("separatorValue")
    private String separatorValue;
    /***
     * element length
     */
    @JsonProperty("elementLength")
    private int elementLength;
    /***
     * write permission numeric value
     */
    @JsonProperty("writePermission")
    private int writePermission;
    /***
     * read permission numeric value
     */
    @JsonProperty("readPermission")
    private int readPermission;
    /***
     * dataspace category
     */
    @JsonProperty("dataspaceCategory")
    private String dataspaceCategory;
    /***
     * list of actions {@link SecurityNamespaceAction}
     */
    @JsonProperty("actions")
    private List<SecurityNamespaceAction> actions;
    /***
     * structure value
     */
    @JsonProperty("structureValue")
    private int structureValue;
    /***
     * extension identifier
     */
    @JsonProperty("extensionType")
    private String extensionType;
    /***
     * is remotable
     */
    @JsonProperty("isRemotable")
    private boolean isRemotable;
    /***
     * use token transfer
     */
    @JsonProperty("useTokenTranslator")
    private boolean useTokenTranslator;
    /***
     * bit mask value, power of 2
     */
    @JsonProperty("systemBitMask")
    private int systemBitMask;

    public String getNamespaceId() {
        return namespaceId;
    }

    public void setNamespaceId(String namespaceId) {
        this.namespaceId = namespaceId;
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

    public String getSeparatorValue() {
        return separatorValue;
    }

    public void setSeparatorValue(String separatorValue) {
        this.separatorValue = separatorValue;
    }

    public int getElementLength() {
        return elementLength;
    }

    public void setElementLength(int elementLength) {
        this.elementLength = elementLength;
    }

    public int getWritePermission() {
        return writePermission;
    }

    public void setWritePermission(int writePermission) {
        this.writePermission = writePermission;
    }

    public int getReadPermission() {
        return readPermission;
    }

    public void setReadPermission(int readPermission) {
        this.readPermission = readPermission;
    }

    public String getDataspaceCategory() {
        return dataspaceCategory;
    }

    public void setDataspaceCategory(String dataspaceCategory) {
        this.dataspaceCategory = dataspaceCategory;
    }

    public List<SecurityNamespaceAction> getActions() {
        return actions;
    }

    public void setActions(List<SecurityNamespaceAction> actions) {
        this.actions = actions;
    }

    public int getStructureValue() {
        return structureValue;
    }

    public void setStructureValue(int structureValue) {
        this.structureValue = structureValue;
    }

    public String getExtensionType() {
        return extensionType;
    }

    public void setExtensionType(String extensionType) {
        this.extensionType = extensionType;
    }

    public boolean isRemotable() {
        return isRemotable;
    }

    public void setRemotable(boolean remotable) {
        isRemotable = remotable;
    }

    public boolean isUseTokenTranslator() {
        return useTokenTranslator;
    }

    public void setUseTokenTranslator(boolean useTokenTranslator) {
        this.useTokenTranslator = useTokenTranslator;
    }

    public int getSystemBitMask() {
        return systemBitMask;
    }

    public void setSystemBitMask(int systemBitMask) {
        this.systemBitMask = systemBitMask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecurityNamespace that = (SecurityNamespace) o;
        return elementLength == that.elementLength && writePermission == that.writePermission && readPermission == that.readPermission && structureValue == that.structureValue && isRemotable == that.isRemotable && useTokenTranslator == that.useTokenTranslator && systemBitMask == that.systemBitMask && Objects.equals(namespaceId, that.namespaceId) && Objects.equals(name, that.name) && Objects.equals(displayName, that.displayName) && Objects.equals(separatorValue, that.separatorValue) && Objects.equals(dataspaceCategory, that.dataspaceCategory) && Objects.equals(actions, that.actions) && Objects.equals(extensionType, that.extensionType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namespaceId, name, displayName, separatorValue, elementLength, writePermission, readPermission, dataspaceCategory, actions, structureValue, extensionType, isRemotable, useTokenTranslator, systemBitMask);
    }
}
