package org.azd.build.types;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * None
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskInputValidation extends SerializableEntity {
    /**
     * Conditional expression
     **/
    @JsonProperty("expression")
    private String expression;
    /**
     * Message explaining how user can correct if validation fails
     **/
    @JsonProperty("message")
    private String message;

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
