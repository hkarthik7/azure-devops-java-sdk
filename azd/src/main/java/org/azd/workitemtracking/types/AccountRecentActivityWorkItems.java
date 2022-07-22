package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountRecentActivityWorkItems {
    @JsonProperty("value")
    private List<AccountRecentActivityWorkItemModel2> accountRecentActivityWorkItems;

    @Override
    public String toString() {
        return "AccountRecentActivityWorkItems{" +
                "accountRecentActivityWorkItems=" + accountRecentActivityWorkItems +
                '}';
    }

    public List<AccountRecentActivityWorkItemModel2> getAccountRecentActivityWorkItems() {
        return accountRecentActivityWorkItems;
    }

    public void setAccountRecentActivityWorkItems(List<AccountRecentActivityWorkItemModel2> accountRecentActivityWorkItems) {
        this.accountRecentActivityWorkItems = accountRecentActivityWorkItems;
    }
}
