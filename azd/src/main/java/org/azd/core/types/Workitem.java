package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Workitem<T extends WorkitemFields> {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("rev")
    private Integer rev;
    @JsonProperty("url")
    private String url;
    @JsonProperty("fields")
    private T fields;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRev() {
        return rev;
    }

    public void setRev(Integer rev) {
        this.rev = rev;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getFields() {
        return fields;
    }

    public void setFields(T fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", rev='" + rev + '\'' +
                ", fields='" + fields + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
