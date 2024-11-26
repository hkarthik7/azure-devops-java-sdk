package org.azd.locations.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthenticatedUser extends SerializableEntity {
    @JsonProperty("id")
    private String id;
    @JsonProperty("descriptor")
    private String descriptor;
    @JsonProperty("subjectDescriptor")
    private String subjectDescriptor;
    @JsonProperty("socialDescriptor")
    private String socialDescriptor;
    @JsonProperty("providerDisplayName")
    private String providerDisplayName;
    @JsonProperty("isActive")
    private boolean isActive;
    @JsonProperty("properties")
    private Object properties;
    @JsonProperty("resourceVersion")
    private int resourceVersion;
    @JsonProperty("metaTypeId")
    private int metaTypeId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public String getSubjectDescriptor() {
        return subjectDescriptor;
    }

    public void setSubjectDescriptor(String subjectDescriptor) {
        this.subjectDescriptor = subjectDescriptor;
    }

    public String getSocialDescriptor() {
        return socialDescriptor;
    }

    public void setSocialDescriptor(String socialDescriptor) {
        this.socialDescriptor = socialDescriptor;
    }

    public String getProviderDisplayName() {
        return providerDisplayName;
    }

    public void setProviderDisplayName(String providerDisplayName) {
        this.providerDisplayName = providerDisplayName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Object getProperties() {
        return properties;
    }

    public void setProperties(Object properties) {
        this.properties = properties;
    }

    public int getResourceVersion() {
        return resourceVersion;
    }

    public void setResourceVersion(int resourceVersion) {
        this.resourceVersion = resourceVersion;
    }

    public int getMetaTypeId() {
        return metaTypeId;
    }

    public void setMetaTypeId(int metaTypeId) {
        this.metaTypeId = metaTypeId;
    }
}
