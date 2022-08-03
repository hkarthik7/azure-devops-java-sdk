package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Build repository properties
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Properties extends BaseAbstractMethod {
    /***
     * Repository clone url
     */
    @JsonProperty("cloneUrl")
    private String cloneUrl;
    /***
     * Repository full name
     */
    @JsonProperty("fullName")
    private String fullName;
    /***
     * Default branch in the repository
     */
    @JsonProperty("defaultBranch")
    private String defaultBranch;
    /***
     * If the repository is a fork or not
     */
    @JsonProperty("isFork")
    private boolean isFork;
    /***
     * Safe repository
     */
    @JsonProperty("safeRepository")
    private String safeRepository;
    /***
     * Build status report
     */
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

}
