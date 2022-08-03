package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Represents a change associated with a build.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildChange extends BaseAbstractMethod {
    /***
     * The identifier for the change. For a commit, this would be the SHA1. For a TFVC changeset, this would be the changeset ID.
     */
    @JsonProperty("id")
    private String id;
    /***
     * The description of the change. This might be a commit message or changeset description.
     */
    @JsonProperty("message")
    private String message;
    /***
     * The type of change. "commit", "changeset", etc.
     */
    @JsonProperty("type")
    private String type;
    /***
     * The author of the change.
     */
    @JsonProperty("author")
    private Author author;
    /***
     * The timestamp for the change.
     */
    @JsonProperty("timestamp")
    private String timestamp;
    /***
     * The location of the full representation of the resource.
     */
    @JsonProperty("location")
    private String location;
    /***
     * The person or process that pushed the change.
     */
    @JsonProperty("pusher")
    private String pusher;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPusher() {
        return pusher;
    }

    public void setPusher(String pusher) {
        this.pusher = pusher;
    }
}
