package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Properties {
    @JsonProperty("cloneUrl")
    private String cloneUrl;
    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("defaultBranch")
    private String defaultBranch;
    @JsonProperty("isFork")
    private boolean isFork;
    @JsonProperty("safeRepository")
    private String safeRepository;
    @JsonProperty("reportBuildStatus")
    private boolean reportBuildStatus;

    public String getCloneUrl() {
        return cloneUrl;
    }

    public void setCloneUrl(String cloneUrl) {
        this.cloneUrl = cloneUrl;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

    public boolean isFork() {
        return isFork;
    }

    public void setFork(boolean fork) {
        isFork = fork;
    }

    public String getSafeRepository() {
        return safeRepository;
    }

    public void setSafeRepository(String safeRepository) {
        this.safeRepository = safeRepository;
    }

    public boolean isReportBuildStatus() {
        return reportBuildStatus;
    }

    public void setReportBuildStatus(boolean reportBuildStatus) {
        this.reportBuildStatus = reportBuildStatus;
    }

    @Override
    public String toString() {
        return "Properties{" +
                "cloneUrl='" + cloneUrl + '\'' +
                ", fullName='" + fullName + '\'' +
                ", defaultBranch='" + defaultBranch + '\'' +
                ", isFork=" + isFork +
                ", safeRepository='" + safeRepository + '\'' +
                ", reportBuildStatus=" + reportBuildStatus +
                '}';
    }
}
