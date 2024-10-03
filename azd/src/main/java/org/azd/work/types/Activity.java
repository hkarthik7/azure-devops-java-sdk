package org.azd.work.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * The class to represent a collection of REST reference links.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Activity extends SerializableEntity {

    @JsonProperty("capacityPerDay")
    private int capacityPerDay;

    @JsonProperty("name")
    private String name;

    public int getCapacityPerDay() {
        return capacityPerDay;
    }

    public void setCapacityPerDay(int capacityPerDay) {
        this.capacityPerDay = capacityPerDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}