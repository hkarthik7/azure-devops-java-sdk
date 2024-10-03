package org.azd.release.releases;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.release.types.Release;
import org.azd.release.types.ReleaseStartMetadata;
import org.azd.release.types.ReleaseUpdateMetadata;
import org.azd.release.types.Releases;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Release releases Api.
 */
public class ReleasesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ReleasesRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "release", "a166fde7-27ad-408e-ba75-703c2cc9d500", ApiVersion.RELEASES);
    }

    /**
     * Provides functionality to work with Release environment API.
     *
     * @return ReleaseEnvironmentRequestBuilder {@link ReleaseEnvironmentRequestBuilder}
     */
    public ReleaseEnvironmentRequestBuilder environment() {
        return new ReleaseEnvironmentRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Release logs API.
     *
     * @return ReleaseLogsRequestBuilder {@link ReleaseLogsRequestBuilder}
     */
    public ReleaseLogsRequestBuilder logs() {
        return new ReleaseLogsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Release Task log API.
     *
     * @return ReleaseTaskLogRequestBuilder {@link ReleaseTaskLogRequestBuilder}
     */
    public ReleaseTaskLogRequestBuilder taskLog() {
        return new ReleaseTaskLogRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Create a release.
     * <p>
     * <br /><br />Example:
     * <br />
     * <pre>{@code
     *         var releaseMetadata = new ReleaseStartMetadata();
     *         var artifacts = new ArtifactMetadata();
     *
     *         var buildVersion = new BuildVersion();
     *         buildVersion.setId("1234"); // Build Id
     *         buildVersion.setName("Demo-Pipeline-CI"); // Build pipeline name
     *
     *         artifacts.setAlias("_Demo-Pipeline-CI"); // Artifact alias name; This can be retrieved from release pipeline.
     *         artifacts.setInstanceReference(buildVersion);
     *
     *         releaseMetadata.setDefinitionId(2); // Release pipeline Id.
     *         releaseMetadata.setDescription("Sample release");
     *         releaseMetadata.setArtifacts(List.of(artifacts));
     *         releaseMetadata.setIsDraft(false);
     *         releaseMetadata.setReason(ReleaseReason.NONE);
     * }</pre>
     *
     * @param releaseStartMetadata Release start metadata to create the release.
     * @return Release object {@link Release}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<Release> createAsync(ReleaseStartMetadata releaseStartMetadata) throws AzDException {
        return builder()
                .POST(releaseStartMetadata)
                .build()
                .executeAsync(Release.class);
    }

    /**
     * Delete a Release
     *
     * @param releaseId pass the release id
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(int releaseId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("releaseId", releaseId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get a Release
     *
     * @param releaseId pass the release id
     * @return Release {@link Release}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Release> getAsync(int releaseId) throws AzDException {
        return builder()
                .serviceEndpoint("releaseId", releaseId)
                .build()
                .executeAsync(Release.class);
    }

    /**
     * Get a Release
     *
     * @param releaseId            pass the release id
     * @param requestConfiguration Represents the query parameters.
     * @return Release {@link Release}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Release> getAsync(int releaseId, Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("releaseId", releaseId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(Release.class);
    }

    /**
     * Get release for a given revision number.
     *
     * @param releaseId                  Id of the release.
     * @param definitionSnapshotRevision Definition snapshot revision number.
     * @return Release revision.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<String> getRevisionAsync(int releaseId, int definitionSnapshotRevision) throws AzDException {
        return builder()
                .serviceEndpoint("releaseId", releaseId)
                .query("definitionSnapshotRevision", definitionSnapshotRevision)
                .header(CustomHeader.TEXT_CONTENT)
                .build()
                .executeStringAsync();
    }

    /**
     * Get a list of releases
     *
     * @return Releases {@link Releases}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Releases> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(Releases.class);
    }

    /**
     * Get a list of releases
     *
     * @param requestConfiguration Represents the query parameters
     * @return Releases {@link Releases}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Releases> listAsync(Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(Releases.class);
    }

    /**
     * Update a complete release object.
     *
     * @param releaseId Id of the release to update.
     * @param release   Release object to update
     * @return a release object {@link Release}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Release> updateAsync(int releaseId, Release release) throws AzDException {
        return builder()
                .PUT(release)
                .serviceEndpoint("releaseId", releaseId)
                .build()
                .executeAsync(Release.class);
    }

    /**
     * Update a complete release object.
     *
     * @param releaseId             Id of the release to update.
     * @param releaseUpdateMetadata Release metadata object to update
     * @return a release object {@link Release}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Release> updateResourceAsync(int releaseId, ReleaseUpdateMetadata releaseUpdateMetadata) throws AzDException {
        return builder()
                .PATCH(releaseUpdateMetadata)
                .serviceEndpoint("releaseId", releaseId)
                .build()
                .executeAsync(Release.class);
    }

    /**
     * Create a release.
     * <p>
     * <br /><br />Example:
     * <br />
     * <pre>{@code
     *         var releaseMetadata = new ReleaseStartMetadata();
     *         var artifacts = new ArtifactMetadata();
     *
     *         var buildVersion = new BuildVersion();
     *         buildVersion.setId("1234"); // Build Id
     *         buildVersion.setName("Demo-Pipeline-CI"); // Build pipeline name
     *
     *         artifacts.setAlias("_Demo-Pipeline-CI"); // Artifact alias name; This can be retrieved from release pipeline.
     *         artifacts.setInstanceReference(buildVersion);
     *
     *         releaseMetadata.setDefinitionId(2); // Release pipeline Id.
     *         releaseMetadata.setDescription("Sample release");
     *         releaseMetadata.setArtifacts(List.of(artifacts));
     *         releaseMetadata.setIsDraft(false);
     *         releaseMetadata.setReason(ReleaseReason.NONE);
     * }</pre>
     *
     * @param releaseStartMetadata Release start metadata to create the release.
     * @return Release object {@link Release}
     * @throws AzDException Default Api exception handler.
     */
    public Release create(ReleaseStartMetadata releaseStartMetadata) throws AzDException {
        return builder()
                .POST(releaseStartMetadata)
                .build()
                .execute(Release.class);
    }

    /**
     * Delete a Release
     *
     * @param releaseId pass the release id
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(int releaseId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("releaseId", releaseId)
                .build()
                .executePrimitive();
    }

    /**
     * Get a Release
     *
     * @param releaseId pass the release id
     * @return Release {@link Release}
     * @throws AzDException Default Api Exception handler.
     */
    public Release get(int releaseId) throws AzDException {
        return builder()
                .serviceEndpoint("releaseId", releaseId)
                .build()
                .execute(Release.class);
    }

    /**
     * Get a Release
     *
     * @param releaseId            pass the release id
     * @param requestConfiguration Represents the query parameters.
     * @return Release {@link Release}
     * @throws AzDException Default Api Exception handler.
     */
    public Release get(int releaseId, Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("releaseId", releaseId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(Release.class);
    }

    /**
     * Get release for a given revision number.
     *
     * @param releaseId                  Id of the release.
     * @param definitionSnapshotRevision Definition snapshot revision number.
     * @return Release revision.
     * @throws AzDException Default Api Exception handler.
     */
    public String getRevision(int releaseId, int definitionSnapshotRevision) throws AzDException {
        return builder()
                .serviceEndpoint("releaseId", releaseId)
                .query("definitionSnapshotRevision", definitionSnapshotRevision)
                .header(CustomHeader.TEXT_CONTENT)
                .build()
                .executeString();
    }

    /**
     * Get a list of releases
     *
     * @return Releases {@link Releases}
     * @throws AzDException Default Api Exception handler.
     */
    public Releases list() throws AzDException {
        return builder()
                .build()
                .execute(Releases.class);
    }

    /**
     * Get a list of releases
     *
     * @param requestConfiguration Represents the query parameters
     * @return Releases {@link Releases}
     * @throws AzDException Default Api Exception handler.
     */
    public Releases list(Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(Releases.class);
    }

    /**
     * Update a complete release object.
     *
     * @param releaseId Id of the release to update.
     * @param release   Release object to update
     * @return a release object {@link Release}
     * @throws AzDException Default Api Exception handler.
     */
    public Release update(int releaseId, Release release) throws AzDException {
        return builder()
                .PUT(release)
                .serviceEndpoint("releaseId", releaseId)
                .build()
                .execute(Release.class);
    }

    /**
     * Update a complete release object.
     *
     * @param releaseId             Id of the release to update.
     * @param releaseUpdateMetadata Release metadata object to update
     * @return a release object {@link Release}
     * @throws AzDException Default Api Exception handler.
     */
    public Release updateResource(int releaseId, ReleaseUpdateMetadata releaseUpdateMetadata) throws AzDException {
        return builder()
                .PATCH(releaseUpdateMetadata)
                .serviceEndpoint("releaseId", releaseId)
                .build()
                .execute(Release.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * A property that should be expanded in the release.
         */
        @QueryParameter(name = "$expand")
        public SingleReleaseExpands expand;
        /**
         * Number of release gate records to get. Default is 5.
         */
        @QueryParameter(name = "$topGateRecords")
        public Integer topGateRecords;
        /**
         * A filter which would allow fetching approval steps selectively based on whether it is automated, or manual.
         * This would also decide whether we should fetch pre and post approval snapshots. Assumes All by default
         */
        @QueryParameter(name = "approvalFilters")
        public ApprovalFilters approvalFilters;
        /**
         * A comma-delimited list of extended properties to be retrieved. If set,
         * the returned Release will contain values for the specified property Ids (if they exist).
         * If not set, properties will not be included.
         */
        @QueryParameter(name = "propertyFilters")
        public String propertyFilters;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

    /**
     * Represents the query parameters.
     */
    public static class ListQueryParameters {
        /**
         * The property that should be expanded in the list of releases.
         */
        @QueryParameter(name = "$expand")
        public ReleaseExpands expand;
        /**
         * Number of releases to get. Default is 50.
         */
        @QueryParameter(name = "$top")
        public Integer top;
        /**
         * Releases with given artifactTypeId will be returned. Values can be Build, Jenkins,
         * GitHub, Nuget, Team Build (external), ExternalTFSBuild, Git, TFVC, ExternalTfsXamlBuild.
         */
        @QueryParameter(name = "artifactTypeId")
        public String artifactTypeId;
        /**
         * Releases with given artifactVersionId will be returned. E.g. in case of Build artifactType, it is buildId.
         */
        @QueryParameter(name = "artifactVersionId")
        public String artifactVersionId;
        /**
         * Gets the releases after the continuation token provided.
         */
        @QueryParameter(name = "continuationToken")
        public Integer continuationToken;
        /**
         * Releases created by this user.
         */
        @QueryParameter(name = "createdBy")
        public String createdBy;
        /**
         * Release definition environment id.
         */
        @QueryParameter(name = "definitionEnvironmentId")
        public Integer definitionEnvironmentId;
        /**
         * Releases from this release definition Id.
         */
        @QueryParameter(name = "definitionId")
        public Integer definitionId;
        /**
         * Environment status filter.
         */
        @QueryParameter(name = "environmentStatusFilter")
        public Integer environmentStatusFilter;
        /**
         * Gets the soft deleted releases, if true.
         */
        @QueryParameter(name = "isDeleted")
        public Boolean isDeleted;
        /**
         * Releases that were created before this time.
         */
        @QueryParameter(name = "maxCreatedTime;")
        public String maxCreatedTime;
        /**
         * Releases that were created after this time.
         */
        @QueryParameter(name = "minCreatedTime;")
        public String minCreatedTime;
        /**
         * Releases under this folder path will be returned
         */
        @QueryParameter(name = "path")
        public String path;
        /**
         * A comma-delimited list of extended properties to be retrieved. If set, the returned Releases will contain
         * values for the specified property Ids (if they exist). If not set, properties will not be included.
         * Note that this will not filter out any Release from results irrespective of whether it has property set or not.
         */
        @QueryParameter(name = "propertyFilters")
        public String propertyFilters;
        /**
         * Gets the results in the defined order of created date for releases. Default is descending.
         */
        @QueryParameter(name = "queryOrder")
        public ReleaseQueryOrder queryOrder;
        /**
         * A comma-delimited list of releases Ids. Only releases with these Ids will be returned.
         */
        @QueryParameter(name = "releaseIdFilter")
        public String releaseIdFilter;
        /**
         * Releases with names containing searchText.
         */
        @QueryParameter(name = "searchText")
        public String searchText;
        /**
         * Releases with given sourceBranchFilter will be returned.
         */
        @QueryParameter(name = "sourceBranchFilter")
        public String sourceBranchFilter;
        /**
         * Unique identifier of the artifact used. e.g. For build it would be {projectGuid}:{BuildDefinitionId},
         * for Jenkins it would be {JenkinsConnectionId}:{JenkinsDefinitionId},
         * for TfsOnPrem it would be {TfsOnPremConnectionId}:{ProjectName}:{TfsOnPremDefinitionId}.
         * For third-party artifacts e.g. TeamCity, BitBucket you may refer 'uniqueSourceIdentifier'
         * inside vss-extension.json <a href="https://github.com/Microsoft/vsts-rm-extensions/blob/master/Extensions">Extensions</a>.
         */
        @QueryParameter(name = "sourceId")
        public String sourceId;
        /**
         * Releases that have this status.
         */
        @QueryParameter(name = "statusFilter")
        public ReleaseStatus statusFilter;
        /**
         * A comma-delimited list of tags. Only releases with these tags will be returned.
         */
        @QueryParameter(name = "tagFilter")
        public String tagFilter;

    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class ListRequestConfiguration {
        public ListQueryParameters queryParameters = new ListQueryParameters();
    }
}
