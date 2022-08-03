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
 * The class to represent a collection of REST reference links. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildArtifact extends BaseAbstractMethod {
    /**
     * The artifact ID.
     **/
    @JsonProperty("id")
    private Integer id;
    /**
     * The name of the artifact.
     **/
    @JsonProperty("name")
    private String name;
    /**
     * The actual resource.
     **/
    @JsonProperty("resource")
    private ArtifactResource resource;
    /**
     * The artifact source, which will be the ID of the job that produced this artifact. If an artifact is associated with multiple sources, this points to the first source.
     **/
    @JsonProperty("source")
    private String source;

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

    public ArtifactResource getResource() {
        return resource;
    }

    public void setResource(ArtifactResource resource) {
        this.resource = resource;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}
