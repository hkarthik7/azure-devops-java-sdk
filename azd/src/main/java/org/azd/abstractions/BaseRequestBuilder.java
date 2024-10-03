package org.azd.abstractions;

import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.AccessTokenCredential;
import org.azd.http.ClientRequest;

import java.util.Objects;

/**
 * Base request builder that provide required functionalities to the inherited members.
 */
public abstract class BaseRequestBuilder {
    /**
     * Represents the access token credential object.
     */
    protected final AccessTokenCredential accessTokenCredential;
    /**
     * Organisation url.
     */
    protected String organizationUrl;
    /**
     * Represents the Azure DevOps Area.
     */
    protected String area;
    /**
     * Location id.
     */
    protected String locationId;
    /**
     * Api version.
     */
    protected String apiVersion;
    /**
     * Serializer object
     */
    protected SerializerContext serializer;

    /**
     * Constructs the instance with passed values.
     * @param organizationUrl Organisation url.
     * @param accessTokenCredential Access token credential object. {@link AccessTokenCredential}
     */
    protected BaseRequestBuilder(final String organizationUrl, final AccessTokenCredential accessTokenCredential) {
        this(organizationUrl, accessTokenCredential, null, null, null);
    }

    /**
     * Constructs the instance with passed values.
     * @param organizationUrl Organisation url.
     * @param accessTokenCredential Access token credential object. {@link AccessTokenCredential}
     * @param area Azure DevOps service area.
     */
    protected BaseRequestBuilder(final String organizationUrl, final AccessTokenCredential accessTokenCredential, final String area) {
        this(organizationUrl, accessTokenCredential, area, null, null);
    }

    /**
     * Constructs the instance with passed values.
     * @param organizationUrl Organisation url.
     * @param accessTokenCredential Access token credential object. {@link AccessTokenCredential}
     * @param area Azure DevOps service area.
     * @param locationId Location id.
     */
    protected BaseRequestBuilder(final String organizationUrl, final AccessTokenCredential accessTokenCredential, final String area,
                                 final String locationId) {
        this(organizationUrl, accessTokenCredential, area, locationId, null);
    }

    /**
     * Constructs the instance with passed values.
     * @param organizationUrl Organisation url.
     * @param accessTokenCredential Access token credential object. {@link AccessTokenCredential}
     * @param area Azure DevOps service area.
     * @param locationId Location id.
     * @param apiVersion Api version.
     */
    protected BaseRequestBuilder(final String organizationUrl, final AccessTokenCredential accessTokenCredential, final String area,
                                 final String locationId, final String apiVersion) {
        Objects.requireNonNull(accessTokenCredential, "Access token credential cannot be null.");
        Objects.requireNonNull(organizationUrl, "Organization url cannot be null.");

        this.organizationUrl = organizationUrl;
        this.accessTokenCredential = accessTokenCredential;
        this.area = area;
        this.locationId = locationId;
        this.apiVersion = apiVersion;
        this.serializer = InstanceFactory.createSerializerContext();
    }

    /**
     * Request builder to construct the request and execute it.
     *
     * @return ClientRequest.Builder of builder. {@link ClientRequest.Builder}
     */
    protected ClientRequest.Builder builder() {
        var builder = ClientRequest.builder(accessTokenCredential)
                .baseInstance(organizationUrl);
        if (area != null) builder.area(area);
        if (locationId != null) builder.location(locationId);
        builder.apiVersion(apiVersion);

        return builder;
    }

    /**
     * Decides whether to include the project or not.
     */
    public static class ProjectExcludeParameter {
        /**
         * Set false to exclude project from request url.
         */
        public boolean excludeProject = true;
    }
}
