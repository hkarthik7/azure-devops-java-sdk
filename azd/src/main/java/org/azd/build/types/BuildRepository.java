package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildRepository {
    @JsonProperty("properties")
    private Properties properties;
    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("defaultBranch")
    private String defaultBranch;
    @JsonProperty("clean")
    private String clean;
    @JsonProperty("checkoutSubmodules")
    private boolean checkoutSubmodules;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

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

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
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
        return "BuildRepository{" +
                "properties=" + properties +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", defaultBranch='" + defaultBranch + '\'' +
                ", clean='" + clean + '\'' +
                ", checkoutSubmodules=" + checkoutSubmodules +
                '}';
    }
}
