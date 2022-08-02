package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The flag to control error policy in a query batch request. Possible options are { Fail, Omit }.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum QueryErrorPolicy {
    @JsonProperty("fail")
    FAIL,
    @JsonProperty("omit")
    OMIT;
}
