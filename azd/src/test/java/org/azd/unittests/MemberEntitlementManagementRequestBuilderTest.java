package org.azd.unittests;

import org.azd.UnitTestConfiguration;
import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.common.types.JsonPatchDocument;
import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.legacy.MockParameters;
import org.azd.memberentitlementmanagement.MemberEntitlementManagementRequestBuilder;
import org.azd.memberentitlementmanagement.types.*;
import org.azd.serviceclient.AzDService;
import org.azd.serviceclient.AzDServiceClient;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;

public class MemberEntitlementManagementRequestBuilderTest {
    private static final SerializerContext serializer = InstanceFactory.createSerializerContext();
    private static AzDServiceClient client;
    private static UnitTestConfiguration testConfiguration;
    private static MemberEntitlementManagementRequestBuilder mem;

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
        mem = client.memberEntitlementManagement();
    }

    @Test
    public void shouldGetGroupEntitlements() throws AzDException {
        mem.groupEntitlements().list();
    }

    @Test(expected = AzDException.class)
    public void shouldGetGroupEntitlement() throws AzDException {
        mem.groupEntitlements().get("0000-000000-0000-0000-0000");
    }

    @Test
    public void shouldGetUsersEntitlementSummary() throws AzDException {
        mem.userEntitlementSummary().get("AccessLevels", "Licenses", "Projects", "Groups");
    }

    @Test
    public void shouldAddUserEntitlement() throws AzDException {
        var p = client.core().projects().get();
        var userEntitlement = new UserEntitlement();

        var accessLevel = new AccessLevel();
        accessLevel.setAccountLicenseType(AccountLicenseType.EXPRESS.toString().toLowerCase());

        var group = new Group();
        group.setGroupType(GroupType.PROJECT_CONTRIBUTOR);

        var projRef = new ProjectRef();
        projRef.setId(p.getId());

        var projectEntitlement = new ProjectEntitlement();
        projectEntitlement.setGroup(group);
        projectEntitlement.setProjectRef(projRef);

        var user = new GraphUser();
        user.setPrincipalName("test@xmail.com");
        user.setSubjectKind("user");

        userEntitlement.setAccessLevel(accessLevel);
        userEntitlement.setUser(user);
        userEntitlement.setProjectEntitlements(List.of(projectEntitlement));

        mem.userEntitlements().add(userEntitlement);
    }

    @Test
    public void shouldGetUsersEntitlements() throws AzDException {
        mem.userEntitlements().search();
    }

    @Test
    public void shouldUpdateUsersEntitlement() throws AzDException {
        var userId = mem.userEntitlements().search().getUsers().stream()
                .filter(x -> x.getUser().getDisplayName().equals("test@xmail.com"))
                .findFirst().get().getId();

        var jsonPatchDocument = new JsonPatchDocument();
        jsonPatchDocument.setOperation(PatchOperation.REPLACE);
        jsonPatchDocument.setPath("/accessLevel");
        jsonPatchDocument.setValue(new LinkedHashMap<String, Object>() {{
            put("accountLicenseType", AccountLicenseType.STAKEHOLDER.toString().toLowerCase());
            put("licensingSource", LicensingSource.ACCOUNT.toString().toLowerCase());
        }});
        mem.userEntitlements().update(userId, List.of(jsonPatchDocument));
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteUsersEntitlement() throws AzDException {
//        var userId = mem.getUserEntitlements().getMembers().stream()
//                .filter(x -> x.getUser().getDisplayName().equals("test@xmail.com"))
//                .findFirst().get().getId();
        // Muting it as it is clashing with other tests
        mem.userEntitlements().delete("0000-00000-00000-000000-000000");
    }
}
