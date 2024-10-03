package org.azd.artifactspackagetypes.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.common.types.JsonPatchDocument;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PackageVersionDetails extends SerializableEntity {
    @JsonProperty("views")
    public JsonPatchDocument views;
}
