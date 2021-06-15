package org.azd.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferenceLink {
    @JsonProperty("self")
    private Reference self;

    @Override
    public String toString() {
        return "ReferenceLink{" +
                "self=" + self +
                '}';
    }

    public Reference getSelf() {
        return self;
    }

    public void setSelf(Reference self) {
        this.self = self;
    }
}
