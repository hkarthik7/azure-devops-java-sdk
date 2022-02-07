package org.azd;

import org.azd.enums.PipelinesExpandOptions;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.AzDClient;
import org.azd.interfaces.GitDetails;
import org.azd.interfaces.PipelinesDetails;
import org.azd.utils.AzDClientApi;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class PipelinesTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static AzDClient webApi;
    private static GitDetails g;
    private static PipelinesDetails p;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        webApi = new AzDClientApi(organization, project, token);
        p = webApi.getPipelinesApi();
        g = webApi.getGitApi();
    }

    @Test
    public void shouldGetArtifacts() throws AzDException {
        p.getArtifacts(8, 661, "drop");
    }

    @Test
    public void shouldGetArtifactsWithContentsExpanded() throws AzDException {
//        String url = p.getArtifacts(8, 531, "drop", PipelinesArtifactExpandOptions.SIGNEDCONTENT).getSignedContent().getUrl();
//        new FileOutputStream("drop.zip").getChannel().transferFrom(Channels.newChannel(
//                new URL(url).openStream()), 0, Long.MAX_VALUE);
        p.getArtifacts(8, 661, "drop", PipelinesExpandOptions.SIGNEDCONTENT);
    }

    @Test
    public void shouldGetPipelines() throws AzDException {
        p.getPipelines();
    }

    @Test
    public void shouldGetPipelineLog() throws AzDException {
        p.getPipelineLog(8, 661, 1);
    }

    @Test
    public void shouldGetPipelineLogWithOptions() throws AzDException {
        p.getPipelineLog(8, 661, 1, PipelinesExpandOptions.SIGNEDCONTENT);
    }

    @Test
    public void shouldGetPipelineLogs() throws AzDException {
        p.getPipelineLogs(8, 661);
    }

    // Should throw PipelineExistsException;
    // Modify this test if the pipeline doesn't exist to create a new one.
    @Test(expected = AzDException.class)
    public void shouldCreateAPipeline() throws AzDException {
        String repoId = g.getRepository("newRepo").getId();
        p.createPipeline("Demo-Pipeline-CI", "/", "/azure-pipelines.yaml", repoId, "newRepo");
    }

    @Test
    public void shouldPreviewADryRunAndReturnYaml() throws AzDException {
        p.previewPipeline(25, true);
    }

    @Test
    public void shouldRunAnExistingPipeline() throws AzDException {
        p.runPipeline(25);
    }
}
