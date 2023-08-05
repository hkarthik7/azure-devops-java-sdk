package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

/**
 * A valid retention lease prevents automated systems from deleting a pipeline run.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RetentionLease extends SerializableEntity {
    /**
     * When the lease was created.
     */
    @JsonProperty("createdOn")
    private String createdOn;
    /**
     * The pipeline definition of the run.
     */
    @JsonProperty("definitionId")
    private int definitionId;
    /**
     * The unique identifier for this lease.
     */
    @JsonProperty("leaseId")
    private int leaseId;
    /**
     * Non-unique string that identifies the owner of a retention lease.
     */
    @JsonProperty("ownerId")
    private String ownerId;
    /**
     * If set, this lease will also prevent the pipeline from being deleted while the lease is still valid.
     */
    @JsonProperty("protectPipeline")
    private boolean protectPipeline;
    /**
     * The pipeline run protected by this lease.
     */
    @JsonProperty("runId")
    private int runId;
    /**
     * The last day the lease is considered valid.
     */
    @JsonProperty("validUntil")
    private String validUntil;

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public int getDefinitionId() {
        return definitionId;
    }

    public void setDefinitionId(int definitionId) {
        this.definitionId = definitionId;
    }

    public int getLeaseId() {
        return leaseId;
    }

    public void setLeaseId(int leaseId) {
        this.leaseId = leaseId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public boolean isProtectPipeline() {
        return protectPipeline;
    }

    public void setProtectPipeline(boolean protectPipeline) {
        this.protectPipeline = protectPipeline;
    }

    public int getRunId() {
        return runId;
    }

    public void setRunId(int runId) {
        this.runId = runId;
    }

    public String getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }
}
