package org.azd.unittests;

import org.azd.UnitTestConfiguration;
import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.artifactspackagetypes.ArtifactsPackageTypesRequestBuilder;
import org.azd.artifactspackagetypes.maven.MavenRequestBuilder;
import org.azd.artifactspackagetypes.types.MavenMinimalPackageDetails;
import org.azd.artifactspackagetypes.types.MavenPackagesBatchRequest;
import org.azd.artifactspackagetypes.types.MavenRecycleBinPackageVersionDetails;
import org.azd.artifactspackagetypes.types.PackageVersionDetails;
import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.common.types.JsonPatchDocument;
import org.azd.enums.Instance;
import org.azd.enums.PackagePromote;
import org.azd.enums.PackagesBatchOperation;
import org.azd.enums.PatchOperation;
import org.azd.exceptions.AzDException;
import org.azd.helpers.StreamHelper;
import org.azd.helpers.artifactspackagetypes.ArtifactsPackageTypesHelpersRequestBuilder;
import org.azd.legacy.MockParameters;
import org.azd.maven.types.MavenPackageVersionDeletionState;
import org.azd.maven.types.Package;
import org.azd.maven.types.UpstreamingBehavior;
import org.azd.serviceclient.AzDService;
import org.azd.serviceclient.AzDServiceClient;
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

