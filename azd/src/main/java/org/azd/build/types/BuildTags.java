package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildTags extends SerializableEntity {
    @JsonProperty("value")
    private String[] tags;

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

}
