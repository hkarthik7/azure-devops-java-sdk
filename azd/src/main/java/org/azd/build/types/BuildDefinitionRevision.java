package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildDefinitionRevision {
    @JsonProperty("revision")
    private int revision;
    @JsonProperty("name")
    private String name;
    @JsonProperty("changedDate")
    private String changedDate;
    @JsonProperty("changeType")
    private String changeType;
    @JsonProperty("definitionUrl")
    private String definitionUrl;
    @JsonProperty("changedBy")
    private ChangedBy changedBy;

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(String changedDate) {
        this.changedDate = changedDate;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public String getDefinitionUrl() {
        return definitionUrl;
    }

    public void setDefinitionUrl(String definitionUrl) {
        this.definitionUrl = definitionUrl;
    }

    public ChangedBy getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(ChangedBy changedBy) {
        this.changedBy = changedBy;
    }

    @Override
    public String toString() {
        return "BuildDefinitionRevision{" +
                "revision=" + revision +
                ", name='" + name + '\'' +
                ", changedDate='" + changedDate + '\'' +
                ", changeType='" + changeType + '\'' +
                ", definitionUrl='" + definitionUrl + '\'' +
                ", changedBy=" + changedBy +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class ChangedBy {
        @JsonProperty("displayName")
        private String displayName;
        @JsonProperty("url")
        private String url;
        @JsonProperty("id")
        private String id;
        @JsonProperty("uniqueName")
        private String uniqueName;
        @JsonProperty("imageUrl")
        private String imageUrl;
        @JsonProperty("descriptor")
        private String descriptor;

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUniqueName() {
            return uniqueName;
        }

        public void setUniqueName(String uniqueName) {
            this.uniqueName = uniqueName;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getDescriptor() {
            return descriptor;
        }

        public void setDescriptor(String descriptor) {
            this.descriptor = descriptor;
        }

        @Override
        public String toString() {
            return "ChangedBy{" +
                    "displayName='" + displayName + '\'' +
                    ", url='" + url + '\'' +
                    ", id='" + id + '\'' +
                    ", uniqueName='" + uniqueName + '\'' +
                    ", imageUrl='" + imageUrl + '\'' +
                    ", descriptor='" + descriptor + '\'' +
                    '}';
        }
    }
}
