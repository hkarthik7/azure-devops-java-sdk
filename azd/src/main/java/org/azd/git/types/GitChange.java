package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitChange {
    @JsonProperty("changeId")
    private int changeId;
    @JsonProperty("changeType")
    private String changeType;
    @JsonProperty("item")
    private String item;
    @JsonProperty("newContent")
    private ItemContent newContent;
    @JsonProperty("newContentTemplate")
    private GitTemplate newContentTemplate;
    @JsonProperty("originalPath")
    private String originalPath;
    @JsonProperty("sourceServerItem")
    private String sourceServerItem;
    @JsonProperty("url")
    private String url;

    public int getChangeId() {
        return changeId;
    }

    public void setChangeId(int changeId) {
        this.changeId = changeId;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public ItemContent getNewContent() {
        return newContent;
    }

    public void setNewContent(ItemContent newContent) {
        this.newContent = newContent;
    }

    public GitTemplate getNewContentTemplate() {
        return newContentTemplate;
    }

    public void setNewContentTemplate(GitTemplate newContentTemplate) {
        this.newContentTemplate = newContentTemplate;
    }

    public String getOriginalPath() {
        return originalPath;
    }

    public void setOriginalPath(String originalPath) {
        this.originalPath = originalPath;
    }

    public String getSourceServerItem() {
        return sourceServerItem;
    }

    public void setSourceServerItem(String sourceServerItem) {
        this.sourceServerItem = sourceServerItem;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "GitChange{" +
                "changeId=" + changeId +
                ", changeType='" + changeType + '\'' +
                ", item='" + item + '\'' +
                ", newContent=" + newContent +
                ", newContentTemplate=" + newContentTemplate +
                ", originalPath='" + originalPath + '\'' +
                ", sourceServerItem='" + sourceServerItem + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
