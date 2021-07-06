package org.azd.interfaces;

import org.azd.enums.WikiType;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.wiki.types.WikiV2;
import org.azd.wiki.types.WikiV2Pages;

public interface WikiDetails {
    WikiV2 createWiki(String branchName, WikiType type, String wikiName, String projectId, String repositoryId, String mappedPath) throws ConnectionException, AzDException;
    WikiV2 deleteWiki(String wikiIdentifier) throws ConnectionException, AzDException;
    WikiV2 getWiki(String wikiIdentifier) throws ConnectionException, AzDException;
    WikiV2Pages getWikis() throws ConnectionException, AzDException;
}
