package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.AttachmentType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TestAttachment extends SerializableEntity {
    /**
     * Attachment type.
     */
    @JsonProperty("attachmentType")
    private AttachmentType attachmentType;
    /**
     * Comment associated with attachment.
     */
    @JsonProperty("comment")
    private String comment;
    /**
     * Attachment created date.
     */
    @JsonProperty("createdDate")
    private String createdDate;
    /**
     * Attachment file name
     */
    @JsonProperty("fileName")
    private String fileName;
    /**
     * ID of the attachment.
     */
    @JsonProperty("id")
    private Integer id;
    /**
     * Attachment size.
     */
    @JsonProperty("size")
    private Integer size;
    /**
     * Attachment Url.
     */
    @JsonProperty("url")
    private String url;

    public AttachmentType getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(AttachmentType attachmentType) {
        this.attachmentType = attachmentType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
