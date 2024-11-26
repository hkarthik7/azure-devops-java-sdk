package org.azd.unittests;

import org.azd.UnitTestConfiguration;
import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.enums.ConfigurationType;
import org.azd.enums.GetArtifactExpandOptions;
import org.azd.enums.GetLogExpandOptions;
import org.azd.enums.Instance;
import org.azd.exceptions.AzDException;
import org.azd.legacy.MockParameters;
import org.azd.pipelines.PipelinesBaseRequestBuilder;
import org.azd.pipelines.types.*;
import org.azd.serviceclient.AzDService;
import org.azd.serviceclient.AzDServiceClient;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class PipelinesRequestBuilderTest {
    private static final SerializerContext serializer = InstanceFactory.createSerializerContext();
    private static AzDServiceClient client;
    private static UnitTestConfiguration testConfiguration;
    private static PipelinesBaseRequestBuilder p;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        var file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        var configFile = new File(dir + "/src/test/java/org/azd/config.json");
        var m = serializer.deserialize(file, MockParameters.class);
        testConfiguration = serializer.deserialize(configFile, UnitTestConfiguration.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        var pat = new PersonalAccessTokenCredential(Instance.BASE_INSTANCE.append(organization), project, token);
        client = AzDService.builder()
                .authentication(pat)
                .buildClient();
        p = client.pipelines();
    }

    @Test
    public void shouldGetArtifacts() throws AzDException {
        p.artifacts().get(
                testConfiguration.properties.pipelines.id,
                testConfiguration.properties.pipelines.runId,
                r -> r.queryParameters.artifactName = testConfiguration.properties.pipelines.artifactName
        );
    }

    @Test
    public void shouldGetArtifactsWithContentsExpanded() throws AzDException {
        p.artifacts().get(
                testConfiguration.properties.pipelines.id,
                testConfiguration.properties.pipelines.runId,
                r -> {
                    r.queryParameters.artifactName = testConfiguration.properties.pipelines.artifactName;
                    r.queryParameters.expand = GetArtifactExpandOptions.SIGNED_CONTENT;
                }
        );
    }

    @Test
    public void shouldGetPipelines() throws AzDException {
        p.pipelines().list();
    }

    @Test
    public void shouldGetPipelineLog() throws AzDException {
        p.logs().get(
                testConfiguration.properties.pipelines.id,
                testConfiguration.properties.pipelines.runId,
                1
        );
    }

    @Test
    public void shouldGetPipelineLogWithOptions() throws AzDException {
        p.logs().get(
                testConfiguration.properties.pipelines.id,
                testConfiguration.properties.pipelines.runId,
                1,
                GetLogExpandOptions.SIGNED_CONTENT
        );
    }

    @Test
    public void shouldGetPipelineLogs() throws AzDException {
        p.logs().list(
                testConfiguration.properties.pipelines.id,
                testConfiguration.properties.pipelines.runId
        );
    }

    // Should throw PipelineExistsException;
    // Modify this test if the pipeline doesn't exist to create a new one.
    @Test(expected = AzDException.class)
    public void shouldCreateAPipeline() throws AzDException {
        String repoId = client.git().repositories().get("newRepo").getId();
        var createPipelineParams = new CreatePipelineParameters();
        createPipelineParams.name = "Demo-Pipeline-CI";
        createPipelineParams.folder = "/";

        var pipelineConfig = new CreatePipelineConfigurationParameters();
        pipelineConfig.type = ConfigurationType.YAML;
        pipelineConfig.yamlFilePath = "/azure-pipelines.yaml";

        var pipelineRepo = new CreatePipelineRepositoryReference();
        pipelineRepo.repositoryId = repoId;
        pipelineRepo.repositoryName = "newRepo";
        pipelineRepo.repositoryType = "azureReposGit";

        pipelineConfig.repository = pipelineRepo;

        createPipelineParams.configuration = pipelineConfig;

        p.pipelines().create(createPipelineParams);
    }

    @Test
    public void shouldPreviewADryRunAndReturnYaml() throws AzDException {
        var pipelineParams = new RunPipelineParameters();
        pipelineParams.setPreviewRun(true);

        p.preview().preview(testConfiguration.properties.pipelines.previewPipelineId, pipelineParams);
    }

    @Test
    public void shouldRunAnExistingPipeline() throws AzDException {
        var pipelineParams = new RunPipelineParameters();
        pipelineParams.setResources(new RunResourcesParameters());
        p.runs().run(testConfiguration.properties.pipelines.previewPipelineId, pipelineParams);
    }
}
