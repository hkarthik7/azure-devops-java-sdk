package org.azd.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Common class to represent self reference link
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferenceLink extends BaseAbstractMethod {
    /***
     * Common class to represent self reference link
     */
    @JsonProperty("self")
    private Reference self;


    public Reference getSelf() {
        return self;
    }

    public void setSelf(Reference self) {
        this.self = self;
    }
}
