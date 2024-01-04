package org.azd.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/***
 * Represents a common hyper reference link
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reference extends SerializableEntity {
    /***
     * Represents a common hyper reference link
     */
    @JsonProperty("href")
    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
