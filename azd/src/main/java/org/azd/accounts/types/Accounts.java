package org.azd.accounts.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

import java.util.List;

/***
 * List of account
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Accounts extends SerializableEntity {
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

}
