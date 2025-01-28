package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CoverageStatistics extends SerializableEntity {
    @JsonProperty("blocksCovered")
    private Integer blocksCovered;
    @JsonProperty("blocksNotCovered")
    private Integer blocksNotCovered;
    @JsonProperty("branchesCovered")
    private Integer branchesCovered;
    @JsonProperty("branchesNotCovered")
    private Integer branchesNotCovered;
    @JsonProperty("linesCovered")
    private Integer linesCovered;
    @JsonProperty("linesNotCovered")
    private Integer linesNotCovered;
    @JsonProperty("linesPartiallyCovered")
    private Integer linesPartiallyCovered;

    public Integer getBlocksCovered() {
        return blocksCovered;
    }

    public void setBlocksCovered(Integer blocksCovered) {
        this.blocksCovered = blocksCovered;
    }

    public Integer getBlocksNotCovered() {
        return blocksNotCovered;
    }

    public void setBlocksNotCovered(Integer blocksNotCovered) {
        this.blocksNotCovered = blocksNotCovered;
    }

    public Integer getBranchesCovered() {
        return branchesCovered;
    }

    public void setBranchesCovered(Integer branchesCovered) {
        this.branchesCovered = branchesCovered;
    }

    public Integer getBranchesNotCovered() {
        return branchesNotCovered;
    }

    public void setBranchesNotCovered(Integer branchesNotCovered) {
        this.branchesNotCovered = branchesNotCovered;
    }

    public Integer getLinesCovered() {
        return linesCovered;
    }

    public void setLinesCovered(Integer linesCovered) {
        this.linesCovered = linesCovered;
    }

    public Integer getLinesNotCovered() {
        return linesNotCovered;
    }

    public void setLinesNotCovered(Integer linesNotCovered) {
        this.linesNotCovered = linesNotCovered;
    }

    public Integer getLinesPartiallyCovered() {
        return linesPartiallyCovered;
    }

    public void setLinesPartiallyCovered(Integer linesPartiallyCovered) {
        this.linesPartiallyCovered = linesPartiallyCovered;
    }
}
