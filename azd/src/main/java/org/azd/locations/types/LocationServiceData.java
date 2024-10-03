package org.azd.locations.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationServiceData extends SerializableEntity {
    @JsonProperty("serviceOwner")
    private String serviceOwner;
    @JsonProperty("defaultAccessMappingMoniker")
    private String defaultAccessMappingMoniker;
    @JsonProperty("lastChangeId")
    private int lastChangeId;
    @JsonProperty("lastChangeId64")
    private int lastChangeId64;

    public String getServiceOwner() {
        return serviceOwner;
    }

    public void setServiceOwner(String serviceOwner) {
        this.serviceOwner = serviceOwner;
    }

    public String getDefaultAccessMappingMoniker() {
        return defaultAccessMappingMoniker;
    }

    public void setDefaultAccessMappingMoniker(String defaultAccessMappingMoniker) {
        this.defaultAccessMappingMoniker = defaultAccessMappingMoniker;
    }

    public int getLastChangeId() {
        return lastChangeId;
    }

    public void setLastChangeId(int lastChangeId) {
        this.lastChangeId = lastChangeId;
    }

    public int getLastChangeId64() {
        return lastChangeId64;
    }

    public void setLastChangeId64(int lastChangeId64) {
        this.lastChangeId64 = lastChangeId64;
    }
}
