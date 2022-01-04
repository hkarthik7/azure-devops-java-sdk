package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Task agent pool reference
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskAgentPoolReference {
    /***
     * Id of the pool
     */
    @JsonProperty("id")
    private int id;
    /***
     * Gets or sets a value indicating whether or not this pool is managed by the service.
     */
    @JsonProperty("isHosted")
    private boolean isHosted;
    /***
     * Determines whether the pool is legacy.
     */
    @JsonProperty("isLegacy")
    private boolean isLegacy;
    /***
     * Name of the agent
     */
    @JsonProperty("name")
    private String name;
    /***
     * Additional pool settings and details
     */
    @JsonProperty("options")
    private String options;
    /***
     * Gets or sets the type of the pool
     */
    @JsonProperty("poolType")
    private String poolType;
    /***
     * Scope of the agent pool
     */
    @JsonProperty("scope")
    private String scope;
    /***
     * Gets the current size of the pool.
     */
    @JsonProperty("size")
    private int size;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isHosted() {
        return isHosted;
    }

    public void setHosted(boolean hosted) {
        isHosted = hosted;
    }

    public boolean isLegacy() {
        return isLegacy;
    }

    public void setLegacy(boolean legacy) {
        isLegacy = legacy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getPoolType() {
        return poolType;
    }

    public void setPoolType(String poolType) {
        this.poolType = poolType;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "TaskAgentPoolReference{" +
                "id=" + id +
                ", isHosted=" + isHosted +
                ", isLegacy=" + isLegacy +
                ", name='" + name + '\'' +
                ", options='" + options + '\'' +
                ", poolType='" + poolType + '\'' +
                ", scope='" + scope + '\'' +
                ", size=" + size +
                '}';
    }
}
