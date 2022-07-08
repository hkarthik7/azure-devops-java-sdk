package org.azd;

import org.azd.enums.PackagePromote;
import org.azd.enums.PackagesBatchOperation;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.AzDClient;
import org.azd.interfaces.UpackDetails;
import org.azd.upack.types.Package;
import org.azd.upack.types.UPackPackageVersionDeletionState;
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

import static org.junit.Assert.assertEquals;

public class UPackApiTest {

    private static final JsonMapper MAPPER = new JsonMapper();
    private static final String FEED = "universal-packages-feed";
    private static final String TEST1_PACKAGENAME = "universal-package";
    private static final String TEST1_VERSION = "1.0.0";
    // Recycle bin Package
    private static final String TEST2_PACKAGENAME = "universa-package";
    private static final String TEST2_VERSION = "1.0.0";
    private static AzDClient webApi;
    private static UpackDetails upack;

    @AfterClass
    public static void restorePackage() {
        try {
            List packages = new ArrayList<>();

            Map<String, Object> p1 = new HashMap<>();
            p1.put("id", TEST1_PACKAGENAME);
            p1.put("version", TEST1_VERSION);
            packages.add(p1);

            upack.updateRecycleBinPackages(FEED, PackagesBatchOperation.RESTORETOFEED, packages);
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
        upack = webApi.getUPackApi();
    }

    @Test
    public void shouldGetPackageVersion() throws AzDException {
        try {
            System.out.println("Universal Package API TEST : getPackageVersion");
            Package testPackage = upack.getPackageVersion(FEED, TEST1_PACKAGENAME, TEST1_VERSION);
            assertEquals(TEST1_PACKAGENAME, testPackage.getName());
            assertEquals(TEST1_VERSION, testPackage.getVersion());
            System.out.println("Universal Package API TEST : getPackageVersion - OK");
        } catch (AzDException e) {
        }
    }

    @Test
    public void shouldGetPackageVersionWithQueryParameters() throws AzDException {
        try {
            System.out.println("Universal Package API TEST : getPackageVersion with query parameters");
            Package testPackage = upack.getPackageVersion(FEED, TEST1_PACKAGENAME, TEST1_VERSION, true);
            assertEquals(TEST1_PACKAGENAME, testPackage.getName());
            assertEquals(TEST1_VERSION, testPackage.getVersion());
            System.out.println("Universal Package API TEST : getPackageVersion with query parameters - OK");
        } catch (AzDException e) {
        }
    }

    @Test
    public void shouldUpdatePackageVersion() throws AzDException {
        try {
            System.out.println("Universal Package API TEST : updatePackageVersion");
            upack.updatePackageVersion(FEED, TEST1_PACKAGENAME, TEST1_VERSION, "Release");
            upack.updatePackageVersion(FEED, TEST1_PACKAGENAME, TEST1_VERSION, PackagePromote.PRERELEASE);
            System.out.println("Universal Package API TEST : updatePackageVersion - OK");
        } catch (AzDException e) {
        }
    }

    @Test
    public void shouldDeleteRestorePackageVersion() throws AzDException, InterruptedException {
        try {
            System.out.println("Universal Package API TEST : deletePackageVersion");
            upack.deletePackageVersion(FEED, TEST1_PACKAGENAME, TEST1_VERSION);
            TimeUnit.SECONDS.sleep(5);
            System.out.println("Universal Package API TEST : deletePackageVersion - OK");

            System.out.println("Universal Package API TEST : restorePackageVersionFromRecycleBin");
            upack.restorePackageVersionFromRecycleBin(FEED, TEST1_PACKAGENAME, TEST1_VERSION);
            TimeUnit.SECONDS.sleep(5);
            System.out.println("Universal Package API TEST : restorePackageVersionFromRecycleBin - OK");
        } catch (AzDException e) {
        }
    }

    @Test
    public void shouldGetPackageVersionFromRecycleBin() throws AzDException {
        try {
            System.out.println("Universal Package API TEST : shouldGetPackageVersionFromRecycleBin");
            UPackPackageVersionDeletionState testPackage = upack.getPackageVersionFromRecycleBin(FEED, TEST2_PACKAGENAME,
                    TEST2_VERSION);
            assertEquals(TEST2_PACKAGENAME, testPackage.getName());
            System.out.println("Universal Package API TEST : shouldGetPackageVersionFromRecycleBin - OK");
        } catch (AzDException e) {
        }
    }

    // // @Test
    // // public void shouldDownloadPackage() throws AzDException {
    // // mvn.downloadPackage("test2", "com.acme", "app", "1.0.2", "app-1.0.2.zip");
    // // }

    @Test
    public void shouldUpdatePackageVersions() throws AzDException, InterruptedException {
        try {
            System.out.println("Universal Package API : updatePackageVersions");
            List packages = new ArrayList<>();

            Map<String, Object> p1 = new HashMap<>();
            p1.put("id", TEST1_PACKAGENAME);
            p1.put("version", TEST1_VERSION);
            packages.add(p1);

            upack.updatePackageVersions(FEED, "Release", PackagesBatchOperation.PROMOTE, packages);
            upack.updatePackageVersions(FEED, "Release", PackagesBatchOperation.DELETE, packages);
            TimeUnit.SECONDS.sleep(3);
            System.out.println("Universal Package API : updatePackageVersions - OK");

            System.out.println("Universal Package APIT : updateRecycleBinPackages");
            upack.updateRecycleBinPackages(FEED, PackagesBatchOperation.RESTORETOFEED, packages);
            TimeUnit.SECONDS.sleep(3);
            System.out.println("Universal Package API : updateRecycleBinPackages - OK");
        } catch (AzDException e) {
        }
    }

    @Test(expected = AzDException.class) // cannot be undone test
    public void shouldDeletePackageVersionFromRecycleBin() throws AzDException {
        System.out.println("Universal Package API : deletePackageVersionFromRecycleBin");
        upack.deletePackageVersionFromRecycleBin(FEED, TEST1_PACKAGENAME, "0.0.0"); // cant not be undone
        System.out.println("Universal Package API : deletePackageVersionFromRecycleBin - OK");
    }
}
