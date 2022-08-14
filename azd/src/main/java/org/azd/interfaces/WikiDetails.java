package org.azd.interfaces;

import org.azd.enums.GitVersionOptions;
import org.azd.enums.GitVersionType;
import org.azd.enums.VersionControlRecursionType;
import org.azd.enums.WikiType;
import org.azd.exceptions.AzDException;
import org.azd.wiki.types.*;

import java.io.InputStream;

public interface WikiDetails {

    WikiV2 createWiki(WikiCreateParameters wikiCreateParameters) throws AzDException;

    WikiV2 deleteWiki(String wikiIdentifier) throws AzDException;

    WikiV2 getWiki(String wikiIdentifier) throws AzDException;

    WikiV2Pages getWikis() throws AzDException;

    WikiAttachment createWikiAttachment(String wikiIdentifier, String name, InputStream content) throws AzDException;

    WikiAttachment createWikiAttachment(String wikiIdentifier, String name, String version,
                                        GitVersionType versionType, GitVersionOptions versionOptions, InputStream content) throws AzDException;

    WikiPageMove createPageMove(String wikiIdentifier, String comment, WikiPageMoveParameters pageMoveParameters) throws AzDException;

    WikiPageMove createPageMove(String wikiIdentifier, String comment, String version,
                                GitVersionType versionType, GitVersionOptions versionOptions, WikiPageMoveParameters pageMoveParameters) throws AzDException;

    WikiPageDetail getPageStats(String wikiIdentifier, int pageId,  int pageViewsForDays) throws AzDException;

    WikiPage createOrUpdateWikiPage(String wikiIdentifier, String path, String comment, String eTagVersion, String content) throws AzDException;

    WikiPage createOrUpdateWikiPage(String wikiIdentifier, String path, String comment, String eTagVersion, String version,
                                GitVersionType versionType, GitVersionOptions versionOptions, String content) throws AzDException;

    WikiPage deleteWikiPage(String wikiIdentifier, String path, String comment) throws AzDException;

    WikiPage deleteWikiPage(String wikiIdentifier, String path, String comment, String version,
                            GitVersionType versionType, GitVersionOptions versionOptions) throws AzDException;

    WikiPage deleteWikiPageById(String id, String wikiIdentifier, String path, String comment, String version,
                            GitVersionType versionType, GitVersionOptions versionOptions) throws AzDException;

    WikiPage getWikiPage(String wikiIdentifier) throws AzDException;

    WikiPage getWikiPage(String wikiIdentifier, boolean includeContent, String path, VersionControlRecursionType recursionLevel,
                         String comment, String version,
                         GitVersionType versionType, GitVersionOptions versionOptions) throws AzDException;

    WikiPage getWikiPageById(String id, String wikiIdentifier) throws AzDException;

    WikiPage getWikiPageById(String id, String wikiIdentifier, boolean includeContent,
                             VersionControlRecursionType recursionLevel) throws AzDException;

    String getWikiPageContent(String id, String wikiIdentifier) throws AzDException;

    InputStream getWikiPageAsZip(String id, String wikiIdentifier) throws AzDException;

    WikiPage updateWikiPage(String id, String wikiIdentifier, String comment, String eTagVersion, String content) throws AzDException;
}
