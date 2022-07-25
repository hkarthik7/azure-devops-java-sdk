package org.azd.enums;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a reference to a definition. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum DefinitionQuality {

    @JsonProperty("definition")
    DEFINITION,

    @JsonProperty("draft")
    DRAFT;

}