package org.azd.interfaces;

import org.azd.core.types.*;
import org.azd.enums.FeatureManagement;
import org.azd.exceptions.AzDException;

import java.util.Optional;

public interface CoreDetails {
    Processes getProcesses() throws AzDException;

    OperationReference createProject(String projectName, String description) throws AzDException;

    OperationReference createProject(String projectName, String description, String sourceControlType,
                                     String templateTypeId) throws AzDException;

    OperationReference deleteProject(String projectId) throws AzDException;

    Project getProject(String projectName) throws AzDException;

    Project getProject(String projectName, boolean includeCapabilities, boolean includeHistory) throws AzDException;

    ProjectProperties getProjectProperties(String projectId) throws AzDException;

    Projects getProjects() throws AzDException;

    Projects getProjects(int skip, int top, String continuationToken,
                         boolean getDefaultTeamImageUrl, String stateFilter) throws AzDException;

    OperationReference updateProject(String projectId, Project projectParameters) throws AzDException;

    WebApiTeam createTeam(String projectName, String teamName) throws AzDException;

    Void deleteTeam(String projectName, String teamName) throws AzDException;

    Team getTeam(String projectName, String teamName) throws AzDException;

    Team getTeam(String projectName, String teamName, boolean expandIdentity) throws AzDException;

    Teams getTeams() throws AzDException;

    Teams getTeams(boolean expandIdentity, String mine, int skip, int top) throws AzDException;

    Team updateTeams(String projectName, String teamName, String description) throws AzDException;

    Optional<Boolean> getFeatureState(String projectId, FeatureManagement feature) throws AzDException;

    ProjectFeature featureToggle(String projectId, FeatureManagement feature, boolean state) throws AzDException;
}
