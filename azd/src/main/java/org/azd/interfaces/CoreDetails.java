package org.azd.interfaces;

import org.azd.core.types.*;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;

import java.util.HashMap;

public interface CoreDetails {
    Processes getProcesses() throws ConnectionException, AzDException;

    OperationReference createProject(String projectName, String description) throws ConnectionException, AzDException;

    OperationReference createProject(String projectName, String description, String sourceControlType,
                      String templateTypeId) throws ConnectionException, AzDException;

    OperationReference deleteProject(String projectId) throws ConnectionException, AzDException;

    Project getProject(String projectName) throws ConnectionException, AzDException;

    Project getProject(String projectName, boolean includeCapabilities, boolean includeHistory) throws ConnectionException, AzDException;

    ProjectProperties getProjectProperties(String projectId) throws ConnectionException, AzDException;

    Projects getProjects() throws ConnectionException, AzDException;

    Projects getProjects(int skip, int top, String continuationToken,
                         boolean getDefaultTeamImageUrl, String stateFilter) throws ConnectionException, AzDException;

    OperationReference updateProject(String projectId, HashMap<String, Object> projectParameters) throws ConnectionException, AzDException;

    WebApiTeam createTeam(String projectName, String teamName) throws ConnectionException, AzDException;

    void deleteTeam(String projectName, String teamName) throws ConnectionException, AzDException;

    Team getTeam(String projectName, String teamName) throws ConnectionException, AzDException;

    Team getTeam(String projectName, String teamName, boolean expandIdentity) throws ConnectionException, AzDException;

    Teams getTeams() throws ConnectionException, AzDException;

    Teams getTeams(boolean expandIdentity, String mine, int skip, int top) throws ConnectionException, AzDException;

    Team updateTeams(String projectName, String teamName, String description) throws ConnectionException, AzDException;
}
