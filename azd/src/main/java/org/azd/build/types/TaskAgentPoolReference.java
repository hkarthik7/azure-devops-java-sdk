package org.azd.build.types;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a variable group. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskAgentPoolReference {
    /**
     * The pool ID.
     **/
    @JsonProperty("id")
    private Integer id;
    /**
     * A value indicating whether or not this pool is managed by the service.
     **/
    @JsonProperty("isHosted")
    private Boolean isHosted;
    /**
     * The pool name.
     **/
    @JsonProperty("name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsHosted() {
        return isHosted;
    }

    public void setIsHosted(Boolean isHosted) {
        this.isHosted = isHosted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TaskAgentPoolReference{" +
                "id=" + id +
                ", isHosted=" + isHosted +
                ", name='" + name + '\'' +
                '}';
    }
}