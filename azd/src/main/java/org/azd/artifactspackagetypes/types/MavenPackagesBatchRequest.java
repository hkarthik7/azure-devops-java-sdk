package org.azd.artifactspackagetypes.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.PackagesBatchOperation;

import java.util.List;
import java.util.Map;

/**
 * A batch of operations to apply to package versions.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MavenPackagesBatchRequest extends SerializableEntity {
    /**
     * Type of operation that needs to be performed on packages.
     */
    @JsonProperty("data")
    public Map<String, Object> data;
    /**
     * Type of operation that needs to be performed on packages.
     */
    @JsonProperty("operation")
    public PackagesBatchOperation operation;
    /**
     * The packages onto which the operation will be performed.
     */
    @JsonProperty("packages")
    public List<MavenMinimalPackageDetails> packages;
}
