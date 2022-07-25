package org.azd.build.types;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents an attachment to a build. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Attachment {
    /**
     * The class to represent a collection of REST reference links.
     **/
    @JsonProperty("_links")
    private Object _links;
    /**
     * The name of the attachment.
     **/
    @JsonProperty("name")
    private String name;

    public Object get_links() {
        return _links;
    }

    public void set_links(Object _links) {
        this._links = _links;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "_links=" + _links +
                ", name='" + name + '\'' +
                '}';
    }
}