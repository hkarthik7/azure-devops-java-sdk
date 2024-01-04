package org.azd.work;

import org.azd.common.ApiVersion;
import org.azd.connection.Connection;
import org.azd.enums.CustomHeader;
import org.azd.enums.IterationsTimeFrame;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.WorkDetails;
import org.azd.utils.AzDAsyncApi;
import org.azd.work.types.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.azd.helpers.URLHelper.encodeSpace;
import static org.azd.helpers.URLHelper.encodeSpecialWithSpace;
import static org.azd.utils.RestClient.send;

/***
 * Work class to manage work API
 */
public class WorkApi extends AzDAsyncApi<WorkApi> implements WorkDetails {
    /***
     * Connection object
     */
    private final Connection CONNECTION;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "work";
    private final String WORK = "1d4f49f9-02b9-4e26-b826-2cdb6195f2a9";

    /***
     * Pass the connection object to work with Work Api
     * @param connection Connection object
     */
    public WorkApi(Connection connection) {
        this.CONNECTION = connection;
    }

    /***
     * Get a team's iterations
     * @param teamName Team ID or team name
     * @return {@link TeamSettingsIterations}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public TeamSettingsIterations getTeamSettingsIterations(String teamName) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, WORK,
                (CONNECTION.getProject() + "/" + encodeSpace(teamName)),
                AREA, null, "teamsettings/iterations", ApiVersion.WORK, null, null, null);

        return MAPPER.mapJsonResponse(r, TeamSettingsIterations.class);
    }

    /***
     * Get a team's iterations using timeframe filter
     * @param teamName Team ID or team name
     * @param timeFrame A filter for which iterations are returned based on relative time.
     * Only 'Current' is supported currently. {@link IterationsTimeFrame}
     * @return {@link TeamSettingsIterations}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public TeamSettingsIterations getTeamSettingsIterations(String teamName, IterationsTimeFrame timeFrame) throws AzDException {

        var q = new HashMap<String, Object>() {{
            put("$timeframe", timeFrame.toString().toLowerCase());
        }};

        String r = send(RequestMethod.GET, CONNECTION, WORK,
                (CONNECTION.getProject() + "/" + encodeSpace(teamName)),
                AREA, null, "teamsettings/iterations", ApiVersion.WORK, q, null, null);

        return MAPPER.mapJsonResponse(r, TeamSettingsIterations.class);
    }

    /***
     * Get work items for iteration
     * @param teamName Team ID or team name
     * @param iterationId ID of the iteration
     * @return {@link TeamSettingsIterations}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public IterationWorkItems getTeamIterationWorkItems(String teamName, String iterationId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, WORK,
                (CONNECTION.getProject() + "/" + encodeSpace(teamName)),
                AREA + "/teamsettings/iterations", iterationId, "workitems", ApiVersion.WORK, null, null, null);

        return MAPPER.mapJsonResponse(r, IterationWorkItems.class);
    }

    /***
     * Get team's iteration by iterationId
     * @param teamName ID of the iteration
     * @param iterationId Team ID or team name
     * @return {@link TeamSettingsIterations}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public TeamSettingsIteration getTeamSettingsIteration(String teamName, String iterationId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, WORK,
                (CONNECTION.getProject() + "/" + encodeSpace(teamName)),
                AREA + "/teamsettings/iterations", iterationId, null, ApiVersion.WORK, null, null, null);

        return MAPPER.mapJsonResponse(r, TeamSettingsIteration.class);
    }

    /***
     * Delete a team's iteration by iterationId
     * @param teamName Team ID or team name
     * @param iterationId ID of the iteration
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deleteTeamSettingsIteration(String teamName, String iterationId) throws AzDException {
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, WORK,
                    (CONNECTION.getProject() + "/" + encodeSpace(teamName)),
                    AREA + "/teamsettings/iterations", iterationId, null, ApiVersion.WORK, null, null, null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
        return null;
    }

    /**
     * Get a team's capacity including total capacity and days off
     *
     * @param iterationId Pass the iteration id.
     * @param teamName    The name of the Azure DevOps organization.
     * @return TeamCapacity Object {@link TeamCapacity}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public TeamCapacity getTotalTeamCapacity(String iterationId, String teamName) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, WORK,
                (CONNECTION.getProject() + "/" + encodeSpecialWithSpace(teamName)),
                AREA + "/teamsettings/iterations", iterationId, "capacities", ApiVersion.WORK_CAPACITY,
                null, null, null);

        return MAPPER.mapJsonResponse(r, TeamCapacity.class);
    }

    /**
     * Get a team member's capacity
     *
     * @param iterationId  Pass the team iteration id.
     * @param teamMemberId Id of the team member.
     * @param teamName     Name of Azure DevOps team.
     * @return TeamMemberCapacityIdentityRef Object {@link TeamMemberCapacityIdentityRef}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public TeamMemberCapacityIdentityRef getTeamMemberCapacity(String iterationId, String teamName,
                                                               String teamMemberId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, WORK,
                (CONNECTION.getProject() + "/" + encodeSpecialWithSpace(teamName)),
                AREA + "/teamsettings/iterations", iterationId, "capacities/" + teamMemberId, ApiVersion.WORK_CAPACITY,
                null, null, null);

        return MAPPER.mapJsonResponse(r, TeamMemberCapacityIdentityRef.class);
    }

    /**
     * Replace a team's capacity
     *
     * @param iterationId         Pass the team iteration id.
     * @param teamName            Name or id of the Azure DevOps team.
     * @param teamMembersCapacity A list of team members capacity to update.
     * @return TeamMemberCapacityIdentityRef Object {@link TeamMemberCapacityIdentityRef}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public TeamMemberCapacityIdentityRefs updateTeamMembersCapacity(String iterationId, String teamName,
                                                                    List<TeamMemberCapacityIdentityRef> teamMembersCapacity) throws AzDException {
        String r = send(RequestMethod.PUT, CONNECTION, WORK,
                (CONNECTION.getProject() + "/" + encodeSpecialWithSpace(teamName)),
                AREA + "/teamsettings/iterations", iterationId, "capacities", ApiVersion.WORK_CAPACITY,
                null, teamMembersCapacity, CustomHeader.JSON_CONTENT_TYPE);
        return MAPPER.mapJsonResponse(r, TeamMemberCapacityIdentityRefs.class);
    }

    /**
     * Update a team member's capacity
     *
     * @param iterationId        Pass the team iteration id.
     * @param teamMemberId       Id of the team member.
     * @param teamName           Name of id of the Azure DevOps team.
     * @param teamMemberCapacity Team member capacity object to update. You can only pass the list of activities and optionally days off.
     * @return TeamMemberCapacityIdentityRef Object {@link TeamMemberCapacityIdentityRef}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public TeamMemberCapacityIdentityRef updateTeamMemberCapacity(String iterationId, String teamName, String teamMemberId,
                                                                  TeamMemberCapacityIdentityRef teamMemberCapacity) throws AzDException {
        var body = new HashMap<String, Object>() {{
            put("activities", teamMemberCapacity.getActivities());
            put("daysOff", teamMemberCapacity.getDaysOff());
        }};

        String r = send(RequestMethod.PATCH, CONNECTION, WORK,
                (CONNECTION.getProject() + "/" + encodeSpecialWithSpace(teamName)),
                AREA + "/teamsettings/iterations", iterationId, "capacities/" + teamMemberId, ApiVersion.WORK_CAPACITY,
                null, body, CustomHeader.JSON_CONTENT_TYPE);
        return MAPPER.mapJsonResponse(r, TeamMemberCapacityIdentityRef.class);
    }

}
