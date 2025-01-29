package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TestRunCoverage extends SerializableEntity {
    /**
     * Last Error
     */
    @JsonProperty("lastError")
    private String lastError;
    /**
     * List of modules
     */
    @JsonProperty("modules")
    private List<ModuleCoverage> modules;
    /**
     * State
     */
    @JsonProperty("state")
    private String state;
    /**
     * Reference of test Run.
     */
    @JsonProperty("testRun")
    private ShallowReference testRun;

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

    public ShallowReference getTestRun() {
        return testRun;
    }

    public void setTestRun(ShallowReference testRun) {
        this.testRun = testRun;
    }
}
