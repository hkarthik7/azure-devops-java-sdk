package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.common.types.ReferenceLinks;

/***
 * Represents a queue for running builds.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Queue extends BaseAbstractMethod {
    /***
     * The class to represent a collection of REST reference links.
     */
    @JsonProperty("_links")
    private ReferenceLinks _links;
    /***
     * The ID of the queue.
     */
    @JsonProperty("id")
    private int id;
    /***
     * The name of the queue.
     */
    @JsonProperty("name")
    private String name;
    /***
     * The full http link to the resource.
     */
    @JsonProperty("url")
    private String url;
    /***
     * The pool used by this queue.
     */
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

}
