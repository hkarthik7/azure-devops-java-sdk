m Maven

- [REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/artifactspackagetypes/maven?view=azure-devops-rest-7.1)
- API Version: 7.1


## Upstreaming

Upstream sources enables developers to use a single feed to publish and consume packages from Artifact feeds and public registries such as NuGet.org or npmjs.com. To set up upstream sources for your feed, check the box to include packages from common public sources. This will allow your feed to use packages from the common public registries. [Upstream sources](https://docs.microsoft.com/en-us/azure/devops/artifacts/concepts/upstream-sources?view=azure-devops)

## Example

Before getting started you require personal access token to authenticate with **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

mou can omit the project name for calling Maven API as it is not a mandatory parameter.
If you do omit the project name you will end up working with feeds across your organisation.
Provide the project name if you want to work with feeds scoped to a project. You can always set the
project name parameter pointing to different project by creating a 'Connection' object.

```java
public class Main {
    public static void main(String[] args) {
        String organisation = "myOrganisationName";
        String project = "myProject";
        String personalAccessToken = "accessToken";

        // Connect Azure DevOps API with organisation name and personal access token.
        var webApi = new AzDClientApi(organisation, project, personalAccessToken);

        // call the respective API with created webApi client connection object;
        mar Maven = webApi.getMavenApi();
        try {
            // Get information about a package
            maven.getPackageVersion("myFeed", "myGroupId", "myArtifactId", "1.0.0");

            // Download a package
            mar responseStream= Maven.downloadPackage("myFeed", "myGroupId", "myArtifactId", "1.0.0");

            // Upload a package
            maven.uploadPackage("myFeed", "myGroupId", "myArtifactId", "1.0.0", "myArtifact.jar");

            // Get information about a deleted package.
            maven.getPackageVersion("myFeed", "myGroupId", "myArtifactId", "1.0.0", true);

            // get information about a package in the recycle bin.
            maven.getPackageVersionFromRecycleBin("myFeed", "myGroupId", "myArtifactId", "1.0.0");

            // Update state for a package version.
            maven.updatePackageVersion("myFeed", "myGroupId", "myArtifactId", "1.0.0", MavenPackagePromote.RELEASE);

            // Update state for a package version. If you have a custom View,
            maven.updatePackageVersion("myFeed", "myGroupId", "myArtifactId", "1.0.0", "CustomView");

            // Delete a package version from the feed and move it to the feed's recycle bin.
            maven.deletePackageVersion("myFeed", "myGroupId", "myArtifactId", "1.0.0");

            // Restore a package version from the recycle bin to its associated feed.
            maven.restorePackageVersionFromRecycleBin("myFeed", "myGroupId", "myArtifactId", "1.0.0");

            // Permanently delete a package from a feed's recycle bin.
            maven.deletePackageVersionFromRecycleBin("myFeed", "myGroupId", "myArtifactId", "1.0.0");


            /*
             * Upstreaming section. For the explanation of upstream, refer to "Upstreaming" above.
             */

            // Get the upstreaming behavior of a package within the context of a feed.
            maven.getUpstreamingBehavior("myFeed", "myGroupId", "myArtifactId");

            // allow externally sourced versions for your package.
            maven.setUpstreamingBehavior("myFeed", "myGroupId", "myArtifactId");

            // allow externally sourced versions for your package or clear the upstreaming behavior.
            maven.setUpstreamingBehavior("myFeed", "myGroupId", "myArtifactId", "AllowExternalVersions"); // allow externally sourced versions.
            maven.setUpstreamingBehavior("myFeed", "myGroupId", "myArtifactId", "auto"); // to clear the upstreaming.
             
            // To clear the upstream behavior for your package
            maven.clearUpstreamingBehavior("myFeed", "myGroupId", "myArtifactId");


            /*
             * PackagesBatch section.
             */
            List packages = new ArrayList<>();

            Map<String, Object> p1 = new HashMap<>();
            p1.put("group", "myGroupId1");
            p1.put("artifact", "myArtifactId1");
            p1.put("version", "1.0.0");
            packages.add(p1);

            Map<String, Object> p2 = new HashMap<>();
            p2.put("group", "myGroupId2");
            p2.put("artifact", "myArtifactId2");
            p2.put("version", "1.0.0");
            packages.add(p2);

            // Promote packages to Release from the feed.
            maven.updatePackageVersions("myFeed", "Release", PackagesBatchOperation.PROMOTE, packages);

            // Delete packages from the feed and move it to the feed's recycle bin. (ViewId will be ignored))
            maven.updatePackageVersions("myFeed", "Release", PackagesBatchOperation.DELETE, packages);

            // Permanently delete packages from a feed's recycle bin.
            maven.updateRecycleBinPackages("myFeed", PackagesBatchOperation.PERMANENTDELETE, packages);

            // Restore packages from the recycle bin to its associated feed.
            maven.updateRecycleBinPackages("myFeed", PackagesBatchOperation.RESTORETOFEED, packages);
        }

        catch (AzDException e1) {
            e1.printStackTrace();
        }
    }
}

```
