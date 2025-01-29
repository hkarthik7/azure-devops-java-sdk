package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * Module coverage
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModuleCoverage extends SerializableEntity {
    @JsonProperty("blockCount")
    private Integer blockCount;
    @JsonProperty("blockData")
    private String[] blockData;
    /**
     * Code Coverage File Url
     */
    @JsonProperty("fileUrl")
    private String fileUrl;
    @JsonProperty("functions")
    private List<FunctionCoverage> functions;
    @JsonProperty("name")
    private String name;
    @JsonProperty("signature")
    private String signature;
    @JsonProperty("signatureAge")
    private Integer signatureAge;
    @JsonProperty("statistics")
    private CoverageStatistics statistics;

    public Integer getBlockCount() {
        return blockCount;
    }

    public void setBlockCount(Integer blockCount) {
        this.blockCount = blockCount;
    }

    public String[] getBlockData() {
        return blockData;
    }

    public void setBlockData(String[] blockData) {
        this.blockData = blockData;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public List<FunctionCoverage> getFunctions() {
        return functions;
    }

    public void setFunctions(List<FunctionCoverage> functions) {
        this.functions = functions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getSignatureAge() {
        return signatureAge;
    }

    public void setSignatureAge(Integer signatureAge) {
        this.signatureAge = signatureAge;
    }

    public CoverageStatistics getStatistics() {
        return statistics;
    }

    public void setStatistics(CoverageStatistics statistics) {
        this.statistics = statistics;
    }
}
