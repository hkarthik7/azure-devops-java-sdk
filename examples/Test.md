# Test

- [REST API](https://learn.microsoft.com/en-us/rest/api/azure/devops/test/test-cases?view=azure-devops-rest-7.2)
- API Version: 7.2

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

        // Create Test Result Attachment
        int runId = 49;
        int testCaseResultId = 100000;
        
        TestAttachmentRequestModel requestModel = new TestAttachmentRequestModel();
        requestModel.attachmentType = TestAttachmentType.GENERAL_ATTACHMENT;
        requestModel.comment = "Test attachment upload";
        requestModel.fileName = "textAsFileAttachment.txt";
        requestModel.stream = Utils.toBase64String(new File("/path/to/file.txt"));

        client.test().attachments().result().create(runId, testCaseResultId, requestModel);

        // Create Test Run Attachment
        TestAttachmentRequestModel requestModel = new TestAttachmentRequestModel();
        requestModel.attachmentType = TestAttachmentType.GENERAL_ATTACHMENT;
        requestModel.comment = "Test attachment upload";
        requestModel.fileName = "imageAsFileAttachment.png";
        requestModel.stream = Utils.toBase64String(new File("/path/to/image.png"));

        client.test().attachments().run().create(runId, requestModel);
        
        // Get Test Run Attachments
        client.test().attachments().run().list(23);

        int buildId = 363;
        int flag = 7;

        // Get Build Code Coverage
        client.test().codeCoverage().getBuildCodeCoverage(buildId, flag);

        // Get Test Run Code Coverage
        int runId = 51;
        int flag = 7;

        client.test().codeCoverage().getTestRunCodeCoverage(runId, flag);

        // Get Point
        int planId = 1;
        int pointIds = 123;
        int suiteId = 1;
        
        client.test().points().get(planId, pointIds, suiteId);
        
        // Get Points By Query
        TestPointsQuery query = new TestPointsQuery();
        TestPoint point7 = new TestPoint();
        point7.setId(7);
        TestPoint point8 = new TestPoint();
        point8.setId(8);
        TestPoint point9 = new TestPoint();
        point9.setId(9);

        query.setPoints(List.of(point7, point8, point9));
        client.test().points().getByQuery(query);

        client.test().points().list(planId, suiteId);

        // List points
        client.test().points().list(1,1, r -> {
            r.queryParameters.configurationId = "2";
            r.queryParameters.includePointDetails = true;
            r.queryParameters.witFields = "System.Title,System.Reason";
        });
        
        // Add test case results
        TestCaseResults results = new TestCaseResults();

        TestCaseResult verifyWebsiteTheme = new TestCaseResult();
        verifyWebsiteTheme.setTestCaseTitle("VerifyWebsiteTheme");
        verifyWebsiteTheme.setAutomatedTestName("FabrikamFiber.WebSite.TestClass.VerifyWebsiteTheme");
        verifyWebsiteTheme.setPriority(1);
        verifyWebsiteTheme.setOutcome("Passed");

        TestCaseResult verifyWebsiteLinks = new TestCaseResult();
        verifyWebsiteLinks.setTestCaseTitle("VerifyWebsiteLinks");
        verifyWebsiteLinks.setAutomatedTestName("FabrikamFiber.WebSite.TestClass.VerifyWebsiteLinks");
        verifyWebsiteLinks.setPriority(2);
        verifyWebsiteLinks.setOutcome("Failed");

        ShallowReference associatedBug = new ShallowReference();
        associatedBug.setId("30");

        verifyWebsiteLinks.setAssociatedBugs(List.of(associatedBug));

        results.setResults(List.of(verifyWebsiteLinks, verifyWebsiteTheme));

        client.test().results().create(runId, results);
        
        // Update test case results
        TestCaseResults results = new TestCaseResults();

        TestCaseResult failedTestCase = new TestCaseResult();
        failedTestCase.setId(100000);
        failedTestCase.setState("Completed");
        failedTestCase.setComment("Website theme is looking good");

        ShallowReference associatedBug = new ShallowReference();
        associatedBug.setId("30");

        failedTestCase.setAssociatedBugs(List.of(associatedBug));

        TestCaseResult knownIssueTestCase = new TestCaseResult();
        knownIssueTestCase.setId(100001);
        knownIssueTestCase.setState("Completed");
        knownIssueTestCase.setComment("Website links are failing because of incorrect container id");
        knownIssueTestCase.setFailureType("Known Issue");

        results.setResults(List.of(failedTestCase, knownIssueTestCase));

        client.test().results().update(runId, results);
        
        // Create test runs
        RunCreateModel createModel = new RunCreateModel();
        createModel.setName("NewTestRun");

        ShallowReference plan = new ShallowReference();
        plan.setId("1");

        createModel.setPlan(plan);
        createModel.setPointIds(List.of(1, 1));

        client.test().runs().create(createModel);

        // Get Test Run By Id
        client.test().runs().get(runId);

        // Get Test Run Statistics
        client.test().runs().getStatistics(runId);
        
        // List test runs
        client.test().runs().list();
        
        // Update a test run
        TestRun testRun = client.test().runs().get(runId);
        testRun.setName("NewTestRun2");
        testRun.setComment("This test run is doomed");

        client.test().runs().update(runId, testRun);
        
        // Create a test session
        TestSession session = new TestSession();
        session.setTitle("Sample TestSession");

        ShallowReference area = new ShallowReference();
        area.setName("my-project-team");

        session.setArea(area);

        client.test().session().create("my-project-team", session);
        
        // List all sessions
        client.test().session().list("my-project-team", r -> {
            r.queryParameters.allSessions = true;
            r.queryParameters.includeAllProperties = true;
        });
        
        // Update a test session
        TestSessions sessions = client.test().session().list("my-project-team");

        TestSession session = sessions.getTestSessions().get(0);
        session.setTitle("Sample TestSession");

        ShallowReference area = new ShallowReference();
        area.setName("my-project-team");

        session.setArea(area);

        session.setId(4);
        session.setComment("Test session comment");
        session.setState(TestSessionState.PAUSED);
        session.setRevision(1);

        client.test().session().update("my-project-team", session);

        // Note that all the result objects has getResponse() which returns ApiResponse object.
        // This contains the request information, request url, raw response, response headers.

        ApiResponse response = client.accounts().profile().get().getResponse();
        
    }
}
```