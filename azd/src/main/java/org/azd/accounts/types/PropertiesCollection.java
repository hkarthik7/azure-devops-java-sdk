package org.azd.accounts.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertiesCollection {
    @JsonProperty("count")
    private int count;
    @JsonProperty("item")
    private JsonNode item;
    @JsonProperty("keys")
    private String[] keys;
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

    @Override
    public String toString() {
        return "PropertiesCollection{" +
                "count=" + count +
                ", item=" + item +
                ", keys=" + Arrays.toString(keys) +
                ", values=" + Arrays.toString(values) +
                '}';
    }
}
