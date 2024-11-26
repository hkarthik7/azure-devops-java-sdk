# WorkItemTracking

- [REST API](https://learn.microsoft.com/en-us/rest/api/azure/devops/wit/?view=azure-devops-rest-7.1)
- API Version: 7.1

## Example

Before getting started you require personal access token to authenticate to **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

Or if you are using OAuth token, follow
- [Authorize access to REST APIs with OAuth 2.0](https://learn.microsoft.com/en-us/azure/devops/integrate/get-started/authentication/oauth?view=azure-devops)
- [Use Azure DevOps OAuth 2.0 to create a web app](https://learn.microsoft.com/en-us/azure/devops/integrate/get-started/authentication/azure-devops-oauth?toc=%2Fazure%2Fdevops%2Fmarketplace-extensibility%2Ftoc.json&view=azure-devops)

Use [VsoScope](https://github.com/hkarthik7/azure-devops-java-sdk/blob/feature/v6.0/azd/src/main/java/org/azd/enums/VsoScope.java) to easily access
the API scope values.


```java
public class Main {
    public static void main(String[] args) throws AzDException {
        // Organisation Url -> https://dev.azure.com/{organisation} for Azure DevOps services
        // and http://{server:port}/tfs/{collection} for TFS server.
        // Running Instance.BASE_INSTANCE.getInstance() will return -> https://dev.azure.com/
        // or run Instance.BASE_INSTANCE.append("organisationName") which returns
        // https://dev.azure.com/organisationName

        String organisationUrl = Instance.BASE_INSTANCE.append("myOrganisation");
        String projectName = "myProject";
        String personalAccessToken = "myPersonalAccessToken";
        // 1) Choose authentication provider
        AccessTokenCredential pat = new PersonalAccessTokenCredential(organisationUrl, projectName, 
                personalAccessToken);
        // or
        AccessTokenCredential oauth = new OAuthAccessTokenCredential(organisationUrl, projectName,
                "appSecret", "authCode", "callbackUrl");

        // 2) Build client using the authentication provider. 
        AzDServiceClient client = AzDService.builder().authentication(pat).buildClient();
        // or
        AzDServiceClient client = AzDService.builder().authentication(oauth).buildClient();

        // Use client object to call the APIs.

        // create a new workitem
        JsonPatchDocument title = new JsonPatchDocument();
        title.setOperation(PatchOperation.ADD);
        title.setPath("/fields/System.Title");
        title.setValue("Sample user story");

        JsonPatchDocument description = new JsonPatchDocument();
        description.setOperation(PatchOperation.ADD);
        description.setPath("/fields/System.Description");
        description.setValue("This is the description for sample user story.");

        JsonPatchDocument tags = new JsonPatchDocument();
        tags.setOperation(PatchOperation.ADD);
        tags.setPath("/fields/System.Tags");
        tags.setValue(String.join(",", "DevOps", "Java", "Sprint 1"));

        client.workItemTracking().workItems().create("user story", List.of(title, description, tags));

        // create a new workitem with additional fields
        JsonPatchDocument assignedTo = new JsonPatchDocument();
        tags.setOperation(PatchOperation.ADD);
        tags.setPath("/fields/System.AssignedTo");
        tags.setValue("test@email.com");

        client.workItemTracking().workItems().create("user story", List.of(title, description, tags, assignedTo));

        // delete a workitem
        client.workItemTracking().workItems().delete(21);

        // permanently delete a workitem
        client.workItemTracking().workItems().delete(11, true);

        // get a workitem with all fields expanded
        client.workItemTracking().workItems().get(21, r -> r.queryParameters.expand = WorkItemExpand.ALL);

        // get a list of workitem
        client.workItemTracking().workItems().list(1, 2, 3);

        // get a workitem revisions
        client.workItemTracking().revisions().list(23);

        // get a revision of workitem with revision number;
        client.workItemTracking().revisions().get(21, 1);

        // update an existing workitem by specifying the fields to update.
        // Note that you have to specify internal field names to update it successfully.
        
        // Move a workitem to another area path
        JsonPatchDocument areaPath = new JsonPatchDocument();
        areaPath.setOperation(PatchOperation.ADD);
        areaPath.setPath("/fields/System.AreaPath");
        areaPath.setValue("MyBoard/Sprint 2");

        client.workItemTracking().workItems().update(277, List.of(areaPath));

        // add hyperlinks to the work item
        Map<String, String> hyperlinksMap = new HashMap<>();
        hyperlinksMap.put("https://docs.microsoft.com/en-us/rest/api/azure/devops",
                "This is a hyperlink that points to the Azure DevOps REST documentation.");

        client.helpers().workItemTracking().addHyperLinks(2, hyperlinksMap);

        // remove hyperlinks from the work item
        List<String> hyperlinks = new ArrayList<>();
        hyperlinks.add("https://docs.microsoft.com/en-us/rest/api/azure/devops");

        client.helpers().workItemTracking().addHyperLinks(2, hyperlinks);

        // Add an attachment to the work item.
        // 1) Add a text file to the work item.
        try(InputStream contentStream = StreamHelper.convertToStream("This is sample content")) {

            AttachmentReference attachment = client.workItemTracking().attachments().create(contentStream, r ->
            {
                r.queryParameters.fileName = "testFile.txt";
                r.queryParameters.uploadType = AttachmentUploadType.SIMPLE.name();
                r.queryParameters.areaPath = "MyBoard/Sprint 2";
            });

            Map<String, String> attachmentFields = new HashMap<>() {{
                put(attachment.getUrl(), "Test File url.");
            }};

            client.helpers().workItemTracking().addWorkItemAttachment(994, attachmentFields);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 2) Add a jpeg file to the work item
        try(InputStream contentStream = StreamHelper.convertToStream(new File("requirement-diagram.jpeg"))) {

            AttachmentReference attachment = client.workItemTracking().attachments().create(contentStream, r ->
            {
                r.queryParameters.fileName = "requirement-diagram.jpeg";
                r.queryParameters.uploadType = AttachmentUploadType.SIMPLE.name();
                r.queryParameters.areaPath = "MyBoard/Sprint 2";
            });

            Map<String, String> attachmentFields = new HashMap<>() {{
                put(attachment.getUrl(), "Infrastructure architecture diagram.");
            }};

            client.helpers().workItemTracking().addWorkItemAttachment(1784, attachmentFields);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Remove an attachment from the work item.
        List<WorkItemRelations> relations = client.workItemTracking()
                .workItems()
                .get(133, r -> r.queryParameters.expand = WorkItemExpand.RELATIONS)
                .getRelations();
        String fileNameToRemove = "testFile.txt";
        List<String> attachmentUrl = new ArrayList<>();

        for (var relation: relations) {
            if (relation.getAttributes().getName().equals(fileNameToRemove)) {
                attachmentUrl.add(relation.getUrl());
                client.helpers().workItemTracking().removeWorkItemAttachment(133, attachmentUrl);
            }
        }

        // Get the work item activities
        // GET https://dev.azure.com/{organization}/_apis/work/accountmyworkrecentactivity?api-version=7.1
        URI uri = UrlBuilder.fromBaseUrl(client.getOrganizationUrl())
                .appendPath(Constants.APIS_RELATIVE_PATH)
                .appendPath(ResourceArea.WORK.getName())
                .appendPath("accountmyworkrecentactivity")
                .appendQueryString(Constants.API_VERSION, "7.1")
                .build();

        AccountRecentActivityWorkItems activityWorkItems = ClientRequest.builder(client.accessTokenCredential())
                .URI(uri)
                .build()
                .execute(AccountRecentActivityWorkItems.class);

        System.out.println(activityWorkItems.getAccountRecentActivityWorkItems().get(0).getId());

        // Get the work item fields
        client.workItemTracking().fields().list();

        // Create a work item field
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

        client.workItemTracking().fields().create(workitemField);

        // Delete the work item field
        client.workItemTracking().fields().delete("New Work Item Field");

        // Update the work item field
        client.workItemTracking().fields().update("New Work Item Field", workitemField);

        // Create a query folder
        QueryHierarchyItem q = new QueryHierarchyItem();
        String query = client.workItemTracking().queries().list().getQueryHierarchyItems().get(1).getId();

        q.setName("Website team");
        q.setIsFolder(true);
        
        client.workItemTracking().queries().create(query, q);

        // Create a query in the previously created folder
        QueryHierarchyItem q = new QueryHierarchyItem();
        q.setName("All Bugs");
        q.setWiql("Select [System.Id], [System.Title], [System.State] From WorkItems Where [System.WorkItemType] " +
                "= 'Bug' order by [Microsoft.VSTS.Common.Priority] asc, [System.CreatedDate] desc");

        client.workItemTracking().queries().create("My Queries/Website team", q);

        // Get all queries
        client.workItemTracking().queries().list().getQueryHierarchyItems();

        // Delete a query folder
        client.workItemTracking().queries().delete("My Queries/Website team");

        // Get queries in batch
        QueryBatchGetRequest request = new QueryBatchGetRequest();
        request.expand = QueryExpand.ALL;
        request.errorPolicy = QueryErrorPolicy.OMIT;
        request.ids = List.of(client.workItemTracking().queries().list().getQueryHierarchyItems().get(1).getId());

        client.workItemTracking().queries().getBatch(request);

        // Search queries
        client.workItemTracking().queries().search(r ->
        {
            r.queryParameters.filter = "Bug";
            r.queryParameters.includeDeleted = false;
            r.queryParameters.top = 100;
            r.queryParameters.expand = QueryExpand.ALL;
        });
    }
}
```