package org.azd.release;

import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.ReleaseDetails;
import org.azd.release.types.Release;
import org.azd.release.types.ReleaseEnvironment;
import org.azd.release.types.Releases;
import org.azd.utils.AzDDefaultParameters;
import org.azd.utils.ResourceId;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import static org.azd.utils.Client.request;

public class ReleaseApi implements ReleaseDetails {
    /***
     * Instance of AzDDefaultParameters
     */
    private final AzDDefaultParameters DEFAULT_PARAMETERS;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "release/releases";

    /***
     * Instantiate the class with instance of AzDDefaultParameters
     * @param defaultParameters instance of AzDDefaultParameters
     */
    public ReleaseApi(AzDDefaultParameters defaultParameters) { this.DEFAULT_PARAMETERS = defaultParameters; }

    @Override
    public Release createRelease(int releaseDefinitionId, String description, String artifactAlias,
                                 String artifactId, String artifactName,
                                 boolean isDraft, String reason) throws DefaultParametersException, AzDException {

        var artifacts = new LinkedHashMap<String, Object>(){{
            put("alias", artifactAlias);
            put("instanceReference", new LinkedHashMap<String, Object>(){{
                put("id", artifactId);
                put("name", artifactName);
            }});
        }};

        var h = new LinkedHashMap<String, Object>(){{
            put("definitionId", Integer.toString(releaseDefinitionId));
            put("description", description);
            put("artifacts", List.of(artifacts));
            put("isDraft", isDraft);
            put("reason", reason);
            put("manualEnvironments", null);

        }};
        String r = request(RequestMethod.POST, DEFAULT_PARAMETERS, ResourceId.RELEASE, DEFAULT_PARAMETERS.getProject(),
                AREA, null, null, ReleaseVersion.VERSION, null, h);

        return MAPPER.mapJsonResponse(r, Release.class);
    }

    @Override
    public Release getRelease(int releaseId) throws DefaultParametersException, AzDException {
        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.RELEASE, DEFAULT_PARAMETERS.getProject(),
                AREA, Integer.toString(releaseId), null, ReleaseVersion.VERSION, null, null);

        return MAPPER.mapJsonResponse(r, Release.class);
    }

    @Override
    public Release getRelease(int releaseId, SingleReleaseExpands expand) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("$expand", expand.toString().toLowerCase());
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.RELEASE, DEFAULT_PARAMETERS.getProject(),
                AREA, Integer.toString(releaseId), null, ReleaseVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, Release.class);
    }

    @Override
    public Release getRelease(int releaseId, SingleReleaseExpands expand,
                              ReleaseApprovalFilters approvalFilters, String[] propertyFilters,
                              int topGateRecords) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("approvalFilters", approvalFilters);
            put("propertyFilters", String.join(",", propertyFilters));
            put("$expand", expand.toString().toLowerCase());
            put("$topGateRecords", topGateRecords);
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.RELEASE, DEFAULT_PARAMETERS.getProject(),
                AREA, Integer.toString(releaseId), null, ReleaseVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, Release.class);
    }

    @Override
    public ReleaseEnvironment getReleaseEnvironment(int releaseId, int environmentId) throws DefaultParametersException, AzDException {
        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.RELEASE, DEFAULT_PARAMETERS.getProject(),
                AREA, Integer.toString(releaseId), "environments/" + environmentId,
                ReleaseVersion.RELEASE_ENVIRONMENT, null, null);

        return MAPPER.mapJsonResponse(r, ReleaseEnvironment.class);
    }

    @Override
    public ReleaseEnvironment getReleaseEnvironment(int releaseId, int environmentId,
                                                    SingleReleaseExpands expand) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("$expand", expand.toString().toLowerCase());
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.RELEASE, DEFAULT_PARAMETERS.getProject(),
                AREA, Integer.toString(releaseId), "environments/" + environmentId,
                ReleaseVersion.RELEASE_ENVIRONMENT, q, null);

        return MAPPER.mapJsonResponse(r, ReleaseEnvironment.class);
    }

    @Override
    public Releases getReleases() throws DefaultParametersException, AzDException {
        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.RELEASE, DEFAULT_PARAMETERS.getProject(),
                AREA, null, null, ReleaseVersion.VERSION, null, null);

        return MAPPER.mapJsonResponse(r, Releases.class);
    }

    @Override
    public Releases getReleases(ReleaseExpands expand) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("$expand", expand.toString().toLowerCase());
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.RELEASE, DEFAULT_PARAMETERS.getProject(),
                AREA, null, null, ReleaseVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, Releases.class);
    }

    @Override
    public Releases getReleases(int definitionId) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("definitionId", definitionId);
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.RELEASE, DEFAULT_PARAMETERS.getProject(),
                AREA, null, null, ReleaseVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, Releases.class);
    }

    @Override
    public Releases getReleases(ReleaseExpands expand, int top) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("$expand", expand.toString().toLowerCase());
            put("$top", top);
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.RELEASE, DEFAULT_PARAMETERS.getProject(),
                AREA, null, null, ReleaseVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, Releases.class);
    }

    @Override
    public Releases getReleases(String[] releaseIdFilter) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("releaseIdFilter", String.join(",", releaseIdFilter));
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.RELEASE, DEFAULT_PARAMETERS.getProject(),
                AREA, null, null, ReleaseVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, Releases.class);
    }

    @Override
    public Releases getReleases(ReleaseExpands expand, int top, String artifactTypeId, String artifactVersionId,
                                int continuationToken, String createdBy, int definitionEnvironmentId, int definitionId,
                                int environmentStatusFilter, boolean isDeleted, String maxCreatedTime, String minCreatedTime,
                                String path, String[] propertyFilters, ReleaseQueryOrder queryOrder, String[] releaseIdFilter,
                                String searchText, String sourceBranchFilter, String sourceId, ReleaseStatus statusFilter,
                                String[] tagFilter) throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("definitionId", definitionId);
            put("definitionEnvironmentId", definitionEnvironmentId);
            put("searchText", searchText);
            put("createdBy", createdBy);
            put("statusFilter", statusFilter);
            put("environmentStatusFilter", environmentStatusFilter);
            put("minCreatedTime", minCreatedTime);
            put("maxCreatedTime", maxCreatedTime);
            put("queryOrder", queryOrder.toString().toLowerCase());
            put("$top", top);
            put("continuationToken", continuationToken);
            put("artifactTypeId", artifactTypeId);
            put("sourceId", sourceId);
            put("artifactVersionId", artifactVersionId);
            put("sourceBranchFilter", sourceBranchFilter);
            put("isDeleted", isDeleted);
            put("$expand", expand.toString().toLowerCase());
            put("tagFilter", String.join(",", tagFilter));
            put("propertyFilters", String.join(",", propertyFilters));
            put("path", path);
            put("releaseIdFilter", String.join(",", releaseIdFilter));
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.RELEASE, DEFAULT_PARAMETERS.getProject(),
                AREA, null, null, ReleaseVersion.VERSION, q, null);

        return MAPPER.mapJsonResponse(r, Releases.class);
    }
}
