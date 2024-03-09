package org.azd.helpers.workitemtracking;

import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.common.types.JsonPatchDocument;
import org.azd.enums.CustomHeader;
import org.azd.enums.PatchOperation;
import org.azd.enums.RequestMethod;
import org.azd.enums.WorkItemOperation;
import org.azd.exceptions.AzDException;
import org.azd.workitemtracking.WorkItemTrackingRequestBuilder;
import org.azd.workitemtracking.types.WorkItem;

import java.util.HashMap;
import java.util.List;

import static org.azd.helpers.URLHelper.encodeSpace;
import static org.azd.utils.RestClient.send;

/**
 * Helper request builder that combines multiple Apis to create logical helper methods for ease of use.
 */
public class WorkItemTrackingHelpersRequestBuilder extends WorkItemTrackingRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public WorkItemTrackingHelpersRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * Creates a single work item.
     *
     * @param workItemType The work item type of the work item to create. e.g., "user story", "bug", "task"
     * @param title        The title for the work item
     * @return {@link WorkItem}
     * @throws AzDException Default Api Exception handler.
     */
    public WorkItem createWorkItem(String workItemType, String title) throws AzDException {
        var jsonPatchDocument = new JsonPatchDocument();
        jsonPatchDocument.setOperation(PatchOperation.ADD);
        jsonPatchDocument.setPath("/fields/System.Title");
        jsonPatchDocument.setValue(title);

        return workItems().createAsync(workItemType, List.of(jsonPatchDocument)).join();
    }
}
