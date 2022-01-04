package org.azd;

import org.azd.enums.PipelinesExpandOptions;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.AzDClient;
import org.azd.interfaces.GitDetails;
import org.azd.interfaces.PipelinesDetails;
import org.azd.utils.AzDClientApi;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

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
    public void shouldGetArtifacts() throws ConnectionException, AzDException, IOException {
        p.getArtifacts(8, 523, "drop");
    }

    @Test
    public void shouldGetArtifactsWithContentsExpanded() throws ConnectionException, AzDException, IOException {
//        String url = p.getArtifacts(8, 523, "drop", PipelinesArtifactExpandOptions.SIGNEDCONTENT).getSignedContent().getUrl();
//        new FileOutputStream("drop.zip").getChannel().transferFrom(Channels.newChannel(
//                new URL(url).openStream()), 0, Long.MAX_VALUE);
        p.getArtifacts(8, 523, "drop", PipelinesExpandOptions.SIGNEDCONTENT);
    }

    @Test
    public void shouldGetPipelines() throws ConnectionException, AzDException, IOException {
        p.getPipelines();
    }

    @Test
    public void shouldGetPipelineLog() throws ConnectionException, AzDException, IOException {
        p.getPipelineLog(8, 523, 1);
    }

    @Test
    public void shouldGetPipelineLogWithOptions() throws ConnectionException, AzDException, IOException {
        p.getPipelineLog(8, 523, 1, PipelinesExpandOptions.SIGNEDCONTENT);
    }

    @Test
    public void shouldGetPipelineLogs() throws ConnectionException, AzDException, IOException {
        p.getPipelineLogs(8, 523);
    }

    // Should throw PipelineExistsException;
    // Modify this test if the pipeline doesn't exist to create a new one.
    @Test(expected = AzDException.class)
    public void shouldCreateAPipeline() throws ConnectionException, AzDException, IOException {
        String repoId = g.getRepository("newRepo").getId();
        p.createPipeline("Demo-Pipeline-CI", "/", "/azure-pipelines.yaml", repoId, "newRepo");
    }

    @Test
    public void shouldPreviewADryRunAndReturnYaml() throws ConnectionException, AzDException, IOException {
        p.previewPipeline(25, true);
    }

    @Test
    public void shouldRunAnExistingPipeline() throws ConnectionException, AzDException, IOException {
        p.runPipeline(25);
    }
}
