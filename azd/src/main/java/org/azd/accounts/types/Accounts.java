package org.azd.accounts.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * List of account
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Accounts {
    /***
     * List of account
     */
    @JsonProperty("value")
    private List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "accounts=" + accounts +
                '}';
    }
}
