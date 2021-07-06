package org.azd;

import org.azd.build.BuildApi;
import org.azd.connection.Connection;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.BuildDetails;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class BuildApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static BuildDetails b;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        Connection defaultParameters = new Connection(organization, project, token);
        b = new BuildApi(defaultParameters);
    }

    @Test
    public void shouldDeleteABuild() throws ConnectionException, AzDException {
        b.deleteBuild(122);
    }

    @Test
    public void shouldGetABuild() throws ConnectionException, AzDException {
        b.getBuild(127).get_links();
    }

    @Test
    public void shouldReturnABuildChanges() throws ConnectionException, AzDException {
        b.getBuildChanges(127);
    }

    @Test
    public void shouldReturnABuildChangesWithOptionalParameters() throws ConnectionException, AzDException {
        b.getBuildChanges(127, 10, "1", true);
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
        b.getBuildLogs(127);
    }

    @Test
    public void shouldReturnBuildWorkItems() throws ConnectionException, AzDException {
        b.getBuildWorkItems(127);
    }

    @Test
    public void shouldReturnBuildWorkItemsWithOptionalParameters() throws ConnectionException, AzDException {
        b.getBuildWorkItems(127, 10);
    }

    @Test
    public void shouldReturnChangesBetweenBuilds() throws ConnectionException, AzDException {
        b.getChangesBetweenBuilds(127, 127, 10);
    }

    @Test
    public void shouldReturnWorkItemsBetweenBuilds() throws ConnectionException, AzDException {
        b.getWorkItemsBetweenBuilds(127, 127, 10);
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
        b.queueBuild(12);
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

}
