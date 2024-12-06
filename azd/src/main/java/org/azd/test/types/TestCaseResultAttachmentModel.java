package org.azd.test.types;

/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Test attachment information in a test iteration.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestCaseResultAttachmentModel extends SerializableEntity {

    /**
     * Path identifier for the test step in the test case workitem.
     **/
    @JsonProperty("actionPath")
    private String actionPath;

    /**
     * Attachment ID.
     **/
    @JsonProperty("id")
    private Integer id;

    /**
     * Iteration ID associated with the attachment.
     **/
    @JsonProperty("iterationId")
    private Integer iterationId;

    /**
     * Name of the attachment.
     **/
    @JsonProperty("name")
    private String name;

    /**
     * Size of the attachment in bytes.
     **/
    @JsonProperty("size")
    private Integer size;

    /**
     * URL to access the attachment.
     **/
    @JsonProperty("url")
    private String url;

    public String getActionPath() {
        return actionPath;
    }

    public void setActionPath(String actionPath) {
        this.actionPath = actionPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIterationId() {
        return iterationId;
    }

    public void setIterationId(Integer iterationId) {
        this.iterationId = iterationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
