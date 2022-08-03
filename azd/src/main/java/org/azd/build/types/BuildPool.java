package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Represents a reference to an agent pool.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildPool extends BaseAbstractMethod {
    /***
     * The pool ID.
     */
    @JsonProperty("id")
    private String id;
    /***
     * The pool name.
     */
    @JsonProperty("name")
    private String name;
    /***
     * A value indicating whether or not this pool is managed by the service.
     */
    @JsonProperty("isHosted")
    private boolean isHosted;

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

    public boolean isHosted() {
        return isHosted;
    }

    public void setHosted(boolean hosted) {
        isHosted = hosted;
    }

}
