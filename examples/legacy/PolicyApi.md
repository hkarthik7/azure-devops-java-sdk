# Policy

- [REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/policy/?view=azure-devops-rest-6.1)
- API Version: 6.1

## Example

Before getting started you require personal access token to authenticate to **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

You are required to create a connection object before calling Git Api.

```java
public class Main {
    public static void main(String[] args) {
        String organisation = "myOrganisationName";
        String project = "myProject";
        String personalAccessToken = "accessToken";

        // Connect Azure DevOps API with organisation name and personal access token.
        var webApi = new AzDClientApi(organisation, project, personalAccessToken);

        // call the respective API with created webApi client connection object;
        var policy = webApi.getPolicyApi();
        var git = webApi.getGitApi();
        try {
            // create policy configuration
            // The below example adds a minimum number of reviewers and applies to develop branch.
            String repoId = git.getRepository("my-repository").getId();
            var scope = new ArrayList<>();
            var obj = new HashMap<String, Object>(){{
                put("repositoryId", repoId);
                put("refName", "refs/heads/develop");
                put("matchKind", "exact");
            }};

            scope.add(obj);

            var settings = new HashMap<String, Object>(){{
                put("minimumApproverCount", 1);
                put("creatorVoteCounts", false);
                put("scope", scope);
            }};

            p.createPolicyConfiguration("fa4e907d-c16b-4a4c-9dfa-4906e5d171dd", true, false, settings);
            
            // delete a policy configuration
            policy.deletePolicyConfiguration(5);
            
            // Get a policy configuration
            policy.getPolicyConfiguration(1);
            
            // Get a list of policy configurations
            policy.getPolicyConfigurations();
            
            // Update a policy configuration with minimum of 2 reviewers
            String repoId = git.getRepository("my-repository").getId();
            var scope = new ArrayList<>();
            var obj = new HashMap<String, Object>(){{
                put("repositoryId", repoId);
                put("refName", "refs/heads/develop");
                put("matchKind", "exact");
            }};

            scope.add(obj);

            var settings = new HashMap<String, Object>(){{
                put("minimumApproverCount", 2);
                put("creatorVoteCounts", false);
                put("scope", scope);
            }};

            p.updatePolicyConfiguration("fa4e907d-c16b-4a4c-9dfa-4906e5d171dd", true, false, settings);
            
            // Get policy type
            policy.getPolicyType("type-guid-here");
            
            // Get all policy types
            policy.getPolicyTypes();
            
        } catch (AzDException e) {
            e.printStackTrace();
        }
    }
}
```