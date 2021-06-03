package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Workitems {
    @JsonProperty("value")
    private List<Workitem> value;

    public List<Workitem> getWorkitems() {
        return value;
    }

    public void setWorkitems(List<Workitem> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Workitems{" +
                "value=" + value +
                '}';
    }
}
