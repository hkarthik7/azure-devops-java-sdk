package org.azd.interfaces;

import org.azd.enums.IterationsTimeFrame;
import org.azd.exceptions.AzDException;
import org.azd.work.types.*;

import java.util.List;


public interface WorkDetails {
    TeamSettingsIterations getTeamSettingsIterations(String teamName) throws AzDException;

    TeamSettingsIterations getTeamSettingsIterations(String teamName, IterationsTimeFrame timeFrame) throws AzDException;

    IterationWorkItems getTeamIterationWorkItems(String teamName, String iterationId) throws AzDException;

    TeamSettingsIteration getTeamSettingsIteration(String teamName, String iterationId) throws AzDException;

    Void deleteTeamSettingsIteration(String teamName, String iterationId) throws AzDException;
    TeamCapacity getTotalTeamCapacity(String iterationId, String teamName) throws AzDException;
    TeamMemberCapacityIdentityRef getTeamMemberCapacity(String iterationId, String teamName, String teamMemberId)
            throws AzDException;
    TeamMemberCapacityIdentityRefs updateTeamMembersCapacity(String iterationId, String teamName,
        List<TeamMemberCapacityIdentityRef> teamMembersCapacity) throws AzDException;
    TeamMemberCapacityIdentityRef updateTeamMemberCapacity(String iterationId, String teamName, String teamMemberId,
        TeamMemberCapacityIdentityRef teamMemberCapacity) throws AzDException;
}
