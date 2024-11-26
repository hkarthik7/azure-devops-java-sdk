package org.azd.wiki.types;

/**
 * Contract encapsulating parameters for the page update operations.
 */
public class WikiUpdateParameters {
    /**
     * Wiki page ID.
     */
    public String id;
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
    /**
     * Comment to be associated with the page operation.
     */
    public String comment;
}
