package org.azd.artifactspackagetypes.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.PackagesBatchOperation;

import java.util.List;

/**
 * A batch of operations to apply to package versions.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UPackPackagesBatchRequest extends SerializableEntity {
    /**
     * Type of operation that needs to be performed on packages.
     */
    @JsonProperty("operation")
    public PackagesBatchOperation operation;
    /**
     * The packages onto which the operation will be performed.
     */
    @JsonProperty("packages")
    public List<MinimalPackageDetails> packages;
}
