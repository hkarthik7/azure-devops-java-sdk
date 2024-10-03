package org.azd.unittests;

import org.azd.UnitTestConfiguration;
import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.core.types.Project;
import org.azd.enums.Instance;
import org.azd.exceptions.AzDException;
import org.azd.git.types.GitRepository;
import org.azd.graph.types.GraphGroup;
import org.azd.graph.types.GraphGroupVstsCreationContext;
import org.azd.graph.types.GraphUser;
import org.azd.legacy.MockParameters;
import org.azd.pipelines.types.Pipeline;
import org.azd.security.SecurityRequestBuilder;
import org.azd.security.SecurityToken;
import org.azd.security.types.*;
import org.azd.serviceclient.AzDService;
import org.azd.serviceclient.AzDServiceClient;
import org.azd.utils.StringUtils;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

public class SecurityRequestBuilderTest {
    private static final SerializerContext serializer = InstanceFactory.createSerializerContext();
    private static AzDServiceClient client;
    private static UnitTestConfiguration testConfiguration;
    private static SecurityRequestBuilder s;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        var file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        var configFile = new File(dir + "/src/test/java/org/azd/config.json");
        var m = serializer.deserialize(file, MockParameters.class);
        testConfiguration = serializer.deserialize(configFile, UnitTestConfiguration.class);
        String organization = m.getO();
        String token = m.getT();
        String project = "My-Project";
        var pat = new PersonalAccessTokenCredential(Instance.BASE_INSTANCE.append(organization), project, token);
        client = AzDService.builder()
                .authentication(pat)
                .buildClient();
        s = client.security();
    }

    @Test
    public void shouldListSecurityNamespaces() throws AzDException {
        SecurityNamespaces securityNamespaces = s.securityNamespaces().query(StringUtils.EMPTY, false);
        assertFalse(securityNamespaces.getSecurityNamespaces().isEmpty());
    }

    @Test
    public void shouldGetANamespace() throws AzDException {
        var namespace = "Git Repositories";
        SecurityNamespace securityNamespace = s.securityNamespaces()
                .query(StringUtils.EMPTY, false)
                .getSecurityNamespaces()
                .stream()
                .filter(x -> x.getDisplayName().equals(namespace))
                .findFirst()
                .get();
        SecurityNamespace securityNamespace1 = s.securityNamespaces()
                .query(securityNamespace.getNamespaceId(), false)
                .getSecurityNamespaces()
                .get(0);
        assertEquals(securityNamespace.getDisplayName(), securityNamespace1.getDisplayName());
    }

    @Test
    public void shouldListACLs() throws AzDException {
        var namespace = "Git Repositories";
        SecurityNamespace securityNamespace = s.securityNamespaces()
                .query(StringUtils.EMPTY, false)
                .getSecurityNamespaces()
                .stream()
                .filter(x -> x.getDisplayName().equals(namespace))
                .findFirst()
                .get();
        ACLs acLs = s.accessControlLists().query(securityNamespace.getNamespaceId(), r -> {
            r.queryParameters.descriptors = null;
            r.queryParameters.includeExtendedInfo = false;
            r.queryParameters.token = null;
            r.queryParameters.recurse = false;
        });
        assertFalse(acLs.getACLs().isEmpty());
        Optional<ACL> no_extended = acLs.getACLs().stream().filter(x -> x
                .getAcesDictionary()
                .values()
                .stream()
                .anyMatch(y -> y.getExtendedInfo() == null))
                .findAny();
        assertTrue(no_extended.isPresent());
    }

    @Test
    public void shouldListACLsWithExtendedInfo() throws AzDException {
        var namespace = "Git Repositories";
        Optional<Project> anyProject = client.core().projects().list().getProjects().stream().findAny();
        Assume.assumeTrue(anyProject.isPresent());
        SecurityNamespace securityNamespace = s.securityNamespaces()
                .query(StringUtils.EMPTY, false)
                .getSecurityNamespaces()
                .stream()
                .filter(x -> x.getDisplayName().equals(namespace))
                .findFirst()
                .get();
        String token = SecurityToken.generate(SecurityToken.Scope.Collection, Map.of());
        //String token = SecurityToken.generate(SecurityToken.Scope.GIT, Map.of("PROJECT_ID", anyProject.get().getId()));
        ACLs acLs = s.accessControlLists().query(securityNamespace.getNamespaceId(), r -> {
            r.queryParameters.descriptors = null;
            r.queryParameters.includeExtendedInfo = true;
            r.queryParameters.token = token;
            r.queryParameters.recurse = false;
        });
        assertFalse(acLs.getACLs().isEmpty());
        Optional<ACL> any = acLs.getACLs().stream().filter(x -> x
                .getAcesDictionary()
                .values()
                .stream()
                .anyMatch(y -> y.getExtendedInfo() != null && y.getExtendedInfo().getEffectiveAllow() != null))
                .findAny();
        assertTrue(any.isPresent());
    }

    @Test
    public void shouldResolveSubjectIdentities() throws AzDException {
        final var expectedIdentifierDomain = Map.of(
                "aad", "Microsoft.IdentityModel.Claims.ClaimsIdentity",
                "svc", "Microsoft.TeamFoundation.ServiceIdentity",
                "bnd", "Microsoft.TeamFoundation.BindPendingIdentity",
                "vssgp", "Microsoft.TeamFoundation.Identity",
                "aadgp", "Microsoft.TeamFoundation.Identity"
        );

        var g = client.graph();
        var allusers = g.users().list().getUsers();
        var allgroups = g.groups().list().getGraphGroups();
        List<String> allIdentifiers = new ArrayList<>();
        for (String prefix : expectedIdentifierDomain.keySet()) {
            var u_opt = allusers.stream().map(GraphUser::getDescriptor);
            var g_opt = allgroups.stream().map(GraphGroup::getDescriptor);
            Optional<String> any = Stream.concat(u_opt, g_opt).filter(x -> x.startsWith(prefix)).findAny();
            any.ifPresent(allIdentifiers::add);
        }
        var identitiesFromSubjectDescriptors = s.identities().read(r ->
                r.queryParameters.subjectDescriptors = allIdentifiers.toArray(new String[0]));
        for (Identity identity : identitiesFromSubjectDescriptors.getIdentities()) {
            var prefix = identity.getSubjectDescriptor().split("\\.")[0];
            assertTrue(expectedIdentifierDomain.containsKey(prefix));
            assertTrue(identity.getDescriptor().startsWith(expectedIdentifierDomain.get(prefix)));
        }
    }


    @Test
    public void shouldListACLForDescriptor() throws AzDException {
        var g = client.graph();
        var c = client.core();

        Optional<GraphUser> aadUser = g.users().list().getUsers().stream().filter(x -> x.getDescriptor().startsWith("aad")).findAny();
        assumeTrue(aadUser.isPresent());
        Project project = c.projects().get("my-awesome-project");
        assumeTrue(project != null);
        var namespace = "Git Repositories";
        SecurityNamespace securityNamespace = s.securityNamespaces().
                query(StringUtils.EMPTY, false)
                .getSecurityNamespaces()
                .stream()
                .filter(x -> x.getDisplayName().equals(namespace))
                .findFirst()
                .get();


        ACLs acLs = s.accessControlLists().query(securityNamespace.getNamespaceId(), r ->
        {
            r.queryParameters.descriptors = new String[]{aadUser.get().getDescriptor()};
            r.queryParameters.token = null;
            r.queryParameters.includeExtendedInfo = false;
            r.queryParameters.recurse = false;
        });
        assertNotNull(acLs.getACLs());
        assertFalse(acLs.getACLs().isEmpty());
    }

    /**
     * not really a test. Dump all actions to see bitmasks
     *
     * @throws AzDException
     */
    @Test
    @Ignore
    public void shouldDumpAllNamespaceActions() throws AzDException {
        List<SecurityNamespace> securityNamespaces = s.securityNamespaces().query(StringUtils.EMPTY, false).getSecurityNamespaces();
        for (SecurityNamespace ns : securityNamespaces) {
            System.out.println("Namespace: " + ns.getDisplayName());
            ns.getActions().stream().forEach(x -> {
                System.out.println("  Action: " + x.getDisplayName() + " (" + x.getBit() + ")");
            });
        }
    }

    @Test
    public void shouldGenerateTokenString() {
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

    @Test
    public void shouldListRequiredTokenProperties() {
        Set<String> keys = SecurityToken.keys(SecurityToken.Scope.GIT);
        assertEquals(2, keys.size());
        assertTrue(keys.contains("PROJECT_ID"));
        assertTrue(keys.contains("REPO_ID"));
    }

    @Test(expected = AssertionError.class)
    public void shouldAddAndRemoveACL() throws AzDException {
        var coreApi = client.core();
        var pipelinesApi = client.pipelines();
        var graphApi = client.graph();
        long allowMask = 1 + 2 + 4 + 256 + 1024;
        long denyMask = 8 + 16 + 32;

        // create a group
        var graphGroupCreationContext = new GraphGroupVstsCreationContext();
        graphGroupCreationContext.displayName = "test-acl-group";
        graphGroupCreationContext.description = "test group created to grant new permissions";
        graphApi.groups().create(graphGroupCreationContext);
        Optional<GraphGroup> groupOptional = graphApi.groups().list()
                .getGraphGroups()
                .stream()
                .filter(x -> x.getDisplayName().equals("test-acl-group"))
                .findAny();
        assertTrue(groupOptional.isPresent());
        Identities identitiesFromSubjectDescriptors = s.identities().read(r ->
                r.queryParameters.subjectDescriptors = new String[]{groupOptional.get().getDescriptor()});
        assertTrue(identitiesFromSubjectDescriptors.getIdentities().size() == 1);
        String descriptor = identitiesFromSubjectDescriptors.getIdentities().stream().findFirst().get().getDescriptor();
        System.out.println(groupOptional.get().getDescriptor() + " ==> " + descriptor);

        // random project
        Optional<Project> projectOptional = coreApi.projects().list().getProjects().stream().filter(x -> x.getName().equals("My-Project")).findAny();
        assumeTrue(projectOptional.isPresent());
        Map<String, String> tokenParameters = new HashMap<>() {{
            put("PROJECT_ID", projectOptional.get().getId());
        }};
        Optional<Pipeline> pipelineOptional = pipelinesApi.pipelines().list().getPipelines().stream().findAny();
        pipelineOptional.ifPresent(pipeline -> tokenParameters.put("BUILD_DEFINITION_ID", Integer.toString(pipeline.getId())));
        String projectBuildToken = SecurityToken.generate(SecurityToken.Scope.Build, tokenParameters);
        System.out.println("Generated token: " + projectBuildToken);

        ACLs accessControlLists = s.accessControlLists().query(SecurityToken.Scope.Build.getNamespace(), r ->
        {
           r.queryParameters.descriptors = new String[]{descriptor};
           r.queryParameters.token = projectBuildToken;
           r.queryParameters.includeExtendedInfo = false;
           r.queryParameters.recurse = false;
        });
        assertTrue(accessControlLists.getACLs() == null || accessControlLists.getACLs().isEmpty());
        System.out.println("ACLS: " + accessControlLists);

        ACL newEntry = new ACL();
        ACE ace = new ACE();
        ace.setDescriptor(descriptor);
        ace.setAllow(allowMask);
        ace.setDeny(denyMask);
        newEntry.setToken(projectBuildToken);
        newEntry.setInheritPermissions(false);
        newEntry.setAcesDictionary(Map.of(descriptor, ace));
        ACLs newEntrySet = new ACLs();
        newEntrySet.setACLs(List.of(newEntry));
        try {
            s.accessControlLists().set(SecurityToken.Scope.Build.getNamespace(), newEntrySet);
            Thread.sleep(5000l); // may occasionally fail if we don't wait long enough after removal
            ACLs updatedACL = s.accessControlLists().query(SecurityToken.Scope.Build.getNamespace(), r ->
            {
               r.queryParameters.descriptors = new String[]{descriptor};
               r.queryParameters.token = projectBuildToken;
               r.queryParameters.includeExtendedInfo = false;
               r.queryParameters.recurse = false;
            });
            assertTrue(updatedACL.getACLs() != null && updatedACL.getACLs().size() == 1);
            s.accessControlLists().remove(SecurityToken.Scope.Build.getNamespace(), r ->
            {
               r.queryParameters.recurse = false;
               r.queryParameters.tokens = projectBuildToken;
            });
            Thread.sleep(5000l); // may occasionally fail if we don't wait long enough after removal
            ACLs removedACLs = s.accessControlLists().query(SecurityToken.Scope.Build.getNamespace(), r ->
            {
                r.queryParameters.descriptors = new String[]{descriptor};
               r.queryParameters.token = projectBuildToken;
               r.queryParameters.includeExtendedInfo = false;
               r.queryParameters.recurse = false;
            });
            assertTrue(removedACLs.getACLs() == null || removedACLs.getACLs().isEmpty());
        } catch (InterruptedException e) {
            // ignore
        } finally {
            graphApi.groups().delete(groupOptional.get().getDescriptor());
        }
    }

    /**
     * - lookup a user and a repository
     * - get current ACL
     * - update ACL
     * - re-fetch ACL and compare, assert allow / deny value changed
     * - reset ACL
     *
     * @throws AzDException
     */
    @Test
    public void shouldUpdateAccessControlList() throws AzDException {
        var graphApi = client.graph();

        long allowMask = 1 + 2 + 4 + 256 + 1024;
        long denyMask = 8 + 16 + 32;
        Optional<GraphUser> userOptional = graphApi.users().list().getUsers().stream().findAny();
        assumeTrue(userOptional.isPresent());

        Identities identitiesFromSubjectDescriptors = s.identities().read(r ->
                r.queryParameters.subjectDescriptors = new String[]{userOptional.get().getDescriptor()});
        String descriptor = identitiesFromSubjectDescriptors.getIdentities().stream().findFirst().get().getDescriptor();
        System.out.println(userOptional.get().getDescriptor() + " ==> " + descriptor);

        // scan all ACLs and find one matching our (randomly selected) descriptor
        // copy it with different permissions
        List<ACL> accessControlLists = s.accessControlLists().query(SecurityToken.Scope.GIT.getNamespace(), r ->
        {
            r.queryParameters.descriptors = new String[]{descriptor};
            r.queryParameters.includeExtendedInfo = false;
            r.queryParameters.recurse = false;
        }).getACLs();
        assumeFalse(accessControlLists.isEmpty());

        ACL existingACL = accessControlLists.stream().findAny().get();
        System.out.println("Token: " + existingACL.getToken());
        ACE currentACE = existingACL.getAcesDictionary().get(descriptor);
        ACL newACL = new ACL();
        newACL.setToken(existingACL.getToken());
        ACE entry = new ACE();
        entry.setDescriptor(descriptor);
        if (allowMask == currentACE.getAllow()) {
            // flip a bit in case allow is already the same
            allowMask = allowMask ^ (Math.round(Math.random()) % 1025);
        }
        entry.setAllow(allowMask);
        if (denyMask == currentACE.getDeny()) {
            denyMask = denyMask ^ (Math.round(Math.random()) % 1025);
        }
        entry.setDeny(denyMask);
        newACL.setAcesDictionary(Map.of(descriptor, entry));
        ACLs newAclSet = new ACLs();
        newAclSet.setACLs(List.of(newACL));
        try {
            s.accessControlLists().set(SecurityToken.Scope.GIT.getNamespace(), newAclSet);
            try {
                Thread.sleep(5000l); // delay to allow change to take effect
            } catch (InterruptedException e) {
            }
            ACLs updatedControlLists = s.accessControlLists().query(SecurityToken.Scope.GIT.getNamespace(), r ->
            {
                r.queryParameters.descriptors = new String[]{descriptor};
                r.queryParameters.includeExtendedInfo = false;
                r.queryParameters.recurse = false;
            });

            for (ACL updatedAcl : updatedControlLists.getACLs()) {
                Optional<ACL> originalAcl = accessControlLists.stream()
                        .filter(x -> x.getToken().equals(updatedAcl.getToken()) && x.getAcesDictionary().containsKey(descriptor)).findAny();
                assertTrue(originalAcl.isPresent());
                assertTrue(updatedAcl.getAcesDictionary().containsKey(descriptor));
                StringBuilder sb = new StringBuilder().append("Allow: ")
                        .append(originalAcl.get().getAcesDictionary().get(descriptor).getAllow())
                        .append(" => ").append(updatedAcl.getAcesDictionary().get(descriptor).getAllow())
                        .append(", Deny: ")
                        .append(originalAcl.get().getAcesDictionary().get(descriptor).getDeny())
                        .append(" => ").append(updatedAcl.getAcesDictionary().get(descriptor).getDeny());
                sb.append("    ").append(descriptor).append(" : ").append(updatedAcl.getToken());
                System.out.println(sb.toString());
            }
        } finally {
            ACLs acLs = new ACLs();
            acLs.setACLs(List.of(existingACL));
            s.accessControlLists().set(SecurityToken.Scope.GIT.getNamespace(), acLs);
        }
    }

    /**
     * - lookup a user and a repository
     * - get current ACL
     * - update ACE with merge flag set
     * - re-fetch ACL and compare:
     * - deny value should be our mask OR'd with original values
     * , allow value should be our mask OR'd with original values + with deny bits unset
     * - reset ACL
     * <p>
     * Not necessarily universal.
     * Depending on the internal permission logic, denying access to one action may implicitly deny other actions.
     * i.e. in git permissions, bit 1 (admin) appears to be flipped depending on other allow/deny values
     *
     * @throws AzDException
     */
    @Test
    public void shouldUpdateAccessControlEntry() throws AzDException {
        long allowMask = 2 + 4 + 16;
        long denyMask = 256 + 512;
        var gitApi = client.git();
        var graphApi = client.graph();

        Optional<GraphUser> userOptional = graphApi.users().list().getUsers().stream().findAny();
        assumeTrue(userOptional.isPresent());

        Optional<GitRepository> repositoryOptional = gitApi.repositories().list().getRepositories().stream()
                .filter(x -> x.getName().equals("newRepo"))
                .findFirst();
        assumeTrue(repositoryOptional.isPresent());

        Identities identitiesFromSubjectDescriptors = s.identities().read(r ->
                r.queryParameters.subjectDescriptors = new String[]{userOptional.get().getDescriptor()});
        String descriptor = identitiesFromSubjectDescriptors.getIdentities().stream().findFirst().get().getDescriptor();
        System.out.println(userOptional.get().getDescriptor() + " ==> " + descriptor);

        String token = SecurityToken.generate(SecurityToken.Scope.GIT, Map.of(
                "PROJECT_ID", repositoryOptional.get().getProject().getId(),
                "REPO_ID", repositoryOptional.get().getId()
        ));
        System.out.println("Token: " + token);
        ACLs accessControlLists = s.accessControlLists().query(SecurityToken.Scope.GIT.getNamespace(), r ->
        {
            r.queryParameters.descriptors = new String[]{descriptor};
            r.queryParameters.token = token;
            r.queryParameters.includeExtendedInfo = false;
            r.queryParameters.recurse = false;
        });

        ACEs newACEs = new ACEs();
        newACEs.setMerge(true);
        newACEs.setToken(token);
        ACE entry = new ACE();
        entry.setDescriptor(descriptor);
        entry.setAllow(allowMask);
        entry.setDeny(denyMask);
        newACEs.setAccessControlEntries(List.of(entry));
        try {
            s.accessControlEntries().set(SecurityToken.Scope.GIT.getNamespace(), newACEs);

            try {
                Thread.sleep(5000l); // wait for completion
            } catch (InterruptedException ie) {
            }

            ACLs updatedControlLists = s.accessControlLists().query(SecurityToken.Scope.GIT.getNamespace(), r ->
            {
                r.queryParameters.descriptors = new String[]{descriptor};
                r.queryParameters.token = token;
                r.queryParameters.includeExtendedInfo = false;
                r.queryParameters.recurse = false;
            });

            assertTrue(updatedControlLists.getACLs().size() == 1);
            assertTrue(updatedControlLists.getACLs().get(0).getAcesDictionary().containsKey(descriptor));

            // set original values == 0 if they didn't exist
            BitSet originalAllow = new BitSet();
            BitSet originalDeny = new BitSet();
            if (accessControlLists.getACLs() != null && !accessControlLists.getACLs().isEmpty()) {
                originalAllow = BitSet.valueOf(new long[]{accessControlLists.getACLs().get(0).getAcesDictionary().get(descriptor).getAllow()});
                originalDeny = BitSet.valueOf(new long[]{accessControlLists.getACLs().get(0).getAcesDictionary().get(descriptor).getDeny()});
            }
            BitSet deltaAllow = BitSet.valueOf(new long[]{allowMask});
            BitSet deltaDeny = BitSet.valueOf(new long[]{denyMask});

            // set expected values via bitset operations
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
            if (accessControlLists.getACLs() == null || accessControlLists.getACLs().isEmpty()) {
                s.accessControlEntries().remove(SecurityToken.Scope.GIT.getNamespace(), r ->
                {
                    r.queryParameters.descriptors = new String[]{descriptor};
                    r.queryParameters.token = token;
                });
            } else {
                s.accessControlLists().set(SecurityToken.Scope.GIT.getNamespace(), accessControlLists);
            }
        }
    }
}
