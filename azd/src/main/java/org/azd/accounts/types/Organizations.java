package org.azd.accounts.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * List of data provider
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Organizations {
    /***
     * List of data provider
     */
    @JsonProperty("dataProviders")
    private DataProvider dataProviders;

    public DataProvider getDataProviders() {
        return dataProviders;
    }

    public void setDataProviders(DataProvider dataProviders) {
        this.dataProviders = dataProviders;
    }

    @Override
    public String toString() {
        return "Organizations{" +
                "dataProviders=" + dataProviders +
                '}';
    }
}
