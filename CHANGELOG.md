# Changelog

## 2.5.8
- Merged PR: [Added support for **policy Api** #8](https://github.com/hkarthik7/azure-devops-java-sdk/pull/8)
- Merged PR: [Added support for **build tags** API #9](https://github.com/hkarthik7/azure-devops-java-sdk/pull/9)

## 2.5.7
- Created a helper method in **BuildApi** to easily create/clone a pipeline.
- Added functionality for managing pull request tags/labels.
- Added functionality for managing pull request reviewers. 

## 2.5.6
- Merged PR: [Added support to **Service Endpoint Api** #6](https://github.com/hkarthik7/azure-devops-java-sdk/pull/6)
- Added Wiki example
- Added support to **Extension management Api**

## 2.5.5
- Introduced **AzDClientApi** to easily create the connection object and call respective API.
- Added support to **OAuth2**. 
- Merged PR: [Connection using oauth token #5](https://github.com/hkarthik7/azure-devops-java-sdk/pull/5).
- Create the authorization endpoint, get the access token and refresh the access token using **OAuthApi**.
**Connection** class automatically refreshes the token if it's expired.
- Moved version details to a single class **ApiVersion**.
- Added support to **Accounts** Api.

## 2.4.5
- Bug fix for Workitems delete Api.
- Added support to retrieve releases from artifact version id (aka build id).
- Add createPullRequest method in GitApi to optionally create the pull request in draft mode.
- Added support to create and update workitems with additional fields.

## 2.4.4
**Minor incremental release**
- Added Pull requests services to GitApi. Retrieve workitems associated to a Pull request.
- Added types for Team and Project services under Core Api.

## 2.4.3

**Breaking changes**
- Changed the name of AzDDefaultParameters class to Connection.
- Renamed DefaultParametersException to ConnectionException.
- Moved resource area identifiers to its respective classes.
- Added support for Wiki, Graph and Member Entitlement Management Apis.
- Removed Url class and added buildUrl function within Client class.

## 1.4.3

- Bug fix for ServiceHooksApi
- Added Release definition Api services
- Workitem request body type for easily creating workitems.

## 1.4.2

- Added support for Service hooks and Release Api.
- Merged PR: [read non-system workitem fields as "other fields" in a map (#4)](https://github.com/hkarthik7/azure-devops-java-sdk/pull/4)
- Removed stale properties from WorkitemFields

## 1.3.1

- Changes to name of the main Apis.
- Added types & definitions.

## 1.2.1

- Major changes 
   - for exception handling
   - Decoupled classes by introducing interfaces. This helps to indicate what we support.
   - Added tests.
   - Added WorkApi and WorkItems Api.

## 0.2.1

- Changes to exception handling
- Added functions to manage pull requests in Git API call
- Bug fix in setting environment variables

## 0.1.0

SDK initial release.