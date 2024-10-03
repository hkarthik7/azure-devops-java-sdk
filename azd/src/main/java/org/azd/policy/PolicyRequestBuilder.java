package org.azd.policy;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.policy.configurations.ConfigurationsRequestBuilder;
import org.azd.policy.evaluations.EvaluationsRequestBuilder;
import org.azd.policy.policytypes.TypesRequestBuilder;
import org.azd.policy.revisions.RevisionsRequestBuilder;

/**
 * Provides functionality to work with Policy Api.
 */
public class PolicyRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public PolicyRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Policy configurations Api.
     *
     * @return Configurations request builder. {@link ConfigurationsRequestBuilder}
     */
    public ConfigurationsRequestBuilder configurations() {
        return new ConfigurationsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Policy evaluations Api.
     *
     * @return Evaluations request builder. {@link EvaluationsRequestBuilder}
     */
    public EvaluationsRequestBuilder evaluations() {
        return new EvaluationsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Policy revisions Api.
     *
     * @return Revisions request builder. {@link RevisionsRequestBuilder}
     */
    public RevisionsRequestBuilder revisions() {
        return new RevisionsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Policy Types Api.
     *
     * @return Types request builder. {@link TypesRequestBuilder}
     */
    public TypesRequestBuilder types() {
        return new TypesRequestBuilder(organizationUrl, accessTokenCredential);
    }

}
