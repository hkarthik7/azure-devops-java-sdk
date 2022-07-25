package org.azd.maven.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * The class to represent a collection of REST reference links.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferenceLinks {
    /***
     * Related REST links.
     */
    @JsonProperty("links")
    private Object links;

    public Object getLinks() {
        return links;
    }

    public void setLinks(Object links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "Object{" +
                "links='" + links.toString() +
                '}';
    }
}
