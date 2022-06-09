# azure-devops-java-sdk

[![Build Status](https://dev.azure.com/harishkarthic/azure-devops-java-sdk/_apis/build/status/hkarthik7.azure-devops-java-sdk?branchName=main)](https://dev.azure.com/harishkarthic/azure-devops-java-sdk/_build/latest?definitionId=8&branchName=main)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://github.com/hkarthik7/azure-devops-java-sdk/blob/main/LICENSE)
[![Documentation Status](https://readthedocs.org/projects/azure-devops-java-sdk-docs/badge/?version=latest)](https://azure-devops-java-sdk-docs.readthedocs.io/en/latest/?badge=latest)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.hkarthik7/azd.svg)](https://search.maven.org/artifact/io.github.hkarthik7/azd/3.0.4/jar)

**azd** library helps to manage **Azure DevOps** REST API with ease. This provides functionality to the significant services 
in **Azure DevOps** and manage in granular level.

The extension method `.createAsync()` is available for all the Apis in the sdk and returns a **CompletableFuture** object on the method that is called.

You can view the [blog post](https://hkarthik7.github.io/azure%20devops/2020/12/04/AzureDevOpsJavaSDK.html) for details about the library.

## Documentation

- [Javadocs](https://hkarthik7.github.io/azd-docs/)
- [Examples](https://github.com/hkarthik7/azure-devops-java-sdk/blob/main/examples)
- [Read the docs](https://azure-devops-java-sdk-docs.readthedocs.io/en/latest/)

## Getting Started

To download the library and use it in your project, just add below in your pom.xml file.

```xml
<dependency>
  <groupId>io.github.hkarthik7</groupId>
  <artifactId>azd</artifactId>
  <version>3.0.4</version>
</dependency>
```
**Java docs**
```xml
<dependency>
    <groupId>io.github.hkarthik7</groupId>
    <artifactId>azd</artifactId>
    <version>3.0.4</version>
    <classifier>javadoc</classifier>
</dependency>
```

**Source jar**
```xml
<dependency>
    <groupId>io.github.hkarthik7</groupId>
    <artifactId>azd</artifactId>
    <version>3.0.4</version>
    <classifier>sources</classifier>
</dependency>
```

- Get the list of projects for your organisation

```java

public class Main {
    public static void main(String[] args) {
        String organisation = "myOrganisationName";
        String personalAccessToken = "accessToken";

        // Connect Azure DevOps API with organisation name and personal access token.
        var webApi = new AzDClientApi(organisation, personalAccessToken);

        // call the respective API with created webApi client connection object;
        var core = webApi.getCoreApi();
        try {
            // get the list of projects
            core.getProjects();
            
            // Get the list of projects asynchronously
            // This returns a CompletableFuture<List<Project>>
            var future = core.createAsync(core.getProjects().getProjects());

            System.out.println("Do something here...");

            var projects = future.join(); // Get the results
            
            projects.stream()
                    .map(Project::getName)
                    .forEach(System.out::println);
            
            // create a new project
            core.createProject("my-new-project", "Finance management");
            
            // create a team in the project
            core.createTeam("my-new-project", "my-new-team");
        
            // list all the teams
            core.getTeams();
        } catch (AzDException e1) {
            e1.printStackTrace();
        }
    }

}
```

- Easily clone a build pipeline

```java
public class Main {
    public static void main(String[] args) {
        String organisation = "myOrganisationName";
        String personalAccessToken = "accessToken";
        String projectName = "myProject";

        // Connect Azure DevOps API with organisation name and personal access token.
        var webApi = new AzDClientApi(organisation, projectName, personalAccessToken);

        // call the respective API with created webApi client connection object;
        var build = webApi.getBuildApi();
        try {
            // Clone an existing pipeline with the pipeline name
            String ciName = "DeployTo-WebApp-CI";
            String ciCloneName = "DeployTo-WebApp-CI-Copy";
            
            build.cloneBuildDefinition(ciName, ciCloneName);
            
        } catch (AzDException e1) {
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

You are going to need JDK version 11 or above and can be downloaded from [here](https://www.oracle.com/java/technologies/javase-downloads.html).
Download Maven from the [official website](https://maven.apache.org/download.cgi). Once it is installed add `JAVA_HOME` to the path as Maven is
going to need it. You can check if Maven is installed correctly by running `mvn -v`.

Once you have installed `JDK` and `Maven` you can then, 

Clone the repository and navigate to root of the folder where `pom.xml` is placed.
- Run `mvn clean` to clean the target folder if any exists
- Update `_unitTest.json` with your organisation name, project name and personal access token.
- Run `mvn test` to run unit tests
- Run `mvn package` to install the dependencies and create the resultant `.jar` file.

## License

This project is licensed under [MIT](LICENSE)

## Contributors

See [Contribution Guidelines](.github/CONTRIBUTING.md)

