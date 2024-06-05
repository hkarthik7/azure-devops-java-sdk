package org.azd.unittests;

import org.azd.UnitTestConfiguration;
import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.legacy.MockParameters;
import org.azd.release.ReleaseBaseRequestBuilder;
import org.azd.release.types.*;
import org.azd.serviceclient.AzDService;
import org.azd.serviceclient.AzDServiceClient;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class ReleaseRequestBuilderTest {
    private static final SerializerContext serializer = InstanceFactory.createSerializerContext();
    private static AzDServiceClient client;
    private static UnitTestConfiguration testConfiguration;
    private static ReleaseBaseRequestBuilder r;

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
        r = client.release();
    }

    @Test
    public void shouldCreateARelease() throws AzDException {
        var build = client.build().builds().list(r ->
                r.queryParameters.definitions = new String[]{Integer.toString(testConfiguration.properties.builds.definitionId)}
        ).getBuildResults().get(0).getBuildNumber();

        var releaseStartMetadata = new ReleaseStartMetadata();

        var artifactMetadata = new ArtifactMetadata();
        artifactMetadata.setAlias(testConfiguration.properties.builds.artifactAlias);

        var buildRef = new BuildVersion();
        buildRef.setId(build);
        buildRef.setName(testConfiguration.properties.builds.definitionName);

        artifactMetadata.setInstanceReference(buildRef);

        releaseStartMetadata.setDefinitionId(testConfiguration.properties.release.definitionId);
        releaseStartMetadata.setDescription("Sample Release");
        releaseStartMetadata.setIsDraft(false);
        releaseStartMetadata.setManualEnvironments(null);
        releaseStartMetadata.setReason(ReleaseReason.NONE);
        releaseStartMetadata.setArtifacts(List.of(artifactMetadata));

        r.releases().create(releaseStartMetadata);
    }

    @Test
    public void shouldGetAllReleases() throws AzDException {
        r.releases().list();
    }

    @Test
    public void shouldGetARelease() throws AzDException {
        var rId = r.releases().list().getReleases().stream().findFirst().get().getId();
        r.releases().get(rId);
    }

    @Test
    public void shouldGetReleaseEnvironmentDetails() throws AzDException {
        var rId = r.releases().list().getReleases().stream().findFirst().get().getId();
        var res = r.releases().get(rId, r -> r.queryParameters.expand = SingleReleaseExpands.TASKS);
        r.releases().environment().get(res.getId(), res.getEnvironments().stream().findFirst().get().getId());
    }

    @Test
    public void shouldGetAllReleaseDefinitions() throws AzDException {
        r.definitions().list();
    }

    @Test
    public void shouldGetAReleaseDefinition() throws AzDException {
        r.definitions().get(testConfiguration.properties.release.definitionId);
    }

    @Test
    public void shouldGetReleaseDefinitionHistory() throws AzDException {
        r.definitions().revision().getHistory(testConfiguration.properties.release.definitionId);
    }

    @Test
    public void shouldDeleteARelease() throws AzDException {
        var build = client.build().builds().list(r ->
                r.queryParameters.definitions = new String[]{Integer.toString(testConfiguration.properties.builds.definitionId)}
        ).getBuildResults().get(0).getBuildNumber();
        var releaseStartMetadata = new ReleaseStartMetadata();

        var artifactMetadata = new ArtifactMetadata();
        artifactMetadata.setAlias(testConfiguration.properties.builds.artifactAlias);

        var buildRef = new BuildVersion();
        buildRef.setId(build);
        buildRef.setName(testConfiguration.properties.builds.definitionName);

        artifactMetadata.setInstanceReference(buildRef);

        releaseStartMetadata.setDefinitionId(testConfiguration.properties.release.definitionId);
        releaseStartMetadata.setDescription("Sample Release");
        releaseStartMetadata.setIsDraft(false);
        releaseStartMetadata.setManualEnvironments(null);
        releaseStartMetadata.setReason(ReleaseReason.NONE);
        releaseStartMetadata.setArtifacts(List.of(artifactMetadata));

        var release = r.releases().create(releaseStartMetadata);
        r.releases().delete(release.getId());
    }

    @Test(expected = AzDException.class)
    public void shouldQueueAReleaseWithEnvironmentName() throws AzDException {
        var release = r.releases().get(354);
        int environmentId = release
                .getEnvironments()
                .stream()
                .filter(x -> x.getName().equals("environmentName"))
                .findFirst()
                .get()
                .getId();

        var releaseEnvironmentUpdateMetadata = new ReleaseEnvironmentUpdateMetadata();
        releaseEnvironmentUpdateMetadata.setStatus(EnvironmentStatus.INPROGRESS);

        r.releases().environment().update(environmentId, release.getId(), releaseEnvironmentUpdateMetadata);

            // or
//            client.helpers().release().queueRelease(354, "D");
    }

    @Test(expected = AzDException.class)
    public void shouldAbandonARelease() throws AzDException {
        // Expected :- InvalidRequestException: VS402966: Transitioning of release from state 'Abandoned' to state 'Abandoned' is not allowed.
        var releaseUpdateMetadata = new ReleaseUpdateMetadata();
        releaseUpdateMetadata.setStatus(ReleaseStatus.ABANDONED);

        r.releases().updateResource(354, releaseUpdateMetadata);
    }

    @Test
    public void shouldGetReleaseApprovals() throws AzDException {
        r.approvals().list();
    }

    @Test
    public void shouldUpdateARelease() throws AzDException {
        var releaseId = r.releases().list().getReleases()
                .stream()
                .filter(rel -> rel.getReleaseDefinition().getName().equals("Demo-CD"))
                .findFirst()
                .get()
                .getId();

        var release = r.releases().get(releaseId);

        release.getVariables().get("Name").setIsSecret(true);

        r.releases().update(release.getId(), release);
    }

    @Test(expected = AzDException.class)
    public void shouldUpdateReleaseApprovals() throws AzDException {
        var releaseApproval = new ReleaseApproval();
        releaseApproval.setComments("Good to go!");
        releaseApproval.setStatus(ApprovalStatus.APPROVED);

        r.approvals().update(2, releaseApproval);
    }

    @Test
    public void shouldGetManualInterventions() throws AzDException {
        var releaseId = r.releases().list().getReleases().get(0).getId();
        r.manualInterventions().list(releaseId);
    }

    @Test
    public void shouldUpdateAReleaseDefinitionOrPipeline() throws AzDException {
        try {
            var releaseDef = r.definitions().get(2);

            // Set the releases to keep in environment retention policy.
            releaseDef.getEnvironments().stream().findFirst().get().getRetentionPolicy().setReleasesToKeep(4);

            // Set the new value to the variables.
            var c = new ConfigurationVariableValue();
            c.setValue("NewCustomValue");

            var variables = new HashMap<String, ConfigurationVariableValue>() {{
                put("Name", c);
            }};

            releaseDef.setVariables(variables);

            r.definitions().update(releaseDef);
        } catch (AzDException ignore) {
        }
    }
}
