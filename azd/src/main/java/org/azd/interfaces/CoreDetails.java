package org.azd.interfaces;

import org.azd.core.types.*;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;

import java.util.HashMap;
import java.util.Map;

public interface CoreDetails {
    Processes getProcesses() throws DefaultParametersException, AzDException;

    Map createProject(String projectName, String description) throws DefaultParametersException, AzDException;

    Map createProject(String projectName, String description, String sourceControlType,
                      String templateTypeId) throws DefaultParametersException, AzDException;

    Map deleteProject(String projectId) throws DefaultParametersException, AzDException;

    Project getProject(String projectName) throws DefaultParametersException, AzDException;

    Project getProject(String projectName, boolean includeCapabilities, boolean includeHistory) throws DefaultParametersException, AzDException;

    ProjectProperties getProjectProperties(String projectId) throws DefaultParametersException, AzDException;

    Projects getProjects() throws DefaultParametersException, AzDException;

    Projects getProjects(int skip, int top, String continuationToken,
                         boolean getDefaultTeamImageUrl, String stateFilter) throws DefaultParametersException, AzDException;

    Map updateProject(String projectId, HashMap<String, Object> projectParameters) throws DefaultParametersException, AzDException;

    Map createTeam(String projectName, String teamName) throws DefaultParametersException, AzDException;

    void deleteTeam(String projectName, String teamName) throws DefaultParametersException, AzDException;

    Team getTeam(String projectName, String teamName) throws DefaultParametersException, AzDException;

    Team getTeam(String projectName, String teamName, boolean expandIdentity) throws DefaultParametersException, AzDException;

    Teams getTeams() throws DefaultParametersException, AzDException;

    Teams getTeams(boolean expandIdentity, String mine, int skip, int top) throws DefaultParametersException, AzDException;

    Team updateTeams(String projectName, String teamName, String description) throws DefaultParametersException, AzDException;
}
