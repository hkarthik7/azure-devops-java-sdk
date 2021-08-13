package org.azd;

import org.azd.enums.WikiType;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.AzDClient;
import org.azd.interfaces.CoreDetails;
import org.azd.interfaces.GitDetails;
import org.azd.interfaces.WikiDetails;
import org.azd.utils.AzDClientApi;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class WikiApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static AzDClient webApi;
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
    public void shouldCreateWikiPage() throws ConnectionException, AzDException {
        var projectId = c.getProject("azure-devops-java-sdk").getId();
        var repoId = g.getRepository("testRepository").getId();
        var wikiPage = w.getWiki("NewWiki").getName();

        w.createWiki("develop", WikiType.CODEWIKI, "MyProjectWiki", projectId, repoId, "/");

        // without this check I'm receiving error while running tests.
        if (wikiPage.isEmpty())
            w.createWiki("develop", WikiType.CODEWIKI, "NewWiki", projectId, repoId, "/docs");
    }

    @Test
    public void shouldGetAWikiPage() throws ConnectionException, AzDException {
        w.getWiki("NewWiki");
    }

    @Test
    public void shouldGetAllWikiPages() throws ConnectionException, AzDException {
        w.getWikis();
    }

    @Test
    public void shouldDeleteAWikiPage() throws ConnectionException, AzDException {
        w.deleteWiki("MyProjectWiki");
    }
}
