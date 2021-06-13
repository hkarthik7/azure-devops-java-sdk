package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.core.types.Project;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Definition {
    @JsonProperty("drafts")
    private List<String> drafts;
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("path")
    private String path;
    @JsonProperty("type")
    private String type;
    @JsonProperty("queueStatus")
    private String queueStatus;
    @JsonProperty("revision")
    private int revision;
    @JsonProperty("project")
    private Project project;

    public List<String> getDrafts() {
        return drafts;
    }

    public void setDrafts(List<String> drafts) {
        this.drafts = drafts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQueueStatus() {
        return queueStatus;
    }

    public void setQueueStatus(String queueStatus) {
        this.queueStatus = queueStatus;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Definition{" +
                "drafts='" + drafts + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", uri='" + uri + '\'' +
                ", path='" + path + '\'' +
                ", type='" + type + '\'' +
                ", queueStatus='" + queueStatus + '\'' +
                ", revision=" + revision +
                ", project=" + project +
                '}';
    }
}
