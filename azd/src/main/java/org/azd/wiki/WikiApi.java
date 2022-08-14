package org.azd.wiki;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.azd.common.ApiVersion;
import org.azd.connection.Connection;
import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.helpers.StreamHelper;
import org.azd.helpers.URLHelper;
import org.azd.interfaces.WikiDetails;
import org.azd.utils.AzDAsyncApi;
import org.azd.utils.RestClient;
import org.azd.wiki.types.*;

import java.io.InputStream;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import static org.azd.utils.RestClient.*;

/***
 * Wiki class to manage Wiki API
 */
public class WikiApi extends AzDAsyncApi<WikiApi> implements WikiDetails {
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
    public WikiApi(Connection connection) {
        this.CONNECTION = connection;
    }

    /***
     * Creates the wiki resource.
     * @param wikiCreateParameters {@link WikiCreateParameters} helps to create code wiki and project wiki. Use the constructor
     * parameter to create respective wikis.
     * @return WikiV2 object {@link WikiV2}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WikiV2 createWiki(WikiCreateParameters wikiCreateParameters) throws AzDException {
        if (wikiCreateParameters.getProjectId() == null) throw new AzDException("Project id cannot be empty.");

        String r = send(RequestMethod.POST, CONNECTION, WIKI, wikiCreateParameters.getProjectId(),
                AREA, null, null, ApiVersion.WIKI, null, wikiCreateParameters, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, WikiV2.class);
    }

    /***
     * Deletes the wiki corresponding to the wiki ID or wiki name provided.
     * @param wikiIdentifier Wiki ID or wiki name.
     * @return WikiV2 {@link WikiV2}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WikiV2 deleteWiki(String wikiIdentifier) throws AzDException {
        String r = send(RequestMethod.DELETE, CONNECTION, WIKI, CONNECTION.getProject(),
                AREA, wikiIdentifier, null, ApiVersion.WIKI, null, null, null);

        return MAPPER.mapJsonResponse(r, WikiV2.class);
    }

    /***
     * Gets the wiki corresponding to the wiki ID or wiki name provided.
     * @param wikiIdentifier Wiki ID or wiki name.
     * @return WikiV2 {@link WikiV2}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WikiV2 getWiki(String wikiIdentifier) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, WIKI, CONNECTION.getProject(),
                AREA, wikiIdentifier, null, ApiVersion.WIKI, null, null, null);

        return MAPPER.mapJsonResponse(r, WikiV2.class);
    }

    /***
     * Gets all wikis in a project or collection.
     * @return WikiV2s {@link WikiV2Pages}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WikiV2Pages getWikis() throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, WIKI, CONNECTION.getProject(),
                AREA, null, null, ApiVersion.WIKI, null, null, null);

        return MAPPER.mapJsonResponse(r, WikiV2Pages.class);
    }

    /**
     * Creates an attachment in the wiki.
     *
     * @param wikiIdentifier Wiki ID or wiki name.
     * @param name Wiki attachment name.
     * @return WikiAttachment Object {@link WikiAttachment}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public WikiAttachment createWikiAttachment(String wikiIdentifier, String name, InputStream content) throws AzDException {
        var q = new HashMap<String, Object>(){{ put("name", name != null ? URLHelper.encodeSpecialWithSpace(name) :  null); }};

        // Wiki attachment Api accepts only encoded String values.
        var body = StreamHelper.convertStreamToBase64(content);

        var r = send(null, RequestMethod.PUT, CONNECTION, WIKI, CONNECTION.getProject(),
                AREA, wikiIdentifier, "attachments", ApiVersion.WIKI_ATTACHMENTS,
                q, HttpRequest.BodyPublishers.ofString(body), HttpResponse.BodyHandlers.ofString(), Map.of("Stream", CustomHeader.STREAM), false);

        var result = MAPPER.mapJsonResponse(r.thenApplyAsync(HttpResponse::body).join(), WikiAttachment.class);

        // Version tag of the attachment is set in headers and this is required for editing wiki pages.
        var eTag = getValueFromHeader(r.thenApplyAsync(HttpResponse::headers).join(), "etag");
        if (eTag != null) result.seteTag(eTag);

        return result;
    }

    /**
     * Creates an attachment in the wiki.
     *
     * @param wikiIdentifier Wiki ID or wiki name.
     * @param name Wiki attachment name.
     * @param version Version string identifier (name of tag/branch, SHA1 of commit)
     * @param versionOptions Version options - Specify additional modifiers to version (e.g Previous)
     * @param versionType Version type (branch, tag, or commit). Determines how Id is interpreted
     * @return WikiAttachment Object {@link WikiAttachment}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public WikiAttachment createWikiAttachment(String wikiIdentifier, String name, String version,
                                               GitVersionType versionType, GitVersionOptions versionOptions, InputStream content) throws AzDException {
        var q = new HashMap<String, Object>(){{
            put("name", name != null ? URLHelper.encodeSpecialWithSpace(name) :  null);
            put("version", version);
            put("versionType", versionType.name());
            put("versionOptions", versionOptions.name());
        }};

        // Wiki attachment Api accepts only encoded String values.
        var body = StreamHelper.convertStreamToBase64(content);

        var r = send(null, RequestMethod.PUT, CONNECTION, WIKI, CONNECTION.getProject(),
                AREA, wikiIdentifier, "attachments", ApiVersion.WIKI_ATTACHMENTS,
                q, HttpRequest.BodyPublishers.ofString(body), HttpResponse.BodyHandlers.ofString(), Map.of("Stream", CustomHeader.STREAM), false);

        var result = MAPPER.mapJsonResponse(r.thenApplyAsync(HttpResponse::body).join(), WikiAttachment.class);

        // Version tag of the attachment is set in headers and this is required for editing wiki pages.
        var eTag = getValueFromHeader(r.thenApplyAsync(HttpResponse::headers).join(), "etag");
        if (eTag != null) result.seteTag(eTag);

        return result;
    }

    /**
     * Creates a page move operation that updates the path and order of the page as provided in the parameters.
     *
     * @param wikiIdentifier Wiki ID or wiki name.
     * @param comment Comment that is to be associated with this page move.
     * @return WikiPageMove Object {@link WikiPageMove}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public WikiPageMove createPageMove(String wikiIdentifier, String comment, WikiPageMoveParameters pageMoveParameters) throws AzDException {
        var q = new HashMap<String, Object>(){{ put("comment", comment != null ? URLHelper.encodeSpecialWithSpace(comment) :  null); }};

        var r = send(null, RequestMethod.POST, CONNECTION, WIKI, CONNECTION.getProject(),
                AREA, wikiIdentifier, "pagemoves", ApiVersion.WIKI_ATTACHMENTS,
                q, HttpRequest.BodyPublishers.ofString(MAPPER.convertToString(pageMoveParameters)),
                HttpResponse.BodyHandlers.ofString(), Map.of("Content-Type", CustomHeader.JSON_CONTENT_TYPE), false);

        var result = MAPPER.mapJsonResponse(r.thenApplyAsync(HttpResponse::body).join(), WikiPageMove.class);

        // Version tag of the attachment is set in headers and this is required for editing wiki pages.
        var eTag = getValueFromHeader(r.thenApplyAsync(HttpResponse::headers).join(), "etag");
        if (eTag != null) result.seteTag(eTag);

        return result;
    }

    /**
     * Creates a page move operation that updates the path and order of the page as provided in the parameters.
     *
     * @param wikiIdentifier Wiki ID or wiki name.
     * @param comment Comment that is to be associated with this page move.
     * @param version Version string identifier (name of tag/branch, SHA1 of commit)
     * @param versionOptions Version options - Specify additional modifiers to version (e.g Previous)
     * @param versionType Version type (branch, tag, or commit). Determines how Id is interpreted
     * @return WikiPageMove Object {@link WikiPageMove}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public WikiPageMove createPageMove(String wikiIdentifier, String comment, String version,
                                       GitVersionType versionType, GitVersionOptions versionOptions,
                                       WikiPageMoveParameters pageMoveParameters) throws AzDException {
        var q = new HashMap<String, Object>(){{
            put("comment", comment);
            put("version", version);
            put("versionType", versionType.name());
            put("versionOptions", versionOptions.name());
        }};

        var r = send(null, RequestMethod.POST, CONNECTION, WIKI, CONNECTION.getProject(),
                AREA, wikiIdentifier, "pagemoves", ApiVersion.WIKI_ATTACHMENTS,
                q, HttpRequest.BodyPublishers.ofString(MAPPER.convertToString(pageMoveParameters)),
                HttpResponse.BodyHandlers.ofString(), Map.of("Content-Type", CustomHeader.JSON_CONTENT_TYPE), false);

        var result = MAPPER.mapJsonResponse(r.thenApplyAsync(HttpResponse::body).join(), WikiPageMove.class);

        // Version tag of the attachment is set in headers and this is required for editing wiki pages.
        var eTag = getValueFromHeader(r.thenApplyAsync(HttpResponse::headers).join(), "etag");
        if (eTag != null) result.seteTag(eTag);

        return result;
    }

    /**
     * Returns page detail corresponding to Page ID.
     *
     * @param pageId Wiki page ID.
     * @param wikiIdentifier Wiki ID or wiki name.
     * @return WikiPageDetail Object {@link WikiPageDetail}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public WikiPageDetail getPageStats(String wikiIdentifier, int pageId, int pageViewsForDays) throws AzDException {
        var q = new HashMap<String, Integer>(){{ put("pageViewsForDays", pageViewsForDays); }};

        var r = send(RequestMethod.POST, CONNECTION, WIKI, CONNECTION.getProject(),
                AREA, wikiIdentifier, "pages/" + pageId + "/stats", ApiVersion.WIKI_ATTACHMENTS,
                q, null, CustomHeader.JSON);

        return MAPPER.mapJsonResponse(r, WikiPageDetail.class);
    }

    /**
     * Creates or edits a wiki page.
     *
     * @param wikiIdentifier Wiki ID or wiki name.
     * @param path Wiki page path.
     * @param comment Comment to be associated with the page operation.
     * @return WikiPage Object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public WikiPage createOrUpdateWikiPage(String wikiIdentifier, String path, String comment, String eTagVersion, String content) throws AzDException {
        var q = new HashMap<String, Object>(){{
            put("path", path);
            put("comment", comment != null ? URLHelper.encodeSpecialWithSpace(comment) : null);
        }};

        var headers = new HashMap<String, CustomHeader>(){{
            put("Content-Type", CustomHeader.JSON_CONTENT_TYPE);
        }};

        if (eTagVersion != null) {
            CustomHeader.CUSTOM_HEADER.setCustomHeaders("If-Match", eTagVersion);
            headers.put("If-Match", CustomHeader.CUSTOM_HEADER);
        }

        var r = send(null, RequestMethod.PUT, CONNECTION, WIKI, CONNECTION.getProject(),
                AREA, wikiIdentifier, "pages", ApiVersion.WIKI_ATTACHMENTS,
                q, HttpRequest.BodyPublishers.ofString(MAPPER.convertToString(Map.of("content", content))),
                HttpResponse.BodyHandlers.ofString(), headers, false);

        var result = MAPPER.mapJsonResponse(r.thenApplyAsync(HttpResponse::body).join(), WikiPage.class);

        // Version tag of the attachment is set in headers and this is required for editing wiki pages.
        // etag value is returned in both create and update operations.
        var eTag = getValueFromHeader(r.thenApplyAsync(HttpResponse::headers).join(), "etag");
        if (eTag != null) result.seteTag(eTag);

        return result;
    }

    /**
     * Creates or edits a wiki page.
     *
     * @param wikiIdentifier Wiki ID or wiki name.
     * @param path Wiki page path.
     * @param comment Comment to be associated with the page operation.
     * @param version Version string identifier (name of tag/branch, SHA1 of commit)
     * @param versionOptions Version options - Specify additional modifiers to version (e.g Previous)
     * @param versionType Version type (branch, tag, or commit). Determines how Id is interpreted
     * @return WikiPage Object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public WikiPage createOrUpdateWikiPage(String wikiIdentifier, String path, String comment, String eTagVersion, String version,
                                       GitVersionType versionType, GitVersionOptions versionOptions,
                                       String content) throws AzDException {
        var q = new HashMap<String, Object>(){{
            put("path", path);
            put("comment", comment != null ? URLHelper.encodeSpecialWithSpace(comment) : null);
            put("version", version);
            put("versionType", versionType.name());
            put("versionOptions", versionOptions.name());
        }};

        var headers = new HashMap<String, CustomHeader>(){{
            put("Content-Type", CustomHeader.JSON_CONTENT_TYPE);
        }};

        if (eTagVersion != null) {
            CustomHeader.CUSTOM_HEADER.setCustomHeaders("If-Match", eTagVersion);
            headers.put("If-Match", CustomHeader.CUSTOM_HEADER);
        }

        var r = send(null, RequestMethod.PUT, CONNECTION, WIKI, CONNECTION.getProject(),
                AREA, wikiIdentifier, "pages", ApiVersion.WIKI_ATTACHMENTS,
                q, HttpRequest.BodyPublishers.ofString(MAPPER.convertToString(Map.of("content", content))),
                HttpResponse.BodyHandlers.ofString(), headers, false);

        var result = MAPPER.mapJsonResponse(r.thenApplyAsync(HttpResponse::body).join(), WikiPage.class);

        // Version tag of the attachment is set in headers and this is required for editing wiki pages.
        // etag value is returned in both create and update operations.
        var eTag = getValueFromHeader(r.thenApplyAsync(HttpResponse::headers).join(), "etag");
        if (eTag != null) result.seteTag(eTag);

        return result;
    }

    /**
     * Deletes a wiki page.
     *
     * @param wikiIdentifier Wiki ID or wiki name.
     * @param path Wiki page path.
     * @param comment Comment to be associated with this page delete.
     * @return WikiPage Object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public WikiPage deleteWikiPage(String wikiIdentifier, String path, String comment) throws AzDException {
        var q = new HashMap<String, Object>(){{
            put("path", path);
            put("comment", comment != null ? URLHelper.encodeSpecialWithSpace(comment) : null);
        }};

        var r = send(null, RequestMethod.DELETE, CONNECTION, WIKI, CONNECTION.getProject(),
                AREA, wikiIdentifier, "pages", ApiVersion.WIKI_ATTACHMENTS, q, null,
                HttpResponse.BodyHandlers.ofString(), Map.of("Content-Type", CustomHeader.JSON_CONTENT_TYPE), false);

        var result = MAPPER.mapJsonResponse(r.thenApplyAsync(HttpResponse::body).join(), WikiPage.class);

        // Version tag of the attachment is set in headers and this is required for editing wiki pages.
        // etag value is returned in both create and update operations.
        var eTag = getValueFromHeader(r.thenApplyAsync(HttpResponse::headers).join(), "etag");
        if (eTag != null) result.seteTag(eTag);

        return result;
    }

    /**
     * Deletes a wiki page.
     *
     * @param wikiIdentifier Wiki ID or wiki name.
     * @param path Wiki page path.
     * @param comment Comment to be associated with this page delete.
     * @param version Version string identifier (name of tag/branch, SHA1 of commit)
     * @param versionOptions Version options - Specify additional modifiers to version (e.g Previous)
     * @param versionType Version type (branch, tag, or commit). Determines how Id is interpreted
     * @return WikiPage Object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public WikiPage deleteWikiPage(String wikiIdentifier, String path, String comment, String version,
                                   GitVersionType versionType, GitVersionOptions versionOptions) throws AzDException {
        var q = new HashMap<String, Object>(){{
            put("path", path);
            put("comment", comment != null ? URLHelper.encodeSpecialWithSpace(comment) : null);
            put("version", version);
            put("versionType", versionType.name());
            put("versionOptions", versionOptions.name());
        }};

        var r = send(null, RequestMethod.DELETE, CONNECTION, WIKI, CONNECTION.getProject(),
                AREA, wikiIdentifier, "pages", ApiVersion.WIKI_ATTACHMENTS, q, null,
                HttpResponse.BodyHandlers.ofString(), Map.of("Content-Type", CustomHeader.JSON_CONTENT_TYPE), false);

        var result = MAPPER.mapJsonResponse(r.thenApplyAsync(HttpResponse::body).join(), WikiPage.class);

        // Version tag of the attachment is set in headers and this is required for editing wiki pages.
        // etag value is returned in both create and update operations.
        var eTag = getValueFromHeader(r.thenApplyAsync(HttpResponse::headers).join(), "etag");
        if (eTag != null) result.seteTag(eTag);

        return result;
    }

    /**
     * Deletes a wiki page.
     *
     * @param id Wiki page ID.
     * @param wikiIdentifier Wiki ID or wiki name.
     * @param comment Comment to be associated with this page delete.
     * @return WikiPage Object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public WikiPage deleteWikiPageById(String id, String wikiIdentifier, String path, String comment, String version,
                                       GitVersionType versionType, GitVersionOptions versionOptions) throws AzDException {
        var q = new HashMap<String, Object>(){{
            put("path", path);
            put("comment", comment != null ? URLHelper.encodeSpecialWithSpace(comment) : null);
        }};

        var r = send(null, RequestMethod.DELETE, CONNECTION, WIKI, CONNECTION.getProject(),
                AREA, wikiIdentifier, "pages/" + id, ApiVersion.WIKI_ATTACHMENTS, q, null,
                HttpResponse.BodyHandlers.ofString(), Map.of("Content-Type", CustomHeader.JSON_CONTENT_TYPE), false);

        var result = MAPPER.mapJsonResponse(r.thenApplyAsync(HttpResponse::body).join(), WikiPage.class);

        // Version tag of the attachment is set in headers and this is required for editing wiki pages.
        // etag value is returned in both create and update operations.
        var eTag = getValueFromHeader(r.thenApplyAsync(HttpResponse::headers).join(), "etag");
        if (eTag != null) result.seteTag(eTag);

        return result;
    }

    /**
     * Gets metadata of the wiki page for the provided path.
     *
     * @param wikiIdentifier Wiki ID or wiki name.
     * @return WikiPage Object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public WikiPage getWikiPage(String wikiIdentifier) throws AzDException {

        var r = send(null, RequestMethod.GET, CONNECTION, WIKI, CONNECTION.getProject(),
                AREA, wikiIdentifier, "pages", ApiVersion.WIKI_ATTACHMENTS, null, null,
                HttpResponse.BodyHandlers.ofString(), null, false);

        var result = MAPPER.mapJsonResponse(r.thenApplyAsync(HttpResponse::body).join(), WikiPage.class);

        // Version tag of the attachment is set in headers and this is required for editing wiki pages.
        // etag value is returned in both create and update operations.
        var eTag = getValueFromHeader(r.thenApplyAsync(HttpResponse::headers).join(), "etag");
        if (eTag != null) result.seteTag(eTag);

        return result;
    }

    /**
     * Gets metadata of the wiki page for the provided path.
     *
     * @param wikiIdentifier Wiki ID or wiki name.
     * @param includeContent True to include the content of the page in the response for Json content type. Defaults to false (Optional)
     * @param path Wiki page path.
     * @param recursionLevel Recursion level for subpages retrieval. Defaults to None (Optional).
     * @param version Version string identifier (name of tag/branch, SHA1 of commit)
     * @param versionOptions Version options - Specify additional modifiers to version (e.g Previous)
     * @param versionType Version type (branch, tag, or commit). Determines how Id is interpreted
     * @return WikiPage Object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public WikiPage getWikiPage(String wikiIdentifier, boolean includeContent, String path,
                                VersionControlRecursionType recursionLevel, String comment, String version,
                                GitVersionType versionType, GitVersionOptions versionOptions) throws AzDException {
        var q = new HashMap<String, Object>(){{
            put("path", path);
            put("includeContent", includeContent);
            put("comment", comment != null ? URLHelper.encodeSpecialWithSpace(comment) : null);
            put("recursionLevel", recursionLevel.name());
            put("version", version);
            put("versionType", versionType.name());
            put("versionOptions", versionOptions.name());
        }};

        var r = send(null, RequestMethod.GET, CONNECTION, WIKI, CONNECTION.getProject(),
                AREA, wikiIdentifier, "pages", ApiVersion.WIKI_ATTACHMENTS, q, null,
                HttpResponse.BodyHandlers.ofString(), null, false);

        var result = MAPPER.mapJsonResponse(r.thenApplyAsync(HttpResponse::body).join(), WikiPage.class);

        // Version tag of the attachment is set in headers and this is required for editing wiki pages.
        // etag value is returned in both create and update operations.
        var eTag = getValueFromHeader(r.thenApplyAsync(HttpResponse::headers).join(), "etag");
        if (eTag != null) result.seteTag(eTag);

        return result;
    }

    /**
     * Gets metadata of the wiki page for the provided page id.
     *
     * @param id Wiki page ID.
     * @param wikiIdentifier Wiki ID or wiki name..
     * @return WikiPage Object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public WikiPage getWikiPageById(String id, String wikiIdentifier) throws AzDException {
        var r = send(null, RequestMethod.GET, CONNECTION, WIKI, CONNECTION.getProject(),
                AREA, wikiIdentifier, "pages/" + id, ApiVersion.WIKI_ATTACHMENTS, null, null,
                HttpResponse.BodyHandlers.ofString(), null, false);

        var result = MAPPER.mapJsonResponse(r.thenApplyAsync(HttpResponse::body).join(), WikiPage.class);

        // Version tag of the attachment is set in headers and this is required for editing wiki pages.
        // etag value is returned in both create and update operations.
        var eTag = getValueFromHeader(r.thenApplyAsync(HttpResponse::headers).join(), "etag");
        if (eTag != null) result.seteTag(eTag);

        return result;
    }

    /**
     * Gets metadata of the wiki page for the provided page id.
     *
     * @param id Wiki page ID.
     * @param wikiIdentifier Wiki ID or wiki name..
     * @param includeContent True to include the content of the page in the response for Json content type. Defaults to false (Optional)
     * @param recursionLevel Recursion level for subpages retrieval. Defaults to None (Optional).
     * @return WikiPage Object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public WikiPage getWikiPageById(String id, String wikiIdentifier, boolean includeContent,
                                    VersionControlRecursionType recursionLevel) throws AzDException {
        var q = new HashMap<String, Object>(){{
            put("includeContent", includeContent);
            put("recursionLevel", recursionLevel.name());
        }};

        var r = send(null, RequestMethod.GET, CONNECTION, WIKI, CONNECTION.getProject(),
                AREA, wikiIdentifier, "pages/" + id, ApiVersion.WIKI_ATTACHMENTS, q, null,
                HttpResponse.BodyHandlers.ofString(), null, false);

        var result = MAPPER.mapJsonResponse(r.thenApplyAsync(HttpResponse::body).join(), WikiPage.class);

        // Version tag of the attachment is set in headers and this is required for editing wiki pages.
        // etag value is returned in both create and update operations.
        var eTag = getValueFromHeader(r.thenApplyAsync(HttpResponse::headers).join(), "etag");
        if (eTag != null) result.seteTag(eTag);

        return result;
    }

    /**
     * Gets content of the wiki page for the provided page id.
     *
     * @param id Wiki page ID.
     * @param wikiIdentifier Wiki ID or wiki name..
     * @return WikiPage Object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public String getWikiPageContent(String id, String wikiIdentifier) throws AzDException {

        var r = send(null, RequestMethod.GET, CONNECTION, WIKI, CONNECTION.getProject(),
                AREA, wikiIdentifier, "pages/" + id, ApiVersion.WIKI_ATTACHMENTS, null, null,
                HttpResponse.BodyHandlers.ofString(), Map.of("Content-Type", CustomHeader.TEXT_CONTENT), false);

        return r.thenApplyAsync(HttpResponse::body).join();
    }

    /**
     * Gets content of the wiki page as zip file for the provided page id.
     *
     * @param id Wiki page ID.
     * @param wikiIdentifier Wiki ID or wiki name..
     * @return WikiPage Object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public InputStream getWikiPageAsZip(String id, String wikiIdentifier) throws AzDException {
        var r = send(null, RequestMethod.GET, CONNECTION, WIKI, CONNECTION.getProject(),
                AREA, wikiIdentifier, "pages/" + id, ApiVersion.WIKI_ATTACHMENTS, null, null,
                HttpResponse.BodyHandlers.ofInputStream(), Map.of("Stream-Zip", CustomHeader.STREAM_ZIP_ACCEPT), false);

        return r.thenApplyAsync(HttpResponse::body).join();
    }

    /**
     * Edits a wiki page.
     *
     * @param id Wiki page ID.
     * @param wikiIdentifier Wiki ID or wiki name.
     * @param comment Comment to be associated with the page operation.
     * @return WikiPage Object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public WikiPage updateWikiPage(String id, String wikiIdentifier, String comment, String eTagVersion, String content) throws AzDException {
        var q = new HashMap<String, Object>(){{
            put("comment", comment != null ? URLHelper.encodeSpecialWithSpace(comment) : null);
        }};

        CustomHeader.CUSTOM_HEADER.setCustomHeaders("If-Match", eTagVersion);

        var headers = new HashMap<String, CustomHeader>(){{
           put("Content-Type", CustomHeader.JSON_CONTENT_TYPE);
           put("If-Match", CustomHeader.CUSTOM_HEADER);
        }};

        var r = send(null, RequestMethod.PATCH, CONNECTION, WIKI, CONNECTION.getProject(),
                AREA, wikiIdentifier, "pages/" + id, ApiVersion.WIKI_ATTACHMENTS, q,
                HttpRequest.BodyPublishers.ofString(MAPPER.convertToString(Map.of("content", content))),
                HttpResponse.BodyHandlers.ofString(), headers, false);

        var result = MAPPER.mapJsonResponse(r.thenApplyAsync(HttpResponse::body).join(), WikiPage.class);

        // Version tag of the attachment is set in headers and this is required for editing wiki pages.
        // etag value is returned in both create and update operations.
        var eTag = getValueFromHeader(r.thenApplyAsync(HttpResponse::headers).join(), "etag");
        if (eTag != null) result.seteTag(eTag);

        return result;
    }

    /**
     * Helper method to inject the header value in json response.
     *
     * @param headers HttpHeaders object
     * @param keyName Name of the header value to inject
     */
    private String getValueFromHeader(HttpHeaders headers, String keyName) {
        if(headers.firstValue(keyName).isPresent())
            return headers.firstValue(keyName).get().replaceAll("\"", "");
        return null;
    }
}
