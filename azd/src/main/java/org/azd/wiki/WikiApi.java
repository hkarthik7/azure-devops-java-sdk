package org.azd.wiki;

import org.azd.common.ApiVersion;
import org.azd.connection.Connection;
import org.azd.enums.RequestMethod;
import org.azd.enums.WikiType;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.WikiDetails;
import org.azd.wiki.types.WikiV2;
import org.azd.wiki.types.WikiV2Pages;

import java.util.HashMap;

import static org.azd.utils.Client.send;

/***
 * Wiki class to manage Wiki API
 */
public class WikiApi implements WikiDetails {
    /***
     * Connection object
     */
    private final Connection CONNECTION;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "wiki/wikis";
    private final String WIKI = "bf7d82a0-8aa5-4613-94ef-6172a5ea01f3";

    /***
     * Pass the connection object to work with Work Api
     * @param connection Connection object
     */
    public WikiApi(Connection connection) { this.CONNECTION = connection; }

    /***
     * Creates the wiki resource.
     * @param branchName Branch name of the repository from which you need to create Wiki. Not required for ProjectWiki type.
     * @param type Type of the wiki. {@link WikiType}
     * @param wikiName Wiki name.
     * @param projectId ID of the project in which the wiki is to be created.
     * @param repositoryId ID of the git repository that backs up the wiki. Not required for ProjectWiki type.
     * @param mappedPath Folder path inside repository which is shown as Wiki. Not required for ProjectWiki type.
     * @return WikiV2 {@link WikiV2}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WikiV2 createWiki(String branchName, WikiType type, String wikiName, String projectId,
                             String repositoryId, String mappedPath) throws ConnectionException, AzDException {
        var b = new HashMap<String, Object>(){{
           put("version", new HashMap<String, Object>(){{ put("version", branchName); }});
           put("type", WikiType.CODEWIKI.toString().toLowerCase());
           put("name", wikiName);
           put("projectId", projectId);
           put("repositoryId", repositoryId);
           put("mappedPath", mappedPath);
        }};

        String r = send(RequestMethod.POST, CONNECTION, WIKI, CONNECTION.getProject(),
                AREA,null , null, ApiVersion.WIKI, null, b);

        return MAPPER.mapJsonResponse(r, WikiV2.class);
    }

    /***
     * Deletes the wiki corresponding to the wiki ID or wiki name provided.
     * @param wikiIdentifier Wiki ID or wiki name.
     * @return WikiV2 {@link WikiV2}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WikiV2 deleteWiki(String wikiIdentifier) throws ConnectionException, AzDException {
        String r = send(RequestMethod.DELETE, CONNECTION, WIKI, CONNECTION.getProject(),
                AREA, wikiIdentifier , null, ApiVersion.WIKI, null, null);

        return MAPPER.mapJsonResponse(r, WikiV2.class);
    }

    /***
     * Gets the wiki corresponding to the wiki ID or wiki name provided.
     * @param wikiIdentifier Wiki ID or wiki name.
     * @return WikiV2 {@link WikiV2}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WikiV2 getWiki(String wikiIdentifier) throws ConnectionException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, WIKI, CONNECTION.getProject(),
                AREA, wikiIdentifier , null, ApiVersion.WIKI, null, null);

        return MAPPER.mapJsonResponse(r, WikiV2.class);
    }

    /***
     * Gets all wikis in a project or collection.
     * @return WikiV2s {@link WikiV2Pages}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WikiV2Pages getWikis() throws ConnectionException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, WIKI, CONNECTION.getProject(),
                AREA, null , null, ApiVersion.WIKI, null, null);

        return MAPPER.mapJsonResponse(r, WikiV2Pages.class);
    }
}
