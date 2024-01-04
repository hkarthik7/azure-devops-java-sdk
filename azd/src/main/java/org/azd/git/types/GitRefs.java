package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/***
 * List of refs (branches).
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitRefs extends SerializableCollectionEntity {

    /***
     * List of refs (branches).
     */
    @JsonProperty("value")
    private List<GitRef> value;

    public List<GitRef> getRefs() {
        return value;
    }

    public void setRefs(List<GitRef> value) {
        this.value = value;
    }

}
