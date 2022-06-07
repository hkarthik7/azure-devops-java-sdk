package org.azd.maven.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.enums.MavenOperation;

/***
 * The JSON model for a JSON Patch operation.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPatchOperation {

    /***
     * The path to copy from for the Move/Copy operation.
     */
    @JsonProperty("from")
    private String from;

    /***
     * The patch operation.
     */
    @JsonProperty("op")
    private MavenOperation op;

    /***
     * The path for the operation. In the case of an array, a zero based index can
     * be used to specify the position in the array (e.g. /biscuits/0/name). The "-"
     * character can be used instead of an index to insert at the end of the array
     * (e.g. /biscuits/-).
     *
     *
     */
    @JsonProperty("path")
    private String path;

    /***
     * The value for the operation. This is either a primitive or a JToken.
     */
    @JsonProperty("value")
    private Object value;

}
