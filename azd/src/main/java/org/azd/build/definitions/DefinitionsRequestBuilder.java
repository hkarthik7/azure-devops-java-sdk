package org.azd.build.definitions;

import org.azd.build.types.BuildDefinition;
import org.azd.common.ApiVersion;
import org.azd.common.types.QueryParameter;
import org.azd.exceptions.AzDException;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class DefinitionsRequestBuilder extends BaseRequestBuilder {
    public DefinitionsRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "build/definitions", ApiVersion.BUILD_DEFINITIONS);
    }

    public CompletableFuture<BuildDefinition> create(BuildDefinition buildDefinition,
                                                     Consumer<DefinitionRequestConfiguration> definitionRequestConfiguration) throws AzDException {
        var reqInfo = toPostRequestInformation(buildDefinition);
        if (definitionRequestConfiguration != null) {
            final var config = new DefinitionRequestConfiguration();
            definitionRequestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.definitionQueryParameters);
        }

        return requestAdapter.sendAsync(reqInfo, BuildDefinition.class);
    }

    public static class DefinitionQueryParameters {
        @QueryParameter(name = "definitionToCloneId")
        public int definitionToCloneId;
        @QueryParameter(name = "definitionToCloneRevision")
        public int definitionToCloneRevision;
    }

    public static class DefinitionRequestConfiguration {
        public DefinitionQueryParameters definitionQueryParameters = new DefinitionQueryParameters();
    }
}
