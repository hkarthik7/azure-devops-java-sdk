package org.azd.unittests;

import org.azd.UnitTestConfiguration;
import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.build.types.Build;
import org.azd.build.types.BuildDefinition;
import org.azd.build.types.Builds;
import org.azd.build.types.Folder;
import org.azd.enums.BuildQueryOrder;
import org.azd.enums.BuildReason;
import org.azd.enums.Instance;
import org.azd.enums.QueuePriority;
import org.azd.exceptions.AzDException;
import org.azd.helpers.StreamHelper;
import org.azd.helpers.Utils;
import org.azd.http.ClientRequest;
import org.azd.legacy.MockParameters;
import org.azd.serviceclient.AzDService;
import org.azd.serviceclient.AzDServiceClient;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class BuildsRequestBuilderTest {
    private static final SerializerContext serializer = InstanceFactory.createSerializerContext();
    private static AzDServiceClient client;
    private static UnitTestConfiguration testConfiguration;

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
    }

    @Test
    public void shouldTestBuildsPagedList() throws AzDException {
        var builds = client.build().builds().list(r -> {
            r.queryParameters.top = 10;
            r.queryParameters.queryOrder = BuildQueryOrder.START_TIME_DESCENDING;
            r.queryParameters.reasonFilter = BuildReason.ALL;
        });
        if (builds != null)
            // Get current set of results.
            builds.getBuildResults().stream().map(b -> Integer.toString(b.getId())).collect(Collectors.joining(", "));
        while (builds != null) {
            // Get next page
            builds = ClientRequest.builder(client.accessTokenCredential())
                    .URI(builds.getNextPageLink())
                    .build()
                    .execute(Builds.class);
            if (builds.getNextPageLink() == null) break;
            else
                builds.getBuildResults().stream().map(b -> Integer.toString(b.getId())).collect(Collectors.joining(", "));
        }
    }

    @Test
    public void shouldDeleteABuild() throws AzDException {
        var newBuild = client.build().builds().queue(testConfiguration.properties.builds.definitionId);
        // Build will be deleted immediately.
        client.build().builds().delete(newBuild.getId());
    }

    @Test
    public void shouldGetABuild() throws AzDException {
        var buildId = client.build().builds().list().getBuildResults().get(0).getId();
        client.build().builds().get(buildId);
    }

    @Test
    public void shouldReturnABuildChanges() throws AzDException {
        var buildId = client.build().builds().list().getBuildResults().get(0).getId();
        client.build().builds().changes().get(buildId);
    }

    @Test
    public void shouldReturnABuildChangesWithOptionalParameters() throws AzDException {
        var buildId = client.build().builds().list().getBuildResults().get(0).getId();
        client.build().builds().changes().get(buildId, r -> {
            r.queryParameters.top = 10;
            r.queryParameters.includeSourceChange = true;
        });
    }

    @Test
    public void shouldReturnABuildLog() throws AzDException {
        var buildId = client.build().builds().list().getBuildResults().get(0).getId();
        client.build().builds().logs().get(buildId, 3);
    }

    @Test
    public void shouldReturnABuildLogWithOptionalParameters() throws AzDException {
        var buildId = client.build().builds().list().getBuildResults().get(0).getId();
        client.build().builds().logs().get(buildId, 3, r -> {
            r.queryParameters.startLine = 3;
            r.queryParameters.endLine = 6;
        });
    }

    @Test
    public void shouldReturnBuildLogs() throws AzDException {
        var buildId = client.build().builds().list().getBuildResults().get(0).getId();
        client.build().builds().logs().get(buildId);
    }

    @Test
    public void shouldReturnBuildWorkItems() throws AzDException {
        var buildId = client.build().builds().list().getBuildResults().get(0).getId();
        client.build().builds().workItems().get(buildId);
    }

    @Test
    public void shouldReturnBuildWorkItemsWithOptionalParameters() throws AzDException {
        var buildId = client.build().builds().list().getBuildResults().get(0).getId();
        client.build().builds().workItems().get(buildId, 10);
    }

    @Test
    public void shouldReturnChangesBetweenBuilds() throws AzDException {
        var fromBuildId = client.build().builds().list().getBuildResults().get(0).getId();
        var toBuildId = client.build().builds().list().getBuildResults().get(0).getId();
        client.build().builds().changes().list(r -> {
            r.queryParameters.fromBuildId = fromBuildId;
            r.queryParameters.toBuildId = toBuildId;
            r.queryParameters.top = 10;
        });
    }

    @Test
    public void shouldReturnWorkItemsBetweenBuilds() throws AzDException {
        var fromBuildId = client.build().builds().list().getBuildResults().get(0).getId();
        var toBuildId = client.build().builds().list().getBuildResults().get(0).getId();
        client.build().builds().workItems().get(r -> {
            r.queryParameters.fromBuildId = fromBuildId;
            r.queryParameters.toBuildId = toBuildId;
            r.queryParameters.top = 10;
        });
    }

    @Test
    public void shouldReturnBuilds() throws AzDException {
        client.build().builds().list();
    }

    @Test
    public void shouldReturnBuildsContinuationToken() throws AzDException {
        assert client.build().builds().list(r -> r.queryParameters.top = 1).getContinuationToken() != null;
    }

    @Test
    public void shouldReturnBuildsWithArrayOfBuildIds() throws AzDException {
        var builds = client.build().builds().list(r -> r.queryParameters.top = 2)
                .getBuildResults()
                .stream()
                .mapToInt(Build::getId)
                .toArray();
        client.build().builds().list(r -> r.queryParameters.buildIds = Utils.toStringArray(builds));
    }

    @Test
    public void shouldReturnTopTwoBuilds() throws AzDException {
        client.build().builds().list(r -> r.queryParameters.top = 2);
    }

    @Test
    public void shouldQueueTheBuild() throws AzDException {
        client.build().builds().queue(testConfiguration.properties.builds.definitionId);
    }

    @Test
    public void shouldReturnListOfBuildController() throws AzDException {
        client.build().controllers().list();
    }

    @Test(expected = AzDException.class)
    public void shouldReturnABuildController() throws AzDException {
        client.build().controllers().get(25);
    }

    @Test(expected = AzDException.class)
    public void shouldCreateBuildDefinition() throws AzDException {
        client.build().definitions().create(null, null);
    }

    @Test
    public void shouldDeleteABuildDefinition() throws AzDException {
        client.build().definitions().delete(13);
    }

    @Test
    public void shouldReturnBuildDefinition() throws AzDException {
        client.build().definitions().get(testConfiguration.properties.builds.definitionId);
    }

    @Test
    public void shouldReturnBuildDefinitionWithOptionalParameters() throws AzDException {
        client.build().definitions().get(testConfiguration.properties.builds.definitionId, r -> {
            r.queryParameters.revision = 2;
            r.queryParameters.includeLatestBuilds = true;
        });
    }

    @Test
    public void shouldReturnBuildDefinitionRevisions() throws AzDException {
        client.build().definitions().getRevisions(testConfiguration.properties.builds.definitionId);
    }

    @Test
    public void shouldReturnBuildDefinitions() throws AzDException {
        client.build().definitions().list();
    }

    @Test
    public void shouldReturnBuildDefinitionsWithIds() throws AzDException {
        var definitions = client.build().definitions().list(r -> r.queryParameters.top = 2)
                .getBuildDefinitions().stream()
                .mapToInt(BuildDefinition::getId)
                .toArray();
        client.build().definitions().list(r -> r.queryParameters.definitionIds = Utils.toStringArray(definitions));
    }

    @Test
    public void shouldReturnTopTwoBuildDefinitions() throws AzDException {
        client.build().definitions().list(r -> r.queryParameters.top = 2);
    }

    @Test
    public void shouldReturnBuildDefinitionsWithName() throws AzDException {
        client.build().definitions().list(r -> r.queryParameters.name = testConfiguration.properties.builds.definitionName);
    }

    @Test(expected = AzDException.class)
    public void shouldRestoreBuildDefinition() throws AzDException {
        client.build().definitions().restore(126, false);
    }

    @Test
    public void shouldAddBuildTags() throws AzDException {
        var buildId = client.build().builds().list().getBuildResults().get(0).getId();
        client.build().tags().build().add(buildId, List.of("Demo"));
    }

    @Test
    public void shouldAddDefinitionTags() throws AzDException {
        client.build().tags().definition().add(testConfiguration.properties.builds.definitionId, List.of("TestDefinition", "DemoDefinition"));
    }

    @Test
    public void shouldDeleteABuildTag() throws AzDException {
        var buildId = client.build().builds().list().getBuildResults().get(0).getId();
        client.build().tags().build().delete(buildId, "Test");
    }

    @Test
    public void shouldDeleteADefinitionTag() throws AzDException {
        client.build().tags().definition().delete(testConfiguration.properties.builds.definitionId, "DemoDefinition");
    }

    @Test
    public void shouldDeleteATag() throws AzDException {
        client.build().tags().delete("DemoDefinition");
    }

    @Test
    public void shouldGetBuildTags() throws AzDException {
        var buildId = client.build().builds().list().getBuildResults().get(0).getId();
        client.build().tags().build().get(buildId);
    }

    @Test
    public void shouldGetDefinitionTags() throws AzDException {
        client.build().tags().definition().get(testConfiguration.properties.builds.definitionId);
    }

    @Test
    public void shouldGetTags() throws AzDException {
        client.build().tags().list();
    }

    @Test
    public void shouldUpdateBuildTags() throws AzDException {
        var buildId = client.build().builds().list().getBuildResults().get(0).getId();
        client.build().tags().build().update(buildId, List.of("Demo", "CI", "Test"), false);
    }

    @Test
    public void shouldUpdateDefinitionTags() throws AzDException {
        client.build().tags().definition().update(testConfiguration.properties.builds.definitionId,
                List.of("TestDefinition", "DemoDefinition"), false);
    }

    @Test
    public void shouldGetYamlBuildForADefinition() throws AzDException {
        client.build().yaml().get(testConfiguration.properties.builds.definitionId).getYaml();
    }

    @Test
    public void shouldGetSourceProvidersFileContents() throws AzDException {
        client.build().sourceProviders().getFileContents("Github", r -> {
            r.queryParameters.commitOrBranch = "master";
            r.queryParameters.repository = "hkarthik7/PSDB";
            r.queryParameters.serviceEndpointId = "a7054ra9-0a34-46ac-bfdf-b8a1da865tdfd6";
            r.queryParameters.path = "LICENSE";
        });
    }

    @Test(expected = AzDException.class)
    public void shouldGetSourceProvidersPullRequest() throws AzDException {
        client.build().sourceProviders().getPullRequest("Github", "2",
                "hkarthik7/PSDB", "a7054ra9-0a34-46ac-bfdf-b8a1da865tdfd6");
    }

    @Test
    public void shouldGetSourceProviders() throws AzDException {
        client.build().sourceProviders().list();
    }

    @Test(expected = AzDException.class)
    public void shouldGetSourceProvidersBranches() throws AzDException {
        client.build().sourceProviders().listBranches("Github", r -> {
            r.queryParameters.serviceEndpointId = "a7054ra9-0a34-46ac-bfdf-b8a1da865tdfd6";
            r.queryParameters.repository = "hkarthik7/PSDB";
        });
    }

    @Test(expected = AzDException.class)
    public void shouldGetSourceProvidersRepositories() throws AzDException {
        client.build().sourceProviders().listRepositories("Github",
                r -> r.queryParameters.serviceEndpointId = "a7054ra9-0a34-46ac-bfdf-b8a1da865tdfd6");
    }

    @Test(expected = AzDException.class)
    public void shouldGetSourceProvidersWebhooks() throws AzDException {
        client.build().sourceProviders().listWebhooks("Github",
                "a7054ra9-0a34-46ac-bfdf-b8a1da865tdfd6", "hkarthik7/PSDB");
    }

    @Test()
    public void shouldGetBuildTimelines() throws AzDException {
        var buildId = client.build().builds().list().getBuildResults().get(0).getId();
        client.build().timeline().get(buildId);
    }

    @Test()
    public void shouldGetBuildTimelinesWithTimelineId() throws AzDException {
        var buildId = client.build().builds().list().getBuildResults().get(0).getId();
        var timeline = client.build().timeline().get(buildId);
        client.build().timeline().get(buildId, timeline.getId());
    }

    @Test()
    public void shouldGetBuildTimelinesWithChangeAndPlanId() throws AzDException {
        var buildId = client.build().builds().list().getBuildResults().get(0).getId();
        var timeline = client.build().timeline().get(buildId);
        client.build().timeline().get(buildId, timeline.getId(), r -> {
            r.queryParameters.changeId = timeline.getChangeId();
        });
    }

    @Test
    public void shouldCreateBuildArtifact() {
        try {
            var buildId = client.build().builds().list().getBuildResults()
                    .stream()
                    .filter(x -> x.getDefinition().getId().equals(testConfiguration.properties.builds.definitionId))
                    .findFirst()
                    .get()
                    .getId();
            var artifact = client.build().artifacts().get(buildId, "Test");

            client.build().artifacts().create(buildId, artifact);
        } catch (AzDException ignored) {

        }
    }

    @Test
    public void shouldGetABuildArtifact() {
        try {
            var buildId = client.build().builds().list().getBuildResults()
                    .stream()
                    .filter(x -> x.getDefinition().getId().equals(testConfiguration.properties.builds.definitionId))
                    .findFirst()
                    .get()
                    .getId();
            client.build().artifacts().get(buildId, "Test");
        } catch (AzDException ignored) {
        }
    }

    @Test
    public void shouldGetBuildArtifactAsZip() throws AzDException {
        var buildId = client.build().builds().list().getBuildResults()
                .stream()
                .filter(x -> x.getDefinition().getId().equals(testConfiguration.properties.builds.definitionId))
                .findFirst()
                .get()
                .getId();

        var artifact = client.build().artifacts().getAsZip(buildId, "Test");

        StreamHelper.download("test-artifact.zip", artifact);
    }

    @Test
    public void shouldGetABuildArtifacts() throws AzDException {
        var buildId = client.build().builds().list().getBuildResults()
                .stream()
                .filter(x -> x.getDefinition().getId().equals(testConfiguration.properties.builds.definitionId))
                .findFirst()
                .get()
                .getId();
        client.build().artifacts().list(buildId);
    }

    @Test()
    public void shouldUpdateABuild() throws AzDException {
        var build = client.build().builds().list().getBuildResults()
                .stream()
                .filter(x -> x.getDefinition().getId().equals(testConfiguration.properties.builds.definitionId))
                .findFirst()
                .get();

        build.setTags(new String[]{"Demo"});
        // Set retry to true only when previous attempt of a build has failed and if retry is true build object
        // should be set to null.
        // client.build().builds().update(build.getId(), true, build);
        client.build().builds().update(build.getId(), false, build);
    }

    @Test()
    public void shouldUpdateMultipleBuilds() throws AzDException {
        var builds = client.build().builds().list(r -> r.queryParameters.top = 2);
        for (var build : builds.getBuildResults()) {
            build.setPriority(QueuePriority.LOW);
        }
        client.build().builds().update(builds);
    }

    @Test()
    public void shouldUpdateBuildDefinition() throws AzDException {
        var def = client.build().definitions().get(testConfiguration.properties.builds.definitionId);
        def.setDescription("Demo CI for azd project");
        client.build().definitions().update(def.getId(), def, null);
    }

    @Test()
    public void shouldCreateFolder() {
        try {
            var folder = new Folder();
            folder.setDescription("New demo folder");
            folder.setPath("\\Demo-Folder\\sub-demo");

            client.build().folders().create(folder.getPath(), folder);
        } catch (AzDException ignored) {
        }
    }

    @Test()
    public void shouldDeleteAFolder() throws AzDException {
        try {
            client.build().folders().delete("\\Demo-Folder\\sub-demo");
        } catch (AzDException ignored) {
        }
    }

    @Test()
    public void shouldGetAListOfFolders() throws AzDException {
        client.build().folders().list();
    }

    @Test()
    public void shouldUpdateFolder() throws AzDException {
        var folder = client.build().folders().list().getFolders().get(1);
        folder.setDescription("Demo folder for azd project");
        client.build().folders().update(folder.getPath(), folder);
    }
}
