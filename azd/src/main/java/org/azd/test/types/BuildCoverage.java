package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * Build Coverage Detail
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildCoverage extends SerializableEntity {
    /**
     * Code Coverage File Url
     */
    @JsonProperty("codeCoverageFileUrl")
    private String codeCoverageFileUrl;
    /**
     * Build Configuration
     */
    @JsonProperty("configuration")
    private BuildConfiguration configuration;
    /**
     * Last Error
     */
    @JsonProperty("lastError")
    private String lastError;
    /**
     * List of Modules
     */
    @JsonProperty("modules")
    private List<ModuleCoverage> modules;
    /**
     * State
     */
    @JsonProperty("state")
    private String state;

    public String getCodeCoverageFileUrl() {
        return codeCoverageFileUrl;
    }

    public void setCodeCoverageFileUrl(String codeCoverageFileUrl) {
        this.codeCoverageFileUrl = codeCoverageFileUrl;
    }

    public BuildConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(BuildConfiguration configuration) {
        this.configuration = configuration;
    }

    public String getLastError() {
        return lastError;
    }

    public void setLastError(String lastError) {
        this.lastError = lastError;
    }

    public List<ModuleCoverage> getModules() {
        return modules;
    }

    public void setModules(List<ModuleCoverage> modules) {
        this.modules = modules;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
