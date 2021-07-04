package org.azd.memberentitlementmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LicenseSummaryData {
    @JsonProperty("accountLicenseType")
    private String accountLicenseType;
    @JsonProperty("assigned")
    private int assigned;
    @JsonProperty("available")
    private int available;
    @JsonProperty("disabled")
    private int disabled;
    @JsonProperty("includedQuantity")
    private int includedQuantity;
    @JsonProperty("isPurchasable")
    private boolean isPurchasable;
    @JsonProperty("licenseName")
    private String licenseName;
    @JsonProperty("msdnLicenseType")
    private String msdnLicenseType;
    @JsonProperty("nextBillingDate")
    private String nextBillingDate;
    @JsonProperty("source")
    private String source;
    @JsonProperty("total")
    private int total;
    @JsonProperty("totalAfterNextBillingDate")
    private int totalAfterNextBillingDate;

    public String getAccountLicenseType() {
        return accountLicenseType;
    }

    public void setAccountLicenseType(String accountLicenseType) {
        this.accountLicenseType = accountLicenseType;
    }

    public int getAssigned() {
        return assigned;
    }

    public void setAssigned(int assigned) {
        this.assigned = assigned;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getDisabled() {
        return disabled;
    }

    public void setDisabled(int disabled) {
        this.disabled = disabled;
    }

    public int getIncludedQuantity() {
        return includedQuantity;
    }

    public void setIncludedQuantity(int includedQuantity) {
        this.includedQuantity = includedQuantity;
    }

    public boolean isPurchasable() {
        return isPurchasable;
    }

    public void setPurchasable(boolean purchasable) {
        isPurchasable = purchasable;
    }

    public String getLicenseName() {
        return licenseName;
    }

    public void setLicenseName(String licenseName) {
        this.licenseName = licenseName;
    }

    public String getMsdnLicenseType() {
        return msdnLicenseType;
    }

    public void setMsdnLicenseType(String msdnLicenseType) {
        this.msdnLicenseType = msdnLicenseType;
    }

    public String getNextBillingDate() {
        return nextBillingDate;
    }

    public void setNextBillingDate(String nextBillingDate) {
        this.nextBillingDate = nextBillingDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalAfterNextBillingDate() {
        return totalAfterNextBillingDate;
    }

    public void setTotalAfterNextBillingDate(int totalAfterNextBillingDate) {
        this.totalAfterNextBillingDate = totalAfterNextBillingDate;
    }

    @Override
    public String toString() {
        return "LicenseSummaryData{" +
                "accountLicenseType='" + accountLicenseType + '\'' +
                ", assigned=" + assigned +
                ", available=" + available +
                ", disabled=" + disabled +
                ", includedQuantity=" + includedQuantity +
                ", isPurchasable=" + isPurchasable +
                ", licenseName='" + licenseName + '\'' +
                ", msdnLicenseType='" + msdnLicenseType + '\'' +
                ", nextBillingDate='" + nextBillingDate + '\'' +
                ", source='" + source + '\'' +
                ", total=" + total +
                ", totalAfterNextBillingDate=" + totalAfterNextBillingDate +
                '}';
    }
}
