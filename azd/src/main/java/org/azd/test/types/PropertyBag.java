package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * The class to represent a Generic store for test session data.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertyBag extends SerializableEntity {
    /**
     * Generic store for test session data
     */
    @JsonProperty("bag")
    private Object bag;

    public Object getBag() {
        return bag;
    }

    public void setBag(Object bag) {
        this.bag = bag;
    }
}
