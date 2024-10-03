package org.azd.unittests;

import org.azd.UnitTestConfiguration;
import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.common.types.JsonPatchDocument;
import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.helpers.StreamHelper;
import org.azd.http.ClientRequest;
import org.azd.legacy.MockParameters;
import org.azd.serviceclient.AzDService;
import org.azd.serviceclient.AzDServiceClient;
import org.azd.workitemtracking.WorkItemTrackingRequestBuilder;
import org.azd.workitemtracking.types.*;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class WorkItemTrackingRequestBuilderTest {
    private static final SerializerContext serializer = InstanceFactory.createSerializerContext();
    private static AzDServiceClient client;
    private static UnitTestConfiguration testConfiguration;
    private static WorkItemTrackingRequestBuilder w;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        var file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        var configFile = new File(dir + "/src/test/java/org/azd/config.json");
        var m = serializer.deserialize(file, MockParameters.class);
        testConfiguration = serializer.deserialize(configFile, UnitTestConfiguration.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        var pat = new PersonalAccessTokenCredential(Instance.BASE_INSTANCE.append(organization), project, token);
        client = AzDService.builder()
                .authentication(pat)
                .buildClient();
        w = client.workItemTracking();
    }

    @Test
    public void shouldGetWorkItem() throws AzDException {
        var expectedValue = client.core().projects().get().getName();
        var result = w.workItems().get(2).getFields().getSystemTeamProject();
        assertEquals(expectedValue, result);
    }

    @Test
    public void shouldGetWorkItemWithOptionalParameters() throws AzDException {
        var expectedValue = client.core().projects().get().getName();
        var result = w.workItems().get(2, r ->
                r.queryParameters.expand = WorkItemExpand.ALL).getFields().getSystemTeamProject();
        assertEquals(expectedValue, result);
    }

    @Test
    public void shouldCreateAWorkItem() throws AzDException {
        var title = new JsonPatchDocument();
        title.setOperation(PatchOperation.ADD);
        title.setPath("/fields/System.Title");
        title.setValue("Sample User story");

        var description = new JsonPatchDocument();
        description.setOperation(PatchOperation.ADD);
        description.setPath("/fields/System.Description");
        description.setValue("Description for the user story");

        var tags = new JsonPatchDocument();
        tags.setOperation(PatchOperation.ADD);
        tags.setPath("/fields/System.Tags");
        tags.setValue("DevOps,Java,SDK");

        w.workItems().create("user story", List.of(title, description, tags));
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteAWorkItem() throws AzDException {
        w.workItems().delete(6);
    }

    @Test
    public void shouldGetWorkItems() throws AzDException {
        w.workItems().list(1, 2, 4);
    }

    @Test
    public void shouldGetWorkItemRevisions() throws AzDException {
        var rev = w.revisions().list(2,
                        r -> r.queryParameters.expand = WorkItemExpand.ALL)
                .getWorkItems()
                .stream()
                .findFirst()
                .get()
                .getFields()
                .getSystemAreaId();
        assertEquals(12, rev);
    }

    @Test
    public void shouldGetWorkItemRevision() throws AzDException {
        w.revisions().get(2, 1);
    }

    @Test
    public void shouldQueryWorkItems() throws AzDException {
        var query = "Select * From WorkItems Where [System.WorkItemType] = 'User Story'";
        var team = "azure-devops-java-sdk Team";
        w.wiql().query(team, query, r ->
        {
            r.queryParameters.top = 10;
            r.queryParameters.timePrecision = true;
        }).getWorkItems();
    }

    @Test
    public void shouldQueryWorkItemsAndGetExactlyOneResult() throws AzDException {
        var query = "Select * From WorkItems Where [System.WorkItemType] = 'User Story'";
        var team = "azure-devops-java-sdk Team";
        var res = (long) w.wiql().query(team, query, r ->
        {
            r.queryParameters.top = 10;
            r.queryParameters.timePrecision = true;
        }).getWorkItems().size();
        assertEquals(10, res);
    }

    @Test(expected = AzDException.class)
    public void shouldRemoveWorkItemFromRecycleBin() throws AzDException {
        w.recycleBin().destroy(93);
    }

    @Test(expected = AzDException.class)
    public void shouldGetWorkItemFromRecycleBin() throws AzDException {
        w.recycleBin().get(760);
    }

    @Test
    public void shouldGetDeletedWorkItemFromRecycleBin() throws AzDException {
        w.recycleBin().list();
    }

    @Test(expected = AzDException.class)
    public void shouldGetDeletedWorkItemsFromRecycleBin() throws AzDException {
        w.recycleBin().list(71, 72, 73, 74);
    }

    @Test(expected = AzDException.class)
    public void shouldRestoreWorkItemFromRecycleBin() throws AzDException {
        w.recycleBin().restore(70, false);
    }

    @Test
    public void shouldUpdateAWorkItem() throws AzDException {
        var docToUpdate = new JsonPatchDocument();
        docToUpdate.setOperation(PatchOperation.ADD);
        docToUpdate.setPath("/fields/System.AssignedTo");
        docToUpdate.setValue("test@xmail.com");
        w.workItems().update(176, List.of(docToUpdate));
    }

    @Test
    public void shouldAddHyperlink() throws AzDException {
        Map<String, String> hyperlinksMap = new HashMap<>();
        hyperlinksMap.put("https://docs.microsoft.com/en-us/rest/api/azure/devops",
                "This is a hyperlink that points to the Azure DevOps REST documentation.");
        client.helpers().workItemTracking().addHyperLinks(1, hyperlinksMap);
    }

    @Test
    public void shouldRemoveHyperlink() throws AzDException {
        List<String> hyperlinks = new ArrayList<>();
        hyperlinks.add("https://docs.microsoft.com/en-us/rest/api/azure/devops");
        try {
            client.helpers().workItemTracking().removeHyperLinks(1, hyperlinks);
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
        w.workItemTypes().list();
    }

    @Test
    public void shouldGetAWorkItemType() throws AzDException {
        w.workItemTypes().get("Bug");
    }

    @Test
    public void shouldCreateWorkItemAttachment() throws AzDException {
        var contentStream = StreamHelper.convertToStream("This is sample content");
        w.attachments().create(contentStream, r ->
        {
            r.queryParameters.fileName = "testFile.txt";
            r.queryParameters.areaPath = "azure-devops-java-sdk";
            r.queryParameters.uploadType = AttachmentUploadType.SIMPLE.toString().toLowerCase();
        });
    }

    @Test
    public void shouldGetWorkItemAttachmentAsStreamToAFile() throws AzDException {
        var responseStream = w.attachments().get("1b8993be-1c0c-4282-9147-4a2141af1a91", r ->
        {
            r.queryParameters.fileName = "newTestFile.txt";
            r.queryParameters.download = true;
        });
        StreamHelper.download("newTestFile.txt", responseStream);
    }

    @Test
    public void shouldGetWorkItemAttachmentAsZipFile() throws AzDException {
        var responseStream = w.attachments().getAsZip("7a62c972-9403-4032-8182-5a2b2eb927b7", r ->
        {
            r.queryParameters.download = true;
            r.queryParameters.fileName = "test.zip";
        });
        StreamHelper.download("test.zip", responseStream);
    }

    @Test
    public void shouldAddAnAttachmentToAWorkItem() {
        try {
            var contentStream = StreamHelper.convertToStream("This is sample content");

            var attachment = w.attachments().create(contentStream, r ->
            {
                r.queryParameters.uploadType = AttachmentUploadType.SIMPLE.toString();
                r.queryParameters.areaPath = "azure-devops-java-sdk";
                r.queryParameters.fileName = "testFile.txt";
            });
            var attachmentFields = new HashMap<String, String>() {{
                put(attachment.getUrl(), "Test File url.");
            }};

            client.helpers().workItemTracking().addWorkItemAttachment(994, attachmentFields);
        } catch (AzDException e) {
        }
    }

    @Test
    public void shouldRemoveAnAttachmentFromAWorkItem() {
        try {
            var urls = w.workItems().get(994, r -> r.queryParameters.expand = WorkItemExpand.RELATIONS).getRelations();
            if (urls != null)
                for (var url : urls)
                    client.helpers().workItemTracking().removeWorkItemAttachment(994, List.of(url.getUrl()));
        } catch (AzDException e) {
        }
    }

    @Test
    public void shouldGetWorkItemActivities() throws AzDException {
        ClientRequest.builder(client.accessTokenCredential())
                .baseInstance(client.getOrganizationUrl())
                .area("wit")
                .location("1bc988f4-c15f-4072-ad35-497c87e3a909")
                .build()
                .execute(AccountRecentActivityWorkItems.class);
    }

    @Test
    public void shouldGetWorkItemFields() throws AzDException {
        w.fields().list();
    }

    @Test
    public void shouldGetWorkItemFieldsWithFieldsExpanded() throws AzDException {
        w.fields().list(GetFieldsExpand.EXTENSIONFIELDS);
    }

    @Test
    public void shouldGetWorkItemField() throws AzDException {
        w.fields().get("Acceptance Criteria");
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
            workitemField.setSupportedOperations(List.of(new WorkItemFieldOperation() {{
                setReferenceName("SupportedOperations.Equals");
                setReferenceName("=");
            }}));
            workitemField.setIsIdentity(true);
            workitemField.setIsPicklist(false);
            workitemField.setIsPicklistSuggested(false);
            workitemField.setUrl(null);

            w.fields().create(workitemField);
        } catch (AzDException e) {
            // Ignore ProcessFieldAlreadyExistsInformedException
        }
    }

    @Test
    public void shouldDeleteWorkItemField() throws AzDException {
        try {
            w.fields().delete("New Work Item Field");
        } catch (AzDException e) {
            // Ignore ProcessFieldCouldNotBeFoundException
        }
    }

    @Test
    public void shouldUpdateAWorkItemField() throws AzDException {
        try {
            var fieldUpdate = new WorkItemFieldUpdate();
            fieldUpdate.isDeleted = false;
            w.fields().update("New Work Item Field", fieldUpdate);
        } catch (AzDException e) {
            // Ignore FieldHasNotBeenDeletedException
        }
    }

    @Test
    public void shouldCreateAQueryFolder() throws AzDException {
        try {
            var q = new QueryHierarchyItem();
            var query = w.queries().list().getQueryHierarchyItems().get(1).getId();

            q.setName("Website team");
            q.setIsFolder(true);
            w.queries().create(query, q);
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

            w.queries().create("My Queries/Website team", q);
        } catch (AzDException e) {
            // Ignore LegacyQueryItemException
        }
    }

    @Test
    public void shouldGetAllQueries() throws AzDException {
        w.queries().list().getQueryHierarchyItems();
    }

    @Test
    public void shouldGetAQueryObject() throws AzDException {
        w.queries().get("My Queries");
    }

    @Test
    public void shouldDeleteAQuery() throws AzDException {
        try {
            w.queries().delete("My Queries/Website team");
        } catch (AzDException e) {
            // Ignore QueryItemNotFoundException
        }
    }

    @Test
    public void shouldGetQueriesInBatch() throws AzDException {
        var id = w.queries().list().getQueryHierarchyItems().stream().findFirst().get().getId();
        var batchRequest = new QueryBatchGetRequest();
        batchRequest.ids = List.of(id);
        batchRequest.errorPolicy = QueryErrorPolicy.OMIT;
        batchRequest.expand = QueryExpand.ALL;
        w.queries().getBatch(batchRequest);
    }

    @Test
    public void shouldSearchQueriesBasedOnFilter() throws AzDException {
        w.queries().search(r -> r.queryParameters.filter = "Bugs");
    }
}
