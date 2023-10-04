package org.azd.core.projects;

import org.azd.common.ApiVersion;
import org.azd.core.types.ProjectFeature;
import org.azd.enums.FeatureManagement;
import org.azd.exceptions.AzDException;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class ProjectsFeatureManagementRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates the request builder with required values.
     * @param accessTokenCredential Authentication type {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public ProjectsFeatureManagementRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "FeatureManagement/FeatureStates/host/project", ApiVersion.FEATURE_MANAGEMENT);
    }

    /***
     * Call un-published API feature to fetch project service feature state.
     * See {@link FeatureManagement} for current list of features.
     * Besides an 'enabled' and 'disabled' state, there is also an undefined state, hence the Optional return wrapper
     * @param projectId project identifier
     * @param feature FeatureManagement enum type for which to return state
     * @return Optional wrapped boolean, empty if state is undefined
     * @throws AzDException Default Api Exception handler
     */
    public CompletableFuture<Optional<Boolean>> getAsync(String projectId, FeatureManagement feature) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + projectId + "/" + feature.getFeatureId();

        return requestAdapter.sendAsync(reqInfo, ProjectFeature.class).thenApplyAsync(ProjectFeature::getStateAsBoolean);
    }

    /***
     * Set project feature state for project service
     * See {@link FeatureManagement} for list of features
     *
     * @param projectId project identifier
     * @param feature enum value for feature to enable or disable
     * @param state enable or disable feature
     * @return object containing feature id and state
     * @throws AzDException Default Api Exception handler
     */
    public CompletableFuture<ProjectFeature> toggleAsync(String projectId, FeatureManagement feature, boolean state) throws AzDException {
        LinkedHashMap<String, Object> body = new LinkedHashMap<>() {{
            put("featureId", feature.getFeatureId());
            put("scope", new LinkedHashMap<>() {{
                put("settingScope", "project");
                put("userScoped", false);
            }});
            put("state", state ? 1 : 0);
        }};

        var reqInfo = toPatchRequestInformation(body);
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + projectId + "/" + feature.getFeatureId();

        return requestAdapter.sendAsync(reqInfo, ProjectFeature.class);
    }

    /***
     * Call un-published API feature to fetch project service feature state.
     * See {@link FeatureManagement} for current list of features.
     * Besides an 'enabled' and 'disabled' state, there is also an undefined state, hence the Optional return wrapper
     * @param projectId project identifier
     * @param feature FeatureManagement enum type for which to return state
     * @return Optional wrapped boolean, empty if state is undefined
     * @throws AzDException Default Api Exception handler
     */
    public Optional<Boolean> get(String projectId, FeatureManagement feature) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + projectId + "/" + feature.getFeatureId();

        return requestAdapter.send(reqInfo, ProjectFeature.class).getStateAsBoolean();
    }

    /***
     * Set project feature state for project service
     * See {@link FeatureManagement} for list of features
     *
     * @param projectId project identifier
     * @param feature enum value for feature to enable or disable
     * @param state enable or disable feature
     * @return object containing feature id and state
     * @throws AzDException Default Api Exception handler
     */
    public ProjectFeature toggle(String projectId, FeatureManagement feature, boolean state) throws AzDException {
        LinkedHashMap<String, Object> body = new LinkedHashMap<>() {{
            put("featureId", feature.getFeatureId());
            put("scope", new LinkedHashMap<>() {{
                put("settingScope", "project");
                put("userScoped", false);
            }});
            put("state", state ? 1 : 0);
        }};

        var reqInfo = toPatchRequestInformation(body);
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + projectId + "/" + feature.getFeatureId();

        return requestAdapter.send(reqInfo, ProjectFeature.class);
    }
}
