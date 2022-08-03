package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Represents build repository
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository extends BaseAbstractMethod {
    /***
     * Id of the repository
     */
    @JsonProperty("id")
    private String id;
    /***
     * Type of the repository
     */
    @JsonProperty("type")
    private String type;
    /***
     * Name of the repository
     */
    @JsonProperty("name")
    private String name;
    /***
     * URL of the repository
     */
    @JsonProperty("url")
    private String url;
    /***
     * Clean
     */
    @JsonProperty("clean")
    private String clean;
    /***
     * To check out submodules or not
     */
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

}
