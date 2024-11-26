package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitItemsList extends SerializableEntity {
    public List<GitItems> gitItems;
}
