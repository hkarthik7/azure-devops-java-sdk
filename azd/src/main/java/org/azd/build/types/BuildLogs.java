package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

import java.util.List;

/***
 * List of build log
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildLogs extends SerializableEntity {
    /***
     * List of build log
     */
    @JsonProperty("value")
    private List<BuildLog> value;


    public List<BuildLog> getBuildLogs() {
        return value;
    }

    public void setBuildLogs(List<BuildLog> value) {
        this.value = value;
    }
}
