# Universal

- [REST API](https://learn.microsoft.com/en-us/rest/api/azure/devops/artifactspackagetypes/universal?view=azure-devops-rest-7.1)
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

        UniversalRequestBuilder uPack = client.artifactsPackageTypes().universal(p -> p.excludeProject);
        // OR
        UniversalRequestBuilder uPack = client.artifactsPackageTypes().universal();

        // Get information about a package
        uPack.get(r ->
        {
            r.packageVersion = "1.0.0";
            r.packageName = "myPackage";
            r.feedId = "myFeed";
        });

        // Get information about a deleted package.
        uPack.get(r ->
        {
            r.packageVersion = "1.0.0";
            r.packageName = "myPackage";
            r.feedId = "myFeed";
        }, s -> s.showDeleted);

        // get information about a package in the recycle bin.
        uPack.recycleBin().get(r ->
        {
            r.feedId = "myFeed";
            r.packageVersion = "1.0.0";
            r.packageName = "myPackage";
        });

        // Update state for a package version.
        JsonPatchDocument views = new JsonPatchDocument();
        views.setOperation(PatchOperation.ADD);
        views.setPath("/views/-");
        views.setValue(PackagePromote.RELEASE);

        PackageVersionDetails packageVersionDetails = new PackageVersionDetails();
        packageVersionDetails.views = views;

        uPack.update(r ->
        {
            r.feedId = "myFeed";
            r.packageVersion = "1.0.0";
            r.packageName = "myPackage";
        }, packageVersionDetails);

        // Update state for a package version. If you have a custom View,
        JsonPatchDocument views = new JsonPatchDocument();
        views.setOperation(PatchOperation.ADD);
        views.setPath("/views/-");
        views.setValue("CustomView");

        PackageVersionDetails packageVersionDetails = new PackageVersionDetails();
        packageVersionDetails.views = views;

        uPack.update(r ->
        {
            r.feedId = "myFeed";
            r.packageVersion = "1.0.0";
            r.packageName = "myPackage";
        }, packageVersionDetails);

        // Delete a package version from the feed and move it to the feed's recycle bin.
        uPack.delete(r ->
        {
            r.feedId = "myFeed";
            r.packageVersion = "1.0.0";
            r.packageName = "myPackage";
        });

        // Restore a package version from the recycle bin to its associated feed.
        UPackRecycleBinPackageVersionDetails packageVersionDetails = new UPackRecycleBinPackageVersionDetails();
        packageVersionDetails.deleted = false;

        uPack.recycleBin().restore(packageVersionDetails, r ->
        {
            r.feedId = "myFeed";
            r.packageVersion = "1.0.0";
            r.packageName = "myPackage";
        });

        // Permanently delete a package from a feed's recycle bin.
        uPack.recycleBin().delete(r ->
        {
            r.feedId = "myFeed";
            r.packageVersion = "1.0.0";
            r.packageName = "myPackage";
        });

        /*
         * PackagesBatch section.
         */

        MinimalPackageDetails p1 = new MinimalPackageDetails();
        p1.id = "myPackageName1";
        p1.version = "1.0.0";

        MinimalPackageDetails p2 = new MinimalPackageDetails();
        p2.id = "myPackageName2";
        p2.version = "1.0.0";

        UPackPackagesBatchRequest batchRequest = new UPackPackagesBatchRequest();
        batchRequest.packages = List.of(p1, p2);
        
        // Promote packages to Release from the feed.
        batchRequest.operation = PackagesBatchOperation.PROMOTE;
        uPack.update("myFeed", batchRequest);

        // Delete packages from the feed and move it to the feed's recycle bin. (ViewId will be ignored))
        batchRequest.operation = PackagesBatchOperation.DELETE;
        uPack.update("myFeed", batchRequest);

        // Permanently delete packages from a feed's recycle bin.
        batchRequest.operation = PackagesBatchOperation.PERMANENTDELETE;
        uPack.update("myFeed", batchRequest);

        // Restore packages from the recycle bin to its associated feed.
        batchRequest.operation = PackagesBatchOperation.RESTORETOFEED;
        uPack.update("myFeed", batchRequest);
    }
}
```