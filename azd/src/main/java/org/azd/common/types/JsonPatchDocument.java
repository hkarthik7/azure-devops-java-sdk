package org.azd.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.enums.PatchOperation;

/**
 * Model for path operation.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPatchDocument extends BaseAbstractMethod{
    /**
     * The path to copy from for the Move/Copy operation.
     */
    @JsonProperty("from")
    private String from;
    /**
     * The patch operation
     */
    @JsonProperty("op")
    private PatchOperation operation;
    /**
     * The path for the operation. In the case of an array, a zero based index can be used to specify
     * the position in the array (e.g. /biscuits/0/name).
     * The "-" character can be used instead of an index to insert at the end of the array (e.g. /biscuits/-).
     */
    @JsonProperty("path")
    private String path;
    /**
     * The value for the operation. This is either a primitive or a JToken.
     */
    @JsonProperty("value")
    private Object value;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public PatchOperation getOperation() {
        return operation;
    }

    public void setOperation(PatchOperation operation) {
        this.operation = operation;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
