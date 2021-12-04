package org.azd;

import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
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
    public void init() throws AzDException, ConnectionException {
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
    public void shouldDeleteABuild() throws ConnectionException, AzDException {
        b.deleteBuild(122);
    }

    @Test
    public void shouldGetABuild() throws ConnectionException, AzDException {
        b.getBuild(buildId);
    }

    @Test
    public void shouldReturnABuildChanges() throws ConnectionException, AzDException {
        b.getBuildChanges(buildId);
    }

    @Test
    public void shouldReturnABuildChangesWithOptionalParameters() throws ConnectionException, AzDException {
        b.getBuildChanges(buildId, 10, "1", true);
    }

    @Test
    public void shouldReturnABuildLog() throws ConnectionException, AzDException {
        b.getBuildLog(50, 3);
    }

    @Test
    public void shouldReturnABuildLogWithOptionalParameters() throws ConnectionException, AzDException {
        b.getBuildLog(127, 3, 3, 6);
    }

    @Test
    public void shouldReturnBuildLogs() throws ConnectionException, AzDException {
        b.getBuildLogs(buildId);
    }

    @Test
    public void shouldReturnBuildWorkItems() throws ConnectionException, AzDException {
        b.getBuildWorkItems(buildId);
    }

    @Test
    public void shouldReturnBuildWorkItemsWithOptionalParameters() throws ConnectionException, AzDException {
        b.getBuildWorkItems(buildId, 10);
    }

    @Test
    public void shouldReturnChangesBetweenBuilds() throws ConnectionException, AzDException {
        b.getChangesBetweenBuilds(buildId, buildId, 10);
    }

    @Test
    public void shouldReturnWorkItemsBetweenBuilds() throws ConnectionException, AzDException {
        b.getWorkItemsBetweenBuilds(buildId, buildId, 10);
    }

    @Test
    public void shouldReturnBuilds() throws ConnectionException, AzDException { b.getBuilds(); }

    @Test
    public void shouldReturnBuildsWithArrayOfBuildIds() throws ConnectionException, AzDException {
        b.getBuilds(new int[]{126, 127});
    }

    @Test
    public void shouldReturnTopTwoBuilds() throws ConnectionException, AzDException {
        b.getBuilds(2);
    }

    @Test
    public void shouldQueueTheBuild() throws ConnectionException, AzDException {
        b.queueBuild(22);
    }

    @Test
    public void shouldReturnListOfBuildController() throws ConnectionException, AzDException {
        b.getBuildControllers();
    }

    @Test(expected = AzDException.class)
    public void shouldReturnABuildController() throws ConnectionException, AzDException {
        // should throw an exception if build controller doesn't exists
        b.getBuildController(25);
    }

    @Test(expected = AzDException.class)
    public void shouldCreateBuildDefinition() throws ConnectionException, AzDException {
        b.createBuildDefinition("");
    }

    @Test
    public void shouldDeleteABuildDefinition() throws ConnectionException, AzDException {
        b.deleteBuildDefinition(13);
    }

    @Test
    public void shouldReturnBuildDefinition() throws ConnectionException, AzDException {
        b.getBuildDefinition(9);
    }

    @Test
    public void shouldReturnBuildDefinitionWithOptionalParameters() throws ConnectionException, AzDException {
        b.getBuildDefinition(9, true, null, 2);
    }

    @Test
    public void shouldReturnBuildDefinitionRevisions() throws ConnectionException, AzDException {
        b.getBuildDefinitionRevisions(9);
    }

    @Test
    public void shouldReturnBuildDefinitions() throws ConnectionException, AzDException {
        b.getBuildDefinitions();
    }

    @Test
    public void shouldReturnBuildDefinitionsWithIds() throws ConnectionException, AzDException {
        b.getBuildDefinitions(new int[]{ 8, 9 });
    }

    @Test
    public void shouldReturnTopTwoBuildDefinitions() throws ConnectionException, AzDException {
        b.getBuildDefinitions(2);
    }

    @Test
    public void shouldReturnBuildDefinitionsWithName() throws ConnectionException, AzDException {
        b.getBuildDefinitions("azure-devops-java-sdk");
    }

    @Test(expected = AzDException.class)
    public void shouldRestoreBuildDefinition() throws ConnectionException, AzDException {
        b.restoreBuildDefinition(126, false);

    }

    @Test
    public void shouldAddABuildTag() throws ConnectionException, AzDException {
        b.addBuildTag(503, "Demo");

    }

    @Test
    public void shouldAddBuildTags() throws ConnectionException, AzDException {
        b.addBuildTags(503, new String[]{ "Demo", "CI", "Test" });

    }

    @Test
    public void shouldAddADefinitionTag() throws ConnectionException, AzDException {
        b.addDefinitionTag(22, "TestDefinition");
    }

    @Test
    public void shouldAddDefinitionTags() throws ConnectionException, AzDException {
        b.addDefinitionTags(22, new String[]{ "TestDefinition", "DemoDefinition"});
    }

    @Test
    public void shouldDeleteABuildTag() throws ConnectionException, AzDException {
        b.deleteBuildTag(503, "Test");
    }

    @Test
    public void shouldDeleteADefinitionTag() throws ConnectionException, AzDException {
        b.deleteDefinitionTag(22, "DemoDefinition");
    }

    @Test
    public void shouldDeleteATag() throws ConnectionException, AzDException {
        b.deleteTag("DemoDefinition");
    }

    @Test
    public void shouldGetBuildTags() throws ConnectionException, AzDException {
        b.getBuildTags(503);
    }

    @Test
    public void shouldGetDefinitionTags() throws ConnectionException, AzDException {
        b.getDefinitionTags(22);
    }

    @Test
    public void shouldGetTags() throws ConnectionException, AzDException {
        b.getTags();
    }

    @Test
    public void shouldUpdateBuildTags() throws ConnectionException, AzDException {
        b.updateBuildTags(503, new String[]{ "Demo", "CI", "Test" }, false);
    }

    @Test
    public void shouldUpdateDefinitionTags() throws ConnectionException, AzDException {
        b.updateDefinitionTags(22, new String[]{ "TestDefinition", "DemoDefinition"}, false);
    }
}
