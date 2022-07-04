package org.azd;

import org.azd.build.types.BuildDefinition;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.AzDClient;
import org.azd.interfaces.BuildDetails;
import org.azd.utils.AzDClientApi;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class BuildApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static BuildDetails b;
    private static AzDClient webApi;
    private static int buildId;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        webApi = new AzDClientApi(organization, project, token);
        b = webApi.getBuildApi();
        buildId = b.getBuilds(1).getBuildResults().stream().findFirst().get().getId();
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteABuild() throws AzDException {
        b.deleteBuild(122);
    }

    @Test
    public void shouldGetABuild() throws AzDException {
        b.getBuild(buildId);
    }

    @Test
    public void shouldReturnABuildChanges() throws AzDException {
        b.getBuildChanges(buildId);
    }

    @Test
    public void shouldReturnABuildChangesWithOptionalParameters() throws AzDException {
        b.getBuildChanges(buildId, 10, "1", true);
    }

    @Test
    public void shouldReturnABuildLog() throws AzDException {
        b.getBuildLog(50, 3);
    }

    @Test
    public void shouldReturnABuildLogWithOptionalParameters() throws AzDException {
        b.getBuildLog(127, 3, 3, 6);
    }

    @Test
    public void shouldReturnBuildLogs() throws AzDException {
        b.getBuildLogs(buildId);
    }

    @Test
    public void shouldReturnBuildWorkItems() throws AzDException {
        b.getBuildWorkItems(buildId);
    }

    @Test
    public void shouldReturnBuildWorkItemsWithOptionalParameters() throws AzDException {
        b.getBuildWorkItems(buildId, 10);
    }

    @Test
    public void shouldReturnChangesBetweenBuilds() throws AzDException {
        b.getChangesBetweenBuilds(buildId, buildId, 10);
    }

    @Test
    public void shouldReturnWorkItemsBetweenBuilds() throws AzDException {
        b.getWorkItemsBetweenBuilds(buildId, buildId, 10);
    }

    @Test
    public void shouldReturnBuilds() throws AzDException {
        b.getBuilds();
    }

    @Test
    public void shouldReturnBuildsWithArrayOfBuildIds() throws AzDException {
        var builds = b.getBuilds().getBuildResults().stream()
                .mapToInt(x -> x.getId())
                .limit(2)
                .toArray();
        b.getBuilds(builds);
    }

    @Test
    public void shouldReturnTopTwoBuilds() throws AzDException {
        b.getBuilds(2);
    }

    @Test
    public void shouldQueueTheBuild() throws AzDException {
        b.queueBuild(22);
    }

    @Test
    public void shouldReturnListOfBuildController() throws AzDException {
        b.getBuildControllers();
    }

    @Test(expected = AzDException.class)
    public void shouldReturnABuildController() throws AzDException {
        // should throw an exception if build controller doesn't exists
        b.getBuildController(25);
    }

    @Test(expected = AzDException.class)
    public void shouldCreateBuildDefinition() throws AzDException {
        b.createBuildDefinition("");
    }

    @Test
    public void shouldDeleteABuildDefinition() throws AzDException {
        b.deleteBuildDefinition(13);
    }

    @Test
    public void shouldReturnBuildDefinition() throws AzDException {
        b.getBuildDefinition(b.getBuildDefinitions().getBuildDefinition().stream().findFirst().get().getId());
    }

    @Test
    public void shouldReturnBuildDefinitionWithOptionalParameters() throws AzDException {
        b.getBuildDefinition(b.getBuildDefinitions().getBuildDefinition().stream().findFirst().get().getId(), true, null, 2);
    }

    @Test
    public void shouldReturnBuildDefinitionRevisions() throws AzDException {
        b.getBuildDefinitionRevisions(b.getBuildDefinitions().getBuildDefinition().stream().findFirst().get().getId());
    }

    @Test
    public void shouldReturnBuildDefinitions() throws AzDException {
        b.getBuildDefinitions();
    }

    @Test
    public void shouldReturnBuildDefinitionsWithIds() throws AzDException {
        var defs = b.getBuildDefinitions().getBuildDefinition().stream()
                .mapToInt(BuildDefinition::getId)
                .limit(2)
                .toArray();
        b.getBuildDefinitions(defs);
    }

    @Test
    public void shouldReturnTopTwoBuildDefinitions() throws AzDException {
        b.getBuildDefinitions(2);
    }

    @Test
    public void shouldReturnBuildDefinitionsWithName() throws AzDException {
        b.getBuildDefinitions(b.getBuildDefinitions().getBuildDefinition().stream().findFirst().get().getName());
    }

    @Test(expected = AzDException.class)
    public void shouldRestoreBuildDefinition() throws AzDException {
        b.restoreBuildDefinition(126, false);

    }

    @Test
    public void shouldAddABuildTag() throws AzDException {
        b.addBuildTag(buildId, "Demo");
    }

    @Test
    public void shouldAddBuildTags() throws AzDException {
        b.addBuildTags(buildId, new String[]{"Demo", "CI", "Test"});
    }

    @Test
    public void shouldAddADefinitionTag() throws AzDException {
        b.addDefinitionTag(22, "TestDefinition");
    }

    @Test
    public void shouldAddDefinitionTags() throws AzDException {
        b.addDefinitionTags(22, new String[]{"TestDefinition", "DemoDefinition"});
    }

    @Test
    public void shouldDeleteABuildTag() throws AzDException {
        b.deleteBuildTag(buildId, "Test");
    }

    @Test
    public void shouldDeleteADefinitionTag() throws AzDException {
        b.deleteDefinitionTag(22, "DemoDefinition");
    }

    @Test
    public void shouldDeleteATag() throws AzDException {
        b.deleteTag("DemoDefinition");
    }

    @Test
    public void shouldGetBuildTags() throws AzDException {
        b.getBuildTags(buildId);
    }

    @Test
    public void shouldGetDefinitionTags() throws AzDException {
        b.getDefinitionTags(22);
    }

    @Test
    public void shouldGetTags() throws AzDException {
        b.getTags();
    }

    @Test
    public void shouldUpdateBuildTags() throws AzDException {
        b.updateBuildTags(buildId, new String[]{"Demo", "CI", "Test"}, false);
    }

    @Test
    public void shouldUpdateDefinitionTags() throws AzDException {
        b.updateDefinitionTags(22, new String[]{"TestDefinition", "DemoDefinition"}, false);
    }

    @Test
    public void shouldGetYamlBuildForADefinition() throws AzDException {
        b.getYaml(22).getYaml();
    }

    @Test(expected = AzDException.class)
    public void shouldGetSourceProvidersFileContents() throws AzDException {
        b.getFileContents("Github", "a7054ra9-0a34-46ac-bfdf-b8a1da865tdfd6",
                "hkarthik7/PSDB", "master", "LICENSE");
    }

    @Test(expected = AzDException.class)
    public void shouldGetSourceProvidersPathContents() throws AzDException {
        b.getPathContents("Github", "a7054ra9-0a34-46ac-bfdf-b8a1da865tdfd6",
                "hkarthik7/PSDB", "master", "/");
    }

    @Test(expected = AzDException.class)
    public void shouldGetSourceProvidersPullRequest() throws AzDException {
        b.getPullRequest("Github", "2",
                "hkarthik7/PSDB", "a7054ra9-0a34-46ac-bfdf-b8a1da865tdfd6");
    }

    @Test
    public void shouldGetSourceProviders() throws AzDException {
        b.getSourceProviders();
    }

    @Test(expected = AzDException.class)
    public void shouldGetSourceProvidersBranches() throws AzDException {
        b.getBranches("Github", "a7054ra9-0a34-46ac-bfdf-b8a1da865tdfd6", "hkarthik7/PSDB");
    }

    @Test(expected = AzDException.class)
    public void shouldGetSourceProvidersRepositories() throws AzDException {
        b.getRepositories("Github", "a7054ra9-0a34-46ac-bfdf-b8a1da865tdfd6");
    }

    @Test(expected = AzDException.class)
    public void shouldGetSourceProvidersWebhooks() throws AzDException {
        b.getWebHooks("Github", "a7054ra9-0a34-46ac-bfdf-b8a1da865tdfd6", "hkarthik7/PSDB");
    }

    @Test()
    public void shouldGetBuildTimelines() throws AzDException {
        b.getTimeline(buildId);
    }

    @Test()
    public void shouldGetBuildTimelinesWithTimelineId() throws AzDException {
        var timeline = b.getTimeline(buildId);
        b.getTimeline(buildId, timeline.getId());
    }

    @Test()
    public void shouldGetBuildTimelinesWithChangeAndPlanId() throws AzDException {
        var timeline = b.getTimeline(buildId);
        b.getTimeline(buildId, timeline.getId(), timeline.getChangeId(), null);
    }
}
