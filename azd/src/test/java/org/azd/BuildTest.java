package org.azd;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.azd.build.builds.Build;
import org.azd.build.types.BuildDefinition;
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
    public void shouldDeleteABuild() {
        b.deleteBuild(52);
    }

    @Test
    public void shouldGetABuild() {
        b.getBuild(50);
    }

    @Test
    public void shouldReturnABuildChanges() {
        b.getBuildChanges(50);
    }

    @Test
    public void shouldReturnABuildChangesWithOptionalParameters() {
        b.getBuildChanges(50, 10, null, true);
    }

    @Test
    public void shouldReturnABuildLog() {
        b.getBuildLog(50, 3);
    }

    @Test
    public void shouldReturnABuildLogWithOptionalParameters() {
        b.getBuildLog(50, 3, 3, 6);
    }

    @Test
    public void shouldReturnBuildLogs() {
        b.getBuildLogs(50);
    }

    @Test
    public void shouldReturnBuildWorkItems() {
        b.getBuildWorkItems(53);
    }

    @Test
    public void shouldReturnBuildWorkItemsWithOptionalParameters() {
        b.getBuildWorkItems(53, 10);
    }

    @Test
    public void shouldReturnChangesBetweenBuilds() {
        b.getChangesBetweenBuilds(65, 69, 10);
    }

    @Test
    public void shouldReturnWorkItemsBetweenBuilds() {
        b.getWorkItemsBetweenBuilds(65, 69, 10);
    }

    @Test
    public void shouldReturnBuilds() { b.getBuilds(); }

    @Test
    public void shouldReturnBuildsWithArrayOfBuildIds() {
        b.getBuilds(new int[]{50, 53});
    }

    @Test
    public void shouldReturnTopTwoBuilds() {
        b.getBuilds(2);
    }

    @Test
    public void shouldQueueTheBuild() {
        b.queueBuild("azure-devops-java-sdk");
    }

    @Test
    public void shouldReturnListOfBuildController() {
        b.getBuildControllers();
    }

    @Test
    public void shouldReturnABuildController() {
        b.getBuildController(25);
    }

    @Test
    public void shouldCreateBuildDefinition() {
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
    public void shouldDeleteABuildDefinition() {
        b.deleteBuildDefinition(11);
    }

    @Test
    public void shouldReturnBuildDefinition() {
        b.getBuildDefinition(9);
    }

    @Test
    public void shouldReturnBuildDefinitionWithOptionalParameters() {
        b.getBuildDefinition(9, true, null, 2).get("name");
    }

    @Test
    public void shouldReturnBuildDefinitionRevision() {
        b.getBuildDefinitionRevision(9);
    }

    @Test
    public void shouldReturnBuildDefinitions() {
        b.getBuildDefinitions();
    }

    @Test
    public void shouldReturnBuildDefinitionsWithIds() {
        b.getBuildDefinitions(new int[]{ 8, 9 });
    }

    @Test
    public void shouldReturnTopTwoBuildDefinitions() {
        b.getBuildDefinitions(2);
    }

    @Test
    public void shouldReturnBuildDefinitionsWithName() {
        b.getBuildDefinitions("azure-devops-java-sdk");
    }

    @Test
    public void shouldRestoreBuildDefinition() {
        b.restoreBuildDefinition(11, false);

    }

}
