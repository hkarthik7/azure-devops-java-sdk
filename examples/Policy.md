# Policy

- [REST API](https://learn.microsoft.com/en-us/rest/api/azure/devops/policy/?view=azure-devops-rest-7.1)
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

        // create policy configuration
        // The below example adds a minimum number of reviewers and applies to develop branch.
        ArrayList<Object> scope = new ArrayList<>();
        Map<String, Object> obj = new HashMap<>(){{
            put("repositoryId", client.git().repositories().get("myRepository").getId());
            put("refName", "refs/heads/develop");
            put("matchKind", "exact");
        }};

        scope.add(obj);

        Map<String, Object> settings = new HashMap<>(){{
            put("minimumApproverCount", 1);
            put("creatorVoteCounts", false);
            put("scope", scope);
        }};

        PolicyTypeRef typeRef = new PolicyTypeRef();
        typeRef.setId("fa4e907d-c16b-4a4c-9dfa-4906e5d171dd");

        PolicyConfiguration policyConfiguration = new PolicyConfiguration();
        policyConfiguration.setSettings(settings);
        policyConfiguration.setType(typeRef);
        policyConfiguration.setEnabled(true);

        client.policy().configurations().create(policyConfiguration);

        // delete a policy configuration
        client.policy().configurations().delete(5);

        // Get a policy configuration
        client.policy().configurations().get(1);

        // Get a list of policy configurations
        client.policy().configurations().list();

        // Update a policy configuration with minimum of 2 reviewers
        ArrayList<Object> scope = new ArrayList<>();
        Map<String, Object> obj = new HashMap<>(){{
            put("repositoryId", client.git().repositories().get("myRepository").getId());
            put("refName", "refs/heads/develop");
            put("matchKind", "exact");
        }};

        scope.add(obj);

        Map<String, Object> settings = new HashMap<>(){{
            put("minimumApproverCount", 2);
            put("creatorVoteCounts", false);
            put("scope", scope);
        }};

        PolicyTypeRef typeRef = new PolicyTypeRef();
        typeRef.setId("fa4e907d-c16b-4a4c-9dfa-4906e5d171dd");

        PolicyConfiguration policyConfiguration = new PolicyConfiguration();
        policyConfiguration.setSettings(settings);
        policyConfiguration.setType(typeRef);
        policyConfiguration.setEnabled(true);

        client.policy().configurations().update(5, policyConfiguration);

        // Get policy type
        client.policy().types().get("type-guid-here");

        // Get all policy types
        client.policy().types().list();
    }
}
```