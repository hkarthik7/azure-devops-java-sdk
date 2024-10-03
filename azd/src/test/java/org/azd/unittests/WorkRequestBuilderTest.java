package org.azd.unittests;

import org.azd.UnitTestConfiguration;
import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.enums.Instance;
import org.azd.enums.IterationsTimeFrame;
import org.azd.exceptions.AzDException;
import org.azd.legacy.MockParameters;
import org.azd.serviceclient.AzDService;
import org.azd.serviceclient.AzDServiceClient;
import org.azd.work.WorkRequestBuilder;
import org.azd.work.types.Activity;
import org.azd.work.types.TeamMemberCapacityIdentityRef;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WorkRequestBuilderTest {
    private static final SerializerContext serializer = InstanceFactory.createSerializerContext();
    private static AzDServiceClient client;
    private static UnitTestConfiguration testConfiguration;
    private static WorkRequestBuilder w;

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
        w = client.work();
    }

    @Test
    public void shouldGetTeamIterations() throws AzDException {
        w.iterations().list("azure-devops-java-sdk Team");
    }

    @Test
    public void shouldGetTeamIterationsWithTimeFrame() throws AzDException {
        var res = w.iterations().list("azure-devops-java-sdk Team", IterationsTimeFrame.CURRENT);
        assertEquals("Sprint 1", res.getIterations().stream().findFirst().get().getName());
    }

    @Test
    public void shouldGetTeamIterationWorkItems() throws AzDException {
        var id = w.iterations().list("azure-devops-java-sdk Team")
                .getIterations().stream().findFirst().get().getId();
        var res = w.iterations().getWorkItems(id, "azure-devops-java-sdk Team");
        res.get_links();
    }

    @Test
    public void shouldGetATeamIteration() throws AzDException {
        var id = w.iterations().list("azure-devops-java-sdk Team")
                .getIterations().stream().findFirst().get().getId();
        w.iterations().get(id, "azure-devops-java-sdk Team");
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteATeamIteration() throws AzDException {
        w.iterations().delete("0000-00000-00000-00000-00000", "azure-devops-java-sdk Team");
    }

    @Test
    public void shouldGetTotalTeamCapacity() throws AzDException {
        var iterationId = w.iterations().list("azure-devops-java-sdk Team")
                .getIterations().get(0).getId();
        w.capacities().get(iterationId, "azure-devops-java-sdk Team");
    }

    @Test
    public void shouldGetTeamMemberCapacity() throws AzDException {
        var iterationId = w.iterations().list("azure-devops-java-sdk Team")
                .getIterations().get(0).getId();
        var teamMemberId = w.capacities().get(iterationId, "azure-devops-java-sdk Team")
                .getTeamMembers().get(0).getTeamMember().getId();
        w.capacities().get(iterationId, teamMemberId, "azure-devops-java-sdk Team");
    }

    @Test
    public void shouldUpdateTeamMemberCapacity() throws AzDException {
        var iterationId = w.iterations().list("azure-devops-java-sdk Team")
                .getIterations().get(0).getId();
        var teamMemberId = w.capacities().get(iterationId, "azure-devops-java-sdk Team")
                .getTeamMembers().get(0).getTeamMember().getId();

        var teamMemberIdentityRef = new TeamMemberCapacityIdentityRef();

        var activity = new Activity();
        activity.setName("Development");
        activity.setCapacityPerDay(5);

        var activities = List.of(activity);

        teamMemberIdentityRef.setActivities(activities);

        w.capacities().update(iterationId, "azure-devops-java-sdk Team", teamMemberId, teamMemberIdentityRef);
    }

    @Test
    public void shouldUpdateTeamMembersCapacity() throws AzDException {
        var iterationId = w.iterations().list("azure-devops-java-sdk Team")
                .getIterations().get(0).getId();
        var teamMember = w.capacities().get(iterationId, "azure-devops-java-sdk Team")
                .getTeamMembers().get(0).getTeamMember();

        var teamMemberIdentityRef = new TeamMemberCapacityIdentityRef();
        teamMemberIdentityRef.setTeamMember(teamMember);

        var teamMemberIdentityRefs = List.of(teamMemberIdentityRef);

        var activity = new Activity();
        activity.setName("Development");
        activity.setCapacityPerDay(3);

        var activities = List.of(activity);

        teamMemberIdentityRef.setActivities(activities);

        w.capacities().replace(iterationId, "azure-devops-java-sdk Team", teamMemberIdentityRefs);
    }
}
