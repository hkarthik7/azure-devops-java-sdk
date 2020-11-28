package org.azd.build.builds;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.azd.build.types.*;
import org.azd.exceptions.DefaultParametersException;
import org.azd.utils.AzDDefaultParameters;
import org.azd.utils.RequestAPI;
import org.azd.utils.ResourceId;
import org.azd.utils.Url;

import java.io.IOException;
import java.util.HashMap;

import static org.azd.validators.AzDDefaultParametersValidator.ValidateDefaultParameters;

/***
 * Build class to manage build API
 * @author Harish karthic
 */
public class Build {
    /***
     * Instance of AzDDefaultParameters
     */
    private final AzDDefaultParameters defaultParameters;
    private final ObjectMapper mapper = new ObjectMapper();

    /***
     * Instantiate the class with instance of AzDDefaultParameters
     * @param defaultParameters instance of AzDDefaultParameters
     */
    public Build(AzDDefaultParameters defaultParameters) { this.defaultParameters = defaultParameters; }

    /***
     * Deletes a build.
     * @param buildId pass the build id to delet
     * @throws DefaultParametersException -> {@link DefaultParametersException}
     */
    public void deleteBuild(int buildId) throws DefaultParametersException {

        if(defaultParameters.getProject() == null) { ValidateDefaultParameters(); }

        String buildUrl = new Url(defaultParameters).buildRequestUrl(
                ResourceId.BUILD,
                defaultParameters.getProject(),
                "build/builds",
                Integer.toString(buildId),
                null,
                BuildVersion.Version,
                null);

        RequestAPI.delete(buildUrl, defaultParameters.getPersonalAccessToken());
    }

    /***
     * Gets a build
     * @param buildId pass the build id
     * @return a build object {@link BuildT}
     * @throws DefaultParametersException -> {@link DefaultParametersException}
     * @throws IOException -> {@link IOException}
     */
    public BuildT getBuild(int buildId) throws DefaultParametersException, IOException {

        if(defaultParameters.getProject() == null) { ValidateDefaultParameters(); }

        String buildUrl = new Url(defaultParameters).buildRequestUrl(
                ResourceId.BUILD,
                defaultParameters.getProject(),
                "build/builds",
                Integer.toString(buildId),
                null,
                BuildVersion.Version,
                null);

        return mapper.readValue(RequestAPI.get(buildUrl, defaultParameters.getPersonalAccessToken()), new TypeReference<BuildT>() {});
    }

    /***
     * Gets the changes associated with a build
     * @param buildId pass the build id
     * @return the object of build changes
     * @throws DefaultParametersException -> {@link DefaultParametersException}
     * @throws IOException -> {@link IOException}
     */
    public BuildChanges getBuildChanges(int buildId) throws DefaultParametersException, IOException {

        if(defaultParameters.getProject() == null) { ValidateDefaultParameters(); }

        String buildUrl = new Url(defaultParameters).buildRequestUrl(
                ResourceId.BUILD,
                defaultParameters.getProject(),
                "build/builds",
                Integer.toString(buildId),
                "changes",
                BuildVersion.BuildChanges,
                null);

        return mapper.readValue(RequestAPI.get(buildUrl, defaultParameters.getPersonalAccessToken()), new TypeReference<BuildChanges>() {
        });
    }

    /***
     * Gets the changes associated with a build
     * @param buildId pass the build id
     * @param top The maximum number of changes to return
     * @param continuationToken pass the continuation token
     * @param includeSourceChange if set to true gets the source changes
     * @return the object of build changes
     * @throws DefaultParametersException -> {@link DefaultParametersException}
     * @throws IOException -> {@link IOException}
     */
    public BuildChanges getBuildChanges(
            int buildId, int top,  String continuationToken, boolean includeSourceChange) throws DefaultParametersException, IOException {

        if(defaultParameters.getProject() == null) { ValidateDefaultParameters(); }

        HashMap<String, Object> q = new HashMap<>() {{
            put("$top", top);
            put("continuationToken", continuationToken);
            put("includeSourceChange", includeSourceChange);
        }};

        String buildUrl = new Url(defaultParameters).buildRequestUrl(
                ResourceId.BUILD,
                defaultParameters.getProject(),
                "build/builds",
                Integer.toString(buildId),
                "changes",
                BuildVersion.BuildChanges,
                q);

        return mapper.readValue(RequestAPI.get(buildUrl, defaultParameters.getPersonalAccessToken()), new TypeReference<BuildChanges>() {});
    }

    /***
     * Gets an individual log file for a build.
     * @param buildId pass the build id
     * @param logId pass the log id
     * @return logs associated with the build for given id
     * @throws DefaultParametersException -> {@link DefaultParametersException}
     */
    public String getBuildLog(int buildId, int logId) throws DefaultParametersException {

        if(defaultParameters.getProject() == null) { ValidateDefaultParameters(); }

        String buildUrl = new Url(defaultParameters).buildRequestUrl(
                ResourceId.BUILD,
                defaultParameters.getProject(),
                "build/builds",
                Integer.toString(buildId),
                "logs/" + logId,
                BuildVersion.BuildLogs,
                null);

        return RequestAPI.get(buildUrl, defaultParameters.getPersonalAccessToken(), "text");
    }

    /***
     * Gets an individual log file for a build.
     * @param buildId pass the build id
     * @param logId pass the log id
     * @param startLine pass the line number from log which you need to fetch
     * @param endLine pass till which line number you need to fetch from the log
     * @return logs associated with the build for given id
     * @throws DefaultParametersException -> {@link DefaultParametersException}
     */
    public String getBuildLog(int buildId, int logId, long startLine, long endLine) throws DefaultParametersException {

        if(defaultParameters.getProject() == null) { ValidateDefaultParameters(); }

        HashMap<String, Object> q = new HashMap<>(){{
            put("startLine", startLine);
            put("endLine", endLine);
        }};

        String buildUrl = new Url(defaultParameters).buildRequestUrl(
                ResourceId.BUILD,
                defaultParameters.getProject(),
                "build/builds",
                Integer.toString(buildId),
                "logs/" + logId,
                BuildVersion.BuildLogs,
                q);

        return RequestAPI.get(buildUrl, defaultParameters.getPersonalAccessToken(), "text");
    }

    /***
     * Gets the logs for a build.
     * @param buildId pass the build id
     * @return the object of build logs with id. This can be used to fetch the particular log with id
     * @throws DefaultParametersException -> {@link DefaultParametersException}
     * @throws IOException -> {@link IOException}
     */
    public BuildLogs getBuildLogs(int buildId) throws DefaultParametersException, IOException {

        if(defaultParameters.getProject() == null) { ValidateDefaultParameters(); }

        String buildUrl = new Url(defaultParameters).buildRequestUrl(
                ResourceId.BUILD,
                defaultParameters.getProject(),
                "build/builds",
                Integer.toString(buildId),
                "logs",
                BuildVersion.BuildLogs,
                null);

        return mapper.readValue(RequestAPI.get(buildUrl, defaultParameters.getPersonalAccessToken()), new TypeReference<BuildLogs>() {});
    }
}
