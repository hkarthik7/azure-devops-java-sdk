package org.azd.core.types;

/**
 * Represents the request body to create a new project.
 */
public class ProjectCreationParameters {
    /**
     * Name of the project.
     */
    public String name;
    /**
     * Description for the project.
     */
    public String description;
    /**
     * Source control type. E.g. "Git" or "VSTS".
     */
    public String sourceControlType;
    /**
     * Process template id.
     */
    public String templateTypeId;
}
