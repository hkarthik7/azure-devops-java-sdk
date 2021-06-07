package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.unboundid.scim2.common.messages.PatchOperation;
import com.unboundid.scim2.common.utils.JsonDiff;
import org.azd.core.CoreVersion;
import org.azd.exceptions.AzDException;
import org.azd.utils.AzDDefaultParameters;
import org.azd.utils.Request;
import org.azd.utils.RequestMethod;
import org.azd.utils.ResourceId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Workitem<T extends WorkitemFields> {

    private final ObjectMapper MAPPER = new ObjectMapper();

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("rev")
    private Integer rev;
    @JsonProperty("url")
    private String url;
    @JsonProperty("fields")
    private T fields;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRev() {
        return rev;
    }

    public void setRev(Integer rev) {
        this.rev = rev;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getFields() {
        return fields;
    }

    public void setFields(T fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "WorkItem{" +
                "id='" + id + '\'' +
                ", rev='" + rev + '\'' +
                ", fields='" + fields + '\'' +
                ", url='" + url + '\'' +
                '}';
    }


    /***
     * Get all Revisions as deltas for workItems in the project with id = workItemId (that the authenticated user has access to).
     * @return array of projects {@link Projects}
     */
    public List<PatchOperation> getWorkitemDeltas(String projectId, AzDDefaultParameters defaultParameters) {
        try {
            String r = Request.request(RequestMethod.GET, defaultParameters, ResourceId.CORE, projectId,
                    "wit/workitems", ""+id, "revisions", CoreVersion.PROJECT_WORK_ITEM_REVISIONS, null, null);

            JsonNode workingItemRevisions = MAPPER.readTree(r);
            List<PatchOperation> result = new ArrayList<>();
            if(workingItemRevisions.hasNonNull("count") && workingItemRevisions.get("count").asInt()>0) {
                int amountRevs = workingItemRevisions.get("count").asInt();
                for(int prevRev = 0;prevRev<amountRevs;prevRev++) {
                    int nextRev = prevRev + 1;

                    JsonNode finalRevData = workingItemRevisions.get("value").get(nextRev - 1);
                    JsonNode prevRevData = prevRev > 0 ? workingItemRevisions.get("value").get(prevRev - 1) : MAPPER.readTree("{}");
                    JsonDiff diff = new JsonDiff();
                    result.addAll(diff.diff((ObjectNode) prevRevData, (ObjectNode) finalRevData, true));
                }
            }
            return result;

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Get all Revisions as deltas for workItems in the project with id = workItemId (that the authenticated user has access to).
     * @return array of projects {@link Projects}
     */
    public WorkitemSummaries getWorkitemRevisions(String projectId, AzDDefaultParameters defaultParameters) {
        try {
            String r = Request.request(RequestMethod.GET, defaultParameters, ResourceId.CORE, projectId,
                    "wit/workitems", ""+id, "revisions", CoreVersion.PROJECT_WORK_ITEM_REVISIONS, null, null);

            return MAPPER.readValue(r, WorkitemSummaries.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }
}
