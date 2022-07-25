package org.azd.build.types;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a reference to an agent pool. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueueOptions {
    /**
     * Create a plan Id for the build, do not run it
     **/
    @JsonProperty("doNotRun")
    private String doNotRun;
    /**
     * No queue options
     **/
    @JsonProperty("none")
    private String none;

    public String getDoNotRun() {
        return doNotRun;
    }

    public void setDoNotRun(String doNotRun) {
        this.doNotRun = doNotRun;
    }

    public String getNone() {
        return none;
    }

    public void setNone(String none) {
        this.none = none;
    }

    @Override
    public String toString() {
        return "QueueOptions{" +
                "doNotRun='" + doNotRun + '\'' +
                ", none='" + none + '\'' +
                '}';
    }
}