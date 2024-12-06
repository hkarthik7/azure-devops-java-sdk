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
 * Reference to a shared step workitem.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class SharedStepModel extends SerializableEntity {

    /**
     * WorkItem shared step ID.
     **/
    @JsonProperty("id")
    private Integer id;

    /**
     * Shared step workitem revision.
     **/
    @JsonProperty("revision")
    private Integer revision;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }
}
