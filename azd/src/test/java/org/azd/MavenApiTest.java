package org.azd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.AzDClient;
import org.azd.interfaces.MavenDetails;
import org.azd.maven.types.BatchOperation;
import org.azd.maven.types.MavenPackageVersionDeletionState;
import org.azd.maven.types.Package;
import org.azd.maven.types.UpstreamingBehavior;
import org.azd.utils.AzDClientApi;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MavenApiTest {

    private static final JsonMapper MAPPER = new JsonMapper();
    private static AzDClient webApi;
    private static MavenDetails mvn;

    private static final String FEED = "maven-feed";
    private static final String TEST1_GROUP = "org.HelloWorld";
    private static final String TEST1_ARTIFACT = "HelloWorld";
    private static final String TEST1_VERSION = "1.0.1";

    private static final String TEST2_GROUP = "org.jack.click";
    private static final String TEST2_ARTIFACT = "ClickJack";
    private static final String TEST2_VERSION = "1.5.0";

    // Recycle bin Package
    private static final String TEST3_GROUP = "org.jack.click";
    private static final String TEST3_ARTIFACT = "ClickJack";
    private static final String TEST3_VERSION = "2.5.0";

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
        System.out.println("Maven API TEST : getPackageVersion");
        Package testPackage=mvn.getPackageVersion(FEED, TEST1_GROUP, TEST1_ARTIFACT, TEST1_VERSION);
        assertEquals(TEST1_GROUP+":"+TEST1_ARTIFACT, testPackage.getId());
        assertEquals(TEST1_VERSION, testPackage.getVersion());
        System.out.println("Maven API TEST : getPackageVersion - OK");
    }

    @Test 
    public void shouldGetPackageVersionWithQueryParameters() throws AzDException { 
        System.out.println("Maven API TEST : getPackageVersion with query parameters");
        Package testPackage=mvn.getPackageVersion(FEED, TEST1_GROUP, TEST1_ARTIFACT, TEST1_VERSION, true);
        assertEquals(TEST1_GROUP+":"+TEST1_ARTIFACT, testPackage.getId());
        assertEquals(TEST1_VERSION, testPackage.getVersion());
        System.out.println("Maven API TEST : getPackageVersion with query parameters - OK");
    }

    public void shouldGetPackageVersionFromRecycleBin() throws AzDException {
        System.out.println("shouldGetPackageVersionFromRecycleBin");
        mvn.getPackageVersionFromRecycleBin(FEED, TEST3_GROUP, TEST3_ARTIFACT, TEST3_VERSION);
        System.out.println("shouldGetPackageVersionFromRecycleBin - OK");
    }
    
    @Test
    public void shouldGetUpstreamingBehavior() throws AzDException {
        System.out.println("Maven API TEST : getUpstreamingBehavior");
        UpstreamingBehavior behavior=mvn.getUpstreamingBehavior(FEED, TEST1_GROUP, TEST1_ARTIFACT);
        assertTrue(behavior.getVersionsFromExternalUpstreams().equals("allowExternalVersions") || behavior.getVersionsFromExternalUpstreams().equals("auto"));        
        System.out.println("Maven API TEST : getUpstreamingBehavior - OK");
    }

    // @Test
    // public void shouldDownloadPackage() throws AzDException {
    //     mvn.downloadPackage("test2", "com.acme", "app", "1.0.2", "app-1.0.2.zip");
    // }

    @Test(expected = AzDException.class)
    public void shouldDeletePackageVersion() throws AzDException {
        System.out.println("Maven API TEST : deletePackageVersion");
        mvn.deletePackageVersion(FEED, TEST1_GROUP, TEST1_GROUP, "0.0.0");
        System.out.println("Maven API TEST : deletePackageVersion - OK");
    }

    @Test(expected = AzDException.class)
    public void shouldDeletePackageVersionFromRecycleBin() throws AzDException {
        System.out.println("Maven API TEST : deletePackageVersionFromRecycleBin");
        mvn.deletePackageVersionFromRecycleBin(FEED, TEST1_GROUP, TEST1_ARTIFACT, "0.0.0");
        System.out.println("Maven API TEST : deletePackageVersionFromRecycleBin - OK");
    }

    @Test
    public void shouldUpdatePackageVersion() throws AzDException {
        System.out.println("Maven API TEST : updatePackageVersion");
        mvn.updatePackageVersion(FEED, TEST1_GROUP, TEST1_ARTIFACT, TEST1_VERSION, "Release");
        System.out.println("Maven API TEST : updatePackageVersion - OK");
    }

    @Test
    public void shouldUpdatePackageVersions() throws AzDException {
        System.out.println("Maven API TEST : updatePackageVersions");
        List packages = new ArrayList<>();

        Map<String, Object> p1 = new HashMap<>();
        p1.put("group", TEST1_GROUP);
        p1.put("artifact", TEST1_ARTIFACT);
        p1.put("version", TEST1_VERSION);
        packages.add(p1);
        
        Map<String, Object> p2 = new HashMap<>();
        p2.put("group", TEST2_GROUP);
        p2.put("artifact", TEST2_ARTIFACT);
        p2.put("version", TEST2_VERSION);
        packages.add(p2);

        mvn.updatePackageVersions(FEED, "Release", BatchOperation.PROMOTE, packages);
        System.out.println("Maven API TEST : updatePackageVersions - OK");
    }

    @Test(expected = AzDException.class)
    public void shouldRestorePackageVersionFromRecycleBin() throws AzDException{
        System.out.println("Maven API TEST : restorePackageVersionFromRecycleBin");
        mvn.restorePackageVersionFromRecycleBin(FEED, TEST1_GROUP, TEST1_ARTIFACT, "0.0.0");
        System.out.println("Maven API TEST : restorePackageVersionFromRecycleBin - OK");
    }

    @Test
    public void shouldSetUpstreamingBehavior() throws AzDException{
        System.out.println("Maven API TEST : setUpstreamingBehavior");
        mvn.setUpstreamingBehavior(FEED, TEST1_GROUP, TEST1_ARTIFACT);
        System.out.println("Maven API TEST : setUpstreamingBehavior - OK");
    }

    @Test
    public void shouldClearUpstreamingBehavior() throws AzDException{
        System.out.println("Maven API TEST : clearUpstreamingBehavior");
        mvn.clearUpstreamingBehavior(FEED, TEST1_GROUP, TEST1_ARTIFACT );
        System.out.println("Maven API TEST : clearUpstreamingBehavior - OK");
    }

    @Test(expected = AzDException.class)
    public void shouldUpdateRecycleBinPackages() throws AzDException{
        System.out.println("Maven API TEST : updateRecycleBinPackages");
        List packages = new ArrayList<>();

        Map<String, Object> p1 = new HashMap<>();
        p1.put("group", TEST1_GROUP);
        p1.put("artifact", TEST1_ARTIFACT);
        p1.put("version", TEST1_VERSION);
        packages.add(p1);
        
        Map<String, Object> p2 = new HashMap<>();
        p2.put("group", TEST2_GROUP);
        p2.put("artifact", TEST2_ARTIFACT);
        p2.put("version", TEST2_VERSION);
        packages.add(p2);

        mvn.updateRecycleBinPackages("test2", BatchOperation.RESTORE_TO_FEED, packages);
        System.out.println("Maven API TEST : updateRecycleBinPackages - OK");
    }

    // 
    @Test
    public void shouldAllMavenFunction() throws AzDException, InterruptedException{
        System.out.println("Maven API TEST : Integration Testing");
        
        // 1. Single Package
        // 1-1 GetPackageVersion
        System.out.println("Maven API TEST : GetPackageVersion");
        Package testPackage=mvn.getPackageVersion(FEED, TEST1_GROUP, TEST1_ARTIFACT, TEST1_VERSION);    
        assertEquals(TEST1_GROUP+":"+TEST1_ARTIFACT, testPackage.getId());
        assertEquals(TEST1_VERSION, testPackage.getVersion());
        System.out.println("Maven API TEST : GetPackageVersion - OK");

        // 1-2. UpstreamingBehavior
        System.out.println("Maven API TEST : UpstreamingBehavior");
        mvn.setUpstreamingBehavior(FEED, TEST1_GROUP, TEST1_ARTIFACT);
        UpstreamingBehavior behavior=mvn.getUpstreamingBehavior(FEED, TEST1_GROUP, TEST1_ARTIFACT);
        assertEquals(behavior.getVersionsFromExternalUpstreams(), "allowExternalVersions" );

        mvn.clearUpstreamingBehavior(FEED, TEST1_GROUP, TEST1_ARTIFACT);
        behavior=mvn.getUpstreamingBehavior(FEED, TEST1_GROUP, TEST1_ARTIFACT);
        assertEquals(behavior.getVersionsFromExternalUpstreams(), "auto" );
        System.out.println("Maven API TEST : UpstreamingBehavior - OK");

        // 1-3 Update Package Version
        System.out.println("Maven API TEST : UpdatePackageVersion");
        mvn.updatePackageVersion(FEED, TEST1_GROUP, TEST1_ARTIFACT, TEST1_VERSION, "Release");
        System.out.println("Maven API TEST : UpdatePackageVersion - OK");


        // 1-4. DeletePackageVersion
        System.out.println("Maven API TEST : DeletePackageVersion");
        mvn.deletePackageVersion(FEED, TEST1_GROUP, TEST1_ARTIFACT, TEST1_VERSION);
        System.out.println("Maven API TEST : DeletePackageVersion - OK");

        // 1-5. GetPackageVersions with deleted package
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Maven API TEST : getPackageVersion with query parameters");
        testPackage=mvn.getPackageVersion(FEED, TEST1_GROUP, TEST1_ARTIFACT, TEST1_VERSION, true);
        assertNotNull(testPackage.getDeletedDate());
        System.out.println("Maven API TEST : getPackageVersion with query parameters - OK");

        // 1-6 GetPackageVersionFromRecycleBin
        System.out.println("Maven API TEST : GetPackageVersionFromRecycleBin");
        MavenPackageVersionDeletionState testDeletePackage=mvn.getPackageVersionFromRecycleBin(FEED, TEST1_GROUP, TEST1_ARTIFACT, TEST1_VERSION);
        assertNotNull(testDeletePackage.getDeletedDate());
        assertEquals(TEST1_ARTIFACT, testDeletePackage.getArtifactId());
        assertEquals(TEST1_VERSION, testDeletePackage.getVersion());
        System.out.println("Maven API TEST : GetPackageVersionFromRecycleBin - OK");

        // 1-7 restorePackageVersionFromRecycleBin
        mvn.restorePackageVersionFromRecycleBin(FEED, TEST1_GROUP, TEST1_ARTIFACT, TEST1_VERSION);


        // 2. Multiple Packages
        // 2-1. UpdatePackageVersions

        List packages = new ArrayList<>();

        Map<String, Object> p1 = new HashMap<>();
        p1.put("group", TEST1_GROUP);
        p1.put("artifact", TEST1_ARTIFACT);
        p1.put("version", TEST1_VERSION);
        packages.add(p1);
        
        Map<String, Object> p2 = new HashMap<>();
        p2.put("group", TEST2_GROUP);
        p2.put("artifact", TEST2_ARTIFACT);
        p2.put("version", TEST2_VERSION);
        packages.add(p2);

        mvn.updatePackageVersions(FEED, "Release", BatchOperation.PROMOTE,packages);
        mvn.updatePackageVersions(FEED, "Release", BatchOperation.DELETE,packages);
        System.out.println("Maven API TEST : UpdatePackageVersions - OK");

        // 2-2. UpdateRecycleBinPackages
        System.out.println("Maven API TEST : UpdateRecycleBinPackages");
        mvn.updateRecycleBinPackages("test2", BatchOperation.RESTORE_TO_FEED, packages);
        System.out.println("Maven API TEST : UpdateRecycleBinPackages - OK");

        System.out.println("Maven API TEST : Integration Testing - OK");
    }

    @After
    public void restorePackage(){
        try{
            List packages = new ArrayList<>();

            Map<String, Object> p1 = new HashMap<>();
            p1.put("group", TEST1_GROUP);
            p1.put("artifact", TEST1_ARTIFACT);
            p1.put("version", TEST1_VERSION);
            packages.add(p1);
            
            Map<String, Object> p2 = new HashMap<>();
            p2.put("group", TEST2_GROUP);
            p2.put("artifact", TEST2_ARTIFACT);
            p2.put("version", TEST2_VERSION);
            packages.add(p2);
    
            mvn.updateRecycleBinPackages("test2", BatchOperation.RESTORE_TO_FEED, packages);
        } catch(Exception e){
        }

    }
}
