package org.azd.memberentitlementmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessLevel {
    @JsonProperty("accountLicenseType")
    private String accountLicenseType;
    @JsonProperty("assignmentSource")
    private String assignmentSource;
    @JsonProperty("licenseDisplayName")
    private String licenseDisplayName;
    @JsonProperty("licensingSource")
    private String licensingSource;
    @JsonProperty("msdnLicenseType")
    private String msdnLicenseType;
    @JsonProperty("status")
    private String status;
    @JsonProperty("statusMessage")
    private String statusMessage;

    public String getAccountLicenseType() {
        return accountLicenseType;
    }

    public void setAccountLicenseType(String accountLicenseType) {
        this.accountLicenseType = accountLicenseType;
    }

    public String getAssignmentSource() {
        return assignmentSource;
    }

    public void setAssignmentSource(String assignmentSource) {
        this.assignmentSource = assignmentSource;
    }

    public String getLicenseDisplayName() {
        return licenseDisplayName;
    }

    public void setLicenseDisplayName(String licenseDisplayName) {
        this.licenseDisplayName = licenseDisplayName;
    }

    public String getLicensingSource() {
        return licensingSource;
    }

    public void setLicensingSource(String licensingSource) {
        this.licensingSource = licensingSource;
    }

    public String getMsdnLicenseType() {
        return msdnLicenseType;
    }

    public void setMsdnLicenseType(String msdnLicenseType) {
        this.msdnLicenseType = msdnLicenseType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    @Override
    public String toString() {
        return "AccessLevel{" +
                "accountLicenseType='" + accountLicenseType + '\'' +
                ", assignmentSource='" + assignmentSource + '\'' +
                ", licenseDisplayName='" + licenseDisplayName + '\'' +
                ", licensingSource='" + licensingSource + '\'' +
                ", msdnLicenseType='" + msdnLicenseType + '\'' +
                ", status='" + status + '\'' +
                ", statusMessage='" + statusMessage + '\'' +
                '}';
    }
}
