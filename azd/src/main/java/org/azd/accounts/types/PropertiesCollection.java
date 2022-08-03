package org.azd.accounts.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.types.BaseAbstractMethod;

/***
 * The class represents a property bag as a collection of key-value pairs. Values of all primitive types
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertiesCollection extends BaseAbstractMethod {
    /***
     * The count of properties in the collection.
     */
    @JsonProperty("count")
    private int count;
    /***
     * item
     */
    @JsonProperty("item")
    private JsonNode item;
    /***
     * The set of keys in the collection.
     */
    @JsonProperty("keys")
    private String[] keys;
    /***
     * The set of values in the collection.
     */
    @JsonProperty("values")
    private String[] values;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public JsonNode getItem() {
        return item;
    }

    public void setItem(JsonNode item) {
        this.item = item;
    }

    public String[] getKeys() {
        return keys;
    }

    public void setKeys(String[] keys) {
        this.keys = keys;
    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }

}
