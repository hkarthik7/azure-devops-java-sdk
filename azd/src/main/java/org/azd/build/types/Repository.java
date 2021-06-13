package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {
    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("clean")
    private String clean;
    @JsonProperty("checkoutSubmodules")
    private boolean checkoutSubmodules;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getClean() {
        return clean;
    }

    public void setClean(String clean) {
        this.clean = clean;
    }

    public boolean isCheckoutSubmodules() {
        return checkoutSubmodules;
    }

    public void setCheckoutSubmodules(boolean checkoutSubmodules) {
        this.checkoutSubmodules = checkoutSubmodules;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", clean='" + clean + '\'' +
                ", checkoutSubmodules=" + checkoutSubmodules +
                '}';
    }
}
