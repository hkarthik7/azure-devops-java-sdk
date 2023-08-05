package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

import java.util.List;

/***
 * Array of environment instance {@link EnvironmentInstance}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnvironmentInstances extends SerializableEntity {
    /***
     * Array of environment instance {@link EnvironmentInstance}
     */
    @JsonProperty("value")
    private List<EnvironmentInstance> environmentInstances;

    public List<EnvironmentInstance> getEnvironmentInstances() {
        return environmentInstances;
    }

    public void setEnvironmentInstances(List<EnvironmentInstance> environmentInstances) {
        this.environmentInstances = environmentInstances;
    }

}
