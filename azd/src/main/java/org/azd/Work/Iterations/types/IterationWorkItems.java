package org.azd.Work.Iterations.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IterationWorkItems {
    @JsonProperty("workItemRelations")
    private List<WorkItemLink> workItemRelations;
    @JsonProperty("url")
    private String url;
    @JsonProperty("_links")
    private JsonNode _links;

    public List<WorkItemLink> getWorkItemRelations() {
        return workItemRelations;
    }

    public void setWorkItemRelations(List<WorkItemLink> workItemRelations) {
        this.workItemRelations = workItemRelations;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public JsonNode get_links() {
        return _links;
    }

    public void set_links(JsonNode _links) {
        this._links = _links;
    }

    @Override
    public String toString() {
        return "IterationWorkItems{" +
                "workItemRelations=" + workItemRelations +
                ", url='" + url + '\'' +
                ", _links=" + _links +
                '}';
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class WorkItemLink {
        @JsonProperty("rel")
        private String rel;
        @JsonProperty("source")
        private WorkItemReference source;
        @JsonProperty("target")
        private WorkItemReference target;

        @Override
        public String toString() {
            return "WorkItemLink{" +
                    "rel='" + rel + '\'' +
                    ", source=" + source +
                    ", target=" + target +
                    '}';
        }

        public String getRel() {
            return rel;
        }

        public void setRel(String rel) {
            this.rel = rel;
        }

        public WorkItemReference getSource() {
            return source;
        }

        public void setSource(WorkItemReference source) {
            this.source = source;
        }

        public WorkItemReference getTarget() {
            return target;
        }

        public void setTarget(WorkItemReference target) {
            this.target = target;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class WorkItemReference {
        @JsonProperty("id")
        private String id;
        @JsonProperty("url")
        private String url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "WorkItemReference{" +
                    "id='" + id + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }
}
