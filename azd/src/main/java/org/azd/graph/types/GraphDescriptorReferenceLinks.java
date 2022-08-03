package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.common.types.Reference;

/***
 * This field contains zero or more interesting links about the graph subject.
 * These links may be invoked to obtain additional relationships or more detailed information about this graph subject.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphDescriptorReferenceLinks extends BaseAbstractMethod {
    /***
     * Self reference url
     */
    @JsonProperty("self")
    private Reference self;

    @JsonProperty("storageKey")
    private Reference storageKey;

    @JsonProperty("subject")
    private Reference subject;

    public Reference getSelf() {
        return self;
    }

    public void setSelf(Reference self) {
        this.self = self;
    }

    public Reference getStorageKey() {
        return storageKey;
    }

    public void setStorageKey(Reference storageKey) {
        this.storageKey = storageKey;
    }

    public Reference getSubject() {
        return subject;
    }

    public void setSubject(Reference subject) {
        this.subject = subject;
    }

}
