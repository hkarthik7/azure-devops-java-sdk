package org.azd.wiki.types;

/**
 * Contract encapsulating parameters for the page create or update operations.
 */
public class WikiCreateOrUpdateParameters {
    /**
     * Wiki ID or wiki name.
     */
    public String wikiIdentifier;
    /**
     * eTAG version; This is mandatory for update operation.
     */
    public String eTagVersion;
    /**
     * Wiki page content
     */
    public String content;
}
