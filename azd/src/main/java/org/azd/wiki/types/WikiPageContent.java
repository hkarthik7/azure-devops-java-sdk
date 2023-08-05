package org.azd.wiki.types;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.azd.serializer.SerializableEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WikiPageContent extends SerializableEntity {
    /**
     * Content of wiki page
     */
    @JacksonInject("content")
    private String content;
    /**
     * Specified the version string of the attachment.
     */
    @JacksonInject("etag")
    private String eTag;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String geteTag() {
        return eTag;
    }

    public void seteTag(String eTag) {
        this.eTag = eTag;
    }
}
