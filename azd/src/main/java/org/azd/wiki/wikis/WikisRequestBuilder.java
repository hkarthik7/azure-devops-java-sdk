package org.azd.wiki.wikis;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.wiki.types.WikiCreateParameters;
import org.azd.wiki.types.WikiV2;
import org.azd.wiki.types.WikiV2Pages;
import org.azd.wiki.types.WikiV2UpdateParameters;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Wiki wikis Api.
 */
public class WikisRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public WikisRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "wiki", "288d122c-dbd4-451d-aa5f-7dbbba070728", ApiVersion.WIKI);
    }

    /**
     * Creates the wiki resource.
     *
     * @param wikiCreateParameters {@link WikiCreateParameters} helps to create code wiki and project wiki. Use the constructor
     *                             parameter to create respective wikis.
     * @return WikiV2 object {@link WikiV2}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WikiV2> createAsync(WikiCreateParameters wikiCreateParameters) throws AzDException {
        return builder()
                .POST(wikiCreateParameters)
                .build()
                .executeAsync(WikiV2.class);
    }

    /**
     * Deletes the wiki corresponding to the wiki ID or wiki name provided.
     *
     * @param wikiIdentifier Wiki ID or wiki name.
     * @return WikiV2 {@link WikiV2}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WikiV2> deleteAsync(String wikiIdentifier) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .build()
                .executeAsync(WikiV2.class);
    }

    /**
     * Gets the wiki corresponding to the wiki ID or wiki name provided.
     *
     * @param wikiIdentifier Wiki ID or wiki name.
     * @return WikiV2 {@link WikiV2}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WikiV2> getAsync(String wikiIdentifier) throws AzDException {
        return builder()
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .build()
                .executeAsync(WikiV2.class);
    }

    /**
     * Gets all wikis in a project or collection.
     *
     * @return WikiV2s {@link WikiV2Pages}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WikiV2Pages> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(WikiV2Pages.class);
    }

    /**
     * Updates the wiki corresponding to the wiki ID or wiki name provided using the update parameters.
     *
     * @param wikiIdentifier         Wiki ID or wiki name.
     * @param wikiV2UpdateParameters Wiki update parameters object.
     * @return WikiV2 {@link WikiV2}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WikiV2> updateAsync(String wikiIdentifier, WikiV2UpdateParameters wikiV2UpdateParameters) throws AzDException {
        return builder()
                .PATCH(wikiV2UpdateParameters)
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .build()
                .executeAsync(WikiV2.class);
    }

    /**
     * Creates the wiki resource.
     *
     * @param wikiCreateParameters {@link WikiCreateParameters} helps to create code wiki and project wiki. Use the constructor
     *                             parameter to create respective wikis.
     * @return WikiV2 object {@link WikiV2}
     * @throws AzDException Default Api Exception handler.
     */
    public WikiV2 create(WikiCreateParameters wikiCreateParameters) throws AzDException {
        return builder()
                .POST(wikiCreateParameters)
                .build()
                .execute(WikiV2.class);
    }

    /**
     * Deletes the wiki corresponding to the wiki ID or wiki name provided.
     *
     * @param wikiIdentifier Wiki ID or wiki name.
     * @return WikiV2 {@link WikiV2}
     * @throws AzDException Default Api Exception handler.
     */
    public WikiV2 delete(String wikiIdentifier) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .build()
                .execute(WikiV2.class);
    }

    /**
     * Gets the wiki corresponding to the wiki ID or wiki name provided.
     *
     * @param wikiIdentifier Wiki ID or wiki name.
     * @return WikiV2 {@link WikiV2}
     * @throws AzDException Default Api Exception handler.
     */
    public WikiV2 get(String wikiIdentifier) throws AzDException {
        return builder()
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .build()
                .execute(WikiV2.class);
    }

    /**
     * Gets all wikis in a project or collection.
     *
     * @return WikiV2s {@link WikiV2Pages}
     * @throws AzDException Default Api Exception handler.
     */
    public WikiV2Pages list() throws AzDException {
        return builder()
                .build()
                .execute(WikiV2Pages.class);
    }

    /**
     * Updates the wiki corresponding to the wiki ID or wiki name provided using the update parameters.
     *
     * @param wikiIdentifier         Wiki ID or wiki name.
     * @param wikiV2UpdateParameters Wiki update parameters object.
     * @return WikiV2 {@link WikiV2}
     * @throws AzDException Default Api Exception handler.
     */
    public WikiV2 update(String wikiIdentifier, WikiV2UpdateParameters wikiV2UpdateParameters) throws AzDException {
        return builder()
                .PATCH(wikiV2UpdateParameters)
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .build()
                .execute(WikiV2.class);
    }
}
