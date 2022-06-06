# WorkitemTracking

- [REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/wit/work%20items/create?view=azure-devops-rest-6.1)
- API Version: 6.1-preview.3

## Example

Before getting started you require personal access token to authenticate with **Azure DevOps** services REST API.
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
            var attachment = w.createAttachment("testFile.txt", AttachmentUploadType.SIMPLE, "my-team", "Sample content");
            var attachmentFields = new HashMap<String, String>(){{ put(attachment.getUrl(), "Test File url."); }};
            
            w.addWorkItemAttachment(133, attachmentFields);
            
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

        } catch (AzDException e) {
            e.printStackTrace();
        }
    }
}
```
