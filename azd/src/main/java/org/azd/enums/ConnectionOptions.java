package org.azd.enums;

public enum ConnectionOptions {
    /**
     * Retrieve no optional data.
     */
    None,
    /**
     * Includes information about AccessMappings and ServiceDefinitions.
     */
    IncludeServices,
    /**
     * Includes the last user access for this host.
     */
    IncludeLastUserAccess,
    /**
     * This is only valid on the deployment host and when true. Will only return inherited definitions.
     */
    IncludeInheritedDefinitionsOnly,
    /**
     * When true will only return non-inherited definitions. Only valid at non-deployment host.
     */
    IncludeNonInheritedDefinitionsOnly
}
