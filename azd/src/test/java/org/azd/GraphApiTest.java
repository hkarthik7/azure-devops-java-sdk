package org.azd;

import org.azd.exceptions.AzDException;
import org.azd.graph.types.GraphGroup;
import org.azd.graph.types.GraphMembership;
import org.azd.graph.types.GraphMemberships;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.AzDClient;
import org.azd.interfaces.GraphDetails;
import org.azd.utils.AzDClientApi;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

public class GraphApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static AzDClient webApi;
    private static GraphDetails g;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        webApi = new AzDClientApi(organization, project, token);
        g = webApi.getGraphApi();
    }

    @Test
    public void shouldGetGraphUsers() throws AzDException {
        g.getUsers().getUsers();
    }

    @Test
    public void shouldGetAGraphUser() throws AzDException {
        var user = g.getUsers().getUsers().stream().findFirst().get();
        var descriptor = user.getDescriptor();
        assertEquals(descriptor, g.getUser(descriptor).getDescriptor());
    }

    @Test
    public void shouldCreateAGraphUser() throws AzDException {
        var user = g.getUsers().getUsers().stream().findFirst().get();
        var descriptor = user.getDescriptor();
        var emailId = "test@gmail.com";
        g.createUser(emailId, descriptor);
    }

    @Test
    public void shouldGetGraphGroups() throws AzDException {
        var group = g.getGroups().getGraphGroups().stream().filter(x -> x.getDisplayName().equals("Contributors")).findFirst().get();
        var expectedValue = "Contributors";
        assertEquals(expectedValue, group.getDisplayName());
    }

    @Test
    public void shouldGetAGraphGroup() throws AzDException {
        var group = g.getGroups().getGraphGroups().stream().filter(x -> x.getDisplayName().equals("Contributors")).findFirst().get();
        g.getGroup(group.getDescriptor());
    }

    @Test
    public void shouldAddAUserToGroup() throws AzDException {
        var group = g.getGroups().getGraphGroups().stream().filter(x -> x.getDisplayName().equals("Contributors")).findFirst().get();
        var emailId = "test@gmail.com";
        g.addUserToGroup(emailId, group.getDescriptor());
    }

    @Test
    public void shouldDeleteAUser() throws AzDException {
        var user = g.getUser("msa.YWE3YWY5MzQtYzcxMi03ODliLWJkMDEtZmRhMWQ4NjEzN2Rh");
        g.deleteUser(user.getDescriptor());
    }

    @Test
    public void shouldGetMembersInGroup() throws AzDException {
        var group = g.getGroups().getGraphGroups().stream().filter(x -> x.getDisplayName().equals("Contributors")).findFirst().get();
        GraphMemberships groupMembers = g.getGroupMembersOf(group.getDescriptor());
        assertFalse(groupMembers.getGraphMemberships().isEmpty());
    }

    @Test
    public void shouldGetGroupsForUser() throws AzDException {
        var user = g.getUsers().getUsers().stream().findAny().get();
        GraphMemberships memberGroups = g.getMemberOfGroups(user.getDescriptor());
        assertFalse(memberGroups.getGraphMemberships().isEmpty());
    }

    @Test
    public void shouldGetBiDirectionalMemberRelationship() throws AzDException {
        var group = g.getGroups().getGraphGroups().stream().filter(x -> x.getDisplayName().equals("Contributors")).findFirst().get();
        GraphMemberships groupMembers = g.getGroupMembersOf(group.getDescriptor());
        var userMembership = groupMembers.getGraphMemberships().stream().filter(g -> g.get_links().getMember().getHref().toLowerCase().contains("/graph/users/")).findAny();
        assumeTrue(userMembership.isPresent());
        var user = g.getUser(userMembership.get().getMemberDescriptor());
        GraphMemberships memberGroups = g.getMemberOfGroups(user.getDescriptor());
        assertTrue(memberGroups.getGraphMemberships().stream().anyMatch(g -> g.getContainerDescriptor().equals(group.getDescriptor())));
    }

    @Test
    public void shouldAddSubjectToGroup() throws AzDException {
        try {
            var group = g.getGroups().getGraphGroups().stream().filter(x -> x.getDisplayName().equals("Contributors")).findFirst().get();
            var groupMembers = g.getGroupMembersOf(group.getDescriptor()).getGraphMemberships().stream().map(GraphMembership::getMemberDescriptor).collect(Collectors.toList());
            var allUsers = g.getUsers();
            var userNotInGroup = allUsers.getUsers().stream().filter(u -> !groupMembers.contains(u.getDescriptor())).findAny();
//            assumeTrue(userNotInGroup.isPresent());
//            GraphMembership graphMembership = g.addMembership(userNotInGroup.get().getDescriptor(), group.getDescriptor());
//            assertTrue(g.getGroupMembersOf(group.getDescriptor()).getGraphMemberships().stream().anyMatch(x -> x.getMemberDescriptor().equals(userNotInGroup.get().getDescriptor())));
//            System.out.println("Added " + userNotInGroup.get().getDescriptor() + " to " + group.getDescriptor());
            g.addMembership(userNotInGroup.get().getDescriptor(), group.getDescriptor());
        } catch (AzDException e) {
        }
    }

    @Test
    public void removeSubjectFromGroup() throws AzDException {
        var subjDesc = "svc.ZDNhMjJkYTUtNDljMC00OTQ5LTk4Y2MtZDM4ZmQzNzBkZmYzOkJ1aWxkOjgwYjQ4NjI2LTBiMjAtNGMyZi04NGE3LWQ2ZGEzMWVlMzQ2OQ";
        var group = g.getGroups().getGraphGroups().stream().filter(x -> x.getDisplayName().equals("Contributors")).findFirst().get();
//        var groupDesc = "vssgp.Uy0xLTktMTU1MTM3NDI0NS0zOTI3OTgxMTY4LTIzMDM3Mzk1Ny0yNzIwNTg1NjYxLTMyMTM5NDc3NzAtMS0yMTM0NTMyMjg3LTMwNTc4NTM3NjctMjU1MTY0NTQyMi02NzAyNTM2ODQ";
        g.removeMembership(subjDesc, group.getDescriptor());
    }

    @Test
    public void shouldNotAddGroupToSelf() throws AzDException {
        var group = g.getGroups().getGraphGroups().stream().filter(x -> x.getDisplayName().endsWith("Project Valid Users")).findFirst().get();
        assertNotNull(group);
        g.addMembership(group.getDescriptor(), group.getDescriptor());
        var groupMembers = g.getGroupMembersOf(group.getDescriptor());
        assertFalse(groupMembers.getGraphMemberships().stream().anyMatch(x -> x.getMemberDescriptor().equals(group.getDescriptor())));
    }

    @Test
    public void shouldAllowGroupInGroup() throws AzDException {
        var group = g.getGroups().getGraphGroups().stream().filter(x -> x.getDisplayName().endsWith("Project Collection Administrators")).findFirst().get();
        var subject = g.getGroups().getGraphGroups().stream().filter(x -> x.getDisplayName().endsWith("Project-Scoped Users")).findFirst().get();
        var groupMembers = g.getGroupMembersOf(group.getDescriptor());
        assumeFalse(groupMembers.getGraphMemberships().stream().anyMatch(x -> x.getMemberDescriptor().equals(subject.getDescriptor())));
        g.addMembership(subject.getDescriptor(), group.getDescriptor());
        groupMembers = g.getGroupMembersOf(group.getDescriptor());
        assertTrue(groupMembers.getGraphMemberships().stream().anyMatch(x -> x.getMemberDescriptor().equals(subject.getDescriptor())));
        g.removeMembership(subject.getDescriptor(), group.getDescriptor());
    }

    @Test
    public void shouldCreateGroup() throws AzDException {
        var groupName = "my-new-org-group";
        GraphMembership group = g.createGroup(groupName, "this is a local org group");
        group.toString();
    }

    @Test
    public void shouldRemoveGroup() throws AzDException {
        var groupName = "my-new-org-group";
        GraphGroup graphGroup = g.getGroups().getGraphGroups().stream().filter(x -> x.getDisplayName().endsWith(groupName)).findAny().get();
        g.deleteGroup(graphGroup.getDescriptor());
    }

}
