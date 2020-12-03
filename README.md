# azure-devops-java-sdk

[![Build Status](https://dev.azure.com/harishkarthic/azure-devops-java-sdk/_apis/build/status/hkarthik7.azure-devops-java-sdk?branchName=main)](https://dev.azure.com/harishkarthic/azure-devops-java-sdk/_build/latest?definitionId=8&branchName=main)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://github.com/hkarthik7/azure-devops-java-sdk/blob/main/LICENSE)
[![Download: azd](https://img.shields.io/github/downloads/hkarthik7/azure-devops-java-sdk/total.svg)](https://github.com/hkarthik7/azure-devops-java-sdk/releases/download/v0.1.0/azd-0.1.0.jar)

**azd** SDK helps to manage **Azure DevOps** REST API on ease. This provides functionality to significant services 
in **Azure DevOps** to manage in granular level.

Usage of the functions and examples can be found [here](https://github.com/hkarthik7/azure-devops-java-sdk/blob/main/examples).

## Getting Started

Download the sdk from [here](https://github.com/hkarthik7/azure-devops-java-sdk/releases/download/v0.1.0/azd-0.1.0.jar).

- Get the list of projects for your organisation

```java

public class Main {
    public static void main(String[] args) {
        String organisation = "myOrganisationName";
        String personalAccessToken = "accessToken";
        
        // instantiate AzDDefaultParameters with organisation name, project and personal access token.
        AzDDefaultParameters defaultParameters = new AzDDefaultParameters(organisation, personalAccessToken);
    
        // call API with the default parameters;
        Core core = new Core(defaultParameters);
        try {
            // get the list of projects
            core.getProjects();
            
            // create a new project
            core.createProject("my-new-project", "Finance management");
            
            // create a team in the project
            core.createTeam("my-new-project", "my-new-team");
        
            // list all the teams
            core.getTeams();
        } catch (IOException | DefaultParametersException e1) {
            e1.printStackTrace();
        }
    }

}
```

## Release Notes

- [Change Log](CHANGELOG.md)

## Dependencies

| NAME | VERSION |
|---|---|
| com.fasterxml.jackson.core | v2.12.0 |

## Build Locally

Clone the repository and navigate to root of the folder where `pom.xml` is placed.
- Run `mvn clean` to clean the target folder if any exists
- Update `_unitTest.json` with your organisation name, project name and personal access token.
- Run `mvn test` to run unit tests
- Run `mvn package` to install the dependencies and create the resultant `.jar` file.

## License

This project is licensed under [MIT](LICENSE)

## Contributors

See [Contribution Guidelines](.github/CONTRIBUTING.md)

