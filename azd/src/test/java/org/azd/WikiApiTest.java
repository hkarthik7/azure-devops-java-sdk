package org.azd;

import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.helpers.StreamHelper;
import org.azd.interfaces.CoreDetails;
import org.azd.interfaces.GitDetails;
import org.azd.interfaces.WikiDetails;
import org.azd.utils.AzDClientApi;
import org.azd.wiki.types.GitVersionDescriptor;
import org.azd.wiki.types.WikiCreateParameters;
import org.azd.wiki.types.WikiPageMoveParameters;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class WikiApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static AzDClientApi webApi;
    private static WikiDetails w;
    private static CoreDetails c;
    private static GitDetails g;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        webApi = new AzDClientApi(organization, project, token);
        c = webApi.getCoreApi();
        w = webApi.getWikiApi();
        g = webApi.getGitApi();
    }

    @Test
    public void shouldCreateWiki() throws AzDException {
        var projectId = c.getProject("azure-devops-java-sdk").getId();
        var repoId = g.getRepository("testRepository").getId();
        String wikiPage = null;
        try {
            wikiPage = w.getWiki("NewWiki").getName();
        } catch (AzDException e) { }

        if (wikiPage == null) {
            var wikiCreateParameters = new WikiCreateParameters("/docs", "NewWiki", projectId, repoId, WikiType.CODEWIKI,
                    new GitVersionDescriptor("develop"));
            w.createWiki(wikiCreateParameters);
        }
    }

    @Test
    public void shouldCreateNewProjectWiki() {
        try {
            var projectId = c.getProject("azure-devops-java-sdk").getId();
            var wikiCreateParameters = new WikiCreateParameters("Azure DevOps java sdk documentation", projectId, WikiType.PROJECTWIKI);
            w.createWiki(wikiCreateParameters);
        } catch (AzDException e) {
            // ignore WikiAlreadyExistsException
        }
    }

    @Test
    public void shouldGetAWiki() throws AzDException {
        w.getWiki("NewWiki");
    }

    @Test
    public void shouldGetAllWikis() throws AzDException {
        w.getWikis();
    }

    @Test
    public void shouldDeleteAWiki() {
        try {
            w.deleteWiki("MyProjectWiki");
        } catch (AzDException e) {
        }
    }

    @Test
    public void shouldCreateAWikiAttachment() {
        try {
            var wiki = w.getWikis().getWikiPages();
            var wikiId = wiki.get(0).getId();
            var wikiName = "azure-architecture.png";
            StreamHelper.downloadFromUrl("https://support.content.office.net/en-us/media/714fa128-65fa-4ab5-b1f7-15bed1065500.png",
                    "azure-architecture.png");
            var content = StreamHelper.convertToStream(new File("azure-architecture.png"));

            w.createWikiAttachment(wikiId, wikiName, "develop", GitVersionType.BRANCH, GitVersionOptions.NONE, content);
        } catch (AzDException e) {
            // Ignore WikiCreateAttachmentFailedException
        }
    }

    @Test
    public void shouldCreateWikiPageMove() throws AzDException {
        var wiki = w.getWikis().getWikiPages();
        var wikiId = wiki.get(0).getId();
        var pageMoveParams = new WikiPageMoveParameters();
        pageMoveParams.setPath("requirements");
        pageMoveParams.setNewPath("requirements");
        pageMoveParams.setNewOrder(0);

        w.createPageMove(wikiId, null, "develop", GitVersionType.BRANCH, GitVersionOptions.NONE, pageMoveParams);
    }

    @Test
    public void shouldGetThePageStats() throws AzDException {
        var wiki = w.getWikis().getWikiPages();
        var wikiId = wiki.get(0).getId();
        w.getPageStats(wikiId, 1, 0);
    }

    @Test
    public void shouldCreateAWikiPage() {
        try {
        var wiki = w.getWikis().getWikiPages();
        var wikiId = wiki.get(0).getId();
        var page = "ProjectSafeLanding";

        w.createOrUpdateWikiPage(wikiId, page, "Page initial commit", null, "develop", GitVersionType.BRANCH,
                GitVersionOptions.NONE, "New sample WIKI page");
        } catch (AzDException e) {
            // Ignore WikiPageAlreadyExistsException
        }
    }

    @Test
    public void shouldDeleteAWikiPage() {
        try {
            var wiki = w.getWikis().getWikiPages();
            var wikiId = wiki.get(0).getId();
            var page = "ProjectSafeLanding";

            w.deleteWikiPage(wikiId, page, "Page deleted", "develop", GitVersionType.BRANCH,
                    GitVersionOptions.NONE);
        } catch (AzDException e) {
            // Ignore WikiPageNotFoundException
        }
    }

    @Test
    public void shouldGetAWikiPage() {
        try {
            var wiki = w.getWikis().getWikiPages();
            var wikiId = wiki.get(0).getId();
            var page = "ProjectSafeLanding";

           w.getWikiPage(wikiId, false, page, VersionControlRecursionType.FULL,
                    "Get wiki page", "develop", GitVersionType.BRANCH, GitVersionOptions.NONE);
        } catch (AzDException e) {
            // Ignore WikiPageNotFoundException
        }
    }

    @Test
    public void shouldGetWikiPageById() {
        try {
            var wiki = w.getWikis().getWikiPages();
            var wikiId = wiki.get(0).getId();
            var page = "ProjectSafeLanding";

            var wikiPage = w.getWikiPage(wikiId, false, page, VersionControlRecursionType.FULL,
                    "Get wiki page", "develop", GitVersionType.BRANCH, GitVersionOptions.NONE);

            w.getWikiPageById(wikiPage.getId().toString(), wikiId, true, VersionControlRecursionType.FULL);
        } catch (AzDException e) {
            // Ignore WikiPageNotFoundException
        }
    }

    @Test
    public void shouldGetWikiPageContent() {
        try {
            var wiki = w.getWikis().getWikiPages();
            var wikiId = wiki.get(0).getId();
            var page = "ProjectSafeLanding";
            var wikiPage = w.getWikiPage(wikiId, false, page, VersionControlRecursionType.FULL,
                    "Get wiki page", "develop", GitVersionType.BRANCH, GitVersionOptions.NONE);

            w.getWikiPageContent(wikiPage.getId().toString(), wikiId);
        } catch (AzDException e) {
            // Ignore WikiPageNotFoundException
        }
    }

    @Test
    public void shouldGetWikiPageContentAsZip() throws AzDException {
        try {
            var wiki = w.getWikis().getWikiPages();
            var wikiId = wiki.get(0).getId();
            var page = "ProjectSafeLanding";
            var wikiPage = w.getWikiPage(wikiId, false, page, VersionControlRecursionType.FULL,
                    "Get wiki page", "develop", GitVersionType.BRANCH, GitVersionOptions.NONE);

            var res = w.getWikiPageAsZip(wikiPage.getId().toString(), wikiId);
            StreamHelper.download(page + ".zip", res);
        } catch (AzDException e) {
            // Ignore WikiPageNotFoundException
        }
    }

    @Test
    public void shouldUpdateWikiPage() {
        try {
            var wiki = w.getWikis().getWikiPages();
            var wikiId = wiki.get(0).getId();
            var page = "ProjectSafeLanding";
            var wikiPage = w.getWikiPage(wikiId, false, page, VersionControlRecursionType.FULL,
                    "Get wiki page", "develop", GitVersionType.BRANCH, GitVersionOptions.NONE);

            w.updateWikiPage(wikiPage.getId().toString(), wikiId, "Updated page content", wikiPage.geteTag(), "# Heading\n" +
                    "This is updated content. \n ## Second Heading \n Place holder for safe landing project.");
        } catch (AzDException e) {
            // Ignore WikiPageNotFoundException
        }
    }

}
