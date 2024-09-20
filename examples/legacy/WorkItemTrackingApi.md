# WorkitemTracking

- [REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/wit/work%20items/create?view=azure-devops-rest-6.1)
- API Version: 6.1-preview.3

## Example

Before getting started you require personal access token to authenticate to **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

You are required to create a connection object before calling Workitem tracking Api.

```java
public class Main {
    public static void main(String[] args) {
        String organisation = "myOrganisationName";
        String project = "myProject";
        String personalAccessToken = "accessToken";

        // Connect Azure DevOps API with organisation name and personal access token.
        var webApi = new AzDClientApi(organisation, project, personalAccessToken);

        // call the respective API with created webApi client connection object;
        var wit = webApi.getWorkitemsApi(connection);
        try {
            // create a new workitem
            wit.createWorkItem("user story", WorkItemOperation.ADD, "Sample user story");
            
            // create a new workitem with additional fields
            var additionalFields = new HashMap<String, Object>(){{
                put("System.Tags", String.join(",", "DevOps", "Java", "SDK"));
                put("System.AssignedTo", "your-email-id");
            }};

            w.createWorkItem("user story", "Sample User story",
                    "Description for the user story", additionalFields);

            // delete a workitem
            wit.deleteWorkItem(21);

            // permanently delete a workitem
            wit.deleteWorkItem(11, true);

            // get a workitem with all fields expanded
            wit.getWorkItem(21, WorkItemExpand.ALL);

            // get a list of workitem
            wit.getWorkItems(new int[]{1,2,3});

            // get a workitem revisions
            wit.getWorkItemRevisions(23);

            // get a revision of workitem with revision number;
            wit.getWorkItemRevision(21, 1);
            
            // update an existing workitem by specifying the fields to update.
            // Note that you have to specify internal field names to update it successfully.
            var fieldsToUpdate = new HashMap<String, Object>(){{
                put("System.AssignedTo", "test@xmail.com");
                put("System.AreaPath", "you-team-area-path");
            }};

            w.updateWorkItem(277, fieldsToUpdate);
            
            // add hyperlinks to the work item
            Map<String, String> hyperlinksMap = new HashMap<>();
            hyperlinksMap.put("https://docs.microsoft.com/en-us/rest/api/azure/devops",
                    "This is a hyperlink that points to the Azure DevOps REST documentation.");
            
            workitemtracking.addHyperLinks(2, hyperlinksMap);
            
            // remove hyperlinks from the work item
            List<String> hyperlinks = new ArrayList<>();
            hyperlinks.add("https://docs.microsoft.com/en-us/rest/api/azure/devops");
            
            workitemtracking.addHyperLinks(2, hyperlinks);
            
            // Add an attachment to the work item.
            // 1) Add a text file to the work item.
            var contentStream = StreamHelper.convertToStream("This is sample content");

            var attachment = w.createAttachment("testFile.txt", AttachmentUploadType.SIMPLE,
                    "my-project-team", contentStream);
            
            var attachmentFields = new HashMap<String, String>() {{
                put(attachment.getUrl(), "Test File url.");
            }};

            w.addWorkItemAttachment(994, attachmentFields);
            
            // 2) Add a jpeg file to the work item
            var contentStream = StreamHelper.convertToStream(new File("requirement-diagram.jpeg"));

            var attachment = w.createAttachment("requirement-diagram.jpeg", AttachmentUploadType.SIMPLE,
                    "my-project-team", contentStream);

            var attachmentFields = new HashMap<String, String>() {{
                put(attachment.getUrl(), "Infrastructure architecture diagram.");
            }};

            w.addWorkItemAttachment(1784, attachmentFields);
            
            // Remove an attachment from the work item.
            var relations = w.getWorkItem(133, WorkItemExpand.RELATIONS).getRelations();
            String fileNameToRemove = "testFile.txt";
            List<String> attachmentUrl = new ArrayList<>();

            for (var relation: relations) {
                if (relation.getAttributes().getName().equals(fileNameToRemove)) {
                    attachmentUrl.add(relation.getUrl());
                    w.removeWorkItemAttachment(133, attachmentUrl);
                }
            }
            
            // Get the work item activities
            w.getMyWorkRecentActivity();
            
            // Get the work item fields
            w.getWorkItemFields();
            
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

            w.createWorkItemField(workitemField);
            
            // Delete the work item field
            w.deleteWorkItemField("New Work Item Field");
            
            // Update the work item field
            w.updateWorkItemField("New Work Item Field", false);
            
            // Create a query folder
            var q = new QueryHierarchyItem();
            var query = w.getQueries().getQueryHierarchyItems().get(1).getId();

            q.setName("Website team");
            q.setIsFolder(true);
            w.createQuery(query, q);
            
            // Create a query in the previously created folder
            var q = new QueryHierarchyItem();
            q.setName("All Bugs");
            q.setWiql("Select [System.Id], [System.Title], [System.State] From WorkItems Where [System.WorkItemType] " +
                    "= 'Bug' order by [Microsoft.VSTS.Common.Priority] asc, [System.CreatedDate] desc");

            w.createQuery("My Queries/Website team", q);
            
            // Get all queries
            w.getQueries().getQueryHierarchyItems();

            // Delete a query folder
            w.deleteQuery("My Queries/Website team");

            // Get queries in batch
            var id = w.getQueries().getQueryHierarchyItems().stream().findFirst().get().getId();
            w.getQueryBatches(QueryErrorPolicy.OMIT, QueryExpand.ALL, new String[]{id});

            // Search queries
            w.searchQuery("Bugs");

        } catch (AzDException e) {
            e.printStackTrace();
        }
    }
}
```
