package org.azd;

import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.helpers.StreamHelper;
import org.azd.interfaces.AzDClient;
import org.azd.interfaces.CoreDetails;
import org.azd.utils.AzDClientApi;
import org.azd.workitemtracking.WorkItemTrackingApi;
import org.azd.workitemtracking.types.QueryHierarchyItem;
import org.azd.workitemtracking.types.WorkItemField;
import org.azd.workitemtracking.types.WorkItemFieldOperation;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class WorkItemTrackingApiTest {

    private static final JsonMapper MAPPER = new JsonMapper();

    private static AzDClient webApi;

    private static WorkItemTrackingApi w;

    private static CoreDetails c;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        webApi = new AzDClientApi(organization, project, token);
        w = webApi.getWorkItemTrackingApi();
        c = webApi.getCoreApi();
    }

    @Test
    public void shouldGetWorkItem() throws AzDException {
        var expectedValue = "azure-devops-java-sdk";
        var result = w.getWorkItem(2).getFields().getSystemTeamProject();
        assertEquals(expectedValue, result);
    }

    @Test
    public void shouldGetWorkItemWithOptionalParameters() throws AzDException {
        var expectedValue = "azure-devops-java-sdk";
        var result = w.getWorkItem(2, WorkItemExpand.ALL).getFields().getSystemTeamProject();
        assertEquals(expectedValue, result);
    }

    @Test
    public void shouldCreateAWorkItem() throws AzDException {
        w.createWorkItem("user story", WorkItemOperation.ADD, "Sample User story", "Description for the user story",
                new String[]{"DevOps", "Java", "SDK"});
    }

    @Test
    public void shouldCreateAWorkItemWithAdditionalFields() throws AzDException {
        var additionalFields = new HashMap<String, Object>() {{
            put("System.Tags", String.join(",", "DevOps", "Java", "SDK"));
        }};

        w.createWorkItem("user story", "Sample User story", "Description for the user story", additionalFields);
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteAWorkItem() throws AzDException {
        w.deleteWorkItem(6);
    }

    @Test
    public void shouldGetWorkItems() throws AzDException {
        w.getWorkItems(new int[]{1, 2, 4});
    }

    @Test
    public void shouldGetWorkItemRevisions() throws AzDException {
        var r = w.getWorkItemRevisions(2, WorkItemExpand.ALL).getWorkItems().stream().findFirst().get().getFields()
                .getSystemAreaId();
        assertEquals(12, r);
    }

    @Test
    public void shouldGetWorkItemRevision() throws AzDException {
        w.getWorkItemRevision(2, 1);
    }

    @Test
    public void shouldQueryWorkItems() throws AzDException {
        var query = "Select * From WorkItems Where [System.WorkItemType] = 'User Story'";
        var team = "azure-devops-java-sdk Team";
        w.queryByWiql(team, query, 10, true).getWorkItems();
    }

    @Test
    public void shouldQueryWorkItemsAndGetExactlyOneResult() throws AzDException {
        var query = "Select * From WorkItems Where [System.WorkItemType] = 'User Story'";
        var team = "azure-devops-java-sdk Team";
        var res = (long) w.queryByWiql(team, query, 1, true).getWorkItems().size();
        assertEquals(1, res);
    }

    @Test(expected = AzDException.class)
    public void shouldRemoveWorkItemFromRecycleBin() throws AzDException {
        w.removeWorkItemFromRecycleBin(93);
    }

    @Test(expected = AzDException.class)
    public void shouldGetWorkItemFromRecycleBin() throws AzDException {
        w.getWorkItemFromRecycleBin(760);
    }

    @Test
    public void shouldGetDeletedWorkItemFromRecycleBin() throws AzDException {
        w.getDeletedWorkItemsFromRecycleBin();
    }

    @Test(expected = AzDException.class)
    public void shouldGetDeletedWorkItemsFromRecycleBin() throws AzDException {
        w.getDeletedWorkItemsFromRecycleBin(new int[]{71, 72, 73, 74});
    }

    @Test(expected = AzDException.class)
    public void shouldRestoreWorkItemFromRecycleBin() throws AzDException {
        w.restoreWorkItemFromRecycleBin(70);
    }

    @Test
    public void shouldUpdateAWorkItem() throws AzDException {
        var fieldsToUpdate = new HashMap<String, Object>() {{
            put("System.AssignedTo", "test@xmail.com");
        }};
        w.updateWorkItem(176, fieldsToUpdate);
    }

    @Test
    public void shouldAddHyperlink() throws AzDException {
        Map<String, String> hyperlinksMap = new HashMap<>();
        hyperlinksMap.put("https://docs.microsoft.com/en-us/rest/api/azure/devops",
                "This is a hyperlink that points to the Azure DevOps REST documentation.");
        w.addHyperLinks(1, hyperlinksMap);
    }

    @Test
    public void shouldRemoveHyperlink() throws AzDException {
        List<String> hyperlinks = new ArrayList<>();
        hyperlinks.add("https://docs.microsoft.com/en-us/rest/api/azure/devops");
        try {
            w.removeHyperLinks(1, hyperlinks);
        } catch (AzDException e) {
            // Test is also successful if hyperlink doesn't exist.
            if (e.getMessage().toLowerCase().contains("the hyperlink doesn't exist")) {
                return;
            }
            throw e;
        }
    }

    @Test
    public void shouldGetWorkItemTypes() throws AzDException {
        w.getWorkItemTypes();
    }

    @Test
    public void shouldGetAWorkItemType() throws AzDException {
        w.getWorkItemType("Bug");
    }

    @Test
    public void shouldCreateWorkItemAttachment() throws AzDException {
        var contentStream = StreamHelper.convertToStream("This is sample content");
        w.createAttachment("testFile.txt", AttachmentUploadType.SIMPLE,
                "azure-devops-java-sdk", contentStream);
    }

    @Test
    public void shouldGetWorkItemAttachmentAsStreamToAFile() throws AzDException {
        var responseStream = w.getAttachmentContent("1b8993be-1c0c-4282-9147-4a2141af1a91", "newTestFile.txt", true);
        StreamHelper.download("newTestFile.txt", responseStream);
    }

    @Test
    public void shouldGetWorkItemAttachmentAsZipFile() throws AzDException {
        var responseStream = w.getAttachmentContent("7a62c972-9403-4032-8182-5a2b2eb927b7", "test.zip", true);
        StreamHelper.download("test.zip", responseStream);
    }

    @Test
    public void shouldAddAnAttachmentToAWorkItem() {
        try {
            var contentStream = StreamHelper.convertToStream("This is sample content");

            var attachment = w.createAttachment("testFile.txt", AttachmentUploadType.SIMPLE,
                    "azure-devops-java-sdk", contentStream);
            var attachmentFields = new HashMap<String, String>() {{
                put(attachment.getUrl(), "Test File url.");
            }};

            w.addWorkItemAttachment(994, attachmentFields);
        } catch (AzDException e) {
        }
    }

    @Test
    public void shouldRemoveAnAttachmentFromAWorkItem() {
        try {
            var urls = w.getWorkItem(994, WorkItemExpand.RELATIONS).getRelations();
            if (urls != null)
                for (var url : urls)
                    w.removeWorkItemAttachment(994, List.of(url.getUrl()));
        } catch (AzDException e) {
        }
    }

    @Test
    public void shouldGetWorkItemActivities() throws AzDException {
        w.getMyWorkRecentActivity();
    }

    @Test
    public void shouldGetWorkItemFields() throws AzDException {
        w.getWorkItemFields();
    }

    @Test
    public void shouldGetWorkItemFieldsWithFieldsExpanded() throws AzDException {
        w.getWorkItemFields(GetFieldsExpand.EXTENSIONFIELDS);
    }

    @Test
    public void shouldGetWorkItemField() throws AzDException {
        w.getWorkItemField("Acceptance Criteria");
    }

    @Test
    public void shouldCreateWorkItemField() throws AzDException {
        try {
            var workitemField = new WorkItemField();
            workitemField.setName("New Work Item Field");
            workitemField.setReferenceName("SupportedOperations.GreaterThanEquals");
            workitemField.setDescription(null);
            workitemField.setType(FieldType.STRING);
            workitemField.setUsage(FieldUsage.WORKITEM);
            workitemField.setReadOnly(false);
            workitemField.setCanSortBy(true);
            workitemField.setIsQueryable(true);
            workitemField.setSupportedOperations(List.of(new WorkItemFieldOperation(){{
                setReferenceName("SupportedOperations.Equals");
                setReferenceName("=");
            }}));
            workitemField.setIsIdentity(true);
            workitemField.setIsPicklist(false);
            workitemField.setIsPicklistSuggested(false);
            workitemField.setUrl(null);

            w.createWorkItemField(workitemField);
        }
        catch (AzDException e) {
            // Ignore ProcessFieldAlreadyExistsInformedException
        }
    }

    @Test
    public void shouldDeleteWorkItemField() throws AzDException {
        try {
            w.deleteWorkItemField("New Work Item Field");
        } catch (AzDException e) {
            // Ignore ProcessFieldCouldNotBeFoundException
        }
    }

    @Test
    public void shouldUpdateAWorkItemField() throws AzDException {
        try {
            w.updateWorkItemField("New Work Item Field", false);
        } catch (AzDException e) {
            // Ignore FieldHasNotBeenDeletedException
        }
    }

    @Test
    public void shouldCreateAQueryFolder() throws AzDException {
        try {
            var q = new QueryHierarchyItem();
            var query = w.getQueries().getQueryHierarchyItems().get(1).getId();

            q.setName("Website team");
            q.setIsFolder(true);
            w.createQuery(query, q);
        } catch (AzDException e) {
            // Ignore LegacyQueryItemException
        }
    }

    @Test
    public void shouldCreateAQuery() throws AzDException {
        try {
            var q = new QueryHierarchyItem();
            q.setName("All Bugs");
            q.setWiql("Select [System.Id], [System.Title], [System.State] From WorkItems Where [System.WorkItemType] " +
                    "= 'Bug' order by [Microsoft.VSTS.Common.Priority] asc, [System.CreatedDate] desc");

            w.createQuery("My Queries/Website team", q);
        } catch (AzDException e) {
            // Ignore LegacyQueryItemException
        }
    }

    @Test
    public void shouldGetAllQueries() throws AzDException {
        w.getQueries().getQueryHierarchyItems();
    }

    @Test
    public void shouldGetAQueryObject() throws AzDException {
        w.getQuery("My Queries");
    }

    @Test
    public void shouldDeleteAQuery() throws AzDException {
        try {
            w.deleteQuery("My Queries/Website team");
        } catch (AzDException e) {
            // Ignore QueryItemNotFoundException
        }
    }

    @Test
    public void shouldGetQueriesInBatch() throws AzDException {
        var id = w.getQueries().getQueryHierarchyItems().stream().findFirst().get().getId();
        w.getQueryBatches(QueryErrorPolicy.OMIT, QueryExpand.ALL, new String[]{id});
    }

    @Test
    public void shouldSearchQueriesBasedOnFilter() throws AzDException {
        w.searchQuery("Bugs");
    }
}