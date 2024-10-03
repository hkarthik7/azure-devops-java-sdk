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
 * Test Resolution State Details.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestEnvironment extends SerializableEntity {
    /**
     * Test Environment Id.
     **/
    @JsonProperty("environmentId")
    private String environmentId;
    /**
     * Test Environment Name.
     **/
    @JsonProperty("environmentName")
    private String environmentName;

    public String getEnvironmentId() {
        return environmentId;
    }

    public void setEnvironmentId(String environmentId) {
        this.environmentId = environmentId;
    }

    public String getEnvironmentName() {
        return environmentName;
    }

    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }

}