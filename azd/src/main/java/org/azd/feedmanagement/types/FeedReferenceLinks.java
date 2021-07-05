package org.azd.feedmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Reference;
import org.azd.common.types.ReferenceLink;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedReferenceLinks extends ReferenceLink {
    @JsonProperty("packages")
    private Reference packages;
    @JsonProperty("permissions")
    private Reference permissions;
    @JsonProperty("feed")
    private Reference feed;

    public Reference getPackages() {
        return packages;
    }

    public void setPackages(Reference packages) {
        this.packages = packages;
    }

    public Reference getPermissions() {
        return permissions;
    }

    public void setPermissions(Reference permissions) {
        this.permissions = permissions;
    }

    public Reference getFeed() {
        return feed;
    }

    public void setFeed(Reference feed) {
        this.feed = feed;
    }

    @Override
    public String toString() {
        return "FeedReferenceLinks{" +
                "packages=" + packages +
                ", permissions=" + permissions +
                '}';
    }
}
