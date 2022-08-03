package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * Represents an issue (error, warning) associated with a build.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue extends BaseAbstractMethod {
    /**
     * The category.
     */
    @JsonProperty("category")
    private String category;
    /**
     * data
     */
    @JsonProperty("data")
    private Object data;
    /**
     * A description of the issue.
     */
    @JsonProperty("message")
    private String message;
    /**
     * The type (error, warning) of the issue.
     */
    @JsonProperty("type")
    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
