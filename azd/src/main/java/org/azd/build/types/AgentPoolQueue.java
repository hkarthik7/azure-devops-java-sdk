package org.azd.build.types;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * Represents a queue for running builds. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgentPoolQueue extends BaseAbstractMethod {
    /**
     * The class to represent a collection of REST reference links.
     **/
    @JsonProperty("_links")
    private Object _links;
    /**
     * The ID of the queue.
     **/
    @JsonProperty("id")
    private Integer id;
    /**
     * The name of the queue.
     **/
    @JsonProperty("name")
    private String name;
    /**
     * The pool used by this queue.
     **/
    @JsonProperty("pool")
    private TaskAgentPoolReference pool;
    /**
     * The full http link to the resource.
     **/
    @JsonProperty("url")
    private String url;

    public Object get_links() {
        return _links;
    }

    public void set_links(Object _links) {
        this._links = _links;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskAgentPoolReference getPool() {
        return pool;
    }

    public void setPool(TaskAgentPoolReference pool) {
        this.pool = pool;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
