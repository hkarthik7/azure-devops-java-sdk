package org.azd.work;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.work.capacities.CapacitiesRequestBuilder;
import org.azd.work.iterations.IterationsRequestBuilder;

/**
 * Provides functionality to work with Work Api.
 */
public class WorkRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public WorkRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Work capacities Api.
     *
     * @return CapacitiesRequestBuilder {@link CapacitiesRequestBuilder}
     */
    public CapacitiesRequestBuilder capacities() {
        return new CapacitiesRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Work iterations Api.
     *
     * @return IterationsRequestBuilder {@link IterationsRequestBuilder}
     */
    public IterationsRequestBuilder iterations() {
        return new IterationsRequestBuilder(organizationUrl, accessTokenCredential);
    }
}
