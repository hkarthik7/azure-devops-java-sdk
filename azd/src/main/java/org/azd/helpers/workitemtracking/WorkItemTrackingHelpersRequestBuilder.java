package org.azd.helpers.workitemtracking;

import org.azd.authentication.AccessTokenCredential;
import org.azd.common.types.JsonPatchDocument;
import org.azd.enums.ApiExceptionTypes;
import org.azd.enums.PatchOperation;
import org.azd.enums.WorkItemExpand;
import org.azd.exceptions.AzDException;
import org.azd.helpers.Utils;
import org.azd.workitemtracking.WorkItemTrackingRequestBuilder;
import org.azd.workitemtracking.types.WorkItem;
import org.azd.workitemtracking.types.WorkItemRelations;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.azd.helpers.Utils.isNullOrEmpty;

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

        return workItems().create(workItemType, List.of(jsonPatchDocument));
    }

    /**
     * Creates a single work item.
     *
     * @param workItemType The work item type of the work item to create. e.g., "user story", "bug", "task"
     * @param title        The title for the work item
     * @param description  Description for the work item
     * @param tags         Tags for the work item
     * @return {@link WorkItem}
     * @throws AzDException Default Api Exception handler.
     */
    public WorkItem createWorkItem(String workItemType, String title,
                                   String description, String[] tags) throws AzDException {

        var titleDocument = new JsonPatchDocument();
        titleDocument.setOperation(PatchOperation.ADD);
        titleDocument.setPath("/fields/System.Title");
        titleDocument.setValue(title);

        var descriptionDocument = new JsonPatchDocument();
        descriptionDocument.setOperation(PatchOperation.ADD);
        descriptionDocument.setPath("/fields/System.Description");
        descriptionDocument.setValue(description);

        var tagsDocument = new JsonPatchDocument();
        tagsDocument.setOperation(PatchOperation.ADD);
        tagsDocument.setPath("/fields/System.Tags");
        tagsDocument.setValue(Utils.toString(tags));

        var req = new ArrayList<JsonPatchDocument>();
        req.add(titleDocument);
        req.add(descriptionDocument);
        req.add(tagsDocument);

        return workItems().create(workItemType, req);
    }


    /**
     * Create hyperlinks for the given work item.
     *
     * @param workItemId    The work item's ID.
     * @param hyperlinksMap A {@link Map} that each entry represents a hyperlink. The key is the hyperlink URL and
     *                      the value is its comment. If a comment is not desired then the value can either be null (if its supported by the map) or an empty string.
     * @return The updated {@link WorkItem}.
     * @throws AzDException Handles errors from REST API and validates passed arguments.
     */
    public WorkItem addHyperLinks(int workItemId, Map<String, String> hyperlinksMap) throws AzDException {

        List<JsonPatchDocument> reqBody = new ArrayList<>();

        for (Map.Entry<String, String> hyperlinkEntry : hyperlinksMap.entrySet()) {
            String url = hyperlinkEntry.getKey();
            String comment = hyperlinkEntry.getValue();

            Map<String, Object> attributesMap = new HashMap<>();
            if (!isNullOrEmpty(comment)) attributesMap.put("comment", comment);

            Map<String, Object> hyperlinkMap = new HashMap<>();
            hyperlinkMap.put("rel", "Hyperlink");
            hyperlinkMap.put("url", url);
            if (!attributesMap.isEmpty()) hyperlinkMap.put("attributes", attributesMap);

            var jsonDocument = new JsonPatchDocument();
            jsonDocument.setOperation(PatchOperation.ADD);
            jsonDocument.setPath("/relations/-");
            jsonDocument.setValue(hyperlinkMap);

            reqBody.add(jsonDocument);
        }

        return workItems().update(workItemId, reqBody);
    }

    /**
     * Remove hyperlinks for the given work item.
     * <p>
     * <b>Note:</b> All hyperlinks must exist in order to be removed. Even if one doesn't then an {@link AzDException} is thrown.
     * </p>
     *
     * @param workItemId The work item's ID.
     * @param urls       A {@link List} with the URL of the hyperlinks.
     * @return The updated {@link WorkItem}.
     * @throws AzDException Handles errors from REST API and validates passed arguments.
     */
    public WorkItem removeHyperLinks(int workItemId, List<String> urls) throws AzDException {

        List<JsonPatchDocument> reqBody = new ArrayList<>();

        List<WorkItemRelations> relations = workItems()
                .get(workItemId, r -> r.queryParameters.expand = WorkItemExpand.RELATIONS)
                .getRelations();

        for (String url : urls) {
            int hyperlinkRelationNumber = -1;
            for (int i = 0; i < relations.size(); i++) {
                WorkItemRelations workItemRelations = relations.get(i);
                if (!workItemRelations.getRel().equals("Hyperlink")) {
                    continue;
                }
                if (workItemRelations.getUrl().equals(url)) {
                    hyperlinkRelationNumber = i;
                    break;
                }
            }

            if (hyperlinkRelationNumber == -1)
                throw new AzDException(MessageFormat.format(
                        "Unable to remove hyperlink ''{0}'' from work item with ID ''{1}'': The hyperlink doesn't exist.",
                        url, hyperlinkRelationNumber));

            var jsonDocument = new JsonPatchDocument();
            jsonDocument.setOperation(PatchOperation.REMOVE);
            jsonDocument.setPath("/relations/" + hyperlinkRelationNumber);

            reqBody.add(jsonDocument);
        }

        return workItems().update(workItemId, reqBody);
    }

    /**
     * Add an attachment to a work item. Pass the url of the attachment and comments as a Map to add the attachment to work item. Note
     * that the attachment should already be created using createAttachment method.
     *
     * @param workItemId     Id of the work item.
     * @param fieldsToUpdate Map of url and comments.
     *                       {@code
     *                       var attachments = new HashMap<String, Object>() {{
     *                       put("https://url/of/attachment", "This is a comment");
     *                       }};
     *                       }
     * @return The work item object. WorkItem {@link WorkItem}
     * @throws AzDException Handles errors from REST API and validates passed arguments.
     */
    public WorkItem addWorkItemAttachment(int workItemId, Map<String, String> fieldsToUpdate) throws AzDException {
        List<JsonPatchDocument> reqBody = new ArrayList<>();

        for (Map.Entry<String, String> entry : fieldsToUpdate.entrySet()) {
            String url = entry.getKey();
            String comment = entry.getValue();

            Map<String, Object> attributesMap = new HashMap<>();
            if (!isNullOrEmpty(comment)) attributesMap.put("comment", comment);

            Map<String, Object> attachment = new HashMap<>();
            attachment.put("rel", "AttachedFile");
            attachment.put("url", url);
            if (!attributesMap.isEmpty()) attachment.put("attributes", attributesMap);

            var jsonDocument = new JsonPatchDocument();
            jsonDocument.setOperation(PatchOperation.ADD);
            jsonDocument.setPath("/relations/-");
            jsonDocument.setValue(attachment);

            reqBody.add(jsonDocument);
        }

        return workItems().update(workItemId, reqBody);
    }

    /**
     * Removes the attachment from a work item. Pass the list of attachment url to be removed.
     *
     * @param workItemId    ID of the work item.
     * @param attachmentUrl List of attachment url.
     * @return The work item object. WorkItem {@link WorkItem}
     * @throws AzDException Handles errors from REST API and validates passed arguments.
     */
    public WorkItem removeWorkItemAttachment(int workItemId, List<String> attachmentUrl) throws AzDException {
        if (attachmentUrl.size() == 0) {
            throw new AzDException("The attachment url list cannot be null. Please validate the argument before passing");
        }

        List<JsonPatchDocument> reqBody = new ArrayList<>();

        var relations = workItems()
                .get(workItemId, r -> r.queryParameters.expand = WorkItemExpand.RELATIONS)
                .getRelations();

        for (String url : attachmentUrl) {
            int attachmentRelationNumber = -1;

            for (int i = 0; i < relations.size(); i++) {
                if (relations.get(i).getUrl().equals(url)) {
                    attachmentRelationNumber = i;

                    var jsonDocument = new JsonPatchDocument();
                    jsonDocument.setOperation(PatchOperation.REMOVE);
                    jsonDocument.setPath("/relations/-" + attachmentRelationNumber);

                    reqBody.add(jsonDocument);
                }
            }

            if (attachmentRelationNumber == -1)
                throw new AzDException(ApiExceptionTypes.InvalidArgumentException.name(), MessageFormat.format(
                        "Unable to remove the attachment ''{0}'' from work item with ID ''{1}'': The attachment doesn't exist.",
                        url, workItemId));
        }

        return workItems().update(workItemId, reqBody);
    }
}
