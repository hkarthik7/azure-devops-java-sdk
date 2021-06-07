package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Workitems<T extends WorkitemFields> {
    @JsonProperty("value")
    private List<Workitem<T>> value;

    public List<Workitem<T>> getWorkitems() {
        return value;
    }

    public void setWorkitems(List<Workitem<T>> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Workitems{" +
                "value=" + value +
                '}';
    }
}
