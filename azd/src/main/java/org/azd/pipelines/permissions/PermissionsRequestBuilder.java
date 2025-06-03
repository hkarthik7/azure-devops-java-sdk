package org.azd.pipelines.permissions;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.pipelines.types.ResourcePipelinePermission;
import org.azd.pipelines.types.ResourcePipelinePermissions;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Pipelines permissions Api.
 */
public class PermissionsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public PermissionsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "pipelinepermissions", "b5b9a4a4-e6cd-4096-853c-ab7d8b0c4eb2", ApiVersion.PIPELINE_PERMISSIONS);
    }

    /**
     * Given a ResourceType and ResourceId, returns authorized definitions for that resource.
     *
     * @param resourceId Id of the resource
     * @param resourceType Type of the resource
     * @return ResourcePipelinePermissions Object {@link ResourcePipelinePermission}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<ResourcePipelinePermission> getAsync(String resourceId, String resourceType) throws AzDException {
        return builder()
                .serviceEndpoint("resourceType", resourceType)
                .serviceEndpoint("resourceId", resourceId)
                .build()
                .executeAsync(ResourcePipelinePermission.class);
    }

    /**
     * Authorizes/Unauthorizes a list of definitions for a given resource.
     *
     * @param resourceId Id of the resource
     * @param resourceType Type of the resource
     * @param resource Resource request object to authorize the request
     *                 <strong>Example:</strong>
     *                 <pre>{@code
     *                  var resource = new ResourcePipelinePermission();
     *                  var pipelinePermission = new PipelinePermission();
     *                  pipelinePermission.setAuthorized(true);
     *                  pipelinePermission.setId(16);
     *                  resource.setPipelines(List.of(pipelinePermission));
     *                 }</pre>
     * @return ResourcePipelinePermissions Object {@link ResourcePipelinePermission}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ResourcePipelinePermission> updateAsync(String resourceId, String resourceType,
                                                                     ResourcePipelinePermission resource) throws AzDException {
        return builder()
                .PATCH(resource)
                .serviceEndpoint("resourceType", resourceType)
                .serviceEndpoint("resourceId", resourceId)
                .build()
                .executeAsync(ResourcePipelinePermission.class);
    }

    /**
     * Batch requests to authorize/unauthorize a list of definitions for a multiple resources.
     *
     * @param resources Resource request object to authorize the request
     *                 <strong>Example:</strong>
     *                 <pre>{@code
     *                  var resourcePipelinePermission = new ResourcePipelinePermission();
     *                  var resourcePipelinePermission1 = new ResourcePipelinePermission();
     *
     *                  var resource = new Resource();
     *                  resource.setId("1");
     *                  resource.setName("Default");
     *                  resource.setType("queue");
     *
     *                  var resource1 = new Resource();
     *                  resource1.setId("1");
     *                  resource1.setName("SampleEnv");
     *                  resource1.setType("environment");
     *
     *                  var pipelinePermission = new PipelinePermission();
     *                  pipelinePermission.setAuthorized(true);
     *                  pipelinePermission.setId(16);
     *
     *                  resourcePipelinePermission.setResource(resource);
     *                  resourcePipelinePermission.setPipelines(List.of(pipelinePermission));
     *
     *                  resourcePipelinePermission1.setResource(resource1);
     *                  resourcePipelinePermission1.setPipelines(List.of(pipelinePermission));
     *                 }</pre>
     * @return ResourcePipelinePermissions Object {@link ResourcePipelinePermission}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ResourcePipelinePermissions> updateAsync(List<ResourcePipelinePermission> resources) throws AzDException {
        return builder()
                .PATCH(resources)
                .build()
                .executeAsync(ResourcePipelinePermissions.class);
    }

    /**
     * Given a ResourceType and ResourceId, returns authorized definitions for that resource.
     *
     * @param resourceId Id of the resource
     * @param resourceType Type of the resource
     * @return ResourcePipelinePermissions Object {@link ResourcePipelinePermission}
     * @throws AzDException Default Api Exception handler.
     **/
    public ResourcePipelinePermission get(String resourceId, String resourceType) throws AzDException {
        return builder()
                .serviceEndpoint("resourceType", resourceType)
                .serviceEndpoint("resourceId", resourceId)
                .build()
                .execute(ResourcePipelinePermission.class);
    }

    /**
     * Authorizes/Unauthorizes a list of definitions for a given resource.
     *
     * @param resourceId Id of the resource
     * @param resourceType Type of the resource
     * @param resource Resource request object to authorize the request
     *                 <strong>Example:</strong>
     *                 <pre>{@code
     *                  var resource = new ResourcePipelinePermission();
     *                  var pipelinePermission = new PipelinePermission();
     *                  pipelinePermission.setAuthorized(true);
     *                  pipelinePermission.setId(16);
     *                  resource.setPipelines(List.of(pipelinePermission));
     *                 }</pre>
     * @return ResourcePipelinePermissions Object {@link ResourcePipelinePermission}
     * @throws AzDException Default Api Exception handler.
     */
    public ResourcePipelinePermission update(String resourceId, String resourceType,
                                             ResourcePipelinePermission resource) throws AzDException {
        return builder()
                .PATCH(resource)
                .serviceEndpoint("resourceType", resourceType)
                .serviceEndpoint("resourceId", resourceId)
                .build()
                .execute(ResourcePipelinePermission.class);
    }

    /**
     * Batch requests to authorize/unauthorize a list of definitions for a multiple resources.
     *
     * @param resources Resource request object to authorize the request
     *                 <strong>Example:</strong>
     *                 <pre>{@code
     *                  var resourcePipelinePermission = new ResourcePipelinePermission();
     *                  var resourcePipelinePermission1 = new ResourcePipelinePermission();
     *
     *                  var resource = new Resource();
     *                  resource.setId("1");
     *                  resource.setName("Default");
     *                  resource.setType("queue");
     *
     *                  var resource1 = new Resource();
     *                  resource1.setId("1");
     *                  resource1.setName("SampleEnv");
     *                  resource1.setType("environment");
     *
     *                  var pipelinePermission = new PipelinePermission();
     *                  pipelinePermission.setAuthorized(true);
     *                  pipelinePermission.setId(16);
     *
     *                  resourcePipelinePermission.setResource(resource);
     *                  resourcePipelinePermission.setPipelines(List.of(pipelinePermission));
     *
     *                  resourcePipelinePermission1.setResource(resource1);
     *                  resourcePipelinePermission1.setPipelines(List.of(pipelinePermission));
     *                 }</pre>
     * @return ResourcePipelinePermissions Object {@link ResourcePipelinePermission}
     * @throws AzDException Default Api Exception handler.
     */
    public ResourcePipelinePermissions update(List<ResourcePipelinePermission> resources) throws AzDException {
        return builder()
                .PATCH(resources)
                .build()
                .execute(ResourcePipelinePermissions.class);
    }
}
