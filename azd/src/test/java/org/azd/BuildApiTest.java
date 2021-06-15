package org.azd;

import org.azd.build.BuildApi;
import org.azd.build.types.BuildDefinition;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.BuildDetails;
import org.azd.utils.AzDDefaultParameters;
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
        AzDDefaultParameters defaultParameters = new AzDDefaultParameters(organization, project, token);
        b = new BuildApi(defaultParameters);
    }

    @Test
    public void shouldDeleteABuild() throws DefaultParametersException, AzDException {
        b.deleteBuild(122);
    }

    @Test
    public void shouldGetABuild() throws DefaultParametersException, AzDException {
        b.getBuild(127).get_links();
    }

    @Test
    public void shouldReturnABuildChanges() throws DefaultParametersException, AzDException {
        b.getBuildChanges(127);
    }

    @Test
    public void shouldReturnABuildChangesWithOptionalParameters() throws DefaultParametersException, AzDException {
        b.getBuildChanges(127, 10, "1", true);
    }

    @Test
    public void shouldReturnABuildLog() throws DefaultParametersException, AzDException {
        b.getBuildLog(50, 3);
    }

    @Test
    public void shouldReturnABuildLogWithOptionalParameters() throws DefaultParametersException, AzDException {
        b.getBuildLog(127, 3, 3, 6);
    }

    @Test
    public void shouldReturnBuildLogs() throws DefaultParametersException, AzDException {
        b.getBuildLogs(127);
    }

    @Test
    public void shouldReturnBuildWorkItems() throws DefaultParametersException, AzDException {
        b.getBuildWorkItems(127);
    }

    @Test
    public void shouldReturnBuildWorkItemsWithOptionalParameters() throws DefaultParametersException, AzDException {
        b.getBuildWorkItems(127, 10);
    }

    @Test
    public void shouldReturnChangesBetweenBuilds() throws DefaultParametersException, AzDException {
        b.getChangesBetweenBuilds(127, 127, 10);
    }

    @Test
    public void shouldReturnWorkItemsBetweenBuilds() throws DefaultParametersException, AzDException {
        b.getWorkItemsBetweenBuilds(127, 127, 10);
    }

    @Test
    public void shouldReturnBuilds() throws DefaultParametersException, AzDException { b.getBuilds(); }

    @Test
    public void shouldReturnBuildsWithArrayOfBuildIds() throws DefaultParametersException, AzDException {
        b.getBuilds(new int[]{126, 127});
    }

    @Test
    public void shouldReturnTopTwoBuilds() throws DefaultParametersException, AzDException {
        b.getBuilds(2);
    }

    @Test
    public void shouldQueueTheBuild() throws DefaultParametersException, AzDException {
        b.queueBuild(12);
    }

    @Test
    public void shouldReturnListOfBuildController() throws DefaultParametersException, AzDException {
        b.getBuildControllers();
    }

    @Test(expected = AzDException.class)
    public void shouldReturnABuildController() throws DefaultParametersException, AzDException {
        // should throw an exception if build controller doesn't exists
        b.getBuildController(25);
    }

    @Test(expected = AzDException.class)
    public void shouldCreateBuildDefinition() throws DefaultParametersException, AzDException {
        b.createBuildDefinition("");
    }

    @Test
    public void shouldDeleteABuildDefinition() throws DefaultParametersException, AzDException {
        b.deleteBuildDefinition(13);
    }

    @Test
    public void shouldReturnBuildDefinition() throws DefaultParametersException, AzDException {
        b.getBuildDefinition(9);
    }

    @Test
    public void shouldReturnBuildDefinitionWithOptionalParameters() throws DefaultParametersException, AzDException {
        b.getBuildDefinition(9, true, null, 2);
    }

    @Test
    public void shouldReturnBuildDefinitionRevisions() throws DefaultParametersException, AzDException {
        b.getBuildDefinitionRevisions(9);
    }

    @Test
    public void shouldReturnBuildDefinitions() throws DefaultParametersException, AzDException {
        b.getBuildDefinitions();
    }

    @Test
    public void shouldReturnBuildDefinitionsWithIds() throws DefaultParametersException, AzDException {
        b.getBuildDefinitions(new int[]{ 8, 9 });
    }

    @Test
    public void shouldReturnTopTwoBuildDefinitions() throws DefaultParametersException, AzDException {
        b.getBuildDefinitions(2);
    }

    @Test
    public void shouldReturnBuildDefinitionsWithName() throws DefaultParametersException, AzDException {
        b.getBuildDefinitions("azure-devops-java-sdk");
    }

    @Test(expected = AzDException.class)
    public void shouldRestoreBuildDefinition() throws DefaultParametersException, AzDException {
        b.restoreBuildDefinition(126, false);

    }

}
