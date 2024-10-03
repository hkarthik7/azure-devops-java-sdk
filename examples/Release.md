# Release

- [REST API](https://learn.microsoft.com/en-us/rest/api/azure/devops/release/?view=azure-devops-rest-7.1)
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
        
        // create a release with the following parameters
        // release definition/pipeline id;
        // description for the release
        // artifact alias name (This is usually will be the name of build pipeline name prefixed with _)
        // artifact id (build number)
        // build pipeline name
        // isDraft - false/true
        BuildVersion buildVersion = new BuildVersion();
        buildVersion.setId("1234");
        buildVersion.setName("Demo-CI");

        ArtifactMetadata artifactMetadata = new ArtifactMetadata();
        artifactMetadata.setAlias("_Demo-CI");
        artifactMetadata.setInstanceReference(buildVersion);

        ReleaseStartMetadata releaseStartMetadata = new ReleaseStartMetadata();
        releaseStartMetadata.setDefinitionId(2);
        releaseStartMetadata.setDescription("Sample release");
        releaseStartMetadata.setArtifacts(List.of(artifactMetadata));
        releaseStartMetadata.setIsDraft(false);

        client.release().releases().create(releaseStartMetadata)

        // get a release
        client.release().releases().get("releaseId");

        // get all releases
        // This returns a paginated response and contains link to next page.
        Releases releases = client.release().releases().list(r -> r.queryParameters.top = 100);

        // Get next set of results.
        releases = ClientRequest.builder(client.accessTokenCredential())
                .URI(releases.getNextPageLink())
                .build()
                .execute(Releases.class);

        // get release environment
        Release release = client.release().releases().get(23, r -> r.queryParameters.expand = SingleReleaseExpands.TASKS);
        client.release().releases().environment().get(release.getEnvironments().get(0).getId(), release.getId());

        // get release definitions
        client.release().definitions().list();

        // get a release definition
        client.release().definitions().get(2);

        // get release definition history
        client.release().definitions().revision().getHistory(2);
    }
}
```