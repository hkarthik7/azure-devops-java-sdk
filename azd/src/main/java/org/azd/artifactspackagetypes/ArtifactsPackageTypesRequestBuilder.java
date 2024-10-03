package org.azd.artifactspackagetypes;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.artifactspackagetypes.maven.MavenRequestBuilder;
import org.azd.artifactspackagetypes.universal.UniversalRequestBuilder;
import org.azd.authentication.AccessTokenCredential;

import java.util.function.Predicate;

/**
 * Provides functionality to work with Azure DevOps Graph Api.
 */
public class ArtifactsPackageTypesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ArtifactsPackageTypesRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Maven Api.
     *
     * @return MavenRequestBuilder {@link MavenRequestBuilder}
     */
    public MavenRequestBuilder maven() {
        return new MavenRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Maven Api and exclude/include the project for request.
     *
     * @return MavenRequestBuilder {@link MavenRequestBuilder}
     */
    public MavenRequestBuilder maven(Predicate<ProjectExcludeParameter> configuration) {
        if (configuration != null) {
            final var config = new ProjectExcludeParameter();
            if (configuration.test(config)) accessTokenCredential.setProjectName(null);
        }
        return new MavenRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Universal aka U_Pack Api.
     *
     * @return UniversalRequestBuilder {@link UniversalRequestBuilder}
     */
    public UniversalRequestBuilder universal() {
        return new UniversalRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Universal aka U_Pack Api.
     *
     * @return UniversalRequestBuilder {@link UniversalRequestBuilder}
     */
    public UniversalRequestBuilder universal(Predicate<ProjectExcludeParameter> configuration) {
        if (configuration != null) {
            final var config = new ProjectExcludeParameter();
            if (configuration.test(config)) accessTokenCredential.setProjectName(null);
        }
        return new UniversalRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * True to show information for deleted packages.
     */
    public static class DeletedPackagePredicate {
        /**
         * True to show information for deleted packages.
         */
        public boolean showDeleted = true;
    }
}
