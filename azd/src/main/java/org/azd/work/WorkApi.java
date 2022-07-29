package org.azd.work;

import org.azd.common.ApiVersion;
import org.azd.connection.Connection;
import org.azd.enums.IterationsTimeFrame;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.WorkDetails;
import org.azd.utils.AzDAsyncApi;
import org.azd.work.types.IterationWorkItems;
import org.azd.work.types.TeamSettingsIteration;
import org.azd.work.types.TeamSettingsIterations;

import java.util.HashMap;
import java.util.Map;

import static org.azd.helpers.URLHelper.encodeSpace;
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

}
