# Universal Package

- [REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/artifactspackagetypes/universal?view=azure-devops-rest-7.1)
- API Version: 7.1

## Example

Before getting started you require personal access token to authenticate with **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

You can omit the project name for calling Universal Package API as it is not a mandatory parameter.
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
        var upack = webApi.getUPackApi();
        try {
            // Get information about a package
            upack.getPackageVersion("myFeed", "myPackageName", "1.0.0");

            // Download a package (to be implemented)
            //upack.downloadPackage("myFeed", "myPackageName", "1.0.0");

            // Get information about a deleted package.
            upack.getPackageVersion("myFeed", "myPackageName", "1.0.0", true);

            // get information about a package in the recycle bin.
            upack.getPackageVersionFromRecycleBin("myFeed", "myPackageName", "1.0.0");

            // Update state for a package version.
            upack.updatePackageVersion("myFeed", "myPackageName", "1.0.0", PackagePromote.RELEASE);

            // Update state for a package version. If you have a custom View,
            upack.updatePackageVersion("myFeed", "myPackageName", "1.0.0", "CustomView");

            // Delete a package version from the feed and move it to the feed's recycle bin.
            upack.deletePackageVersion("myFeed", "myPackageName", "1.0.0");

            // Restore a package version from the recycle bin to its associated feed.
            upack.restorePackageVersionFromRecycleBin("myFeed", "myPackageName", "1.0.0");

            // Permanently delete a package from a feed's recycle bin.
            upack.deletePackageVersionFromRecycleBin("myFeed", "myPackageName", "1.0.0")

            /*
             * PackagesBatch section.
             */
            List packages = new ArrayList<>();

            Map<String, Object> p1 = new HashMap<>();
            p1.put("id", "myPackageName1");
            p1.put("version", "1.0.0");
            packages.add(p1);

            Map<String, Object> p2 = new HashMap<>();
            p2.put("id", "myPackageName2");
            p2.put("version", "1.0.0");
            packages.add(p2);

            // Promote packages to Release from the feed.
            upack.updatePackageVersions("myFeed", "Release", PackagesBatchOperation.PROMOTE, packages)

            // Delete packages from the feed and move it to the feed's recycle bin. (ViewId will be ignored))
            upack.updatePackageVersions("myFeed", "Release", PackagesBatchOperation.DELETE, packages)

            // Permanently delete packages from a feed's recycle bin.
            upack.updateRecycleBinPackages("myFeed", PackagesBatchOperation.PERMANENTDELETE, packages)

            // Restore packages from the recycle bin to its associated feed.
            upack.updateRecycleBinPackages("myFeed", PackagesBatchOperation.RESTORETOFEED, packages)
        }

        catch (AzDException e1) {
            e1.printStackTrace();
        }
    }
}

```
