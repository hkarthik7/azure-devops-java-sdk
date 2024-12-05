package org.azd.test.types;

/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Represents a reference to a build with details such as branch name,
 * build system, and repository information.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildReference extends SerializableEntity {

    /**
     * Name of the branch associated with the build.
     **/
    @JsonProperty("branchName")
    private String branchName;

    /**
     * The build system used for the build.
     **/
    @JsonProperty("buildSystem")
    private String buildSystem;

    /**
     * ID of the build definition.
     **/
    @JsonProperty("definitionId")
    private Integer definitionId;

    /**
     * Unique ID of the build.
     **/
    @JsonProperty("id")
    private Integer id;

    /**
     * Number identifying the build.
     **/
    @JsonProperty("number")
    private String number;

    /**
     * Repository ID associated with the build.
     **/
    @JsonProperty("repositoryId")
    private String repositoryId;

    /**
     * URI of the build.
     **/
    @JsonProperty("uri")
    private String uri;

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBuildSystem() {
        return buildSystem;
    }

    public void setBuildSystem(String buildSystem) {
        this.buildSystem = buildSystem;
    }

    public Integer getDefinitionId() {
        return definitionId;
    }

    public void setDefinitionId(Integer definitionId) {
        this.definitionId = definitionId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRepositoryId() {
        return repositoryId;
    }

    public void setRepositoryId(String repositoryId) {
        this.repositoryId = repositoryId;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
