package org.azd.enums;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The build's priority. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ProjectState {
    /**
     * All projects regardless of state except Deleted.
     **/
    @JsonProperty("all")
    ALL,
    /**
     * Project has been queued for creation, but the process has not yet started.
     **/
    @JsonProperty("createPending")
    CREATEPENDING,
    /**
     * Project has been deleted.
     **/
    @JsonProperty("deleted")
    DELETED,
    /**
     * Project is in the process of being deleted.
     **/
    @JsonProperty("deleting")
    DELETING,
    /**
     * Project is in the process of being created.
     **/
    @JsonProperty("new")
    NEW,
    /**
     * Project has not been changed.
     **/
    @JsonProperty("unchanged")
    UNCHANGED,
    /**
     * Project is completely created and ready to use.
     **/
    @JsonProperty("wellFormed")
    WELLFORMED;
}