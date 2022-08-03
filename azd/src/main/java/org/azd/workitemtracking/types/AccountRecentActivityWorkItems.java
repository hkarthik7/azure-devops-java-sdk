package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountRecentActivityWorkItems extends BaseAbstractMethod {
    @JsonProperty("value")
    private List<AccountRecentActivityWorkItemModel2> accountRecentActivityWorkItems;


    public List<AccountRecentActivityWorkItemModel2> getAccountRecentActivityWorkItems() {
        return accountRecentActivityWorkItems;
    }

    public void setAccountRecentActivityWorkItems(List<AccountRecentActivityWorkItemModel2> accountRecentActivityWorkItems) {
        this.accountRecentActivityWorkItems = accountRecentActivityWorkItems;
    }
}
