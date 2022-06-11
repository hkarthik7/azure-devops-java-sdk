package org.azd;

import org.azd.core.CoreApi;
import org.azd.core.types.Project;
import org.azd.exceptions.AzDException;
import org.azd.git.GitApi;
import org.azd.git.types.Repository;
import org.azd.graph.GraphApi;
import org.azd.graph.types.GraphGroup;
import org.azd.graph.types.GraphUser;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.*;
import org.azd.security.SecurityToken;
import org.azd.security.types.*;
import org.azd.utils.AzDClientApi;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.junit.Assume.*;

public class SecurityApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static AzDClient webApi;
    private static SecurityDetails s;


    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        webApi = new AzDClientApi(organization, project, token);
        s = webApi.getSecurityApi();
    }

    @Test
    public void shouldListSecurityNamespaces() throws AzDException {
        SecurityNamespaces securityNamespaces = s.getNamespaces();
        assertFalse(securityNamespaces.getSecurityNamespaces().isEmpty());
    }

    @Test
    public void shouldGetANamespace() throws AzDException {
        var namespace = "Git Repositories";
        SecurityNamespace securityNamespace = s.getNamespaces().getSecurityNamespaces().stream().filter(x -> x.getDisplayName().equals(namespace)).findFirst().get();
        SecurityNamespace securityNamespace1 = s.getNamespace(securityNamespace.getNamespaceId());
        assertEquals(securityNamespace.getDisplayName(), securityNamespace1.getDisplayName());
    }

    @Test
    public void shouldListACLs() throws AzDException {
        var namespace = "Git Repositories";
        SecurityNamespace securityNamespace = s.getNamespaces().getSecurityNamespaces().stream().filter(x -> x.getDisplayName().equals(namespace)).findFirst().get();
        ACLs acLs = s.getAccessControlLists(securityNamespace.getNamespaceId());
        assertFalse(acLs.getACLs().isEmpty());
        Optional<ACL> no_extended = acLs.getACLs().stream().filter(x -> x.getAcesDictionary().values().stream().anyMatch(y -> y.getExtendedInfo() == null)).findAny();
        assertTrue(no_extended.isPresent());
    }

    @Test
    public void shouldListACLsWithExtendedInfo() throws AzDException {
        var namespace = "Git Repositories";
        CoreApi coreApi = webApi.getCoreApi();
        Optional<Project> anyProject = coreApi.getProjects().getProjects().stream().findAny();
        Assume.assumeTrue(anyProject.isPresent());
        SecurityNamespace securityNamespace = s.getNamespaces().getSecurityNamespaces().stream().filter(x -> x.getDisplayName().equals(namespace)).findFirst().get();
        String token = SecurityToken.generate(SecurityToken.Scope.GIT, Map.of("PROJECT_ID", anyProject.get().getId()));
        ACLs acLs = s.getAccessControlLists(securityNamespace.getNamespaceId(), null, token, true, false);
        assertFalse(acLs.getACLs().isEmpty());
        Optional<ACL> any = acLs.getACLs().stream().filter(x -> x.getAcesDictionary().values().stream().anyMatch(y -> y.getExtendedInfo() != null && y.getExtendedInfo().getEffectiveAllow() != null)).findAny();
        assertTrue(any.isPresent());
    }

    @Test
    public void shouldResolveSubjectIdentities() throws AzDException {
        final Map<String, String> expectedIdentifierDomain = Map.of(
                "aad", "Microsoft.IdentityModel.Claims.ClaimsIdentity",
                "svc", "Microsoft.TeamFoundation.ServiceIdentity",
                "bnd", "Microsoft.TeamFoundation.BindPendingIdentity",
                "vssgp", "Microsoft.TeamFoundation.Identity",
                "aadgp", "Microsoft.TeamFoundation.Identity"
        );
        GraphDetails g = webApi.getGraphApi();
        var allusers = g.getUsers().getUsers();
        var allgroups = g.getGroups().getGraphGroups();
        List<String> allIdentifiers = new ArrayList<>();
        for (String prefix : expectedIdentifierDomain.keySet()) {
            var u_opt = allusers.stream().map(GraphUser::getDescriptor);
            var g_opt = allgroups.stream().map(GraphGroup::getDescriptor);
            Optional<String> any = Stream.concat(u_opt, g_opt).filter(x -> x.startsWith(prefix)).findAny();
            if (any.isPresent()) allIdentifiers.add(any.get());
        }
        Identities identitiesFromSubjectDescriptors = s.getIdentitiesFromSubjectDescriptors(allIdentifiers.toArray(new String[0]));
        for (Identity identity : identitiesFromSubjectDescriptors.getIdentities()) {
            var prefix = identity.getSubjectDescriptor().split("\\.")[0];
            assertTrue(expectedIdentifierDomain.containsKey(prefix));
            assertTrue(identity.getDescriptor().startsWith(expectedIdentifierDomain.get(prefix)));
        }
    }


    @Test
    public void shouldListACLForDescriptor() throws AzDException {
        GraphDetails g = webApi.getGraphApi();
        CoreDetails c = webApi.getCoreApi();

        Optional<GraphUser> aadUser = g.getUsers().getUsers().stream().filter(x -> x.getDescriptor().startsWith("aad")).findAny();
        assumeTrue(aadUser.isPresent());
        Project project = c.getProject("my-awesome-project");
        assumeTrue(project != null);
        var namespace = "Git Repositories";
        SecurityNamespace securityNamespace = s.getNamespaces().getSecurityNamespaces().stream().filter(x -> x.getDisplayName().equals(namespace)).findFirst().get();


        ACLs acLs = s.getAccessControlLists(securityNamespace.getNamespaceId(), new String[]{aadUser.get().getDescriptor()}, null, false, false);
        assertNotNull(acLs.getACLs());
        assertFalse(acLs.getACLs().isEmpty());
    }

    /***
     * not really a test. Dump all actions to see bitmasks
     * @throws AzDException
     */
    @Test
    @Ignore
    public void shouldDumpAllNamespaceActions() throws AzDException {
        List<SecurityNamespace> securityNamespaces = s.getNamespaces().getSecurityNamespaces();
        for (SecurityNamespace ns : securityNamespaces) {
            System.out.println("Namespace: " + ns.getDisplayName());
            ns.getActions().stream().forEach(x -> {
                System.out.println("  Action: " + x.getDisplayName() + " ("+x.getBit()+")");
            });
        }
    }

    @Test
    public void shouldGenerateTokenString() throws AzDException {
        String expected;
        String generated = SecurityToken.generate(SecurityToken.Scope.GIT, Map.of());
        expected = "repoV2";
        assertEquals(expected, generated);
        String generated2 = SecurityToken.generate(SecurityToken.Scope.GIT, Map.of(
                "PROJECT_ID", "my-project-id",
                "REPO_ID", "repository-id"
        ));
        expected = "repoV2/my-project-id/repository-id";
        assertEquals(expected, generated2);
    }

    /***
     * - lookup a user and a repository
     * - get current ACL
     * - update ACL
     * - re-fetch ACL and compare, assert allow / deny value changed
     * - reset ACL
     * @throws AzDException
     */
    @Test
    public void shouldAddAccessControlList() throws AzDException {
        var projectName = "my-awesome-project";
        GitApi gitApi = webApi.getGitApi();
        CoreApi coreApi = webApi.getCoreApi();
        GraphApi graphApi = webApi.getGraphApi();

        long allowMask = 1 + 2 + 4 + 256 + 1024;
        long denyMask = 8 + 16 + 32;
        Optional<GraphUser> userOptional = graphApi.getUsers().getUsers().stream().filter(x -> x.getDescriptor().startsWith("aad")).findAny();
        assertTrue(userOptional.isPresent());
        Optional<Repository> repositoryOptional = gitApi.getRepositories().getRepositories().stream().filter(x -> x.getProject().getName().equals(projectName)).findAny();
        assumeTrue(repositoryOptional.isPresent());
        System.out.println("" + repositoryOptional.get());

        Identities identitiesFromSubjectDescriptors = s.getIdentitiesFromSubjectDescriptors(userOptional.get().getDescriptor());
        String descriptor = identitiesFromSubjectDescriptors.getIdentities().stream().findFirst().get().getDescriptor();
        System.out.println(userOptional.get().getDescriptor() + " ==> " + descriptor);

        String token = SecurityToken.generate(SecurityToken.Scope.GIT, Map.of(
                "PROJECT_ID", repositoryOptional.get().getProject().getId(),
                "REPO_ID", repositoryOptional.get().getId()
        ));
        System.out.println("Token: " + token);
        ACLs accessControlLists = s.getAccessControlLists(SecurityToken.Scope.GIT.getNamespace(), new String[]{descriptor}, token, false, false);
        assertTrue(accessControlLists.getACLs().size() == 1);
        assertTrue(accessControlLists.getACLs().get(0).getAcesDictionary().containsKey(descriptor));
        ACE currentEntry = accessControlLists.getACLs().get(0).getAcesDictionary().get(descriptor);
        //accessControlLists.getACLs().stream().map(ACL::toString).forEach(System.out::println);
        ACL newACL = new ACL();
        newACL.setToken(token);
        ACE entry = new ACE();
        entry.setDescriptor(descriptor);
        if (allowMask == currentEntry.getAllow()) {
            // flip a bit in case allow is already the same
            allowMask = allowMask ^ 1;
         }
        entry.setAllow(allowMask);
        entry.setDeny(denyMask);
        newACL.setAcesDictionary(Map.of(descriptor, entry));
        ACLs newAclSet = new ACLs();
        newAclSet.setACLs(List.of(newACL));
        try {
            s.setAccessControlList(SecurityToken.Scope.GIT.getNamespace(), newAclSet);

            ACLs updatedControlLists = s.getAccessControlLists(SecurityToken.Scope.GIT.getNamespace(), new String[]{descriptor}, token, false, false);

            assertTrue(updatedControlLists.getACLs().size() == 1);
            assertTrue(updatedControlLists.getACLs().get(0).getAcesDictionary().containsKey(descriptor));
            assertNotEquals(updatedControlLists.getACLs().get(0).getAcesDictionary().get(descriptor).getAllow(), accessControlLists.getACLs().get(0).getAcesDictionary().get(descriptor).getAllow());
            assertNotEquals(updatedControlLists.getACLs().get(0).getAcesDictionary().get(descriptor).getDeny(), accessControlLists.getACLs().get(0).getAcesDictionary().get(descriptor).getDeny());
        } finally {
            s.setAccessControlList(SecurityToken.Scope.GIT.getNamespace(), accessControlLists);
        }
    }

    /***
     * - lookup a user and a repository
     * - get current ACL
     * - update ACE with merge flag set
     * - re-fetch ACL and compare:
     *   - deny value should be our mask OR'd with original values
     *   , allow value should be our mask OR'd with original values + with deny bits unset
     * - reset ACL
     *
     * Not necessarily universal.
     * Depending on the internal permission logic, denying access to one action may implicitly deny other actions.
     * i.e. in git permissions, bit 1 (admin) appears to be flipped depending on other allow/deny values
     * @throws AzDException
     */
    @Test
    public void shouldUpdateAccessControlEntry() throws AzDException {
        var projectName = "my-awesome-project";
        long allowMask = 2+4+16;
        long denyMask = 256+512;
        GitApi gitApi = webApi.getGitApi();
        CoreApi coreApi = webApi.getCoreApi();
        GraphApi graphApi = webApi.getGraphApi();

        //s.getNamespace(SecurityToken.Scope.GIT.getNamespace()).getActions().stream().sorted(Comparator.comparingInt(x -> x.getBit())).forEach(x -> System.out.println("Action ("+x.getBit()+"): " + x.getDisplayName()));
        Optional<GraphUser> userOptional = graphApi.getUsers().getUsers().stream().filter(x -> x.getDescriptor().startsWith("aad")).findAny();
        assertTrue(userOptional.isPresent());
        Optional<Repository> repositoryOptional = gitApi.getRepositories().getRepositories().stream().filter(x -> x.getProject().getName().equals(projectName)).findAny();
        assumeTrue(repositoryOptional.isPresent());
        //System.out.println("" + repositoryOptional.get());

        Identities identitiesFromSubjectDescriptors = s.getIdentitiesFromSubjectDescriptors(userOptional.get().getDescriptor());
        String descriptor = identitiesFromSubjectDescriptors.getIdentities().stream().findFirst().get().getDescriptor();
        System.out.println(userOptional.get().getDescriptor() + " ==> " + descriptor);

        String token = SecurityToken.generate(SecurityToken.Scope.GIT, Map.of(
                "PROJECT_ID", repositoryOptional.get().getProject().getId(),
                "REPO_ID", repositoryOptional.get().getId()
        ));
        System.out.println("Token: " + token);
        ACLs accessControlLists = s.getAccessControlLists(SecurityToken.Scope.GIT.getNamespace(), new String[]{descriptor}, token, false, false);
        assertTrue(accessControlLists.getACLs().size() == 1);
        assertTrue(accessControlLists.getACLs().get(0).getAcesDictionary().containsKey(descriptor));
        //System.out.println("Original: ");
        //accessControlLists.getACLs().stream().map(ACL::toString).forEach(System.out::println);
        ACEs newACEs = new ACEs();
        newACEs.setMerge(true);
        newACEs.setToken(token);
        ACE entry = new ACE();
        entry.setDescriptor(descriptor);
        entry.setAllow(allowMask);
        entry.setDeny(denyMask);
        newACEs.setAccessControlEntries(List.of(entry));
        try {
            s.setAccessControlEntries(SecurityToken.Scope.GIT.getNamespace(), newACEs);

            ACLs updatedControlLists = s.getAccessControlLists(SecurityToken.Scope.GIT.getNamespace(), new String[]{descriptor}, token, false, false);
            //System.out.println("Updated: ");
            //updatedControlLists.getACLs().stream().map(ACL::toString).forEach(System.out::println);

            assertTrue(updatedControlLists.getACLs().size() == 1);
            assertTrue(updatedControlLists.getACLs().get(0).getAcesDictionary().containsKey(descriptor));
            BitSet originalAllow = BitSet.valueOf(new long[]{accessControlLists.getACLs().get(0).getAcesDictionary().get(descriptor).getAllow()});
            BitSet originalDeny = BitSet.valueOf(new long[]{accessControlLists.getACLs().get(0).getAcesDictionary().get(descriptor).getDeny()});
            BitSet deltaAllow = BitSet.valueOf(new long[]{allowMask});
            BitSet deltaDeny = BitSet.valueOf(new long[]{denyMask});
            deltaAllow.or(originalAllow);
            deltaDeny.or(originalDeny);

            deltaAllow.andNot(deltaDeny);

            BitSet updatedAllow = BitSet.valueOf(new long[]{updatedControlLists.getACLs().get(0).getAcesDictionary().get(descriptor).getAllow()});
            BitSet updatedDeny = BitSet.valueOf(new long[]{updatedControlLists.getACLs().get(0).getAcesDictionary().get(descriptor).getDeny()});

            assertEquals(deltaAllow, updatedAllow);
            assertEquals(deltaDeny, updatedDeny);

            assertEquals(0, Arrays.compare(updatedAllow.toLongArray(), deltaAllow.toLongArray()));
            assertEquals(0, Arrays.compare(updatedDeny.toLongArray(), deltaDeny.toLongArray()));
        } finally {
            s.setAccessControlList(SecurityToken.Scope.GIT.getNamespace(), accessControlLists);
        }
    }
}
