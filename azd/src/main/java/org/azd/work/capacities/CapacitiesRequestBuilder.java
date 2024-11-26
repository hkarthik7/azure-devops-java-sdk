package org.azd.work.capacities;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.helpers.URLHelper;
import org.azd.work.types.TeamCapacity;
import org.azd.work.types.TeamMemberCapacityIdentityRef;
import org.azd.work.types.TeamMemberCapacityIdentityRefs;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Work capacities Api.
 */
public class CapacitiesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public CapacitiesRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "work", "74412d15-8c1a-4352-a48d-ef1ed5587d57", ApiVersion.WORK_CAPACITY);
    }

    /**
     * Get a team's capacity including total capacity and days off
     *
     * @param iterationId Pass the iteration id.
     * @param team        The name of the Azure DevOps organization.
     * @return TeamCapacity Object {@link TeamCapacity}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<TeamCapacity> getAsync(String iterationId, String team) throws AzDException {
        return builder()
                .serviceEndpoint("iterationId", iterationId)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .build()
                .executeAsync(TeamCapacity.class);
    }

    /**
     * Get a team member's capacity
     *
     * @param iterationId  Pass the team iteration id.
     * @param teamMemberId Id of the team member.
     * @param team         Name of Azure DevOps team.
     * @return TeamMemberCapacityIdentityRef Object {@link TeamMemberCapacityIdentityRef}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<TeamMemberCapacityIdentityRef> getAsync(String iterationId, String teamMemberId, String team)
            throws AzDException {
        return builder()
                .serviceEndpoint("iterationId", iterationId)
                .serviceEndpoint("teamMemberId", teamMemberId)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .build()
                .executeAsync(TeamMemberCapacityIdentityRef.class);
    }

    /**
     * Replace a team's capacity
     *
     * @param iterationId                    Pass the team iteration id.
     * @param team                           Name or id of the Azure DevOps team.
     * @param teamMemberCapacityIdentityRefs A list of team members capacity to update.
     * @return Collection of TeamMemberCapacityIdentityRef Object {@link TeamMemberCapacityIdentityRefs}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<TeamMemberCapacityIdentityRefs> replaceAsync(String iterationId, String team,
                                                                          List<TeamMemberCapacityIdentityRef> teamMemberCapacityIdentityRefs)
            throws AzDException {
        return builder()
                .PUT(teamMemberCapacityIdentityRefs)
                .serviceEndpoint("iterationId", iterationId)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .build()
                .executeAsync(TeamMemberCapacityIdentityRefs.class);
    }

    /**
     * Update a team member's capacity
     *
     * @param iterationId                   Pass the team iteration id.
     * @param teamMemberId                  Id of the team member.
     * @param team                          Name of id of the Azure DevOps team.
     * @param teamMemberCapacityIdentityRef Team member capacity object to update.
     *                                      You can only pass the list of activities and optionally days off.
     * @return TeamMemberCapacityIdentityRef Object {@link TeamMemberCapacityIdentityRef}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<TeamMemberCapacityIdentityRef> updateAsync(String iterationId, String team, String teamMemberId,
                                                                        TeamMemberCapacityIdentityRef teamMemberCapacityIdentityRef)
            throws AzDException {
        return builder()
                .PATCH(teamMemberCapacityIdentityRef)
                .serviceEndpoint("iterationId", iterationId)
                .serviceEndpoint("teamMemberId", teamMemberId)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .build()
                .executeAsync(TeamMemberCapacityIdentityRef.class);
    }

    /**
     * Get a team's capacity including total capacity and days off
     *
     * @param iterationId Pass the iteration id.
     * @param team        The name of the Azure DevOps organization.
     * @return TeamCapacity Object {@link TeamCapacity}
     * @throws AzDException Default Api Exception handler.
     **/
    public TeamCapacity get(String iterationId, String team) throws AzDException {
        return builder()
                .serviceEndpoint("iterationId", iterationId)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .build()
                .execute(TeamCapacity.class);
    }

    /**
     * Get a team member's capacity
     *
     * @param iterationId  Pass the team iteration id.
     * @param teamMemberId Id of the team member.
     * @param team         Name of Azure DevOps team.
     * @return TeamMemberCapacityIdentityRef Object {@link TeamMemberCapacityIdentityRef}
     * @throws AzDException Default Api Exception handler.
     **/
    public TeamMemberCapacityIdentityRef get(String iterationId, String teamMemberId, String team)
            throws AzDException {
        return builder()
                .serviceEndpoint("iterationId", iterationId)
                .serviceEndpoint("teamMemberId", teamMemberId)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .build()
                .execute(TeamMemberCapacityIdentityRef.class);
    }

    /**
     * Replace a team's capacity
     *
     * @param iterationId                    Pass the team iteration id.
     * @param team                           Name or id of the Azure DevOps team.
     * @param teamMemberCapacityIdentityRefs A list of team members capacity to update.
     * @return Collection of TeamMemberCapacityIdentityRef Object {@link TeamMemberCapacityIdentityRefs}
     * @throws AzDException Default Api Exception handler.
     **/
    public TeamMemberCapacityIdentityRefs replace(String iterationId, String team,
                                                  List<TeamMemberCapacityIdentityRef> teamMemberCapacityIdentityRefs)
            throws AzDException {
        return builder()
                .PUT(teamMemberCapacityIdentityRefs)
                .serviceEndpoint("iterationId", iterationId)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .build()
                .execute(TeamMemberCapacityIdentityRefs.class);
    }

    /**
     * Update a team member's capacity
     *
     * @param iterationId                   Pass the team iteration id.
     * @param teamMemberId                  Id of the team member.
     * @param team                          Name of id of the Azure DevOps team.
     * @param teamMemberCapacityIdentityRef Team member capacity object to update.
     *                                      You can only pass the list of activities and optionally days off.
     * @return TeamMemberCapacityIdentityRef Object {@link TeamMemberCapacityIdentityRef}
     * @throws AzDException Default Api Exception handler.
     **/
    public TeamMemberCapacityIdentityRef update(String iterationId, String team, String teamMemberId,
                                                TeamMemberCapacityIdentityRef teamMemberCapacityIdentityRef)
            throws AzDException {
        return builder()
                .PATCH(teamMemberCapacityIdentityRef)
                .serviceEndpoint("iterationId", iterationId)
                .serviceEndpoint("teamMemberId", teamMemberId)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .build()
                .execute(TeamMemberCapacityIdentityRef.class);
    }
}
