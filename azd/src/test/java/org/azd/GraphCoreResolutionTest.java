package org.azd;

import org.azd.exceptions.AzDException;
import org.azd.graph.types.GraphMembership;
import org.azd.graph.types.SubjectLookupResponse;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.AzDClient;
import org.azd.interfaces.CoreDetails;
import org.azd.interfaces.GraphDetails;
import org.azd.utils.AzDClientApi;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

/***
 * additional tests for graph api which require other (Core) API components
 * to perform object lookups
 */
public class GraphCoreResolutionTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static AzDClient webApi;
    private static GraphDetails g;
    private static CoreDetails c;

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
        c = webApi.getCoreApi();
    }

    @Test
    public void shouldResolveDescriptorForProject() throws AzDException {
        var p = c.getProjects().getProjects().stream().findAny().get();
        var d = g.getDescriptor(p.getId());
        System.out.println(p.getName());
        System.out.println(d.getValue());
    }

    @Test
    public void shouldLookupMultipleSubjects() throws AzDException {
        var group = g.getGroups().getGraphGroups().stream().filter(x -> x.getDisplayName().equals("Contributors")).findAny().get();
        var members = g.getGroupMembersOf(group.getDescriptor()).getGraphMemberships();
        SubjectLookupResponse subjectLookupResponse = g.subjectLookup(members.stream().map(GraphMembership::getMemberDescriptor).collect(Collectors.toList()).toArray(new String[0]));
        assertEquals(members.size(), subjectLookupResponse.getValue().size());
    }

    @Test
    public void shouldCreateProjectGroup() throws AzDException {
        var groupName = "my-new-group";
        var p = c.getProjects().getProjects().stream().filter(x -> x.getName().equals("My-Project")).findAny().get();
        var p_descriptor = g.getDescriptor(p.getId()).getValue();
        assumeFalse(g.getGroups().getGraphGroups().stream().anyMatch(x -> x.getDisplayName().endsWith(groupName)));
        GraphMembership group = g.createGroup(groupName, "description for " + groupName, p_descriptor);
        assertTrue(g.getGroups().getGraphGroups().stream().anyMatch(x -> x.getDisplayName().endsWith(groupName)));
    }

}
