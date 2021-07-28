package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemStateColor {
    @JsonProperty("category")
    private String category;
    @JsonProperty("color")
    private String color;
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

    @Override
    public String toString() {
        return "WorkItemStateColor{" +
                "category='" + category + '\'' +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
