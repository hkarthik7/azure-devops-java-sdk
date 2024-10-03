package org.azd.helpers.build;

import org.azd.authentication.AccessTokenCredential;
import org.azd.build.BuildBaseRequestBuilder;
import org.azd.build.types.BuildDefinition;
import org.azd.exceptions.AzDException;

/**
 * Helper request builder that combines multiple Apis to create logical helper methods for ease of use.
 */
public class BuildHelpersRequestBuilder extends BuildBaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public BuildHelpersRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * Clone an existing definition/pipeline
     *
     * @param definitionName      Name of the build definition/pipeline. E.g., WebApp-Deployment-CI
     * @param definitionCloneName Name of the pipeline/definition to be created or cloned. E.g., WebApp-Deployment-CI-Copy
     * @return build definition {@link BuildDefinition}
     * @throws AzDException Default Api Exception handler.
     */
    public BuildDefinition cloneBuildDefinition(String definitionName, String definitionCloneName) throws AzDException {
        // validate if the definition exists
        int def;

        try {
            def = definitions().list()
                    .getBuildDefinitions()
                    .stream()
                    .filter(x -> x.getName().equals(definitionName))
                    .findFirst()
                    .get()
                    .getId();
        } catch (Exception e) {
            throw new AzDException("Cannot find the definition with name '" + definitionName + "'.");
        }

        if (!Integer.toString(def).isEmpty()) {
            var definitionObject = definitions().get(def);
            definitionObject.setName(definitionCloneName);
            return definitions().create(definitionObject, r -> r.definitionQueryParameters.definitionToCloneId = def);
        }

        return null;
    }
}
