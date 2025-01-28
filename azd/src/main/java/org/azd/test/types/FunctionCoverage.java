package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FunctionCoverage extends SerializableEntity {
    @JsonProperty("class")
    private String className;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nameSpace")
    private String nameSpace;
    @JsonProperty("sourceFile")
    private String sourceFile;
    @JsonProperty("statistics")
    private CoverageStatistics statistics;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public CoverageStatistics getStatistics() {
        return statistics;
    }

    public void setStatistics(CoverageStatistics statistics) {
        this.statistics = statistics;
    }
}
