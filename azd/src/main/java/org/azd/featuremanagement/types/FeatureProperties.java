package org.azd.featuremanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FeatureProperties extends SerializableEntity {
    @JsonProperty("defaultRoute")
    private String defaultRoute;
    @JsonProperty("acquisitionRoute")
    private String acquisitionRoute;

    public String getDefaultRoute() {
        return defaultRoute;
    }

    public void setDefaultRoute(String defaultRoute) {
        this.defaultRoute = defaultRoute;
    }

    public String getAcquisitionRoute() {
        return acquisitionRoute;
    }

    public void setAcquisitionRoute(String acquisitionRoute) {
        this.acquisitionRoute = acquisitionRoute;
    }
}
