package org.azd.WorkitemTracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItem {
    @JsonProperty("id")
    private int id;
    @JsonProperty("rev")
    private int rev;
    @JsonProperty("fields")
    private JsonNode fields;
    @JsonProperty("relations")
    private List<Relations> relations;
    @JsonProperty("_links")
    private JsonNode _links;
    @JsonProperty("url")
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRev() {
        return rev;
    }

    public void setRev(int rev) {
        this.rev = rev;
    }

    public JsonNode getFields() {
        return fields;
    }

    public void setFields(JsonNode fields) {
        this.fields = fields;
    }

    public JsonNode get_links() {
        return _links;
    }

    public void set_links(JsonNode _links) {
        this._links = _links;
    }

    public List<Relations> getRelations() {
        return relations;
    }

    public void setRelations(List<Relations> relations) {
        this.relations = relations;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "WorkItem{" +
                "id=" + id +
                ", rev=" + rev +
                ", fields=" + fields +
                ", _links=" + _links +
                ", relations=" + relations +
                ", url='" + url + '\'' +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Relations {
        @JsonProperty("rel")
        private String rel;
        @JsonProperty("url")
        private String url;
        @JsonProperty("attributes")
        private JsonNode attributes;

        public String getRel() {
            return rel;
        }

        public void setRel(String rel) {
            this.rel = rel;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public JsonNode getAttributes() {
            return attributes;
        }

        public void setAttributes(JsonNode attributes) {
            this.attributes = attributes;
        }

        @Override
        public String toString() {
            return "Relations{" +
                    "rel='" + rel + '\'' +
                    ", url='" + url + '\'' +
                    ", attributes=" + attributes +
                    '}';
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class ReferenceLinks {
        @JsonProperty("self")
        private References self;
        @JsonProperty("workItemUpdates")
        private References workItemUpdates;
        @JsonProperty("workItemRevisions")
        private References workItemRevisions;
        @JsonProperty("workItemComments")
        private References workItemComments;
        @JsonProperty("html")
        private References html;
        @JsonProperty("workItemType")
        private References workItemType;
        @JsonProperty("fields")
        private References fields;

        public References getSelf() {
            return self;
        }

        public void setSelf(References self) {
            this.self = self;
        }

        public References getWorkItemUpdates() {
            return workItemUpdates;
        }

        public void setWorkItemUpdates(References workItemUpdates) {
            this.workItemUpdates = workItemUpdates;
        }

        public References getWorkItemRevisions() {
            return workItemRevisions;
        }

        public void setWorkItemRevisions(References workItemRevisions) {
            this.workItemRevisions = workItemRevisions;
        }

        public References getWorkItemComments() {
            return workItemComments;
        }

        public void setWorkItemComments(References workItemComments) {
            this.workItemComments = workItemComments;
        }

        public References getHtml() {
            return html;
        }

        public void setHtml(References html) {
            this.html = html;
        }

        public References getWorkItemType() {
            return workItemType;
        }

        public void setWorkItemType(References workItemType) {
            this.workItemType = workItemType;
        }

        public References getFields() {
            return fields;
        }

        public void setFields(References fields) {
            this.fields = fields;
        }

        @Override
        public String toString() {
            return "ReferenceLinks{" +
                    "self=" + self +
                    ", workItemUpdates=" + workItemUpdates +
                    ", workItemRevisions=" + workItemRevisions +
                    ", workItemComments=" + workItemComments +
                    ", html=" + html +
                    ", workItemType=" + workItemType +
                    ", fields=" + fields +
                    '}';
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class References {
        @JsonProperty("href")
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        @Override
        public String toString() {
            return "References{" +
                    "href='" + href + '\'' +
                    '}';
        }
    }
}
