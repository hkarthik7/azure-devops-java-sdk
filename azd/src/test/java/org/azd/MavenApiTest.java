package org.azd;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.AzDClient;
import org.azd.interfaces.MavenDetails;
import org.azd.utils.AzDClientApi;
import org.junit.Before;
import org.junit.Test;

public class MavenApiTest {

    private static final JsonMapper MAPPER = new JsonMapper();
    private static AzDClient webApi;
    private static MavenDetails mvn;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        webApi = new AzDClientApi(organization, project, token);
        mvn = webApi.getMavenApi();
    }

    @Test(expected = AzDException.class)
    public void shouldGetPackageVersion() throws AzDException {
        mvn.getPackageVersion("test2", "com.acme", "app", "1.0.5");
    }

    @Test(expected = AzDException.class)
    public void shouldGetPackageVersionWithQueryParameters() throws AzDException {
        mvn.getPackageVersion("test2", "com.acme", "app", "1.0.4", true);
    }

    @Test(expected = AzDException.class)
    public void shouldGetPackageVersionFromRecycleBin() throws AzDException {
        mvn.getPackageVersionFromRecycleBin("test2", "com.acme", "app","1.0.4");
    }
    
    @Test(expected = AzDException.class)
    public void shouldGetUpstreamingBehavior() throws AzDException {
        mvn.getUpstreamingBehavior("test2", "com.acme", "app");
    }

    // @Test
    // public void shouldDownloadPackage() throws AzDException {
    //     var t=mvn.downloadPackage("test2", "com.acme", "app", "1.0.2", "app-1.0.2.zip");
    //     System.out.println("t");
    // }

    @Test(expected = AzDException.class)
    public void shouldDeletePackageVersion() throws AzDException {
        mvn.deletePackageVersion("test2", "com.acme", "app", "1.0.2");
    }

    @Test(expected = AzDException.class)
    public void shouldDeletePackageVersionFromRecycleBin() throws AzDException {
        mvn.deletePackageVersionFromRecycleBin("test2", "com.acme", "app", "1.0.2");
    }

    @Test(expected = AzDException.class)
    public void shouldUpdatePackageVersion() throws AzDException {
        mvn.updatePackageVersion("test2", "com.acme", "app", "1.0.1", "PRERELEAS");
    }

    @Test(expected = AzDException.class)
    public void shouldUpdatePackageVersions() throws AzDException {
        List packages = new ArrayList<>();

        Map<String, Object> p1 = new HashMap<>();
        p1.put("group", "com.acme");
        p1.put("artifact", "app");
        p1.put("version", "1.0.0");
        packages.add(p1);
        
        Map<String, Object> p2 = new HashMap<>();
        p2.put("group", "com.acme");
        p2.put("artifact", "app");
        p2.put("version", "1.0.1");
        packages.add(p2);

        mvn.updatePackageVersions("test2", "tes", packages);
    }

    @Test(expected = AzDException.class)
    public void shouldrestorePackageVersionFromRecycleBin() throws AzDException{
        mvn.restorePackageVersionFromRecycleBin("test2", "com.acme", "app", "1.0.3");
    }


}
