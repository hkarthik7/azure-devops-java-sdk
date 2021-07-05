package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildChange {
    @JsonProperty("id")
    private String id;
    @JsonProperty("message")
    private String message;
    @JsonProperty("type")
    private String type;
    @JsonProperty("author")
    private Author author;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("location")
    private String location;
    @JsonProperty("pusher")
    private String pusher;

    @Override
    public String toString() {
        return "Change{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                ", type='" + type + '\'' +
                ", author=" + author +
                ", timestamp='" + timestamp + '\'' +
                ", location='" + location + '\'' +
                ", pusher='" + pusher + '\'' +
                '}';
    }

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
