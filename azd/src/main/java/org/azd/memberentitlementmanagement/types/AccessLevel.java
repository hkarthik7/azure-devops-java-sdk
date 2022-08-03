package org.azd.memberentitlementmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * License assigned to a user
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessLevel extends BaseAbstractMethod {
    /***
     * Type of Account License (e.g. Express, Stakeholder etc.)
     */
    @JsonProperty("accountLicenseType")
    private String accountLicenseType;
    /***
     * Assignment Source of the License (e.g. Group, Unknown etc.
     */
    @JsonProperty("assignmentSource")
    private String assignmentSource;
    /***
     * Display name of the License
     */
    @JsonProperty("licenseDisplayName")
    private String licenseDisplayName;
    /***
     * Licensing Source (e.g. Account. MSDN etc.)
     */
    @JsonProperty("licensingSource")
    private String licensingSource;
    /***
     * Type of MSDN License (e.g. Visual Studio Professional, Visual Studio Enterprise etc.)
     */
    @JsonProperty("msdnLicenseType")
    private String msdnLicenseType;
    /***
     * User status in the account
     */
    @JsonProperty("status")
    private String status;
    /***
     * Status message.
     */
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

}
