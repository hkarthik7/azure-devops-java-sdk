package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * List of project
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Projects extends BaseAbstractMethod {
    /***
     * List of project
     */
    @JsonProperty("value")
    private List<Project> projects;

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> value) {
        this.projects = value;
    }

}
