package org.azd.core.projects;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.common.types.JsonPatchDocument;
import org.azd.core.types.ProjectProperties;
import org.azd.enums.CustomHeader;
import org.azd.exceptions.AzDException;
import org.azd.helpers.Utils;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to manage project properties Api.
 */
public class PropertiesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public PropertiesRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "core", "4976a71a-4487-49aa-8aab-a1eda469037a", ApiVersion.PROJECT_PROPERTIES);
    }

    /**
     * Get a collection of team project properties.
     *
     * @param projectId provide the project guid not the project name
     * @return ProjectProperties {@link ProjectProperties}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ProjectProperties> getAsync(String projectId) throws AzDException {
        return builder()
                .serviceEndpoint("projectId", projectId)
                .build()
                .executeAsync(ProjectProperties.class);
    }

    /**
     * Get a collection of team project properties.
     *
     * @param projectId provide the project guid not the project name
     * @param keys      A comma-delimited string of team project property names.
     *                  Wildcard characters ("?" and "*") are supported. If no key is specified, all properties will be returned.
     * @return ProjectProperties {@link ProjectProperties}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ProjectProperties> getAsync(String projectId, String... keys) throws AzDException {
        return builder()
                .serviceEndpoint("projectId", projectId)
                .query("keys", Utils.toString(keys))
                .build()
                .executeAsync(ProjectProperties.class);
    }

    /**
     * Create, update, and delete team project properties.
     *
     * @param projectId provide the project guid not the project name
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> setAsync(String projectId, JsonPatchDocument projectProperty) throws AzDException {
        return builder()
                .PATCH(projectProperty)
                .serviceEndpoint("projectId", projectId)
                .header(CustomHeader.JSON_PATCH)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get a collection of team project properties.
     *
     * @param projectId provide the project guid not the project name
     * @return ProjectProperties {@link ProjectProperties}
     * @throws AzDException Default Api Exception handler.
     */
    public ProjectProperties get(String projectId) throws AzDException {
        return builder()
                .serviceEndpoint("projectId", projectId)
                .build()
                .execute(ProjectProperties.class);
    }

    /**
     * Get a collection of team project properties.
     *
     * @param projectId provide the project guid not the project name
     * @param keys      A comma-delimited string of team project property names.
     *                  Wildcard characters ("?" and "*") are supported. If no key is specified, all properties will be returned.
     * @return ProjectProperties {@link ProjectProperties}
     * @throws AzDException Default Api Exception handler.
     */
    public ProjectProperties get(String projectId, String... keys) throws AzDException {
        return builder()
                .serviceEndpoint("projectId", projectId)
                .query("keys", Utils.toString(keys))
                .build()
                .execute(ProjectProperties.class);
    }

    /**
     * Create, update, and delete team project properties.
     *
     * @param projectId provide the project guid not the project name
     * @throws AzDException Default Api Exception handler.
     */
    public Void set(String projectId, JsonPatchDocument projectProperty) throws AzDException {
        return builder()
                .PATCH(projectProperty)
                .serviceEndpoint("projectId", projectId)
                .header(CustomHeader.JSON_PATCH)
                .build()
                .executePrimitive();
    }
}
