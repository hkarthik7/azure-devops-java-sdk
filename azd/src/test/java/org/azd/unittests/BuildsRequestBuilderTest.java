package org.azd.unittests;

import org.azd.UnitTestConfiguration;
import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.build.types.Builds;
import org.azd.enums.BuildQueryOrder;
import org.azd.enums.BuildReason;
import org.azd.enums.Instance;
import org.azd.exceptions.AzDException;
import org.azd.http.ClientRequest;
import org.azd.legacy.MockParameters;
import org.azd.serviceclient.AzDService;
import org.azd.serviceclient.AzDServiceClient;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
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
            builds = ClientRequest.builder().URI(builds.getNextPageLink()).build().execute(Builds.class);
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
}
