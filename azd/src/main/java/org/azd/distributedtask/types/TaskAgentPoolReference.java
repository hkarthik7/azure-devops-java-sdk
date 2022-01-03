package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskAgentPoolReference {
    @JsonProperty("id")
    private int id;
    @JsonProperty("isHosted")
    private boolean isHosted;
    @JsonProperty("isLegacy")
    private boolean isLegacy;
    @JsonProperty("name")
    private String name;
    @JsonProperty("options")
    private String options;
    @JsonProperty("poolType")
    private String poolType;
    @JsonProperty("scope")
    private String scope;
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
