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
 * Represents the failing since information of a test result.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class FailingSince extends SerializableEntity {

    /**
     * Build reference since failing.
     **/
    @JsonProperty("build")
    private BuildReference build;

    /**
     * Time since failing (UTC).
     **/
    @JsonProperty("date")
    private String date;

    /**
     * Release reference since failing.
     **/
    @JsonProperty("release")
    private ReleaseReference release;

    // Getters and setters
    public BuildReference getBuild() {
        return build;
    }

    public void setBuild(BuildReference build) {
        this.build = build;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ReleaseReference getRelease() {
        return release;
    }

    public void setRelease(ReleaseReference release) {
        this.release = release;
    }
}
