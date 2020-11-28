package org.azd;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.azd.build.builds.Build;
import org.azd.build.types.BuildT;
import org.azd.exceptions.DefaultParametersException;
import org.azd.utils.AzDDefaultParameters;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

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
    public void shouldDeleteABuild() throws DefaultParametersException {
        b.deleteBuild(51);
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
    public void shouldReturnABuildLog() throws DefaultParametersException {
        b.getBuildLog(50, 3);
    }

    @Test
    public void shouldReturnABuildLogWithOptionalParameters() throws DefaultParametersException {
        b.getBuildLog(50, 3, 3, 6);
    }

    @Test
    public void shouldReturnBuildLogs() throws IOException, DefaultParametersException {
        b.getBuildLogs(50);
    }

}
