package org.azd.core.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * The class represents a property bag as a collection of key-value pairs. Values of all primitive types
 * (any type with a TypeCode != TypeCode.Object) except for DBNull are accepted. Values of type Byte[], Int32,
 * Double, DateType and String preserve their type, other primitives are retuned as a String. Byte[] expected
 * as base64 encoded string.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertiesCollection extends SerializableEntity {
    /**
     * The count of properties in the collection.
     **/
    @JsonProperty("count")
    private Integer count;

    @JsonProperty("item")
    private Object item;
    /**
     * The set of keys in the collection.
     **/
    @JsonProperty("keys")
    private String[] keys;
    /**
     * The set of values in the collection.
     **/
    @JsonProperty("values")
    private String[] values;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
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