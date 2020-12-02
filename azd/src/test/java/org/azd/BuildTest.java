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
    private static ObjectMapper mapper = new ObjectMapper();
    private static String dir;
    private static File file;
    private static MockParameters m;
    private static String organization;
    private static String token;
    private static String project;
    private static AzDDefaultParameters defaultParameters;
    private static Build b;


    @Before
    public void init() throws IOException {
        dir = System.getProperty("user.dir");
        file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        m = mapper.readValue(file, MockParameters.class);
        organization = m.getO();
        token = m.getT();
        project = m.getP();
        defaultParameters = new AzDDefaultParameters(organization, project, token);
        b = new Build(defaultParameters);
    }

    @Test
    public void shouldDeleteABuild() throws DefaultParametersException, IOException {
        b.deleteBuild(52);
    }

    @Test
    public void shouldGetABuild() throws IOException, DefaultParametersException {
        b.getBuild(50);
    }

    @Test
    public void shouldReturnABuildChanges() throws IOException, DefaultParametersException {
        b.getBuildChanges(50);
    }

    @Test
    public void shouldReturnABuildChangesWithOptionalParameters() throws IOException, DefaultParametersException {
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
    public void shouldReturnBuildLogs() throws IOException, DefaultParametersException {
        b.getBuildLogs(50);
    }

    @Test
    public void shouldReturnBuildWorkItems() throws IOException, DefaultParametersException {
        b.getBuildWorkItems(53);
    }

    @Test
    public void shouldReturnBuildWorkItemsWithOptionalParameters() throws IOException, DefaultParametersException {
        b.getBuildWorkItems(53, 10);
    }

    @Test
    public void shouldReturnChangesBetweenBuilds() throws IOException, DefaultParametersException {
        b.getChangesBetweenBuilds(65, 69, 10);
    }

    @Test
    public void shouldReturnWorkItemsBetweenBuilds() throws IOException, DefaultParametersException {
        b.getWorkItemsBetweenBuilds(65, 69, 10);
    }

    @Test
    public void shouldReturnBuilds() throws IOException, DefaultParametersException {
        b.getBuilds();
    }

    @Test
    public void shouldReturnBuildsWithArrayOfBuildIds() throws IOException, DefaultParametersException {
        b.getBuilds(new int[]{50, 53});
    }

    @Test
    public void shouldReturnTopTwoBuilds() throws IOException, DefaultParametersException {
        b.getBuilds(2);
    }

    @Test
    public void shouldQueueTheBuild() throws IOException, DefaultParametersException {
        System.out.println(b.queueBuild(9));
    }

    @Test
    public void shouldReturnListOfBuildController() throws IOException, DefaultParametersException {
        b.getBuildControllers();
    }

    @Test
    public void shouldReturnABuildController() throws IOException, DefaultParametersException {
        b.getBuildController(25);
    }

    @Test
    public void shouldCreateBuildDefinition() throws IOException, DefaultParametersException {
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
    public void shoulddeleteABuildDefinition() throws IOException, DefaultParametersException {
        b.deleteBuildDefinition(11);
    }

    @Test
    public void shouldReturnBuildDefinition() throws IOException, DefaultParametersException {
        b.getBuildDefinition(9);
    }

    @Test
    public void shouldReturnBuildDefinitionWithOptionalParameters() throws IOException, DefaultParametersException {
        b.getBuildDefinition(9, true, null, 2).get("name");
    }

    @Test
    public void shouldReturnBuildDefinitionRevision() throws IOException, DefaultParametersException {
        System.out.println(b.getBuildDefinitionRevision(9));
    }

    @Test
    public void shouldReturnBuildDefinitions() throws IOException, DefaultParametersException {
        b.getBuildDefinitions();
    }

    @Test
    public void shouldReturnBuildDefinitionsWithIds() throws IOException, DefaultParametersException {
        b.getBuildDefinitions(new int[]{ 8, 9 });
    }

    @Test
    public void shouldReturnTopTwoBuildDefinitions() throws IOException, DefaultParametersException {
        b.getBuildDefinitions(2);
    }

    @Test
    public void shouldReturnBuildDefinitionsWithName() throws IOException, DefaultParametersException {
        b.getBuildDefinitions("azure-devops-java-sdk");
    }

    @Test
    public void shouldRestoreBuildDefinition() throws IOException, DefaultParametersException {
        b.restoreBuildDefinition(11, false);

    }

}