public class ArtifactsPackageTypesRequestBuilderTest {
    private static final SerializerContext serializer = InstanceFactory.createSerializerContext();
    private static AzDServiceClient client;
    private static UnitTestConfiguration testConfiguration;
    private static final String FEED = "maven-feed";
    private static final String TEST1_GROUP = "org.jack.click";
    private static final String TEST1_ARTIFACT = "ClickJack";
    private static final String TEST1_VERSION = "1.5.0";
    private static final String TEST2_GROUP = "org.tester.maven";
    private static final String TEST2_ARTIFACT = "MavenTester";
    private static final String TEST2_VERSION = "1.1.0";
    // Recycle bin Package
    private static final String TEST3_GROUP = "org.HelloWorld";
    private static final String TEST3_ARTIFACT = "HelloWorld";
    private static final String TEST3_VERSION = "1.0.0";
    private static ArtifactsPackageTypesRequestBuilder a;
    private static ArtifactsPackageTypesHelpersRequestBuilder ah;
    private static MavenRequestBuilder mvn;

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
        a = client.artifactsPackageTypes();
        mvn = a.maven();
    }

    @AfterClass
    public static void restorePackage() {
        try {
            var packages = new ArrayList<MavenMinimalPackageDetails>();

            var p1 = new MavenMinimalPackageDetails();
            p1.version = TEST1_VERSION;
            p1.group = TEST1_GROUP;
            p1.artifact = TEST1_ARTIFACT;

            var p2 = new MavenMinimalPackageDetails();
            p2.version = TEST2_VERSION;
            p2.group = TEST2_GROUP;
            p2.artifact = TEST2_ARTIFACT;

            packages.add(p1);
            packages.add(p2);

            var mavenPackagesReq = new MavenPackagesBatchRequest();
            mavenPackagesReq.packages = packages;
            mavenPackagesReq.operation = PackagesBatchOperation.RESTORETOFEED;

            mvn.recycleBin().update(FEED, mavenPackagesReq);
        } catch (Exception ignored) {
        }
    }

    @Test
    public void shouldGetPackageVersion() throws AzDException {
        System.out.println("Maven API TEST : getPackageVersion");
        Package testPackage = mvn.get(r -> {
            r.feedId = FEED;
            r.groupId = TEST1_GROUP;
            r.artifactId = TEST1_ARTIFACT;
            r.version = TEST1_VERSION;
        });
        assertEquals(TEST1_GROUP + ":" + TEST1_ARTIFACT, testPackage.getName());
        assertEquals(TEST1_VERSION, testPackage.getVersion());
        System.out.println("Maven API TEST : getPackageVersion - OK");
    }

    @Test
    public void shouldGetPackageVersionWithQueryParameters() throws AzDException {
        System.out.println("Maven API TEST : getPackageVersion with query parameters");
        Package testPackage = mvn.get(r -> {
            r.feedId = FEED;
            r.groupId = TEST1_GROUP;
            r.artifactId = TEST1_ARTIFACT;
            r.version = TEST1_VERSION;
        }, s -> s.showDeleted);
        assertEquals(TEST1_GROUP + ":" + TEST1_ARTIFACT, testPackage.getName());
        assertEquals(TEST1_VERSION, testPackage.getVersion());
        System.out.println("Maven API TEST : getPackageVersion with query parameters - OK");
    }

    @Test
    public void shouldGetUpstreamingBehavior() throws AzDException {
        System.out.println("Maven API TEST : getUpstreamingBehavior");
        UpstreamingBehavior behavior = mvn.upstreamingBehavior().get(r -> {
            r.artifactId = TEST1_ARTIFACT;
            r.groupId = TEST1_GROUP;
            r.feedId = FEED;
        });
        assertTrue(behavior.getVersionsFromExternalUpstreams().equals("allowExternalVersions") || behavior.getVersionsFromExternalUpstreams().equals("auto"));
        System.out.println("Maven API TEST : getUpstreamingBehavior - OK");
    }

    @Test
    public void shouldSetUpstreamingBehavior() throws AzDException {
        System.out.println("Maven API TEST : setUpstreamingBehavior");
        var upstreamBehaviour = new UpstreamingBehavior();
        upstreamBehaviour.setVersionsFromExternalUpstreams("allowExternalVersions");
        mvn.upstreamingBehavior().set(r -> {
            r.feedId = FEED;
            r.groupId = TEST1_GROUP;
            r.artifactId = TEST1_ARTIFACT;
        }, upstreamBehaviour);
        System.out.println("Maven API TEST : setUpstreamingBehavior - OK");
    }

    @Test
    public void shouldClearUpstreamingBehavior() throws AzDException {
        System.out.println("Maven API TEST : clearUpstreamingBehavior");
        var upstreamBehaviour = new UpstreamingBehavior();
        upstreamBehaviour.setVersionsFromExternalUpstreams("auto");
        mvn.upstreamingBehavior().set(r -> {
            r.feedId = FEED;
            r.groupId = TEST1_GROUP;
            r.artifactId = TEST1_ARTIFACT;
        }, upstreamBehaviour);
        System.out.println("Maven API TEST : clearUpstreamingBehavior - OK");
    }

    @Test
    public void shouldUpdatePackageVersion() throws AzDException {
        System.out.println("Maven API TEST : updatePackageVersion");
        var jsonPatchDocument = new JsonPatchDocument();
        jsonPatchDocument.setOperation(PatchOperation.ADD);
        jsonPatchDocument.setPath("/views/-");
        jsonPatchDocument.setValue(PackagePromote.RELEASE.toString().toLowerCase());
        var mavenPackageVersioningDetails = new PackageVersionDetails();
        mavenPackageVersioningDetails.views = jsonPatchDocument;
        mvn.update(r -> {
            r.feedId = FEED;
            r.groupId = TEST1_GROUP;
            r.artifactId = TEST1_ARTIFACT;
            r.version = TEST1_VERSION;
        }, mavenPackageVersioningDetails);

        jsonPatchDocument.setValue(PackagePromote.PRERELEASE.toString().toLowerCase());
        mavenPackageVersioningDetails.views = jsonPatchDocument;
        mvn.update(r -> {
            r.feedId = FEED;
            r.groupId = TEST1_GROUP;
            r.artifactId = TEST1_ARTIFACT;
            r.version = TEST1_VERSION;
        }, mavenPackageVersioningDetails);
        System.out.println("Maven API TEST : updatePackageVersion - OK");
    }

    @Test
    public void shouldDeleteRestorePackageVersion() throws AzDException, InterruptedException {
        System.out.println("Maven API TEST : deletePackageVersion");
        mvn.delete(r -> {
            r.feedId = FEED;
            r.groupId = TEST1_GROUP;
            r.artifactId = TEST1_ARTIFACT;
            r.version = TEST1_VERSION;
        });
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Maven API TEST : deletePackageVersion - OK");

        System.out.println("Maven API TEST : restorePackageVersionFromRecycleBin");
        var mavenRecycleBinPackageVersionDetails = new MavenRecycleBinPackageVersionDetails();
        mavenRecycleBinPackageVersionDetails.deleted = false;
        mvn.recycleBin().restore(mavenRecycleBinPackageVersionDetails, r -> {
            r.feed = FEED;
            r.groupId = TEST1_GROUP;
            r.artifactId = TEST1_ARTIFACT;
            r.version = TEST1_VERSION;
        });
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Maven API TEST : restorePackageVersionFromRecycleBin - OK");
    }

    @Test
    public void shouldGetPackageVersionFromRecycleBin() throws AzDException {
        System.out.println("Maven API TEST : shouldGetPackageVersionFromRecycleBin");
        try {
            mvn.recycleBin().get(r -> {
                r.feed = FEED;
                r.groupId = TEST3_GROUP;
                r.artifactId = TEST3_ARTIFACT;
                r.version = TEST3_VERSION;
            });
        } catch (AzDException ignored) {
        }
        System.out.println("Maven API TEST : shouldGetPackageVersionFromRecycleBin - OK");
    }

    @Test
    public void shouldDownloadPackage() throws AzDException {
        var feedId = client.artifacts().feedManagement().get(FEED).getId();
        var responseStream = mvn.download(r -> {
            r.feedId = feedId;
            r.groupId = TEST1_GROUP;
            r.artifactId = TEST1_ARTIFACT;
            r.version = TEST1_VERSION;
            r.fileName = "ClickJack-1.5.2.jar";
        });
        StreamHelper.download("ClickJack-1.5.2.jar", responseStream);
        System.out.println("Maven API TEST : shouldDownloadPackage - OK");
    }

    @Test
    public void shouldUploadPackage() throws AzDException {
        var feedId = client.artifacts().feedManagement().get(FEED).getId();
        var uploadVersion = TEST1_VERSION.substring(0, TEST1_VERSION.lastIndexOf(".")) + "." + (Integer.parseInt(TEST1_VERSION.substring(TEST1_VERSION.lastIndexOf(".") + 1)) + 1);
        String uploadFileName = TEST1_ARTIFACT + "-" + uploadVersion + ".jar";

        var responseStream = mvn.download(r -> {
            r.feedId = feedId;
            r.groupId = TEST1_GROUP;
            r.artifactId = TEST1_ARTIFACT;
            r.version = TEST1_VERSION;
            r.fileName = "ClickJack-1.5.2.jar";
        });
        StreamHelper.download(uploadFileName, responseStream);

        var content = StreamHelper.convertToStream(new File(uploadFileName));
        try {
            Package testPackage = mvn.get(r -> {
                r.feedId = FEED;
                r.groupId = TEST1_GROUP;
                r.artifactId = TEST1_ARTIFACT;
                r.version = uploadVersion;
            });
        } catch (AzDException e) { // package not found
            System.out.println("Maven API TEST : shouldUploadPackage");
            ah.uploadPackage(FEED, TEST1_GROUP, TEST1_ARTIFACT, uploadVersion, uploadFileName, content);
            System.out.println("Maven API TEST : shouldUploadPackage - OK");
        }
    }

    @Test
    public void shouldUpdatePackageVersions() throws AzDException, InterruptedException {
        System.out.println("Maven API TEST : updatePackageVersions");
        var batchRequest = new MavenPackagesBatchRequest();
        batchRequest.operation = PackagesBatchOperation.PROMOTE;

        var packages = new ArrayList<MavenMinimalPackageDetails>();
        var minimalPackage1 = new MavenMinimalPackageDetails();
        minimalPackage1.artifact = TEST1_ARTIFACT;
        minimalPackage1.group = TEST1_GROUP;
        minimalPackage1.version = TEST1_VERSION;

        var minimalPackage2 = new MavenMinimalPackageDetails();
        minimalPackage2.artifact = TEST2_ARTIFACT;
        minimalPackage2.group = TEST2_GROUP;
        minimalPackage2.version = TEST2_VERSION;

        packages.add(minimalPackage1);
        packages.add(minimalPackage2);

        batchRequest.packages = packages;
        batchRequest.data = Map.of("viewId", "Release");

        mvn.update(FEED, batchRequest);

        batchRequest.operation = PackagesBatchOperation.DELETE;

        mvn.update(FEED, batchRequest);

        TimeUnit.SECONDS.sleep(3);
        System.out.println("Maven API TEST : updatePackageVersions - OK");

        System.out.println("Maven API TEST : updateRecycleBinPackages");
        batchRequest.operation = PackagesBatchOperation.RESTORETOFEED;
        mvn.recycleBin().update(FEED, batchRequest);
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Maven API TEST : updateRecycleBinPackages - OK");
    }

    @Test(expected = AzDException.class) // cannot be undone test
    public void shouldDeletePackageVersionFromRecycleBin() throws AzDException {
        System.out.println("Maven API TEST : deletePackageVersionFromRecycleBin");
        mvn.recycleBin().delete(r -> {
            r.feed = FEED;
            r.artifactId = TEST1_ARTIFACT;
            r.groupId = TEST1_GROUP;
            r.version = "0.0.0";
        });
        System.out.println("Maven API TEST : deletePackageVersionFromRecycleBin - OK");
    }

    // It should test last.
    public void shouldTestAllMavenFunction() throws AzDException, InterruptedException {
        System.out.println("Maven API TEST : Integration Testing");

        // 1. Single Package
        // 1-1 GetPackageVersion
        System.out.println("Maven API TEST : GetPackageVersion");
        Package testPackage = mvn.get(r -> {
            r.feedId = FEED;
            r.artifactId = TEST1_ARTIFACT;
            r.groupId = TEST1_GROUP;
            r.version = TEST1_VERSION;
        });
        assertEquals(TEST1_GROUP + ":" + TEST1_ARTIFACT, testPackage.getName());
        assertEquals(TEST1_VERSION, testPackage.getVersion());
        System.out.println("Maven API TEST : GetPackageVersion - OK");

        // 1-2. UpstreamingBehavior
        System.out.println("Maven API TEST : UpstreamingBehavior");
        var upstreamBehaviour = new UpstreamingBehavior();
        upstreamBehaviour.setVersionsFromExternalUpstreams("allowExternalVersions");
        mvn.upstreamingBehavior().set(r -> {
            r.feedId = FEED;
            r.groupId = TEST1_GROUP;
            r.artifactId = TEST1_ARTIFACT;
        }, upstreamBehaviour);
        UpstreamingBehavior behavior = mvn.upstreamingBehavior().get(r -> {
            r.feedId = FEED;
            r.artifactId = TEST1_ARTIFACT;
            r.groupId = TEST1_GROUP;
        });
        assertEquals(behavior.getVersionsFromExternalUpstreams(), "allowExternalVersions");

        // Clear upstream behaviour
        upstreamBehaviour.setVersionsFromExternalUpstreams("auto");
        mvn.upstreamingBehavior().set(r -> {
            r.feedId = FEED;
            r.groupId = TEST1_GROUP;
            r.artifactId = TEST1_ARTIFACT;
        }, upstreamBehaviour);
        behavior = mvn.upstreamingBehavior().get(r -> {
            r.feedId = FEED;
            r.artifactId = TEST1_ARTIFACT;
            r.groupId = TEST1_GROUP;
        });
        assertEquals(behavior.getVersionsFromExternalUpstreams(), "auto");
        System.out.println("Maven API TEST : UpstreamingBehavior - OK");

        // 1-3 Update Package Version
        System.out.println("Maven API TEST : UpdatePackageVersion");
        var jsonPatchDocument = new JsonPatchDocument();
        jsonPatchDocument.setOperation(PatchOperation.ADD);
        jsonPatchDocument.setPath("/views/-");
        jsonPatchDocument.setValue(PackagePromote.RELEASE.toString().toLowerCase());
        var mavenPackageVersioningDetails = new PackageVersionDetails();
        mavenPackageVersioningDetails.views = jsonPatchDocument;
        mvn.update(r -> {
            r.feedId = FEED;
            r.groupId = TEST1_GROUP;
            r.artifactId = TEST1_ARTIFACT;
            r.version = TEST1_VERSION;
        }, mavenPackageVersioningDetails);
        System.out.println("Maven API TEST : UpdatePackageVersion - OK");


        // 1-4. DeletePackageVersion
        System.out.println("Maven API TEST : DeletePackageVersion");
        mvn.delete(r -> {
            r.feedId = FEED;
            r.artifactId = TEST1_ARTIFACT;
            r.groupId = TEST1_GROUP;
            r.version = TEST1_VERSION;
        });
        System.out.println("Maven API TEST : DeletePackageVersion - OK");

        // 1-5. GetPackageVersions with deleted package
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Maven API TEST : getPackageVersion with query parameters");
        testPackage = mvn.get(r -> {
            r.feedId = FEED;
            r.artifactId = TEST1_ARTIFACT;
            r.groupId = TEST1_GROUP;
            r.version = TEST1_VERSION;
        }, x -> x.showDeleted = true);
        assertNotNull(testPackage.getDeletedDate());
        System.out.println("Maven API TEST : getPackageVersion with query parameters - OK");

        // 1-6 GetPackageVersionFromRecycleBin
        System.out.println("Maven API TEST : GetPackageVersionFromRecycleBin");
        MavenPackageVersionDeletionState testDeletePackage = mvn.recycleBin().get(r -> {
            r.feed = FEED;
            r.groupId = TEST1_GROUP;
            r.artifactId = TEST1_ARTIFACT;
            r.version = TEST1_VERSION;
        });
        assertNotNull(testDeletePackage.getDeletedDate());
        assertEquals(TEST1_ARTIFACT, testDeletePackage.getArtifactId());
        assertEquals(TEST1_VERSION, testDeletePackage.getVersion());
        System.out.println("Maven API TEST : GetPackageVersionFromRecycleBin - OK");

        // 1-7 restorePackageVersionFromRecycleBin
        var packageVersionDetails = new  MavenRecycleBinPackageVersionDetails();
        packageVersionDetails.deleted = false;
        mvn.recycleBin().restore(packageVersionDetails, r -> {
            r.feed = FEED;
            r.artifactId = TEST1_ARTIFACT;
            r.groupId = TEST1_GROUP;
            r.version = TEST1_VERSION;
        });

        // 2. Multiple Packages
        // 2-1. UpdatePackageVersions

        var batchRequest = new MavenPackagesBatchRequest();
        batchRequest.operation = PackagesBatchOperation.PROMOTE;

        var packages = new ArrayList<MavenMinimalPackageDetails>();
        var minimalPackage1 = new MavenMinimalPackageDetails();
        minimalPackage1.artifact = TEST1_ARTIFACT;
        minimalPackage1.group = TEST1_GROUP;
        minimalPackage1.version = TEST1_VERSION;

        var minimalPackage2 = new MavenMinimalPackageDetails();
        minimalPackage2.artifact = TEST2_ARTIFACT;
        minimalPackage2.group = TEST2_GROUP;
        minimalPackage2.version = TEST2_VERSION;

        packages.add(minimalPackage1);
        packages.add(minimalPackage2);

        batchRequest.packages = packages;
        batchRequest.data = Map.of("views", "Release");

        mvn.update(FEED, batchRequest);

        batchRequest.operation = PackagesBatchOperation.DELETE;

        mvn.update(FEED, batchRequest);
        System.out.println("Maven API TEST : UpdatePackageVersions - OK");

        // 2-2. UpdateRecycleBinPackages
        System.out.println("Maven API TEST : UpdateRecycleBinPackages");
        batchRequest.operation = PackagesBatchOperation.RESTORETOFEED;
        mvn.recycleBin().update(FEED, batchRequest);
        System.out.println("Maven API TEST : UpdateRecycleBinPackages - OK");

        System.out.println("Maven API TEST : Integration Testing - OK");
    }
}
