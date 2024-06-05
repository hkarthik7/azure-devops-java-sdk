package org.azd.helpers;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ResourceId;
import org.azd.helpers.artifactspackagetypes.ArtifactsPackageTypesHelpersRequestBuilder;
import org.azd.helpers.build.BuildHelpersRequestBuilder;
import org.azd.helpers.featuremanagement.FeatureManagementHelpersRequestBuilder;
import org.azd.helpers.git.GitHelpersRequestBuilder;
import org.azd.helpers.graph.GraphHelpersRequestBuilder;
import org.azd.helpers.release.ReleaseHelpersRequestBuilder;
import org.azd.helpers.serviceendpoint.ServiceEndpointHelpersRequestBuilder;
import org.azd.helpers.workitemtracking.WorkItemTrackingHelpersRequestBuilder;
import org.azd.locations.LocationsBaseRequestBuilder;

import java.util.function.Predicate;

/**
 * Container class that includes helper methods. 
 */
public class HelpersRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization url.
     * @param accessTokenCredential Access token credential object.
     */
    public HelpersRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * Constructs build helpers request builder instance.
     *
     * @return ArtifactsPackageTypesHelpersRequestBuilder {@link ArtifactsPackageTypesHelpersRequestBuilder}
     */
    public ArtifactsPackageTypesHelpersRequestBuilder artifactsPackageTypes() {
        return new ArtifactsPackageTypesHelpersRequestBuilder(getLocationUrl(ResourceId.MAVEN), accessTokenCredential);
    }

    /**
     * Constructs build helpers request builder instance.
     *
     * @return ArtifactsPackageTypesHelpersRequestBuilder {@link ArtifactsPackageTypesHelpersRequestBuilder}
     */
    public ArtifactsPackageTypesHelpersRequestBuilder artifactsPackageTypes(Predicate<ProjectExcludeParameter> configuration) {
        if (configuration != null) {
            final var config = new ProjectExcludeParameter();
            if (configuration.test(config)) accessTokenCredential.setProjectName(null);
        }
        return new ArtifactsPackageTypesHelpersRequestBuilder(getLocationUrl(ResourceId.MAVEN), accessTokenCredential);
    }

    /**
     * Constructs build helpers request builder instance.
     *
     * @return BuildHelpersRequestBuilder {@link BuildHelpersRequestBuilder}
     */
    public BuildHelpersRequestBuilder build() {
        return new BuildHelpersRequestBuilder(getLocationUrl(ResourceId.BUILD), accessTokenCredential);
    }

    /**
     * Constructs feature management helpers request builder instance.
     *
     * @return FeatureManagementHelpersRequestBuilder {@link FeatureManagementHelpersRequestBuilder}
     */
    public FeatureManagementHelpersRequestBuilder featureManagement() {
        return new FeatureManagementHelpersRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Constructs git helpers request builder instance.
     *
     * @return GitHelpersRequestBuilder {@link GitHelpersRequestBuilder}
     */
    public GitHelpersRequestBuilder git() {
        return new GitHelpersRequestBuilder(getLocationUrl(ResourceId.GIT), accessTokenCredential);
    }

    /**
     * Constructs graph helpers request builder instance.
     *
     * @return GraphHelpersRequestBuilder {@link GraphHelpersRequestBuilder}
     */
    public GraphHelpersRequestBuilder graph() {
        return new GraphHelpersRequestBuilder(getLocationUrl(ResourceId.GRAPH), accessTokenCredential);
    }

    /**
     * Constructs graph helpers request builder instance.
     *
     * @return ReleaseHelpersRequestBuilder {@link ReleaseHelpersRequestBuilder}
     */
    public ReleaseHelpersRequestBuilder release() {
        return new ReleaseHelpersRequestBuilder(getLocationUrl(ResourceId.RELEASE), accessTokenCredential);
    }


    /**
     * Constructs service endpoint helpers request builder instance.
     *
     * @return ServiceEndpointHelpersRequestBuilder {@link ServiceEndpointHelpersRequestBuilder}
     */
    public ServiceEndpointHelpersRequestBuilder serviceEndpoint() {
        return new ServiceEndpointHelpersRequestBuilder(getLocationUrl(ResourceId.SERVICE_ENDPOINT), accessTokenCredential);
    }

    /**
     * Constructs work item tracking helpers request builder instance.
     *
     * @return WorkItemTrackingHelpersRequestBuilder {@link WorkItemTrackingHelpersRequestBuilder}
     */
    public WorkItemTrackingHelpersRequestBuilder workItemTracking() {
        return new WorkItemTrackingHelpersRequestBuilder(getLocationUrl(ResourceId.WIT), accessTokenCredential);
    }

    /**
     * Helper method to create the location url based on resource id.
     *
     * @param resourceId Pass the resource id. {@link ResourceId}
     * @return Location url.
     */
    private String getLocationUrl(String resourceId) {
        var builder = new LocationsBaseRequestBuilder(organizationUrl, accessTokenCredential);
        return builder.getUrl(resourceId);
    }
}
