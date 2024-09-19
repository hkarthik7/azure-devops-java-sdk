# Extension Management

- [REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/extensionmanagement/installed-extensions?view=azure-devops-rest-6.1)
- API Version: 6.1-preview

## Example

Before getting started you require personal access token to authenticate with **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

To install, uninstall and update an extension, publisher id and extension id are mandatory. To get the publisher and extension id, head over to 
the Marketplace and select the extension that you want to install and check for **itemName=<publisherId.extensionId>** in the URL

For instance, checkout the example below that shows how to get the ids for Sonar qube extension.

![SonarQube Extension](media/Sonarqube.PNG)

```java
public class Main {
    public static void main(String[] args) {
        String organisation = "myOrganisationName";
        String project = "myProject";
        String personalAccessToken = "accessToken";

        // Connect Azure DevOps API with organisation name and personal access token.
        var webApi = new AzDClientApi(organisation, project, personalAccessToken);

        // call the respective API with created webApi client connection object;
        var extensions = webApi.getExtensionManagementApi();
        try {
            // install an extension
            // if the version is null then latest version will be installed.
            extensions.installExtension("SonarSource", "sonarqube", null);
            
            // uninstall an extension
            extensions.uninstallExtension("SonarSource", "sonarqube");
            
            // update and extension. (Enable/disable an extension)
            // disable an extension
            extensions.updateExtension("SonarSource", "sonarqube", ExtensionStateFlags.DISABLED);
            
            // enable an extension
            extensions.updateExtension("SonarSource", "sonarqube", ExtensionStateFlags.NONE);
            
            // get an extension by it's id
            extensions.getExtension("sonarqube", "SonarSource");
            
            // list all the available extensions
            extensions.getExtensions();

        } 
        catch (AzDException e1) {
            e1.printStackTrace();
        }
    }
}

``` 
