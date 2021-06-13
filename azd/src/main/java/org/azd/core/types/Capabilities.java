package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Capabilities {
    @JsonProperty("processTemplate")
    private ProcessTemplate processTemplate;
    @JsonProperty("versioncontrol")
    private VersionControl versioncontrol;

    public ProcessTemplate getProcessTemplate() {
        return processTemplate;
    }

    public void setProcessTemplate(ProcessTemplate processTemplate) {
        this.processTemplate = processTemplate;
    }

    public VersionControl getVersionControl() {
        return versioncontrol;
    }

    public void setVersionControl(VersionControl versioncontrol) {
        this.versioncontrol = versioncontrol;
    }

    @Override
    public String toString() {
        return "Capabilities{" +
                "processTemplate=" + processTemplate +
                ", versioncontrol=" + versioncontrol +
                '}';
    }
}
