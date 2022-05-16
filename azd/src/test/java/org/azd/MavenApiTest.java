package org.azd;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.azd.enums.MavenPackagePromote;
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

    @Test
    public void shouldGetPackageVersion() throws AzDException {
        mvn.getPackageVersion("maven-feed", "org.HelloWorld", "HelloWorld", "1.0.0");
    }

    @Test
    public void shouldGetPackageVersionWithQueryParameters() throws AzDException {
        mvn.getPackageVersion("maven-feed", "org.tester.maven", "MavenTester", "1.1.0", true);
    }

    @Test
    public void shouldGetPackageVersionFromRecycleBin() throws AzDException {
        mvn.getPackageVersionFromRecycleBin("maven-feed", "org.jack.click", "ClickJack","2.5.0");
    }
    
    @Test
    public void shouldGetUpstreamingBehavior() throws AzDException {
        mvn.getUpstreamingBehavior("maven-feed", "org.HelloWorld", "HelloWorld");
    }

    // @Test
    // public void shouldDownloadPackage() throws AzDException {
    //     var t=mvn.downloadPackage("test2", "com.acme", "app", "1.0.2", "app-1.0.2.zip");
    //     System.out.println("t");
    // }

    @Test
    public void shouldDeletePackageVersion() throws AzDException {
        mvn.deletePackageVersion("maven-feed", "org.jack.click", "ClickJack", "2.5.0");
    }

    @Test
    public void shouldDeletePackageVersionFromRecycleBin() throws AzDException {
        mvn.deletePackageVersionFromRecycleBin("maven-feed", "org.jack.click", "ClickJack", "3.0.0");
    }

    @Test
    public void shouldUpdatePackageVersion() throws AzDException {
        mvn.updatePackageVersion("maven-feed", "org.HelloWorld", "HelloWorld", "1.0.0", MavenPackagePromote.PRERELEASE);
    }

    @Test
    public void shouldUpdatePackageVersions() throws AzDException {
        List packages = new ArrayList<>();

        Map<String, Object> p1 = new HashMap<>();
        p1.put("group", "org.HelloWorld");
        p1.put("artifact", "HelloWorld");
        p1.put("version", "1.0.0");
        packages.add(p1);
        
        Map<String, Object> p2 = new HashMap<>();
        p2.put("group", "org.tester.maven");
        p2.put("artifact", "MavenTester");
        p2.put("version", "1.1.0");
        packages.add(p2);

        mvn.updatePackageVersions("maven-feed", MavenPackagePromote.PRERELEASE, packages);
    }

    @Test
    public void shouldRestorePackageVersionFromRecycleBin() throws AzDException, InterruptedException {
        org.azd.maven.types.Package pkg = null;
        try {
            pkg = mvn.getPackageVersion("maven-feed", "org.jack.click", "ClickJack", "1.5.0");
        } catch (Exception e) { }
        if (pkg != null) {
            mvn.deletePackageVersion("maven-feed", "org.jack.click", "ClickJack", "1.5.0");
            Thread.sleep(3000); // Wait until package is deleted.
        }

        mvn.restorePackageVersionFromRecycleBin("maven-feed", "org.jack.click", "ClickJack", "1.5.0");
    }
}
