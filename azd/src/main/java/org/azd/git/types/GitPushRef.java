package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.types.Author;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitPushRef {
    @JsonProperty("_links")
    private JsonNode _links;
    @JsonProperty("date")
    private String date;
    @JsonProperty("pushId")
    private int pushId;
    @JsonProperty("pushedBy")
    private Author pushedBy;
    @JsonProperty("url")
    private String url;

    public JsonNode get_links() {
        return _links;
    }

    public void set_links(JsonNode _links) {
        this._links = _links;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPushId() {
        return pushId;
    }

    public void setPushId(int pushId) {
        this.pushId = pushId;
    }

    public Author getPushedBy() {
        return pushedBy;
    }

    public void setPushedBy(Author pushedBy) {
        this.pushedBy = pushedBy;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "GitPushRef{" +
                "_links=" + _links +
                ", date='" + date + '\'' +
                ", pushId=" + pushId +
                ", pushedBy=" + pushedBy +
                ", url='" + url + '\'' +
                '}';
    }
}
