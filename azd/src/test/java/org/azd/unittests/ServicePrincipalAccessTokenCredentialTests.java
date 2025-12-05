package org.azd.unittests;

import org.azd.MockParameters;
import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.ResponseHandler;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.ServicePrincipalAccessTokenCredential;
import org.azd.build.types.Builds;
import org.azd.enums.BuildQueryOrder;
import org.azd.enums.BuildReason;
import org.azd.enums.Instance;
import org.azd.exceptions.AzDException;
import org.azd.http.ClientRequest;
import org.azd.serviceclient.AzDService;
import org.azd.serviceclient.AzDServiceClient;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.stream.Collectors;

public class ServicePrincipalAccessTokenCredentialTests {
    private static final SerializerContext serializer = InstanceFactory.createSerializerContext();
    private static AzDServiceClient client;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        var file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        var m = serializer.deserialize(file, MockParameters.class);
        String organization = m.getO();
        String tenantId = m.getTI();
        String clientId = m.getC();
        String clientSecret = m.getCs();
        String project = m.getP();
        var spn = new ServicePrincipalAccessTokenCredential(
                Instance.BASE_INSTANCE.append(organization),
                project, tenantId,
                clientId, clientSecret);
        client = AzDService.builder()
                .authentication(spn)
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

    // Permissions vso.build_execute
    @Test
    public void shouldQueueTheBuild() throws AzDException {
        client.build().builds().queue(22);
    }
}
