package org.azd.memberentitlementmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * A reference to a project
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectRef {
    /***
     * Project ID.
     */
    @JsonProperty("id")
    private String id;
    /***
     * Project Name.
     */
    @JsonProperty("name")
    private String name;

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

    @Override
    public String toString() {
        return "ProjectRef{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
