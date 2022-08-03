package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Represents a queue for running builds.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildQueue extends BaseAbstractMethod {
    /***
     * The ID of the queue.
     */
    @JsonProperty("id")
    private String id;
    /***
     * The name of the queue.
     */
    @JsonProperty("name")
    private String name;
    /***
     * The pool used by this queue.
     */
    @JsonProperty("pool")
    private BuildPool pool;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BuildPool getPool() {
        return pool;
    }

    public void setPool(BuildPool pool) {
        this.pool = pool;
    }

}
