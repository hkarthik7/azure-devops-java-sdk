package org.azd.locations.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Properties extends SerializableEntity {
    @JsonProperty("account")
    private Properties account;

    public Properties getAccount() {
        return account;
    }

    public void setAccount(Properties account) {
        this.account = account;
    }
}
