package org.azd;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.azd.build.builds.Build;
import org.azd.build.types.BuildDefinition;
import org.azd.exceptions.DefaultParametersException;
import org.azd.utils.AzDDefaultParameters;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class BuildTest {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static Build b;

    @Before
    public void init() throws IOException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.readValue(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        AzDDefaultParameters defaultParameters = new AzDDefaultParameters(organization, project, token);
        b = new Build(defaultParameters);
    }

    @Test
    public void shouldDeleteABuild() throws DefaultParametersException, IOException {
        b.deleteBuild(52);
    }

    @Test
    public void shouldGetABuild() throws DefaultParametersException, IOException {
        b.getBuild(50).get_links();
    }

    @Test
    public void shouldReturnABuildChanges() throws DefaultParametersException, IOException {
        b.getBuildChanges(50);
    }

    @Test
    public void shouldReturnABuildChangesWithOptionalParameters() throws DefaultParametersException, IOException {
        b.getBuildChanges(50, 10, null, true);
    }

    @Test
    public void shouldReturnABuildLog() throws DefaultParametersException, IOException {
        b.getBuildLog(50, 3);
    }

    @Test
    public void shouldReturnABuildLogWithOptionalParameters() throws DefaultParametersException, IOException {
        b.getBuildLog(50, 3, 3, 6);
    }

    @Test
    public void shouldReturnBuildLogs() throws DefaultParametersException, IOException {
        b.getBuildLogs(50);
    }

    @Test
    public void shouldReturnBuildWorkItems() throws DefaultParametersException, IOException {
        b.getBuildWorkItems(53);
    }

    @Test
    public void shouldReturnBuildWorkItemsWithOptionalParameters() throws DefaultParametersException, IOException {
        b.getBuildWorkItems(53, 10);
    }

    @Test
    public void shouldReturnChangesBetweenBuilds() throws DefaultParametersException, IOException {
        b.getChangesBetweenBuilds(65, 69, 10);
    }

    @Test
    public void shouldReturnWorkItemsBetweenBuilds() throws DefaultParametersException, IOException {
        b.getWorkItemsBetweenBuilds(65, 69, 10);
    }

    @Test
    public void shouldReturnBuilds() throws DefaultParametersException, IOException { b.getBuilds(); }

    @Test
    public void shouldReturnBuildsWithArrayOfBuildIds() throws DefaultParametersException, IOException {
        b.getBuilds(new int[]{50, 53});
    }

    @Test
    public void shouldReturnTopTwoBuilds() throws DefaultParametersException, IOException {
        b.getBuilds(2);
    }

    @Test
    public void shouldQueueTheBuild() throws DefaultParametersException, IOException {
        b.queueBuild("azure-devops-java-sdk");
    }

    @Test
    public void shouldReturnListOfBuildController() throws DefaultParametersException, IOException {
        b.getBuildControllers();
    }

    @Test
    public void shouldReturnABuildController() throws DefaultParametersException, IOException {
        b.getBuildController(25);
    }

    @Test
    public void shouldCreateBuildDefinition() throws DefaultParametersException, IOException {
        BuildDefinition bD = new BuildDefinition();
        bD.setName("Test-CI");
        bD.setBadgeEnabled(true);
        bD.setPath("\\");

        HashMap<String, Object> m = new HashMap<>(){{
            put("name", bD.getName());
            put("path", bD.getPath());
            put("badgesEnabled", bD.isBadgeEnabled());
        }};

        b.createBuildDefinition(m);
    }

    @Test
    public void shouldDeleteABuildDefinition() throws DefaultParametersException, IOException {
        b.deleteBuildDefinition(11);
    }

    @Test
    public void shouldReturnBuildDefinition() throws DefaultParametersException, IOException {
        b.getBuildDefinition(9);
    }

    @Test
    public void shouldReturnBuildDefinitionWithOptionalParameters() throws DefaultParametersException, IOException {
        b.getBuildDefinition(9, true, null, 2).get("name");
    }

    @Test
    public void shouldReturnBuildDefinitionRevision() throws DefaultParametersException, IOException {
        b.getBuildDefinitionRevision(9);
    }

    @Test
    public void shouldReturnBuildDefinitions() throws DefaultParametersException, IOException {
        b.getBuildDefinitions();
    }

    @Test
    public void shouldReturnBuildDefinitionsWithIds() throws DefaultParametersException, IOException {
        b.getBuildDefinitions(new int[]{ 8, 9 });
    }

    @Test
    public void shouldReturnTopTwoBuildDefinitions() throws DefaultParametersException, IOException {
        b.getBuildDefinitions(2);
    }

    @Test
    public void shouldReturnBuildDefinitionsWithName() throws DefaultParametersException, IOException {
        b.getBuildDefinitions("azure-devops-java-sdk");
    }

    @Test
    public void shouldRestoreBuildDefinition() throws DefaultParametersException, IOException {
        b.restoreBuildDefinition(11, false);

    }

}
