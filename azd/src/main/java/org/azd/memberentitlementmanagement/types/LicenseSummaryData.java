package org.azd.memberentitlementmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Summary of Licenses in the organization.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LicenseSummaryData extends BaseAbstractMethod {
    /***
     * Type of Account License.
     */
    @JsonProperty("accountLicenseType")
    private String accountLicenseType;
    /***
     * Count of Licenses already assigned.
     */
    @JsonProperty("assigned")
    private int assigned;
    /***
     * Available Count.
     */
    @JsonProperty("available")
    private int available;
    /***
     * Count of Disabled Licenses.
     */
    @JsonProperty("disabled")
    private int disabled;
    /***
     * Quantity
     */
    @JsonProperty("includedQuantity")
    private int includedQuantity;
    /***
     * Designates if this license quantity can be changed through purchase
     */
    @JsonProperty("isPurchasable")
    private boolean isPurchasable;
    /***
     * Name of the License.
     */
    @JsonProperty("licenseName")
    private String licenseName;
    /***
     * Type of MSDN License.
     */
    @JsonProperty("msdnLicenseType")
    private String msdnLicenseType;
    /***
     * Specifies the date when billing will charge for paid licenses
     */
    @JsonProperty("nextBillingDate")
    private String nextBillingDate;
    /***
     * Source of the License.
     */
    @JsonProperty("source")
    private String source;
    /***
     * Total Count.
     */
    @JsonProperty("total")
    private int total;
    /***
     * Total license count after next billing cycle
     */
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

}
