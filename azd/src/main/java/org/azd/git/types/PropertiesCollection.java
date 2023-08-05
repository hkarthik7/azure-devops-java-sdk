package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertiesCollection extends SerializableEntity {
    /**
     * The count of properties in the collection.
     */
    @JsonProperty("count")
    private int count;
    @JsonProperty("item")
    private Object item;
    /**
     * The set of keys in the collection.
     */
    @JsonProperty("keys")
    private String[] keys;
    /**
     * The set of values in the collection.
     */
    @JsonProperty("values")
    private String[] values;
}
