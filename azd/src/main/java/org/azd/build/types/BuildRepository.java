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
 * The build result. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildRepository extends BaseAbstractMethod {
    /**
     * Indicates whether to checkout submodules.
     **/
    @JsonProperty("checkoutSubmodules")
    private Boolean checkoutSubmodules;
    /**
     * Indicates whether to clean the target folder when getting code from the repository.
     **/
    @JsonProperty("clean")
    private String clean;
    /**
     * The name of the default branch.
     **/
    @JsonProperty("defaultBranch")
    private String defaultBranch;
    /**
     * The ID of the repository.
     **/
    @JsonProperty("id")
    private String id;
    /**
     * The friendly name of the repository.
     **/
    @JsonProperty("name")
    private String name;

    @JsonProperty("properties")
    private Object properties;
    /**
     * The root folder.
     **/
    @JsonProperty("rootFolder")
    private String rootFolder;
    /**
     * The type of the repository.
     **/
    @JsonProperty("type")
    private String type;
    /**
     * The URL of the repository.
     **/
    @JsonProperty("url")
    private String url;

    public Boolean getCheckoutSubmodules() {
        return checkoutSubmodules;
    }

    public void setCheckoutSubmodules(Boolean checkoutSubmodules) {
        this.checkoutSubmodules = checkoutSubmodules;
    }

    public String getClean() {
        return clean;
    }

    public void setClean(String clean) {
        this.clean = clean;
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

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

    public Object getProperties() {
        return properties;
    }

    public void setProperties(Object properties) {
        this.properties = properties;
    }

    public String getRootFolder() {
        return rootFolder;
    }

    public void setRootFolder(String rootFolder) {
        this.rootFolder = rootFolder;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
