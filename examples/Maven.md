# Maven

- [REST API](https://learn.microsoft.com/en-us/rest/api/azure/devops/artifactspackagetypes/maven?view=azure-devops-rest-7.1)
- API Version: 7.1

## Example

Before getting started you require personal access token to authenticate to **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

Or if you are using OAuth token, follow
- [Authorize access to REST APIs with OAuth 2.0](https://learn.microsoft.com/en-us/azure/devops/integrate/get-started/authentication/oauth?view=azure-devops)
- [Use Azure DevOps OAuth 2.0 to create a web app](https://learn.microsoft.com/en-us/azure/devops/integrate/get-started/authentication/azure-devops-oauth?toc=%2Fazure%2Fdevops%2Fmarketplace-extensibility%2Ftoc.json&view=azure-devops)

Use [VsoScope](https://github.com/hkarthik7/azure-devops-java-sdk/blob/feature/v6.0/azd/src/main/java/org/azd/enums/VsoScope.java) to easily access
the API scope values.

## Upstreaming

Upstream sources enables developers to use a single feed to publish and consume packages from Artifact feeds and public 
registries such as NuGet.org or npmjs.com. To set up upstream sources for your feed, check the box to include packages from common public sources. 
This will allow your feed to use packages from the common public registries. [Upstream sources](https://docs.microsoft.com/en-us/azure/devops/artifacts/concepts/upstream-sources?view=azure-devops)

You can omit the project name for calling Maven API as it is not a mandatory parameter.
If you do omit the project name you will end up working with feeds across your organisation.
Provide the project name if you want to work with feeds scoped to a project. You can always set the
project name parameter pointing to different project by creating a 'Connection' object.

```java
import java.io.FileInputStream;
import java.io.InputStream;

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

        // Exclude project
        MavenRequestBuilder maven = client.artifactsPackageTypes().maven(p -> p.excludeProject);
        // OR
        MavenRequestBuilder maven = client.artifactsPackageTypes().maven();

        // Get information about a package
        maven.get(r ->
        {
            r.feedId = "myFeed";
            r.groupId = "myGroupId";
            r.artifactId = "myArtifactId";
            r.version = "1.0.0";
        });

        // Download a package
        InputStream responseStream = maven.get(r ->
        {
            r.feedId = "myFeed";
            r.groupId = "myGroupId";
            r.artifactId = "myArtifactId";
            r.version = "1.0.0";
            r.fileName = "myFile.txt";
        });

        StreamHelper.download("myFile.txt", responseStream);

        // Upload a package
        try(InputStream content = new FileInputStream("myArtifact.jar")) {
            client.helpers().artifactsPackageTypes().uploadPackage("myFeed", "myGroupId", "myArtifactId", "1.0.0", "myArtifact.jar", content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Get information about a deleted package.
        maven.get(r ->
        {
            r.feedId = "myFeed";
            r.groupId = "myGroupId";
            r.artifactId = "myArtifactId";
            r.version = "1.0.0";
            r.fileName = "myFile.txt";
        }, s -> s.showDeleted);

        // get information about a package in the recycle bin.
        maven.recycleBin().get(r ->
        {
            r.feedId = "myFeed";
            r.groupId = "myGroupId";
            r.artifactId = "myArtifactId";
            r.version = "1.0.0";
            r.fileName = "myFile.txt";
        });

        // Update state for a package version.
        JsonPatchDocument jsonPatchDocument = new JsonPatchDocument();
        jsonPatchDocument.setPath("/views/-");
        jsonPatchDocument.setOperation(PatchOperation.ADD);
        jsonPatchDocument.setValue(PackagePromote.RELEASE); // Promote the package

        PackageVersionDetails packageVersionDetails = new PackageVersionDetails();
        packageVersionDetails.views = jsonPatchDocument;

        maven.update(r ->
        {
            r.feedId = "myFeed";
            r.groupId = "myGroupId";
            r.artifactId = "myArtifactId";
            r.version = "1.0.0";
            r.fileName = "myFile.txt";
        }, packageVersionDetails);

        // Update state for a package version. If you have a custom View,
        JsonPatchDocument jsonPatchDocument = new JsonPatchDocument();
        jsonPatchDocument.setPath("/views/-");
        jsonPatchDocument.setOperation(PatchOperation.ADD);
        jsonPatchDocument.setValue("CustomView"); 

        PackageVersionDetails packageVersionDetails = new PackageVersionDetails();
        packageVersionDetails.views = jsonPatchDocument;

        maven.update(r ->
        {
            r.feedId = "myFeed";
            r.groupId = "myGroupId";
            r.artifactId = "myArtifactId";
            r.version = "1.0.0";
            r.fileName = "myFile.txt";
        }, packageVersionDetails);

        // Delete a package version from the feed and move it to the feed's recycle bin.
        maven.delete(r ->
        {
            r.feedId = "myFeed";
            r.groupId = "myGroupId";
            r.artifactId = "myArtifactId";
            r.version = "1.0.0";
            r.fileName = "myFile.txt";
        });

        // Restore a package version from the recycle bin to its associated feed.
        MavenRecycleBinPackageVersionDetails packageVersionDetails = new MavenRecycleBinPackageVersionDetails();
        packageVersionDetails.deleted = false;

        maven.recycleBin().restore(packageVersionDetails, r ->
        {
            r.feedId = "myFeed";
            r.groupId = "myGroupId";
            r.artifactId = "myArtifactId";
            r.version = "1.0.0";
            r.fileName = "myFile.txt";
        });

        // Permanently delete a package from a feed's recycle bin.
        maven.deletePackageVersionFromRecycleBin("myFeed", "myGroupId", "myArtifactId", "1.0.0");
        
        /*
         * Upstreaming section. For the explanation of upstream, refer to "Upstreaming" above.
         */

        // Get the upstreaming behavior of a package within the context of a feed.
        maven.upstreamingBehavior().get(r ->
        {
            r.feedId = "myFeed";
            r.groupId = "myGroupId";
            r.artifactId = "myArtifactId";
        });

        // allow externally sourced versions for your package.
        UpstreamingBehavior upstreamingBehavior = new UpstreamingBehavior();
        upstreamingBehavior.setVersionsFromExternalUpstreams("allowExternalVersions");

        maven.upstreamingBehavior().set(r ->
        {
            r.feedId = "myFeed";
            r.groupId = "myGroupId";
            r.artifactId = "myArtifactId";
        });

        // allow externally sourced versions for your package or clear the upstreaming behavior.
        UpstreamingBehavior upstreamingBehavior = new UpstreamingBehavior();
        upstreamingBehavior.setVersionsFromExternalUpstreams("auto");  // to clear the upstreaming.

        maven.upstreamingBehavior().set(r ->
        {
            r.feedId = "myFeed";
            r.groupId = "myGroupId";
            r.artifactId = "myArtifactId";
        });

        /*
         * PackagesBatch section.
         */
        MavenMinimalPackageDetails pkg1 = new MavenMinimalPackageDetails();
        pkg1.group = "myGroupId1";
        pkg1.artifact = "myArtifactId1";
        pkg1.version = "1.0.0";

        MavenMinimalPackageDetails pkg2 = new MavenMinimalPackageDetails();
        pkg2.group = "myGroupId2";
        pkg2.artifact = "myArtifactId2";
        pkg2.version = "1.0.0";

        MavenPackagesBatchRequest packagesBatchRequest = new MavenPackagesBatchRequest();
        packagesBatchRequest.operation = PackagesBatchOperation.PROMOTE;
        packagesBatchRequest.data = Map.of("viewId", "Release");
        packagesBatchRequest.packages = List.of(pkg1, pkg2);


        // Promote packages to Release from the feed.
        maven.update("myFeed", packagesBatchRequest);

        // Delete packages from the feed and move it to the feed's recycle bin. (ViewId will be ignored))
        packagesBatchRequest.operation = PackagesBatchOperation.DELETE;
        maven.update("myFeed", packagesBatchRequest);

        // Permanently delete packages from a feed's recycle bin.
        packagesBatchRequest.operation = PackagesBatchOperation.PERMANENTDELETE;
        maven.update("myFeed", packagesBatchRequest);

        // Restore packages from the recycle bin to its associated feed.
        packagesBatchRequest.operation = PackagesBatchOperation.RESTORETOFEED;
        maven.update("myFeed", packagesBatchRequest);
    }
}
```