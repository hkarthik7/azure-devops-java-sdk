package org.azd.release;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.release.approvals.ApprovalsRequestBuilder;
import org.azd.release.definitions.DefinitionsRequestBuilder;
import org.azd.release.deployments.DeploymentsRequestBuilder;
import org.azd.release.folders.ReleaseFoldersRequestBuilder;
import org.azd.release.gates.GatesRequestBuilder;
import org.azd.release.manualinterventions.ManualInterventionsRequestBuilder;
import org.azd.release.releases.ReleasesRequestBuilder;

/**
 * Provides functionality to work with Release Api.
 */
public class ReleaseBaseRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ReleaseBaseRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Release approvals API.
     *
     * @return ApprovalsRequestBuilder {@link ApprovalsRequestBuilder}
     */
    public ApprovalsRequestBuilder approvals() {
        return new ApprovalsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Release definitions API.
     *
     * @return DefinitionsRequestBuilder {@link DefinitionsRequestBuilder}
     */
    public DefinitionsRequestBuilder definitions() {
        return new DefinitionsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Release deployments API.
     *
     * @return DeploymentsRequestBuilder {@link DeploymentsRequestBuilder}
     */
    public DeploymentsRequestBuilder deployments() {
        return new DeploymentsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Release folders API.
     *
     * @return ReleaseFoldersRequestBuilder {@link ReleaseFoldersRequestBuilder}
     */
    public ReleaseFoldersRequestBuilder folders() {
        return new ReleaseFoldersRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Release gates API.
     *
     * @return GatesRequestBuilder {@link GatesRequestBuilder}
     */
    public GatesRequestBuilder gates() {
        return new GatesRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Release manual intervention API.
     *
     * @return ManualInterventionsRequestBuilder {@link ManualInterventionsRequestBuilder}
     */
    public ManualInterventionsRequestBuilder manualInterventions() {
        return new ManualInterventionsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Release releases API.
     *
     * @return ReleasesRequestBuilder {@link ReleasesRequestBuilder}
     */
    public ReleasesRequestBuilder releases() {
        return new ReleasesRequestBuilder(organizationUrl, accessTokenCredential);
    }

}
