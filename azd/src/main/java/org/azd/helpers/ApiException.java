package org.azd.helpers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Represents API inner exception
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiException {
    /***
     * Id of the exception
     */
    @JsonProperty("$id")
    private int id;
    /***
     * Inner exception if any exists
     */
    @JsonProperty("innerException")
    private String innerException;
    /***
     * Exception message
     */
    @JsonProperty("message")
    private String message;
    /***
     * Exception type
     */
    @JsonProperty("typeName")
    private String typeName;
    /***
     * Exception type key
     */
    @JsonProperty("typeKey")
    private String typeKey;
    /***
     * Error code
     */
    @JsonProperty("errorCode")
    private int errorCode;
    /***
     * Event id
     */
    @JsonProperty("eventId")
    private int eventId;

    @Override
    public String toString() {
        return "ApiException{" +
                "id=" + id +
                ", innerException='" + innerException + '\'' +
                ", message='" + message + '\'' +
                ", typeName='" + typeName + '\'' +
                ", typeKey='" + typeKey + '\'' +
                ", errorCode=" + errorCode +
                ", eventId=" + eventId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInnerException() {
        return innerException;
    }

    public void setInnerException(String innerException) {
        this.innerException = innerException;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeKey() {
        return typeKey;
    }

    public void setTypeKey(String typeKey) {
        this.typeKey = typeKey;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
}
