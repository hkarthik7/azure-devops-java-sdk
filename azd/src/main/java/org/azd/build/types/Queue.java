package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.definitions.ReferenceLinks;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Queue {
    @JsonProperty("_links")
    private ReferenceLinks _links;
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("pool")
    private BuildPool pool;

    public ReferenceLinks get_links() {
        return _links;
    }

    public void set_links(ReferenceLinks _links) {
        this._links = _links;
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

    public BuildPool getPool() {
        return pool;
    }

    public void setPool(BuildPool pool) {
        this.pool = pool;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "_links=" + _links +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", pool=" + pool +
                '}';
    }
}
