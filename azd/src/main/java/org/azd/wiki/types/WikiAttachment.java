package org.azd.wiki.types;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Defines properties for wiki attachment file.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class WikiAttachment extends SerializableEntity {
    /**
     * Name of the wiki attachment file.
     **/
    @JsonProperty("name")
    private String name;
    /**
     * Path of the wiki attachment file.
     **/
    @JsonProperty("path")
    private String path;
    /**
     * Specified the version string of the attachment.
     */
    @JsonProperty("etag")
    private String eTag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String geteTag() {
        return eTag;
    }

    public void seteTag(String eTag) {
        this.eTag = eTag;
    }
}