package org.azd;

import java.io.File;

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
        mvn.getPackageVersion("test2", "com.acme", "app", "1.0.0");
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

    @Test
    public void shouldUpdatePackageVersion() throws AzDException {
        mvn.updatePackageVersion("test2", "com.acme", "app", "1.0.1", "PRERELEASE");
    }


}
