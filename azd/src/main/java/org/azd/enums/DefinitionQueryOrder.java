package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum DefinitionQueryOrder {
    /**
     * Order by definition name ascending.
     */
    @JsonProperty("definitionNameAscending")
    DEFINITIONNAMEASCENDING,
    /**
     * Order by definition name descending.
     */
    @JsonProperty("definitionNameDescending")
    DEFINITIONNAMEDESCENDING,
    /**
     * Order by created on/last modified time ascending.
     */
    @JsonProperty("lastModifiedAscending")
    LASTMODIFIEDASCENDING,
    /**
     * Order by created on/last modified time descending.
     */
    @JsonProperty("lastModifiedDescending")
    LASTMODIFIEDDESCENDING
}
