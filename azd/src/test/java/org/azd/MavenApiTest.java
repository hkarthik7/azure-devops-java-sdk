package org.azd;

import org.azd.enums.PackagePromote;
import org.azd.enums.PackagesBatchOperation;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.helpers.StreamHelper;
import org.azd.interfaces.AzDClient;
import org.azd.interfaces.FeedManagementDetails;
import org.azd.interfaces.MavenDetails;
import org.azd.maven.types.MavenPackageVersionDeletionState;
import org.azd.maven.types.Package;
import org.azd.maven.types.UpstreamingBehavior;
import org.azd.utils.AzDClientApi;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class MavenApiTest {

    private static final JsonMapper MAPPER = new JsonMapper();
    private static final String FEED = "maven-feed";
    private static final String TEST1_GROUP = "org.jack.click";
    private static final String TEST1_ARTIFACT = "ClickJack";
    private static final String TEST1_VERSION = "1.5.0";
    private static final String TEST2_GROUP = "org.tester.maven";
    private static final String TEST2_ARTIFACT = "MavenTester";
    private static final String TEST2_VERSION = "1.0.0";
    // Recycle bin Package
    private static final String TEST3_GROUP = "org.HelloWorld";
    private static final String TEST3_ARTIFACT = "HelloWorld";
    private static final String TEST3_VERSION = "1.0.0";
    private static AzDClient webApi;
    private static MavenDetails mvn;
    private static FeedManagementDetails feed;

    @AfterClass
    public static void restorePackage() {
        try {
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

            mvn.updateRecycleBinPackages(FEED, PackagesBatchOperation.RESTORETOFEED, packages);
        } catch (Exception e) {
        }
    }

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
        feed = webApi.getFeedManagementApi();
    }

    @Test
    public void shouldGetPackageVersion() throws AzDException {
        System.out.println("Maven API TEST : getPackageVersion");
        Package testPackage = mvn.getPackageVersion(FEED, TEST1_GROUP, TEST1_ARTIFACT, TEST1_VERSION);
        assertEquals(TEST1_GROUP + ":" + TEST1_ARTIFACT, testPackage.getName());
        assertEquals(TEST1_VERSION, testPackage.getVersion());
        System.out.println("Maven API TEST : getPackageVersion - OK");
    }

    @Test
    public void shouldGetPackageVersionWithQueryParameters() throws AzDException {
        System.out.println("Maven API TEST : getPackageVersion with query parameters");
        Package testPackage = mvn.getPackageVersion(FEED, TEST1_GROUP, TEST1_ARTIFACT, TEST1_VERSION, true);
        assertEquals(TEST1_GROUP + ":" + TEST1_ARTIFACT, testPackage.getName());
        assertEquals(TEST1_VERSION, testPackage.getVersion());
        System.out.println("Maven API TEST : getPackageVersion with query parameters - OK");
    }

    @Test
    public void shouldGetUpstreamingBehavior() throws AzDException {
        System.out.println("Maven API TEST : getUpstreamingBehavior");
        UpstreamingBehavior behavior = mvn.getUpstreamingBehavior(FEED, TEST1_GROUP, TEST1_ARTIFACT);
        assertTrue(behavior.getVersionsFromExternalUpstreams().equals("allowExternalVersions") || behavior.getVersionsFromExternalUpstreams().equals("auto"));
        System.out.println("Maven API TEST : getUpstreamingBehavior - OK");
    }

    @Test
    public void shouldSetUpstreamingBehavior() throws AzDException {
        System.out.println("Maven API TEST : setUpstreamingBehavior");
        mvn.setUpstreamingBehavior(FEED, TEST1_GROUP, TEST1_ARTIFACT);
        System.out.println("Maven API TEST : setUpstreamingBehavior - OK");
    }

    @Test
    public void shouldClearUpstreamingBehavior() throws AzDException {
        System.out.println("Maven API TEST : clearUpstreamingBehavior");
        mvn.clearUpstreamingBehavior(FEED, TEST1_GROUP, TEST1_ARTIFACT);
        System.out.println("Maven API TEST : clearUpstreamingBehavior - OK");
    }

    @Test
    public void shouldUpdatePackageVersion() throws AzDException {
        System.out.println("Maven API TEST : updatePackageVersion");
        mvn.updatePackageVersion(FEED, TEST1_GROUP, TEST1_ARTIFACT, TEST1_VERSION, "Release");
        mvn.updatePackageVersion(FEED, TEST1_GROUP, TEST1_ARTIFACT, TEST1_VERSION, PackagePromote.PRERELEASE);
        System.out.println("Maven API TEST : updatePackageVersion - OK");
    }

    @Test
    public void shouldDeleteRestorePackageVersion() throws AzDException, InterruptedException {
        System.out.println("Maven API TEST : deletePackageVersion");
        mvn.deletePackageVersion(FEED, TEST1_GROUP, TEST1_ARTIFACT, TEST1_VERSION);
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Maven API TEST : deletePackageVersion - OK");

        System.out.println("Maven API TEST : restorePackageVersionFromRecycleBin");
        mvn.restorePackageVersionFromRecycleBin(FEED, TEST1_GROUP, TEST1_ARTIFACT, TEST1_VERSION);
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Maven API TEST : restorePackageVersionFromRecycleBin - OK");
    }

    @Test
    public void shouldGetPackageVersionFromRecycleBin() throws AzDException {
        System.out.println("Maven API TEST : shouldGetPackageVersionFromRecycleBin");
        try {
            mvn.getPackageVersionFromRecycleBin(FEED, TEST3_GROUP, TEST3_ARTIFACT, TEST3_VERSION);
        } catch(AzDException e) { }
        System.out.println("Maven API TEST : shouldGetPackageVersionFromRecycleBin - OK");
    }

    @Test
    public void shouldDownloadPackage() throws AzDException {
        var feedId = feed.getFeed(FEED).getId();
        var responseStream = mvn.downloadPackage(feedId, TEST1_GROUP, TEST1_ARTIFACT, TEST1_VERSION, "ClickJack-1.5.0.jar");
        StreamHelper.download("ClickJack-1.5.0.jar", responseStream);
        System.out.println("Maven API TEST : shouldDownloadPackage - OK");
    }

    @Test
    public void shouldUploadPackage() throws AzDException {
        var feedId = feed.getFeed(FEED).getId();
        var uploadVersion = TEST1_VERSION.substring(0, TEST1_VERSION.lastIndexOf(".")) + "." + (Integer.parseInt(TEST1_VERSION.substring(TEST1_VERSION.lastIndexOf(".") + 1)) + 1);
        String uploadFileName = TEST1_ARTIFACT+"-"+uploadVersion+".jar";

        var responseStream = mvn.downloadPackage(feedId, TEST1_GROUP, TEST1_ARTIFACT, TEST1_VERSION, "ClickJack-1.5.0.jar");
        StreamHelper.download(uploadFileName, responseStream);

        var content = StreamHelper.convertToStream(new File(uploadFileName));
        try{
            Package testPackage = mvn.getPackageVersion(FEED, TEST1_GROUP, TEST1_ARTIFACT, uploadVersion);
        } catch(AzDException e){ // package not found
            System.out.println("Maven API TEST : shouldUploadPackage");
            mvn.uploadPackage(FEED, TEST1_GROUP, TEST1_ARTIFACT, uploadVersion, uploadFileName, content);
            System.out.println("Maven API TEST : shouldUploadPackage - OK");
        }
    }

    @Test
    public void shouldUpdatePackageVersions() throws AzDException, InterruptedException {
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

        mvn.updatePackageVersions(FEED, "Release", PackagesBatchOperation.PROMOTE, packages);
        mvn.updatePackageVersions(FEED, "Release", PackagesBatchOperation.DELETE, packages);
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Maven API TEST : updatePackageVersions - OK");

        System.out.println("Maven API TEST : updateRecycleBinPackages");
        mvn.updateRecycleBinPackages(FEED, PackagesBatchOperation.RESTORETOFEED, packages);
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Maven API TEST : updateRecycleBinPackages - OK");
    }

    @Test(expected = AzDException.class) // cannot be undone test
    public void shouldDeletePackageVersionFromRecycleBin() throws AzDException {
        System.out.println("Maven API TEST : deletePackageVersionFromRecycleBin");
        mvn.deletePackageVersionFromRecycleBin(FEED, TEST1_GROUP, TEST1_ARTIFACT, "0.0.0"); // cant not be undone
        System.out.println("Maven API TEST : deletePackageVersionFromRecycleBin - OK");
    }

    // It should be test last.
    public void shouldAllMavenFunction() throws AzDException, InterruptedException {
        System.out.println("Maven API TEST : Integration Testing");

        // 1. Single Package
        // 1-1 GetPackageVersion
        System.out.println("Maven API TEST : GetPackageVersion");
        Package testPackage = mvn.getPackageVersion(FEED, TEST1_GROUP, TEST1_ARTIFACT, TEST1_VERSION);
        assertEquals(TEST1_GROUP + ":" + TEST1_ARTIFACT, testPackage.getName());
        assertEquals(TEST1_VERSION, testPackage.getVersion());
        System.out.println("Maven API TEST : GetPackageVersion - OK");

        // 1-2. UpstreamingBehavior
        System.out.println("Maven API TEST : UpstreamingBehavior");
        mvn.setUpstreamingBehavior(FEED, TEST1_GROUP, TEST1_ARTIFACT);
        UpstreamingBehavior behavior = mvn.getUpstreamingBehavior(FEED, TEST1_GROUP, TEST1_ARTIFACT);
        assertEquals(behavior.getVersionsFromExternalUpstreams(), "allowExternalVersions");

        mvn.clearUpstreamingBehavior(FEED, TEST1_GROUP, TEST1_ARTIFACT);
        behavior = mvn.getUpstreamingBehavior(FEED, TEST1_GROUP, TEST1_ARTIFACT);
        assertEquals(behavior.getVersionsFromExternalUpstreams(), "auto");
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
        testPackage = mvn.getPackageVersion(FEED, TEST1_GROUP, TEST1_ARTIFACT, TEST1_VERSION, true);
        assertNotNull(testPackage.getDeletedDate());
        System.out.println("Maven API TEST : getPackageVersion with query parameters - OK");

        // 1-6 GetPackageVersionFromRecycleBin
        System.out.println("Maven API TEST : GetPackageVersionFromRecycleBin");
        MavenPackageVersionDeletionState testDeletePackage = mvn.getPackageVersionFromRecycleBin(FEED, TEST1_GROUP, TEST1_ARTIFACT, TEST1_VERSION);
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

        mvn.updatePackageVersions(FEED, "Release", PackagesBatchOperation.PROMOTE, packages);
        mvn.updatePackageVersions(FEED, "Release", PackagesBatchOperation.DELETE, packages);
        System.out.println("Maven API TEST : UpdatePackageVersions - OK");

        // 2-2. UpdateRecycleBinPackages
        System.out.println("Maven API TEST : UpdateRecycleBinPackages");
        mvn.updateRecycleBinPackages(FEED, PackagesBatchOperation.RESTORETOFEED, packages);
        System.out.println("Maven API TEST : UpdateRecycleBinPackages - OK");

        System.out.println("Maven API TEST : Integration Testing - OK");
    }
}
