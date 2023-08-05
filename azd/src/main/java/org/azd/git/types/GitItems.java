package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitItems extends SerializableEntity {
    @JsonProperty("value")
    private List<GitItem> items;

    public List<GitItem> getItems() {
        return items;
    }

    public void setItems(List<GitItem> items) {
        this.items = items;
    }
}
