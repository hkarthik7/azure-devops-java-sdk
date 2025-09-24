package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.VersionControlChangeType;

public class GitPullRequestChange extends SerializableEntity {
    @JsonProperty("changeId")
    public int changeId;

    @JsonProperty("changeTrackingId")
    public int changeTrackingId;

    @JsonProperty("changeType")
    public VersionControlChangeType changeType;

    @JsonProperty("item")
    public String item;

    @JsonProperty("newContent")
    public ItemContent newContent;

    @JsonProperty("newContentTemplate")
    public GitTemplate newContentTemplate;

    @JsonProperty("originalPath")
    public String originalPath;

    @JsonProperty("sourceServerItem")
    public String sourceServerItem;

    @JsonProperty("url")
    public String url;
}
