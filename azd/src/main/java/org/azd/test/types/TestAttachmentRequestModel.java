package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.enums.TestAttachmentType;

/**
 * Test attachment request model
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestAttachmentRequestModel {
    /**
     * Attachment type By Default it will be GeneralAttachment.
     */
    @JsonProperty("attachmentType")
    public TestAttachmentType attachmentType = TestAttachmentType.GENERAL_ATTACHMENT;
    /**
     * Comment associated with attachment
     */
    @JsonProperty("comment")
    public String comment;
    /**
     * Attachment filename
     */
    @JsonProperty("fileName")
    public String fileName;
    /**
     * Base64 encoded file stream
     */
    @JsonProperty("stream")
    public String stream;
}
