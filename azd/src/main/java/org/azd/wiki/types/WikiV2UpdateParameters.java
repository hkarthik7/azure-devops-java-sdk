package org.azd.wiki.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * Wiki update parameters.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WikiV2UpdateParameters extends SerializableEntity {
    /**
     * Name of the Wiki.
     */
    @JsonProperty("name")
    public String name;
    /**
     * Versions of the wiki.
     */
    @JsonProperty("versions")
    public List<GitVersionDescriptor> versions;
}
