package org.azd.unittests;

import org.azd.UnitTestConfiguration;
import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.helpers.StreamHelper;
import org.azd.legacy.MockParameters;
import org.azd.serviceclient.AzDService;
import org.azd.serviceclient.AzDServiceClient;
import org.azd.utils.StringUtils;
import org.azd.wiki.WikiRequestBuilder;
import org.azd.wiki.types.*;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class WikiRequestBuilderTest {
    private static final SerializerContext serializer = InstanceFactory.createSerializerContext();
    private static AzDServiceClient client;
    private static UnitTestConfiguration testConfiguration;
    private static WikiRequestBuilder w;

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
        w = client.wiki();
    }

    @Test
    public void shouldCreateWiki() throws AzDException {
        var projectId = client.core().projects().get().getId();
        var repoId = client.git().repositories().get("testRepository").getId();
        String wikiPage = null;
        try {
            wikiPage = w.wikis().get("NewWiki").getName();
        } catch (AzDException e) {
        }

        if (wikiPage == null) {
            var version = new GitVersionDescriptor();
            version.version = "develop";
            var wikiCreateParameters = new WikiCreateParameters("/docs", "NewWiki", projectId, repoId, WikiType.CODEWIKI,
                    version);
            w.wikis().create(wikiCreateParameters);
        }
    }

    @Test
    public void shouldCreateNewProjectWiki() {
        try {
            var projectId = client.core().projects().get().getId();
            var wikiCreateParameters = new WikiCreateParameters("Azure DevOps java sdk documentation", projectId, WikiType.PROJECTWIKI);
            w.wikis().create(wikiCreateParameters);
        } catch (AzDException e) {
            // ignore WikiAlreadyExistsException
        }
    }

    @Test
    public void shouldGetAWiki() throws AzDException {
        w.wikis().get("NewWiki");
    }

    @Test
    public void shouldGetAllWikis() throws AzDException {
        w.wikis().list();
    }

    @Test
    public void shouldDeleteAWiki() {
        try {
            w.wikis().delete("MyProjectWiki");
        } catch (AzDException e) {
        }
    }

    @Test
    public void shouldCreateAWikiAttachment() {
        try {
            var wiki = w.wikis().list().getWikiPages();
            var wikiId = wiki.get(0).getId();
            var wikiName = "azure-architecture.png";
            StreamHelper.downloadFromUrl("https://support.content.office.net/en-us/media/714fa128-65fa-4ab5-b1f7-15bed1065500.png",
                    "azure-architecture.png");
            var content = StreamHelper.convertToStream(new File("azure-architecture.png"));

            w.attachments().create(wikiId, r ->
            {
                r.queryParameters.name = wikiName;
                r.queryParameters.version = "develop";
                r.queryParameters.versionType = GitVersionType.BRANCH;
                r.queryParameters.versionOptions = GitVersionOptions.NONE;
            }, content);
        } catch (AzDException e) {
            // Ignore WikiCreateAttachmentFailedException
        }
    }

    @Test
    public void shouldCreateWikiPageMove() throws AzDException {
        var wiki = w.wikis().list().getWikiPages();
        var wikiId = wiki.get(0).getId();
        var pageMoveParams = new WikiPageMoveParameters();
        pageMoveParams.setPath("requirements");
        pageMoveParams.setNewPath("requirements");
        pageMoveParams.setNewOrder(0);

        w.pageMoves().create(wikiId, r ->
        {
            r.queryParameters.comment = StringUtils.EMPTY;
            r.queryParameters.version = "develop";
            r.queryParameters.versionOptions = GitVersionOptions.NONE;
            r.queryParameters.versionType = GitVersionType.BRANCH;
        }, pageMoveParams);
    }

    @Test
    public void shouldGetThePageStats() throws AzDException {
        try {
            var wiki = w.wikis().list().getWikiPages();
            var wikiId = wiki.get(0).getId();
            w.pageStats().get(1, wikiId, 0);
        } catch (AzDException ex) {}
    }

    @Test
    public void shouldCreateAWikiPage() {
        try {
            var wiki = w.wikis().list().getWikiPages();
            var wikiId = wiki.get(0).getId();
            var page = "ProjectSafeLanding";

            var wikiCreateOrUpdateParameters = new WikiCreateOrUpdateParameters();
            wikiCreateOrUpdateParameters.wikiIdentifier = wikiId;
            wikiCreateOrUpdateParameters.content = "New sample WIKI page";

            w.pages().createOrUpdate(wikiCreateOrUpdateParameters, r ->
            {
                r.queryParameters.path = page;
                r.queryParameters.comment = "Page initial commit";
                r.queryParameters.version = "develop";
                r.queryParameters.versionOptions = GitVersionOptions.NONE;
                r.queryParameters.versionType = GitVersionType.BRANCH;
            });
        } catch (AzDException e) {
            // Ignore WikiPageAlreadyExistsException
        }
    }

    @Test
    public void shouldDeleteAWikiPage() {
        try {
            var wiki = w.wikis().list().getWikiPages();
            var wikiId = wiki.get(0).getId();
            var page = "ProjectSafeLanding";

            w.pages().delete(wikiId, r ->
            {
                r.queryParameters.path = page;
                r.queryParameters.comment = "Page deleted";
                r.queryParameters.version = "develop";
                r.queryParameters.versionOptions = GitVersionOptions.NONE;
                r.queryParameters.versionType = GitVersionType.BRANCH;
            });
        } catch (AzDException e) {
            // Ignore WikiPageNotFoundException
        }
    }

    @Test
    public void shouldGetAWikiPage() {
        try {
            var wiki = w.wikis().list().getWikiPages();
            var wikiId = wiki.get(0).getId();
            var page = "ProjectSafeLanding";

            w.pages().get(wikiId, r ->
            {
                r.queryParameters.path = page;
                r.queryParameters.recursionLevel = VersionControlRecursionType.FULL;
                r.queryParameters.includeContent = false;
                r.queryParameters.comment = "Get wiki page";
                r.queryParameters.version = "develop";
                r.queryParameters.versionOptions = GitVersionOptions.NONE;
                r.queryParameters.versionType = GitVersionType.BRANCH;
            });
        } catch (AzDException e) {
            // Ignore WikiPageNotFoundException
        }
    }

    @Test
    public void shouldGetWikiPageById() {
        try {
            var wiki = w.wikis().list().getWikiPages();
            var wikiId = wiki.get(0).getId();
            var page = "ProjectSafeLanding";

            var wikiPage = w.pages().get(wikiId, r ->
            {
                r.queryParameters.path = page;
                r.queryParameters.recursionLevel = VersionControlRecursionType.FULL;
                r.queryParameters.includeContent = false;
                r.queryParameters.comment = "Get wiki page";
                r.queryParameters.version = "develop";
                r.queryParameters.versionOptions = GitVersionOptions.NONE;
                r.queryParameters.versionType = GitVersionType.BRANCH;
            });

            w.pages().getById(wikiId, wikiPage.getId(), r ->
            {
                r.queryParameters.includeContent = true;
                r.queryParameters.recursionLevel = VersionControlRecursionType.FULL;
            });
        } catch (AzDException e) {
            // Ignore WikiPageNotFoundException
        }
    }

    @Test
    public void shouldGetWikiPageContent() {
        try {
            var wiki = w.wikis().list().getWikiPages();
            var wikiId = wiki.get(0).getId();
            var page = "ProjectSafeLanding";
            var wikiPage = w.pages().get(wikiId, r ->
            {
                r.queryParameters.path = page;
                r.queryParameters.recursionLevel = VersionControlRecursionType.FULL;
                r.queryParameters.includeContent = false;
                r.queryParameters.comment = "Get wiki page";
                r.queryParameters.version = "develop";
                r.queryParameters.versionOptions = GitVersionOptions.NONE;
                r.queryParameters.versionType = GitVersionType.BRANCH;
            });
            w.pages().getByIdAsText(wikiId, wikiPage.getId(), r ->
            {
                r.queryParameters.includeContent = true;
                r.queryParameters.recursionLevel = VersionControlRecursionType.FULL;
            });
        } catch (AzDException e) {
            // Ignore WikiPageNotFoundException
        }
    }

    @Test
    public void shouldGetWikiPageContentAsZip() throws AzDException {
        try {
            var wiki = w.wikis().list().getWikiPages();
            var wikiId = wiki.get(0).getId();
            var page = "ProjectSafeLanding";
            var wikiPage = w.pages().get(wikiId, r ->
            {
                r.queryParameters.path = page;
                r.queryParameters.recursionLevel = VersionControlRecursionType.FULL;
                r.queryParameters.includeContent = false;
                r.queryParameters.comment = "Get wiki page";
                r.queryParameters.version = "develop";
                r.queryParameters.versionOptions = GitVersionOptions.NONE;
                r.queryParameters.versionType = GitVersionType.BRANCH;
            });

            var res = w.pages().getByIdAsZip(wikiId, wikiPage.getId(), r ->
            {
                r.queryParameters.includeContent = true;
                r.queryParameters.recursionLevel = VersionControlRecursionType.FULL;
            });
            StreamHelper.download(page + ".zip", res);
        } catch (AzDException e) {
            // Ignore WikiPageNotFoundException
        }
    }

    @Test
    public void shouldUpdateWikiPage() {
        try {
            var wiki = w.wikis().list().getWikiPages();
            var wikiId = wiki.get(0).getId();
            var page = "ProjectSafeLanding";
            var wikiPage = w.pages().get(wikiId, r ->
            {
                r.queryParameters.path = page;
                r.queryParameters.recursionLevel = VersionControlRecursionType.FULL;
                r.queryParameters.includeContent = false;
                r.queryParameters.comment = "Get wiki page";
                r.queryParameters.version = "develop";
                r.queryParameters.versionOptions = GitVersionOptions.NONE;
                r.queryParameters.versionType = GitVersionType.BRANCH;
            });

            var wikiUpdateParams = new WikiUpdateParameters();
            wikiUpdateParams.id = wikiPage.getId().toString();
            wikiUpdateParams.wikiIdentifier = wikiId;
            wikiUpdateParams.comment = "Updated page content";
            wikiUpdateParams.content = "# Heading\n" +
                    "This is updated content. \n ## Second Heading \n Place holder for safe landing project.";
            wikiUpdateParams.eTagVersion = wikiPage.geteTag();

            w.pages().update(wikiUpdateParams);
        } catch (AzDException e) {
            // Ignore WikiPageNotFoundException
        }
    }
}
