package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.QueryErrorPolicy;
import org.azd.enums.QueryExpand;

import java.util.List;

/**
 * Describes a request to get a list of queries
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryBatchGetRequest extends SerializableEntity {
    /**
     * The expand parameters for queries. Possible options are { None, Wiql, Clauses, All, Minimal }
     */
    @JsonProperty("$expand")
    public QueryExpand expand;
    /**
     * The flag to control error policy in a query batch request. Possible options are { Fail, Omit }.
     */
    @JsonProperty("errorPolicy")
    public QueryErrorPolicy errorPolicy;
    /**
     * The requested query ids
     */
    @JsonProperty("ids")
    public List<String> ids;
}
