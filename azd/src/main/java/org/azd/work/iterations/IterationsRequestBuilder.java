package org.azd.work.iterations;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.IterationsTimeFrame;
import org.azd.exceptions.AzDException;
import org.azd.helpers.URLHelper;
import org.azd.work.types.IterationWorkItems;
import org.azd.work.types.TeamSettingsIteration;
import org.azd.work.types.TeamSettingsIterations;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Work iterations Api.
 */
public class IterationsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public IterationsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "work", "c9175577-28a1-4b06-9197-8636af9f64ad", ApiVersion.WORK);
    }

    /**
     * Delete a team's iteration by iterationId
     *
     * @param team Team ID or team name
     * @param id   ID of the iteration
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(String id, String team) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("id", id)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get team's iteration by iterationId
     *
     * @param team ID of the iteration
     * @param id   Team ID or team name
     * @return TeamSettingsIteration object {@link TeamSettingsIteration}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<TeamSettingsIteration> getAsync(String id, String team) throws AzDException {
        return builder()
                .serviceEndpoint("id", id)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .build()
                .executeAsync(TeamSettingsIteration.class);
    }

    /**
     * Get work items for iteration
     *
     * @param team        Team ID or team name
     * @param iterationId ID of the iteration
     * @return Collection of iteration work items {@link IterationWorkItems}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<IterationWorkItems> getWorkItemsAsync(String iterationId, String team) throws AzDException {
        return builder()
                .location("5b3ef1a6-d3ab-44cd-bafd-c7f45db850fa")
                .serviceEndpoint("iterationId", iterationId)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .build()
                .executeAsync(IterationWorkItems.class);
    }

    /**
     * Get a team's iterations using timeframe filter
     *
     * @param team Team ID or team name
     * @return Collection of TeamSettingsIteration object {@link TeamSettingsIterations}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<TeamSettingsIterations> listAsync(String team) throws AzDException {
        return builder()
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .build()
                .executeAsync(TeamSettingsIterations.class);
    }

    /**
     * Get a team's iterations using timeframe filter
     *
     * @param team      Team ID or team name
     * @param timeFrame A filter for which iterations are returned based on relative time.
     *                  Only 'Current' is supported currently. {@link IterationsTimeFrame}
     * @return Collection of TeamSettingsIteration object {@link TeamSettingsIterations}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<TeamSettingsIterations> listAsync(String team, IterationsTimeFrame timeFrame) throws AzDException {
        return builder()
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .query("$timeframe", timeFrame.toString().toLowerCase())
                .build()
                .executeAsync(TeamSettingsIterations.class);
    }

    /**
     * Add an iteration to the team
     *
     * @param team                  Team ID or team name
     * @param teamSettingsIteration Team settings iteration object to add iteration to the team.
     * @return TeamSettingsIteration object {@link TeamSettingsIteration}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<TeamSettingsIteration> postAsync(String team, TeamSettingsIteration teamSettingsIteration)
            throws AzDException {
        return builder()
                .POST(teamSettingsIteration)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .build()
                .executeAsync(TeamSettingsIteration.class);
    }

    /**
     * Delete a team's iteration by iterationId
     *
     * @param team Team ID or team name
     * @param id   ID of the iteration
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(String id, String team) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("id", id)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .build()
                .executePrimitive();
    }

    /**
     * Get team's iteration by iterationId
     *
     * @param team ID of the iteration
     * @param id   Team ID or team name
     * @return TeamSettingsIteration object {@link TeamSettingsIteration}
     * @throws AzDException Default Api Exception handler.
     */
    public TeamSettingsIteration get(String id, String team) throws AzDException {
        return builder()
                .serviceEndpoint("id", id)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .build()
                .execute(TeamSettingsIteration.class);
    }

    /**
     * Get work items for iteration
     *
     * @param team        Team ID or team name
     * @param iterationId ID of the iteration
     * @return Collection of iteration work items {@link IterationWorkItems}
     * @throws AzDException Default Api Exception handler.
     */
    public IterationWorkItems getWorkItems(String iterationId, String team) throws AzDException {
        return builder()
                .location("5b3ef1a6-d3ab-44cd-bafd-c7f45db850fa")
                .serviceEndpoint("iterationId", iterationId)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .build()
                .execute(IterationWorkItems.class);
    }

    /**
     * Get a team's iterations using timeframe filter
     *
     * @param team Team ID or team name
     * @return Collection of TeamSettingsIteration object {@link TeamSettingsIterations}
     * @throws AzDException Default Api Exception handler.
     */
    public TeamSettingsIterations list(String team) throws AzDException {
        return builder()
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .build()
                .execute(TeamSettingsIterations.class);
    }

    /**
     * Get a team's iterations using timeframe filter
     *
     * @param team      Team ID or team name
     * @param timeFrame A filter for which iterations are returned based on relative time.
     *                  Only 'Current' is supported currently. {@link IterationsTimeFrame}
     * @return Collection of TeamSettingsIteration object {@link TeamSettingsIterations}
     * @throws AzDException Default Api Exception handler.
     */
    public TeamSettingsIterations list(String team, IterationsTimeFrame timeFrame) throws AzDException {
        return builder()
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .query("$timeframe", timeFrame.toString().toLowerCase())
                .build()
                .execute(TeamSettingsIterations.class);
    }

    /**
     * Add an iteration to the team
     *
     * @param team                  Team ID or team name
     * @param teamSettingsIteration Team settings iteration object to add iteration to the team.
     * @return TeamSettingsIteration object {@link TeamSettingsIteration}
     * @throws AzDException Default Api Exception handler.
     */
    public TeamSettingsIteration post(String team, TeamSettingsIteration teamSettingsIteration)
            throws AzDException {
        return builder()
                .POST(teamSettingsIteration)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .build()
                .execute(TeamSettingsIteration.class);
    }
}
