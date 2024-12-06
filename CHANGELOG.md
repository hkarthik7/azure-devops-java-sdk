# Changelog

# 6.0.1

- Added support for TestCaseResult in **TestApi**.

# 6.0.0

**Major release**
**Breaking changes**

- Pagination
- Proxy configuration
- Automatic retry
- Fluent Api syntax
- Issue: [#69](https://github.com/hkarthik7/azure-devops-java-sdk/issues/69)
- PR: [Feature/v6.0 #75](https://github.com/hkarthik7/azure-devops-java-sdk/pull/75)

# 5.0.13

**Minor Incremental Release**
- Bumped dependency version.

# 5.0.12

**Minor Incremental Release**
- Fix issue: [VariableGroupMap always assign the same value to variables #73](https://github.com/hkarthik7/azure-devops-java-sdk/issues/73)

# 5.0.11

**Minor Incremental Release**
- Fix issue: [GitPullRequest getCommits() is always null #71](https://github.com/hkarthik7/azure-devops-java-sdk/issues/71)
- Fix issue: [CVE "sonatype-2022-6438" #72](https://github.com/hkarthik7/azure-devops-java-sdk/issues/72)


# 5.0.10

**Minor Incremental Release**
- Fix issue: [[Improvement] Add ability for GitApi.getRepositories() to include hidden repositories #68](https://github.com/hkarthik7/azure-devops-java-sdk/issues/68)

# 5.0.9

**Minor Incremental Release**
- Fix issue: [How to get the get the team capacity? #66](https://github.com/hkarthik7/azure-devops-java-sdk/issues/66)
- Fix issue: [[Feature] Missing Pull Request Statuses object #64](https://github.com/hkarthik7/azure-devops-java-sdk/issues/64)
- Fix issue: [Do you support pagination with the continuationToken #63](https://github.com/hkarthik7/azure-devops-java-sdk/issues/63)

## 5.0.8

**Minor Incremental Release**
- Fix issue: [Git push does not work because JSON output does not match examples #61](https://github.com/hkarthik7/azure-devops-java-sdk/issues/61)
- Merged PR: [Add version to the query #60](https://github.com/hkarthik7/azure-devops-java-sdk/pull/60)
- Merged PR: [Fix git change item and ignore null values #62](https://github.com/hkarthik7/azure-devops-java-sdk/pull/62)

## 5.0.7

**Minor Incremental Release**
- Fix issue: [GitRepository does not support repositories with size greater than 2147483647 bytes](https://github.com/hkarthik7/azure-devops-java-sdk/issues/52)
- Fix issue: [Add ability to get Retry-After value in response header](https://github.com/hkarthik7/azure-devops-java-sdk/issues/54)
- Merged PR: [Fix issue 52, change size field from Integer to Long](https://github.com/hkarthik7/azure-devops-java-sdk/pull/53)
- Merged PR: [Fix parsing exception](https://github.com/hkarthik7/azure-devops-java-sdk/pull/57)
- Fix issue: [Parsing exception for ReleaseDefinition that has an an Environment that has Conditions.](https://github.com/hkarthik7/azure-devops-java-sdk/issues/56)
- Merged PR: [Add mechanism to get Retry-After value in response header](https://github.com/hkarthik7/azure-devops-java-sdk/pull/55)

## 5.0.6

- Support to **TestApi**. This introduces support to Test runs in the TestApi.
- Addresses issue [Json mapping issue when trying to read builds that couldn't run #48](https://github.com/hkarthik7/azure-devops-java-sdk/issues/48)
- Addresses issue [Documentation of RestClient or Unit tests of RestClient needed #49](https://github.com/hkarthik7/azure-devops-java-sdk/issues/49)
  - Documentation: https://azure-devops-java-sdk-docs.readthedocs.io/en/latest/docs/tutorial/
  - Tests: https://github.com/hkarthik7/azure-devops-java-sdk/blob/main/azd/src/test/java/org/azd/RestClientTest.java
- Added support to **Pushes** in **GitApi.**
- Address issue [Push Changes Feature #50](https://github.com/hkarthik7/azure-devops-java-sdk/issues/50).

## 5.0.5
**Minor Incremental Release**
- Updated jackson-databind dependency version.
- Update to **GitApi**, create pull request from pull request object.
- Bug fix for issue [Json mapping issue when trying to read builds that couldn't run #48](https://github.com/hkarthik7/azure-devops-java-sdk/issues/48)

## 5.0.4
- Add support git forks
- Merged PR: [Add support git forks, #47](https://github.com/hkarthik7/azure-devops-java-sdk/pull/47)
- Merged PR: [Issue #42 Add lasteRefreshedOn variable #45](https://github.com/hkarthik7/azure-devops-java-sdk/pull/45)
- Merged PR: [fix downloadPackage exception handling #44](https://github.com/hkarthik7/azure-devops-java-sdk/pull/44)
- Bug fix for OAuthApi methods `getAccessToken` and `getRefreshToken`.

## 5.0.3

- Added support for GitRefs, GitTag in **GitApi**.
- Merged PR: [Can I implement deleteTag or deleteBranch method? #27](https://github.com/hkarthik7/azure-devops-java-sdk/issues/27)
- Added uploadPackage method in **MavenApi**.
- Merged PR: [Fix Release Condition conditionType Issue #39 #40](https://github.com/hkarthik7/azure-devops-java-sdk/pull/40)

## 5.0.2

- Changes in **WikiApi**
  - Bug fix for **getPageStats()** method.
  - Change the type parameters for **createWiki()** method. Now **createWiki()** allows creating project and code wiki.
  - Support for managing project wiki in all methods.
- Update for **GitApi**
  - Added support for Git Blobs and Git Items Api.  


## 5.0.1

- Expanded support for **ReleaseApi**.
- Bug fix for **updateReleaseEnvironment** in **ReleaseApi**.
- Added **ResourceId** class that contains the resource ids of all services.
- Bug fix for issue [MIssing visibility enum value #38](https://github.com/hkarthik7/azure-devops-java-sdk/issues/38).
- Extended support for **WikiApi**


## 5.0.0

**Breaking changes**

**Changes to Build and BuildDefinition types**

- Enable feature management for project services (i.e. Test Plans, Boards, etc).
- Merged PR: [implement featureManagement to enable / disable project services #33 #34](https://github.com/hkarthik7/azure-devops-java-sdk/pull/34)
- Expanded support for **BuildApi**.
  - Bug fix for `cloneBuildDefinition` method
  - Added `updateBuild` and `updateBuilds`
  - Manage `Folder` Api
- Expanded support for **WorkItemTrackingApi**.
  - Added methods `createAttachment`, `getAttachmentAsZip` and `getAttachmentContent` for better management of
  Workitem attachments Api.
  - `createAttachment` and `getAttachment` methods are deprecated. New methods returns an `InputStream` and 
    `StreamHelper` can be used to download or convert it to string etc.  
- Updated `downloadPackage` in **MavenApi**.
- **StreamHelper** class to download contents from Api response.
- Type change for `updateReleaseDefinition` in **ReleaseApi** for ease of use.
- Added support for `Queries` Api in `Work item tracking`.
  
- `BaseClient` and `Client` classes are deprecated. Instead, introduced `BaseRestClient` and `RestClient` classes for
ease of use in other concrete Api implementations.
  

## 4.0.0

**Breaking changes**

- Added GraphEntity as parent of GraphUser and GraphGroup
- Minor risk if extending from GraphUser or GraphGroup
- Merged PR: [Refactor GraphEntity as parent of GraphUser and GraphGroup #32](https://github.com/hkarthik7/azure-devops-java-sdk/pull/32)
- Implement **Security API** and **Identity API** functionality
  - query security namespaces
  - query access control lists
  - set / remove access control lists
  - set / remove access control entries
  - read identity descriptors (convert from user / group descriptors)
- Merged PR: [Added support for Git tag #31](https://github.com/hkarthik7/azure-devops-java-sdk/pull/31)
- Merged PR: [Implement **Security API** and **Identity API** functionality #30](https://github.com/hkarthik7/azure-devops-java-sdk/pull/30)
- Expanded the GitApi to get the branches of a repository, or a specific branch from a repository based on the branch name.
- Merged PR: [Getting repository branches support #35](https://github.com/hkarthik7/azure-devops-java-sdk/pull/35)

## 3.0.4

- Updated Api version from 6.x to 7.x.
- Merged PR: [Added support for maven api #20](https://github.com/hkarthik7/azure-devops-java-sdk/pull/20)
- **MavenApi** supports
    - `getPackageVersion`
    - `getPackageVersionFromRecycleBin`
    - `getUpstreamingBehavior`
    - `deletePackageVersion`
    - `deletePackageVersionFromRecycleBin`
    - `updatePackageVersion`
    - `updatePackageVersions`
    - `updateRecycleBinPackages`
    - `restorePackageVersionFromRecycleBin`
    - `setUpstreamingBehavior`
    - `clearUpstreamingBehavior`
- Added support for timeline in **BuildApi**.
- Extended functionality of **Graph API**.
  - get members of a group
  - get groups a user (or nested group) is a member of
  - add nested group membership
  - remove membership
  - create/delete group
  - resolve resource descriptor from storageKey
  - resolve graph resources from descriptors
- Merged PR: [Added remain Maven API, update test #22](https://github.com/hkarthik7/azure-devops-java-sdk/pull/22)
- Merged PR: [Feature/upack #24](https://github.com/hkarthik7/azure-devops-java-sdk/pull/24)
- Merged PR: [Added support for Attachments in WorkItemTrackingApi. #25](https://github.com/hkarthik7/azure-devops-java-sdk/pull/25)
- Merged PR: [GraphAPI enhancements. #26](https://github.com/hkarthik7/azure-devops-java-sdk/pull/26)
- Fix:
  - Feed type to fix json parse error on create
  - feed update key changed from name to id (req'd for PATCH call)

## 3.0.3

- Addressed issue: [browsing repository content #15](https://github.com/hkarthik7/azure-devops-java-sdk/issues/15)
- Added support for **Source Providers** in **BuildApi**.
- Updated dependency jackson-databind version.

## 3.0.2

**Minor incremental release**
- Merged PR: [Issue #13: Change size from int to long #14](https://github.com/hkarthik7/azure-devops-java-sdk/pull/14)
- Extended support for **Git Api**.

## 3.0.1

- Bug fix for executor service in **AzDAsyncApi**.

## 3.0.0

**Breaking changes**
- Removed **ConnectionException** class as it is not used anymore.  
- Extended functionality of **Release Api**.
  - Delete and Update a release
  - Manage release environments
  - Kick off a release pipeline using `queueRelease` method
  - Approve a release
  - Update the manual intervention for a release
- Extended functionality of **Build Api**.
  - Get the `yaml` for a designer build pipeline
  - Update a stage or all stages in the build pipeline
- Change in input parameters for **createSubscription** in **ServiceHooksApi**.
  - **createSubscription** method is tied to type **ServiceHooks** that extracts the parameters from it.
- Added **AzDAsyncApi** that helps to create asynchronous operation across all the methods in the library.

## 2.5.9
- Expanded the WorkItemTrackingDetails interface with two updateWorkItem
  methods and added hyperlinks support. [Associated PR](https://github.com/hkarthik7/azure-devops-java-sdk/pull/10)
- Added support for **Distributed Task Api**

## 2.5.8
- Merged PR: [Added support for **policy Api** #8](https://github.com/hkarthik7/azure-devops-java-sdk/pull/8)
- Merged PR: [Added support for **build tags** API #9](https://github.com/hkarthik7/azure-devops-java-sdk/pull/9)
- Added support for Pipelines API.

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
- **Connection** class automatically refreshes the token if it's expired.
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
