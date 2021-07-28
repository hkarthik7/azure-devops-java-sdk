## azure-devops-java-sdk requirements checklist:
    
- The package name should reflect the service/resource that should be wrapped
- **types** package holds all the return types
- Class name should be suffixed with *Api*
- Update the Api version in `ApiVersion` file
- A contract should exist for each class (interface) and all the supported functionalities should be declared
- All the custom types (enums) should be placed under **enums** package
- Unit test should be written for each method

## Release / Deploy

- Update **CHANGELOG.md**
- Update **pom.xml** with new version