package org.azd.build.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Represents an issue (error, warning) associated with a build.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue extends SerializableEntity {
    /**
     * The category.
     **/
    @JsonProperty("category")
    private String category;

    @JsonProperty("data")
    private Object data;
    /**
     * A description of the issue.
     **/
    @JsonProperty("message")
    private String message;
    /**
     * The type (error, warning) of the issue.
     **/
    @JsonProperty("type")
    private IssueType type;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public IssueType getType() {
        return type;
    }

    public void setType(IssueType type) {
        this.type = type;
    }

}