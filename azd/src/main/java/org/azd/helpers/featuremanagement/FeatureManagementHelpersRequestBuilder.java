package org.azd.helpers.featuremanagement;

import org.azd.authentication.AccessTokenCredential;
import org.azd.core.types.ProjectFeature;
import org.azd.enums.ContributedFeatureEnabledValue;
import org.azd.enums.FeatureManagement;
import org.azd.enums.FeatureManagementScopeName;
import org.azd.enums.FeatureManagementUserScope;
import org.azd.exceptions.AzDException;
import org.azd.featuremanagement.FeatureManagementRequestBuilder;
import org.azd.featuremanagement.types.ContributedFeatureSettingScope;
import org.azd.featuremanagement.types.ContributedFeatureState;

import java.util.Optional;

/**
 * Helper request builder that combines multiple Apis to create logical helper methods for ease of use.
 */
public class FeatureManagementHelpersRequestBuilder extends FeatureManagementRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public FeatureManagementHelpersRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * Call un-published API feature to fetch project service feature state.
     * See {@link FeatureManagement} for current list of features.
     * Besides an 'enabled' and 'disabled' state, there is also an undefined state, hence the Optional return wrapper
     *
     * @param projectId project identifier
     * @param feature   FeatureManagement enum type for which to return state
     * @return Optional wrapped boolean, empty if state is undefined
     * @throws AzDException Default Api Exception handler
     */
    public Optional<Boolean> getFeatureState(String projectId, FeatureManagement feature) throws AzDException {
        var state = stateScope().get(feature, FeatureManagementUserScope.HOST, FeatureManagementScopeName.PROJECT, projectId);
        if (state == null) return Optional.empty();
        if (state.getState().equals(ContributedFeatureEnabledValue.ENABLED))
            return Optional.of(Boolean.TRUE);
        else if (state.getState().equals(ContributedFeatureEnabledValue.DISABLED))
            return Optional.of(Boolean.FALSE);
        return Optional.empty();
    }

    /**
     * Set project feature state for project service
     * See {@link FeatureManagement} for list of features
     *
     * @param projectId project identifier
     * @param feature   enum value for feature to enable or disable
     * @param state     enable or disable feature
     * @return object containing feature id and state
     * @throws AzDException Default Api Exception handler
     */
    public ProjectFeature featureToggle(String projectId, FeatureManagement feature, boolean state) throws AzDException {

        var featureState = new ContributedFeatureState();

        var scope = new ContributedFeatureSettingScope();
        scope.setSettingScope(FeatureManagementScopeName.PROJECT.getScopeName());
        scope.setUserScoped(false);

        featureState.setFeatureId(feature.getFeatureId());
        featureState.setScope(scope);
        featureState.setState(state ? ContributedFeatureEnabledValue.ENABLED : ContributedFeatureEnabledValue.DISABLED);

        var resp = stateScope().set(featureState, feature, FeatureManagementUserScope.HOST, FeatureManagementScopeName.PROJECT, projectId);

        var projFeature = new ProjectFeature();
        var projScope = new ProjectFeature.Scope();
        projScope.setSettingScope(resp.getScope().getSettingScope());
        projScope.setUserScoped(resp.getScope().isUserScoped());

        projFeature.setFeatureId(resp.getFeatureId());
        projFeature.setScope(projScope);
        projFeature.setState(resp.getState().getFeatureValue());

        return projFeature;
    }
}
