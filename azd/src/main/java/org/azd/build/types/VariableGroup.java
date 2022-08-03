package org.azd.build.types;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.Map;

/**
 * None 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class VariableGroup extends BaseAbstractMethod {
    /**
     * The Name of the variable group.
     **/
    @JsonProperty("alias")
    private String alias;
    /**
     * The description.
     **/
    @JsonProperty("description")
    private String description;
    /**
     * The ID of the variable group.
     **/
    @JsonProperty("id")
    private Integer id;
    /**
     * The name of the variable group.
     **/
    @JsonProperty("name")
    private String name;
    /**
     * The type of the variable group.
     **/
    @JsonProperty("type")
    private String type;

    @JsonProperty("variables")
    private Map<String, BuildDefinitionVariable> variables;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, BuildDefinitionVariable> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, BuildDefinitionVariable> variables) {
        this.variables = variables;
    }
}
