package org.azd.unittests;

import org.azd.UnitTestConfiguration;
import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.enums.GraphTraversalDirection;
import org.azd.enums.Instance;
import org.azd.exceptions.AzDException;
import org.azd.graph.GraphRequestBuilder;
import org.azd.graph.types.*;
import org.azd.legacy.MockParameters;
import org.azd.serviceclient.AzDService;
import org.azd.serviceclient.AzDServiceClient;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

public class GraphRequestBuilderTest {
    private static final SerializerContext serializer = InstanceFactory.createSerializerContext();
    private static AzDServiceClient client;
    private static UnitTestConfiguration testConfiguration;
    private static GraphRequestBuilder g;

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
        g = client.graph();
    }

    @Test
    public void shouldGetGraphUsers() throws AzDException {
        g.users().list();
    }

    @Test
    public void shouldGetAGraphUser() throws AzDException {
        var user = g.users().list().getUsers().stream().findFirst().get();
        var descriptor = user.getDescriptor();
        assertEquals(descriptor, g.users().get(descriptor).getDescriptor());
    }

    @Test
    public void shouldCreateAGraphUser() throws AzDException {
        var graphUser = new GraphUserMailAddressCreationContext();
        graphUser.mailAddress = "test@gmail.com";
        g.users().create(graphUser);
    }

    @Test
    public void shouldGetGraphGroups() throws AzDException {
        var group = g.groups().list().getGraphGroups().stream().filter(x -> x.getDisplayName().equals("Contributors")).findFirst().get();
        var expectedValue = "Contributors";
        assertEquals(expectedValue, group.getDisplayName());
    }

    @Test
    public void shouldGetAGraphGroup() throws AzDException {
        var group = g.groups().list().getGraphGroups().stream().filter(x -> x.getDisplayName().equals("Contributors")).findFirst().get();
        g.groups().get(group.getDescriptor());
    }

    @Test
    public void shouldAddAUserToGroup() throws AzDException {
        var group = g.groups().list().getGraphGroups().stream().filter(x -> x.getDisplayName().equals("Contributors")).findFirst().get();
        var graphUser = new GraphUserMailAddressCreationContext();
        graphUser.mailAddress = "test@gmail.com";
        g.users().create(graphUser, r -> r.queryParameters.groupDescriptors = new String[]{group.getDescriptor()});
    }

    @Test
    public void shouldDeleteAUser() throws AzDException {
        var user = g.users().get("msa.YWE3YWY5MzQtYzcxMi03ODliLWJkMDEtZmRhMWQ4NjEzN2Rh");
        g.users().delete(user.getDescriptor());
    }

    @Test
    public void shouldGetMembersInGroup() throws AzDException {
        var group = g.groups().list().getGraphGroups().stream().filter(x -> x.getDisplayName().equals("Contributors")).findFirst().get();
        GraphMemberships groupMembers = g.memberships().list(group.getDescriptor(),
                r -> r.queryParameters.direction = GraphTraversalDirection.DOWN);
        assertFalse(groupMembers.getGraphMemberships().isEmpty());
    }

    @Test
    public void shouldGetGroupsForUser() throws AzDException {
        var user = g.users().list().getUsers().stream().findAny().get();
        GraphMemberships memberGroups = g.memberships().list(user.getDescriptor(),
                r -> r.queryParameters.direction = GraphTraversalDirection.UP);
        assertFalse(memberGroups.getGraphMemberships().isEmpty());
    }

    @Test
    public void shouldGetBiDirectionalMemberRelationship() throws AzDException {
        var group = g.groups().list().getGraphGroups().stream().filter(x -> x.getDisplayName().equals("Contributors")).findFirst().get();
        GraphMemberships groupMembers = g.memberships().list(group.getDescriptor(),
                r -> r.queryParameters.direction = GraphTraversalDirection.DOWN);
        var userMembership = groupMembers.getGraphMemberships().stream().filter(g -> g.get_links().getMember().getHref().toLowerCase().contains("/graph/users/")).findAny();
        assumeTrue(userMembership.isPresent());
        var user = g.users().get(userMembership.get().getMemberDescriptor());
        GraphMemberships memberGroups = g.memberships().list(user.getDescriptor(),
                r -> r.queryParameters.direction = GraphTraversalDirection.UP);
        assertTrue(memberGroups.getGraphMemberships().stream().anyMatch(g -> g.getContainerDescriptor().equals(group.getDescriptor())));
    }

    @Test
    @Ignore
    public void shouldAddSubjectToGroup() throws AzDException {
        try {
            var group = g.groups().list().getGraphGroups().stream().filter(x -> x.getDisplayName().equals("Contributors")).findFirst().get();
            var groupMembers = g.memberships().list(group.getDescriptor(),
                            r -> r.queryParameters.direction = GraphTraversalDirection.DOWN)
                    .getGraphMemberships().stream().map(GraphMembership::getMemberDescriptor).collect(Collectors.toList());
            var allUsers = g.users().list();
            var userNotInGroup = allUsers.getUsers().stream().filter(u -> !groupMembers.contains(u.getDescriptor())).findAny();
//            assumeTrue(userNotInGroup.isPresent());
//            GraphMembership graphMembership = g.addMembership(userNotInGroup.get().getDescriptor(), group.getDescriptor());
//            assertTrue(g.getGroupMembersOf(group.getDescriptor()).getGraphMemberships().stream().anyMatch(x -> x.getMemberDescriptor().equals(userNotInGroup.get().getDescriptor())));
//            System.out.println("Added " + userNotInGroup.get().getDescriptor() + " to " + group.getDescriptor());
            g.memberships().add(userNotInGroup.get().getDescriptor(), group.getDescriptor());
        } catch (AzDException ignored) {
        }
    }

    @Test
    public void removeSubjectFromGroup() throws AzDException {
        var subjDesc = "svc.ZDNhMjJkYTUtNDljMC00OTQ5LTk4Y2MtZDM4ZmQzNzBkZmYzOkJ1aWxkOjgwYjQ4NjI2LTBiMjAtNGMyZi04NGE3LWQ2ZGEzMWVlMzQ2OQ";
        var group = g.groups().list().getGraphGroups().stream().filter(x -> x.getDisplayName().equals("Contributors")).findFirst().get();
//        var groupDesc = "vssgp.Uy0xLTktMTU1MTM3NDI0NS0zOTI3OTgxMTY4LTIzMDM3Mzk1Ny0yNzIwNTg1NjYxLTMyMTM5NDc3NzAtMS0yMTM0NTMyMjg3LTMwNTc4NTM3NjctMjU1MTY0NTQyMi02NzAyNTM2ODQ";
        g.memberships().delete(subjDesc, group.getDescriptor());
    }

    @Test
    public void shouldNotAddGroupToSelf() throws AzDException {
        var group = g.groups().list().getGraphGroups().stream().filter(x -> x.getDisplayName().endsWith("Project Valid Users")).findFirst().get();
        assertNotNull(group);
        g.memberships().add(group.getDescriptor(), group.getDescriptor());
        var groupMembers = g.memberships().list(group.getDescriptor(),
                r -> r.queryParameters.direction = GraphTraversalDirection.DOWN);
        assertFalse(groupMembers.getGraphMemberships().stream().anyMatch(x -> x.getMemberDescriptor().equals(group.getDescriptor())));
    }

    @Test
    public void shouldAllowGroupInGroup() throws AzDException {
        var group = g.groups().list().getGraphGroups().stream().filter(x -> x.getDisplayName().endsWith("Project Collection Administrators")).findFirst().get();
        var subject = g.groups().list().getGraphGroups().stream().filter(x -> x.getDisplayName().endsWith("Project-Scoped Users")).findFirst().get();
        var groupMembers = g.memberships().list(group.getDescriptor(),
                r -> r.queryParameters.direction = GraphTraversalDirection.DOWN);
        assumeFalse(groupMembers.getGraphMemberships().stream().anyMatch(x -> x.getMemberDescriptor().equals(subject.getDescriptor())));
        g.memberships().add(subject.getDescriptor(), group.getDescriptor());
        groupMembers = g.memberships().list(group.getDescriptor(),
                r -> r.queryParameters.direction = GraphTraversalDirection.DOWN);
        assertTrue(groupMembers.getGraphMemberships().stream().anyMatch(x -> x.getMemberDescriptor().equals(subject.getDescriptor())));
        g.memberships().delete(subject.getDescriptor(), group.getDescriptor());
    }

    @Test
    public void shouldCreateGroup() throws AzDException {
        var graphGroup = new GraphGroupVstsCreationContext();
        graphGroup.displayName = "my-new-org-group";
        graphGroup.description = "this is a local org group";
        g.groups().create(graphGroup);
    }

    @Test
    public void shouldRemoveGroup() throws AzDException {
        var groupName = "my-new-org-group";
        GraphGroup graphGroup = g.groups().list().getGraphGroups().stream().filter(x -> x.getDisplayName().endsWith(groupName)).findAny().get();
        g.groups().delete(graphGroup.getDescriptor());
    }

    @Test
    public void shouldResolveDescriptorForProject() throws AzDException {
        var p = client.core().projects().list().getProjects().stream().findAny().get();
        var d = g.descriptors().get(p.getId());
        p.getName();
        d.getValue();
    }

    @Test
    @Ignore
    public void shouldLookupMultipleSubjects() throws AzDException {
        var group = g.groups().list().getGraphGroups().stream().filter(x -> x.getDisplayName().equals("Contributors")).findAny().get();
        var members = g.memberships().list(group.getDescriptor(),
                r -> r.queryParameters.direction = GraphTraversalDirection.DOWN).getGraphMemberships();
        var subjectLookup = new GraphSubjectLookup();
        var subjectLookupKeys = new ArrayList<GraphSubjectLookupKey>();
        for (var member : members)
            subjectLookupKeys.add(new GraphSubjectLookupKey(member.getMemberDescriptor()));
        subjectLookup.setLookupKeys(subjectLookupKeys);
        SubjectLookupResponse subjectLookupResponse = g.subjectLookup().lookup(subjectLookup);
        assertEquals(members.size(), subjectLookupResponse.getValue().size());
    }

    @Test
    public void shouldCreateProjectGroup() throws AzDException {
        var groupName = "my-new-group";
        assumeTrue(g.groups().list().getGraphGroups().stream().anyMatch(x -> x.getDisplayName().endsWith(groupName)));
        var graphGroup = new GraphGroupVstsCreationContext();
        graphGroup.displayName = "my-new-org-group";
        graphGroup.description = "this is a local org group";
        g.groups().create(graphGroup);
        assertTrue(g.groups().list().getGraphGroups().stream().anyMatch(x -> x.getDisplayName().endsWith(groupName)));
    }
}
