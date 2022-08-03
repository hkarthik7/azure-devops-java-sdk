package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Work item type state name, color and state category
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemStateColor extends BaseAbstractMethod {
    /***
     * Category of state
     */
    @JsonProperty("category")
    private String category;
    /***
     * Color value
     */
    @JsonProperty("color")
    private String color;
    /***
     * Work item type state name
     */
    @JsonProperty("name")
    private String name;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
