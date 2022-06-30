package org.azd.interfaces;

import org.azd.enums.IterationsTimeFrame;
import org.azd.exceptions.AzDException;
import org.azd.work.types.IterationWorkItems;
import org.azd.work.types.TeamSettingsIteration;
import org.azd.work.types.TeamSettingsIterations;


public interface WorkDetails {
    TeamSettingsIterations getTeamSettingsIterations(String teamName) throws AzDException;

    TeamSettingsIterations getTeamSettingsIterations(String teamName, IterationsTimeFrame timeFrame) throws AzDException;

    IterationWorkItems getTeamIterationWorkItems(String teamName, String iterationId) throws AzDException;

    TeamSettingsIteration getTeamSettingsIteration(String teamName, String iterationId) throws AzDException;

    Void deleteTeamSettingsIteration(String teamName, String iterationId) throws AzDException;
}
